// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package net.lc4ever.framework.domain.cdm;

import java.util.Iterator;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import net.lc4ever.framework.domain.cdm.Domain;
import net.lc4ever.framework.domain.cdm.DomainDataOnDemand;
import net.lc4ever.framework.domain.cdm.DomainIntegrationTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect DomainIntegrationTest_Roo_IntegrationTest {
    
    declare @type: DomainIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: DomainIntegrationTest: @ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml");
    
    declare @type: DomainIntegrationTest: @Transactional;
    
    @Autowired
    DomainDataOnDemand DomainIntegrationTest.dod;
    
    @Test
    public void DomainIntegrationTest.testCountDomains() {
        Assert.assertNotNull("Data on demand for 'Domain' failed to initialize correctly", dod.getRandomDomain());
        long count = Domain.countDomains();
        Assert.assertTrue("Counter for 'Domain' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void DomainIntegrationTest.testFindDomain() {
        Domain obj = dod.getRandomDomain();
        Assert.assertNotNull("Data on demand for 'Domain' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Domain' failed to provide an identifier", id);
        obj = Domain.findDomain(id);
        Assert.assertNotNull("Find method for 'Domain' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Domain' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void DomainIntegrationTest.testFindAllDomains() {
        Assert.assertNotNull("Data on demand for 'Domain' failed to initialize correctly", dod.getRandomDomain());
        long count = Domain.countDomains();
        Assert.assertTrue("Too expensive to perform a find all test for 'Domain', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Domain> result = Domain.findAllDomains();
        Assert.assertNotNull("Find all method for 'Domain' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Domain' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void DomainIntegrationTest.testFindDomainEntries() {
        Assert.assertNotNull("Data on demand for 'Domain' failed to initialize correctly", dod.getRandomDomain());
        long count = Domain.countDomains();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Domain> result = Domain.findDomainEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Domain' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Domain' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void DomainIntegrationTest.testFlush() {
        Domain obj = dod.getRandomDomain();
        Assert.assertNotNull("Data on demand for 'Domain' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Domain' failed to provide an identifier", id);
        obj = Domain.findDomain(id);
        Assert.assertNotNull("Find method for 'Domain' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyDomain(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'Domain' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void DomainIntegrationTest.testMergeUpdate() {
        Domain obj = dod.getRandomDomain();
        Assert.assertNotNull("Data on demand for 'Domain' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Domain' failed to provide an identifier", id);
        obj = Domain.findDomain(id);
        boolean modified =  dod.modifyDomain(obj);
        Integer currentVersion = obj.getVersion();
        Domain merged = (Domain)obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Domain' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void DomainIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'Domain' failed to initialize correctly", dod.getRandomDomain());
        Domain obj = dod.getNewTransientDomain(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Domain' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Domain' identifier to be null", obj.getId());
        try {
            obj.persist();
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        obj.flush();
        Assert.assertNotNull("Expected 'Domain' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void DomainIntegrationTest.testRemove() {
        Domain obj = dod.getRandomDomain();
        Assert.assertNotNull("Data on demand for 'Domain' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Domain' failed to provide an identifier", id);
        obj = Domain.findDomain(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Domain' with identifier '" + id + "'", Domain.findDomain(id));
    }
    
}
