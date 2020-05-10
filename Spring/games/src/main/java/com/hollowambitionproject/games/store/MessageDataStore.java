package com.hollowambitionproject.games.store;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The Class MessageDataStore.
 */
public class MessageDataStore {

	/** The messages. */
	private static List<String> messages = new CopyOnWriteArrayList<>();

	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	public static List<String> getMessages() {
		return messages;
	}

	/**
	 * Adds the messages.
	 *
	 * @param requestMessages the request messages
	 * @return true, if successful
	 */
	public static void addMessages(List<String> requestMessages) {
		messages.addAll(requestMessages);
	}

	/**
	 * Clear messages.
	 *
	 * @return true, if successful
	 */
	public static boolean clearMessages() {
		messages.clear();
		return true;
	}

}
