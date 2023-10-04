package com.udacity.boogle.maps;

public class Address {

    private String address;
    private String city;
    private String state;
    private String zip;

    public Address() {}

    public Address(String address, String city, String state, String zip) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    // Getter và Setter tự động được tạo bởi IDE hoặc IDE của bạn

    @Override
    public String toString() {
        return address + ", " + city + ", " + state + " " + zip;
    }
}
