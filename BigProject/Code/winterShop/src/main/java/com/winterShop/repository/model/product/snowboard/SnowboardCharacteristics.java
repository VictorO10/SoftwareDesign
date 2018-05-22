package com.winterShop.repository.model.product.snowboard;

import javax.persistence.*;

@Entity
public class SnowboardCharacteristics {

    @SequenceGenerator(
            name = "snowboardChars_seq",
            sequenceName = "snowboardChars_sequence",
            allocationSize = 50
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "snowboardChars_seq")
    @Id
    private Long snowboardCharacteristicsId;

    private Long length;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    SnowboardBase snowboardBase;

    public SnowboardCharacteristics() {
    }
}
