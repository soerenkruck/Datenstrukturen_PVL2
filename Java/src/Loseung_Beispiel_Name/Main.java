package Loseung_Beispiel_Name;

public class Main {

    public static void main(String[] args) {
        PVL2_G33 pvl2_g33 = new PVL2_G33();

        pvl2_g33.enroll_student("Sören", "Kruck");
        pvl2_g33.enroll_student("Dominic", "Zemlin");
        pvl2_g33.enroll_student("Erik", "Hellfritzsch");

        pvl2_g33.disenroll_student(2);

        pvl2_g33.enroll_student("Dörte", "Finnja");
        pvl2_g33.enroll_student("Finnja", "Wittig");

        pvl2_g33.take_exam(4, "Informatik", 5.0f);
        pvl2_g33.take_exam(4, "Informatik", 5.0f);
        pvl2_g33.take_exam(4, "Informatik", 3.0f);

        System.out.println(pvl2_g33.get_database());
    }

}
