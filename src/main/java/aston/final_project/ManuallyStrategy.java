package aston.final_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ManuallyStrategy implements StrategyFill{

    @Override
    public List<Bus> getDataToList() throws CustomException{
        return manuallyInput().stream()
                .map(Utility::mapStringToBus)
                .collect(Collectors.toList());
    }

    private static List<String> manuallyInput() {
//        int size = Utility.getListSize();
        int size = 3;
        List<String> list = new ArrayList<>();
        System.out.println("Введите параметры " + size + " автобусов в формате: номер, модель, пробег.\n" +
                "Пример ввода: `MAN, X00ME, 98000.\n" +
                "Для выхода введите пустую строку (и нажмите Enter).");
        String userInput;
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < size; i++) {
                if (!scanner.hasNextLine()) {
                    System.out.println("NO");
                    continue;
                }
                userInput = scanner.nextLine();
                if(userInput.isBlank()){
                    System.out.println("Ввод завершен.");
                    break;
                }
                list.add(userInput);
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        System.out.println(getListSize());
        manuallyInput().forEach(System.out::println);

//        Scanner scanner = new Scanner(System.in);
//        System.out.println(scanner.nextLine());;
    }

}
