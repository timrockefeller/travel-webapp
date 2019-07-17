package edu.ustb.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ustb.dao.RouteDao;
import edu.ustb.domain.Route;
import edu.ustb.util.JDBCUtils;

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

    
}
