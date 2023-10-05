package com.vote.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vote.app.model.Candidate;

public interface CandidateRepo extends JpaRepository<Candidate, Integer> {

}
