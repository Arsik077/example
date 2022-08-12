package com.example.spring.Example;

public class Engine {
    private int volume;

    public void start(){
        System.out.println("Run");
    }

    public Engine(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
