package com.example.transactionrollbacktest.services;

import com.example.transactionrollbacktest.exceptions.TestException;
import com.example.transactionrollbacktest.repositories.TestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Arne Van Eycken
 * @version 1.0
 */

@Service
@Transactional
public class TestService implements ITestService{
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Transactional
    public void testMethod1(){
        System.out.println("Running testMethod1 in TestService");
        testRepository.rollbackTester();
        try {
            testRepository.testMethod1();
        } catch (RuntimeException e) {
            System.out.println("TestMethod1 in TestService zou nu een rollback moeten doen");
        }
        System.out.println("TestMethod1 in TestService doet eigenlijk toch geen rollback");
        testRepository.rollbackTester();
    }
    @Transactional
    public void testMethod2(){
        System.out.println("Running testMethod2 in TestService");
        try {
            testRepository.testMethod2();
        } catch (RuntimeException e) {
            System.out.println("TestMethod2 in TestService zou nu een rollback moeten doen");
            e.printStackTrace();
        }
        System.out.println("TestMethod2 in TestService doet eigenlijk toch geen rollback");
    }

    @Transactional
    public void testMethod3(){
        System.out.println("Running testMethod3 in TestService");
        testRepository.rollbackTester();
        try {
            exceptionThrower();
        } catch (Exception e) {
            System.out.println("TestMethod3 in TestService zou nu een rollback moeten doen");
        }
        System.out.println("TestMethod3 in TestService doet eigenlijk toch geen rollback");
        testRepository.rollbackTester();
    }

    private void exceptionThrower(){
        System.out.println("Throwing exception in exceptionThrower in TestService");
        throw new TestException();
    }

}
