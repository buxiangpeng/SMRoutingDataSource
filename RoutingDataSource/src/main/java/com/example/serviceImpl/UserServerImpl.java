package com.example.serviceImpl;

import java.util.List;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.base.BaseServiceImpl;
import com.example.common.DataSourceType;
import com.example.controller.TestController;
import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.UserServer;
import com.example.util.MyDataSource;

@Service
public class UserServerImpl extends BaseServiceImpl<User,UserDao> implements UserServer{

	private static Logger log = LoggerFactory.getLogger(UserServerImpl.class);
	
	@Resource
	private UserDao userDao;
	
	@MyDataSource(DataSourceType.READ)
	public List<User> getRead() {
		log.info("业务处理层  getRead");
		return baseDao.findAll();
	}
	
	@MyDataSource(DataSourceType.WRITE)
	public List<User> getWrite() {
		log.info("业务处理层  getWrite");
		return baseDao.findAll();
	}
}
