package com.bigarson.service.contract;

import com.bigarson.model.dto.WorkingTimeDTO;

import java.util.UUID;

public interface WorkingTimeService {

    WorkingTimeDTO createWorkingTime(UUID branchId, WorkingTimeDTO workingTimeDTO);

    WorkingTimeDTO getWorkingTimeByBranchId(UUID branchId);

    WorkingTimeDTO updateWorkingTime(UUID branchId, WorkingTimeDTO workingTimeDTO);
}
