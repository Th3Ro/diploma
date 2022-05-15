package ru.doploma.idealcarprice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "service_sites")
@Data
@NoArgsConstructor
public class ServiceSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "url", unique = true, nullable = false)
    private String url;

    @ManyToMany(mappedBy = "serviceSites", fetch = FetchType.LAZY)
    @JsonIgnore
    List<City> cities = new ArrayList<>();

    @OneToMany(mappedBy = "serviceSite", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ServiceXpath> serviceXpaths = new ArrayList<>();
}
