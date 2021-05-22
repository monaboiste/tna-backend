package pl.zgora.uz.wiea.tna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
public class TnaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TnaApplication.class, args);
    }
}
