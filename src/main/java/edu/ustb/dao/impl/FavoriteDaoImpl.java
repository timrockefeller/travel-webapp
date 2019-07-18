package edu.ustb.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ustb.dao.FavoriteDao;
import edu.ustb.domain.Favorite;
import edu.ustb.domain.Route;
import edu.ustb.domain.User;
import edu.ustb.util.JDBCUtils;

/**
 * FavoriteDaoImpl
 */
public class FavoriteDaoImpl implements FavoriteDao{

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Favorite> getFavoritesByUser(User user) {
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

    public Favorite getFavorited(int uid, int rid) {
        Favorite favorite = null;
        try {
            String sql = "select * from tab_favorite where rid = ? and uid = ?";
            favorite = template.queryForObject(sql,new BeanPropertyRowMapper<Favorite>(Favorite.class),uid,rid );
        } catch (DataAccessException e) {
            System.out.println("did not found fav, user not logged in?");
        }
        return favorite;
    }

 
    public int addFavorited(int uid, int rid) {
        String sql = "insert into tab_favorite (rid, date, uid) VALUES (?, ?, ?)";
        return template.update(sql, rid, new Date(), uid);
    }

    
    public int findCountByRid(int rid) {
        String sql = "select count(*) from tab_favorite where rid = ?";
        return template.queryForObject(sql,Integer.class,rid);
    }
    
}
