package aston.final_project;

enum Strategies {
    FROM_FILE("1"),
    MANUALLY("2"),
    RANDOMLY("3");

    private final String title;

    Strategies(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Strategy {" + title + "}";
    }
}
