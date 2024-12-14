import java.util.ArrayList;

public class Agence {
    public ArrayList<Vehicule> vehicules;
    public ArrayList<Client> clients;
    public ArrayList<Location> locations;

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
    public Location searchLocation(int clientid, String matricule) throws inexistantLocationException{
        for (Location location : locations) {
            if( location.getClient().getClientId() == clientid && location.getVehicule().getMatricule() == matricule){
                return location;
            }
        }
        throw new inexistantLocationException();
    }

    public void addVehicule(Vehicule vehicule) {
        try{
            searchVehicule(vehicule.getMatricule());

        }catch (inexistantVehiculeException e){
            vehicules.add(vehicule);
        }
    }
    public void addClient(Client client) {
        try {
            searchClient(client.getClientId());
        } catch (inexistantClientException e) {
            clients.add(client);
        }
    }
    public void addLocation(Location location) {
        try{
            searchLocation(location.getClient().getClientId(), location.getVehicule().getMatricule());
        }catch (inexistantLocationException e){
            locations.add(location);
        }
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
