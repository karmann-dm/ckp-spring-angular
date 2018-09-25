package org.ccfebras.ckp.repository;

import org.ccfebras.ckp.model.Position;
import org.ccfebras.ckp.repository.base.CommonRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends CommonRepository<Position> {
    List<Position> findAllByNameContaining(String name);
}
