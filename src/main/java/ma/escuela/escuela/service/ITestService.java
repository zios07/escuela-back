package ma.escuela.escuela.service;

import ma.escuela.escuela.domain.Test;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;

import java.util.List;

public interface ITestService {

    Test addTest(Test test) throws ServiceException;

    Test findTest(long id) throws NotFoundException;

    List<Test> findAllTests();

    void deleteTest(long id) throws NotFoundException;

    List<Test> searchTests(Test testDto) throws NotFoundException;

    Test updateTest(Test test) throws NotFoundException;

}
