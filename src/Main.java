import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Unternehmen> readFromFile(String filename) throws IOException {
        List<Unternehmen> unternehmenListe = new ArrayList<>();
        Scanner scan = new Scanner(Path.of(filename));
        String text = scan.nextLine();
        while (scan.hasNext()) {
            int id = Integer.parseInt(text.split(",")[0]);
            String name = text.split(",")[1];
            String grosse = text.split(",")[2];
            Unternehmensgröße unternehmensgröße = switch (grosse) {
                case "Small" -> Unternehmensgröße.SMALL;
                case "Medium" -> Unternehmensgröße.MEDIUM;
                default -> Unternehmensgröße.LARGE;
            };
            int anzahlMitarbeiter = Integer.parseInt(text.split(",")[3]);
            int einkommenKunde = Integer.parseInt(text.split(",")[4]);
            String ort = text.split(",")[5];
            Unternehmen unternehmen = new Unternehmen(id, name, unternehmensgröße, anzahlMitarbeiter, einkommenKunde, ort);
            unternehmenListe.add(unternehmen);
            text = scan.nextLine();
        }
        scan.close();
        return unternehmenListe;
    }

    public static void writeToFile(String filename, List<Unternehmen> unternehmenListe) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Unternehmen unternehmen : unternehmenListe) {
            String unternemensGrosse = switch (unternehmen.getUnternehmensgröße()) {
                case SMALL -> "Small";
                case MEDIUM -> "Medium";
                case LARGE -> "Large";
            };
            writer.write(unternehmen.getId() + "," + unternehmen.getUnternehmensname() + ","
                    + unternemensGrosse + "," + unternehmen.getAnzahlMitarbeiter() + ","
                    + unternehmen.getEinkommenVonKunde() + "," + unternehmen.getOrt());
            writer.newLine();
        }
        writer.close();
    }

    public static void writeToFile2(String filename, List<Unternehmen> unternehmenListe) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Unternehmen unternehmen : unternehmenListe) {
            writer.write( unternehmen.getOrt()+": "+ unternehmen.getEinkommenVonKunde());
            writer.newLine();
        }
        writer.close();
    }

    public static List<Unternehmen> sortiertAbstNachAnzMitarbeiter(List<Unternehmen> unternehmenListe) {
        return unternehmenListe.stream().sorted(Comparator.comparing(Unternehmen::getAnzahlMitarbeiter)).toList();
    }

    public static List<Unternehmen> TopOrteNachEinkommen(List<Unternehmen> unternehmenListe) {
        return unternehmenListe.stream().sorted(Comparator.comparingInt(Unternehmen::getEinkommenVonKunde).reversed()).toList();
    }

    public static void main(String[] args) throws IOException {
        // write your code here
        List<Unternehmen> unternehmenList = readFromFile("kundendaten.txt");
        System.out.println(unternehmenList);

        List<Unternehmen> sortierteUnternehmenListe1 = sortiertAbstNachAnzMitarbeiter(unternehmenList);
        writeToFile("kundensortiert.txt", sortierteUnternehmenListe1);

        List<Unternehmen> topOrteNachEinkommen = TopOrteNachEinkommen(unternehmenList);
        writeToFile2("statistik.txt",topOrteNachEinkommen);
    }
}
