package edu.ustb.service.impl;

import java.util.List;

import edu.ustb.dao.FavoriteDao;
import edu.ustb.dao.impl.FavoriteDaoImpl;
import edu.ustb.domain.Favorite;
import edu.ustb.domain.User;
import edu.ustb.service.FavoriteService;

/**
 * FavoriteServiceImpl
 */
public class FavoriteServiceImpl implements FavoriteService {

    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    public List<Favorite> getFavoritesByUser(User user) {
        try {
            return favoriteDao.getFavoritesByUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isFavorite(User user, int rid) {
        try {
            return favoriteDao.isFavorated(user, rid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
