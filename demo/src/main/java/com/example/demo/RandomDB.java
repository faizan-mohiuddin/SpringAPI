package com.example.demo;

public class RandomDB {
    private final String ColA;
    private final Integer ColB;

    public RandomDB(String ColA, Integer ColB) {

        this.ColA = ColA;
        this.ColB = ColB;

    }

    public String getColA() {

        return this.ColA;

    }

    public int getColB() {

        return this.ColB;

    }
}
