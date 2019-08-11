package com.tanganda.marsrover.domain;

public enum Position {
	NORTH("N", 0, 1), EAST("E", 1, 0), SOUTH("S", 0, -1), WEST("W", -1, 0);

	private final String label;
	private final Integer valueToIncreaseX;
	private final Integer valueToIncreaseY;

	private Position(String label, Integer valueToIncreaseX, Integer valueToIncreaseY) {
		this.label = label;
		this.valueToIncreaseX = valueToIncreaseX;
		this.valueToIncreaseY = valueToIncreaseY;
	}

	public Integer getValueToIncreaseX() {
		return valueToIncreaseX;
	}

	public Integer getValueToIncreaseY() {
		return valueToIncreaseY;
	}

	public String getLabel() {
		return label;
	}

	public Position getLeft() {
		switch (this) {
		case NORTH:
			return WEST;
		case SOUTH:
			return EAST;
		case EAST:
			return NORTH;
		default:
			return SOUTH;
		}
	}

	public Position getRight() {
		switch (this) {
		case NORTH:
			return EAST;
		case SOUTH:
			return WEST;
		case EAST:
			return SOUTH;
		default:
			return NORTH;
		}
	}
}
