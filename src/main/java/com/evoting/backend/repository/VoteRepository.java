package com.evoting.backend.repository;

import com.evoting.backend.entity.Candidate;
import com.evoting.backend.entity.Vote;
import com.evoting.backend.entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    boolean existsByVoter(Voter voter);

    long countByCandidate(Candidate candidate);
}