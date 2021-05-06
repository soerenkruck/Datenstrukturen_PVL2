package Loseung_G33;

import PVL.PVL2;

import java.util.ArrayList;
import java.util.List;

public class PVL2_G33 implements PVL2 {

    ArrayList<Student> studenten;
    ArrayList<Kurs> alleKurse;

    public PVL2_G33(){
        studenten = new ArrayList<>();
        alleKurse = new ArrayList<>();
    }

    @Override
    public int enroll_student(String first_name, String surname) {

        Student tStudent = new Student(first_name, surname, Utility.getLowestPossibleMatrikelNummer(studenten));
        studenten.add(tStudent);

        return tStudent.getMatrikelNummer();
    }

    @Override
    public boolean disenroll_student(int number) {
        if (studenten.size() > 0) {
            Student temp = Utility.getStudentByNumber(studenten, number);

            if (temp == null)
                return false;

            for (Student student: studenten) {
                if (student.getMatrikelNummer() == number) {
                    studenten.remove(student);
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void take_exam(int number, String courseID, float grade) {
        if (alleKurse.size() > 0) {
            if (!Utility.existiertKurs(alleKurse, courseID)) {
                alleKurse.add(new Kurs(courseID));
                System.out.println("Es wurde ein neuer Kurs eingeführt.");
            }
        } else {
            alleKurse.add(new Kurs(courseID));
            System.out.println("Es wurde ein neuer Kurs eingeführt.");
        }

        Student tempStudent = Utility.getStudentByNumber(studenten, number);

        if (tempStudent != null) {
            boolean bestanden;
            bestanden = tempStudent.takeExam(courseID, grade);

            if (!bestanden) {
                disenroll_student(tempStudent.getMatrikelNummer());
            }
        } else {
            System.err.println("Diesen Studenten gibt es nicht.");
        }
    }

    @Override
    public List<String> get_student(int number) {

        Student t = Utility.getStudentByNumber(studenten, number);

        if (t != null)
            return t.studentInformation();
        else
            return new ArrayList<>();   // Gibt leere Liste zurück
    }

    @Override
    public List<List<String>> get_database() {
        return Utility.generateDatabase(this.studenten);
    }
}
