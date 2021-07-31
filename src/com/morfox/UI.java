package com.morfox;

import com.morfox.groups.Group;
import com.morfox.groups.Point;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UI {

    private final GroupsManager groupsManager;

    public UI(GroupsManager groupsManager) {
        this.groupsManager = groupsManager;
    }

    public void print(int[] groupNums) {
        if (groupNums.length == 0) {
            for (Group group : groupsManager.getGroups()) {
                System.out.println(group.toString());
            }
            System.out.println("Количество точек без группы: " + groupsManager.getNoGroup().size());
        } else {
            Set<Point> points = new HashSet<>();

            groupsManager.getGroups(groupNums).forEach(group -> points.addAll(group.getPoints()));

            if (points.isEmpty()) {
                System.out.println("Группа(ы) пуста(ы)");
            } else {
                System.out.println(points.stream().map(Point::toString).collect(Collectors.joining(", ")));
            }
        }
    }

    public void help() {
        System.out.println(
                "add <point>        - добавить в память программы точки, координаты передаются парами чисел через пробел\n" +
                        "                     прим. add 1 1 -2 -3 //добавить 2 точки: (1,1) и (-2,-3)\n" +
                        "print              - напечатать построчно каждую из трех групп (входящие в них точки)\n" +
                        "                     если в группу не попадает ни одна точка, то вывести сообщение, что группа пуста\n" +
                        "                     последней строкой напечатать количество точек, не вошедших ни в одну группу\n" +
                        "print <group_num>  - напечатать одним списком точки, входящие в группу(ы) переданную(ые) параметром <group_num>\n" +
                        "                     прим. print 1 2\n" +
                        "remove <group_num> - удалить из памяти все точки, входящие в группу(ы) <group_num>\n" +
                        "                     прим. remove 2 3\n" +
                        "clear              - очистить память\n" +
                        "help               - вывод справки по командам"
        );
    }
}
