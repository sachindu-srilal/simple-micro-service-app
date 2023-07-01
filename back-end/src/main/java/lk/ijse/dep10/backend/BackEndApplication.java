package lk.ijse.dep10.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackEndApplication {

	public static void main(String[] args) {
		System.out.println("hello spring");
		SpringApplication.run(BackEndApplication.class, args);
	}

}
