package ru.doploma.idealcarprice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "supplier_sites")
@Data
@NoArgsConstructor
public class SupplierSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "url", unique = true, nullable = false)
    private String url;

    @OneToMany(mappedBy = "supplierSite", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SupplierXpath> supplierXpaths = new ArrayList<>();

    @Override
    public String toString() {
        return "SupplierSite{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
