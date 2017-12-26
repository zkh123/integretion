package com.ppdai.demo.数据迁移性能优化.dao;

import com.ppdai.demo.数据迁移性能优化.entity.IKUserList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by huanglijun on 2017/12/26.
 */
@Mapper
public interface IKUserListDao {
    List<IKUserList> selectAll();

    int getCount(@Param(value = "insertTime")String insertTime);

    int init(IKUserList ikUserList);

    int batchInit(List<IKUserList> list);
}