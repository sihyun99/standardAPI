package standard.standard.api.test.domain.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TestRequestParam {

  private static final long serialVersionUID = -3175124847277476476L;

  @Schema(
      example = "ko",
      allowableValues = "ko/en/zh/vn/jp",
      required = false,
      description = "언어 설정값",
      hidden = false
  )
  private String locale = "ko";


  @Schema(
      example = "테스트",
      description = "테스트 파라미터"
  )
  @NotBlank
  private String testParam;

}
