package com.ppdai.demo.数据迁移性能优化.dao;

import com.ppdai.demo.数据迁移性能优化.entity.BatchUserList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by huanglijun on 2017/12/26.
 */
@Mapper
public interface BatchUserListDao {
    List<BatchUserList> selectAll();

    int batchInsert(List<BatchUserList> list);
}