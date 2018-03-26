package pnie1983.controller;

import org.junit.Test;
import pnie1983.exceptions.PatientException;
import pnie1983.model.Patient;
import pnie1983.repository.Repository;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DoctorControllerTest {
    DoctorController ctrl;
    Repository rep;

    @org.junit.Before
    public void setUp() throws Exception {
        rep = new Repository("C:\\Users\\nicol\\Documents\\Custom Office Templates\\college\\3rd year, 2nd semester\\vvss\\pnie1983Lab3\\src\\FilePatients.txt", "C:\\Users\\nicol\\Documents\\Custom Office Templates\\college\\3rd year, 2nd semester\\vvss\\pnie1983Lab3\\src\\FileConsultations.txt");
        ctrl = new DoctorController(rep);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void addPatient() throws PatientException {
        String name="andrada";
        String ssn="2971106123456";
        String address="braila";

        int nrBefore = rep.getPatientList().size();
        ctrl.addPatient(new Patient(name, ssn, address));
        int nrAfter = rep.getPatientList().size();
        assertEquals(nrBefore+1, nrAfter);
    }

    @Test
    public void checkIfPatientCNPHasProperLength() {
        String name="radu";
        String ssn="19611071456789";
        String address="bacau";

        String thrown = "";

        try {
            ctrl.addPatient(new Patient(name, ssn, address));
        } catch (PatientException e) {
            thrown = e.getMessage();
        }

        assertEquals(thrown, "SSN has the length != 13");


    }

    @Test
    public void checkIfPatientCNPHasProperFormat()
    {
        String name="radu";
        String ssn="a196110714567";
        String address="bacau";

        String thrown = "";

        try {
            ctrl.addPatient(new Patient(name, ssn, address));
        } catch (PatientException e) {
            thrown = e.getMessage();
        }
        assertEquals(thrown, "The \"ssn\" field has an invalid format!");
    }

    @Test
    public void checkIfPatientNameIsNotNull()
    {
        String name="";
        String ssn="1961107145678";
        String address="bacau";

        String thrown = "";

        try {
            ctrl.addPatient(new Patient(name, ssn, address));
        } catch (PatientException e) {
            thrown = e.getMessage();
        }
        assertEquals(thrown, "One of the required fields is empty!");
    }

    @Test
    public void checkIfPatientAddressIsNotNull()
    {
        String name="radu";
        String ssn="1961107145678";
        String address="";

        String thrown = "";

        try {
            ctrl.addPatient(new Patient(name, ssn, address));
        } catch (PatientException e) {
            thrown = e.getMessage();
        }
        assertEquals(thrown, "One of the required fields is empty!");
    }
}