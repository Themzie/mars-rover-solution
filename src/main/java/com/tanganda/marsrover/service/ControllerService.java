package com.tanganda.marsrover.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tanganda.marsrover.Util.ClientUtil;
import com.tanganda.marsrover.model.Controller;
import com.tanganda.marsrover.parse.CommandParse;
import com.tanganda.marsrover.validator.BoundaryValidator;

@Component
public class ControllerService {

	private CommandParse commandParse;
	
	private BoundaryValidator boundaryValidator;
	
	private ClientUtil controllerFactory;
	
	public Controller moveTo(final String command) {
		Controller robot = controllerFactory.create();
			commandParse.parseToActions(command)
						.forEach(action ->{
							action.apply(robot);
							boundaryValidator.validateBoundary(robot.getArea(), robot.getCoordinate());
						});
		return robot;
	}
	
	@Autowired
	public void setBoundaryValidator(BoundaryValidator boundaryValidator) {
		this.boundaryValidator = boundaryValidator;
	}
	
	@Autowired
	public void setCommandParse(CommandParse commandParse) {
		this.commandParse = commandParse;
	}
	
	@Autowired
	public void setRobotFactory(ClientUtil robotFactory) {
		this.controllerFactory = robotFactory;
	}
}
