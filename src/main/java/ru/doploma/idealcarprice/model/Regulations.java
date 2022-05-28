package ru.doploma.idealcarprice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "regulations")
@Data
@NoArgsConstructor
public class Regulations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "criterion_name", unique = true, nullable = false)
    private String criterionName;

    @Column(name = "is_need_body_work", nullable = false)
    private boolean isNeedBodyWork;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "regulations_body_works",
            joinColumns = { @JoinColumn(name = "regulations_id") },
            inverseJoinColumns = { @JoinColumn(name = "body_work_id") }
    )
    @JsonIgnore
    private List<BodyWork> bodyWorks = new ArrayList<>();

    @OneToOne(mappedBy = "regulations")
    @JsonIgnore
    private ServicePrice servicePrice;

    @OneToMany(mappedBy = "regulations", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Detail> details;

    @Override
    public String toString() {
        return "Regulation{" +
                "id=" + id +
                ", criterionName='" + criterionName + '\'' +
                ", servicePrice=" + servicePrice.getPrice() +
                '}';
    }
}
