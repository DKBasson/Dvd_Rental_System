import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
/**
 * @author Teagan Randall
 * @studID: 215095111
 * @class: 3e
 */
public class Client{

    private Socket socket;
    static ObjectOutputStream out;
    static ObjectInputStream in;
    private static ArrayList<DVD> dvdsFromDatabase = new ArrayList<>();
    private static ArrayList<Customer> custsFromDatabase = new ArrayList<>();
    private static ArrayList<Rental> rentalsFromDatabase = new ArrayList<>();
    private static String response;

    public Client(){
        try{
            socket = new Socket("127.0.0.1", 3434);
            System.out.println("CLIENT>>> Connected.");
        }
        catch(IOException e){
            e.getMessage();
        }
    }

    public void communicate(String gui_text){
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(socket.getInputStream());

            String msg;

            try{
                    msg = gui_text;
                    out.writeObject(msg);
                    out.flush();

                    if(msg.equalsIgnoreCase("GIVECUSTS")){
                        custsFromDatabase.clear();
                        custsFromDatabase = (ArrayList<Customer>) in.readObject();

                    }
                    else if(msg.equalsIgnoreCase("GIVEDVDS")){
                        dvdsFromDatabase.clear();
                        dvdsFromDatabase = (ArrayList<DVD>) in.readObject();

                    }
                    else if(msg.equalsIgnoreCase("GIVERENTALS")){
                        rentalsFromDatabase.clear();
                        rentalsFromDatabase = (ArrayList<Rental>) in.readObject();
                    }
                    else{
                        response = (String) in.readObject();
                    }
            }
            catch(ClassNotFoundException e){
                e.getMessage();
            }
            catch(IOException a){
                a.getMessage();
            }
        }
        catch(IOException e){
            e.getMessage();
        }
    }

    public ArrayList<DVD> getDvdsFromDatabase(){
        return dvdsFromDatabase;
    }

    public ArrayList<Customer> getCustsFromDatabase() {
        return custsFromDatabase;
    }

    public ArrayList<Rental> getRentalsFromDatabase() {
        return rentalsFromDatabase;
    }

    public String getResponse(){
        return response;
    }
}

