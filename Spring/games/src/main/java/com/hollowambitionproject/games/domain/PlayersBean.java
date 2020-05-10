package com.hollowambitionproject.games.domain;

import java.util.Map;

/**
 * The Class PlayersBean.
 */
public class PlayersBean {

	/** The team players. */
	private Map<Integer, String> teamPlayers;

	/** The current team. */
	private int currentTeam;

	/** The current players. */
	private String currentPlayers;

	/**
	 * Instantiates a new players bean.
	 *
	 * @param teamPlayers    the team players
	 * @param currentTeam    the current team
	 * @param currentPlayers the current players
	 */
	public PlayersBean(Map<Integer, String> teamPlayers, int currentTeam, String currentPlayers) {
		this.teamPlayers = teamPlayers;
		this.currentTeam = currentTeam;
		this.currentPlayers = currentPlayers;
	}

	/**
	 * Gets the team players.
	 *
	 * @return the team players
	 */
	public Map<Integer, String> getTeamPlayers() {
		return teamPlayers;
	}

	/**
	 * Sets the team players.
	 *
	 * @param teamPlayers the team players
	 */
	public void setTeamPlayers(Map<Integer, String> teamPlayers) {
		this.teamPlayers = teamPlayers;
	}

	/**
	 * Gets the current team.
	 *
	 * @return the current team
	 */
	public int getCurrentTeam() {
		return currentTeam;
	}

	/**
	 * Sets the current team.
	 *
	 * @param currentTeam the new current team
	 */
	public void setCurrentTeam(int currentTeam) {
		this.currentTeam = currentTeam;
	}

	/**
	 * Gets the current players.
	 *
	 * @return the current players
	 */
	public String getCurrentPlayers() {
		return currentPlayers;
	}

	/**
	 * Sets the current players.
	 *
	 * @param currentPlayers the new current players
	 */
	public void setCurrentPlayers(String currentPlayers) {
		this.currentPlayers = currentPlayers;
	}

}
