package Homework6;

public class Laptop {
    private String name;
    private String ram;
    private String hdd;
    private String os;
    private String color;

    public Laptop(String name, String ram, String hdd, String os, String color) {
        this.name = name;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getRam() {
        return ram;
    }

    public String getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Laptop [name=" + name + ", ram=" + ram + ", hdd=" + hdd + ", os="
                + os + ", color=" + color + "]";
    }
}