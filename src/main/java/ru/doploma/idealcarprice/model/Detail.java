package ru.doploma.idealcarprice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "details")
@Data
@NoArgsConstructor
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "detail", fetch = FetchType.LAZY)
    @JsonIgnore
    private PartCode partCode;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "details_service_xpaths",
            joinColumns = @JoinColumn(name = "detail_id"),
            inverseJoinColumns = @JoinColumn(name = "service_xpath_id")
    )
    @JsonIgnore
    private List<ServiceXpath> serviceXpaths = new ArrayList<>();

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", partCode=" + partCode.getVendorCode() +
                '}';
    }
}
