package com.lw.mvc.core.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.lw.mvc.core.entity.BaseEntity;
import com.lw.mvc.core.exceptions.BizException;

/**
 * @title :
 * @description :
 * @time: 2017-11-01 17:57:43
 * @author irays
 * @email irayslu@163.com
 * @version 0.0.6
 * @since JDK 1.7
 */
public abstract class AbstractBaseDaoImpl<T extends BaseEntity> extends SqlSessionDaoSupport implements BaseDao<T> {

	protected static final Logger log = LoggerFactory.getLogger(AbstractBaseDaoImpl.class);

	/**
	 * 单个插入
	 */
	public static final String SQL_INSERT = "insert";
	/**
	 * 批量插入
	 */
	public static final String SQL_BATCH_INSERT = "batchInsert";
	/**
	 * 更新
	 */
	public static final String SQL_UPDATE = "update";
	/**
	 * 根据id获取
	 */
	public static final String SQL_SELECT_BY_ID = "selectById";
	/**
	 * 根据id删除
	 */
	public static final String SQL_DELETE_BY_ID = "deleteById";
	/**
	 * 分页获取数据
	 */
	public static final String SQL_LIST_PAGE = "listPage";
	/**
	 * 根据
	 */
	public static final String SQL_LIST_BY = "listBy";

	/**
	 * 注入SqlSessionTemplate实例(要求Spring中进行SqlSessionTemplate的配置)
	 * 可以调用sessionTemplate完成数据库操作.
	 */
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	protected SqlSessionFactory sqlSessionFactory;

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	@Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

	@Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
    

	@Override
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	@Override
	public SqlSession getSqlSession() {
		return super.getSqlSession();
	}


	public DataSource getDataSource() {
		return dataSource;
	}

	public String spliceStatement(String sqlId) {

		String name = this.getClass().getName();

		StringBuffer sb = new StringBuffer().append(name).append(".").append(sqlId);

		return sb.toString();
	}
	
	@Override
	public long insert(T t) {

		/**
		 * 持久化实体不能为null
		 */
		if (null == t) {
			throw new RuntimeException("T is null");
		}
		if (null == sqlSessionTemplate) {
			throw new RuntimeException("sqlSessionTemplate is null");
		}
		
		//初始化数据
		if(t instanceof BaseEntity){
			BaseEntity baseEntity = (BaseEntity)t;
			baseEntity.setGmtCreate(new Date());
			baseEntity.setVersion(0L);
		}
		
		int result = sqlSessionTemplate.insert(spliceStatement(SQL_INSERT), t);

		if (result <= 0) {
			throw BizException.STORAGE_INSERT_RESULT_0;
		}

		if (null != t && null != t.getId() && result > 0) {
			return t.getId();
		}

		return result;
	}
	
	@Override
	public long insert(List<T> list) {

		if (null == list || list.size() <= 0) {
			return 0;
		}

		int result = sqlSessionTemplate.insert(spliceStatement(SQL_BATCH_INSERT), list);

		if (result <= 0) {
			throw BizException.STORAGE_INSERT_RESULT_0;
		}

		return result;
	}
	
	@Override
	public long update(T t) {
		if (null == t){
			throw new RuntimeException("T is null");
		}
		
		int result = sqlSessionTemplate.update(spliceStatement(SQL_UPDATE), t);

		if (result <= 0){
			throw BizException.STORAGE_UPDATE_RESULT_0;
		}

		return result;
	}
	@Override
	public long update(List<T> list) {

		if (list == null || list.size() <= 0){
			return 0;
		}

		int result = 0;

		for (int i = 0; i < list.size(); i++) {
			this.update(list.get(i));
			result += 1;
		}

		if (result <= 0){
			throw BizException.STORAGE_UPDATE_RESULT_0;
		}

		return result;
	}
	
	@Override
	public T selectById(long id) {
		return sqlSessionTemplate.selectOne(spliceStatement(SQL_SELECT_BY_ID), id);
	}
	
	@Override
	public long deleteById(long id) {
		return (long) sqlSessionTemplate.delete(spliceStatement(SQL_DELETE_BY_ID), id);
	}
	
	@Override
	public List<T> listPage(int pageNum, int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<T> listPage = sqlSessionTemplate.selectList(spliceStatement(SQL_LIST_PAGE));
		return listPage;
	}
	
	@Override
	public String getSeqNextValue(String seqName){
		return null;
	}
	
	

}
