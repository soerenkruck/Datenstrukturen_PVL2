package Loseung_Beispiel_Name;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static boolean existiertKurs(ArrayList<Kurs> alleKurse, String courseID) {
        for (Kurs kurs: alleKurse) {
            if (kurs.getCourseID().equals(courseID)) {
                return true;
            }
        }

        return false;
    }

    public static boolean existiertKursBeiStudent(ArrayList<KursData> alleKurse, String courseID) {
        for (KursData kurs: alleKurse) {
            if (kurs.getKurs().getCourseID().equals(courseID)) {
                return true;
            }
        }

        return false;
    }

    public static KursData getKursByID(ArrayList<KursData> kurse, String courseID) {
        for (KursData k: kurse) {
            if (k.getKurs().getCourseID().equals(courseID)) {
                return k;
            }
        }

        return null;
    }

    public static Student getStudentByNumber(ArrayList<Student> alleStudenten, int number) {
        for (Student student: alleStudenten) {
            if (student.getMatrikelNummer() == number) {
                return student;
            }
        }

        return null;
    }

    public static int getLowestPossibleMatrikelNummer(ArrayList<Student> students) {
        if (students.size() == 0)
            return 1;

        int[] index = new int[999];

        for (int i = 0; i < index.length; i++) {
            index[i] = 0;
        }

        for (Student student: students) {
            index[student.getMatrikelNummer()-1] = 1;
        }

        for (int j = 0; j < index.length; j++) {
            if (index[j] == 0) {
                return ++j;
            }
        }

        return -1;
    }

    public static List<List<String>> generateDatabase(ArrayList<Student> students) {
        List<List<String>> databaseList = new ArrayList<>();

        for (int i = 0; i < students.toArray().length; i++) {
            databaseList.add(students.get(i).studentInformation());
        }

        return databaseList;
    }

}
