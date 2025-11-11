package aston.final_project;

import java.util.Scanner;

public class ValidationUtils {
    /**
     * Метод конвертирует строку в объект типа <Bus>
     * @param string строка в формате "field1, field2, field3"
     * @return объект типа Bus с полями содержащими null: field1, field2, field3;
     */
    static Bus mapStringToBus(String string) {
        Bus bus = null;
        if(isUserInputConsistOfThreeFields(string)) {
            String[] parts = string.split(",", -1);
            String[] fields = new String[]{null, null, "0"};
            for (int i = 0; i < parts.length; i++) {
                fields[i] = parts[i].isBlank()? fields[i] : parts[i].trim();
            }
            try {
                bus = new Bus.BusBuilder()
                        .setNumber(fields[0])
                        .setModel(fields[1])
                        .setRun(Integer.parseInt(fields[2]))
                        .build();
            } catch (RuntimeException e) {
                System.out.println("Ошибка конвертации данных (пробег должен быть числом). Попробуйте еще раз.\n");
                return null;
            }
        } else {
            System.out.println("Ошибка конвертации (у объекта Bus должно быть 3 поля).\n");
            return null;
        }
        return bus;
    }

    /**
     * Метод проверяет пользовательский ввод на возможность конвертации в объект типа Bus.
     * @param input - исходная строка для конвертации в объект типа <Bus>
     * @return true, если метод split() может разбить строку не более чем на три части, что соответствует
     * кол-ву полей класса Bus
     */
     static boolean isUserInputConsistOfThreeFields(String input) {
        long commaCount = input.chars()
                .filter(ch -> ch == ',')
                .count();
        return commaCount == 2;
    }

    /**
     * Метод проверяет возможность парсинга строки в число (задан ли пробег числом)
     * @param run
     * @return true, если можно спарсить чтроку в число
     */
    static boolean isRunInstanceOfInteger (String run) {
         try {
             Integer.parseInt(run.trim());
             return true;
         } catch (NumberFormatException e) {
             return false;
         }
    }

    static int getListSize() {
        String input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                    Укажите размер коллекции (целое число > 0).
                    "Для выхода введите "Q" (и нажмите Enter).""");
        while(true) {
            input = scanner.nextLine().trim();
            if(input.equalsIgnoreCase("Q")) {
                System.out.print("Пользователь прервал ввод.\n");
                break;
            }
            try{
                int size = Integer.parseInt(input);
                if(size > 0) {
                    return size;
                }
                else {
                    System.out.println("Число должно быть > 0, попробуйте еще.");
                }
            } catch (NumberFormatException e) {
                System.out.println(input + " не является целым положительным числом.");
            }
        }
//        scanner.close();
        return 0;
    }
}
