package standard.common.config.property;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class MobileDeviceProperties {

  @Value("${allow.display.on.mobile.page}")
  private String allowDisplayOnMobilePage;
}
