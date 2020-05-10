package com.hollowambitionproject.games.dao.message;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hollowambitionproject.games.store.MessageDataStore;

/**
 * The Class MessageDaoImpl.
 */
@Service
public class MessageDaoImpl {

	/**
	 * Exchange messages.
	 *
	 * @param requestMessages the request messages
	 * @return the list
	 */
	public List<String> exchangeMessages(List<String> requestMessages) {
		MessageDataStore.addMessages(requestMessages);
		return MessageDataStore.getMessages();
	}

	/**
	 * Clear messages.
	 *
	 * @return true, if successful
	 */
	public boolean clearMessages() {
		MessageDataStore.clearMessages();
		return true;
	}

	/**
	 * Adds the messages.
	 *
	 * @param requestMessages the request messages
	 * @return true, if successful
	 */
	public boolean addMessages(List<String> requestMessages) {
		MessageDataStore.addMessages(requestMessages);
		return true;
	}

	/**
	 * Gets the messages.
	 *
	 * @return true, if successful
	 */
	public boolean getMessages() {
		MessageDataStore.getMessages();
		return true;
	}

}
