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
}
