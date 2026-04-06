package com.evoting.backend.controller;

import com.evoting.backend.entity.Candidate;
import com.evoting.backend.repository.CandidateRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidateController {

    private final CandidateRepository candidateRepository;

    public CandidateController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @GetMapping
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }
    @PostMapping
public Candidate addCandidate(@RequestBody Candidate candidate) {
    return candidateRepository.save(candidate);
}
}