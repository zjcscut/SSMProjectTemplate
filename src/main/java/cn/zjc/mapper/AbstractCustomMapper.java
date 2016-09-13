package cn.zjc.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author zhangjinci
 * @version 2016/9/13 16:17
 * @function 抽象Mapper,用于整合通用mapper的功能
 */
public interface AbstractCustomMapper<T> extends MySqlMapper<T>, Mapper<T> {
}
