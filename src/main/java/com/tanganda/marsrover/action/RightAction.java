package com.tanganda.marsrover.action;

import com.tanganda.marsrover.model.Controller;

public class RightAction implements IAction{

	@Override
	public void apply(Controller robot) {
		robot.setPosition(robot.getPosition().getRight());
	}
}
