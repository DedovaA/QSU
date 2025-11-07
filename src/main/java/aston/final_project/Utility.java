package aston.final_project;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Utility {

    /**
     * Метод конвертирует строку в объект типа <Bus>
     * @param string строка в формате "field1, field2, field3"
     * @return объект типа Bus с полями (где null заменен пустой строкой): field1, field2, field3;
     * @throws CustomException если пробег задан не числом или если количество полей не равно 3
     */
    static Bus mapStringToBusWithoutNullFields(String string) throws CustomException{
        if(isUserInputConsistOfThreeFields(string)) {
            String[] fields = string.split(",", -1);
            if(isRunInstanceOfInteger(fields[2]) || fields[2].isBlank())
                return new Bus.BusBuilder()
                        .setNumber(fields[0].trim())
                        .setModel(fields[1].trim())
                        .setRun(fields[2].isBlank() ? 0 : Integer.parseInt(fields[2].trim()))
                        .build();
            else throw new CustomException("Ошибка конвертации. Пробег должен быть числом");
        } else throw new CustomException("Ошибка конвертации. У объекта должно быть 3 поля");
    }

    /**
     * Метод конвертирует строку в объект типа <Bus>
     * @param string строка в формате "field1, field2, field3"
     * @return объект типа Bus с полями содержащими null: field1, field2, field3;
     */
    static Bus mapStringToBus(String string) throws CustomException{
        if(isUserInputConsistOfThreeFields(string)) {
            String[] parts = string.split(",", -1);
            String[] fields = new String[]{null, null, "0"};
            for (int i = 0; i < parts.length; i++) {
                fields[i] = parts[i].isBlank()? fields[i] : parts[i].trim();
            }
            return new Bus.BusBuilder()
                    .setNumber(fields[0])
                    .setModel(fields[1])
                    .setRun(Integer.parseInt(fields[2]))
                    .build();
        } else throw new CustomException("Ошибка конвертации (у объекта Bus должно быть 3 поля).");
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
             Integer.parseInt(run);
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
                    "Для выхода введите пустую строку (и нажмите Enter).""");
        while(true) {
            input = scanner.nextLine().trim();

            if(input.isEmpty()) {
                System.out.print("Выход.\n");
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
        scanner.close();
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(getListSize());;
//        System.out.println(mapStringToBus(",,"));
//        System.out.println(mapStringToBus("f,,"));
//        System.out.println(mapStringToBus(",f,"));
//        System.out.println(mapStringToBus(",,1"));
//        String[] parts = ",1,".split(",",-1);
//        for (int i = 0; i < parts.length; i++) {
//            System.out.println("*" + parts[i] + "*");
//        }
        System.out.println(isRunInstanceOfInteger("2"));
        System.out.println(isRunInstanceOfInteger("k"));
    }

}


//        String[] parts = string.split(",");
//        String number = parts[0].isBlank() ? null : parts[0].trim();
//        String model = parts[1].isBlank() ? null : parts[1].trim();
//        int run = parts[2].isBlank() ? 0 : Integer.parseInt(parts[2].trim());
//
//        Bus bus = new Bus.BusBuilder()
//                .setNumber(number)
//                .setModel(model)
//                .setRun(run)
//                .build();


/**
 * Метод запрашивает у пользователя "размер коллекции" целое положительное число
 * @return целое положительное число, если пользователь ничего не ввел, вернет 0.
 */
//static int getListSize() {
//    String input;
//    int size = 0;
//    System.out.println("Укажите размер коллекции (целое положительное число больше 0). Для выхода нажмите Q.");
//    try(Scanner scanner = new Scanner(System.in)) {
//        while (true) {
//            try {
//                input = scanner.nextLine();
//                if (input.equalsIgnoreCase("Q"))
//                    break;
//                size = Integer.parseInt(input);
//                break;
//            } catch (RuntimeException e) {
//                System.out.println("Вы ввели не число. Попробуйте еще раз");
//
//            }
//        }
//    }
//    return size;
//}

