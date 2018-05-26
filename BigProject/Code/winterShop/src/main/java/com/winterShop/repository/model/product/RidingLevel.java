package com.winterShop.repository.model.product;

import com.winterShop.repository.model.product.snowboard.SnowboardBase;
import com.winterShop.repository.model.product.snowboardBoots.SnowboardBootsBase;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RidingLevel {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long ridingLevelId;

    private String level;

    private String levelDescription;

    @ManyToMany(mappedBy = "ridingLevelSet")
    private Set<SnowboardBootsBase> snowboardBootsBaseSet;

    @ManyToMany(mappedBy = "ridingLevelSet")
    private Set<SnowboardBase> snowboardBaseSet;

    public RidingLevel() {
    }

    public Long getRidingLevelId() {
        return ridingLevelId;
    }

    public void setRidingLevelId(Long ridingLevelId) {
        this.ridingLevelId = ridingLevelId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelDescription() {
        return levelDescription;
    }

    public void setLevelDescription(String levelDescription) {
        this.levelDescription = levelDescription;
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
