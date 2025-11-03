package aston.final_project;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
            Strategy strategyKey = null;
            boolean isActive = true;
            try(Scanner scanner = new Scanner(System.in)) {
                while (isActive) {
                    System.out.println("""
                        Выберите источник ввода данных для сортировки:
                        1 - из файла,
                        2 - вручную из консоли,
                        3 - рандомный список.
                        Для выхода нажмите - Q.""");
                    String userInput = scanner.nextLine();
                    if (userInput.equalsIgnoreCase("Q")) {
                        System.out.println("Выход из программы.");
                        return;
                    } else {
                        switch (userInput) {
                            case "1" -> {
                                strategyKey = Strategy.FROM_FILE;
                                isActive = false;
                            }
                            case "2" -> {
                                strategyKey = Strategy.MANUALLY;
                                isActive = false;
                            }
                            case "3" -> {
                                strategyKey = Strategy.RANDOMLY;
                                isActive = false;
                            }
                            default -> System.out.println("Неверный ввод, попробуйте еще раз.");
                        }
                    }
                }
            }
            System.out.println(strategyKey);
        }
    }

