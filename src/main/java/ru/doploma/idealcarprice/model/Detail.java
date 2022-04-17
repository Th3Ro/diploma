package ru.doploma.idealcarprice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
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

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "details_defects",
//            joinColumns = @JoinColumn(name = "detail_id"),
//            inverseJoinColumns = @JoinColumn(name = "defect_id")
//    )
//    private List<Defect> defects;

    @OneToMany(mappedBy = "detail", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    private List<PartCode> partCodes;
}
