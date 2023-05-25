package com.barista.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barista.dto.PreRequisiteDTO;
import com.barista.exceptions.BaristaException;
import com.barista.service.BaristaService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BaristaController {

	private Logger logger = LoggerFactory.getLogger(BaristaController.class);

	@Autowired
	private BaristaService baristaService;

	@PostMapping("/initialValues")
	public ResponseEntity<?> initialValues() {
		logger.info("Initialize ingredeient values");
		try {
			Map<String, PreRequisiteDTO> ingredients = baristaService.initialValues();
			return new ResponseEntity<>(ingredients, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Error in Initialize ingredeient values", e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/currentValues")
	public ResponseEntity<?> currentValues() {
		logger.info("Getting current ingredeient values");
		try {
			return new ResponseEntity<>(baristaService.currentValues(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error in Getting current ingredeient values", e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/resetValues")
	public ResponseEntity<?> resetValues() {
		logger.info("Resetting ingredeient values");
		try {
			return new ResponseEntity<>(baristaService.resetValues(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error while Resetting ingredeient values", e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getDrinkDetails/{drinkName}")
	public ResponseEntity<?> getDrinkDetails(@PathVariable("drinkName") String drinkName) {
		logger.info("Get drink details ");
		try {
			return new ResponseEntity<>(baristaService.getDrinkDetails(drinkName), HttpStatus.OK);
		} catch (BaristaException e) {
			logger.error("Error while getting drink details", e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
