
package dao;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import edu.ustb.dao.FavoriteDao;
import edu.ustb.dao.impl.FavoriteDaoImpl;
import edu.ustb.domain.Favorite;
import edu.ustb.domain.User;

/**
 * FavDaoTest
 */
public class FavDaoTest {

    public void getList() {

        List<Favorite> favlis = new FavoriteDaoImpl().getFavoritesByUser(new User() {
            {
                setUid(12);
            }
        });
        // for (Favorite fav : favlis) {
        // System.out.println(fav.toString());
        // }
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(favlis);

            System.out.println(json);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
