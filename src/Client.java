public class Client extends Personne{
    int clientId;
    static int compteur = 0;
    public Client(String nom, String prenom, int age) {
        super(nom, prenom, age);
        clientId = compteur++;
    }
    public int getClientId() {
        return clientId;
    }
    public void setClientid(int clientId) {
        this.clientId = clientId;
    }
}













