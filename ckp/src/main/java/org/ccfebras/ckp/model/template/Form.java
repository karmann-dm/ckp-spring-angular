package org.ccfebras.ckp.model.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ccfebras.ckp.model.base.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "forms")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Form extends AbstractEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "config")
    private String config;
}
