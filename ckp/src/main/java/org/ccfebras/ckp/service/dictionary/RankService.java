package org.ccfebras.ckp.service.dictionary;

import org.ccfebras.ckp.model.Rank;
import org.ccfebras.ckp.repository.RankRepository;
import org.ccfebras.ckp.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankService extends AbstractService<Rank, RankRepository> {
    private final RankRepository rankRepository;

    @Autowired
    public RankService(RankRepository rankRepository) {
        this.rankRepository = rankRepository;
    }

    @Override
    public RankRepository getRepository() {
        return rankRepository;
    }

}
