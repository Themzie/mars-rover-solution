package com.tanganda.marsrover.tests.action;

import com.tanganda.marsrover.action.LeftAction;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.tanganda.marsrover.domain.Position;
import com.tanganda.marsrover.model.Coordinate;
import com.tanganda.marsrover.model.Controller;

public class LeftActionTest {

	private LeftAction leftAction;

	@Before
	public void setUp() {
		leftAction = new LeftAction();
	}

	@Test
	public void shouldReturnWestWhenNorth() {
		Controller robot = createRobot(Position.NORTH);
		leftAction.apply(robot);
		assertEquals(Position.WEST, robot.getPosition());
	}

	@Test
	public void shouldReturnEastWhenSouth() {
		Controller robot = createRobot(Position.SOUTH);
		leftAction.apply(robot);
		assertEquals(Position.EAST, robot.getPosition());
	}

	@Test
	public void shouldReturnNorthWhenEast() {
		Controller robot = createRobot(Position.EAST);
		leftAction.apply(robot);
		assertEquals(Position.NORTH, robot.getPosition());
	}

	@Test
	public void shouldReturnSouthWhenWeast() {
		Controller robot = createRobot(Position.WEST);
		leftAction.apply(robot);
		assertEquals(Position.SOUTH, robot.getPosition());
	}

	private Controller createRobot(Position position) {
		Coordinate coordinate = new Coordinate(0, 0);
		return new Controller(null, position, coordinate, "Test");
	}
}
