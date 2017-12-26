package com.ppdai.demo;

import com.ppdai.demo.多线程.pool.EDuPool;
import com.ppdai.demo.多线程.thread.EDuThread;
import com.ppdai.demo.定时job.common_jar.ScheduleHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IntegretionDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegretionDemoApplication.class, args);
		//启动多线程的测试
		doEDuThreadJOB();
	}

	public static void doEDuThreadJOB(){
		//多线程去跑下面的代码
		EDuPool.getSingleInstance().excute(new EDuThread());
	}

	@Bean
	public ServletRegistrationBean testServletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new ScheduleHandler());
		registration.addUrlMappings("/myFirstJob");
		registration.addUrlMappings("/secondJob");
		return registration;
	}
}
