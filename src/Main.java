import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agence ag = new Agence();
        int choice;
        Vehicule vehicule=null;
        Client c=null;
        do {
            choice=menu();
            switch(choice) {
                case 1:
                    Client cl = new Client(sc.next(), sc.next(), sc.nextInt());
                    ag.addClient(cl);
                    break;
                case 2:
                    int id;
                    id = sc.nextInt();

                    try{
                        c=ag.searchClient(id);
                    }
                    catch(inexistantClientException e){
                        System.out.println(e.getMessage());
                    }
                    ag.clients.remove(c);
                    c=null;
                    break;
                case 3:
                    Vehicule v = new Vehicule(sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.nextInt());
                    ag.addVehicule(v);
                    break;
                case 4:
                    String mat;
                    mat = sc.next();
                    vehicule=null;
                    try{
                        vehicule = ag.searchVehicule(mat);
                    }
                    catch(inexistantVehiculeException e){
                        System.out.println(e.getMessage());
                    }

                case 7:
                    vehicule=null;
                    c=null;
                    try{
                        c=ag.searchClient(sc.nextInt());
                        vehicule=ag.searchVehicule(sc.next());
                    }
                    catch(inexistantClientException e){
                        System.out.println(e.getMessage());
                    }
                    catch(inexistantVehiculeException e){
                        System.out.println(e.getMessage());
                    }
                    Location loc = new Location(c,vehicule,sc.nextInt());
            }
        }while(choice!=0);
    }
    public static int menu(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add Client");
            System.out.println("3. Delete Client");
            System.out.println("2. Add Vehicule");
            System.out.println("4. Delete Vehicule");
            System.out.println("5. Add Agence");
            System.out.println("6. Delete Agence");
            System.out.println("7. Add Location");
            System.out.println("8. Exit");
            choice = sc.nextInt();
        }while(choice>8 || choice<1);
        return choice;
    }
}

