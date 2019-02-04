import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
/**
 * @author Teagan Randall  Chad Wyngaard
 * @studID: 215095111      ?????????
 * @class: 3e
 */
public class Database {

    private static Statement stmnt;
    private static Connection con;
    private static ResultSet rs;

    private static ArrayList<Customer> custs = new ArrayList<>();
    private static ArrayList<DVD> dvds = new ArrayList<>();
    private static ArrayList<Rental> rentals = new ArrayList<>();

    private static int custCounter = 0;
    private static int dvdCounter = 0;
    private static int rentalCounter = 0;

    protected static FileInputStream fis;
    protected static BufferedInputStream bis;
    protected static ObjectInputStream ois;

    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:1234/mydatabase?autoReconnect=true&useSSL=false", "root", "root");
            stmnt = con.createStatement();
        } catch (ClassNotFoundException e) {
            e.getMessage();
            System.out.println("Failed to load driver.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed");
        }
        return con;
    }

    public static void dropTables() {

        try {
            rs = connect().getMetaData().getTables(null, null, "rental", null);

            while (rs.next()) {

                String tableName = rs.getString("TABLE_NAME");

                if (tableName.equalsIgnoreCase("RENTAL")) {
                    stmnt.executeUpdate("ALTER TABLE RENTAL DROP FOREIGN KEY CUSTOMER_FK");
                    stmnt.executeUpdate("ALTER TABLE RENTAL DROP FOREIGN KEY DVD_FK");
                    stmnt.executeUpdate("DROP TABLE `mydatabase`.`rental`;");
                    System.out.println("Dropping RENTAL Table in mydatabase...");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs = connect().getMetaData().getTables(null, null, "dvd", null);

            while (rs.next()) {

                String tableName = rs.getString("TABLE_NAME");

                if (tableName.equalsIgnoreCase("DVD")) {
                    stmnt.executeUpdate("ALTER TABLE DVD DROP PRIMARY KEY");
                    stmnt.executeUpdate("DROP TABLE `mydatabase`.`dvd`;");
                    System.out.println("Dropping DVD Table in mydatabase...");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs = connect().getMetaData().getTables(null, null, "customer", null);

            while (rs.next()) {

                String tableName = rs.getString("TABLE_NAME");

                if (tableName.equalsIgnoreCase("CUSTOMER")) {
                    stmnt.executeUpdate("ALTER TABLE CUSTOMER DROP PRIMARY KEY");
                    stmnt.executeUpdate("DROP TABLE `mydatabase`.`customer`;");
                    System.out.println("Dropping CUSTOMER Table in mydatabase...");
                    System.out.println("-----------------------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deSerCust() {

        String filename = "Customers.ser";

        try {
            fis = new FileInputStream(filename);
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getMessage();
        }

        try {
            while (true) {
                custs.add((Customer) ois.readObject());
            }
        } catch (EOFException e) {
            System.out.println("Deserializing Customer File...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
            System.out.println("Random exception.");
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deSerDvd() {

        String filename = "Movies.ser";

        try {
            fis = new FileInputStream(filename);
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (true) {
                dvds.add((DVD) ois.readObject());
            }
        } catch (EOFException e) {
            System.out.println("Deserializing Movies File...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
            System.out.println("Random exception.");
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deSerRent() {

        String filename = "rental.ser";

        try {
            fis = new FileInputStream(filename);
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (true) {
                rentals.add((Rental) ois.readObject());
            }
        } catch (EOFException e) {
            System.out.println("Deserializing Rental File...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
            System.out.println("Random exception.");
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void createTables() {

        try {
            String createCustTable = ("CREATE TABLE IF NOT EXISTS CUSTOMER(id integer(10) NOT NULL, name varchar(20) NOT NULL, surname varchar(20) NOT NULL, phone varchar(12) NOT NULL, credit float(6) NOT NULL, canRent boolean NOT NULL)");
            String createDvdTable = ("CREATE TABLE IF NOT EXISTS DVD(dvdId integer(10) NOT NULL, title varchar(50) NOT NULL, category varchar(20) NOT NULL, newRelease boolean NOT NULL, available boolean NOT NULL)");
            String createRentalTable = ("CREATE TABLE IF NOT EXISTS RENTAL(rentalId integer(10) NOT NULL, dateRented varchar(20) NOT NULL, dateReturned varchar(20), custId integer(10) NOT NULL, dvdIdNo integer(10) NOT NULL)");

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:1234/mydatabase?autoReconnect=true&useSSL=false", "root", "root");

            System.out.println("-----------------------------------");
            System.out.println("Creating Tables in mydatabase...");
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(createCustTable);
            stmt.executeUpdate(createDvdTable);
            stmt.executeUpdate(createRentalTable);

            System.out.println("Tables Successfully Created.");
            System.out.println("------------------------------------------------------------");

            stmt.executeUpdate("ALTER TABLE CUSTOMER ADD CONSTRAINT CUSTOMER_PK PRIMARY KEY(id)");
            stmt.executeUpdate("ALTER TABLE DVD ADD CONSTRAINT DVD_PK PRIMARY KEY(dvdId)");
            stmt.executeUpdate("ALTER TABLE RENTAL ADD CONSTRAINT CUSTOMER_FK FOREIGN KEY(custId) REFERENCES CUSTOMER (id) ON DELETE CASCADE");
            stmt.executeUpdate("ALTER TABLE RENTAL ADD CONSTRAINT DVD_FK FOREIGN KEY(dvdIdno) REFERENCES DVD (dvdId) ON DELETE CASCADE");

            for (int i = 0; i < custs.size(); i++) {

                int idNo = custs.get(i).getCustNumber();
                String name = custs.get(i).getName();
                String surname = custs.get(i).getSurname();
                String phone = custs.get(i).getPhoneNum();
                double credit = custs.get(i).getCredit();
                boolean can = custs.get(i).canRent();

                custCounter++;
                stmt.execute("INSERT INTO CUSTOMER(id, name, surname, phone, credit, canRent) VALUES(" + idNo + "," + "'" + name + "'" + "," + "'" + surname + "'" + "," + "'" + phone + "'" + "," + credit + ","
                        + can + ")");
            }

            System.out.println("Added: " + custCounter + " row's to Customer Table in mydatabase.");

            for (int i = 0; i < dvds.size(); i++) {

                int dvdIdNo = dvds.get(i).getDvdNumber();
                String title = dvds.get(i).getTitle();
                String[] raw = title.split("'");
                StringBuilder newTitle = new StringBuilder();

                for (int x = 0; x < raw.length; x++) {
                    try {
                        newTitle.append(raw[x]);
                    } catch (NullPointerException e) {
                        e.getMessage();
                    }
                }
                String category = dvds.get(i).getCategory();
                boolean newRel = dvds.get(i).isNewRelease();
                boolean avail = dvds.get(i).isAvailable();

                dvdCounter++;
                stmt.executeUpdate("INSERT INTO DVD(dvdId, title, category, newRelease, available) VALUES(" + dvdIdNo + "," + "'" + String.valueOf(newTitle) + "'" + "," + "'" + category + "'" + "," + newRel + "," + avail + ")");
            }

            System.out.println("Added: " + dvdCounter + " row's to Dvd Table in mydatabase.");

            for (int i = 0; i < rentals.size(); i++) {

                int rentalId = rentals.get(i).getRentalNumber();
                String dateRented = rentals.get(i).getDateRented();
                String dateReturned = rentals.get(i).getDateReturned();
                int custID = rentals.get(i).getCustNumber();
                int dvdNo = rentals.get(i).getDvdNumber();

                rentalCounter++;

                stmt.execute("INSERT INTO RENTAL(rentalId, dateRented, dateReturned, custId, dvdIdNo) VALUES(" + rentalId + "," + "'" + dateRented + "'" + "," + "'" + dateReturned + "'" + "," + custID + "," + dvdNo + ")");
            }
            System.out.println("Added: " + rentalCounter + " row's to Rental Table in mydatabase.");
            System.out.println("------------------------------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void executeUpdate(String in_sql) {
        try {
            //CONNECT TO DB
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:1234/mydatabase?autoReconnect=true&useSSL=false", "root", "root");

            Statement stm;
            stm = conn.createStatement();
            stm.executeUpdate(in_sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeQuery(String in_sql) {
        try {
            //CONNECT TO DB
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:1234/mydatabase?autoReconnect=true&useSSL=false", "root", "root");

            Statement stm;
            stm = conn.createStatement();
            stm.executeQuery(in_sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeDB() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Customer> getAllCustomers() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:1234/mydatabase?autoReconnect=true&useSSL=false", "root", "root");

            ResultSet rst;
            Statement stm;
            stm = conn.createStatement();
            String sql = "Select * From customer";
            rst = stm.executeQuery(sql);

            ArrayList<Customer> customerList = new ArrayList<>();

            while (rst.next()) {
                Customer customer = new Customer(Integer.parseInt(rst.getString("id")), rst.getString("name"), rst.getString("surname"), rst.getString("phone"), rst.getDouble("credit"), rst.getBoolean("canRent"));
                customerList.add(customer);
            }
            return customerList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int setCategory(String sCategory) {
        int category = 0;

        switch (sCategory) {
            case "horror":
                category = 1;
                break;
            case "Sci-fi":
                category = 2;
                break;
            case "Drama":
                category = 3;
                break;
            case "Romance":
                category = 4;
                break;
            case "Comedy":
                category = 5;
                break;
            case "Action":
                category = 6;
                break;
            case "Cartoon":
                category = 7;
                break;
        }
        return category;
    }

    public static ArrayList<DVD> getAllDVDs() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:1234/mydatabase?autoReconnect=true&useSSL=false", "root", "root");

            ResultSet rst;
            Statement stm;
            stm = conn.createStatement();
            String sql = "SELECT * FROM dvd";
            rst = stm.executeQuery(sql);

            ArrayList<DVD> dvdList = new ArrayList<>();

            while (rst.next()) {
                DVD dvd = new DVD(Integer.parseInt(rst.getString("dvdId")), rst.getString("title"), setCategory(rst.getString("category")), rst.getBoolean("newRelease"), rst.getBoolean("available"));
                dvdList.add(dvd);
            }
            return dvdList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Rental> getAllRentals() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:1234/mydatabase?autoReconnect=true&useSSL=false", "root", "root");

            ResultSet rst;
            Statement stm;
            stm = conn.createStatement();
            String sql = "Select * From rental";
            rst = stm.executeQuery(sql);

            ArrayList<Rental> rentalList = new ArrayList<>();

            while (rst.next()) {
                Rental rental = new Rental(Integer.parseInt(rst.getString("rentalId")), rst.getString("dateRented"), rst.getString("dateReturned"), rst.getInt("custId"), rst.getInt("dvdIdNo"));
                rentalList.add(rental);
            }
            return rentalList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        Database db = new Database();

        System.out.println("Connecting to database...");
        System.out.println("Connected.");
        System.out.println("-----------------------------------");
        db.dropTables();
        deSerRent();
        deSerCust();
        deSerDvd();
        db.createTables();

        final JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(dialog, "                             DATABASE" +
                "\n        ____________________________" + "\n        Added " + custCounter +
                " rows to customer table.\n              Added " + dvdCounter + " rows to dvd table.\n             Added "
                + rentalCounter + " rows to rental table.\n"  + "        ____________________________",
                "Database Updated", JOptionPane.PLAIN_MESSAGE);
        dialog.dispose();
    }
}
