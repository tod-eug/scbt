package dto;

import java.util.Date;

public class SprachCafe {

    private final String name;
    private final String address;
    private final String district;
    private final String contact;
    private final String info;
    private final Date startTime;
    private final Date endTime;

    public SprachCafe(String name,
                      String address,
                      String district,
                      String contact,
                      String info,
                      Date startTime,
                      Date endTime) {
        this.name = name;
        this.address = address;
        this.district = district;
        this.contact = contact;
        this.info = info;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public String getContact() {
        return contact;
    }

    public String getInfo() {
        return info;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
}
