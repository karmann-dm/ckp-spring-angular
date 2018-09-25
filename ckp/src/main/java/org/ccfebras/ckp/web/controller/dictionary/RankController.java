package org.ccfebras.ckp.web.controller.dictionary;

import org.ccfebras.ckp.model.Rank;
import org.ccfebras.ckp.repository.RankRepository;
import org.ccfebras.ckp.service.dictionary.RankService;
import org.ccfebras.ckp.web.controller.base.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dictionary/")
public class RankController extends AbstractController<Rank, RankRepository, RankService> {
    private final RankService rankService;

    @Autowired
    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @Override
    public RankService getService() {
        return rankService;
    }
}
