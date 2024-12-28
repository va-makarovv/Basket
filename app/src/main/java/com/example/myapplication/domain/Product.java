package com.example.myapplication.domain;

import java.util.Objects;

public class Product {
    private final String nameProd;
    private final String imgUrl;
    private final String descProd;

    public Product(String nameProd, String imgUrl, String descProd) {
        this.nameProd = nameProd;
        this.imgUrl = imgUrl;
        this.descProd = descProd;
    }

    public String getNameProd() {
        return nameProd;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getDescProd() {
        return descProd;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "name='" + nameProd + '\'' +
                ", image_url='" + imgUrl + '\'' +
                ", description='" + descProd + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameProd, product.nameProd) && Objects.equals(imgUrl, product.imgUrl) && Objects.equals(descProd, product.descProd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProd, imgUrl, descProd);
    }
}
