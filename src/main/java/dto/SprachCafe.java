package dto;

public class SprachCafe {

    private final String name;
    private final String address;
    private final String district;
    private final String contact;
    private final String info;

    public SprachCafe(String name,
                      String address,
                      String district,
                      String contact,
                      String info) {
        this.name = name;
        this.address = address;
        this.district = district;
        this.contact = contact;
        this.info = info;
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
}
