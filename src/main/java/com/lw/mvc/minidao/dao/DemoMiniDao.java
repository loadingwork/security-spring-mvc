package com.lw.mvc.minidao.dao;

import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import com.lw.mvc.domain.po.DemoMiniDaoPO;

/**
 * DemoMiniDao 持久化接口
 * @author root
 *
 */
@Repository
public interface DemoMiniDao {
	
	
	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	@Sql("select * from demo_mini_dao where id = :id")
	DemoMiniDaoPO get(@Param("id") Integer id);
	
	/**
     * 插入数据 【SQL文件】
     * @param demoMiniDaoPO
     */
    void insert(@Param("demoMiniDaoPO") DemoMiniDaoPO demoMiniDaoPO);

}
