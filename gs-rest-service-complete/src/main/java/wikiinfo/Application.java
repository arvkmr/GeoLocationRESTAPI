package wikiinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication

public class Application {
	static MongoOperations mongoOperation;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        ApplicationContext ctx = 
                new AnnotationConfigApplicationContext(MongoDbConfig.class);
   	  mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
    }
}
