package aston.final_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static aston.final_project.Utility.getListSize;

public class RandomlyStrategy implements StrategyFill{
    private static final Random random = new Random();
    private static final String[] MODELS = {"Volvo", "MAN", "Hyundai"};

    @Override
    public List<Bus> getDataToList() throws CustomException{
        //return IntStream.range(0, getListSize()).mapToObj(i -> getRandomBus()).collect(Collectors.toList());
        List<Bus> list = new ArrayList<>();
        int size = getListSize();
        for (int i = 0; i < size; i++) {
            Bus bus = getRandomBus();
            list.add(bus);
        }
        return list;
    }

    private static Bus getRandomBus() {
        String number = String.valueOf(random.nextInt(1000) + 1000);
        String model = MODELS[random.nextInt(MODELS.length)];
        int run = (random.nextInt(100) + 100) * 1000;
        return new Bus.BusBuilder().setNumber(number).setModel(model).setRun(run).build();
    }

}
