package jakubfilipiak.interntasks.learnhibernate.models;

public enum Color {

    RED("R"),
    GREEN("G"),
    BLUE("B");

    private String firstLetter;

    Color(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public static Color fromFirstLetter(String letter) {
        for (Color color : Color.values()) {
            if (color.firstLetter.equals(letter)) return color;
        }
        return null;
    }

    public String getFirstLetter() {
        return firstLetter;
    }
}
