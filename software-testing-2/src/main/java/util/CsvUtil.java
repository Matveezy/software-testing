package util;

import mathfunctions.MathFunctions;
import system.System;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Function;

public class CsvUtil {

    private static final double step = 0.05;
    private static final double lowValue = -4;
    private static final double highValue = 4;

    static void printValueToCsv(File file, Double x, Double value, BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write(String.valueOf(x));
        bufferedWriter.write(",");
        bufferedWriter.write(String.valueOf(value));
        bufferedWriter.newLine();
    }

    static void printCsv(Function<Double, Double> function, double step, double lowVal, double highVal, String fileName) throws IOException {
        File file = new File("src/main/resources/csv/" + fileName + ".csv");
        file.delete();
        file.createNewFile();
        double x;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write("x" + "," + "value");
            bufferedWriter.newLine();
            for (int i = 0; i < (highVal - lowVal) / step; ++i) {
                x = lowVal + i * step;
                printValueToCsv(file, x, function.apply(x), bufferedWriter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        MathFunctions mathFunctions = new MathFunctions();
        System system = new System(mathFunctions);
        printCsv(mathFunctions::cos, step, lowValue, highValue, "cos");
        printCsv(mathFunctions::sin, step, lowValue, highValue, "sin");
        printCsv(mathFunctions::tan, step, lowValue, highValue, "tan");
        printCsv(mathFunctions::cotan, step, lowValue, highValue, "cotan");
        printCsv(mathFunctions::sec, step, lowValue, highValue, "sec");
        printCsv(mathFunctions::cosec, step, lowValue, highValue, "cosec");
        printCsv(system::trigonometricEq, step, lowValue, highValue, "trigonometric");
        printCsv(system::logarithmicEq, step, lowValue, highValue, "logarithmic");
    }
}
