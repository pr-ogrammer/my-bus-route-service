package pl.prutkowski.bus.route;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
public class MyBusRouteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBusRouteServiceApplication.class, args);
	}

	@Bean("busRouteExecutor")
	public Executor getBusRouteExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(500);
		executor.setThreadNamePrefix("busExec-");
		executor.initialize();
		return executor;
	}
}
