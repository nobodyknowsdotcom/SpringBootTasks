package com.example.demo.vehicles;

import lombok.Getter;

public abstract class Rollable {
    @Getter
    private int size;

    public Rollable(int size){
        this.size = size;
    }

    public void roll(){
        System.out.println("i'm rolling!");
    }
}
