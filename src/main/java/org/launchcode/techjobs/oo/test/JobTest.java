package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static javax.swing.UIManager.getString;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId(){
        Job newJob = new Job();
        Job anotherJob = new Job();
        assertNotEquals(newJob, anotherJob);
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester",newJob.getName());
        assertEquals("ACME",newJob.getEmployer().getValue());
        assertEquals("Desert",newJob.getLocation().getValue());
        assertEquals("Quality control", newJob.getPositionType().getValue());
        assertEquals("Persistence",newJob.getCoreCompetency().getValue());

        assertTrue("Product tester" == newJob.getName());
        assertTrue("ACME" == newJob.getEmployer().getValue());
        assertTrue("Desert" == newJob.getLocation().getValue());
        assertTrue("Quality control" == newJob.getPositionType().getValue());
        assertTrue("Persistence" == newJob.getCoreCompetency().getValue());
        assertTrue(newJob instanceof Job);

    }
    @Test
    public void testJobsForEquality(){
        Job newJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job newJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(newJobOne.getId()==newJobTwo.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        char character = '\n';
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(character,newJob.toString().charAt(0));
        assertEquals(character,newJob.toString().charAt(newJob.toString().length()-1));
        System.out.println(newJob.toString());
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals( "\nID: 1" +
                "\n"+"Name: Product tester" +
                "\n"+"Employer: ACME" +
                "\n"+"Location: Desert" +
                "\n"+"Position Type: Quality control"+
                "\n"+"Core Competency: Persistence"+"\n",newJob.toString());

        newJob = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals( "\nID: 1" +
                "\n"+"Name: Data not available" +
                "\n"+"Employer: ACME" +
                "\n"+"Location: Desert" +
                "\n"+"Position Type: Quality control"+
                "\n"+"Core Competency: Persistence"+"\n",newJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job newJob= new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("ACME", newJob.toStringHandlesEmptyField(newJob.getEmployer().getValue()));
        assertEquals("Data not available", newJob.toStringHandlesEmptyField(newJob.getLocation().getValue()));

        String acme = newJob.toString().split("\n")[2];
        assertEquals("ACME", acme);
    }
}
