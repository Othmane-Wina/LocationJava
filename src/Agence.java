import java.util.ArrayList;

public class Agence {
    ArrayList<Vehicule> vehicules;
    ArrayList<Client> clients;
    ArrayList<Location> locations;

    public void addVehicule(Vehicule vehicule) {
        vehicules.add(vehicule);
    }
    public void addClient(Client client) {
        clients.add(client);
    }
    public void addLocation(Location location) {
        locations.add(location);
    }

    public Vehicule searchVehicule(String matricule) {
        for (Vehicule vehicule : vehicules) {
            if (vehicule.getMatricule().equals(matricule)) {
                return vehicule;
            }
        }
        return null;
    }
    public Client searchClient(int clientid) {
        for (Client client : clients) {
            if(client.getClientId() == clientid){
                return client;
            }
        }
        return null;
    }
}
