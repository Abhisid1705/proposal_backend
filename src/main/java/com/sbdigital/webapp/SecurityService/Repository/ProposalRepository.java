package com.sbdigital.webapp.SecurityService.Repository;

import com.sbdigital.webapp.SecurityService.Domain.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    List<Proposal> findByAssigneeContains(Long userId);
    Proposal findByIdAndAssigneeContains(Long taskId, Long userId);

    List<Proposal> findByCreatedBy(Integer createdBy);

}