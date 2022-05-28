package ru.doploma.idealcarprice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "service_prices")
@Data
@NoArgsConstructor
public class ServicePrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @OneToOne
    @JoinColumn(name = "regulations_id", referencedColumnName = "id")
    private Regulations regulations;

    @Override
    public String toString() {
        return "ServicePrice{" +
                "id=" + id +
                ", price=" + price +
                ", regulations=" + regulations.getCriterionName() +
                '}';
    }
}
