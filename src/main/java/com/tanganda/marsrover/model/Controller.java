package com.tanganda.marsrover.model;

import java.io.Serializable;

import com.tanganda.marsrover.domain.Position;

public class Controller implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Position position;
	
	private Coordinate coordinate;
	
	private Area area;
	
	private String id;
	
	public Controller() {
	}
	
	public Controller(Area area, Position position, Coordinate coordinate, String id) {
		this();
		this.position = position;
		this.coordinate = coordinate;
		this.id = id;
		this.area = area;
	}
	
	public String getId() {
		return id;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public Area getArea() {
		return area;
	}
	
	@Override
	public String toString() {
		StringBuilder textBuilder = new StringBuilder();
		textBuilder.append("(")
				.append(this.coordinate.getX())
				.append(", ")
				.append(this.coordinate.getY())
				.append(", ")
				.append(this.position.getLabel())
				.append(")");
		
		return textBuilder.toString();
	}
}
