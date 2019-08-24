package com.tanganda.marsrover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tanganda.marsrover.service.ControllerService;

@RestController
@RequestMapping("/mars-rover")
public class Controller {
	
	@Autowired
    private ControllerService robotService;

    @RequestMapping(value = "/tanganda/{command}", method = RequestMethod.POST)
    public ResponseEntity<?> moveTo(@PathVariable final String command) {
        com.tanganda.marsrover.model.Controller robot = robotService.moveTo(command);
        return ResponseEntity.ok(robot.toString());
    }
}
