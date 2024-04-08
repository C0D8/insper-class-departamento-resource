package insper.classroom.departamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DepartamentoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartamentoApplication.class, args);
    }
    
}
