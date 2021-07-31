package com.morfox.groups;

public class Validator1 implements Validator {
    @Override
    public boolean check(Point point) {
        return point.x <= point.y;
    }

    @Override
    public String description() {
        return "Группа 1 (y=x^1)";
    }
}
