package dto;

public class RequestParameters {

    private String weekDay;
    private String district;
    private String dayTime;

    public RequestParameters(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public String getDistrict() {
        return district;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }
}
