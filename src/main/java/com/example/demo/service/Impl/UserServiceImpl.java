package com.example.demo.service.Impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.domain.UserDO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
     UserMapper userMapper;

	@Override
	public int login(String username,String password) {
		return userMapper.login(username,password);
	}

	@Override
	public UserDO get(Long userId){
		return userMapper.get(userId);
	}
	
	@Override
	public List<UserDO> list(Map<String, Object> map){
		return userMapper.list(map);
	}

	@Override
	public List<UserDO> listByDepartment(Map<String, Object> map){
		return userMapper.listByDepartment(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userMapper.count(map);
	}


	@Transactional
	@Override
	public int save(UserDO sysUser) {
	//	System.out.println("sysUser1:"+sysUser.getUserId()+" "+sysUser.getUsername()+" "+sysUser.getRoleIds());
		int count = userMapper.save(sysUser);
		return count;
	}
	@Override
	public int update(UserDO sysUser){
		return userMapper.update(sysUser);
	}
	
	@Override
	public int remove(Long userId){
		return userMapper.remove(userId);
	}
	@Override
	public int removeSale(Long userId){
		return userMapper.removeSale(userId);
	}
	
	@Override
	public int batchRemove(Long[] userIds){
		return userMapper.batchRemove(userIds);
	}
	
}
