package com.tanganda.marsrover.tests.action;

import com.tanganda.marsrover.action.MoveAction;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.tanganda.marsrover.domain.Position;
import com.tanganda.marsrover.model.Coordinate;
import com.tanganda.marsrover.model.Controller;

public class MoveActionTest {

	private MoveAction moveAction;
	
	@Before
    public void setUp() {
        moveAction = new MoveAction();
    }
	
	@Test
	public void shouldWhenNorthIncreaseY() {
		Controller robot = createRobot(Position.NORTH);
		moveAction.apply(robot);
		assertEquals(Integer.valueOf(1), robot.getCoordinate().getY());
		assertEquals(Integer.valueOf(0), robot.getCoordinate().getX());
	}
	
	@Test
	public void shouldWhenEastIncreaseX() {
		Controller robot = createRobot(Position.EAST);
		moveAction.apply(robot);
		assertEquals(Integer.valueOf(0), robot.getCoordinate().getY());
		assertEquals(Integer.valueOf(1), robot.getCoordinate().getX());
	}
	
	@Test
	public void shouldWhenSouthDecrementY() {
		Controller robot = createRobot(Position.SOUTH);
		moveAction.apply(robot);
		assertEquals(Integer.valueOf(-1), robot.getCoordinate().getY());
		assertEquals(Integer.valueOf(0), robot.getCoordinate().getX());
	}
	
	@Test
	public void shouldWhenWestDecrementX() {
		Controller robot = createRobot(Position.WEST);
		moveAction.apply(robot);
		assertEquals(Integer.valueOf(0), robot.getCoordinate().getY());
		assertEquals(Integer.valueOf(-1), robot.getCoordinate().getX());
	}
	
	private Controller createRobot(Position position) {
		Coordinate coordinate = new Coordinate(0, 0);
		return new Controller(null, position,coordinate, "Test");
	}
}
