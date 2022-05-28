package ru.doploma.idealcarprice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "supplier_xpaths")
@Data
@NoArgsConstructor
public class SupplierXpath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "value", unique = true, nullable = false)
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_site_id")
    private SupplierSite supplierSite;

    @Override
    public String toString() {
        return "SupplierXpath{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", supplierSite=" + supplierSite.getUrl() +
                '}';
    }
}
