package ru.exchanger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("введи число в рублях");
            int rubles = scanner.nextInt();
            scanner.nextLine();

            System.out.println("выбери валюту: ");
            System.out.println("1. доллар (USD)");
            System.out.println("2. евро (EUR)");
            String vault = scanner.nextLine();

            BigDecimal result;


            if (vault.equalsIgnoreCase("usd")) {
                result = Main.rubToUsd(rubles);
                System.out.println("у вас " + result.setScale(2, RoundingMode.HALF_UP) + " долларов");

            } else if (vault.equalsIgnoreCase("eur")) {
                result = Main.rubToEur(rubles);
                System.out.println("у вас " + result.setScale(2, RoundingMode.HALF_UP) + " евро");
            } else
                System.out.println("ошибка ввода");
        }catch (InputMismatchException e)
        {
            System.out.println("нужно ввести число");
        }


    }
    public static BigDecimal rubToUsd(int a)
    {
        BigDecimal b = BigDecimal.valueOf(a);
        return b.multiply(BigDecimal.valueOf(0.012));
    }
    public static BigDecimal rubToEur(int a)
    {
        BigDecimal b = BigDecimal.valueOf(a);
        return b.multiply(BigDecimal.valueOf(0.011));

    }
}
