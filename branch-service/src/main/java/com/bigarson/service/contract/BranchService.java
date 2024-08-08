package com.bigarson.service.contract;


import com.bigarson.model.dto.BranchDTO;
import com.bigarson.model.dto.BranchUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface BranchService {

    BranchDTO getBranchByBranchId(UUID branchId);
    BranchDTO create(BranchDTO branchDTO);
    BranchDTO update(BranchUpdateDTO branchUpdateDTO);
    List<BranchDTO> getBranchList();
    void delete(UUID branchId);
}
