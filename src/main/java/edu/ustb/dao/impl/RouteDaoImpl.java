package edu.ustb.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ustb.dao.RouteDao;
import edu.ustb.domain.Route;
import edu.ustb.util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * RouteDaoImpl
 */
public class RouteDaoImpl implements RouteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public Route getRouteByRid(int rid) throws DataAccessException {
        String sql = "select * from tab_route where rid=?";
        Route route = template.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);
        return route;
    }

    public int findTotalCount(int cid, String rname) {
        String sql = "select count(*) from tab_route where cid = ? and rname like ?";
        return template.queryForObject(sql, Integer.class, cid,"%"+rname+"%");
    }

    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {
        String sql = "select * from tab_route where cid = ? and rname like ? limit ? , ? ";
        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), cid,"%"+rname+"%", start, pageSize);
    }

}
