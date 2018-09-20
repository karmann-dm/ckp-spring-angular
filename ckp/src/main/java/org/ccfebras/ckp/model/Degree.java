package org.ccfebras.ckp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @HistoryField(title = "Наименование")
    private String name;

    @OneToMany(mappedBy = "degree")
    @JsonIgnore
    private List<User> users;
}
