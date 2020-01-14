package com.itcast.apilimit;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

//具体服务限流监听
//初始化需要进行并发限制的 API


@Component
public class InitApiLimitRateListener implements ApplicationContextAware{
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		Environment environment = ctx.getEnvironment();
		String defaultLimit = environment.getProperty("open.api.defaultLimit");
		Object rate = defaultLimit == null ? 100 : defaultLimit; 
		System.out.println("当前：频率="+rate.toString());
		ApiLimitAspect.semaphoreMap.put("open.api.defaultLimit", new Semaphore(Integer.parseInt(rate.toString())));
		Map<String, Object> beanMap = ctx.getBeansWithAnnotation(RestController.class);
		Set<String> keys = beanMap.keySet();
		for (String key : keys) {
			Class<?> clz = beanMap.get(key).getClass();
			String fullName = beanMap.get(key).getClass().getName();
			if (fullName.contains("EnhancerBySpringCGLIB") || fullName.contains("$$")) {
				fullName = fullName.substring(0, fullName.indexOf("$$"));
				try {
					clz = Class.forName(fullName);
				} catch (ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
			}
			Method[] methods = clz.getMethods();
			for (Method method : methods) {
				if (method.isAnnotationPresent(ApiRateLimit.class)) {
					String confKey = method.getAnnotation(ApiRateLimit.class).confKey();
					System.out.println(confKey+"--------->key");
					if (environment.getProperty(confKey) != null) {
						Integer limit = Integer.parseInt(environment.getProperty(confKey));
						ApiLimitAspect.semaphoreMap.put(confKey, new Semaphore(limit));
					}else{
						ApiLimitAspect.semaphoreMap.put(confKey, new Semaphore(10,true));
					}
				}
			}
		}
	}
}
