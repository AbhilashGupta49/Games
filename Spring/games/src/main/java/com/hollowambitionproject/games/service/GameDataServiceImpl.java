package com.hollowambitionproject.games.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hollowambitionproject.games.dao.message.MessageDaoImpl;
import com.hollowambitionproject.games.dao.timer.TimerDaoImpl;

/**
 * The Class GameDataServiceImpl.
 *
 * @param <T> the generic type
 */
@Service
public class GameDataServiceImpl<T> implements GameDataService<T> {

	/** The allowed time. SET this to change timer. */
	private int allowedTime = 0;

	/** The message dao impl. */
	@Autowired
	private MessageDaoImpl messageDaoImpl;

	/** The timer dao impl. */
	@Autowired
	private TimerDaoImpl timerDaoImpl;

	/**
	 * Exchange messages.
	 *
	 * @param name            the name
	 * @param requestMessages the request messages
	 * @return the message[]
	 */
	@Override
	public List<String> exchangeMessages(String name, List<String> requestMessages) {
		return messageDaoImpl
				.exchangeMessages(requestMessages.stream().map(msg -> name + ": " + msg).collect(Collectors.toList()));
	}

	/**
	 * Gets the time left.
	 *
	 * @return the time left
	 */
	@Override
	public int getTimeLeft() {
		return timerDaoImpl.getTimeLeft(allowedTime);
	}

	/**
	 * Reset timer.
	 *
	 * @return true, if successful
	 */
	public boolean resetTimer() {
		return timerDaoImpl.resetTimer();
	}

	/**
	 * Sets the allowed time.
	 *
	 * @param time the new allowed time
	 * @return true, if successful
	 */
	public boolean setAllowedTime(int time) {
		allowedTime = time;
		return true;
	}

	/**
	 * Process data.
	 *
	 * @param requestData the request data
	 * @return the t
	 */
	@Override
	public T processData(T requestData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setupNewRound(Set<String> names, String... args) {
		// TODO Auto-generated method stub
		return false;
	}

}
