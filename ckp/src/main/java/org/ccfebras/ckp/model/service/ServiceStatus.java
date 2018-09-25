package org.ccfebras.ckp.model.service;

import org.ccfebras.ckp.model.ckp.CkpStatusName;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "service_statuses")
public class ServiceStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name = "name", length = 60)
    private ServiceStatusName name;
}
