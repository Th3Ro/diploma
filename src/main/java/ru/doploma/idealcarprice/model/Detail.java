package ru.doploma.idealcarprice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "details")
@Data
@NoArgsConstructor
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(mappedBy = "detail", fetch = FetchType.LAZY)
    @JsonIgnore
    private PartCode partCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regulations_id")
    private Regulations regulations;

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", partCode=" + partCode.getVendorCode() +
                '}';
    }
}
