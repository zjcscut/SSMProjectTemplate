package cn.zjc.dao;

import cn.zjc.entity.User;
import cn.zjc.mapper.AbstractCustomMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangjinci
 * @version 2016/9/13 16:16
 * @function
 */
@Repository
public interface UserMapper extends AbstractCustomMapper<User> {

    User selectById(@Param("id") Integer id);

    List<User> selectAll();

}
