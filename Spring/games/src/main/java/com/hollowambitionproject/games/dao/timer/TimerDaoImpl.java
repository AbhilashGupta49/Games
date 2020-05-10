package com.hollowambitionproject.games.dao.timer;

import org.springframework.stereotype.Service;

import com.hollowambitionproject.games.store.TimerDataStore;

/**
 * The Class TimerDaoImpl.
 */
@Service
public class TimerDaoImpl {

	/**
	 * Gets the time left.
	 *
	 * @param allowedTime the allowed time
	 * @return the time left
	 */
	public int getTimeLeft(int allowedTime) {
		int diff = allowedTime - TimerDataStore.getTime();
		if (diff < 1) {
			diff = 0;
		}
		return diff;
	}

	/**
	 * Reset timer.
	 *
	 * @return true, if successful
	 */
	public boolean resetTimer() {
		TimerDataStore.resetTimer();
		return true;
	}

}
