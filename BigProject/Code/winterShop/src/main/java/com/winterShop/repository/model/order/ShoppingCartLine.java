package com.winterShop.repository.model.order;

import com.winterShop.repository.model.product.ProductWChars;

import javax.persistence.*;

@Entity
public class ShoppingCartLine {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long shoppingCartLineId;

    @ManyToOne
    @JoinColumn(name="productWCharsId", nullable=false)
    private ProductWChars productWChars;

    @ManyToOne
    @JoinColumn(name="shoppingCartId", nullable = false)
    private ShoppingCart shoppingCart;

    private Long ammount;

    public ShoppingCartLine() {
    }

    public Long getShoppingCartLineId() {
        return shoppingCartLineId;
    }

    public void setShoppingCartLineId(Long shoppingCartLineId) {
        this.shoppingCartLineId = shoppingCartLineId;
    }

    public ProductWChars getProductWChars() {
        return productWChars;
    }

    public void setProductWChars(ProductWChars productWChars) {
        this.productWChars = productWChars;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Long getAmmount() {
        return ammount;
    }

    public void setAmmount(Long ammount) {
        this.ammount = ammount;
    }
}
