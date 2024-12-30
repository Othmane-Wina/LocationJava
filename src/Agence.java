import java.util.ArrayList;
import java.io.*;

public class Agence implements Serializable {
    public ArrayList<Vehicule> vehicules;
    public ArrayList<Client> clients;
    public ArrayList<Location> locations;

    public Agence() {
        vehicules = new ArrayList<>();
        clients = new ArrayList<>();
        locations = new ArrayList<>();
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

    public Location searchLocation(int clientid, String matricule) throws inexistantLocationException{
        for (Location location : locations) {
            if( location.getClient().getClientId() == clientid && location.getVehicule().getMatricule() == matricule){
                return location;
            }
        }
        throw new inexistantLocationException();
    }

    public static void writeToFile(ArrayList<?> list, String file) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(list);
        } catch (EOFException eof) {
        throw new IOException("End of file reached unexpectedly while writing: " + eof.getMessage());
    }
    }

    public void addVehicule(Vehicule vehicule) throws IOException {
        try{
            searchVehicule(vehicule.getMatricule());

        }catch (inexistantVehiculeException e){
            vehicules.add(vehicule);
            try{
                writeToFile(vehicules, "Vehicule.txt");
            }
            catch (IOException er){
                System.out.println("Failed to save vehicule");
                vehicules.remove(vehicule);
            }
        }
    }

    public void addClient(Client client) {
        try {
            searchClient(client.getClientId());
        } catch (inexistantClientException e) {
            clients.add(client);
            try{
                writeToFile(clients, "Client.txt");
            }
            catch (IOException er){
                System.out.println("Failed to save client");
                clients.remove(client);
            }
        }
    }

    public void addLocation(Location location) {
        try{
            searchLocation(location.getClient().getClientId(),location.getVehicule().getMatricule());
        }
        catch (inexistantLocationException e){
            locations.add(location);
            try{
                writeToFile(locations, "Location.txt");
            }
            catch (IOException er){
                System.out.println("Failed to save location");
                locations.remove(location);
            }
        }
    }

    public void deleteVehicule(String matricule) throws inexistantVehiculeException {
        try{
            Vehicule vehicule = searchVehicule(matricule);
            vehicules.remove(vehicule);
        }
        catch (inexistantVehiculeException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteClient(int clientid) throws inexistantClientException {
        try{
            Client client = searchClient(clientid);
            clients.remove(client);
        }
        catch (inexistantClientException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showVehicules(){
        for (Vehicule vehicule : vehicules) {
            System.out.println(vehicule);
        }
    }

    public void showClients(){
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    public void showLocations(){
        for (Location location : locations) {
            System.out.println(location);
        }
    }

    public static <T> ArrayList<T> readFromFile(String file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<T>) in.readObject();
        }
    }

    public void loadVehicules(){
        try{
            vehicules = readFromFile("Vehicule.txt");
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public void loadClients(){
        try{
            clients = readFromFile("Client.txt");
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void loadLocations(){
        try{
            locations = readFromFile("Location.txt");
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
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
        }
        catch (inexistantVehiculeException e){
            return false;
        }
    }

}
