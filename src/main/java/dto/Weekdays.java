package dto;


public enum Weekdays {
    Montag("Montag"),
    Dienstag("Dienstag"),
    Mittwoch("Mittwoch"),
    Donnerstag("Donnerstag"),
    Freitag("Freitag"),
    Samstag("Samstag");

    private String value;
    public String getValue() {
        return value;
    }
    private Weekdays(String value) {
        this.value = value;
    }
}
