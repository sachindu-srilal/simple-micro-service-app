package lk.ijse.dep10.backend.business.impl;

import lk.ijse.dep10.backend.business.StudentBO;
import lk.ijse.dep10.backend.business.exception.DuplicateRecordException;
import lk.ijse.dep10.backend.business.exception.RecordNotFoundException;
import lk.ijse.dep10.backend.business.util.Transformer;
import lk.ijse.dep10.backend.dao.custom.StudentDAO;
import lk.ijse.dep10.backend.dto.StudentDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentBOImpl implements StudentBO {

    private final StudentDAO studentDAO;
    private final Transformer transformer;

    public StudentBOImpl(StudentDAO studentDAO, Transformer transformer) {
        this.studentDAO = studentDAO;
        this.transformer = transformer;
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
        return studentDAO.findAll().stream().map(transformer::fromStudentEntity).collect(Collectors.toList());
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) throws Exception {
        if (studentDAO.existsById(studentDTO.getId())) {
            throw new DuplicateRecordException(studentDTO.getId() + " already exists");
        }
        return transformer.fromStudentEntity(studentDAO.save(transformer.toStudentEntity(studentDTO)));
    }

    @Override
    public void deleteStudent(Integer pk) throws Exception {
        if(!studentDAO.existsById(pk)) throw new RecordNotFoundException("Delete failed " + pk + " does not exist");
        studentDAO.deleteById(pk);
    }

}
