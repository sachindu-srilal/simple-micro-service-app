package lk.ijse.dep10.backend.business;

import lk.ijse.dep10.backend.dto.StudentDTO;

import java.util.List;

public interface StudentBO {

    List<StudentDTO> getAllStudents() throws Exception;

    StudentDTO saveStudent(StudentDTO studentDTO) throws Exception;

    void deleteStudent(Integer pk) throws Exception;
}
