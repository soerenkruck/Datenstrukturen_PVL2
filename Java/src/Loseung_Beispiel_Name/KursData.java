package Loseung_Beispiel_Name;

public class KursData {

    private Kurs kurs;

    private float grade;
    private int versuche;

    public KursData(Kurs kurs, float grade) {
        this.kurs = kurs;
        this.grade = grade;
        this.versuche = 1;
    }

    public boolean neuerVersuch(float grade) {
        if (this.grade == 5.0f) {
            this.grade = grade;
            this.versuche++;
        }

        return versuche != 3 || this.grade != 5.0f;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public float getGrade() {
        return grade;
    }

    public int getVersuche() {
        return versuche;
    }
}
