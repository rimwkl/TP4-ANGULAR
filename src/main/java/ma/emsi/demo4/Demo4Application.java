package ma.emsi.demo4;

import ma.emsi.demo4.entities.Payment;
import ma.emsi.demo4.entities.PaymentStatus;
import ma.emsi.demo4.entities.PaymentType;
import ma.emsi.demo4.entities.Student;
import ma.emsi.demo4.repository.PaymentRepository;
import ma.emsi.demo4.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

import static org.springframework.data.util.TypeUtils.type;

@SpringBootApplication
public class Demo4Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo4Application.class, args);
	}
@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository,
                                        PaymentRepository paymentRepository){
		return args -> {
			studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                            .firstName("Mohamed").code("112233").programId("SDIA")
                    .build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("rim").code("112244").programId("SDIA")
                    .build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("Hamza").code("112255").programId("GLSID")
                    .build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("Ziad").code("112266").programId("BDCC")
                    .build());
            PaymentType[] paymentTypes =PaymentType.values();
            Random random = new Random();
            studentRepository.findAll().forEach(st -> {
                for (int i =0;i<10;i++){
                    int index = random.nextInt(paymentTypes.length);
                    Payment payment =   Payment.builder()
                            .amount(1000+(int)(Math.random()*20000))
                            .type(paymentTypes[index])
                            .status(PaymentStatus.CREATED)
                            .date(LocalDate.now())
                            .student(st)
                            .build();
                    paymentRepository.save(payment);

                }
            });
        };
}


}
