package aston.final_project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Map<Enum, DataSource> strategies = new HashMap<>();
        strategies.put(Strategies.FROM_FILE, new FromFileStrategy());
        strategies.put(Strategies.MANUALLY, new ManuallyStrategy());
        strategies.put(Strategies.RANDOMLY, new RandomlyStrategy());

        List<Bus> list;

        try (Scanner scanner = new Scanner(System.in)) {
            String input;
            while (true) {
                System.out.println("""
                        Выберите источник ввода данных для сортировки:
                        1 - из файла,
                        2 - вручную из консоли,
                        3 - рандомный список,
                        Q - для выхода,
                        и нажмите Enter.""");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("Q")) {
                    System.out.println("Выход из программы.");
                    return;
                }
                Enum key = switch (input.trim()) {
                    case "1" -> Strategies.FROM_FILE;
                    case "2" -> Strategies.MANUALLY;
                    case "3" -> Strategies.RANDOMLY;
                    default -> null;
                };
                if (key == null) {
                    System.out.println("Неверный ввод, попробуйте еще раз.");
                    continue;
                }
                list = strategies.get(key).getBusList();
                if (list != null && !list.isEmpty()) {
                    printResult(list);
                    break;
                }
            }
        }
    }

    private static void printResult(List<Bus> list) {
        System.out.println("Unsorted list:");
        list.forEach(System.out::println);
        System.out.println("Sorted list:");
        SortUtils.quickSort(list);
        list.forEach(System.out::println);
    }
}
