package standard.standard.api.test.service;

import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import standard.standard.api.test.domain.request.TestRequestParam;
import standard.standard.api.test.domain.response.TestResponse;

@RequiredArgsConstructor
@Service
public class TestServiceImpl implements TestService {

  @Override
  public HashMap<String,TestResponse> getTestList(
      TestRequestParam requestParam) {

    TestResponse testResponse = new TestResponse();
    testResponse.setTestStr("테스트");
    testResponse.setTest2Str("테스트2");
    HashMap<String,TestResponse> result = new HashMap<>();
    result.put("result",testResponse);

    return result;

  }
}
