package com.evoting.backend.config;

import com.evoting.backend.entity.Candidate;
import com.evoting.backend.repository.CandidateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadCandidates(CandidateRepository candidateRepository) {
        return args -> {
            if (candidateRepository.count() == 0) {
                candidateRepository.save(new Candidate("Candidate A - Progressive Party 🎯"));
                candidateRepository.save(new Candidate("Candidate B - Unity Alliance ✊"));
                candidateRepository.save(new Candidate("Candidate C - Freedom Front ⭐"));
            }
        };
    }
}