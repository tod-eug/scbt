package dto;

public enum Districts {
    Mitte("Mitte"),
    Prenzlauer_Berg("Prenzlauer Berg"),
    Pankow("Pankow"),
    Kreuzberg("Kreuzberg"),
    Spandau("Spandau"),
    Charlottenburg("Charlottenburg"),
    Steglitz("Steglitz"),
    Zehlendorf("Zehlendorf"),
    Reinickendorf("Reinickendorf"),
    Neukölln("Neukölln"),
    Tempelhof("Tempelhof"),
    Lichtenberg("Lichtenberg"),
    Schöneberg("Schöneberg"),
    Köpenick("Köpenick"),
    Hellersdorf("Hellersdorf"),
    Wilmersdorf("Wilmersdorf"),
    Marzahn("Marzahn"),
    Friedrichshain("Friedrichshain");

    private String value;
    public String getValue() {
        return value;
    }
    private Districts(String value) {
        this.value = value;
    }
}
