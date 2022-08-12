package com.example.spring.Database;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value = "testBean2")
public class TestBean2Impl implements TestBean {
    private String qwerty;

    public TestBean2Impl() {
        System.out.println("test bean 2 created");
    }

    public TestBean2Impl(String qwerty) {
        this.qwerty = qwerty;
    }

    public String getQwerty() {
        return qwerty;
    }

    public void setQwerty(String qwerty) {
        this.qwerty = qwerty;
    }

    @Override
    public String getBeanData() {
        return this.qwerty + " test bean 2 impl";
    }
}
