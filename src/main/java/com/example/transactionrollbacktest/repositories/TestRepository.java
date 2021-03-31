package com.example.transactionrollbacktest.repositories;

import com.example.transactionrollbacktest.exceptions.TestException;
import org.springframework.stereotype.Repository;

/**
 * @author Arne Van Eycken
 * @version 1.0
 */

@Repository
public class TestRepository implements ITestRepository{

    public void testMethod1(){
        System.out.println("Throwing exception in testMethod1 in TestRepository");
        throw new TestException();
    }

    public void testMethod2(){
        System.out.println("Running testMethod2 in TestRepository");
    }
    public void rollbackTester(){
        System.out.println("RollbackTester wordt nog steeds opgeroepen");
    }

}
