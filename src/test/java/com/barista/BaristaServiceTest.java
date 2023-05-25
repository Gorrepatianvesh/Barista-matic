package com.barista;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.barista.constants.BaristaConstants;
import com.barista.dto.DrinkDTO;
import com.barista.dto.PreRequisiteDTO;
import com.barista.exceptions.BaristaException;
import com.barista.service.BaristaService;

@SpringBootTest
public class BaristaServiceTest {

	@Autowired
	private BaristaService service;

	@Test
	@Order(1)
	public void initialValues() {
		Map<String, PreRequisiteDTO> ingredeints = service.initialValues();
		assertTrue(ingredeints.size() == 9);
	}

	@Test
	@Order(2)
	public void getDrink() {
		try {
			DrinkDTO drink = service.getDrinkDetails(BaristaConstants.COFFEE);
			assertTrue(BaristaConstants.COFFEE.equals(drink.getName()));
			Map<String, PreRequisiteDTO> current = service.currentValues();
			assertTrue(current.get(BaristaConstants.COFFEE).getQuantity() == 7);
		} catch (BaristaException e) {
			assertFalse(true);
		}
	}

	@Test
	@Order(3)
	public void getDrinkNotAvailable() {
		try {
			service.getDrinkDetails("XYZ");
			assertTrue(false);
		} catch (BaristaException e) {
			assertTrue(true);
		}
	}

	@Test
	@Order(4)
	public void getDrinkCappuccino() {
		try {
			DrinkDTO drink = service.getDrinkDetails(BaristaConstants.CAPPUCCINO);
			assertTrue(BaristaConstants.CAPPUCCINO.equals(drink.getName()));
			Map<String, PreRequisiteDTO> current = service.currentValues();
			assertTrue(current.get(BaristaConstants.ESPRESSO).getQuantity() == 8);
		} catch (BaristaException e) {
			assertFalse(true);
		}
	}

	@Test
	@Order(5)
	public void resetValues() {
		Map<String, PreRequisiteDTO> ingredeints = service.initialValues();
		assertTrue(ingredeints.size() == 9);
	}
}
