package ru.doploma.idealcarprice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "repair_types")
@Data
@NoArgsConstructor
public class RepairType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "repairType", fetch = FetchType.LAZY)
    private List<Defect> defects;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "repair_types_service_xpaths",
            joinColumns = @JoinColumn(name = "repair_type_id"),
            inverseJoinColumns = @JoinColumn(name = "service_xpath_id")
    )
    @JsonIgnore
    private List<ServiceXpath> serviceXpaths;
}
