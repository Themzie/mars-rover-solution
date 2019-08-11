package com.tanganda.marsrover.tests.service;

import com.tanganda.marsrover.Util.ActionUtil;
import com.tanganda.marsrover.Util.AreaUtil;
import com.tanganda.marsrover.Util.ClientUtil;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.tanganda.marsrover.domain.Position;
import com.tanganda.marsrover.exception.CommandInvalidException;
import com.tanganda.marsrover.exception.ExceededBoundaryException;
import com.tanganda.marsrover.model.Controller;
import com.tanganda.marsrover.parse.CommandParse;
import com.tanganda.marsrover.service.ControllerService;
import com.tanganda.marsrover.validator.BoundaryValidator;

public class ControllerServiceTest {
	
	private static final Integer MAX_X_COORDINATE = 5;
	private static final Integer MAX_Y_COORDINATE = 5;
	private static final Integer COORDINATE_X_INIT = 0;
	private static final Integer COORDINATE_Y_INIT = 0;
	
	private ControllerService controllerService;
	
	@Before
	public void setUp() {
		controllerService = new ControllerService();
		setCommandParse();
		setBoundaryValidator();
		setRobotFactory();
	}
	
	@Test
	public void shouldMoveTo0X2SouthPosition() {
		String command = "MMRMMRMM";
		Controller robot = controllerService.moveTo(command);
		assertEquals("(2, 0, S)", robot.toString());
	}
	
	@Test
	public void shouldMoveTo0X2WestPosition() {
		String command = "MML";
		Controller robot = controllerService.moveTo(command);
		assertEquals("(0, 2, W)", robot.toString());
	}
	
	@Test
	public void shouldMoveTo1X3NorthPosition() {
		String command = "MMRMLM";
		Controller robot = controllerService.moveTo(command);
		assertEquals("(1, 3, N)", robot.toString());
	}
	
	@Test
	public void shouldMoveTo5X3SouthPosition() {
		String command = "MMRMLMMMRMMMMRMM";
		Controller robot = controllerService.moveTo(command);
		assertEquals("(5, 3, S)", robot.toString());
	}
	
	@Test
	public void shouldMoveTo5X0SouthPosition() {
		String command = "MMRMLMMMRMMMMRMMMMM";
		Controller robot = controllerService.moveTo(command);
		assertEquals("(5, 0, S)", robot.toString());
	}
	
	@Test(expected = ExceededBoundaryException.class)
	public void shouldThrowExceededBoundaryExceptionOnlyMoving() {
		String command = "MMMMMMMMMMMMMMMMMMMMMMMM";
		controllerService.moveTo(command);
	}
	
	@Test(expected = ExceededBoundaryException.class)
	public void shouldThrowExceededBoundaryException() {
		String command = "MMRMLMMMLMM";
		controllerService.moveTo(command);
	}
	
	@Test(expected = CommandInvalidException.class)
	public void shouldThrowCommandInvalidException() {
		String command = "AAA";
		controllerService.moveTo(command);
	}

	private void setRobotFactory() {
		ClientUtil robotFactory = new ClientUtil();
		robotFactory.setCoordinateXInit(COORDINATE_X_INIT);
		robotFactory.setCoordinateYInit(COORDINATE_Y_INIT);
		robotFactory.setPosition(Position.NORTH);
		robotFactory.setId("Test");
		robotFactory.setAreaFactory(createAreaFactory());
		controllerService.setRobotFactory(robotFactory);
	}

	private AreaUtil createAreaFactory() {
		AreaUtil areaFactory = new AreaUtil();
		areaFactory.setMaxXCoordinate(MAX_X_COORDINATE);
		areaFactory.setMaxYCoordinate(MAX_Y_COORDINATE);
		areaFactory.setMinXCoordinate(COORDINATE_X_INIT);
		areaFactory.setMinYCoordinate(COORDINATE_Y_INIT);
		return areaFactory;
	}

	private void setBoundaryValidator() {
		BoundaryValidator boundaryValidator = new BoundaryValidator();
		controllerService.setBoundaryValidator(boundaryValidator);
	}

	private void setCommandParse() {
		CommandParse commandParse = new CommandParse();
		ActionUtil actionFactory= new ActionUtil();
		commandParse.setActionFactory(actionFactory);
		controllerService.setCommandParse(commandParse);
	}
	
}
