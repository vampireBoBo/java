package entity;

import java.io.Serializable;
/**
 * 学生实体对象
 * @author Administrator
 *
 */
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 158408172856062733L;
	private String no; // 学号
	private String name; // 姓名
	private String gender; // 性别
	private int age; // 年龄
	private String phone; // 电话
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
