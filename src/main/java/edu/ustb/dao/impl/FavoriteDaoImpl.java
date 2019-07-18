package edu.ustb.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ustb.dao.FavoriteDao;
import edu.ustb.dao.RouteDao;
import edu.ustb.domain.Favorite;
import edu.ustb.domain.Route;
import edu.ustb.domain.User;
import edu.ustb.util.JDBCUtils;

/**
 * FavoriteDaoImpl
 */
public class FavoriteDaoImpl implements FavoriteDao{

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<Integer> getFavoritesRidByUser(User user) {
        List<Integer> favlist = new ArrayList<Integer>();

        String sql = "select rid from tab_favorite where uid=?";
        favlist = template.queryForList(sql, Integer.class, user.getUid());

        return favlist;
    }

    public Favorite getFavorited(int uid, int rid) {
        Favorite favorite = null;
        try {
            String sql = "select * from tab_favorite where rid = ? and uid = ?";
            favorite = template.queryForObject(sql,new BeanPropertyRowMapper<Favorite>(Favorite.class),uid,rid );
        } catch (DataAccessException e) {
            System.out.println("did not found fav, user not logged in? : "+user.getUid());
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
