package cn.zjc.dao.impl;

import cn.zjc.dao.MutualEvaluationMapper;
import cn.zjc.entity.User;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangjinci
 * @version 2016/9/21 11:51
 * @function 手工批量操作mapper
 */
@Repository
public class MutualEvaluationMapperImpl implements MutualEvaluationMapper {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    @Override
    public boolean insertCrossEvaluation(List<User> users) {
        long start = System.currentTimeMillis();
        int result = 1;
        SqlSession batchSqlSession = null;
        try {
            batchSqlSession = getSqlSessionTemplate()
                    .getSqlSessionFactory()
                    .openSession(ExecutorType.BATCH, false);
            int batchCount = 1000; //每次提交1000条
            int batchLastIndex = batchCount;
            int batchSize = users.size();
            for (int index = 0; index < batchSize; ) {

                if (batchLastIndex >= batchSize) {
                    batchLastIndex = batchSize;
                    result = result * batchSqlSession.insert("cn.zjc.dao.MutualEvaluationMapper.insertCrossEvaluation", users.subList(index, batchLastIndex));
                    batchSqlSession.commit();
                    System.out.println("index:" + index + " batchLastIndex:" + batchLastIndex);
                    break;// 数据插入完毕，退出循环
                } else {
                    result = result * batchSqlSession.insert("cn.zjc.dao.MutualEvaluationMapper.insertCrossEvaluation", users.subList(index, batchLastIndex));
                    batchSqlSession.commit();
                    System.out.println("index:" + index + " batchLastIndex:" + batchLastIndex);
                    index = batchLastIndex;// 设置下一批下标
                    batchLastIndex = index + (batchCount - 1);
                }
            }
            batchSqlSession.commit();
        } finally {
            if (batchSqlSession != null) {
                batchSqlSession.close();
            }
        }
        System.out.println("....cost time:" + (System.currentTimeMillis() - start) / 1000 + "s");
        return result > 0;
    }
}
