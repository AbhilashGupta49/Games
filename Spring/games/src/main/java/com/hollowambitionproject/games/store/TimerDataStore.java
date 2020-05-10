package com.hollowambitionproject.games.store;

/**
 * The Class TimerDataStore.
 */
public class TimerDataStore {

	/** The time. */
	private static long time;

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public static int getTime() {
		return (int) ((System.currentTimeMillis() - time) / 1000);
	}

	/**
	 * Resets the timer.
	 */
	public static void resetTimer() {
		time = System.currentTimeMillis();
	}

}
