package com.cristik.modules.test.entity.svo;

import javax.persistence.*;
import java.util.Date;

@Table(name="visitor")
public class Visitor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String userName;
    @Column
    private Integer userImage;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private Integer age;
    @Column
    private Integer imgIdentify;
    @Column
    private String identifyNumber;
    @Column
    private String birthday;
    @Column
    private String sex;
    @Column
    private String country;
    @Column
    private String province;
    @Column
    private String city;
    @Column
    private String location;
    @Column
    private String qq;
    @Column
    private String weixin;
    @Column
    private String contactName;
    @Column
    private String contactNumber;
    @Column
    private Integer status;//1正常2禁用
    @Column
    private Date createTime;
    @Column
    private Date updateTime;

    public Visitor(Integer id, String name, String userName, Integer userImage, String email, String phone, Integer age, Integer imgIdentify, String identifyNumber, String birthday, String sex, String country, String province, String city, String location, String qq, String weixin, String contactName, String contactNumber, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.userImage = userImage;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.imgIdentify = imgIdentify;
        this.identifyNumber = identifyNumber;
        this.birthday = birthday;
        this.sex = sex;
        this.country = country;
        this.province = province;
        this.city = city;
        this.location = location;
        this.qq = qq;
        this.weixin = weixin;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Visitor() {
        super();
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserImage() {
        return userImage;
    }

    public void setUserImage(Integer userImage) {
        this.userImage = userImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getImgIdentify() {
        return imgIdentify;
    }

    public void setImgIdentify(Integer imgIdentify) {
        this.imgIdentify = imgIdentify;
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", userImage=" + userImage +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", imgIdentify=" + imgIdentify +
                ", identifyNumber='" + identifyNumber + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sex='" + sex + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", location='" + location + '\'' +
                ", qq='" + qq + '\'' +
                ", weixin='" + weixin + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}