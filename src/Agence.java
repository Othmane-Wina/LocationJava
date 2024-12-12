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

    public Vehicule searchVehicule(String matricule) throws inexistantVehiculeException{
        for (Vehicule vehicule : vehicules) {
            if (vehicule.getMatricule().equals(matricule)) {
                return vehicule;
            }
        }
        throw new inexistantVehiculeException();
    }
    public Client searchClient(int clientid) throws inexistantClientException {
        for (Client client : clients) {
            if(client.getClientId() == clientid){
                return client;
            }
        }
        throw new inexistantClientException();
    }
    public boolean isCarAvailable(String matricule) {
        // this function check if a car is available for rent based on its matricule"
        Vehicule v;
        try{
            v = searchVehicule(matricule);
            for(Location location : locations){
                if (location.getVehicule().equals(v) && location.getState() != 0){
                    return false;
                }
            }
            return true;
        }catch (inexistantVehiculeException e){
            return false;
        }
    }
}
