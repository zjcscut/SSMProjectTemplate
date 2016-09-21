package cn.zjc.dao;

import cn.zjc.entity.User;
import java.util.List;

/**
 * @author zhangjinci
 * @version 2016/9/21 11:51
 * @function 手工mapper
 */

public interface MutualEvaluationMapper {

    boolean insertCrossEvaluation(List<User> users);
}
