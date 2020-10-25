package com.hzit.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzit.demo.model.SeckillGoods;
import com.hzit.demo.model.SeckillOrder;
import com.hzit.demo.model.SeckillOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeckillOrderMapper extends BaseMapper<SeckillOrder> {
    long countByExample(SeckillOrderExample example);

    int deleteByExample(SeckillOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SeckillOrder record);

    int insertSelective(SeckillOrder record);

    List<SeckillOrder> selectByExample(SeckillOrderExample example);

    SeckillOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SeckillOrder record, @Param("example") SeckillOrderExample example);

    int updateByExample(@Param("record") SeckillOrder record, @Param("example") SeckillOrderExample example);

    int updateByPrimaryKeySelective(SeckillOrder record);

    int updateByPrimaryKey(SeckillOrder record);
}