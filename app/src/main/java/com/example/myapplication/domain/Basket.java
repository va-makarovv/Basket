package com.example.myapplication.domain;

import com.example.myapplication.exception.BasketOverflow;

import java.io.Serializable;

public class Basket implements Serializable {
    private Product[] arrProduct;

    public Product[] getArrProduct() {

        return arrProduct;
    }

    public Basket() {
        arrProduct = new Product[10];
    }


    public void addProd(Product product){
        for(int i = 0; i <= 10; i++){
            if (arrProduct[i] == null){
                arrProduct[i] = product;
            } else if ((arrProduct[arrProduct.length - 1] != null)) {
                throw new BasketOverflow("Your basket is full");
            }

        }
    }
    public void remProduct(Product product) {
        boolean isDelit = false;
        for (int i = 0; i < 10; i++) {
            if (isDelit){
                arrProduct[i] = arrProduct[i - 1];
            }
            else if (arrProduct[i].equals(product)) {
                arrProduct[i] = null;
                isDelit = true;
            }
        }
        arrProduct[9] = null;
    }
    public void clearAll(){
        arrProduct = new Product[10];
    }
    public boolean contain(Product product){
        for (int i = 0; i < 10; i++) {
            if(product.equals(arrProduct[i])){
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Product p:
                arrProduct) {
            stringBuilder.append(p.getName()).append('\n');
        }
        return stringBuilder.toString();
    }

}
