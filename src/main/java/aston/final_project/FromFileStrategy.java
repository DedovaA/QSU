package aston.final_project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FromFileStrategy implements DataSource {

    @Override
    public List<Bus> getBusList() throws CustomException {
        List<Bus> listBus = new ArrayList<>();
        List<String> listStrings = readFromFile();
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

    private static List<String> readFromFile() throws CustomException {
        Path path = getPath();
        if(path == null)
            return null;
        List<String> list;

        try (Stream<String> strings = Files.lines(path, StandardCharsets.UTF_8)) {
            list = strings.toList();
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла, попробуйте еще раз.\n");
            return null;
        }

        if (list.isEmpty()) {
            System.out.println("Файл не может быть пустым, попробуйте еще раз.\n");
            return null;
        }
        return list;
    }

    private static Path getPath() {
        Scanner scanner = new Scanner(System.in);
        String input;
        Path path = null;
        System.out.println("Укажите путь к файлу. Или нажмите Q для выхода.");
        while (true) {
            try {
                input =  scanner.nextLine();
                if(input.equalsIgnoreCase("Q"))
                    break;
                if(input.isBlank()) {
                    System.out.println("Имя файла не может быть пустым, попробуйте еще раз. Или нажмите Q для выхода.");
                    continue;
                }
                path = Path.of(input).toAbsolutePath();
                if (!Files.exists(path) || !Files.isRegularFile(path)) {
                    System.out.println("Путь не существует или не является файлом, попробуйте еще раз. Или нажмите Q для выхода.");
                    continue;
                }
                break;
            } catch (Throwable e) {
                System.out.println("Путь не существует или не является файлом, попробуйте еще раз. Или нажмите Q для выхода.");
            }
        }
//        scanner.close();
        return path;
    }

    @Override
    public String toString() {
        return "Из файла (FromFile)";
    }
}
