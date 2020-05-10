package com.hollowambitionproject.games.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hollowambitionproject.games.domain.PictionaryBean;
import com.hollowambitionproject.games.service.PictionaryDataServiceImpl;

/**
 * The Class PictionaryController.
 */
@RestController
@RequestMapping("/pictionary")
public class PictionaryController {

	/** The pictionary data service. */
	@Autowired
	private PictionaryDataServiceImpl pictionaryDataServiceImpl;

	/**
	 * Exchange data.
	 *
	 * @param data the data
	 * @return the response entity
	 */
	@PostMapping(value = "/exchange-data", consumes = "application/json")
	public ResponseEntity<PictionaryBean> exchangeData(@RequestBody PictionaryBean data) {
		return ResponseEntity.ok(pictionaryDataServiceImpl.processData(data));
	}

	/**
	 * New Round.
	 *
	 * @param names the names
	 * @param word  the word
	 * @param time  the time
	 * @return the response entity
	 */
	@PostMapping(value = "/setup-new-round", consumes = "application/json")
	public ResponseEntity<Boolean> setupNewRound(@RequestParam Set<String> names, @RequestParam String word,
			@RequestParam int time) {
		return ResponseEntity.ok(pictionaryDataServiceImpl.setupNewRound(names, word, String.valueOf(time)));
	}

	/**
	 * Sets the current word.
	 *
	 * @param word the word
	 * @return the response entity
	 */
	@PostMapping(value = "/set-word", consumes = "application/json")
	public ResponseEntity<Boolean> setCurrentWord(@RequestParam String word) {
		return ResponseEntity.ok(pictionaryDataServiceImpl.setCurrentWord(word));
	}

	/**
	 * Gets the current word.
	 *
	 * @param word the word
	 * @return the response entity
	 */
	@GetMapping(value = "/get-word", consumes = "application/json")
	public ResponseEntity<String> getCurrentWord() {
		return ResponseEntity.ok(pictionaryDataServiceImpl.getCurrentWord());
	}

}
