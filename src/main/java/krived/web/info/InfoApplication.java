package krived.web.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoApplication.class, args);

//	TODO:	проверить 13 процедуру, показывает 0 0
//			изменить апдейт и делит в фк на каскадные
//			удалить changeSet с импортом csv и ресетнуть базу
//			логирование!
//			поднять приложение в докере
//			переписать на дженерики?
	}
}
