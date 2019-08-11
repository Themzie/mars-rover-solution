package com.tanganda.marsrover.action;

import com.tanganda.marsrover.model.Controller;

public class MoveAction implements IAction{

	@Override
	public void apply(Controller robot) {
		Integer oldXCoordinate = robot.getCoordinate().getX();
		Integer oldYCoordinate = robot.getCoordinate().getY();
		robot.getCoordinate().setX(oldXCoordinate + robot.getPosition().getValueToIncreaseX());
		robot.getCoordinate().setY(oldYCoordinate + robot.getPosition().getValueToIncreaseY());
	}

}
