package com.hollowambitionproject.games.service;

import java.util.List;
import java.util.Set;

/**
 * The Interface GameDataService.
 *
 * @param <T> the generic type
 */
public interface GameDataService<T> {

	/**
	 * Process data.
	 *
	 * @param requestData the request data
	 * @return the t
	 */
	T processData(T requestData);

	/**
	 * Setup new round.
	 *
	 * @param names the names
	 * @param args  the args
	 * @return true, if successful
	 */
	boolean setupNewRound(Set<String> names, String... args);

	/**
	 * Gets the time left.
	 *
	 * @return the time left
	 */
	int getTimeLeft();

	/**
	 * Exchange messages.
	 *
	 * @param name     the name
	 * @param messages the messages
	 * @return the message[]
	 */
	List<String> exchangeMessages(String name, List<String> messages);

}
