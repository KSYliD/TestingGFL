package org.example;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(Main.output(2.0, 5.0, 1.0));

    }

    public static double resolveFunction(double x) {
        double y = 0.0;
        if (x > 3.4) {
            y = sin(x) * log(x);
        } else if (x <= 3.4) {
            y = cos(x) * cos(x);
        }
        double scale = Math.pow(10, 1);
        return Math.round(y * scale) / scale;
    }

    public static int stepNum(double start, double end, double step) {
        double scale = Math.pow(10, 3);
        double value = Math.round(((end - start) / step ) * scale) / scale;
        return (int) (value + 1);
    }

    public static double[] createArrayX(double start, double end, double step) {
        int arrSize = stepNum(start, end, step);
        double[] arr = new double[arrSize];
        for (int i = 0; i < arrSize; i++) {
            double scale = Math.pow(10, 3);
            double value = Math.round(start * scale) / scale;
            arr[i] = value;
            start += step;
        }
        return arr;
    }

    public static double[] createArrayY(double[] arrayX) {
        double[] arr = new double[arrayX.length];
        for (int i = 0; i < arrayX.length; i++) {
            double scale = Math.pow(10, 3);
            double value = Math.round(resolveFunction(arrayX[i]) * scale) / scale;
            arr[i] = value;
        }
        return arr;
    }

    public static int maxValueNum(double[] arr) {
        double maxNum = Double.MIN_VALUE;
        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxNum) {
                maxNum = arr[i];
                res = i;
            }
        }
        return res;
    }

    public static int minValueNum(double[] arr) {
        double minNum = Double.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minNum) {
                minNum = arr[i];
                res = i;
            }
        }
        return res;
    }

    public static double sum(double[] arr) {
        double result = 0;
        for (double v : arr) {
            result += v;
        }
        return result;
    }

    public static double average(double[] arr) {
        return sum(arr) / arr.length;
    }

    public static String output(double start, double end, double step) {
        double[] arrX = createArrayX(start, end, step);
        double[] arrY = createArrayY(arrX);
        int maxValStep = maxValueNum(arrY);
        int minValStep = minValueNum(arrY);
        return "max value: " + arrY[maxValStep] + " step: " + maxValStep + " step value: " + arrX[maxValStep]
                + "\nmin value: " + arrY[minValStep] + " step: " + minValStep + " step value: " + arrX[minValStep];
    }
}