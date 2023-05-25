package com.barista.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.barista.constants.BaristaConstants;
import com.barista.dto.DrinkDTO;
import com.barista.dto.PreRequisiteDTO;
import com.barista.exceptions.BaristaException;
import com.barista.service.BaristaService;

@Service
public class BaristaServiceImpl implements BaristaService {

	private Logger logger = LoggerFactory.getLogger(BaristaServiceImpl.class);

	static Map<String, PreRequisiteDTO> ingrediants = new HashMap<String, PreRequisiteDTO>();

	@Override
	public Map<String, PreRequisiteDTO> initialValues() {
		ingrediants.put(BaristaConstants.COFFEE, new PreRequisiteDTO(0.75, 10));
		ingrediants.put(BaristaConstants.DECAF_COFFE, new PreRequisiteDTO(0.75, 10));
		ingrediants.put(BaristaConstants.SUGAR, new PreRequisiteDTO(0.25, 10));
		ingrediants.put(BaristaConstants.CREAM, new PreRequisiteDTO(0.25, 10));
		ingrediants.put(BaristaConstants.STEAMED_MILK, new PreRequisiteDTO(0.35, 10));
		ingrediants.put(BaristaConstants.FOAMED_MILK, new PreRequisiteDTO(0.35, 10));
		ingrediants.put(BaristaConstants.ESPRESSO, new PreRequisiteDTO(1.10, 10));
		ingrediants.put(BaristaConstants.COCOA, new PreRequisiteDTO(0.90, 10));
		ingrediants.put(BaristaConstants.WHIPPED_CREAM, new PreRequisiteDTO(1.00, 10));

		return ingrediants;
	}

	@Override
	public DrinkDTO getDrinkDetails(String drinkName) throws BaristaException {
		logger.info("Verfiying drink details");
		if (BaristaConstants.COFFEE.equals(drinkName)) {
			PreRequisiteDTO c = checkAvailability(BaristaConstants.COFFEE, 3);
			PreRequisiteDTO s = checkAvailability(BaristaConstants.SUGAR, 1);
			PreRequisiteDTO cr = checkAvailability(BaristaConstants.CREAM, 1);
			adjustValues(c, 3, BaristaConstants.COFFEE);
			adjustValues(s, 1, BaristaConstants.SUGAR);
			adjustValues(cr, 1, BaristaConstants.CREAM);

			Double price = 3 * c.getPrice() + s.getPrice() + cr.getPrice();
			return new DrinkDTO(price, drinkName);
		}

		if (BaristaConstants.DECAF_COFFE.equals(drinkName)) {
			PreRequisiteDTO c = checkAvailability(BaristaConstants.DECAF_COFFE, 3);
			PreRequisiteDTO s = checkAvailability(BaristaConstants.SUGAR, 1);
			PreRequisiteDTO cr = checkAvailability(BaristaConstants.CREAM, 1);
			adjustValues(c, 3, BaristaConstants.DECAF_COFFE);
			adjustValues(s, 1, BaristaConstants.SUGAR);
			adjustValues(cr, 1, BaristaConstants.CREAM);

			Double price = 3 * c.getPrice() + s.getPrice() + cr.getPrice();
			return new DrinkDTO(price, drinkName);
		}

		if (BaristaConstants.CAFFE_LATTE.equals(drinkName)) {
			PreRequisiteDTO c = checkAvailability(BaristaConstants.ESPRESSO, 2);
			PreRequisiteDTO s = checkAvailability(BaristaConstants.STEAMED_MILK, 1);
			adjustValues(c, 2, BaristaConstants.ESPRESSO);
			adjustValues(s, 1, BaristaConstants.STEAMED_MILK);

			Double price = 2 * c.getPrice() + s.getPrice();
			return new DrinkDTO(price, drinkName);
		}

		if (BaristaConstants.CAFFE_AMERICANO.equals(drinkName)) {
			PreRequisiteDTO c = checkAvailability(BaristaConstants.ESPRESSO, 3);
			adjustValues(c, 3, BaristaConstants.ESPRESSO);

			Double price = 3 * c.getPrice();
			return new DrinkDTO(price, drinkName);
		}

		if (BaristaConstants.CAFFE_MOCHA.equals(drinkName)) {
			PreRequisiteDTO c = checkAvailability(BaristaConstants.ESPRESSO, 1);
			PreRequisiteDTO s = checkAvailability(BaristaConstants.COCOA, 1);
			PreRequisiteDTO cr = checkAvailability(BaristaConstants.STEAMED_MILK, 1);
			PreRequisiteDTO w = checkAvailability(BaristaConstants.WHIPPED_CREAM, 1);
			adjustValues(c, 1, BaristaConstants.ESPRESSO);
			adjustValues(s, 1, BaristaConstants.COCOA);
			adjustValues(cr, 1, BaristaConstants.STEAMED_MILK);
			adjustValues(cr, 1, BaristaConstants.WHIPPED_CREAM);

			Double price = c.getPrice() + s.getPrice() + cr.getPrice() + w.getPrice();
			return new DrinkDTO(price, drinkName);
		}

		if (BaristaConstants.CAPPUCCINO.equals(drinkName)) {
			PreRequisiteDTO c = checkAvailability(BaristaConstants.ESPRESSO, 2);
			PreRequisiteDTO s = checkAvailability(BaristaConstants.STEAMED_MILK, 1);
			PreRequisiteDTO cr = checkAvailability(BaristaConstants.FOAMED_MILK, 1);
			adjustValues(c, 2, BaristaConstants.ESPRESSO);
			adjustValues(s, 1, BaristaConstants.STEAMED_MILK);
			adjustValues(cr, 1, BaristaConstants.FOAMED_MILK);

			Double price = 2 * c.getPrice() + s.getPrice() + cr.getPrice();
			return new DrinkDTO(price, drinkName);
		}

		throw new BaristaException(BaristaConstants.NOT_AVAILABLE);
	}

	private PreRequisiteDTO checkAvailability(String drink, int quantity) throws BaristaException {
		PreRequisiteDTO c = ingrediants.get(drink);
		if (c.getQuantity() < quantity)
			throw new BaristaException(BaristaConstants.INSUFFICENT_INGREDIENTS);
		return c;
	}

	private void adjustValues(PreRequisiteDTO c, int quantity, String drink) {
		c.setQuantity(c.getQuantity() - quantity);
		ingrediants.put(drink, c);
	}

	@Override
	public Map<String, PreRequisiteDTO> currentValues() {
		logger.info("returninng current ingredient values");
		return ingrediants;
	}

	@Override
	public Map<String, PreRequisiteDTO> resetValues() {
		logger.info("reset ingredient values");
		return initialValues();
	}

}
