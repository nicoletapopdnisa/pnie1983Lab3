package pnie1983;

/**
 * Hello world!
 *
 */

import pnie1983.repository.Repository;
import pnie1983.ui.DoctorUI;
import pnie1983.controller.DoctorController;

public class App {

    public static void main(String[] args) {
        String patients = "src/FilePatients.txt";
        String consultations = "src/FileConsultations.txt";
        Repository repo = new Repository(patients, consultations);
        DoctorController ctrl = new DoctorController(repo);

        DoctorUI console = new DoctorUI(ctrl);
        console.Run();
    }
}
