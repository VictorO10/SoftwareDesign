package com.winterShop.repository.model.order;

import com.winterShop.repository.model.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ShoppingCart {

    @SequenceGenerator(
            name="shoppingCart_seq",
            sequenceName = "shoppingCart_sequence",
            allocationSize = 5
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shoppingCart_seq")
    @Id
    private Long shoppingCartId;

    @OneToMany(mappedBy = "shoppingCart")
    private Set<ShoppingCartLine> shoppingCartLineSet;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public ShoppingCart() {
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Set<ShoppingCartLine> getShoppingCartLineSet() {
        return shoppingCartLineSet;
    }

    public void setShoppingCartLineSet(Set<ShoppingCartLine> shoppingCartLineSet) {
        this.shoppingCartLineSet = shoppingCartLineSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
