package ru.doploma.idealcarprice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "service_xpaths")
@Data
@NoArgsConstructor
public class ServiceXpath {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "value", unique = true, nullable = false)
    private String value;

    @ManyToMany(mappedBy = "serviceXpaths", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<RepairType> repairType = new ArrayList<>();

    @ManyToMany(mappedBy = "serviceXpaths", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Detail> details = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_site_id")
    private ServiceSite serviceSite;
}
