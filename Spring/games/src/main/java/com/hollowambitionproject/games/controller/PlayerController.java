package com.hollowambitionproject.games.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hollowambitionproject.games.service.player.PlayerDataServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerController.
 */
@RestController()
@RequestMapping("/player")
public class PlayerController {

	/** The player data service impl. */
	@Autowired
	private PlayerDataServiceImpl playerDataServiceImpl;

	/**
	 * Adds the player.
	 *
	 * @param name the name
	 * @return the response entity
	 */
	@PostMapping(value = "/add-player")
	public ResponseEntity<Boolean> addPlayer(@RequestParam String name) {
		return ResponseEntity.ok(playerDataServiceImpl.addPlayer(name));
	}

	/**
	 * Gets the player score card.
	 *
	 * @return the player score card
	 */
	@GetMapping(value = "/player-score")
	public ResponseEntity<Map<String, Integer>> getPlayerScoreCard() {
		return ResponseEntity.ok(playerDataServiceImpl.getAllPlayersScore());
	}

	/**
	 * Gets the current players.
	 *
	 * @return the current players
	 */
	@GetMapping(value = "/current-players")
	public ResponseEntity<Set<String>> getCurrentPlayers() {
		return ResponseEntity.ok(playerDataServiceImpl.getCurrentPlayers());
	}

	/**
	 * Gets the team score card.
	 *
	 * @return the team score card
	 */
	@GetMapping("/team-score")
	public ResponseEntity<Map<Integer, Integer>> getTeamScoreCard() {
		return ResponseEntity.ok(playerDataServiceImpl.getTeamScore());
	}

	/**
	 * Gets the team score card.
	 *
	 * @param teams the teams
	 * @return the team score card
	 */
	@PostMapping(value = "/form-teams")
	public ResponseEntity<Boolean> getTeamScoreCard(@RequestParam int teams) {
		return ResponseEntity.ok(playerDataServiceImpl.formTeams(teams));
	}

	/**
	 * Give chance to players.
	 *
	 * @param names the names
	 * @return the response entity
	 */
	@PostMapping(value = "/give-chance-players")
	public ResponseEntity<Boolean> giveChanceToPlayers(@RequestParam Set<String> names) {
		return ResponseEntity.ok(playerDataServiceImpl.setCurrentPlayers(names));
	}

	/**
	 * Give chance to team.
	 *
	 * @param team the team
	 * @return the response entity
	 */
	@PostMapping(value = "/give-chance-team")
	public ResponseEntity<Boolean> giveChanceToTeam(@RequestParam int team) {
		return ResponseEntity.ok(playerDataServiceImpl.setCurrentTeam(team));
	}

	/**
	 * Give chance to players.
	 *
	 * @param names  the names
	 * @param points the points
	 * @return the response entity
	 */
	@PostMapping(value = "/give-points-players")
	public ResponseEntity<Boolean> givePointsToPlayers(@RequestParam Set<String> names, @RequestParam int points) {
		return ResponseEntity.ok(playerDataServiceImpl.addPointsPlayers(names, points));
	}

	/**
	 * Reset player points.
	 *
	 * @return the response entity
	 */
	@PostMapping(value = "/reset-player-points")
	public ResponseEntity<Boolean> resetPlayerPoints() {
		return ResponseEntity.ok(playerDataServiceImpl.resetPoints());
	}

}
