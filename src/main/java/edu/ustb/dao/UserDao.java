package edu.ustb.dao;

import edu.ustb.domain.User;

public interface UserDao {
	 /**
     * 用户保存
     * @param user
     */
    public int add(User user);
    
   User findByUserName(String userName);
   
 }
