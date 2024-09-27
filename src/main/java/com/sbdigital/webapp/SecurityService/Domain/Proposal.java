package com.sbdigital.webapp.SecurityService.Domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "proposals")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "proposal_title")
    private String proposalTitle;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "proposal_description")
    private String proposalDescription;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "budget")
    private Double budget;

    @Column(name = "priority")
    private int priority;

    @Column(name = "createdBy")
    private int createdBy;

    @ElementCollection
    @Column(name = "assignee")
    private List<Long> assignee;

    @ElementCollection
    @Column(name = "contributors")
    private List<Long> contributors;    // Getters and Setters
    // ...

    public Long getId() {
        return id;
    }

    public Proposal setId(Long id) {
        this.id = id;
        return this;
    }

    public String getProposalTitle() {
        return proposalTitle;
    }

    public Proposal setProposalTitle(String proposalTitle) {
        this.proposalTitle = proposalTitle;
        return this;
    }

    public String getClientName() {
        return clientName;
    }

    public Proposal setClientName(String clientName) {
        this.clientName = clientName;
        return this;
    }

    public String getProposalDescription() {
        return proposalDescription;
    }

    public Proposal setProposalDescription(String proposalDescription) {
        this.proposalDescription = proposalDescription;
        return this;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Proposal setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Double getBudget() {
        return budget;
    }

    public Proposal setBudget(Double budget) {
        this.budget = budget;
        return this;
    }

    public int getPriority() {
        return priority;
    }

    public Proposal setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public List<Long> getAssignee() {
        return assignee;
    }

    public Proposal setAssignee(List<Long> assignee) {
        this.assignee = assignee;
        return this;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public Proposal setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public List<Long> getContributors() {
        return contributors;
    }

    public Proposal setContributors(List<Long> contributors) {
        this.contributors = contributors;
        return this;
    }
}