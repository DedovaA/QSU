package aston.final_project;

enum Strategies {
    FROM_FILE("из файла"),
    MANUALLY("вручную"),
    RANDOMLY("рандомно");

    private final String title;

    Strategies(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Strategy {" + title + "}";
    }
}
