package com.hollowambitionproject.games.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hollowambitionproject.games.dao.timer.TimerDaoImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class TimerController.
 */
@RestController()
@RequestMapping("/timer")
public class TimerController {

	/** The game data service impl. */
	@Autowired
	private TimerDaoImpl timerDaoImpl;

	/**
	 * Reset timer.
	 *
	 * @return the response entity
	 */
	@PostMapping("/reset-timer")
	public ResponseEntity<Boolean> resetTimer() {
		return ResponseEntity.ok(timerDaoImpl.resetTimer());
	}

}
