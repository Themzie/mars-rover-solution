package com.tanganda.marsrover.validator;

import org.springframework.stereotype.Component;

import com.tanganda.marsrover.exception.ExceededBoundaryException;
import com.tanganda.marsrover.model.Area;
import com.tanganda.marsrover.model.Coordinate;

@Component
public class BoundaryValidator{

	public void validateBoundary(final Area area, final Coordinate coordinate) {
		Integer yCoordinate = coordinate.getY();
		Integer xCoordinate = coordinate.getX();
		if(!yIsWithin(area, yCoordinate) || !xIsWithin(area, xCoordinate)) {
			throw new ExceededBoundaryException();
		}
	}
	
	private boolean yIsWithin(final Area area, final int y) {
		return area.getBaseOfArea().getY() <= y && area.getTopOfArea().getY() >= y;
	}
	
	private boolean xIsWithin(final Area area, final int x) {
		return area.getBaseOfArea().getY() <= x && area.getTopOfArea().getY() >= x;
	}
}
