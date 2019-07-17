package edu.ustb.service.impl;

import java.util.List;

import edu.ustb.dao.FavoriteDao;
import edu.ustb.dao.RouteDao;
import edu.ustb.dao.RouteImgDao;
import edu.ustb.dao.SellerDao;
import edu.ustb.dao.impl.FavoriteDaoImpl;
import edu.ustb.dao.impl.RouteDaoImpl;
import edu.ustb.dao.impl.RouteImgDaoImpl;
import edu.ustb.dao.impl.SellerDaoImpl;
import edu.ustb.domain.Route;
import edu.ustb.domain.RouteImg;
import edu.ustb.domain.Seller;
import edu.ustb.service.RouteService;

/**
 * RouteServiceImpl
 */
public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao = new RouteDaoImpl();
    private RouteImgDao routeImgDao = new RouteImgDaoImpl();
    private SellerDao sellerDao = new SellerDaoImpl();
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    public Route getRouteByRid(int rid) {
        Route route = routeDao.getRouteByRid(rid);

        List<RouteImg> routeImgList = routeImgDao.getRouteImgByRid(route.getRid());
        route.setRouteImgList(routeImgList);

        Seller seller = sellerDao.getSellerBySid(route.getSid());
        route.setSeller(seller);

        int count = favoriteDao.findCountByRid(route.getRid());
        route.setCount(count);

        return route;
    }

}
