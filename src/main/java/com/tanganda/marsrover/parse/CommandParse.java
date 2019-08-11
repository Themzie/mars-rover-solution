package com.tanganda.marsrover.parse;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tanganda.marsrover.action.IAction;
import com.tanganda.marsrover.Util.ActionUtil;

@Component
public class CommandParse {
	
	private ActionUtil actionUtil;
	
	public List<IAction> parseToActions(final String command) {
		return command.chars()
						.mapToObj(act -> actionUtil.get((char) act))
						.collect(Collectors.toList());
	}
	
	@Autowired
	public void setActionFactory(ActionUtil actionFactory) {
		this.actionUtil = actionFactory;
	}

}
