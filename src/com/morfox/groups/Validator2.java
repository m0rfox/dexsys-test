package com.morfox.groups;

public class Validator2 implements Validator {
    @Override
    public boolean check(Point point) {
        return Math.pow(point.x, 2) <= point.y;
    }

    @Override
    public String description() {
        return "Группа 2 (y=x^2)";
    }
}
