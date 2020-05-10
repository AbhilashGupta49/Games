package com.hollowambitionproject.games.domain;

import java.util.List;

/**
 * The Class WinCondition.
 */
public class WinCondition {

	/** The winners. */
	private List<Winner> winners;

	/** The win message. */
	private String winMessage;

	/**
	 * Instantiates a new win condition.
	 *
	 * @param winners    the winners
	 * @param winMessage the win message
	 */
	public WinCondition(List<Winner> winners, String winMessage) {
		this.winners = winners;
		this.winMessage = winMessage;
	}

	/**
	 * Gets the winners.
	 *
	 * @return the winners
	 */
	public List<Winner> getWinners() {
		return winners;
	}

	/**
	 * Sets the winners.
	 *
	 * @param winners the new winners
	 */
	public void setWinners(List<Winner> winners) {
		this.winners = winners;
	}

	/**
	 * Gets the win message.
	 *
	 * @return the win message
	 */
	public String getWinMessage() {
		return winMessage;
	}

	/**
	 * Sets the win message.
	 *
	 * @param winMessage the new win message
	 */
	public void setWinMessage(String winMessage) {
		this.winMessage = winMessage;
	}

}
