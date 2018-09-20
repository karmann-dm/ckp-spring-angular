package org.ccfebras.ckp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ccfebras.ckp.model.base.UserDateAudit;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "positions", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Position extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "position")
    private List<User> users;
}
