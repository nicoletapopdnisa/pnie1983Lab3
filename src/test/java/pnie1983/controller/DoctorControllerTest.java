package pnie1983.controller;

import org.junit.Test;
import pnie1983.exceptions.ConsultationException;
import pnie1983.exceptions.PatientException;
import pnie1983.model.Patient;
import pnie1983.repository.Repository;

import java.util.ArrayList;
import java.util.List;

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
        String name = "andrada";
        String ssn = "2971106123456";
        String address = "braila";

        int nrBefore = rep.getPatientList().size();
        ctrl.addPatient(new Patient(name, ssn, address));
        int nrAfter = rep.getPatientList().size();
        assertEquals(nrBefore + 1, nrAfter);
    }

    @Test
    public void checkIfPatientCNPHasProperLength() {
        String name = "radu";
        String ssn = "19611071456789";
        String address = "bacau";

        String thrown = "";

        try {
            ctrl.addPatient(new Patient(name, ssn, address));
        } catch (PatientException e) {
            thrown = e.getMessage();
        }

        assertEquals(thrown, "SSN has the length != 13");


    }

    @Test
    public void checkIfPatientCNPHasProperFormat() {
        String name = "radu";
        String ssn = "a196110714567";
        String address = "bacau";

        String thrown = "";

        try {
            ctrl.addPatient(new Patient(name, ssn, address));
        } catch (PatientException e) {
            thrown = e.getMessage();
        }
        assertEquals(thrown, "The \"ssn\" field has an invalid format!");
    }

    @Test
    public void checkIfPatientNameIsNotNull() {
        String name = "";
        String ssn = "1961107145678";
        String address = "bacau";

        String thrown = "";

        try {
            ctrl.addPatient(new Patient(name, ssn, address));
        } catch (PatientException e) {
            thrown = e.getMessage();
        }
        assertEquals(thrown, "One of the required fields is empty!");
    }

    @Test
    public void checkIfPatientAddressIsNotNull() {
        String name = "radu";
        String ssn = "1961107145678";
        String address = "";

        String thrown = "";

        try {
            ctrl.addPatient(new Patient(name, ssn, address));
        } catch (PatientException e) {
            thrown = e.getMessage();
        }
        assertEquals(thrown, "One of the required fields is empty!");
    }

    @Test
    public void addConsultationIf_3_C1_False() {
        String consID = null;
        String patientSSN = "2961107125782";
        String diag = "varicela";
        List<String> meds = new ArrayList<java.lang.String>();
        meds.add("antibiotic");
        meds.add("paracetamol");
        String date = "25.03.2018";

        String thrown = "";

        try {
            ctrl.addConsultation(consID, patientSSN, diag, meds, date);
        } catch (ConsultationException e) {
            thrown = e.getMessage();
        }

        assertEquals("invalid arguments", thrown);
    }

    @Test
    public void addConsultationIf_3_C1_True() {
        String consID = "10";
        String patientSSN = "2961107125782";
        String diag = "varicela";
        List<String> meds = new ArrayList<java.lang.String>();
        meds.add("antibiotic");
        meds.add("paracetamol");
        String date = "24.03.2018";

        String thrown = "";

        try {
            ctrl.addConsultation(consID, patientSSN, diag, meds, date);
        } catch (ConsultationException e) {
            thrown = e.getMessage();
        }

        assertEquals("", thrown);
    }

    @Test
    public void addConsultationIf_3_C2_False() {
        String consID = "11";
        String patientSSN = null;
        String diag = "varicela";
        List<String> meds = new ArrayList<java.lang.String>();
        meds.add("antibiotic");
        meds.add("paracetamol");
        String date = "24.03.2018";

        String thrown = "";

        try {
            ctrl.addConsultation(consID, patientSSN, diag, meds, date);
        } catch (ConsultationException e) {
            thrown = e.getMessage();
        }

        assertEquals("invalid arguments", thrown);
    }

    @Test
    public void addConsultationIf_3_C2_True() {
        String consID = "12";
        String patientSSN = "1961208123456";
        String diag = "varicela";
        List<String> meds = new ArrayList<java.lang.String>();
        meds.add("antibiotic");
        meds.add("paracetamol");
        String date = "24.03.2018";

        String thrown = "";

        try {
            ctrl.addConsultation(consID, patientSSN, diag, meds, date);
        } catch (ConsultationException e) {
            thrown = e.getMessage();
        }

        assertEquals("", thrown);
    }

    @Test
    public void addConsultationIf_3_C3_False() {
        String consID = "13";
        String patientSSN = "1961208123456";
        String diag = null;
        List<String> meds = new ArrayList<java.lang.String>();
        meds.add("antibiotic");
        meds.add("paracetamol");
        String date = "24.03.2018";

        String thrown = "";

        try {
            ctrl.addConsultation(consID, patientSSN, diag, meds, date);
        } catch (ConsultationException e) {
            thrown = e.getMessage();
        }

        assertEquals("invalid arguments", thrown);
    }

    @Test
    public void addConsultationIf_3_C3_True() {
        String consID = "14";
        String patientSSN = "2961107125782";
        String diag = "durere cap";
        List<String> meds = new ArrayList<java.lang.String>();
        meds.add("antibiotic");
        meds.add("paracetamol");
        String date = "27.03.2018";

        String thrown = "";

        try {
            ctrl.addConsultation(consID, patientSSN, diag, meds, date);
        } catch (ConsultationException e) {
            thrown = e.getMessage();
        }

        assertEquals("", thrown);
    }

    @Test
    public void addConsultationIf_3_C4_False() {
        String consID = "15";
        String patientSSN = "1961208123456";
        String diag = "diafragma febra";
        List<String> meds = new ArrayList<java.lang.String>();
        String date = "29.03.2018";

        String thrown = "";

        try {
            ctrl.addConsultation(consID, patientSSN, diag, meds, date);
        } catch (ConsultationException e) {
            thrown = e.getMessage();
        }

        assertEquals("invalid arguments", thrown);
    }

    @Test
    public void addConsultationIf_3_C4_True() {
        String consID = "15";
        String patientSSN = "2961107125782";
        String diag = "durere gat";
        List<String> meds = new ArrayList<java.lang.String>();
        meds.add("antibiotic");
        meds.add("paracetamol");
        String date = "27.03.2018";

        String thrown = "";

        try {
            ctrl.addConsultation(consID, patientSSN, diag, meds, date);
        } catch (ConsultationException e) {
            thrown = e.getMessage();
        }

        assertEquals("", thrown);
    }

    @Test
    public void addConsultationIf_3_C6_False() {
        String consID = "-1";
        String patientSSN = "1961208123456";
        String diag = null;
        List<String> meds = new ArrayList<java.lang.String>();
        meds.add("antibiotic");
        meds.add("paracetamol");
        String date = "24.03.2018";

        String thrown = "";

        try {
            ctrl.addConsultation(consID, patientSSN, diag, meds, date);
        } catch (ConsultationException e) {
            thrown = e.getMessage();
        }

        assertEquals("invalid arguments", thrown);
    }

    @Test
    public void addConsultationIf_3_C6_True() {
        String consID = "16";
        String patientSSN = "2961107125782";
        String diag = "durere cap";
        List<String> meds = new ArrayList<java.lang.String>();
        meds.add("antibiotic");
        meds.add("paracetamol");
        String date = "27.03.2018";

        String thrown = "";

        try {
            ctrl.addConsultation(consID, patientSSN, diag, meds, date);
        } catch (ConsultationException e) {
            thrown = e.getMessage();
        }

        assertEquals("", thrown);
    }

    @Test
    public void addConsultationIf_3_C5_False() {
        String consID = "17";
        String patientSSN = "1961208123450";
        String diag = null;
        List<String> meds = new ArrayList<java.lang.String>();
        meds.add("antibiotic");
        meds.add("paracetamol");
        String date = "24.03.2018";

        String thrown = "";

        try {
            ctrl.addConsultation(consID, patientSSN, diag, meds, date);
        } catch (ConsultationException e) {
            thrown = e.getMessage();
        }

        assertEquals("invalid arguments", thrown);
    }

    @Test
    public void addConsultationIf_3_C5_True() {
        String consID = "18";
        String patientSSN = "2961107125782";
        String diag = "durere cap";
        List<String> meds = new ArrayList<java.lang.String>();
        meds.add("antibiotic");
        meds.add("paracetamol");
        String date = "27.03.2018";

        String thrown = "";

        try {
            ctrl.addConsultation(consID, patientSSN, diag, meds, date);
        } catch (ConsultationException e) {
            thrown = e.getMessage();
        }

        assertEquals("", thrown);
    }

    @Test
    public void addConsultation_Path1()
    {
        String consID = "19";
        String patientSSN = "2961107125782";
        String diag = "durere cap";
        List<String> meds = null;
        String date = "27.03.2018";

        String thrown = "";

        try {
            ctrl.addConsultation(consID, patientSSN, diag, meds, date);
        } catch (ConsultationException e) {
            thrown = e.getMessage();
        }

        assertEquals("meds is null", thrown);
    }

    @Test
    public void addConsultation_Path2()
    {
        rep.setConsultationFileName("");
        String consID = "22";
        String patientSSN = "2961107125782";
        String diag = "durere cap + gat si asa";
        List<String> meds = new ArrayList<java.lang.String>();
        meds.add("antibiotic");
        meds.add("paracetamol");
        meds.add("aspirin plus c");
        meds.add("aspirin plus c forte");
        String date = "04.04.2018";

        String thrown = "";

        try {
            ctrl.addConsultation(consID, patientSSN, diag, meds, date);
        } catch (ConsultationException e) {
            thrown = e.getMessage();
        }

        assertEquals("", thrown);
    }

    @Test
    public void addConsultation_Path3()
    {
        rep.setConsultationFileName("C:\\Users\\nicol\\Documents\\Custom Office Templates\\college\\3rd year, 2nd semester\\vvss\\pnie1983Lab3\\src\\FileConsultations.txt");
        String consID = "21";
        String patientSSN = "2961107125782";
        String diag = "durere cap + gat...";
        List<String> meds = new ArrayList<java.lang.String>();
        meds.add("antibiotic");
        meds.add("paracetamol");
        meds.add("aspirin plus c");
        String date = "02.04.2018";

        String thrown = "";

        try {
            ctrl.addConsultation(consID, patientSSN, diag, meds, date);
        } catch (ConsultationException e) {
            thrown = e.getMessage();
        }

        assertEquals("", thrown);
    }

    @Test
    public void getPatientsWithDisease_BBTCase()
    {
        String disease = "sore throat";
        String thrown = "";
        try {
            List<Patient> patients = ctrl.getPatientsWithDisease(disease);
            assertEquals(patients.size(), 3);
        } catch (PatientException e) {
            thrown = e.getMessage();
            if(disease == null)
            {
                assertEquals(thrown, "Null disease parameter provided");
            }
            else {
                assertEquals(thrown, "Empty disease provided");
            }
        }
    }

    @Test
    public void addPacient_BigBangInt()
    {
        String name = "diana";
        String ssn = "2971106123456";
        String address = "pitesti";
        String thrown = "";

        int nrBefore = rep.getPatientList().size();
        try {
            ctrl.addPatient(new Patient(name, ssn, address));
            int nrAfter = rep.getPatientList().size();
            assertEquals(nrBefore + 1, nrAfter);
        } catch (PatientException e) {
            thrown = e.getMessage();
            assertEquals(thrown, "Null fields");
        }

    }

    @Test
    public void addConsultation_BigBangInt()
    {
        String consID = "22";
        String patientSSN = "2971106123456";
        String diag = "varicela";
        List<String> meds = new ArrayList<java.lang.String>();
        meds.add("antibiotic");
        meds.add("paracetamol");
        String date = "10.04.2018";
        String thrown = "";

        try {
            ctrl.addConsultation(consID, patientSSN, diag, meds, date);
        } catch (ConsultationException exc) {
            thrown = exc.getMessage();
        }

        assertEquals("", thrown);
    }

    @Test
    public void getPatientsWithDisease_BigBangInt()
    {
        String diseaseWanted = "varicela";
        String thrown = "";
        try {
            List<Patient> patientsWithDisease = ctrl.getPatientsWithDisease(diseaseWanted);
            assertEquals(patientsWithDisease.size(), 2);
        } catch (PatientException e) {
            thrown = e.getMessage();
            if(diseaseWanted != null)
            {
                assertEquals(thrown, "Empty disease provided");
            }
            else {
                assertEquals(thrown, "Null disease parameter provided");
            }
        }
    }

    @Test
    public void BigBangIntegrationTest()
    {
        addPacient_BigBangInt();
        addConsultation_BigBangInt();
        getPatientsWithDisease_BigBangInt();
    }

}