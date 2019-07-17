
package dao;

import java.util.List;

import org.junit.Test;

import edu.ustb.dao.FavoriteDao;
import edu.ustb.domain.Favorite;
import edu.ustb.domain.User;

/**
 * FavDaoTest
 */
public class FavDaoTest {

    @Test
    public void getList() {

        List<Favorite> favlis = new FavoriteDao().getFavoritesByUser(new User() {
            {
                setUid(12);
            }
        });
        for (Favorite fav : favlis) {
            System.out.println(fav.toString());
        }
    }
}
