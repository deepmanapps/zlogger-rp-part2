package com.zlogger.practical_rp_producer.repository;

import com.zlogger.practical_rp_producer.model.Candidate;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface CandidateRepository extends R2dbcRepository<Candidate, Integer> {

    Flux<Candidate> findByCandidateNameContaining(String candidateName);

    Flux<Candidate> findByCandidatesJobTitle(String jobTitle);

    Flux<Candidate> findByCandidatesEmail(String email);


}
