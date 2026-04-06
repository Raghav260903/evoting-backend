package com.evoting.backend.controller;

import com.evoting.backend.entity.Voter;
import com.evoting.backend.repository.VoterRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voters")
@CrossOrigin
public class VoterController {

    private final VoterRepository voterRepository;

    public VoterController(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    @GetMapping
    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    @PostMapping
    public Voter addVoter(@RequestBody Voter voter) {
        return voterRepository.save(voter);
    }
}