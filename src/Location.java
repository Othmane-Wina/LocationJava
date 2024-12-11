import java.util.Date;

public class Location {
    static int count = 0;
    private Client client;
    private Vehicule vehicule;
    private int numContract;
    private Date datePrise;
    private Date dateRetour;
    private Date dateRetourPrévu;


    public Location(Client client, Vehicule vehicule, Date datePrise, Date dateRetour, Date dateRetourPrévu) {
        this.client = client;
        this.vehicule = vehicule;
        this.datePrise = datePrise;
        this.dateRetour = dateRetour;
        this.dateRetourPrévu = dateRetourPrévu;
        this.numContract = count++;
    }

    public int getNumContract() {
        return numContract;
    }

    public Client getClient() {
        return client;
    }

    public Date getDatePrise() {
        return datePrise;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public Date getDateRetourPrévu() {
        return dateRetourPrévu;
    }

}
