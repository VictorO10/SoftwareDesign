package com.example.demo;

import com.example.controller.LaboratoryController;
import com.example.model.service.models.LaboratoryDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	LaboratoryController laboratoryController;

	@Test
	public void addLaboratory() {

		int sizeBefore = laboratoryController.getAllLaboratorys().size();

		LaboratoryDTO laboratoryDTO = new LaboratoryDTO();
		laboratoryDTO.setCurricula("Mancare");
		laboratoryDTO.setTitle("Felul intai");
		laboratoryDTO.setLongDescription("Fasole frecata cu carnati");
		laboratoryDTO.setLabNb(Long.parseLong("50"));
		laboratoryController.saveLaboratory(laboratoryDTO);

		int sizeAfter = laboratoryController.getAllLaboratorys().size();

		assert(sizeBefore == sizeAfter - 1);
	}

//	@Test
//	public void removeLaboratory(){
//		int sizeBefore = laboratoryController.getAllLaboratorys().size();
//
//		laboratoryController.deleteLaboratoryLabNb(Long.parseLong("50"));
//
//		int sizeAfter = laboratoryController.getAllLaboratorys().size();
//
//		assert(sizeBefore == sizeAfter + 1);
//	}



}
