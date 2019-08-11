package com.tanganda.marsrover.Util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.tanganda.marsrover.action.IAction;
import com.tanganda.marsrover.action.LeftAction;
import com.tanganda.marsrover.action.MoveAction;
import com.tanganda.marsrover.action.RightAction;
import com.tanganda.marsrover.exception.CommandInvalidException;

@Component
public class ActionUtil {
	
	private static final Character LEFT = 'L';
	private static final Character MOVE = 'M';
	private static final Character RIGHT = 'R';
	
	private static Map<Character, IAction> actions = registerActions();
	
	public ActionUtil() {
	}

	public IAction get(final char code) {
		IAction action = actions.get(code);
		if(ObjectUtils.isEmpty(action)) {
			throw new CommandInvalidException();
		}
		return action;
	}
	
	private static Map<Character, IAction> registerActions() {
		actions = new HashMap<>();
		actions.put(LEFT, new LeftAction());
		actions.put(RIGHT, new RightAction());
		actions.put(MOVE, new MoveAction());
		return actions;
	}
}
