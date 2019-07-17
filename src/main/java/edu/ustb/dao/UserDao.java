package edu.ustb.dao;

import edu.ustb.domain.User;

public interface UserDao {

    /**
     * 用户保存
     * 
     * @param user
     */
    public void save(User user);

    /**
     * 根据用户名查询用户信息
     * 
     * @param username
     * @return
     */

    User findByUserName(String userName);

    User findByCode(String code);

    void updateStatus(User user);
    User findByUsernameAndPassword(String username, String password);

}
