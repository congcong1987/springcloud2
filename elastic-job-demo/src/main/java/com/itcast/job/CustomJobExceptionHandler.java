package com.itcast.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dangdang.ddframe.job.executor.handler.JobExceptionHandler;
import com.itcast.Util.DingDingMessageUtil;

/**
 * 自定义定时
 * @author DELL
 *
 */
public class CustomJobExceptionHandler implements JobExceptionHandler{
	 private Logger logger = LoggerFactory.getLogger(CustomJobExceptionHandler.class);

	    @Override
	    public void handleException(String jobName, Throwable cause) {
	        logger.error(String.format("Job '%s' exception occur in job processing", jobName), cause);
	        DingDingMessageUtil.sendTextMessage("【"+jobName+"】任务异常。" + cause.getMessage());
	    }
}
