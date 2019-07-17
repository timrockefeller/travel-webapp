
package dao;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import edu.ustb.dao.FavoriteDao;
import edu.ustb.dao.impl.FavoriteDaoImpl;
import edu.ustb.dao.impl.RouteDaoImpl;
import edu.ustb.domain.Favorite;
import edu.ustb.domain.Route;
import edu.ustb.domain.User;
import edu.ustb.service.impl.FavoriteServiceImpl;
import edu.ustb.service.impl.RouteServiceImpl;

/**
 * FavDaoTest
 */
public class FavDaoTest {
    @Test
    public void getList() {

        boolean f = new FavoriteServiceImpl().isFavorite(new User() {
            {
                setUid(26);
            }
        }, 4);
        System.out.println(f);
    }

    public void getRouteByRidTest() {
        int rid = 7;
        Route route = new RouteDaoImpl().getRouteByRid(rid);
        System.out.println(route);
    }

    @Test
    public void addRouteWithUidAndRid() {
        User u = new User() {
            {
                setUid(12);
            }
        };
        int rid = 14;
        int result = new FavoriteServiceImpl().addFavorite(u, rid);
        System.out.println(result);
    }
}
