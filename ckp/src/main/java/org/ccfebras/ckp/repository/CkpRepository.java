package org.ccfebras.ckp.repository;

import org.ccfebras.ckp.model.ckp.Ckp;
import org.ccfebras.ckp.model.ckp.CkpStatusName;
import org.ccfebras.ckp.repository.base.CommonRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CkpRepository extends CommonRepository<Ckp> {
    List<Ckp> getAllByStatusName(CkpStatusName ckpStatusName);
}
