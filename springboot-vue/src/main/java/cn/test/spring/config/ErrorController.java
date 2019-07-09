package cn.test.spring.config;

import cn.test.spring.common.Constants;
import cn.test.spring.response.BaseResponse;
import cn.test.spring.response.CommonException;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Api(tags = { "error" }, description = " ")
@RestController
@ControllerAdvice
public class ErrorController
{
  private static Logger logger = LogManager.getLogger(ErrorController.class);
  @ExceptionHandler(value = { Exception.class})
  public @ResponseBody
  ResponseEntity<BaseResponse> exceptionHandler(Exception ex, HttpServletRequest request)
  {
    BaseResponse baseResponse = new BaseResponse();
    baseResponse.setStatusCode(Constants.RESPONSE_STATUS_CODE_FAILED);

    if (ex instanceof CommonException) {
      baseResponse.setStatusMsg(ex.getMessage());
    } else {
      logger.error("exceptionHandler error:{}", ex);
      ex.printStackTrace();
      StringBuilder sb = new StringBuilder();
      if(request!=null)
      {
        sb.append("URI:").append(request.getRequestURI()).append("\r\n");
        sb.append("URL:").append(request.getRequestURL()).append("\r\n");
        sb.append("RemoteAddr:").append(request.getRemoteAddr()).append("\r\n");
        sb.append("RemoteHost:").append(request.getRemoteHost()).append("\r\n");
        sb.append("RemotePort:").append(request.getRemotePort()).append("\r\n");
        sb.append("method:").append(request.getMethod()).append("\r\n");
        //add header
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements())
        {
          String header = enumeration.nextElement();
          sb.append(header).append(":").append(request.getHeader(header)).append("\r\n");
        }
      }
      String stacktrace = ExceptionUtils.getStackTrace(ex);
      sb.append(stacktrace);
      baseResponse.setStatusMsg(sb.toString());
    }
    return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
  }
}
