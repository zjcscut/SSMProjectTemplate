package cn.zjc.service;

import cn.zjc.dao.MutualEvaluationMapper;
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

    @Autowired
    private MutualEvaluationMapper mutualEvaluationMapper;

    public User findUser(Integer id) {
        return userMapper.selectById(id);
    }

    public PageBean<User> findAllUser(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageBean<>(userMapper.selectAll());
    }

    public boolean batchInsertUsers() {
        List<User> list = new ArrayList<>(600000);
        for (int i = 0; i < 600000; i++) {
            list.add(new User(i / 60000, "user" + (i / 60000), new Date(), (i / 60000) + "@163.com"));
        }
        return mutualEvaluationMapper.insertCrossEvaluation(list);
    }

}
