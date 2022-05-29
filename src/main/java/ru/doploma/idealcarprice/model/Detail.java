package ru.doploma.idealcarprice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

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

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "detail")
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    @JsonIgnore
    private List<PartCode> partCodes;

    @ManyToMany(mappedBy = "details", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Regulations> regulations = new ArrayList<>();

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
