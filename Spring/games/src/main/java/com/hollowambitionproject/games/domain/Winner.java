package com.hollowambitionproject.games.domain;

/**
 * The Class Winner.
 */
public class Winner {

	/** The name. */
	private String name;

	/** The points. */
	private int points;

	/** The message. */
	private String message;

	/**
	 * Instantiates a new winner.
	 *
	 * @param name    the name
	 * @param points  the points
	 * @param message the message
	 */
	public Winner(String name, int points, String message) {
		this.name = name;
		this.points = points;
		this.message = message;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the points.
	 *
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Sets the points.
	 *
	 * @param points the new points
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
