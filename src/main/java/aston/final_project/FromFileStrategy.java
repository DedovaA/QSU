package aston.final_project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FromFileStrategy implements DataSource {

    @Override
    public List<Bus> getBusList() throws CustomException {
        return  readFromFile().stream()
                .map(Utility::mapStringToBusWithoutNullFields)
                .collect(Collectors.toList());
    }

    private static List<String> readFromFile() throws CustomException {
        String path = getPath();

        Path file = validatePath(path);

        List<String> list;
        try (Stream<String> strings = Files.lines(file, StandardCharsets.UTF_8)) {
            list = strings.toList();
        } catch (IOException e) {
            throw new CustomException("Ошибка чтения файла. Message: " + e.getMessage());
        }
        return list;
    }

    private static String getPath(){
        String userInput;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Укажите путь к файлу.");
            userInput = scanner.nextLine();
        }
        return userInput;
    }

    private static Path validatePath(String fileName) throws CustomException {
        if(fileName == null || fileName.isBlank())
            throw new CustomException("Имя файла не может быть пустым или null");
        Path path = Path.of(fileName).toAbsolutePath();
        if (!Files.isRegularFile(path))
            throw new CustomException("Ошибка. " + path + " не является файлом или не существует.");
        return path;
    }

}
