package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Berlin Clock test class
 * 
 * @author Neha
 *
 */
public class BerlinClockTest {

	private TimeConverter berlinClock;

	/**
	 * Initialize the dependent object used for unit testing
	 */
	@Before
	public void before() {
		berlinClock = new BerlinClock();
	}

	/**
	 * Test method to test scenario middle of afternoon when time is "15:15:15"
	 */
	@Test
	public void testBerlinClock() {
		String expectedTime = "O" + System.lineSeparator() + "RRRO" + System.lineSeparator() + "OOOO"
				+ System.lineSeparator() + "YYROOOOOOOO" + System.lineSeparator() + "OOOO";
		assertEquals(expectedTime, berlinClock.convertTime("15:15:15"));
	}

	/**
	 * Test method to test scenario just before midnight when time is "23:59:59"
	 */
	@Test
	public void testBerlinClockJustBeforeMidnight() {
		String expectedTime = "O" + System.lineSeparator() + "RRRR" + System.lineSeparator() + "RRRO"
				+ System.lineSeparator() + "YYRYYRYYRYY" + System.lineSeparator() + "YYYY";
		assertEquals(expectedTime, berlinClock.convertTime("23:59:59"));
	}

	/**
	 * Test method to test scenario Midnight when time is "00:00:00"
	 */
	@Test
	public void testBerlinClockWhenMidnight() {
		String expectedTime = "Y" + System.lineSeparator() + "OOOO" + System.lineSeparator() + "OOOO"
				+ System.lineSeparator() + "OOOOOOOOOOO" + System.lineSeparator() + "OOOO";
		assertEquals(expectedTime, berlinClock.convertTime("00:00:00"));
	}

}
