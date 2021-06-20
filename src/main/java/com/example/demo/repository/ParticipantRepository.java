package com.example.demo.repository;

import com.example.demo.entity.Participant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipantRepository extends CrudRepository<Participant, Long> {

    List<Participant> findAll();

    Optional<Participant> findById(Long id);

}
