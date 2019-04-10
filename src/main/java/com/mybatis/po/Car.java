package com.mybatis.po;

/**
 * Package: com.mybatis.po
 * DESCRIPTION:
 *
 * @author guxiu2008
 * @create 2019-04-10 21:59
 **/
public class Car {
    private String id;
    private String brand;
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

}
