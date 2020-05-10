package com.hollowambitionproject.games.dao.game;

import java.util.Set;

/**
 * The Interface GameDao.
 *
 * @param <T> the generic type
 */
public interface GameDao<T> {

	/**
	 * Exchange game data.
	 *
	 * @param names           the names
	 * @param requestGameData the request game data
	 * @return the t
	 */
	T exchangeGameData(Set<String> names, T requestGameData);

}
