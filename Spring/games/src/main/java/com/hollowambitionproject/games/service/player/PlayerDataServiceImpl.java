package com.hollowambitionproject.games.service.player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.hollowambitionproject.games.store.PlayerDataStore;

/**
 * The Class PlayerDataServiceImpl.
 */
@Service
public class PlayerDataServiceImpl {

	/**
	 * Sets the current players.
	 *
	 * @param players the players
	 * @return true, if successful
	 */
	public boolean setCurrentPlayers(Set<String> players) {
		PlayerDataStore.setCurrentPlayers(players);
		return true;
	}

	/**
	 * Sets the current team.
	 *
	 * @param team the team
	 * @return true, if successful
	 */
	public boolean setCurrentTeam(int team) {
		PlayerDataStore.setCurrentTeam(team);
		PlayerDataStore.setCurrentPlayers(getAllPlayersInTeam(team));
		return true;
	}

	/**
	 * Form teams.
	 *
	 * @param teams the teams
	 * @return true, if successful
	 */
	public boolean formTeams(int teams) {
		PlayerDataStore.getTeamPlayers().clear();
		for (int i = 1; i <= teams; i++) {
			PlayerDataStore.getTeamPlayers().put(i, new HashSet<>());
		}
		return true;
	}

	/**
	 * Adds the player.
	 *
	 * @param name the name
	 * @return true, if successful
	 */
	public synchronized boolean addPlayer(String name) {
		Map<Integer, Set<String>> teamPlayers = PlayerDataStore.getTeamPlayers();
		if (teamPlayers.size() == 0) {
			formTeams(1);
		}
		if (teamPlayers.size() == 1) {
			return addPlayerToTeam(name, 1);
		}
		int minSize = teamPlayers.get(1).size();
		for (int i = 1; i < teamPlayers.size(); i++) {
			if (teamPlayers.get(i + 1).size() < minSize) {
				return addPlayerToTeam(name, i + 1);
			}
		}
		return addPlayerToTeam(name, 1);

	}

	/**
	 * Adds the player to team.
	 *
	 * @param name the name
	 * @param team the team
	 * @return true, if successful
	 */
	public boolean addPlayerToTeam(String name, int team) {
		if (!PlayerDataStore.getScoreCard().containsKey(name)) {
			PlayerDataStore.getScoreCard().put(name, 0);
			PlayerDataStore.getTeamPlayers().get(team).add(name);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Adds the points.
	 *
	 * @param name   the name
	 * @param points the points
	 * @return true, if successful
	 */
	public boolean addPointsPlayer(String name, int points) {
		int currentScore = PlayerDataStore.getScoreCard().get(name);
		PlayerDataStore.getScoreCard().put(name, currentScore + points);
		return true;
	}

	/**
	 * Adds the points multiple players.
	 *
	 * @param names  the names
	 * @param points the points
	 * @return true, if successful
	 */
	public boolean addPointsPlayers(Set<String> names, int points) {
		for (String name : names) {
			addPointsPlayer(name, points);
		}
		return true;
	}

	/**
	 * Adds the points team.
	 *
	 * @param team   the team
	 * @param points the points
	 * @return true, if successful
	 */
	public boolean addPointsTeam(int team, int points) {
		Set<String> players = getAllPlayersInTeam(team);
		for (String player : players) {
			addPointsPlayer(player, points);
		}
		return true;
	}

	/**
	 * Reset points.
	 *
	 * @return true, if successful
	 */
	public boolean resetPoints() {
		Map<String, Integer> scoreCard = PlayerDataStore.getScoreCard();
		for (Map.Entry<String, Integer> playerScore : scoreCard.entrySet()) {
			setPlayerPoints(playerScore.getKey(), 0);
		}
		return true;
	}

	/**
	 * Sets the player points.
	 *
	 * @param name  the name
	 * @param score the score
	 * @return true, if successful
	 */
	public boolean setPlayerPoints(String name, int score) {
		PlayerDataStore.getScoreCard().put(name, score);
		return true;
	}

	/**
	 * Gets the team score.
	 *
	 * @return the team score
	 */
	public synchronized Map<Integer, Integer> getTeamScore() {
		Map<Integer, Integer> teamScore = new HashMap<>();
		Map<Integer, Set<String>> teams = PlayerDataStore.getTeamPlayers();
		for (Map.Entry<Integer, Set<String>> team : teams.entrySet()) {
			int score = 0;
			for (String player : team.getValue()) {
				score += PlayerDataStore.getScoreCard().get(player);
			}
			teamScore.put(team.getKey(), score);
		}
		return teamScore;
	}

	/**
	 * Gets the current players.
	 *
	 * @return the current players
	 */
	public Set<String> getCurrentPlayers() {
		return PlayerDataStore.getCurrentPlayers();
	}

	/**
	 * Gets the all players score.
	 *
	 * @return the all players score
	 */
	public Map<String, Integer> getAllPlayersScore() {
		return PlayerDataStore.getScoreCard();

	}

	/**
	 * Gets the all players in team.
	 *
	 * @param team the team
	 * @return the all players in team
	 */
	public Set<String> getAllPlayersInTeam(int team) {
		return PlayerDataStore.getTeamPlayers().get(team);
	}

	/**
	 * Gets the number of teams.
	 *
	 * @return the number of teams
	 */
	public int getNumberOfTeams() {
		return PlayerDataStore.getTeamPlayers().size();
	}

	/**
	 * Checks if is player present.
	 *
	 * @param name the name
	 * @return true, if is player present
	 */
	public boolean isPlayerPresent(String name) {
		return PlayerDataStore.getScoreCard().containsKey(name);
	}

}
