package com.example.spring.Example;

public class Car {
    private Engine engine;

    public Car() {
    }

    public void drive(){
        engine.start();
    }

    public Car(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
