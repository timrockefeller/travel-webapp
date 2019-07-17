package edu.ustb.dao;

import edu.ustb.domain.Route;
import edu.ustb.domain.SearchInfo;

import java.util.List;

public interface SearchDao {

/**
 * @param rid
 * @return rID value
 *
 * */
    Route getByID(int rid);//Single Search

    /**
     * @param searchInfo(Constraints)
     * @return list the number of the routes
     *
     * */
    int findRowsAll(SearchInfo searchInfo);//GET ALL(DEFAULT)
    /**
     * @param searchInfo(Constraints) p.s status = -1 would return an exception while
     *                                1 refers to routeName only, 2 refers to routeDescription only
     *                                3 refers to both.
     * @return the result list
     * */
    List<Route> findByCondition(SearchInfo searchInfo);//CORE SEARCH


}
