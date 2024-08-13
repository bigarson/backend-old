package com.bigarson.service.impl;

import com.bigarson.helper.contract.ImageHelper;
import com.bigarson.model.dto.AccountDTO;
import com.bigarson.model.dto.BranchDTO;
import com.bigarson.model.dto.WorkingTimeDTO;
import com.bigarson.model.entity.Branch;
import com.bigarson.model.entity.BranchWorkingTime;
import com.bigarson.model.exception.BranchLimitException;
import com.bigarson.model.exception.BranchNotFoundException;
import com.bigarson.repository.BranchRepository;
import com.bigarson.repository.BranchWorkingTimeRepository;
import com.bigarson.service.contract.AccountService;
import com.bigarson.service.contract.BranchService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final AccountService accountService;
    private final ModelMapper modelMapper;
    private final BranchWorkingTimeRepository workingTimeRepository;
    private final ImageHelper imageHelper;

    @Override
    public BranchDTO getBranchByBranchId(UUID branchId) {
        Branch branch = branchRepository.findById(branchId).orElseThrow(BranchNotFoundException::new);
        return branchToBranchDto(branch);
    }

    @Override
    public BranchDTO create(UUID userId, BranchDTO branchDTO) {
        UUID accountId = getAccountIdFromAccountService(userId);
        int accountMaxBranch = 1;
        if (branchRepository.countAllByAccountId(accountId) >= accountMaxBranch) {
            throw new BranchLimitException();
        }
        Branch branch = modelMapper.map(branchDTO, Branch.class);
        branch.setAccountId(accountId);
        branch = branchRepository.save(branch);
        if (!Objects.equals(null,branchDTO.getBranchImage())) {
            String imageUrl = imageHelper.upload(branchDTO.getBranchImage(), branch.getId());
            branch.setImageUrl(imageUrl);
            branch = branchRepository.save(branch);
        }
        if (!Objects.equals(branchDTO.getWorkingTime(), null)) {
            BranchWorkingTime branchWorkingTime = modelMapper.map(branchDTO.getWorkingTime(), BranchWorkingTime.class);
            branchWorkingTime.setBranch(branch);
            workingTimeRepository.save(branchWorkingTime);
        }
        return branchToBranchDto(branch);
    }

    @Override
    public BranchDTO update(UUID userId, BranchDTO branchUpdateDTO) {
        UUID accountId = getAccountIdFromAccountService(userId);
        Branch branch = branchRepository.findByAccountIdAndId(accountId, branchUpdateDTO.getId()).orElseThrow(BranchNotFoundException::new);
        branch = modelMapper.map(branchUpdateDTO, Branch.class);
        branch.setAccountId(accountId);
        branch = branchRepository.save(branch);
        if (!Objects.equals(branchUpdateDTO.getWorkingTime(), null)) {
            BranchWorkingTime branchWorkingTime = workingTimeRepository.findByBranchId(branch.getId()).orElseThrow(WrongThreadException::new);
            workingTimeRepository.save(branchWorkingTime);
        }
        return modelMapper.map(branch, BranchDTO.class);
    }

    @Override
    public List<BranchDTO> getBranchList(UUID userId) {
        UUID accountId = getAccountIdFromAccountService(userId);
        List<Branch> branches = branchRepository.findAllByAccountIdAndDeletedTimeIsNull(accountId);
        List<BranchDTO> branchDTOS = new ArrayList<>();
        for (Branch branch : branches) {
            BranchWorkingTime workingTime = workingTimeRepository.findByBranchId(branch.getId()).orElseThrow(WrongThreadException::new);
            BranchDTO dto = modelMapper.map(branch, BranchDTO.class);
            dto.setWorkingTime(modelMapper.map(workingTime, WorkingTimeDTO.class));
            branchDTOS.add(dto);
        }
        return branchDTOS;
    }

    @Override
    public void delete(UUID userId, UUID branchId) {
        UUID accountId = getAccountIdFromAccountService(userId);
        branchRepository.disableByAccountIdAndId(accountId, branchId);
    }

    private UUID getAccountIdFromAccountService(UUID userId) {
        AccountDTO accountDTO = accountService.getAccountByUserId(userId);
        return accountDTO.getId();
    }

    private BranchDTO branchToBranchDto(Branch branch) {
        BranchWorkingTime workingTime = workingTimeRepository.findByBranchId(branch.getId()).orElseThrow(BranchNotFoundException::new);
        BranchDTO branchDTO = modelMapper.map(branch, BranchDTO.class);
        branchDTO.setWorkingTime(modelMapper.map(workingTime, WorkingTimeDTO.class));
        return branchDTO;
    }
}
