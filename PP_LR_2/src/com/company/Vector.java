package com.company;

public class Vector {
    private double[] elements;

    public Vector(int length) {

        elements = new double[length];
    }

    public int getLength() {

        return elements.length;
    }

    public double getElement(int index) {

        return elements[index];
    }

    public void setElement(int index, double value) {

        elements[index] = value;
    }

    public Vector copyVector(){
        // копирование вектора
        Vector result = new Vector(elements.length);
        for(int i = 0; i < elements.length; i++){
            result.setElement(i, elements[i]);
        }
        return result;
    }

    public double getMin() {
        // минимальный элемент вектора
        double min = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] < min) {
                min = elements[i];
            }
        }
        return min;
    }

    public double getMax() {
        // максимальный элемент вектора
        double max = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] > max) {
                max = elements[i];
            }
        }
        return max;
    }

    public Vector insertionSortUp() {
        // сортировка выбором по возрастанию
        Vector result = copyVector();
        int pos;
        double min;
        for(int i = 0; i < result.getLength(); i++) {
            pos = i;
            min = result.getElement(i);
            //выбор наибольшего элемента
            for(int j = i + 1; j < result.getLength(); j++){
                if(result.getElement(j) < min){
                    pos = j; // позиция наибольшего элемента
                    min = result.getElement(j);
                }
            }
            result.setElement(pos, result.getElement(i));
            result.setElement(i, min);
        }
        return result;
    }

    public Vector insertionSortDown() {
        // сортировка выбором по убыванию
        Vector result = copyVector();
        int pos;
        double max;
        for(int i = 0; i < result.getLength(); i++) {
            pos = i;
            max = result.getElement(i);
            //выбор наибольшего элемента
            for(int j = i + 1; j < result.getLength(); j++){
                if(result.getElement(j) > max){
                    pos = j; // позиция наибольшего элемента
                    max = result.getElement(j);
                }
            }
            result.setElement(pos, result.getElement(i));
            result.setElement(i, max);
        }
        return result;
    }

    public double getEuclidNorm() {
        //вычисление евклидовой нормы
        double sum = 0; // сумма элементов в квадрате

        for (double element : elements) {
            sum += element * element;
        }

        return Math.sqrt(sum);
    }

    public void multiplyByNumber(double number) {
        //умножение вектора на число
        for (int i = 0; i < elements.length; i++) {
            elements[i] = elements[i] * number;
        }
    }

    public double getScalarMultipl(Vector factor){
        // скалярное произведение векторов
        double result = 0;
        for(int i = 0; i < elements.length; i++){
            result += elements[i] * factor.getElement(i);
        }
        return result;
    }

    public Vector getVectorsSum(Vector term){
        // сумма двух векторов
        Vector result = new Vector(elements.length);
        for(int i = 0; i < elements.length; i++){
            result.setElement(i, elements[i] + term.getElement(i));
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (double element : elements) {
            str.append("\t").append(element);
        }

        return str.toString();
    }
}
