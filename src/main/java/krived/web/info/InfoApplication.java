package krived.web.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoApplication.class, args);

//	TODO:	проверить 13 процедуру, показывает 0 0
//			логирование!
//			обработать эксепшены
//			поднять приложение в докере
//			переписать на дженерики?
	}
}
