package dto;

public enum DayTime {
    Morgen("Morgen"),
    Nachmittag("Nachmittag"),
    Abend("Abend");


    private String value;
    public String getValue() {
        return value;
    }
    private DayTime(String value) {
        this.value = value;
    }
}
