package Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest{

    Job job1;
    Job job2;
    Job job3;
    Job job4;
    Job job5;

    @Before
    public void createJobs() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4 = new Job("Full Stack Developer", new Employer("Spotify"), new Location("Hawaii"), new PositionType("Junior Developer"), new CoreCompetency("Java"));
        job5 = new Job("Full Stack Developer", new Employer("Spotify"), new Location("Hawaii"), new PositionType("Junior Developer"), new CoreCompetency("Java"));

    }

    @Test
    public void emptyTest() {
        assertEquals(10,10,.001);
    }

    @Test
    public void testSettingJobId() {
        assertFalse(job1.equals(job2));
        assertEquals(job2.getId(), (job1.getId() + 1), .001);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(job3.getId() == (job2.getId() + 1));
        assertTrue(job3.getId() == (int)job3.getId());

        assertEquals(job3.getName(), "Product tester");
        assertTrue(job3.getName().equals((String) job3.getName()));

        assertEquals(job3.getEmployer().getValue(), "ACME");
        assertTrue(job3.getEmployer() instanceof Employer);

        assertEquals(job3.getLocation().getValue(), "Desert");
        assertTrue(job3.getLocation() instanceof Location);

        assertEquals(job3.getPositionType().getValue(), "Quality control");
        assertTrue(job3.getPositionType() instanceof PositionType);

        assertEquals(job3.getCoreCompetency().getValue(), "Persistence");
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job4.equals(job5));
    }

    @Test
    public void jobToString() {
        assertTrue(job5.toString().startsWith("\n"));
        assertTrue(job5.toString().endsWith("\n"));
        assertTrue(job5.toString().equals("\nID: " + job5.getId() + "\nName: Full Stack Developer\nEmployer: Spotify\nLocation: Hawaii\nPosition Type: Junior Developer\nCore Competency: Java\n"));
        assertTrue(job1.toString().equals("OOPS! This job does not seem to exist."));
    }

}
