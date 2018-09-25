package org.ccfebras.ckp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ccfebras.ckp.model.base.AbstractEntity;
import org.ccfebras.ckp.model.ckp.Ckp;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "equipments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipment extends AbstractEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private String mark;

    @Column(name = "producer")
    private String producer;

    @Column(name = "hour_price")
    private Float hourPrice;

    @Column(name = "production_year")
    private String productionYear;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ckp_equipment_relation", joinColumns = {
            @JoinColumn(name = "equipment_id")
    }, inverseJoinColumns = { @JoinColumn(name = "ckp_id") })
    private Set<Ckp> ckps = new HashSet<>();
}
