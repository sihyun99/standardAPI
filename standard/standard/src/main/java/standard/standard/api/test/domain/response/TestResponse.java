package standard.standard.api.test.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class TestResponse {

  @Schema(
      example = "테스트",
      description = "테스트 스트링"
  )
  private String testStr;

  @Schema(
      example = "테스트",
      description = "테스트 스트링2"
  )
  private String test2Str;


}
