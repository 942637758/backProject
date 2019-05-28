package org.bachelor.architecture.eureka.dao;

import org.bachelor.architecture.eureka.domain.UserInfo;
import org.bachelor.architecture.eureka.vo.UserInfoVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserInfoMapper extends Mapper<UserInfo> {

  List<UserInfoVO> selectAllUserInfoVO();
}
