package edu.ustb.dao;

import java.util.List;

import edu.ustb.domain.RouteImg;

/**
 * RouteImgDao
 */
public interface RouteImgDao {

    /**
     * List of pics
     * @param rid
     * @return
     */
    public List<RouteImg> getRouteImgByRid(int rid);
}
