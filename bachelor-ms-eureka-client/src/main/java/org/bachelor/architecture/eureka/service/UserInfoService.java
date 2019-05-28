package org.bachelor.architecture.eureka.service;

import com.github.pagehelper.PageInfo;
import org.bachelor.architecture.eureka.dao.UserInfoMapper;
import org.bachelor.architecture.eureka.domain.UserInfo;
import org.bachelor.architecture.eureka.vo.UserInfoVO;
import org.bachelor.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: 用户管理服务
 * @Author Alexhendar
 * @Date: Created in 2018/10/19 17:16
 * @Modified By:
 */
@Service
public class UserInfoService extends BaseService<UserInfo> {

  @Autowired
  UserInfoMapper userInfoMapper;
  /**
   * <p>selectAllByPage :  查询用户列表</p>
   * @Auther: Alexhendar
   * @Date: 2018/10/19 17:17
   * @param
   * @return PageInfo
   */
  public PageInfo<UserInfoVO> selectAllByPage() {
    List<UserInfoVO> userInfoList = userInfoMapper.selectAllUserInfoVO();
    PageInfo<UserInfoVO> userInfoPage = new PageInfo<>(userInfoList);
    return userInfoPage;
  }
}
