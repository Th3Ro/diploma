package ru.doploma.idealcarprice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repairType_id")
    @JsonIgnore
    private RepairType repairType;

    @Override
    public String toString() {
        return "Defect{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", repairType=" + repairType.getName() +
                '}';
    }
}
