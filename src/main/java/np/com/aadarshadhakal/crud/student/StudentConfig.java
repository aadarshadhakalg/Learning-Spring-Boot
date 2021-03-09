package np.com.aadarshadhakal.crud.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
		Student mariam =	new Student(
					"Mariam","mariam.jamal@gmail.com",LocalDate.of(2002,Month.APRIL,5)
					);
		
		Student alex =	new Student(
				"alex","alex.jamal@gmail.com",LocalDate.of(2000,Month.APRIL,5)
				);
		
		studentRepository.saveAll(List.of(mariam,alex));
		};
	}

}
