package cn.zjc.service;

import cn.zjc.dao.UserMapper;
import cn.zjc.entity.User;
import cn.zjc.utils.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
