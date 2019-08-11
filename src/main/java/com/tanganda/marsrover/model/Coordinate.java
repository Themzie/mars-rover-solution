package com.tanganda.marsrover.model;

import java.io.Serializable;

public class Coordinate implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer x;
	
	private Integer y;
	
	public Coordinate() {
	}
	
	public Coordinate(Integer x, Integer y) {
		this();
		this.x = x;
		this.y = y;
	}

	public Integer getX() {
		return x;
	}
	
	public Integer getY() {
		return y;
	}
	
	public void setX(Integer x) {
		this.x = x;
	}
	
	public void setY(Integer y) {
		this.y = y;
	}
}
