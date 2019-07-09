package cn.test.spring.controller;

import cn.test.spring.response.BaseResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lot/")
public class LotController {
	private static Logger logger = LogManager.getLogger(LotController.class);

	@ApiOperation("获取集群中所有socket数量")
	@RequestMapping(value = "/getSocketSize", method = RequestMethod.GET,produces = {"application/json"})
	public BaseResponse<Long> getSocketSize() {
		logger.info("getSocketSize start");
		BaseResponse<Long> res = null;
		res.setResponseData(18000L);
		logger.info("getSocketSize start");
		return res;
	}
}
