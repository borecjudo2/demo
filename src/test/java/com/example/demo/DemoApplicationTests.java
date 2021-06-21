package com.example.demo;

import com.example.demo.controller.GymParticipantsController;
import com.example.demo.dto.ParticipantDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private GymParticipantsController controller;

	@Test
	void getAll() {
		List<ParticipantDTO> allParticipants = controller.getAllParticipants();
	}

	@Test
	void getById() {
		ParticipantDTO participantById = controller.getParticipantById(18L);
	}

	@Test
	void create() {
		ParticipantDTO participantDTO = getDTO();
		ParticipantDTO createdDTO = controller.createParticipant(participantDTO);
	}

	@Test
	void update() {
		ParticipantDTO participantDTO = getDTO();
		participantDTO.setRole("athlete");
		ParticipantDTO updatedDTO = controller.updateParticipant(participantDTO, 19L);
	}

	@Test
	void delete() {
		controller.deleteParticipant(19L);
	}

	private ParticipantDTO getDTO(){
		ParticipantDTO participantDTO = new ParticipantDTO();
		participantDTO.setName("Дима");
		participantDTO.setLastName("Пупкин");
		participantDTO.setRole("coach");
		participantDTO.setBirthdayDate("26-12-2008");
		participantDTO.setSubscriptionFromDate("12-12-2020");
		participantDTO.setSubscriptionToDate("12-12-2021");
		return participantDTO;
	}

}
