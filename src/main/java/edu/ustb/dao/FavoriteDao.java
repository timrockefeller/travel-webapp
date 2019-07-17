package edu.ustb.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ustb.domain.Favorite;
import edu.ustb.domain.Route;
import edu.ustb.domain.User;
import edu.ustb.util.JDBCUtils;

/**
 * FavorateDao
 */
public class FavoriteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Favorite> getFavoritesByUser(User user) {
        //TODO
        List<Favorite> favlist = new ArrayList<Favorite>();

        List<Route> routes = null;
        String sql = "select * from tab_favorite right join tab_route tr on tab_favorite.rid = tr.rid where uid=?";
        routes = template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), user.getUid());
        for (Route route : routes) {
            Favorite fav = new Favorite();
            fav.setUser(user);
            fav.setRoute(route);
            fav.setDate(new Date().toString());
            favlist.add(fav);
        }
        return favlist;
    }
}
