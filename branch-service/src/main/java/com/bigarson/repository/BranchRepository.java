package com.bigarson.repository;

import com.bigarson.model.entity.Branch;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BranchRepository extends JpaRepository<Branch, UUID> {
    List<Branch> findAllByAccountIdAndDeletedTimeIsNull(UUID accountId);
    @Query(value = "select count(1) from Branch where accountId = :accountId and deletedTime is null")
    Integer countAllByAccountId(@Param("accountId") UUID accountId);
    Optional<Branch> findByAccountIdAndId(UUID accountId, UUID branchId);
    @Modifying
    @Transactional
    @Query(value = "update Branch b set b.deletedTime = current_timestamp where b.accountId = :accountId and b.id = :branchId")
    void disableByAccountIdAndId(@Param("accountId") UUID accountId,@Param("branchId") UUID branchId);
}
