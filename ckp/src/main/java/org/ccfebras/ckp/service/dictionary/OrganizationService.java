package org.ccfebras.ckp.service.dictionary;

import org.ccfebras.ckp.model.Organization;
import org.ccfebras.ckp.repository.OrganizationRepository;
import org.ccfebras.ckp.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService extends AbstractService<Organization, OrganizationRepository> {
    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public OrganizationRepository getRepository() {
        return this.organizationRepository;
    }
}
