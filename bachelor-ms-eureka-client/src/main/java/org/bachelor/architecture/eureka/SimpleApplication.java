package org.bachelor.architecture.eureka;

import org.bachelor.core.exception.BusinessException;
import org.bachelor.core.exception.RemoteException;
import org.bachelor.core.exception.SystemException;
import org.bachelor.web.json.JsonResponse;
import org.bachelor.web.json.ResponseStatus;
import org.bachelor.web.message.MessageUtil;
import org.bachelor.web.springmvc.BaseController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tk.mybatis.spring.annotation.MapperScan;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuzhuo on 2018/9/14.
 */
@SpringBootApplication(scanBasePackages = {"org.bachelor"})
@EnableCircuitBreaker // 开启断路器功能
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("org.bachelor.architecture.eureka.dao")
public class SimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleApplication.class, args);
    }

//    @Value("${server.port}")
//    String port;
//
//    @RequestMapping("/hi/{name}")
//    public ResponseEntity<JsonResponse> home(@PathVariable String name) {
//
//        Map<String,String> map = new HashMap<>();
//        map.put("value1", name);
//        map.put("value2", name);
//        return JsonResponse.createHttpEntity(map, HttpStatus.OK);
//    }
//
//    @RequestMapping("/err/{type}")
//    public ResponseEntity<JsonResponse> err(@PathVariable String type) {
//
//        if ("1".equals(type)){
//            throw new SystemException("测试系统异常");
//        } else if ("2".equals(type)){
//            throw new BusinessException("测试业务异常");
//        } else if ("3".equals(type)){
//            throw new RemoteException("测试远程调用");
//        } else {
//
//        }
//
//        return JsonResponse.createHttpEntity(null, HttpStatus.OK);
//    }
}
