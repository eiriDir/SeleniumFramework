package org.example.enums;

public enum TextData {
    EMAIL("eiridyr@gmail.com"),
    PASSWORD("Wg6y2"),

    BASE_URL("https://demo.solomono.net"),
    MENU_APPLIANCES_URL("https://demo.solomono.net/uk/pobutova-tehnika/c-417.html"),
    APPLIANCES_PRODUCT_URL("https://demo.solomono.net/uk/kenwood-zjm-810/p-559.html"),
    MENU_LAPTOP_URL("https://demo.solomono.net/laptops/c-378.html"),
    LAPTOP_PRODUCT_URL("https://demo.solomono.net/apple-macbook-air/p-543.html"),
    CHECKOUT_URL("https://demo.solomono.net/uk/checkout.php"),
    FORGOTTEN_PASSWORD_URL("https://demo.solomono.net/password_forgotten.php");

    private final String text;

    TextData(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
