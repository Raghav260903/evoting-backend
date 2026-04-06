package com.evoting.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "candidate_name", nullable = false)
    private String candidateName;

    public Candidate() {
    }

    public Candidate(String candidateName) {
        this.candidateName = candidateName;
    }

    public Long getId() {
        return id;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }
}