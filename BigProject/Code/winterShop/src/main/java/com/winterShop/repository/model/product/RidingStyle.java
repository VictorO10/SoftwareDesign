package com.winterShop.repository.model.product;

import com.winterShop.repository.model.product.snowboard.SnowboardBase;
import com.winterShop.repository.model.product.snowboardBoots.SnowboardBootsBase;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RidingStyle {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long ridingStyleId;

    private String style;

    private String styleDescription;

    @ManyToMany(mappedBy = "ridingStyleSet")
    private Set<SnowboardBootsBase> snowboardBootsBaseSet;

    @ManyToMany(mappedBy = "ridingStyleSet")
    private Set<SnowboardBase> snowboardBaseSet;

    public RidingStyle() {
    }

    public Long getRidingStyleId() {
        return ridingStyleId;
    }

    public void setRidingStyleId(Long ridingStyleId) {
        this.ridingStyleId = ridingStyleId;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyleDescription() {
        return styleDescription;
    }

    public void setStyleDescription(String styleDescription) {
        this.styleDescription = styleDescription;
    }

    public Set<SnowboardBootsBase> getSnowboardBootsBaseSet() {
        return snowboardBootsBaseSet;
    }

    public void setSnowboardBootsBaseSet(Set<SnowboardBootsBase> snowboardBootsBaseSet) {
        this.snowboardBootsBaseSet = snowboardBootsBaseSet;
    }

    public Set<SnowboardBase> getSnowboardBaseSet() {
        return snowboardBaseSet;
    }

    public void setSnowboardBaseSet(Set<SnowboardBase> snowboardBaseSet) {
        this.snowboardBaseSet = snowboardBaseSet;
    }
}
