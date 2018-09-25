package org.ccfebras.ckp.repository;

import org.ccfebras.ckp.model.Degree;
import org.ccfebras.ckp.repository.base.CommonRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DegreeRepository extends CommonRepository<Degree> {
    List<Degree> findAllByNameContaining(String name);
}
