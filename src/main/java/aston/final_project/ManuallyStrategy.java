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
            System.out.println("Введите параметры автобусов в формате: номер, модель, пробег. Для выхода введите \"Q\" (и нажмите Enter).");
            for (int i = 0; i < size; i++) {
                System.out.printf("\nВведите параметры %d автобуса:\n", i + 1);
                while (true) {
                    userInput = scanner.nextLine();
                    if(userInput.equalsIgnoreCase("Q"))
                        return list;
                    if(userInput.isBlank()){
                        System.out.println("Вы ничего не ввели, попробуйте еще раз. Или нажмите Q для выхода.");
                        continue;
                    }
                    if(!ValidationUtils.isUserInputConsistOfThreeFields(userInput)) {
                        System.out.println("У объекта должно быть 3 поля, попробуйте еще раз. Или нажмите Q для выхода.");
                        continue;
                    }
                    if(!ValidationUtils.isUserInputValidRun(userInput)) {
                        continue;
                    }
                    list.add(userInput);
                    break;
                }
            }
//        scanner.close();
        return list;
    }

    @Override
    public String toString() {
        return "Консольный ввод (Manually)";
    }
}
