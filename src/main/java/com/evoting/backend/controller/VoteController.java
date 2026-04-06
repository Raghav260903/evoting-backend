package com.evoting.backend.controller;

import com.evoting.backend.entity.Candidate;
import com.evoting.backend.entity.Vote;
import com.evoting.backend.entity.Voter;
import com.evoting.backend.repository.CandidateRepository;
import com.evoting.backend.repository.VoteRepository;
import com.evoting.backend.repository.VoterRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

@RestController
@RequestMapping("/api/votes")
@CrossOrigin
public class VoteController {

    private final VoteRepository voteRepository;
    private final VoterRepository voterRepository;
    private final CandidateRepository candidateRepository;

    public VoteController(VoteRepository voteRepository,
                          VoterRepository voterRepository,
                          CandidateRepository candidateRepository) {
        this.voteRepository = voteRepository;
        this.voterRepository = voterRepository;
        this.candidateRepository = candidateRepository;
    }

    @PostMapping
public String castVote(@RequestBody Map<String, String> request) {

    String voterId = request.get("voterId").trim();
    Long candidateId = Long.parseLong(request.get("candidateId").trim());

    System.out.println("Voter ID from request = " + voterId);
    System.out.println("Candidate ID from request = " + candidateId);

    Voter voter = voterRepository.findByVoterId(voterId).orElse(null);
    Candidate candidate = candidateRepository.findById(candidateId).orElse(null);

    System.out.println("Voter found = " + (voter != null));
    System.out.println("Candidate found = " + (candidate != null));

    if (voter == null || candidate == null) {
        return "Invalid voter or candidate";
    }

    if (voteRepository.existsByVoter(voter)) {
        return "You have already voted";
    }

    Vote vote = new Vote();
    vote.setVoter(voter);
    vote.setCandidate(candidate);
    vote.setVotedAt(LocalDateTime.now());

    voteRepository.save(vote);

    return "Vote saved successfully";
}

    @GetMapping("/check/{voterId}")
    public boolean hasAlreadyVoted(@PathVariable String voterId) {
        Voter voter = voterRepository.findByVoterId(voterId).orElse(null);

        if (voter == null) {
            return false;
        }

        return voteRepository.existsByVoter(voter);
    }

    @GetMapping("/results")
    public List<Map<String, Object>> getResults() {
        List<Candidate> candidates = candidateRepository.findAll();

        return candidates.stream().map(candidate -> {
            long voteCount = voteRepository.countByCandidate(candidate);

            Map<String, Object> result = new HashMap<>();
            result.put("id", candidate.getId());
            result.put("candidateName", candidate.getCandidateName());
            result.put("votes", voteCount);

            return result;
        }).toList();
    }
}