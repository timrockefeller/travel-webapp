package edu.ustb.service.impl;

import edu.ustb.dao.UserDao;
import edu.ustb.dao.impl.UserDaoImpl;
import edu.ustb.domain.User;
import edu.ustb.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	   

	@Override
	public boolean regist(User user) {
		User tempUser=userDao.findByUserName(user.getUsername());
		if(tempUser!=null){
			return false;
		}
		return	userDao.add(user)>0;
	}

}
