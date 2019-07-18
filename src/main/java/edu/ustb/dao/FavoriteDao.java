package edu.ustb.dao;

import java.util.List;

import edu.ustb.domain.Favorite;
import edu.ustb.domain.User;

/**
 * FavorateDao
 */
public interface FavoriteDao {

    /**
     * 单个用户的所有收藏线路
     * @param user
     * @return
     */
    public List<Favorite> getFavoritesByUser(User user);

    /**
     * 该用户是否对某一条线路添加收藏
     * @param uid
     * @param rid
     * @return
     */
    public Favorite getFavorited(int uid, int rid);

    /**
     * 添加收藏
     * @param uid
     * @param rid
     * @return
     */
    public int addFavorited(int uid, int rid);

    /**
     * 根据rid查询该线路的收藏次数
     * 
     * @param rid
     * @return
     */
    public int findCountByRid(int rid);
}
