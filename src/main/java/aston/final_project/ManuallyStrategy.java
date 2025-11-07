package aston.final_project;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ManuallyStrategy implements DataSource {

    @Override
    public List<Bus> getBusList() throws CustomException{
        return manuallyInput().stream()
                .map(Utility::mapStringToBusWithoutNullFields)
                .collect(Collectors.toList());
    }

    private static List<String> manuallyInput() {
        int size = Utility.getListSize();
        List<String> list = new ArrayList<>();

        String userInput;
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < size; i++) {
                System.out.printf("""
                        Введите параметры %d автобусов в формате: номер, модель, пробег.
                        Пример ввода: `MAN, X00ME, 98000.
                        Для выхода введите пустую строку (и нажмите Enter).\n""", size);
                userInput = scanner.nextLine();
                if(userInput.equalsIgnoreCase("Q"))
                    return list;
                if(userInput.isBlank()){
                    System.out.println("Вы ничего не ввели, попробуйте еще раз.");
                    i--;
                    continue;
                } else if(!Utility.isUserInputConsistOfThreeFields(userInput)) {
                    System.out.println("Не достаточно полей, попробуйте еще раз.");
                    i--;
                    continue;
                }
                list.add(userInput);
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        manuallyInput().forEach(System.out::println);
        System.out.println(new ManuallyStrategy().getBusList());;

    }

}


//private static List<String> manuallyInput() {
////        int size = Utility.getListSize();
//    int size = 3;
//    List<String> list = new ArrayList<>();
//    System.out.println("Введите параметры " + size + " автобусов в формате: номер, модель, пробег.\n" +
//            "Пример ввода: `MAN, X00ME, 98000.\n" +
//            "Для выхода введите пустую строку (и нажмите Enter).");
//    String userInput;
//    try (Scanner scanner = new Scanner(System.in)) {
//        for (int i = 0; i < size; i++) {
//            if (!scanner.hasNextLine()) {
//                System.out.println("Вы ничего не ввели, попробуйте еще раз.");
//                continue;
//            }
//            userInput = scanner.nextLine();
//            if(userInput.isBlank()){
//                System.out.println("Ввод завершен.");
//                break;
//            }
//            list.add(userInput);
//        }
//    }
//    return list;
//}