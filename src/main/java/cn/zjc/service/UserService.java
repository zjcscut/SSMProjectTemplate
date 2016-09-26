package cn.zjc.service;

import cn.zjc.dao.UserMapper;
import cn.zjc.entity.User;
import cn.zjc.utils.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangjinci
 * @version 2016/9/13 16:34
 * @function
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public User findUser(Integer id) {
		return userMapper.selectById(id);
	}

	public PageBean<User> findAllUser(Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		return new PageBean<>(userMapper.selectAll());
	}

	public void batchInsertUsers() {
		int i;
		List<User> users = new ArrayList<>(600000);
		for (i = 0; i < 600000; i++) {
			User u = new User();
			u.setName("用户" + (i / 50000));
			u.setUserId(i / 50000);
			u.setBirth(new Date());
			u.setEmail((i / 50000) + "@163.com");
			users.add(u);
		}
		userMapper.batchInsert(users);

	}
}
