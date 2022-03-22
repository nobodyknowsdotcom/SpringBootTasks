package Application;

import Vehicles.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        ApplicationContext javaConfigContext = new AnnotationConfigApplicationContext(Config.class);

        Car carWithConstructor = javaConfigContext.getBean(Car.class);
        CarWithSetterInjection carWithSetter = javaConfigContext.getBean(CarWithSetterInjection.class);
        CarWithFieldInjection carWithField = javaConfigContext.getBean(CarWithFieldInjection.class);
    }
}
