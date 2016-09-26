package cn.zjc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangjinci
 * @version 2016/9/13 16:12
 * @function
 */
@Entity
@Table(name = "TB_AT_USER")
public class User implements Serializable {

    @Id
    private Integer id;
	@Column
	private Integer userId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "BIRTH")
    private Date birth;
    @Column(name = "EMAIL")
    private String email;

    public User() {
    }


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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userId=" + userId +
				", name='" + name + '\'' +
				", birth=" + birth +
				", email='" + email + '\'' +
				'}';
	}
}
