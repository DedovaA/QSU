package aston.final_project;

import java.util.*;

public class App {
    private static final DataSource[] strategyArr = {new FromFileStrategy(),new ManuallyStrategy(),new RandomlyStrategy()};

//    static Map<String, DataSource> getMap(DataSource[] arr) {
//        Map<String, DataSource> map = new HashMap<>();
//        for (int i = 0; i < strategyArr.length; i++) {
//            map.put(String.valueOf(i + 1), arr[i]);
//        }
//        return map;
//    }

//    static String createMainMenu(DataSource[] arr) {
//        StringBuilder message = new StringBuilder("Выберите источник ввода данных для сортировки:\n");
//        for (int i = 0; i < strategyArr.length; i++) {
//            message.append((i + 1)).append(" - ").append(arr[i].toString()).append("\n");
//        }
//        message.append("Q - для выхода");
//        return message.toString();
//    }

    public static void main(String[] args) {
//        Map<String, DataSource> strategyMap = getMap(strategyArr);
//        String mainMenuMessage = createMainMenu(strategyArr);
        Map<String, DataSource> strategyMap = new StrategyMap(strategyArr).getMap();
        String mainMenuMessage = new MainMenu(strategyArr).getMenu();
        List<Bus> list;

        try (Scanner scanner = new Scanner(System.in)) {
            String input;
            while (true) {
                System.out.println(mainMenuMessage);
                input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("Q")) {
                    System.out.println("Выход из программы.");
                    return;
                }

                if (!strategyMap.containsKey(input)) {
                    System.out.println("Неверный ввод, попробуйте еще раз.");
                    continue;
                }
                list = strategyMap.get(input).getBusList();
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
