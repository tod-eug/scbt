package dto;

public enum Districts {
    Mitte("Mitte"),
    Kreuzberg("Kreuzberg"),
    Pankow("Pankow"),
    Spandau("Spandau");

    private String value;
    public String getValue() {
        return value;
    }
    private Districts(String value) {
        this.value = value;
    }
}
