package ru.doploma.idealcarprice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "detail_xpaths")
@Data
@NoArgsConstructor
public class DetailXpath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Long id;

    @Column(name = "value", unique = true, nullable = false)
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detail_site_id")
    private DetailSite detailSite;

    @Override
    public String toString() {
        return "DetailXpath{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", detailSite=" + detailSite.getUrl() +
                '}';
    }
}
