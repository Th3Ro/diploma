package ru.doploma.idealcarprice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "part_codes")
@Data
@NoArgsConstructor
public class PartCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "vendor_code")
    private String vendorCode;

    @ManyToOne
    @JoinColumn(name = "detail_id")
    private Detail detail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;

    @Override
    public String toString() {
        return "PartCode{" +
                "id=" + id +
                ", vendorCode='" + vendorCode + '\'' +
                ", detail=" + detail.getName() +
                ", model=" + model.getName() +
                '}';
    }
}
