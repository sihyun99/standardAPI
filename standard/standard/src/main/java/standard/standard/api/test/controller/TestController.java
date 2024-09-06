package standard.standard.api.test.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import standard.standard.api.test.domain.request.TestRequestParam;
import standard.standard.api.test.domain.response.TestResponse;
import standard.standard.api.test.service.TestService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
@Tag(name = "Location Controller", description = "테스트 콘트롤러입니다.")
@Validated
public class TestController {

  private final TestService testService;

  @Operation(summary = "테스트 API"
      , responses = {
      @ApiResponse(responseCode = "200"
          , description = "성공"
          , content = @Content(mediaType = "application/json"
          , schema = @Schema(implementation = TestResponse.class)))
  })
  @Parameters({
      @Parameter(name = "locale", description = "언어", required = false, in = ParameterIn.HEADER, example = "ko"),
      @Parameter(name = "wmGbn", description = "웹 모바일 구분", required = false, in = ParameterIn.HEADER, example = "01")
  })
  @GetMapping(value = "/test-api")
  public @ResponseBody HashMap<String, TestResponse> getTestList(
      @Valid TestRequestParam requestParam
  ) {
    return testService.getTestList(requestParam);
  }
}
