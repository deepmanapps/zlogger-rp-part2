package com.zlogger.practical_rp_producer.repository;

import com.zlogger.practical_rp_producer.model.Candidate;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface CandidateRepository extends R2dbcRepository<Candidate, Integer> {

    Flux<Candidate> findByNameContaining(String candidateName);

    Flux<Candidate> findByJobTitle(String jobTitle);

    Flux<Candidate> findByEmail(String email);


}
