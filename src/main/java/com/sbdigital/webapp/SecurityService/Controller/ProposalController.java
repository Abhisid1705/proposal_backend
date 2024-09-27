package com.sbdigital.webapp.SecurityService.Controller;

import com.sbdigital.webapp.SecurityService.Domain.Notification;
import com.sbdigital.webapp.SecurityService.Domain.Proposal;
import com.sbdigital.webapp.SecurityService.Service.NotificationService;
import com.sbdigital.webapp.SecurityService.Service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")  // Replace with your frontend URL
@RequestMapping("/proposals")
public class ProposalController {

    @Autowired
    private ProposalService proposalService;
    @Autowired
    private NotificationService notificationService;
    @PostMapping("/create")
    public Proposal createProposal(@RequestBody Proposal proposal) {
        proposal.setContributors(new ArrayList<Long>());
        List<Notification> notifications = new ArrayList<>();
        for (Long userId : proposal.getAssignee()) {
            Notification notification = new Notification();
            notification.setUser_id(userId);  // Set the user ID to each contributor of the proposal
            notification.setMessage("A new proposal has been created with name: " + proposal.getProposalTitle());
            notification.setRead(0);  // Set the read status to 0 (unread)
            notifications.add(notification);
        }

        // Save all notifications to the database
        notificationService.saveAllNotifications(notifications);

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
    @GetMapping("/my-proposal/{userid}")
    public List<Proposal> getProposalByTaskIdAndUserId(@PathVariable Integer userid) {
        return proposalService.getAllMyProposal(userid);
    }
    @CrossOrigin(origins = "*")  // Replace with your frontend URL
    @GetMapping("/{taskid}")
    public Proposal getProposalById(@PathVariable Long taskid) {
        return proposalService.getProposalById(taskid);
    }

}