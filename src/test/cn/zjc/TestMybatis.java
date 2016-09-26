package cn.zjc;

import cn.zjc.entity.User;
import cn.zjc.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;

import java.util.List;

/**
 * @author zhangjinci
 * @version 2016/9/13 16:39
 * @function
 */
public class TestMybatis extends Basic {

    @Autowired
    private UserService userService;

    @Test
    public void Test1() {
        User u = userService.findUser(1);
        System.out.println("result==>" + u);
    }

    @Test
    public void Test2() {
        List<User> users = userService.findAllUser(1, 2).getList();
        assertEquals(2,users.size());
    }

    @Test
	public void Test3(){
		userService.batchInsertUsers();
	}
}
