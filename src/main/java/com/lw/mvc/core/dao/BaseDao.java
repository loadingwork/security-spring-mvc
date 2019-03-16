package com.lw.mvc.core.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;


/**
 * @title : 数据访问层基础支撑接口
 * @description : 
 * @time: 2017-11-01 17:58:06 
 * @author irays
 * @email  irayslu@163.com 
 * @version 0.0.5
 * @since JDK 1.7
 */
public interface BaseDao<T> {

	/**
	 * 根据实体对象新增记录.
	 * 
	 * @param entity
	 *            .
	 * @return id .
	 */
	long insert(T entity);

	/**
	 * 批量插入
	 * @param list
	 * @return
	 */
	long insert(List<T> list);

	/**
	 * 更新实体对应的记录.
	 * 
	 * @param entity
	 *            .
	 * @return
	 */
	long update(T entity);

	/**
	 * 批量更新对象
	 * @param list
	 * @return
	 */
	long update(List<T> list);

	/**
	 * 根据ID查找记录
	 * @param id
	 * @return
	 */
	T selectById(long id);

	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	long deleteById(long id);
	
	/**
	 * 分页获取所有的记录
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	List<T> listPage(int pageNum, int pageSize);

	/**
	 * 根据序列名称获取下一个值
	 * @param seqName
	 * @return
	 */
	String getSeqNextValue(String seqName);
	/**
	 * 获取session TEMPLATE
	 * @return
	 */
	SqlSessionTemplate getSqlSessionTemplate();
	/**
	 * 获取session
	 * @return
	 */
	SqlSession getSqlSession();

}
