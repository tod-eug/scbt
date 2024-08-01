package dto;


public enum Weekdays {
    Monday("Monday"),
    Tuesday("Tuesday"),
    Wednesday("Wednesday"),
    Thursday("Thursday"),
    Friday("Friday"),
    Saturday("Saturday");

    private String value;
    public String getValue() {
        return value;
    }
    private Weekdays(String value) {
        this.value = value;
    }
}
