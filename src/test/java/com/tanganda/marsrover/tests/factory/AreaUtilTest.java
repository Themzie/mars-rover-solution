package com.tanganda.marsrover.tests.factory;

import com.tanganda.marsrover.Util.AreaUtil;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class AreaUtilTest {
	
	private AreaUtil areaFactory;
	
	@Before
	public void setUp() {
		initAreaFactory();
	}
	
	@Test
	public void shouldCreateAnArea() {
		assertNotNull(areaFactory.create());
	}
	
	private void initAreaFactory() {
		areaFactory = new AreaUtil();
		areaFactory.setMaxXCoordinate(5);
		areaFactory.setMaxYCoordinate(5);
		areaFactory.setMinXCoordinate(0);
		areaFactory.setMinYCoordinate(0);
	}
}
