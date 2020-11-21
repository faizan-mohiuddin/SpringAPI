package com.example.demo;

public class RandomDB {
    private final String ColA;
    private final Integer ColB;
    private final Integer ID;

    public RandomDB(String ColA, Integer ColB, Integer ID) {

        this.ColA = ColA;
        this.ColB = ColB;
        this.ID = ID;

    }

    public String getColA() {

        return this.ColA;

    }

    public int getColB() {

        return this.ColB;

    }
}
