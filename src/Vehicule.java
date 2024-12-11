public class Vehicule {
    public String matricule;
    public String marque;
    public String modele;
    public int prix;
    public int kilometrage;

    public Vehicule(String matricule, String marque, String modele, int prix, int kilo) {
        this.matricule = matricule;
        this.marque=modele;
        this.prix=prix;
        this.kilometrage=kilo;
    }

    public String getMatricule() {
        return matricule;
    }


    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }


}
