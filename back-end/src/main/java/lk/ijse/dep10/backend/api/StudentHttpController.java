package lk.ijse.dep10.backend.api;

import lk.ijse.dep10.backend.business.StudentBO;
import lk.ijse.dep10.backend.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/students")
public class StudentHttpController {

    private final StudentBO studentBO;

    public StudentHttpController(StudentBO studentBO) {
        this.studentBO = studentBO;
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() throws Exception {
        return studentBO.getAllStudents();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO saveStudent(@RequestBody @Valid StudentDTO studentDTO) throws Exception {
        return studentBO.saveStudent(studentDTO);
    }

    @DeleteMapping("/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable("studentId") Integer studentId) throws Exception {
        studentBO.deleteStudent(studentId);
    }
}
