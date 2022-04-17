package ru.doploma.idealcarprice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "defects")
@Data
@NoArgsConstructor
public class Defect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "name")
    private String name;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "details_defects",
//            joinColumns = @JoinColumn(name = "defect_id"),
//            inverseJoinColumns = @JoinColumn(name = "detail_id")
//    )
//    private List<Detail> details;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repairType_id")
    private RepairType repairType;
}
