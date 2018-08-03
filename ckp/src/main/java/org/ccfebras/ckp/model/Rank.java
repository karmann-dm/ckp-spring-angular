package org.ccfebras.ckp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ccfebras.ckp.model.base.UserDateAudit;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ranks", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rank extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rank_seq")
    @SequenceGenerator(name = "rank_seq", sequenceName = "ranks_id_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "rank")
    private List<User> users;
}
