package Tests;


import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class JobTest {
    @Test
    public void testSettingJobId() {
        Job test_jobId = new Job();
        Job test_jobId2 = new Job();

        assertFalse(test_jobId.getId() == test_jobId2.getId());
        assertTrue(test_jobId2.getId() - test_jobId.getId() == 1);

    }

    @Test
    public void testJobContructorSetsAllFields() {
        Job test_job = new Job("Product tester", new Employer("ACME"),
        new Location("Desert"), new PositionType("Quality control"),
        new CoreCompetency("Persistence"));

        assertTrue(test_job.getName() == "Product tester");
        assertTrue(test_job.getEmployer().getValue() == "ACME");
        assertTrue(test_job.getLocation().getValue() == "Desert");
        assertTrue(test_job.getPositionType().getValue() == "Quality control");
        assertTrue(test_job.getCoreCompetency().getValue() == "Persistence");

        assertTrue(test_job.getEmployer() instanceof Employer);
        assertTrue(test_job.getLocation() instanceof Location);
        assertTrue(test_job.getPositionType() instanceof PositionType);
        assertTrue(test_job.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality() {
        Job test_job = new Job("Product tester", new Employer("ACME"),
         new Location("Desert"), new PositionType("Quality control"),
         new CoreCompetency("Persistence"));

        Job test_job1 = new Job("Product tester", new Employer("ACME"),
        new Location("Desert"), new PositionType("Quality control"),
        new CoreCompetency("Persistence"));

        assertFalse(test_job.equals(test_job1));
    }

    @Test
    public void testJobstoString() {
        Job test_job = new Job("Product tester", new Employer("ACME"),
        new Location("Desert"), new PositionType("Quality control"),
        new CoreCompetency("Persistence"));

        assertTrue(test_job.toString().endsWith("\n"));
        assertTrue(test_job.toString().startsWith("\n"));
    }

    @Test
    public void testJobstoString2() {
        Job test_job = new Job("Product tester", new Employer("ACME"),
        new Location("Desert"), new PositionType("Quality control"),
        new CoreCompetency("Persistence"));

        String[] someStrings1 = test_job.toString().split("\n");
        assertTrue(someStrings1[1].contains("ID: "));
        assertTrue(someStrings1[2].contains("Name: "));
        assertTrue(someStrings1[3].contains("Employer: "));
        assertTrue(someStrings1[4].contains("Location: "));
        assertTrue(someStrings1[5].contains("Position Type: "));
        assertTrue(someStrings1[6].contains("Core Competency: "));

    }

    @Test
    public void testEmptyField() {
        Job test_job = new Job("Product tester", new Employer("ACME"),
        new Location("Desert"), new PositionType("Quality control"),
        new CoreCompetency(""));

        assertTrue(test_job.toString().contains("Data not available"));
    }
}
