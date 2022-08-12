package com.example.spring.Database;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Primary
public class TestBeanImpl implements TestBean {
    private String test;

    public TestBeanImpl() {
        this.test = "Default";
        System.out.println("Test Bean created with no args constructor");
    }

    public TestBeanImpl(String test) {
        this.test = test;
        System.out.println("Test Bean created with name = " + test);
    }

    public String getTest() {
        return test;
    }

    @Override
    public String getBeanData() {
        return this.test + " test bean 1 impl";
    }

    public void setTest(String test) {
        this.test = test;
    }
}
