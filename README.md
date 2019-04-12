访问Eureka Server:
http://localhost:9000/


访问Eureka Client: 
http://localhost:9001/say?name=Zhou  节点1
http://localhost:9002/say?name=Zhou  节点2

访问Ribbon:
http://localhost:9003/say?name=zhou
		需要注册
		@Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return  new RestTemplate();
    }
		
		
		restTemplate.getForObject("http://HELLO/say?name="+name,String.class);
		HELLO 是Eureka Client的名字
		
		
		
		Dalston及以上的版本中，打开断路器 
		feign.hystrix.enabled=true
		
			
			
		Hystrix Dashboard——Hystrix仪表盘	
		http://localhost:9004/hystrix
		开启仪表盘
		<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
		</dependency>
		@Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;

    }
		
访问Feign:
http://localhost:9004/say?name=Zhou


	feign:
  hystrix:
    enabled: true
		

		
访问Zuul:
http://localhost:9005/ribbon/say?name=Zhou
http://localhost:9005/feign/say?name=Zhou

zuul启动不了 其中一个原因是 spring cloud版本和spring boot版本不对应



访问Config-server:
http://localhost:9006/config-server/dev
http://127.0.0.1:9006/config-server/dev/master
http://localhost:9006/application-dev.yml

访问Config-client:
http://localhost:9007/test/user
http://127.0.0.1:8888/test/user

??更改了config-server 8888的默认端口 在client-client里增加bootstrap.properties配置  http://localhost:9007/test/user  并不能访问
还是得访问  http://127.0.0.1:8888/test/user 才能读取到远程git配置  暂未找到原因


刷新bus http://localhost:9007/bus/refresh
http://localhost:9007/bus/refresh   这里还是得访问8888才可以刷新


