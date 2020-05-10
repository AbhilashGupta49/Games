package com.hollowambitionproject.games.domain;

/**
 * The Class Stroke.
 */
public class Stroke {

	/** The prev pos. */
	private Coordinate prevPos;

	/** The current pos. */
	private Coordinate currentPos;

	/**
	 * Instantiates a new stroke.
	 *
	 * @param prevPos    the prev pos
	 * @param currentPos the current pos
	 */
	public Stroke(Coordinate prevPos, Coordinate currentPos) {
		super();
		this.prevPos = prevPos;
		this.currentPos = currentPos;
	}

	/**
	 * Gets the prev pos.
	 *
	 * @return the prev pos
	 */
	public Coordinate getPrevPos() {
		return prevPos;
	}

	/**
	 * Sets the prev pos.
	 *
	 * @param prevPos the new prev pos
	 */
	public void setPrevPos(Coordinate prevPos) {
		this.prevPos = prevPos;
	}

	/**
	 * Gets the current pos.
	 *
	 * @return the current pos
	 */
	public Coordinate getCurrentPos() {
		return currentPos;
	}

	/**
	 * Sets the current pos.
	 *
	 * @param currentPos the new current pos
	 */
	public void setCurrentPos(Coordinate currentPos) {
		this.currentPos = currentPos;
	}

}
