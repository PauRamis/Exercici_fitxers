public class Avenger {


    public Avenger(byte[] nom, byte[] notes, byte[] totalAparicio, byte[] anyPrimeraAparicio, byte[] genere) {
        this.nom = arToString(nom);
        this.notes = arToString(notes);
        this.genere = genere[0] == 'm' ? Genere.Home : Genere.Dona;
        this.totalAparicio = totalAparicio[3] | totalAparicio[2];
        this.anyPrimeraAparicio = anyPrimeraAparicio[3] | anyPrimeraAparicio[2];
    }

    private String arToString(byte[] nom) {
        String res = "";
        for (byte c: nom){
            if (c >= ' ')
                res += (char) c;
        }
        return res;
    }

    enum Genere {Home, Dona}

    String nom;
    String notes;
    Genere genere;
    int totalAparicio;
    int anyPrimeraAparicio;
}
