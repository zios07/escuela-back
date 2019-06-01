package ma.escuela.escuela.service.impl;

import ma.escuela.escuela.domain.Test;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;
import ma.escuela.escuela.repository.TestRepository;
import ma.escuela.escuela.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService implements ITestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public Test addTest(Test test) throws ServiceException {
        return testRepository.save(test);
    }

    @Override
    public Test findTest(long id) throws NotFoundException {
        Optional<Test> testOptional = testRepository.findById(id);
        if (!testOptional.isPresent())
            throw new NotFoundException("TEST.NOT.FOUND", "Test not found with id : " + id);
        return testOptional.get();
    }

    @Override
    public List<Test> findAllTests() {
        return testRepository.findAll();
    }

    @Override
    public void deleteTest(long id) throws NotFoundException {
        testRepository.deleteById(id);
    }

    @Override
    public List<Test> searchTests(Test testDto) throws NotFoundException {
        return null;
    }

    @Override
    public Test updateTest(Test test) throws NotFoundException {
        return testRepository.save(test);
    }
}
