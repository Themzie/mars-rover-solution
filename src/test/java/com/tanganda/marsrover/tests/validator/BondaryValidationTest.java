package com.tanganda.marsrover.tests.validator;

import org.junit.Before;
import org.junit.Test;

import com.tanganda.marsrover.exception.ExceededBoundaryException;
import com.tanganda.marsrover.model.Area;
import com.tanganda.marsrover.model.Coordinate;
import com.tanganda.marsrover.validator.BoundaryValidator;

public class BondaryValidationTest {
	
	private static final Integer MAX_X_COORDINATE = 5;
	private static final Integer MAX_Y_COORDINATE = 5;
	private static final Integer COORDINATE_X_INIT = 0;
	private static final Integer COORDINATE_Y_INIT = 0;
	
	private BoundaryValidator boundaryValidator;
	
	private Area area;
	
	private Coordinate coordinate;
	
	@Before
	public void setUp() {
		boundaryValidator = new BoundaryValidator();
		coordinate = new Coordinate(COORDINATE_X_INIT, COORDINATE_Y_INIT);
		initArea();
	}

	@Test(expected = ExceededBoundaryException.class)
	public void shouldExceededBoundaryInXOfBase() {
		coordinate.setY(COORDINATE_Y_INIT);
		coordinate.setX(-1);
		boundaryValidator.validateBoundary(area, coordinate);
	}
	
	@Test(expected = ExceededBoundaryException.class)
	public void shouldExceededBoundaryInYOfBase() {
		coordinate.setX(COORDINATE_X_INIT);
		coordinate.setY(-1);
		boundaryValidator.validateBoundary(area, coordinate);
	}
	
	@Test(expected = ExceededBoundaryException.class)
	public void shouldExceededBoundaryInXOfTop() {
		coordinate.setX(MAX_X_COORDINATE + 1);
		coordinate.setY(COORDINATE_Y_INIT);
		boundaryValidator.validateBoundary(area, coordinate);
	}
	
	@Test(expected = ExceededBoundaryException.class)
	public void shouldExceededBoundaryInYOfTop() {
		coordinate.setX(COORDINATE_X_INIT);
		coordinate.setY(MAX_Y_COORDINATE + 1);
		boundaryValidator.validateBoundary(area, coordinate);
	}
	
	

	private void initArea() {
		Coordinate baseOfArea = new Coordinate(COORDINATE_X_INIT, COORDINATE_Y_INIT);
		Coordinate topOfArea = new Coordinate(MAX_X_COORDINATE, MAX_Y_COORDINATE);
		area = new Area(baseOfArea, topOfArea);
	}
	
}
