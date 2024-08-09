package com.bigarson.service.impl;

import com.bigarson.model.dto.PlanDTO;
import com.bigarson.model.entity.Plan;
import com.bigarson.model.exception.PlanAlreadyExist;
import com.bigarson.model.exception.PlanNotFound;
import com.bigarson.repository.PlanRepository;
import com.bigarson.service.contract.PlanService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {
    private final PlanRepository planRepository;
    private final ModelMapper modelMapper;

    @Override
    public PlanDTO create(PlanDTO planDTO) {
        Optional<Plan> planOptional = planRepository.findByName(planDTO.getName());
        if (planOptional.isPresent()) {
            throw new PlanAlreadyExist();
        }
        planDTO.setId(null);
        Plan plan = modelMapper.map(planDTO, Plan.class);
        plan = planRepository.save(plan);
        return modelMapper.map(plan, PlanDTO.class);
    }

    @Override
    public PlanDTO update(PlanDTO planDTO) {
        planRepository.findById(planDTO.getId()).orElseThrow(PlanNotFound::new);
        Plan plan = modelMapper.map(planDTO, Plan.class);
        return modelMapper.map(plan, PlanDTO.class);
    }

    @Override
    public PlanDTO getById(UUID id) {
        Plan plan = planRepository.findById(id).orElseThrow(PlanNotFound::new);
        return modelMapper.map(plan, PlanDTO.class);
    }

    @Override
    public PlanDTO getByName(String planName) {
        Plan plan = planRepository.findByName(planName).orElseThrow(PlanNotFound::new);
        return modelMapper.map(plan, PlanDTO.class);
    }

    @Override
    public PlanDTO getFreePlan() {
        Plan plan = planRepository.findByName("FREE").orElseThrow(PlanNotFound::new);
        return modelMapper.map(plan, PlanDTO.class);
    }

    @Override
    public List<PlanDTO> getAll() {
        List<Plan> plans = planRepository.findAll();
        List<PlanDTO> planDTOs = new ArrayList<>();
        for (Plan plan : plans) {
            planDTOs.add(modelMapper.map(plan, PlanDTO.class));
        }
        return planDTOs;
    }

    @Override
    public void deletePlan(UUID planId) {
        planRepository.deleteById(planId);
    }


}
