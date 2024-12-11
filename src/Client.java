public class Client extends Personne{
    int clientid;
    static int compteur = 0;
    public Client(String nom, String prenom, int age) {
        super(nom, prenom, age);
        clientid = compteur++;
    }
    public int getClientid() {
        return clientid;
    }
    public void setClientid(int clientid) {
        this.clientid = clientid;
    }
}













