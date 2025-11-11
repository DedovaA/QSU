package aston.final_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static aston.final_project.ValidationUtils.getListSize;

public class RandomlyStrategy implements DataSource {
    private static final Random random = new Random();
    private static final String[] MODELS = {"Volvo", "MAN", "Hyundai", null};

    @Override
    public List<Bus> getBusList() {
        List<Bus> list = new ArrayList<>();
        int size = getListSize();
        for (int i = 0; i < size; i++) {
            Bus bus = getRandomBus();
            list.add(bus);
        }
        return list;
    }

    private static Bus getRandomBus() {
        String number = String.valueOf(random.nextInt(100) + 100);
        String model = MODELS[random.nextInt(MODELS.length)];
        int run = random.nextInt(100) * 1000;
        return new Bus.BusBuilder().setNumber(number).setModel(model).setRun(run).build();
    }

    @Override
    public String toString() {
        return "Рандомная генерация (Randomly)";
    }
}
