import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
/**
 * @author Teagan Randall  Chad Wyngaard
 * @studID: 215095111      ?????????
 * @class: 3e
 */
public class Server{

    private static Connection con;
    private boolean running = true;

    private ServerSocket listener;
    private Socket client;

    protected static ObjectOutputStream outS;
    protected  static ObjectInputStream inS;

    private static ArrayList<Customer> custs = new ArrayList<>();
    private static ArrayList<DVD> dvds = new ArrayList<>();
    private static ArrayList<Rental> rentals = new ArrayList<>();

    public static Connection connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:1234/mydatabase?autoReconnect=true&useSSL=false", "root", "root");
        }
        catch (ClassNotFoundException e){
            e.getMessage();
            System.out.println("Failed to load driver.");
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed");
        }
        return con;
    }

    public Server(){
        try{
            listener = new ServerSocket(3434,10);

        }
        catch(IOException e){
            e.getMessage();
        }
    }

    public void listen(){
        try {
            client = listener.accept();
            System.out.println("SERVER>>> Listening.");

            while(running){
                processClient();
            }
        }
        catch(IOException e){
            e.getMessage();
        }
    }

    public void processClient(){

            try {
                outS = new ObjectOutputStream(client.getOutputStream());
                outS.flush();
                inS = new ObjectInputStream(client.getInputStream());

                String clientMsg = "";

                    clientMsg = (String) inS.readObject();
                    System.out.println(clientMsg);

                    if(clientMsg.equalsIgnoreCase("CLOSE")){
                        outS.writeObject("Shutting down database and server.");
                        outS.flush();
                        running = false;
                        outS.close();
                        inS.close();
                        client.close();
                        listener.close();
                    }
                    else if (clientMsg.equalsIgnoreCase("GIVECUSTS")) {
                        ArrayList<Customer> gc = Database.getAllCustomers();
                        outS.writeObject(gc);
                    }
                    else if (clientMsg.equalsIgnoreCase("GIVEDVDS")) {
                        ArrayList<DVD> gd = Database.getAllDVDs();
                        outS.writeObject(gd);
                    }
                    else if(clientMsg.equalsIgnoreCase("GIVERENTALS")){
                        ArrayList<Rental> gr = Database.getAllRentals();
                        outS.writeObject(gr);
                    }
                    else if (clientMsg.charAt(0) == 'A') {
                        String proClient = clientMsg.substring(1);
                        Database.executeUpdate(proClient);
                        outS.writeObject("Customer successfully added to database.");
                    }
                    else if (clientMsg.charAt(0) == 'B') {
                        String proClient = clientMsg.substring(1);
                        Database.executeUpdate(proClient);
                        outS.writeObject("_________________________\nCustomer Successfully Deleted\n           Rental Removed.\n       Dvd is now available.");
                    }
                    else if (clientMsg.charAt(0) == 'C') {
                        String proClient = clientMsg.substring(1);
                        Database.executeUpdate(proClient);
                        outS.writeObject("Dvd Successfully Added.");
                    }
                    else if (clientMsg.charAt(0) == 'D') {
                        String proClient = clientMsg.substring(1);
                        Database.executeUpdate(proClient);
                        outS.writeObject("_________________________\n   DVD Successfully Deleted\n           Rental Removed.\n       Customer can now rent.\n");
                    }
                    else if (clientMsg.charAt(0) == 'P'){
                        String proClient = clientMsg.substring(1);
                        Database.executeQuery(proClient);
                        outS.writeObject("");
                    }
                    else if(clientMsg.charAt(0) == 'F'){
                        String proClient = clientMsg.substring(1);
                        Database.executeUpdate(proClient);
                        outS.writeObject("");
                    }
                    else if(clientMsg.charAt(0) == 'K'){
                        String proClient = clientMsg.substring(1);
                        Database.executeUpdate(proClient);
                        outS.writeObject("Credit Successfully added.");
                    }
                    else if (clientMsg.charAt(0) == 'L') {
                        String proClient = clientMsg.substring(1);
                        Database.executeUpdate(proClient);
                        outS.writeObject("_________________________\nCustomer Successfully Deleted");
                    }
                    else if (clientMsg.charAt(0) == 'O') {
                        String proClient = clientMsg.substring(1);
                        Database.executeUpdate(proClient);
                        outS.writeObject("_________________________\n   DVD Successfully Deleted");
                    }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args){
        Server s = new Server();
        connect();
        System.out.println("SERVER>>> Connecting to database...\nSERVER>>> Connected\nSERVER>>> Listening...");
        s.listen();
    }
}