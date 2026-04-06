package com.evoting.backend.repository;

import com.evoting.backend.entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoterRepository extends JpaRepository<Voter, Long> {

    Optional<Voter> findByPhone(String phone);

    Optional<Voter> findByVoterId(String voterId);
}