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
@Table(name = "departments", uniqueConstraints = {
        @UniqueConstraint(columnNames = "short_name")
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department extends UserDateAudit {
    @Column(name = "short_name")
    private String shortName;

    @Column(name = "full_name", columnDefinition = "TEXT")
    private String fullName;

    @OneToMany(mappedBy = "department")
    private List<Organization> organizations;
}
