package com.bigarson.service.contract;


import com.bigarson.model.dto.BranchDTO;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

public interface BranchService {

    BranchDTO getBranchByBranchId(UUID branchId);
    BranchDTO create(UUID userId,BranchDTO branchDTO);
    BranchDTO update(UUID userId,BranchDTO branchUpdateDTO);
    List<BranchDTO> getBranchList(UUID userId);
    void delete(UUID userId,UUID branchId);
}
