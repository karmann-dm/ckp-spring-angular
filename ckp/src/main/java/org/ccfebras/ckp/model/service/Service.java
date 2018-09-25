package org.ccfebras.ckp.model.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ccfebras.ckp.model.Equipment;
import org.ccfebras.ckp.model.base.AbstractEntity;
import org.ccfebras.ckp.model.template.Template;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "services")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Service extends AbstractEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status")
    private ServiceStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "template_id")
    private Template template;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "service_equipment_relation",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    private List<Equipment> equipments = new ArrayList<>();
}
