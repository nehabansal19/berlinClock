package com.ubs.opsit.interviews;

import java.util.stream.Stream;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrBuilder;

/**
 * Class to present the implementation of Berlin clock
 * 
 * @author Neha
 *
 */
public class BerlinClock implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		Time time = Time.parse(aTime);
		return new ClockState(time).toString();
	}

	/**
	 * This class represents clock's lights visible state. State of each rows is
	 * encoded as a String consisting of characters 'R', 'Y' and 'O' where Y =
	 * Yellow, R = red, O = Off
	 *
	 */
	public static class ClockState {
		final String second;
		final String hour1;
		final String hour2;
		final String minutes1;
		final String minutes2;

		private ClockState(Time time) {
			this.second = getSeconds(time.seconds);
			this.hour1 = getTopHours(time.hour);
			this.hour2 = getBottomHours(time.hour);
			this.minutes1 = getTopMinutes(time.minutes);
			this.minutes2 = getBottomMinutes(time.minutes);
		}

		private String getTopHours(int hour) {
			return formatRow("R", hour / 5, 4);
		}

		private String getBottomHours(int hour) {
			return formatRow("R", hour % 5, 4);
		}

		private String getTopMinutes(int number) {
			return formatRow("Y", number / 5, 11).replaceAll("YYY", "YYR");

		}

		private String getBottomMinutes(int number) {
			return formatRow("Y", number % 5, 4);
		}

		private String getSeconds(int number) {
			if (number % 2 == 0) {
				return "Y";
			} else {
				return "O";
			}
		}

		private String formatRow(String light, int times, int length) {
			return StringUtils.repeat(light, times) + StringUtils.repeat("O", length - times);
		}

		@Override
		public String toString() {
			return new StrBuilder().appendWithSeparators(new String[] { second, hour1, hour2, minutes1, minutes2 },
					System.lineSeparator()).toString();
		}

	}

	/**
	 * Class to encapsulate hour, minutes and seconds of a day
	 *
	 */
	public static class Time {
		final int hour;
		final int minutes;
		final int seconds;

		public Time(int hour, int minutes, int seconds) {
			this.hour = hour;
			this.minutes = minutes;
			this.seconds = seconds;
		}

		public static Time parse(String time) {
			int[] timeParts = Stream.of(time.split(":")).mapToInt(Integer::parseInt).toArray();
			return new Time(timeParts[0], timeParts[1], timeParts[2]);
		}

		@Override
		public String toString() {
			return String.format("%02d:%02d:%02d", hour, minutes, seconds);
		}

	}

}
