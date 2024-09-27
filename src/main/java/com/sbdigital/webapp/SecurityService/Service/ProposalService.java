package com.sbdigital.webapp.SecurityService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import com.sbdigital.webapp.SecurityService.Domain.Proposal;
import com.sbdigital.webapp.SecurityService.Repository.ProposalRepository;
import java.util.List;
import java.util.Optional;

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
    public List<Proposal> getAllMyProposal(Integer userId) {
        return proposalRepository.findByCreatedBy(userId);
    }
    public Proposal getProposalById(Long taskId) {
        Optional<Proposal> proposalOptional= proposalRepository.findById(taskId);
        return proposalOptional.orElseGet(Proposal::new);

    }
}
