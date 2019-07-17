package edu.ustb.service.impl;

import edu.ustb.dao.RouteDao;
import edu.ustb.dao.impl.RouteDaoImpl;
import edu.ustb.domain.Route;
import edu.ustb.service.RouteService;

/**
 * RouteServiceImpl
 */
public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao = new RouteDaoImpl();
    public Route getRouteByRid(int rid) {
        Route route = null;
        try {
            route = routeDao.getRouteByRid(rid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return route;
    }

}
