package edu.ustb.dao;

import java.util.List;

import edu.ustb.domain.Favorite;
import edu.ustb.domain.User;

/**
 * FavorateDao
 */
public interface FavoriteDao {
    public List<Favorite> getFavoritesByUser(User user);
}
