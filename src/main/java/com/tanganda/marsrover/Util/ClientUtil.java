package com.tanganda.marsrover.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.tanganda.marsrover.domain.Position;
import com.tanganda.marsrover.model.Area;
import com.tanganda.marsrover.model.Coordinate;
import com.tanganda.marsrover.model.Controller;

@Component
public class ClientUtil {
	
	private AreaUtil areaFactory;
	
	private Integer coordinateXInit;
	
	private Integer coordinateYInit;
	
	private String id;
	
	private Position position;
	
	public Controller create() {
		Coordinate coordinate = new  Coordinate(coordinateXInit, coordinateYInit);
		Area area = areaFactory.create();
		return new Controller(area, position, coordinate, id);
	}
	
	@Autowired
	public void setAreaFactory(AreaUtil areaFactory) {
		this.areaFactory = areaFactory;
	}
	
	@Value("${robot.coordinate_x_init}")
	public void setCoordinateXInit(Integer coordinateXInit) {
		this.coordinateXInit = coordinateXInit;
	}
	
	@Value("${robot.coordinate_y_init}")
	public void setCoordinateYInit(Integer coordinateYInit) {
		this.coordinateYInit = coordinateYInit;
	}
	
	@Value("${robot.id}")
	public void setId(String id) {
		this.id = id;
	}
	
	@Value("${robot.init_position}")
	public void setPosition(Position position) {
		this.position = position;
	}
}
