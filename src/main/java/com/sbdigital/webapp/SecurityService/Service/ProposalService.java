package com.sbdigital.webapp.SecurityService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbdigital.webapp.SecurityService.Domain.Proposal;
import com.sbdigital.webapp.SecurityService.Repository.ProposalRepository;
import java.util.List;

@Service
public class ProposalService {

    @Autowired
    private ProposalRepository proposalRepository;

    public Proposal saveProposal(Proposal proposal) {
        return proposalRepository.save(proposal);
    }

    public List<Proposal> getProposalsByUserId(Long userId) {
        return proposalRepository.findByAssigneeContains(userId);
    }

    public Proposal getProposalByTaskIdAndUserId(Long taskId, Long userId) {
        return proposalRepository.findByIdAndAssigneeContains(taskId, userId);
    }
}
