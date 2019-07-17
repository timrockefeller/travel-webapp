package edu.ustb.service;

import java.util.List;

import edu.ustb.domain.Favorite;
import edu.ustb.domain.User;

/**
 * FavoriteService
 * 
 * @param 
 */
public interface FavoriteService {

    /**
     * 根据在session中保存的user Param 去从数据库中查找所有该用户收藏的Routes
     * @param User
     * @return Favorite数组，(1)在test中User只有Uid值，其余都为null (2)User为 从session Object化的数据
     */
    public List<Favorite> getFavoritesByUser(User user);

    /**
     * 查询该用户是否收藏Route
     * @param user
     * @param rid
     * @return (1)True if have count in tab_fav table,False if not (2)False if Error occured
     */
    public boolean isFavorite(User user, int rid);
}
