package np.com.aadarshadhakal.crud.student;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

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
	
	public void addNewSudent(Student student) {
		if(studentRepository.findStudentByEmail(student.getEmail()).isPresent() ) {
			throw new IllegalStateException("Student with this email already exists.");
		}
		studentRepository.save(student);
	}


	public void deleteStudent(Long id) {
		if(studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
		}else {
			throw new IllegalStateException("Student with id" + id + "doesnot exists");
		}
		
	}

	@Transactional
	public void updateStudent(Long id, String name, String email) {
		Student student = studentRepository.findById(id).orElseThrow(()->  new IllegalStateException("Student with id" + id + "doesnot exists") );
		
		if(name !=null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		
		if(email !=null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
			
			if(studentRepository.findStudentByEmail(email).isPresent()) {
				throw new IllegalStateException("Email Already Taken");
			}else {

				student.setEmail(email);
			}
		}
		
	}
}
