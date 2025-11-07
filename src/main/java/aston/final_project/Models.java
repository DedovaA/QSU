package aston.final_project;

import java.util.*;
import java.util.stream.Collectors;

public enum Models {
    VOLVO("VOLVO"),
    MAN("MAN"),
    HYUNDAI("HYUNDAI");

    private final String title;

    Models(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Models {" + title + "}";
    }
}

 class Demo {
     public static void main(String[] args) {
         List<Models> models = Arrays.asList(Models.values());
         Set<String> busModels =  models.stream()
                 .map(Models::getTitle)
                 .collect(Collectors.toSet());
//         или просто
         Set<String> busModels1 =  Arrays.stream(Models.values())
                 .map(Models::getTitle)
                 .collect(Collectors.toSet());

         System.out.println(busModels);
         //проверяем есть ли такая модель
         String someModel = "egflaegh";
         String someModel2 = "HYUNDAI";
         System.out.println(busModels.contains(someModel));
         System.out.println(busModels.contains(someModel2));
     }
 }
