package aston.final_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManuallyStrategy implements DataSource {
    @Override
    public List<Bus> getBusList() throws CustomException{
        List<Bus> listBus = new ArrayList<>();
        List<String> listStrings = manuallyInput();
        if(listStrings == null)
            return listBus;
        Bus bus;
        for (int i = 0; i < listStrings.size(); i++) {
            bus = ValidationUtils.mapStringToBus(listStrings.get(i));
            if(bus != null)
                listBus.add(bus);
            else
                return null;
        }
        return listBus;
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
                System.out.printf("Введите параметры %d автобуса:\n", i + 1);
                userInput = scanner.nextLine();
                if(userInput.equalsIgnoreCase("Q"))
                    return list;
                if(userInput.isBlank()){
                    System.out.println("Вы ничего не ввели, попробуйте еще раз.");
                    i--;
                    continue;
                } else if(!ValidationUtils.isUserInputConsistOfThreeFields(userInput)) {
                    System.out.println("У объекта должно быть 3 поля, попробуйте еще раз.");
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
