public class Unternehmen {
    private int id;
    private String unternehmensname;
    private Unternehmensgröße unternehmensgröße;
    private int anzahlMitarbeiter;
    private int einkommenVonKunde;
    private String ort;

    public Unternehmen(int id, String unternehmensname, Unternehmensgröße unternehmensgröße, int anzahlMitarbeiter, int einkommenVonKunde, String ort) {
        this.id = id;
        this.unternehmensname = unternehmensname;
        this.unternehmensgröße = unternehmensgröße;
        this.anzahlMitarbeiter = anzahlMitarbeiter;
        this.einkommenVonKunde = einkommenVonKunde;
        this.ort = ort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnternehmensname() {
        return unternehmensname;
    }

    public void setUnternehmensname(String unternehmensname) {
        this.unternehmensname = unternehmensname;
    }

    public Unternehmensgröße getUnternehmensgröße() {
        return unternehmensgröße;
    }

    public void setUnternehmensgröße(Unternehmensgröße unternehmensgröße) {
        this.unternehmensgröße = unternehmensgröße;
    }

    public int getAnzahlMitarbeiter() {
        return anzahlMitarbeiter;
    }

    public void setAnzahlMitarbeiter(int anzahlMitarbeiter) {
        this.anzahlMitarbeiter = anzahlMitarbeiter;
    }

    public int getEinkommenVonKunde() {
        return einkommenVonKunde;
    }

    public void setEinkommenVonKunde(int einkommenVonKunde) {
        this.einkommenVonKunde = einkommenVonKunde;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public String toString() {
        return "Kunden{" +
                "id=" + id +
                ", unternehmensname='" + unternehmensname + '\'' +
                ", unternehmensgröße=" + unternehmensgröße +
                ", anzahlMitarbeiter=" + anzahlMitarbeiter +
                ", einkommenVonKunde=" + einkommenVonKunde +
                ", ort='" + ort + '\'' +
                '}';
    }
}
