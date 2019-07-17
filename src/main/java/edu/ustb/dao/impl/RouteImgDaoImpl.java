package edu.ustb.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ustb.dao.RouteImgDao;
import edu.ustb.domain.RouteImg;
import edu.ustb.util.JDBCUtils;

/**
 * RouteImgDaoImpl
 */
public class RouteImgDaoImpl implements RouteImgDao {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<RouteImg> getRouteImgByRid(int rid) {
        String sql = "select * from tab_route_img where rid = ?";
        return template.query(sql, new BeanPropertyRowMapper<RouteImg>(RouteImg.class), rid);
    }

}
