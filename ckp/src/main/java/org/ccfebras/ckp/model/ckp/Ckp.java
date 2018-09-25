package org.ccfebras.ckp.model.ckp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ccfebras.ckp.model.*;
import org.ccfebras.ckp.model.base.UserDateAudit;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ckps")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ckp extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "organization_id", insertable = false, updatable = false)
    private Long organizationId;

    @Column(name = "head_full_name")
    private String headFullName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "head_degree_id")
    private Degree headDegree;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "head_rank_id")
    private Rank headRank;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "head_position_id")
    private Position headPosition;

    @Column(name = "head_phone")
    private String headPhone;

    @Column(name = "head_fax")
    private String headFax;

    @Column(name = "address")
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private CkpStatus status;

    @ManyToMany(mappedBy = "ckps")
    private Set<Equipment> equipments = new HashSet<>();
}
