package com.tanganda.marsrover.tests.action;

import com.tanganda.marsrover.action.RightAction;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.tanganda.marsrover.domain.Position;
import com.tanganda.marsrover.model.Coordinate;
import com.tanganda.marsrover.model.Controller;

public class RightActionTest {
	
	private RightAction rightAction;

	@Before
	public void setUp() {
		rightAction = new RightAction();
	}

	@Test
	public void shouldReturnEastWhenNorth() {
		Controller robot = createRobot(Position.NORTH);
		rightAction.apply(robot);
		assertEquals(Position.EAST, robot.getPosition());
	}

	@Test
	public void shouldReturnWeastWhenSouth() {
		Controller robot = createRobot(Position.SOUTH);
		rightAction.apply(robot);
		assertEquals(Position.WEST, robot.getPosition());
	}

	@Test
	public void shouldReturnSouthWhenEast() {
		Controller robot = createRobot(Position.EAST);
		rightAction.apply(robot);
		assertEquals(Position.SOUTH, robot.getPosition());
	}

	@Test
	public void shouldReturNorthWhenWest() {
		Controller robot = createRobot(Position.WEST);
		rightAction.apply(robot);
		assertEquals(Position.NORTH, robot.getPosition());
	}

	private Controller createRobot(Position position) {
		Coordinate coordinate = new Coordinate(0, 0);
                    return new Controller(null, position, coordinate, "Test");
	}
}
