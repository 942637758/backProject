package org.bachelor.userlogin;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.jwt.crypto.sign.RsaSigner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
@SpringBootApplication(scanBasePackages = {"org.bachelor"},exclude = {DataSourceAutoConfiguration.class})
public class UserLoginApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserLoginApplication.class, args);
  }
  @Bean
  public RsaSigner jwtSigner() {
    String privateKey = StringUtils.EMPTY;
    try {
      InputStream ips = UserLoginApplication.class.getResourceAsStream("/id_rsa");
      InputStreamReader reader = new InputStreamReader(ips);
      StringBuffer buffer = new StringBuffer();
      int tmp;
      while ((tmp = reader.read()) != -1) {
        buffer.append((char) tmp);
      }
      privateKey = buffer.toString();
      reader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    RsaSigner signer = new RsaSigner(privateKey);
    return signer;
  }

}
