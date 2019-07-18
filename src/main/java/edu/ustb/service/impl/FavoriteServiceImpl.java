package edu.ustb.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.ustb.dao.FavoriteDao;
import edu.ustb.dao.RouteDao;
import edu.ustb.dao.impl.FavoriteDaoImpl;
import edu.ustb.dao.impl.RouteDaoImpl;
import edu.ustb.domain.Favorite;
import edu.ustb.domain.User;
import edu.ustb.service.FavoriteService;

/**
 * FavoriteServiceImpl
 */
public class FavoriteServiceImpl implements FavoriteService {

    private FavoriteDao favoriteDao = new FavoriteDaoImpl();
    private RouteDao routeDao = new RouteDaoImpl();

    public List<Favorite> getFavoritesByUser(User user) {
        List<Favorite> favlist = new ArrayList<Favorite>();
        try {
            List<Integer> rids = favoriteDao.getFavoritesRidByUser(user);
            for (int id : rids) {
                favlist.add(new Favorite(routeDao.getRouteByRid(id), null, user));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return favlist;
    }

    public boolean isFavorite(int uid, int rid) {
        try {
            return favoriteDao.getFavorited(uid, rid)!=null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int addFavorite(int uid, int rid) {
        //check before add
        if (!isFavorite(uid, rid)) {
            try {
                return favoriteDao.addFavorited(uid, rid);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

}
