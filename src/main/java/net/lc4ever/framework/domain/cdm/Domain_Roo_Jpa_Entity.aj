// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.lc4ever.framework.domain.cdm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import net.lc4ever.framework.domain.cdm.Domain;

privileged aspect Domain_Roo_Jpa_Entity {
    
    declare @type: Domain: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Domain.id;
    
    @Version
    @Column(name = "version")
    private Integer Domain.version;
    
    public Long Domain.getId() {
        return this.id;
    }
    
    public void Domain.setId(Long id) {
        this.id = id;
    }
    
    public Integer Domain.getVersion() {
        return this.version;
    }
    
    public void Domain.setVersion(Integer version) {
        this.version = version;
    }
    
}
