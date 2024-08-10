package dto;

public enum Districts {
    Mitte("Mitte"),
    Friedrichshain("Friedrichshain"),
    Pankow("Pankow"),
    Kreuzberg("Kreuzberg"),
    Spandau("Spandau"),
    Steglitz("Steglitz"),
    Zehlendorf("Zehlendorf"),
    Reinickendorf("Reinickendorf"),
    Neukölln("Neukölln"),
    Tempelhof("Tempelhof"),
    Schöneberg("Schöneberg"),
    Köpenick("Köpenick"),
    Hellersdorf("Hellersdorf"),
    Wilmersdorf("Wilmersdorf"),
    Marzahn("Marzahn"),
    Charlottenburg("Charlottenburg"),
    Prenzlauer_Berg("Prenzlauer Berg");

    private String value;
    public String getValue() {
        return value;
    }
    private Districts(String value) {
        this.value = value;
    }
}
