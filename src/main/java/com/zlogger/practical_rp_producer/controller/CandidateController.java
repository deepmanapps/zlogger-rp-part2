package com.zlogger.practical_rp_producer.controller;


import com.zlogger.practical_rp_producer.model.Candidate;
import com.zlogger.practical_rp_producer.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/v1")
public class CandidateController {

    @Autowired
    CandidateService candidateService;

    @GetMapping("/candidates")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Candidate> getAllCandidates() {
        return candidateService.findAllCandidates();
    }
    @GetMapping("/candidates/{jobTitle}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Candidate> getCandidateByJob(@PathVariable("jobTitle") String jobTitle) {
        return candidateService.findByCandidatesJobTitle(jobTitle);
    }

    @PostMapping("/candidates")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Candidate> createCandidate(@RequestBody Candidate candidate) {
        return candidateService.save(candidate);
    }

    @PutMapping("/candidates")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Candidate> updateCandidate(@RequestBody Candidate candidate) {
        return candidateService.update(candidate.getId(), candidate);
    }

    @DeleteMapping("/candidates/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteCandidateById(@PathVariable("id") int id) {
        return candidateService.delete(id);
    }

    @DeleteMapping("/candidates")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteAllCandidates() {
        return candidateService.deleteAll();
    }

}
