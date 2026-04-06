package com.evoting.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "voter_id", nullable = false)
    private Voter voter;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    @Column(name = "voted_at")
    private LocalDateTime votedAt;

    public Vote() {
    }

    public Vote(Voter voter, Candidate candidate, LocalDateTime votedAt) {
        this.voter = voter;
        this.candidate = candidate;
        this.votedAt = votedAt;
    }

    public Long getId() {
        return id;
    }

    public Voter getVoter() {
        return voter;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public LocalDateTime getVotedAt() {
        return votedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public void setVotedAt(LocalDateTime votedAt) {
        this.votedAt = votedAt;
    }
}