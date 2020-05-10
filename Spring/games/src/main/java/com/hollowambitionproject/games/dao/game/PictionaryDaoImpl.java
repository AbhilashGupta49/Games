package com.hollowambitionproject.games.dao.game;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hollowambitionproject.games.domain.Stroke;
import com.hollowambitionproject.games.service.player.PlayerDataServiceImpl;
import com.hollowambitionproject.games.store.PictionaryDataStore;

/**
 * The Class PictionaryDaoImpl.
 */
@Service
public class PictionaryDaoImpl implements GameDao<List<Stroke>> {

	/** The player data service impl. */
	@Autowired
	private PlayerDataServiceImpl playerDataServiceImpl;

	/**
	 * Exchange game data.
	 *
	 * @param names          the names
	 * @param requestStrokes the request strokes
	 * @return the object
	 */
	@Override
	public List<Stroke> exchangeGameData(Set<String> names, List<Stroke> requestStrokes) {
		if (playerDataServiceImpl.getCurrentPlayers().containsAll(names)) {
			PictionaryDataStore.modifyStrokes(requestStrokes);
			return null;
		} else {
			return PictionaryDataStore.readStrokes();
		}
	}

	/**
	 * Clear strokes.
	 *
	 * @return true, if successful
	 */
	public boolean clearStrokes() {
		PictionaryDataStore.clearStrokes();
		return true;
	}

	/**
	 * Sets the current word.
	 *
	 * @param currentWord the current word
	 * @return true, if successful
	 */
	public boolean setCurrentWord(String currentWord) {
		PictionaryDataStore.setCurrentWord(currentWord);
		return true;
	}

	/**
	 * Gets the current word.
	 *
	 * @return the current word
	 */
	public String getCurrentWord() {
		return PictionaryDataStore.getCurrentWord();
	}

}
