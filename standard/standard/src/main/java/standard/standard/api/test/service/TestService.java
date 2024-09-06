package standard.standard.api.test.service;

import jakarta.validation.Valid;
import java.util.HashMap;
import org.springframework.web.bind.annotation.ResponseBody;
import standard.standard.api.test.domain.request.TestRequestParam;
import standard.standard.api.test.domain.response.TestResponse;

public interface TestService {

  public @ResponseBody HashMap<String, TestResponse> getTestList(@Valid TestRequestParam requestParam);
}
