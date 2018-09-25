package org.ccfebras.ckp.model.ckp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "ckp_statuses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CkpStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name = "name", length = 60)
    private CkpStatusName name;
}
