package com.morfox.groups;

public class Validator3 implements Validator {
    @Override
    public boolean check(Point point) {
        return Math.pow(point.x, 3) <= point.y;
    }

    @Override
    public String description() {
        return "Группа 3 (y=x^3)";
    }

}
