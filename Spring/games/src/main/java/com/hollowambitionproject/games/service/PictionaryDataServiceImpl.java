package com.hollowambitionproject.games.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hollowambitionproject.games.dao.game.PictionaryDaoImpl;
import com.hollowambitionproject.games.domain.PictionaryBean;
import com.hollowambitionproject.games.domain.Stroke;
import com.hollowambitionproject.games.domain.WinCondition;
import com.hollowambitionproject.games.domain.Winner;
import com.hollowambitionproject.games.service.player.PlayerDataServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class PictionaryDataServiceImpl.
 */
@Service("pictionaryDataServiceImpl")
public class PictionaryDataServiceImpl extends GameDataServiceImpl<PictionaryBean>
		implements GameDataService<PictionaryBean> {

	/** The winning points. */
	private static int WINNING_POINTS_GUESSER = 25;

	/** The winning points. */
	private static int WINNING_POINTS_ARTIST = 40;

	/** The win condition. */
	private static WinCondition winCondition;

	/** The stopped time. */
	private static int stoppedTime;

	/** The pictionary dao impl. */
	@Autowired
	private PictionaryDaoImpl pictionaryDaoImpl;

	/** The player data service impl. */
	@Autowired
	PlayerDataServiceImpl playerDataServiceImpl;

	/**
	 * Process data.
	 *
	 * @param requestData the request data
	 * @return the pictionary bean
	 */
	@Override
	public PictionaryBean processData(PictionaryBean requestData) {
		String name = requestData.getNames().iterator().next();
		if (!playerDataServiceImpl.isPlayerPresent(name)) {
			playerDataServiceImpl.addPlayer(name);
		}
		List<String> responseMessages = exchangeMessages(name, requestData.getMessages());
		List<Stroke> strokes = pictionaryDaoImpl.exchangeGameData(requestData.getNames(), requestData.getStrokes());
		Set<String> currentPlayers = playerDataServiceImpl.getCurrentPlayers();
		int time = getTimeLeft();
		if (time < 1) {
			unsetPropertiesExceptStrokes();
		}
		String currentWordResponse = null;
		if (currentPlayers != null && currentPlayers.size() != 0) {
			String currentPlayer = currentPlayers.iterator().next();
			currentWordResponse = currentPlayer.equalsIgnoreCase(name) ? getCurrentWord() : null;
			if (matchWord(requestData.getMessages())) {
				stoppedTime = time;
				playerDataServiceImpl.addPointsPlayer(name, WINNING_POINTS_GUESSER);
				playerDataServiceImpl.addPointsPlayer(currentPlayer, WINNING_POINTS_ARTIST);
				String winningWord = getCurrentWord();
				List<Winner> winners = new ArrayList<>();
				winners.add(new Winner(name, WINNING_POINTS_GUESSER, "guessed the word!"));
				winners.add(new Winner(currentPlayer, WINNING_POINTS_ARTIST, "drew well!"));
				winCondition = new WinCondition(winners, "The winning word was - " + winningWord);
				setCurrentWord(null);
				playerDataServiceImpl.setCurrentPlayers(new HashSet<>());

			}
		}
		Map<String, Integer> scoreCard = playerDataServiceImpl.getAllPlayersScore();
		return new PictionaryBean(responseMessages, currentPlayers, strokes, scoreCard, winCondition,
				currentWordResponse, time);
	}

	/**
	 * Unset properties except strokes.
	 *
	 * @return true, if successful
	 */
	public boolean unsetPropertiesExceptStrokes() {
		winCondition = null;
		playerDataServiceImpl.setCurrentPlayers(new HashSet<>());
		setCurrentWord(null);
		return true;
	}

	/**
	 * Unset properties.
	 *
	 * @return true, if successful
	 */
	public boolean unsetProperties() {
		pictionaryDaoImpl.clearStrokes();
		return unsetPropertiesExceptStrokes();
	}

	/**
	 * Setup new round.
	 *
	 * @param names the names
	 * @param args  the args
	 * @return true, if successful
	 */
	@Override
	public boolean setupNewRound(Set<String> names, String... args) {
		winCondition = null;
		pictionaryDaoImpl.clearStrokes();
		setCurrentWord(args[0]);
		playerDataServiceImpl.setCurrentPlayers(names);
		resetTimer();
		setAllowedTime(Integer.valueOf(args[1]));
		return true;
	}

	/**
	 * Sets the current word.
	 *
	 * @param word the word
	 * @return true, if successful
	 */
	public boolean setCurrentWord(String word) {
		return pictionaryDaoImpl.setCurrentWord(word);
	}

	/**
	 * Gets the current word.
	 *
	 * @return the current word
	 */
	public String getCurrentWord() {
		return pictionaryDaoImpl.getCurrentWord();
	}

	/**
	 * Match word.
	 *
	 * @param messages the messages
	 * @return true, if successful
	 */
	private boolean matchWord(List<String> messages) {
		String currentWord = pictionaryDaoImpl.getCurrentWord();
		if (messages != null && messages.size() > 0 && currentWord != null && messages.contains(currentWord)) {
			return true;
		}
		return false;
	}

}
