package com.morfox;

import com.morfox.groups.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GroupsManager groupsManager = new GroupsManager(new Validator[]{
                new Validator1(),
                new Validator2(),
                new Validator3()
        });
        UI ui = new UI(groupsManager);

        Scanner in = new Scanner(System.in);
        String command = "";
        do {
            System.out.println("Введите команду");
            try {
                command = in.nextLine();
                String[] commandParts = command.split("( )+");
                String[] params = Arrays.copyOfRange(commandParts, 1, commandParts.length);

                switch (commandParts[0]) {
                    case "add":
                        groupsManager.add(parseAddingInput(params));
                        break;
                    case "print":
                        ui.print(Arrays.stream(params).mapToInt(Integer::parseInt).toArray());
                        break;
                    case "remove":
                        groupsManager.remove(Arrays.stream(params).mapToInt(Integer::parseInt).toArray());
                        break;
                    case "clear":
                        groupsManager.clear();
                        break;
                    case "help":
                        ui.help();
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Неправильный тип параметров: ожидается целочисленное выражение");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (!command.equals("exit"));
        in.close();
    }

    private static Point[] parseAddingInput(String[] pointInputs) {
        if (pointInputs.length % 2 != 0) {
            throw new RuntimeException("Неверный формат данных. \n Координаты передаются парами чисел через пробел, например, add 1 1 -2 -3 - добавит 2 точки: (1,1) и (-2,-3)");
        }

        Point[] points = new Point[pointInputs.length / 2];

        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(Integer.parseInt(pointInputs[i * 2]), Integer.parseInt(pointInputs[i * 2 + 1]));
        }

        return points;
    }
}
