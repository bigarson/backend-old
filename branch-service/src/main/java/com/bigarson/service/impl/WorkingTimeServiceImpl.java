package com.bigarson.service.impl;

import com.bigarson.model.dto.WorkingTimeDTO;
import com.bigarson.model.entity.BranchWorkingTime;
import com.bigarson.model.exception.WorkTimeNotFoundException;
import com.bigarson.model.exception.WorkingTimeAlreadyExistException;
import com.bigarson.repository.BranchWorkingTimeRepository;
import com.bigarson.service.contract.WorkingTimeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkingTimeServiceImpl implements WorkingTimeService {

    BranchWorkingTimeRepository workingTimeRepository;
    ModelMapper modelMapper;

    @Override
    public WorkingTimeDTO createWorkingTime(UUID branchId, WorkingTimeDTO workingTimeDTO) {
        if (workingTimeRepository.existsById(branchId)) {
            throw new WorkingTimeAlreadyExistException();
        }
        workingTimeDTO.setBranchId(branchId);
        BranchWorkingTime workingTime = modelMapper.map(workingTimeDTO, BranchWorkingTime.class);
        workingTime = workingTimeRepository.save(workingTime);
        return modelMapper.map(workingTime, WorkingTimeDTO.class);
    }

    @Override
    public WorkingTimeDTO getWorkingTimeByBranchId(UUID branchId) {
        BranchWorkingTime workingTime = workingTimeRepository.findByBranchId(branchId).orElseThrow(WorkTimeNotFoundException::new);
        return modelMapper.map(workingTime, WorkingTimeDTO.class);
    }

    @Override
    public WorkingTimeDTO updateWorkingTime(UUID branchId, WorkingTimeDTO workingTimeDTO) {
        BranchWorkingTime workingTime = workingTimeRepository.findById(branchId).orElseThrow(WorkTimeNotFoundException::new);
        modelMapper.map(workingTimeDTO, workingTime);
        workingTime = workingTimeRepository.save(workingTime);
        return modelMapper.map(workingTime, WorkingTimeDTO.class);
    }
}
