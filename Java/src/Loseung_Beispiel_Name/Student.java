package Loseung_Beispiel_Name;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private int studentID;
    private String firstName, lastName;

    private ArrayList<KursData> kurse;

    public Student(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = id;

        kurse = new ArrayList<>();
    }

    public int getMatrikelNummer() {
        return studentID;
    }

    public boolean takeExam(String courseID, float grade) {
        if (Utility.existiertKursBeiStudent(kurse, courseID))
            return Utility.getKursByID(kurse, courseID).neuerVersuch(grade);
        else
            kurse.add(new KursData(new Kurs(courseID), grade));

        return true;
    }

    /** Generiert eine Liste bestehend aus Strings mit den Infotmationen eines Studenten.
     **/
    public List<String> studentInformation() {
        List<String> list = new ArrayList<>();

        list.add(this.firstName);
        list.add(this.lastName);
        list.add(String.valueOf(this.studentID));

        for (KursData k: kurse) {
            int fehlversuche = k.getVersuche() - 1;
            list.add(k.getKurs().getCourseID() + " " + k.getGrade() + " " + fehlversuche);
        }

        return list;
    }

}
