package com.dao;

import com.entity.ShangjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangjiaView;

/**
 * 农家乐商家 Dao 接口
 *
 * @author 
 */
public interface ShangjiaDao extends BaseMapper<ShangjiaEntity> {

   List<ShangjiaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
