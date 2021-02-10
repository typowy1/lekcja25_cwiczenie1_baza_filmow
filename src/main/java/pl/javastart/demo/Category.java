package pl.javastart.demo;

public enum Category {
    COMEDY("Komedia"), SCIFI("Sci-Fi"), DRAMA("Dramat");

    private String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
