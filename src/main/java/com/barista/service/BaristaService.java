package com.barista.service;

import java.util.Map;

import com.barista.dto.DrinkDTO;
import com.barista.dto.PreRequisiteDTO;
import com.barista.exceptions.BaristaException;

public interface BaristaService {
	Map<String, PreRequisiteDTO> initialValues();
	
	Map<String, PreRequisiteDTO> currentValues();
	
	Map<String, PreRequisiteDTO> resetValues();
	
	DrinkDTO getDrinkDetails(String drinkName)throws BaristaException ;
}
