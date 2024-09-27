package com.sbdigital.webapp.SecurityService.Controller;

import com.sbdigital.webapp.SecurityService.Domain.Proposal;
import com.sbdigital.webapp.SecurityService.Service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
    @PostMapping("/task/{taskId}/user/{userId}/submitProposal")
    public Proposal submitProposal(@PathVariable Long taskId, @PathVariable Long userId,
                                   @RequestParam("file") MultipartFile file,
                                   @ModelAttribute Proposal proposal) throws IOException {
        // Save the file to a directory
        String uploadDir = System.getProperty("user.dir") + "/uploads/";
      //  System.out.println("hi"+System.getProperty("user.dir"));
        File uploadFile = new File(uploadDir + +userId+"_"+taskId+"_"+file.getOriginalFilename());
        file.transferTo(uploadFile);

        // Process the proposal
        Proposal existingProposal = proposalService.getProposalByTaskIdAndUserId(taskId, userId);
        if (existingProposal != null) {

            return proposalService.saveProposal(existingProposal);
        } else {
            return proposalService.saveProposal(proposal);
        }
    }
}
