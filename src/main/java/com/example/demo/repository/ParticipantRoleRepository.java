package com.example.demo.repository;

import com.example.demo.entity.ParticipantRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipantRoleRepository extends JpaRepository<ParticipantRole, Long> {

    Optional<ParticipantRole> findByRoleValueIgnoreCase(String roleValue);

}
