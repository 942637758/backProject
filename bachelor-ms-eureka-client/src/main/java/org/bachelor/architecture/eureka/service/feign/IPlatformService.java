package org.bachelor.architecture.eureka.service.feign;

import org.bachelor.baseservice.controller.mapping.IPlatformController;
import org.bachelor.baseservice.vo.PlatformVO;
import org.bachelor.web.json.JsonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: IPlatformService，封装了对base-server中platform模块的接口调用
 * @Author Alexhendar
 * @Date: Created in 2018/10/19 17:18
 * @Modified By:
 *
 */
@FeignClient(name = "base-service", fallback = PlatformServiceFallback.class)
public interface IPlatformService extends IPlatformController {
}


@Component
class PlatformServiceFallback implements IPlatformService {
  private static final Logger logger = LoggerFactory.getLogger(PlatformServiceFallback.class);

  /**
   * <p>listAllPlatforom :  查询平台列表</p>
   * @Auther: Alexhendar
   * @Date: 2018/10/19 17:20
   * @param
   * @return ResponseEntity<JsonResponse>
   */
  @Override
  public ResponseEntity<JsonResponse> listAllPlatforom() {
    logger.error("PlatformService fallback error occured! ");
    List<PlatformVO> platformVOList = new ArrayList<PlatformVO>();
    PlatformVO platformVO = new PlatformVO();
    platformVO.setName("默认平台名(演示用)");
    platformVO.setOsName("CentOS 7");
    platformVOList.add(platformVO);
    return JsonResponse.createHttpEntity(platformVOList, HttpStatus.OK);
  }
}
