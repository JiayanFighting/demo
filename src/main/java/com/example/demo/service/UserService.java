package com.example.demo.service;

import com.example.demo.domain.UserDO;
import java.util.List;
import java.util.Map;


public interface UserService {

	int login(String username,String password);
	UserDO get(Long userId);

	List<UserDO> list(Map<String, Object> map);
	List<UserDO> listByDepartment(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(UserDO sysUser);
	
	int update(UserDO sysUser);
	
	int remove(Long userId);
	int removeSale(Long userId);
	int batchRemove(Long[] userIds);
}
