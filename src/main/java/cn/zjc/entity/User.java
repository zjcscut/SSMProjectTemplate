package cn.zjc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "BIRTH")
    private Date birth;
    @Column(name = "EMAIL")
    private String email;

    public User() {
    }

    public User(Integer id, String name, Date birth, String email) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.email = email;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", email='" + email + '\'' +
                '}';
    }
}
