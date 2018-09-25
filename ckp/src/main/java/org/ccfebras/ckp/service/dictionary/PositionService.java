package org.ccfebras.ckp.service.dictionary;

import org.ccfebras.ckp.model.Position;
import org.ccfebras.ckp.repository.PositionRepository;
import org.ccfebras.ckp.service.base.AbstractService;
import org.ccfebras.ckp.web.dto.filter.NameFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService extends AbstractService<Position, PositionRepository> {
    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public PositionRepository getRepository() {
        return positionRepository;
    }
}
