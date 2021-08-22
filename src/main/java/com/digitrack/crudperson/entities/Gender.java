package com.digitrack.crudperson.entities;

public enum Gender {
    FEMALE(1),
    MALE(2);

    private int val;

    Gender(int val) {
        this.val = val;
    }

    public int val() {
        return val;
    }

    public static Gender castToEnum(Integer val) {
        if (val == 1) {
            return FEMALE;
        }
        return MALE;
    }
}
