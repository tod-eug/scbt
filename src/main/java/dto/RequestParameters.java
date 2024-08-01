package dto;

public class RequestParameters {

    private Weekdays weekDay;
    private Districts district;
    private DayTime dayTime;

    public RequestParameters(Weekdays weekDay) {
        this.weekDay = weekDay;
    }

    public Weekdays getWeekDay() {
        return weekDay;
    }

    public Districts getDistrict() {
        return district;
    }

    public DayTime getDayTime() {
        return dayTime;
    }

    public void setWeekDay(Weekdays weekDay) {
        this.weekDay = weekDay;
    }

    public void setDistrict(Districts district) {
        this.district = district;
    }

    public void setDayTime(DayTime dayTime) {
        this.dayTime = dayTime;
    }
}
