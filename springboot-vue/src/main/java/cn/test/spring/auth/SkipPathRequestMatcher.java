package cn.test.spring.auth;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

public class SkipPathRequestMatcher implements RequestMatcher
{
  private OrRequestMatcher matchers;
  private OrRequestMatcher processingMatcher;
  
  public SkipPathRequestMatcher(List<String> pathsToSkip, List<String> processingPath)
  {
    List<RequestMatcher> m = pathsToSkip.stream().map(path -> new AntPathRequestMatcher(path))
        .collect(Collectors.toList());
    matchers = new OrRequestMatcher(m);
    
    List<RequestMatcher> m1 = processingPath.stream().map(path -> new AntPathRequestMatcher(path))
        .collect(Collectors.toList());
    processingMatcher = new OrRequestMatcher(m1);
//    processingMatcher = new AntPathRequestMatcher(processingPath);
  }
  
  @Override
  public boolean matches(HttpServletRequest request)
  {
    if (matchers.matches(request))
    {
      return false;
    }
    return processingMatcher.matches(request) ? true : false;
  }
  
}
