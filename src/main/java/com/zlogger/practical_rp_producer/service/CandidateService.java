package com.zlogger.practical_rp_producer.service;


import com.zlogger.practical_rp_producer.model.Candidate;
import com.zlogger.practical_rp_producer.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class CandidateService {


    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }


    public Flux<Candidate> findAllCandidates() {
         return candidateRepository.findAll();
    }

    public Flux<Candidate> findByCandidatesJobTitle(String jobTitle) {
        return candidateRepository.findByJobTitle(jobTitle);
    }

    public Flux<Candidate> findByCandidatesEmail(String email) {
        return candidateRepository.findByEmail(email);
    }



    public Mono<Candidate> save(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Mono<Candidate> update(int id,Candidate candidate) {
        return candidateRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optCandidate -> {
                    if (optCandidate.isPresent()) {
                        return candidateRepository.save(candidate);
                    }
                    return Mono.empty();
                });
    }
    public Mono<Void> delete(int id) {

       return candidateRepository.deleteById(id);
    }

    public Mono<Void> deleteAll() {
        return candidateRepository.deleteAll();
    }
}
