package org.bachelor.architecture.eureka.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.bachelor.core.exception.BusinessException;
import org.bachelor.core.exception.SystemException;
import org.bachelor.architecture.eureka.domain.UserInfo;
import org.bachelor.architecture.eureka.service.UserInfoService;
import org.bachelor.architecture.eureka.vo.UserInfoVO;
import org.bachelor.web.json.JsonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Description: 用户管理接口: 添加用户 修改用户信息 删除指定的用户 查询指定用户 查询用户列表
 *
 * @Author Alexhendar
 * @Date: Created in 2018/10/9 15:55
 * @Modified By:
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/userinfo/")
public class UserInfomationController {

  private static final Logger logger = LoggerFactory.getLogger(UserInfomationController.class);

  @Autowired
  UserInfoService userInfoService;

  /**
   * <p>
   * findUserListByPage : 查询用户列表，@ApiImplicitParams为示例，实际分页由bachelor处理
   * </p>
   *
   * @Auther: Alexhendar
   * @Date: 2018/10/19 17:08
   * @param
   * @return ResponseEntity<JsonResponse>
   */
  @ApiOperation(value = "用户列表查询", notes = "查询用户列表，分页使用start,page参数")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "start", value = "分页当前页码", paramType = "query", required = false,
          dataType = "Integer"),
      @ApiImplicitParam(name = "page", value = "每个分页元素个数", paramType = "query", required = false,
          dataType = "Integer")})
  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public ResponseEntity<JsonResponse> findUserListByPage(@RequestParam int pageNum, @RequestParam int pageSize) {

    PageHelper.startPage(pageNum, pageSize);
    PageInfo<UserInfoVO> pageInfo = userInfoService.selectAllByPage();
    return JsonResponse.createHttpEntity(pageInfo, HttpStatus.OK);
  }

  /**
   * <p>
   * findUserById : 根据用户ID查询指定用户
   * </p>
   *
   * @Auther: Alexhendar
   * @Date: 2018/10/19 17:10
   * @param userid
   * @return ResponseEntity
   */
  @ApiOperation(value = "根据用户ID查询指定用户")
  @ApiImplicitParam(name = "userid", value = "userid", paramType = "path", required = true)
  @RequestMapping(value = "/user/{userid}", method = RequestMethod.GET)
  public ResponseEntity<JsonResponse> findUserById(@PathVariable("userid") Long userid) {

    UserInfo userInfo = userInfoService.selectByPrimaryKey(userid);
    UserInfoVO userInfoVO = new UserInfoVO();
    if (userInfo != null) {
      try {
        BeanUtils.copyProperties(userInfoVO, userInfo);
      } catch (Exception e) {
        // 数据转换异常处理，向上抛出异常
        throw new SystemException(e);
      }
      return JsonResponse.createHttpEntity(userInfoVO, HttpStatus.OK);
    } else {
      // 业务异常，用户不存在
//      throw new BusinessException("user with that userid not exist");
      return JsonResponse.createHttpEntity(userInfoVO, HttpStatus.NO_CONTENT);
    }
//    return JsonResponse.createHttpEntity(userInfoVO, HttpStatus.NO_CONTENT);
  }

  /**
   * <p>
   * addUserInfo : 新增用户
   * </p>
   *
   * @Auther: Alexhendar
   * @Date: 2018/10/19 17:11
   * @param userInfo
   * @return ResponseEntity
   */
  @ApiOperation(value = "新增用户")
  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public ResponseEntity<JsonResponse> addUserInfo(@RequestBody UserInfo userInfo) {
    // 新增操作，日志记录
    logger.info("add user with {} : ",
        ReflectionToStringBuilder.toString(userInfo, ToStringStyle.SHORT_PREFIX_STYLE));

    int res = userInfoService.insert(userInfo);
    if (res == 1) {
      return JsonResponse.createHttpEntity(HttpStatus.OK);
    } else {
      // 插入用户失败
      return JsonResponse.createHttpEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * <p>
   * updateUserInfo : 修改用户信息 根据主键更新实体全部字段，所有属性值都需要在userInfo中，没有设置的，null值也会更新到数据库
   * </p>
   *
   * @Auther: Alexhendar
   * @Date: 2018/10/19 17:11
   * @param userInfo
   * @return ResponseEntity
   */
  @ApiOperation(value = "修改用户信息", notes = "根据主键更新实体全部字段，所有属性值都需要在userInfo中，没有设置的，null值不会更新到数据库")
  @RequestMapping(value = "/user", method = RequestMethod.PUT)
  public ResponseEntity<JsonResponse> updateUserInfo(@RequestBody UserInfo userInfo) {
    // 修改操作，日志记录
    logger.info("update user with {} : ",
        ReflectionToStringBuilder.toString(userInfo, ToStringStyle.SHORT_PREFIX_STYLE));
    int res = userInfoService.update(userInfo);
    if (res == 1) {
      return JsonResponse.createHttpEntity(HttpStatus.OK);
    } else {
      // 修改用户信息失败
      return JsonResponse.createHttpEntity(HttpStatus.NOT_FOUND);
    }
  }


  /**
   * <p>
   * deleteUserInfo : 删除指定的用户
   * </p>
   *
   * @Auther: Alexhendar
   * @Date: 2018/10/19 17:12
   * @param userid
   * @return ResponseEntity
   */
  @ApiOperation(value = "删除指定的用户", notes = "根据主键删除指定的用户")
  @ApiImplicitParam(name = "userid", value = "userid", paramType = "path", required = true)
  @RequestMapping(value = "/user/{userid}", method = RequestMethod.DELETE)
  public ResponseEntity<JsonResponse> deleteUserInfo(@PathVariable("userid") Long userid) {
    // 删除操作，日志记录
    logger.info("delete user {} : ", userid);
    int res = userInfoService.deleteByPrimaryKey(userid);
    if (res == 1) {
      return JsonResponse.createHttpEntity(HttpStatus.OK);
    } else {
      // 删除指定用户失败
      return JsonResponse.createHttpEntity(HttpStatus.NOT_FOUND);
    }
  }
}
