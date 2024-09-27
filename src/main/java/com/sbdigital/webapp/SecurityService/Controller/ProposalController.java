package com.sbdigital.webapp.SecurityService.Controller;

import com.sbdigital.webapp.SecurityService.Domain.Proposal;
import com.sbdigital.webapp.SecurityService.Service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proposals")
public class ProposalController {

    @Autowired
    private ProposalService proposalService;

    @PostMapping("/create")
    public Proposal createProposal(@RequestBody Proposal proposal) {

        return proposalService.saveProposal(proposal);
    }

    @GetMapping("/user/{userId}")
    public List<Proposal> getProposalsByUserId(@PathVariable Long userId) {
        return proposalService.getProposalsByUserId(userId);
    }

    @GetMapping("/task/{taskId}/user/{userId}")
    public Proposal getProposalByTaskIdAndUserId(@PathVariable Long taskId, @PathVariable Long userId) {
        return proposalService.getProposalByTaskIdAndUserId(taskId, userId);
    }
}