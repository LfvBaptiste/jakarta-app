package fr.formation.jakarta.model.entity;

public class VintageCamera {
    private int id;
    private String name;
    private String brand;
    private int year;
    private double price;
    private String country;
    private String format;

    // Constructeur
    public VintageCamera(
            int id,
            String name,
            String brand,
            int year,
            double price,
            String country,
            String format
    ) {

        this.id = id;
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.country = country;
        this.format = format;
    }

    // Getters et Setters

    public int getId() {
        return id;
    }

    public VintageCamera setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public VintageCamera setName(String name) {
        this.name = name;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public VintageCamera setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public int getYear() {
        return year;
    }

    public VintageCamera setYear(int year) {
        this.year = year;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public VintageCamera setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public VintageCamera setCountry(String country) {
        this.country = country;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", country=" + country +
                ", format=" + format +
                '}';
    }
}
