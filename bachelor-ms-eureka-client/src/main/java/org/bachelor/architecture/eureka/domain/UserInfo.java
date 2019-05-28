package org.bachelor.architecture.eureka.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user_info")
public class UserInfo {
  @Id
  private Long id;

  /**
   * 用户名
   */
  @Column(name = "user_name")
  private String userName;

  /**
   * 密码
   */
  private String password;

  /**
   * 用户类型
   */
  @Column(name = "user_type")
  private String userType;

  private Integer enabled;

  @Column(name = "real_name")
  private String realName;

  private String qq;

  private String email;

  private String address;

  private String tel;

  /**
   * @return id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 获取用户名
   *
   * @return user_name - 用户名
   */
  public String getUserName() {
    return userName;
  }

  /**
   * 设置用户名
   *
   * @param userName 用户名
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * 获取密码
   *
   * @return password - 密码
   */
  public String getPassword() {
    return password;
  }

  /**
   * 设置密码
   *
   * @param password 密码
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * 获取用户类型
   *
   * @return user_type - 用户类型
   */
  public String getUserType() {
    return userType;
  }

  /**
   * 设置用户类型
   *
   * @param userType 用户类型
   */
  public void setUserType(String userType) {
    this.userType = userType;
  }

  /**
   * @return enabled
   */
  public Integer getEnabled() {
    return enabled;
  }

  /**
   * @param enabled
   */
  public void setEnabled(Integer enabled) {
    this.enabled = enabled;
  }

  /**
   * @return real_name
   */
  public String getRealName() {
    return realName;
  }

  /**
   * @param realName
   */
  public void setRealName(String realName) {
    this.realName = realName;
  }

  /**
   * @return qq
   */
  public String getQq() {
    return qq;
  }

  /**
   * @param qq
   */
  public void setQq(String qq) {
    this.qq = qq;
  }

  /**
   * @return email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return tel
   */
  public String getTel() {
    return tel;
  }

  /**
   * @param tel
   */
  public void setTel(String tel) {
    this.tel = tel;
  }
}
