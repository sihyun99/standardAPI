package standard.common.config.p6spy;

import com.p6spy.engine.spy.P6SpyOptions;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class P6spyLogMessageFormatConfiguration {

  @PostConstruct
  public void setLogMessageFormat() {
    P6SpyOptions.getActiveInstance()
        .setLogMessageFormat(P6spySqlFormatConfiguration.class.getName());      // pretty
  }
}
