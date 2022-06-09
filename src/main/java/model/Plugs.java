package main.java.model;


public enum Plugs {
    TYPE1,
    TYPE2,
    CSS2,
    CHAdeMO;

    public static Plugs fromCheckboxLabel(String label) {
        return switch (label) {
            case "tipo1" -> TYPE1;
            case "tipo2" -> TYPE2;
            case "CSS2" -> CSS2;
            case "CHAdeMO" -> CHAdeMO;
            default -> null;
        };
    }
}
