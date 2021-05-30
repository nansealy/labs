package com.company;

import java.util.Scanner;

public class Main {
    public static Vector getVector(String str){
        // преобразование строки в вектор
        Vector vector = null;
        try {
            String[] str_array;
            str_array = str.split(" ");
            vector = new Vector(str_array.length);
            for (int i = 0; i < str_array.length; i++) {
                vector.setElement(i, Double.parseDouble(str_array[i]));
            }
        }
        catch(Exception exception){
            System.out.println("Ошибка ввода!");
            vector = null;
        }
        return vector;
    }

    public static void main(String[] args) {

        Vector vector = null;
        Scanner scan = new Scanner(System.in);
        String input;
        boolean exit = false;

        while(!exit) {
            System.out.println("Меню:");
            System.out.println("1 - создание вектора");
            System.out.println("2 - вывод значений вектора");
            System.out.println("3 - поиск минимума");
            System.out.println("4 - поиск максимума");
            System.out.println("5 - сортировка по возрастанию");
            System.out.println("6 - сортировка по убыванию");
            System.out.println("7 - поиск евклидовой нормы");
            System.out.println("8 - умножение вектора на число");
            System.out.println("9 - поиск скалярного произведения двух векторов");
            System.out.println("10 - сложение двух векторов");
            System.out.println("11 - завершение программы");

            input = scan.next();

            switch(input) {
                case "1": {
                    Scanner scanner = new Scanner(System.in); // новый объект scanner
                    System.out.print("Введите значения вектора, разделяя пробелами: ");
                    String vec = scanner.nextLine();
                    vector = getVector(vec);
                    if(vector != null) {
                        System.out.println("Вектор записан: " + vector.toString());
                    }
                    else System.out.println("Вектор не записан!");
                    break;

                }
                case "2": {
                    if (vector != null) {
                        System.out.println("Вектор: " + vector.toString());
                    }
                    else System.out.println("Вектор не записан!");
                    break;
                }
                case "3": {
                    if (vector != null) {
                        System.out.println("Минимальное значение вектора: " + vector.getMin());
                    }
                    else System.out.println("Вектор не записан!");
                    break;
                }
                case "4": {
                    if (vector != null) {
                        System.out.println("Максимальное значение вектора: " + vector.getMax());
                    }
                    else System.out.println("Вектор не записан!");
                    break;
                }
                case "5": {
                    if (vector != null) {

                        System.out.println("Отсортированный по возрастанию вектор: " + vector.insertionSortUp().toString());
                    }
                    else System.out.println("Вектор не записан!");
                    break;
                }
                case "6": {
                    if (vector != null) {

                        System.out.println("Отсортированный по убыванию вектор: " + vector.insertionSortDown().toString());
                    }
                    else System.out.println("Вектор не записан!");
                    break;
                }
                case "7": {
                    if (vector != null) {
                        System.out.println("Евклидова норма: " + vector.getEuclidNorm());
                    }
                    else System.out.println("Вектор не записан!");
                    break;
                }
                case "8": {
                    if (vector != null) {
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Введите число: ");
                        double number = scanner.nextDouble();
                        vector.multiplyByNumber(number);
                        System.out.println("Результирующий вектор: " + vector.toString());
                    }
                    else System.out.println("Вектор не записан!");
                    break;
                }
                case "9": {
                    if (vector != null) {
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Введите вектор-множитель: ");
                        String vec = scanner.nextLine();
                        Vector factor = getVector(vec);
                        if (factor == null){
                            System.out.println("Вектор не записан!");
                        }
                        else if (factor.getLength() == vector.getLength()) {

                            System.out.println("Скалярное произведение векторов: " + vector.getScalarMultipl(factor));
                        }
                        else System.out.println("Невозможно произвести операцию над векторами.");
                    }
                    else System.out.println("Вектор не записан!");
                    break;
                }
                case "10": {
                    if (vector != null) {
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Введите вектор-слагаемое: ");
                        String vec = scanner.nextLine();
                        Vector term = getVector(vec);
                        if (term == null){
                            System.out.println("Вектор не записан!");
                        }
                        else if (term.getLength() == vector.getLength()) {

                            System.out.println("Сумма векторов: " + vector.getVectorsSum(term).toString());
                        }
                        else System.out.println("Невозможно произвести операцию над векторами.");
                    }
                    else System.out.println("Вектор не записан!");
                    break;
                }
                case "11": {
                    exit = true;
                    break;
                }

            }
        }





    }
}
