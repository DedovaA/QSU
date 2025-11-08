package aston.final_project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

//        Map<Enum, DataSource> map = new HashMap<>();
//        map.put(Strategies.FROM_FILE, new FromFileStrategy());
//        map.put(Strategies.MANUALLY, new ManuallyStrategy());
//        map.put(Strategies.RANDOMLY, new RandomlyStrategy());

        List<Bus> list;
//        Strategies strategyKey = null;
        boolean isActive = true;
        Scanner scanner = new Scanner(System.in);
            while (isActive) {
                System.out.println("""
                    Выберите источник ввода данных для сортировки:
                    1 - из файла,
                    2 - вручную из консоли,
                    3 - рандомный список,
                    Q - для выхода,
                    и нажмите Enter.""");
                String userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("Q")) {
                    System.out.println("Выход из программы.");
                    return;
                } else {
                    switch (userInput) {
                        case "1" -> {
//                            SortUtils.quickSort(new FromFileStrategy().getBusList());
//                            list = map.get(Strategies.FROM_FILE).getBusList();
                            list = new FromFileStrategy().getBusList();
                            System.out.println("Unsorted list:");
                            list.forEach(System.out::println);
                            System.out.println("Sorted list:");
                            SortUtils.quickSort(list);
                            list.forEach(System.out::println);
                            isActive = false;
                        }
                        case "2" -> {
//                            SortUtils.quickSort(new ManuallyStrategy().getBusList());
//                            list = map.get(Strategies.MANUALLY).getBusList();
                            list = new ManuallyStrategy().getBusList();
                            if(!list.isEmpty()) {
                                System.out.println("Unsorted list:");
                                list.forEach(System.out::println);
                                System.out.println("даSorted list:");
                                SortUtils.quickSort(list);
                                list.forEach(System.out::println);
                                isActive = false;
                            } else isActive = false;
                        }
                        case "3" -> {
//                            SortUtils.quickSort(new RandomlyStrategy().getBusList());
//                            list = map.get(Strategies.RANDOMLY).getBusList();
                            list = new RandomlyStrategy().getBusList();
                            System.out.println("Unsorted list:");
                            list.forEach(System.out::println);
                            System.out.println("Sorted list:");
                            SortUtils.quickSort(list);
                            list.forEach(System.out::println);
                            isActive = false;
                        }
                        default -> System.out.println("Неверный ввод, попробуйте еще раз.");
                    }
                }
            }
        scanner.close();
    }
}
