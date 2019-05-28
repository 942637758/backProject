package org.bachelor.architecture.eureka.vo;

import java.util.Date;

/**
 * @ClassName UserInfoVO
 * @Description: 用户涉密信息，如密码等字段不能回显到用户页面
 * @Author Alexhendar
 * @Date 2018/10/9 16:06
 * @Version 1.0
 **/
public class UserInfoVO {
  private Long id;
  private String userName;
  private String userType;
  private Integer enabled;
  private String realName;
  private String qq;
  private String email;
  private String address;
  private String tel;

  private Date birthday = new Date();

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public Integer getEnabled() {
    return enabled;
  }

  public void setEnabled(Integer enabled) {
    this.enabled = enabled;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }
}
