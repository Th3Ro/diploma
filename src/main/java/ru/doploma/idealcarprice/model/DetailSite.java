package ru.doploma.idealcarprice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "detail_sites")
@Data
@NoArgsConstructor
public class DetailSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "url", unique = true)
    private String url;

    @OneToMany(mappedBy = "detailSite", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DetailXpath> detailXpaths = new ArrayList<>();
}
