package edu.ustb.dao;

import java.util.List;

import edu.ustb.domain.Route;

import java.util.List;

/**
 * RouteDao
 */
public interface RouteDao {

    public Route getRouteByRid(int rid);

    /**
     * 根据cid查询总记录
     * 
     * @param cid
     * @return
     */
    public int findTotalCount(int cid, String rname);

    /**
     * 根据cid,start,pageSize查询当前页得数据集
     * 
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    public List<Route> findByPage(int cid, int start, int pageSize, String rname);
    Route findOne(int rid);
}
