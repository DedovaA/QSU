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
        List<Bus> buses = null;
        List<String> list = readFromFile();

        if(list == null)
            return buses;

        return list.stream()
                .map(ValidationUtils::mapStringToBus)
                .collect(Collectors.toList());
    }

    private static List<String> readFromFile() throws CustomException {
        Path path = getPath();
        if(path == null)
            return null;

        List<String> list;
        try (Stream<String> strings = Files.lines(path, StandardCharsets.UTF_8)) {
            list = strings.toList();
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла, попробуйте еще раз.");
            return null;
        }
        return list;
    }

    private static Path getPath() {
        System.out.println("Укажите путь к файлу. Или нажмите Q для выхода.");
        Scanner scanner = new Scanner(System.in);
        String input =  scanner.nextLine();
        if(input.equalsIgnoreCase("Q"))
            return null;
        if(input.isBlank()) {
            System.out.println("Имя файла не может быть пустым, попробуйте еще раз.");
            return null;
        }
        Path path = Path.of(input).toAbsolutePath();
        return isPathValid(path) ? path : null;
    }

    private static boolean isPathValid(Path path){
        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            System.out.println("Ошибка. Путь не существует или не является файлом, попробуйте еще раз.");
            return false;
        }
        return true;
    }

}
