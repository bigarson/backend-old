package com.bigarson.service.contract;


import com.bigarson.model.dto.BranchDTO;
import com.bigarson.model.dto.BranchUpdateDTO;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

public interface BranchService {

    BranchDTO getBranchByBranchId(UUID branchId);
    BranchDTO create(Principal principal,BranchDTO branchDTO);
    BranchDTO update(Principal principal,BranchUpdateDTO branchUpdateDTO);
    List<BranchDTO> getBranchList(Principal principal);
    void delete(Principal principal,UUID branchId);
}
