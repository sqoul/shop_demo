package com.hzit.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzit.demo.model.OrderInfo;
import com.hzit.demo.model.SeckillGoods;
import com.hzit.demo.model.SeckillGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeckillGoodsMapper extends BaseMapper<SeckillGoods> {
    long countByExample(SeckillGoodsExample example);

    int deleteByExample(SeckillGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SeckillGoods record);

    int insertSelective(SeckillGoods record);

    List<SeckillGoods> selectByExample(SeckillGoodsExample example);

    SeckillGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SeckillGoods record, @Param("example") SeckillGoodsExample example);

    int updateByExample(@Param("record") SeckillGoods record, @Param("example") SeckillGoodsExample example);

    int updateByPrimaryKeySelective(SeckillGoods record);

    int updateByPrimaryKey(SeckillGoods record);
}