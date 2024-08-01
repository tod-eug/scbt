package dto;

public enum DayTime {
    Morning("Morning"),
    Day("Day"),
    Evening("Evening");


    private String value;
    public String getValue() {
        return value;
    }
    private DayTime(String value) {
        this.value = value;
    }
}
