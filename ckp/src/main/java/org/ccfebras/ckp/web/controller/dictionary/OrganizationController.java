package org.ccfebras.ckp.web.controller.dictionary;

import org.ccfebras.ckp.model.Organization;
import org.ccfebras.ckp.service.dictionary.DictionaryService;
import org.ccfebras.ckp.web.dto.request.CreateOrganizationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dictionary/organization")
public class OrganizationController {
    @Autowired
    private DictionaryService dictionaryService;

    @Secured({"ROLE_MODERATOR", "ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<Organization> createOrganization(@Valid @RequestBody CreateOrganizationRequest request) {
        Organization organization = new Organization();
        organization.setShortName(request.getShortName());
        organization.setFullName(request.getFullName());
        organization.setDepartment(dictionaryService.findDepartmentById(request.getDepartmentId()));
        return new ResponseEntity<>(dictionaryService.saveOrganization(organization), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Organization>> getOrganizations(@RequestParam(
            value = "department",
            required = false
    ) Long departmentId) {
        if(departmentId == null)
            return new ResponseEntity<>(dictionaryService.findOrganizations(), HttpStatus.OK);
        else
            return new ResponseEntity<>(dictionaryService.findOrganizationsByDepartmentId(departmentId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organization> getOrganization(@PathVariable Long id) {
        return new ResponseEntity<>(dictionaryService.findOrganizationById(id), HttpStatus.OK);
    }

    @Secured({"ROLE_MODERATOR", "ROLE_ADMIN"})
    @PutMapping("/{id}")
    public ResponseEntity<Organization> updateOrganization(@PathVariable Long id,
                                                           @RequestBody CreateOrganizationRequest request) {
        Organization organization = dictionaryService.findOrganizationById(id);
        if(request.getDepartmentId() != null)
            organization.setDepartment(dictionaryService.findDepartmentById(request.getDepartmentId()));
        if(request.getShortName() != null)
            organization.setShortName(request.getShortName());
        if(request.getFullName() != null)
            organization.setFullName(request.getFullName());
        if(request.getInfo() != null)
            organization.setInfo(request.getInfo());
        return new ResponseEntity<>(dictionaryService.saveOrganization(organization), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrganization(@PathVariable Long id) {
        dictionaryService.deleteOrganization(id);
        return ResponseEntity.ok().build();
    }
}
