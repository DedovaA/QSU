package aston.final_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ManuallyStrategy implements DataSource {
    @Override
    public List<Bus> getBusList() throws CustomException{
        return manuallyInput().stream()
                .map(ValidationUtils::mapStringToBusWithoutNullFields)
                .collect(Collectors.toList());
    }

    private static List<String> manuallyInput() {
        List<String> list = new ArrayList<>();
        int size = ValidationUtils.getListSize();
        if (size == 0)
            return list;
        String userInput;
        Scanner scanner = new Scanner(System.in);
            System.out.printf("""
                        Введите параметры автобуса в формате: номер, модель, пробег.
                        Пример ввода: `X00ME, MAN, 98000.
                        Для выхода введите "Q" (и нажмите Enter).\n""", size);
            for (int i = 0; i < size; i++) {
                userInput = scanner.nextLine();
                if(userInput.equalsIgnoreCase("Q"))
                    return list;
                if(userInput.isBlank()){
                    System.out.println("Вы ничего не ввели, попробуйте еще раз.");
                    i--;
                    continue;
                } else if(!ValidationUtils.isUserInputConsistOfThreeFields(userInput)) {
                    System.out.println("Не достаточно полей, попробуйте еще раз.");
                    i--;
                    continue;
                }
                list.add(userInput);
            }
//        scanner.close();
        return list;
    }

    @Override
    public String toString() {
        return "Консольный ввод (Manually)";
    }
}


//private static List<String> manuallyInput() {
////        int size = ValidationUtils.getListSize();
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