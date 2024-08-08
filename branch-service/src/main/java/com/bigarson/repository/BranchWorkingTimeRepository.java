package com.bigarson.repository;

import com.bigarson.model.entity.BranchWorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BranchWorkingTimeRepository extends JpaRepository<BranchWorkingTime, UUID> {
    Optional<BranchWorkingTime> findByBranchId(UUID branchId);
}
