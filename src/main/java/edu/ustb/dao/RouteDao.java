package edu.ustb.dao;

import edu.ustb.domain.Route;

import java.util.List;

/**
 * RouteDao
 */
public interface RouteDao {

    Route getRouteByRid(int rid);
    int findTotalCount(int cid, String rname);

    List<Route> findByPage(int cid, int start, int pageSize, String rname);

    Route findOne(int rid);
}
