package np.com.aadarshadhakal.crud.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	private final StudentRepository studentRepository;
	
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
}
