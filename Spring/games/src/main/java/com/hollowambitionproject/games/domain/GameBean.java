/*
 * 
 */
package com.hollowambitionproject.games.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The Class GameBean.
 */
public class GameBean {

	/** The messages. */
	private List<String> messages = new ArrayList<>();

	/** The name. */
	private Set<String> names;

	/** The score card. */
	private Map<String, Integer> scoreCard;

	/** The win condition. */
	private WinCondition winCondition;

	private int time;

	/**
	 * Instantiates a new game bean.
	 */
	public GameBean() {

	}

	/**
	 * Instantiates a new game bean.
	 *
	 * @param messages the messages
	 * @param names    the names
	 */
	public GameBean(List<String> messages, Set<String> names) {
		this.messages = messages;
		this.names = names;
	}

	/**
	 * Instantiates a new game bean.
	 *
	 * @param messages  the messages
	 * @param names     the names
	 * @param scoreCard the score card
	 */
	public GameBean(List<String> messages, Set<String> names, Map<String, Integer> scoreCard) {
		this.messages = messages;
		this.names = names;
		this.scoreCard = scoreCard;
	}

	/**
	 * Instantiates a new game bean.
	 *
	 * @param messages     the messages
	 * @param names        the names
	 * @param scoreCard    the score card
	 * @param winCondition the win condition
	 */
	public GameBean(List<String> messages, Set<String> names, Map<String, Integer> scoreCard,
			WinCondition winCondition) {
		this.messages = messages;
		this.names = names;
		this.scoreCard = scoreCard;
		this.winCondition = winCondition;
	}

	/**
	 * Instantiates a new game bean.
	 *
	 * @param messages     the messages
	 * @param names        the names
	 * @param scoreCard    the score card
	 * @param winCondition the win condition
	 * @param time         the time
	 */
	public GameBean(List<String> messages, Set<String> names, Map<String, Integer> scoreCard, WinCondition winCondition,
			int time) {
		this.messages = messages;
		this.names = names;
		this.scoreCard = scoreCard;
		this.winCondition = winCondition;
		this.time = time;
	}

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * Sets the time.
	 *
	 * @param time the new time
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * Gets the win condition.
	 *
	 * @return the win condition
	 */
	public WinCondition getWinCondition() {
		return winCondition;
	}

	/**
	 * Sets the win condition.
	 *
	 * @param winCondition the new win condition
	 */
	public void setWinCondition(WinCondition winCondition) {
		this.winCondition = winCondition;
	}

	/**
	 * Sets the names.
	 *
	 * @param names the new names
	 */
	public void setNames(Set<String> names) {
		this.names = names;
	}

	/**
	 * Gets the score card.
	 *
	 * @return the score card
	 */
	public Map<String, Integer> getScoreCard() {
		return scoreCard;
	}

	/**
	 * Sets the score card.
	 *
	 * @param scoreCard the score card
	 */
	public void setScoreCard(Map<String, Integer> scoreCard) {
		this.scoreCard = scoreCard;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public Set<String> getNames() {
		return names;
	}

	/**
	 * Sets the name.
	 *
	 * @param names the new name
	 */
	public void setName(Set<String> names) {
		this.names = names;
	}

	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	public List<String> getMessages() {
		return messages;
	}

	/**
	 * Sets the messages.
	 *
	 * @param messages the new messages
	 */
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}
