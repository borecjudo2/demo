package com.example.demo.repository;

import com.example.demo.entity.ParticipantRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipantRoleRepository extends CrudRepository<ParticipantRole, Long> {

    Optional<ParticipantRole> findByRoleValue(String roleValue);

}
