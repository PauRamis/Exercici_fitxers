import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*- 50 bytes pel nom del personatge
- Número enter (4 bytes) que indica les aparicions del personatge
- Lletra per indicar el gènere del personatge
- Número (2 bytes) que indica l'any d'aparició del personatge
- 300 bytes amb notes referents al personatge*/
public class Main {
    static final String nomFitxer = "/home/superior/IdeaProjects/Exercici fitxers/src/avengers.bin";
    public static void main(String[] args) throws IOException {
        File avengers = new File(nomFitxer);
        InputStream is = new FileInputStream(avengers);
        DataInputStream dis = new DataInputStream(is);
        List<Avenger> avengerList = new ArrayList<>();
        while (true) {
            try {
                byte[] arNom = dis.readNBytes(50);
                if (arNom == null) break;
                byte[] arAnyApa = dis.readNBytes(4);
                byte[] arGenere = dis.readNBytes(1);
                byte[] arNumApa = dis.readNBytes(2);
                byte[] arNotes = dis.readNBytes(300);
                Avenger a = new Avenger(arNom, arAnyApa, arGenere, arNumApa, arNotes);
                avengerList.add(a);

            } catch (EOFException e){
                break;
            }
        }
        dis.close();
        run_a(avengerList);
        run_b(avengerList);
        //run_c(avengerList);
        //run_d(avengerList);
        //run_e(avengerList);
        run_f(avengerList);
        //c)
        //d) Variança de les aparicions dels personatges que són home
        //e) Notes de qualsevol personatge (el programa ha de demanar primer quin personatge es vol)
        //f) Cercar si un personatge surt a la llista o no, i si no és el cas, el programa ha de demanar les seves dades i escriure un altre cop el fitxer, amb el nou personatge inclòs.
    }

    private static void run_a(List<Avenger> avengerList) {
        System.out.println("Quants de personatges hi ha que són home? i quants dona?");
        int home = 0;
        int dona = 0;
        for (Avenger a : avengerList){
            if (a.genere == Avenger.Genere.Home)
                home++;
            if (a.genere == Avenger.Genere.Dona)
                dona++;
        }
        System.out.println("Homes: " + home + " Dones: " + dona);
    }

    private static void run_b(List<Avenger> avengerList) {
        System.out.println("Quin és l'any d'aparició més petit, i el més gros? A quins personatges corresponen?");
        Avenger mesJove = avengerList.get(0);
        Avenger mesVell = avengerList.get(0);

        for (Avenger a : avengerList){
            if (a.anyPrimeraAparicio < mesJove.anyPrimeraAparicio)
                mesJove = a;
            if (a.anyPrimeraAparicio > mesVell.anyPrimeraAparicio)
                mesVell = a;
        }
        System.out.println("Any d'aparició més petit: " + mesJove + ". Any d'aparició més gros: " + mesVell);
    }

    private static void run_c(List<Avenger> avengerList) {
        System.out.println("Mitjana de les aparicions dels personatges que són dona");
    }


    private static void run_f(List<Avenger> avengerList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom del personatje: ");
        String nom = scanner.nextLine();
        if (pesonatjeExisteix(nom, avengerList)){

        }
        introdueixNouPersonatge(nom);
    }

    private static void introdueixNouPersonatge(String nom) {
        //Demanar dades

        //FileOutputStream

        //OutputStream i DataOutputStream per afegir les dades

        //close
    }

    private static boolean pesonatjeExisteix(String nom, List<Avenger> avengerList){
        for (Avenger a : avengerList){
            if (a.nom.toLowerCase().contains(nom.toLowerCase()))
                return true;
        }
        return false;
    }
}