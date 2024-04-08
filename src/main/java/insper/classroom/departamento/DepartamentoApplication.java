package insper.classroom.departamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients(basePackages = {
    "insper.classroom.aula",
    "insper.classroom.monitoria"
})
@EnableDiscoveryClient
@SpringBootApplication
public class DepartamentoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartamentoApplication.class, args);
    }
    
}
