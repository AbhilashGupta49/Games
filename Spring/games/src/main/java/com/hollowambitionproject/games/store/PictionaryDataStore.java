package com.hollowambitionproject.games.store;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.hollowambitionproject.games.domain.Stroke;

/**
 * The Class PictionaryDataStore.
 */
public class PictionaryDataStore {

	/** The strokes. */
	private static List<Stroke> strokes = new CopyOnWriteArrayList<>();

	/** The current word. */
	private static String currentWord = null;

	/**
	 * Gets the current word.
	 *
	 * @return the current word
	 */
	public static String getCurrentWord() {
		return currentWord;
	}

	/**
	 * Sets the current word.
	 *
	 * @param currentWord the new current word
	 */
	public static void setCurrentWord(String currentWordSet) {
		currentWord = currentWordSet;
	}

	/**
	 * Modify strokes.
	 *
	 * @param requestStrokes the request strokes
	 */
	public static void modifyStrokes(List<Stroke> requestStrokes) {
		strokes.clear();
		strokes.addAll(requestStrokes);
	}

	/**
	 * Clear strokes.
	 *
	 */
	public static void clearStrokes() {
		strokes.clear();
	}

	/**
	 * Read strokes.
	 *
	 * @return the list
	 */
	public static List<Stroke> readStrokes() {
		return strokes;
	}

}
