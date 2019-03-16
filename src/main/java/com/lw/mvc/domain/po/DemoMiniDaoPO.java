package com.lw.mvc.domain.po;

/**
 * 测试持久化对象
 * 
 * @author root
 *
 */
public class DemoMiniDaoPO {

	/**
	 * 注解
	 */
	private Integer id;

	/**
	 * 名称
	 */
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DemoMiniDaoPO [id=" + id + ", name=" + name + "]";
	}
	

}
