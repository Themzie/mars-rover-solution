package com.tanganda.marsrover.tests.factory;

import com.tanganda.marsrover.Util.ActionUtil;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.tanganda.marsrover.action.IAction;
import com.tanganda.marsrover.action.LeftAction;
import com.tanganda.marsrover.action.MoveAction;
import com.tanganda.marsrover.action.RightAction;
import com.tanganda.marsrover.exception.CommandInvalidException;

public class ActionUtilTest {
	
	private static final Character LEFT = 'L';
	private static final Character MOVE = 'M';
	private static final Character RIGHT = 'R';
	private static final Character UNKNOW_COMMAND = 'A';
	
	private ActionUtil actionFactory;
	
	@Before
	public void setUp() {
		actionFactory = new ActionUtil();
	}
	
	@Test
	public void shouldReturnLeftActionInstance() {
		IAction action = actionFactory.get(LEFT);
		assertEquals(Boolean.TRUE, (action instanceof LeftAction));
	}
	
	@Test
	public void shouldReturnRightActionInstance() {
		IAction action = actionFactory.get(RIGHT);
		assertEquals(Boolean.TRUE, (action instanceof RightAction));
	}
	
	@Test
	public void shouldReturnMoveActionInstance() {
		IAction action = actionFactory.get(MOVE);
		assertEquals(Boolean.TRUE, (action instanceof MoveAction));
	}
	
	@Test(expected = CommandInvalidException.class)
	public void shouldThrowCommandInvalidException() {
		actionFactory.get(UNKNOW_COMMAND);
	}
}
