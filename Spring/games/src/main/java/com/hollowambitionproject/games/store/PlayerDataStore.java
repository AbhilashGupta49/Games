package com.hollowambitionproject.games.store;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * The Class PlayerDataStore.
 */
public class PlayerDataStore {

	/** The score card. */
	private static Map<String, Integer> scoreCard = new ConcurrentHashMap<>();

	/** The team players. */
	private static Map<Integer, Set<String>> teamPlayers = new ConcurrentHashMap<>();

	/** The current players. */
	private static Set<String> currentPlayers = new CopyOnWriteArraySet<>();

	/** The current team. */
	private static int currentTeam = 1;

	/**
	 * Gets the score card.
	 *
	 * @return the score card
	 */
	public static Map<String, Integer> getScoreCard() {
		return scoreCard;
	}

	/**
	 * Sets the score card.
	 *
	 * @param scoreCard the score card
	 */
	public static void setScoreCard(Map<String, Integer> scoreCard) {
		PlayerDataStore.scoreCard = scoreCard;
	}

	/**
	 * Gets the team players.
	 *
	 * @return the team players
	 */
	public static Map<Integer, Set<String>> getTeamPlayers() {
		return teamPlayers;
	}

	/**
	 * Sets the team players.
	 *
	 * @param teamPlayers the team players
	 */
	public static void setTeamPlayers(Map<Integer, Set<String>> teamPlayers) {
		PlayerDataStore.teamPlayers = teamPlayers;
	}

	/**
	 * Gets the current players.
	 *
	 * @return the current players
	 */
	public static Set<String> getCurrentPlayers() {
		return currentPlayers;
	}

	/**
	 * Sets the current players.
	 *
	 * @param players the new current players
	 */
	public static void setCurrentPlayers(Set<String> players) {
		currentPlayers.clear();
		currentPlayers.addAll(players);
	}

	/**
	 * Gets the current team.
	 *
	 * @return the current team
	 */
	public static int getCurrentTeam() {
		return currentTeam;
	}

	/**
	 * Sets the current team.
	 *
	 * @param currentTeam the new current team
	 */
	public static void setCurrentTeam(int currentTeam) {
		PlayerDataStore.currentTeam = currentTeam;
	}

}
