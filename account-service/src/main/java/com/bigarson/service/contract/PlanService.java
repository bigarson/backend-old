package com.bigarson.service.contract;

import com.bigarson.model.dto.PlanDTO;

import java.util.List;
import java.util.UUID;

public interface PlanService {
    PlanDTO create(PlanDTO planDTO);
    PlanDTO update(PlanDTO planDTO);
    PlanDTO getById(UUID id);
    PlanDTO getByName(String planName);
    PlanDTO getFreePlan();
    List<PlanDTO> getAll();

    void deletePlan(UUID planId);
}
