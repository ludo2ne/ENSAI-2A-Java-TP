package fr.ensai.running.repository;

import org.springframework.data.repository.CrudRepository;

import fr.ensai.running.model.Competition;

public interface CompetitionRepository extends CrudRepository<Competition, Long> {
}