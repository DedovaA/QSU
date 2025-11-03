package aston.final_project;

public enum Strategy {
    FROM_FILE("из файла"),
    MANUALLY("вручную"),
    RANDOMLY("рандомно");

    private final String title;

    Strategy(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Strategy {" + title + "}";
    }
}
