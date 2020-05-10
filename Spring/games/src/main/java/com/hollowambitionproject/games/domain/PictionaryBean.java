package com.hollowambitionproject.games.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The Class PictionaryBean.
 */
@JsonPropertyOrder({ "data" })
public class PictionaryBean extends GameBean {

	/** The strokes. */
	private List<Stroke> strokes = new ArrayList<>();

	/** The current word. */
	private String currentWord;

	/**
	 * Instantiates a new pictionary bean.
	 */
	public PictionaryBean() {
		super();
	}

	/**
	 * Response instantiator.
	 *
	 * @param messages          the messages
	 * @param currentPlayerName the name
	 * @param strokes           the strokes
	 * @param scoreCard         the score card
	 * @param winCondition      the win condition
	 * @param currentWord       the current word
	 * @param time              the time
	 */
	public PictionaryBean(List<String> messages, Set<String> currentPlayerName, List<Stroke> strokes,
			Map<String, Integer> scoreCard, WinCondition winCondition, String currentWord, int time) {
		super(messages, currentPlayerName, scoreCard, winCondition, time);
		this.strokes = strokes;
		this.currentWord = currentWord;
	}

	/**
	 * Request instantiator
	 *
	 * @param messages          the messages
	 * @param currentPlayerName the current player name
	 * @param strokes           the strokes
	 */
	public PictionaryBean(List<String> messages, Set<String> currentPlayerName, List<Stroke> strokes) {
		super(messages, currentPlayerName);
		this.strokes = strokes;
	}

	/**
	 * Gets the current word.
	 *
	 * @return the current word
	 */
	public String getCurrentWord() {
		return currentWord;
	}

	/**
	 * Sets the current word.
	 *
	 * @param currentWord the new current word
	 */
	public void setCurrentWord(String currentWord) {
		this.currentWord = currentWord;
	}

	/**
	 * Gets the strokes.
	 *
	 * @return the strokes
	 */
	public List<Stroke> getStrokes() {
		return strokes;
	}

	/**
	 * Sets the strokes.
	 *
	 * @param strokes the new strokes
	 */
	public void setStrokes(List<Stroke> strokes) {
		this.strokes = strokes;
	}

}
