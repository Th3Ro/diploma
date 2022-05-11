package ru.doploma.idealcarprice.model;

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

    @Column(name = "vendor_code")
    private String name;

    @OneToMany(mappedBy = "repairType", fetch = FetchType.LAZY)
    private List<Defect> defects;
}
