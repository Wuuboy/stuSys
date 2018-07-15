package edu.hnust.stu.bean;

import java.util.Date;

import javax.validation.constraints.Pattern;

public class Student {
    private Integer id;

    @Pattern(regexp="(^[a-zA-Z0-9_-]{3,6}$)|(^[\u2E80-\u9FFF]{2,5})"
    		,message="用户名必须是2-5位中文或者6-16位英文和数字的组合")
    private String name;

    private String sex;

    private Date birth;

    private Double java;

    private Double math;

    private Double english;

    private Double pe;

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
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date dateString) {
        this.birth = dateString;
    }

    public Double getJava() {
        return java;
    }

    public void setJava(Double java) {
        this.java = java;
    }

    public Double getMath() {
        return math;
    }

    public void setMath(Double math) {
        this.math = math;
    }

    public Double getEnglish() {
        return english;
    }

    public void setEnglish(Double english) {
        this.english = english;
    }

    public Double getPe() {
        return pe;
    }

    public void setPe(Double pe) {
        this.pe = pe;
    }

	public Student(Integer id, String name, String sex, Date birth, Double java, Double math, Double english,
			Double pe) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.java = java;
		this.math = math;
		this.english = english;
		this.pe = pe;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", birth=" + birth + ", java=" + java
				+ ", math=" + math + ", english=" + english + ", pe=" + pe + "]";
	}
	
	
    
}