package com.morfox.groups;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Group {

    private final List<Point> groupPoints = new ArrayList<>();
    private final Validator validator;

    public Group(Validator validator) {
        this.validator = validator;
    }

    public void clear() {
        groupPoints.clear();
    }

    public boolean checkAndAdd(Point point) {
        boolean isValid = validator.check(point);
        if (isValid) {
            groupPoints.add(point);
        }
        return isValid;
    }

    public List<Point> getPoints() {
        return groupPoints;
    }

    @Override
    public String toString() {
        if (groupPoints.isEmpty()) {
            return validator.description() + ": Группа пуста";
        }
        return validator.description() + ": " + groupPoints.stream().map(Point::toString).collect(Collectors.joining(", "));
    }
}
