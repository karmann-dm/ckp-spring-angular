package org.ccfebras.ckp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ccfebras.ckp.config.envers.HistoryField;
import org.ccfebras.ckp.config.envers.HistoryRoot;
import org.ccfebras.ckp.model.base.UserDateAudit;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "degrees", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@HistoryRoot(title = "Учёная степень")
public class Degree extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "degrees_seq")
    @SequenceGenerator(name = "degrees_seq", sequenceName = "degrees_id_seq")
    private Long id;

    @Column(name = "name")
    @HistoryField(title = "Наименование")
    private String name;

    @OneToMany(mappedBy = "degree")
    private List<User> users;
}
