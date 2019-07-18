package edu.ustb.service;

import edu.ustb.domain.Route;
import edu.ustb.vo.PageBean;

/**
 * RouteService
 */
public interface RouteService {

    Route getRouteByRid(int rid);
    PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);


}
