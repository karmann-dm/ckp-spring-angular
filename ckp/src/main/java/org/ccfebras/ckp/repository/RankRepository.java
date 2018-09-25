package org.ccfebras.ckp.repository;

import org.ccfebras.ckp.model.Rank;
import org.ccfebras.ckp.repository.base.CommonRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankRepository extends CommonRepository<Rank> {
    List<Rank> findAllByNameContaining(String name);
}
