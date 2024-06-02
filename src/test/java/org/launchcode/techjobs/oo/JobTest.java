package org.launchcode.techjobs.oo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {

    @Before
    public void setUp() {
        Job.resetNextId();
    }

    @Test
    public void testSettingJobId(){
        Job jobA = new Job();
        Job jobB = new Job();
        assertNotEquals(jobA.getId(), jobB.getId());
    }
    //TODO: Create your unit tests here

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job instanceof Job);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job jobA = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobB = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(jobA.equals(jobB));
    }

//    @Test
//    public void testToStringStartsAndEndsWithNewLine() {
//        Job job = new Job();
//        String expected = System.lineSeparator() + job.toString().trim() + System.lineSeparator();
//        assertEquals(expected, job.toString());
//    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String actual = job.toString();
        assertTrue(actual.startsWith(System.lineSeparator()));
        assertTrue(actual.endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String jobString = job.toString();

        assertTrue(jobString.contains("ID: "));
        assertTrue(jobString.contains("Name: "));
        assertTrue(jobString.contains("Employer: "));
        assertTrue(jobString.contains("Location: "));
        assertTrue(jobString.contains("Position Type: "));
        assertTrue(jobString.contains("Core Competency: "));
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String expected = System.lineSeparator() +
                "ID: 1" + System.lineSeparator() +
                "Name: Data not available" + System.lineSeparator() +
                "Employer: Data not available" + System.lineSeparator() +
                "Location: Data not available" + System.lineSeparator() +
                "Position Type: Data not available" + System.lineSeparator() +
                "Core Competency: Data not available" + System.lineSeparator();
        assertEquals(expected, job.toString());
    }

}

