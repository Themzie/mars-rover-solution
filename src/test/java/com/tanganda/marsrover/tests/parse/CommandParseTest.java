package com.tanganda.marsrover.tests.parse;

import com.tanganda.marsrover.Util.ActionUtil;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tanganda.marsrover.action.IAction;
import com.tanganda.marsrover.action.LeftAction;
import com.tanganda.marsrover.action.MoveAction;
import com.tanganda.marsrover.action.RightAction;
import com.tanganda.marsrover.exception.CommandInvalidException;
import com.tanganda.marsrover.parse.CommandParse;


public class CommandParseTest {
	
	private CommandParse commandParse; 
	
	@Before
	public void setUp() {
		commandParse = new CommandParse();
		commandParse.setActionFactory(new ActionUtil());
	}
	
	@Test
    public void shouldBeAnInstanceOfLeftAction(){
        List<IAction> actions = commandParse.parseToActions("L");
        assertTrue(actions.get(0) instanceof LeftAction);
    }

    @Test
    public void shouldBeAnInstanceOfRightAction(){
        List<IAction> actions = commandParse.parseToActions("R");
        assertTrue(actions.get(0) instanceof RightAction);
    }

    @Test
    public void shouldBeAnInstanceOfMoveAction() throws Exception {
        List<IAction> actions = commandParse.parseToActions("M");
        assertTrue(actions.get(0) instanceof MoveAction);
    }

    @Test
    public void shouldContainThreeActions() throws Exception {
        List<IAction> actions = commandParse.parseToActions("MLR");
        assertEquals(actions.size(), 3);
    }

    @Test(expected = CommandInvalidException.class)
    public void shouldValidateInvalidCommand() throws Exception {
    	commandParse.parseToActions("MLARM");
    }
}
