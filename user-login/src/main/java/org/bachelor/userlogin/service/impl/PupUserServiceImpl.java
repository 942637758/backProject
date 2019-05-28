package org.bachelor.userlogin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

@Service
public class PupUserServiceImpl {

  @Autowired
  protected StringRedisTemplate redisTemplate;

  // 设置1天有效时间
  private long timeout = 1;
  private String delPrefix = "del_";

  /**
   * 解析token,存入redis,并设置ttl
   *
   * @param accesstoken
   */
  public void logout(String accesstoken) {
    if(!StringUtils.isEmpty(accesstoken)){
      redisTemplate.opsForValue().set(delPrefix + accesstoken, "LO", timeout, TimeUnit.DAYS);
    }
  }
}
