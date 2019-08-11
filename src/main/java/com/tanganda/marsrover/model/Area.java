package com.tanganda.marsrover.model;

import java.io.Serializable;

public class Area implements Serializable {

	private static final long serialVersionUID = 1L;

	private Coordinate baseOfArea;

	private Coordinate topOfArea;

	public Area() {
	}

	public Area(Coordinate topOfArea, Coordinate baseOfArea) {
		this();
		this.topOfArea = topOfArea;
		this.baseOfArea = baseOfArea;
	}

	public Coordinate getBaseOfArea() {
		return baseOfArea;
	}

	public Coordinate getTopOfArea() {
		return topOfArea;
	}
}
