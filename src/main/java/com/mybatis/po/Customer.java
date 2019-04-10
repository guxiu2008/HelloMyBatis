package com.mybatis.po;

import java.util.List;

/**
 * Package: com.mybatis.po
 * DESCRIPTION:对应数据库中的t_customer表
 *
 * @author guxiu2008
 * @create 2019-02-12 22:02
 **/
public class Customer {
    private Integer id;
    private String username;
    private String jobs;
    private String phone;
    private List<Car> cars;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", jobs='" + jobs + '\'' +
                ", phone='" + phone + '\'' +
                ", cars=" + cars +
                '}';
    }
}
