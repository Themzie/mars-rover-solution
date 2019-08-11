package com.tanganda.marsrover.tests.factory;

import com.tanganda.marsrover.Util.AreaUtil;
import com.tanganda.marsrover.Util.ClientUtil;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.tanganda.marsrover.domain.Position;
import com.tanganda.marsrover.model.Area;
import com.tanganda.marsrover.model.Coordinate;
import com.tanganda.marsrover.model.Controller;

public class ControllerUtilTest {
	
	private ClientUtil robotFactory;
	
	@Before
	public void setUp() {
		initRobotFactory();
	}
	
	@Test
	public void shouldCreateARobot() {
		assertNotNull(robotFactory.create());
	}
	
	@Test
	public void shouldCreateARobotWithXAndYInitAsZero() {
		Controller robot = robotFactory.create();
		assertEquals(Integer.valueOf(0), robot.getCoordinate().getX());
		assertEquals(Integer.valueOf(0), robot.getCoordinate().getY());
	}
	
	
	@Test
	public void shouldCreateARobotWithPositionNorth() {
		Controller robot = robotFactory.create();
		assertEquals(Position.NORTH, robot.getPosition());
	}
	
	@Test
	public void shouldCreateARobotWithAreaWithBaseAsZero() {
		Controller robot = robotFactory.create();
		assertEquals(Integer.valueOf(0), robot.getArea().getBaseOfArea().getX());
		assertEquals(Integer.valueOf(0), robot.getArea().getBaseOfArea().getY());
	}
	
	@Test
	public void shouldCreateARobotWithAreaWithTopAsFive() {
		Controller robot = robotFactory.create();
		assertEquals(Integer.valueOf(5), robot.getArea().getTopOfArea().getX());
		assertEquals(Integer.valueOf(5), robot.getArea().getTopOfArea().getY());
	}
	
	@Test
	public void shouldCreateARobotWithIdEqualTest() {
		Controller robot = robotFactory.create();
		assertEquals("Test", robot.getId());
	}

	private void initRobotFactory() {
		robotFactory = new ClientUtil();
		robotFactory.setId("Test");
		robotFactory.setCoordinateXInit(0);
		robotFactory.setCoordinateYInit(0);
		robotFactory.setPosition(Position.NORTH);
		robotFactory.setAreaFactory(createMockAreaFactory());
	}

	private AreaUtil createMockAreaFactory() {
		AreaUtil areaFactory = mock(AreaUtil.class);
		Coordinate topOfArea = new Coordinate(5, 5);
		Coordinate baseOfArea = new Coordinate(0, 0);
		when(areaFactory.create()).thenReturn(new Area(topOfArea, baseOfArea));
		return areaFactory;
	}
	
}
