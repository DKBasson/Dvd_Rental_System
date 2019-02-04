import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
/**
 * @author: Teagan Randall Chad Wyngaard
 * @studID: 215095111      ?????????
 * @class: 3e
 */
public class NewMainMenu extends javax.swing.JFrame {

    protected static ArrayList<Customer> guiCusts = new ArrayList<>();
    protected static ArrayList<DVD> guiDVDs = new ArrayList<>();
    protected static ArrayList<Rental> guiRentals = new ArrayList<>();

    protected static ArrayList<DVD> searchDvds = new ArrayList<>();
    protected static ArrayList<Customer> alphaCusts = new ArrayList<>();
    protected static ArrayList<DVD> reportDVDs = new ArrayList<>();
    protected static ArrayList<Rental> reportRentals = new ArrayList<>();

    private static int rentalIdCounter;

    Client cl = new Client();

    public NewMainMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure you want to exit?","WARNING",JOptionPane.YES_NO_OPTION);
                if(dialogButton == JOptionPane.YES_OPTION) {
                    cl.communicate("CLOSE");
                    JOptionPane.showMessageDialog(null, cl.getResponse(), "Shutting down.", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        System.exit(0);
                    }catch(ArrayIndexOutOfBoundsException f){
                        f.getMessage();
                    }
                }
                else{
                    remove(dialogButton);
                }
            }
        });

        cl.communicate("GIVECUSTS");
        guiCusts = cl.getCustsFromDatabase();
        cl.communicate("GIVEDVDS");
        guiDVDs = cl.getDvdsFromDatabase();
        cl.communicate("GIVERENTALS");
        guiRentals = cl.getRentalsFromDatabase();
        rentalIdCounter = guiRentals.size()+1;
    }
    private void initComponents() {

        dynamicPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        addcustIDTxt = new javax.swing.JTextField();
        addcustNameTxt = new javax.swing.JTextField();
        addcustSurnameTxt = new javax.swing.JTextField();
        addCustAddBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        addcustPhoneTxt = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        delCustDelBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        delCustDelTxt = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        addCreditCustIDTxt = new javax.swing.JTextField();
        addCreditAmtTxt = new javax.swing.JTextField();
        addCreditAddBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        addDvdAddBtn = new javax.swing.JButton();
        addDvdIDTxt = new javax.swing.JTextField();
        addDvdTitleTxt = new javax.swing.JTextField();
        addDvdCatComBox = new javax.swing.JComboBox<>();
        addDvdNewRelComBox = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        DelDvdDelBtn = new javax.swing.JButton();
        DelDvdIDTxt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addRentalCustList = new javax.swing.JList<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        addRentalDvdByCategoryJList = new javax.swing.JList<>();
        addRentalRentBtn = new javax.swing.JButton();
        addRentalCatComBox = new javax.swing.JComboBox<>();
        addRentalRefreshBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        returnRentalIDTxt = new javax.swing.JTextField();
        returnPanelReturnBtn = new javax.swing.JButton();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        reportCustTable = new javax.swing.JTable();
        reportCustTableRefeshBtn = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        reportsRentalComBox = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        reportRentalTable = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        reportsDVDTable = new javax.swing.JTable();
        reportDVDComBox = new javax.swing.JComboBox<>();
        jPanel31 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        searchCustIDTxt = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        searchCustResultsTable = new javax.swing.JTable();
        searchCustSearchBtn = new javax.swing.JToggleButton();
        jPanel23 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        searchDVDtitleTxt = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        searchDVDTable = new javax.swing.JTable();
        searchDVDSearchBtn = new javax.swing.JToggleButton();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        searchDVDIDTxt = new javax.swing.JTextField();
        searchDVDIDBtn = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        searchDVDIDTable = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        searchRentalsDateTxt = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        searchRentalsTable = new javax.swing.JTable();
        renralReportSearchBtn = new javax.swing.JButton();

        searchDVDIDTxt.addKeyListener(new java.awt.event.KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){}
            @Override
            public void keyPressed(KeyEvent e){
                String text = searchDVDIDTxt.getText();
                try {
                    if (text.length() > 10) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid ID number.");
                        searchDVDIDTxt.setText(searchDVDIDTxt.getText(0, 10));
                    }
                }
                catch(BadLocationException g){
                    g.getMessage();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                String text = searchDVDIDTxt.getText();
                try {
                    if((text.length() < 10)&&(text.length() > 0)) {
                        int num = Integer.parseInt(text + "");
                    }
                }
                catch(NumberFormatException f){
                    JOptionPane.showMessageDialog(null, "Please enter digits only.", "Digits Only", JOptionPane.INFORMATION_MESSAGE);
                    searchDVDIDTxt.requestFocus();
                    searchDVDIDTxt.setText("");
                    return;
                }
            }
        });

        searchDVDtitleTxt.addKeyListener(new java.awt.event.KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){}
            @Override
            public void keyPressed(KeyEvent e){}
            @Override
            public void keyReleased(KeyEvent e){
                String text = "";
                char x = 0;
                try {
                    x = searchDVDtitleTxt.getText().charAt(0);
                    text = searchDVDtitleTxt.getText();
                }
                catch(StringIndexOutOfBoundsException a){
                    a.getMessage();
                }
                try {
                    int num = Integer.parseInt(text.charAt(0)+"");

                    if(searchDVDtitleTxt.getText().length() > 1) {
                        JOptionPane.showMessageDialog(null, "Only One Character Allowed.", "1 Character  Max", JOptionPane.INFORMATION_MESSAGE);
                        searchDVDtitleTxt.requestFocus();
                        searchDVDtitleTxt.setText(String.valueOf(x));
                        return;
                    }
                }
                catch(NumberFormatException f){

                    if (searchDVDtitleTxt.getText().length() > 1) {
                        JOptionPane.showMessageDialog(null, "Only One Character Allowed.", "1 Character  Max", JOptionPane.INFORMATION_MESSAGE);
                        searchDVDtitleTxt.requestFocus();
                        searchDVDtitleTxt.setText(String.valueOf(x));
                        return;
                    }

                }
            }
        });

        returnRentalIDTxt.addKeyListener(new java.awt.event.KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){}
            @Override
            public void keyPressed(KeyEvent e){
                String text =  returnRentalIDTxt.getText();
                try {
                    if (text.length() > 10) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid ID number.");
                        returnRentalIDTxt.setText( returnRentalIDTxt.getText(0, 10));
                    }
                }
                catch(BadLocationException g){
                    g.getMessage();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                String text =  returnRentalIDTxt.getText();
                try {
                    if((text.length() < 10)&&(text.length() > 0)) {
                        int num = Integer.parseInt(text + "");
                    }
                }
                catch(NumberFormatException f){
                    JOptionPane.showMessageDialog(null, "Please enter digits only.", "Digits Only", JOptionPane.INFORMATION_MESSAGE);
                    returnRentalIDTxt.requestFocus();
                    returnRentalIDTxt.setText("");
                    return;
                }
            }
        });

        DelDvdIDTxt.addKeyListener(new java.awt.event.KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){}
            @Override
            public void keyPressed(KeyEvent e){
                String text = DelDvdIDTxt.getText();
                try {
                    if (text.length() > 10) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid ID number.");
                        DelDvdIDTxt.setText(DelDvdIDTxt.getText(0, 10));
                    }
                }
                catch(BadLocationException g){
                    g.getMessage();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                String text = DelDvdIDTxt.getText();
                try {
                    if((text.length() < 10)&&(text.length() > 0)) {
                        int num = Integer.parseInt(text + "");
                    }
                }
                catch(NumberFormatException f){
                    JOptionPane.showMessageDialog(null, "Please enter digits only.", "Digits Only", JOptionPane.INFORMATION_MESSAGE);
                    DelDvdIDTxt.requestFocus();
                    DelDvdIDTxt.setText("");
                    return;
                }
            }
        });

        delCustDelTxt.addKeyListener(new java.awt.event.KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){}
            @Override
            public void keyPressed(KeyEvent e){
                String text = delCustDelTxt.getText();
                try {
                    if (text.length() > 10) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid ID number.");
                        delCustDelTxt.setText(delCustDelTxt.getText(0, 10));
                    }
                }
                catch(BadLocationException g){
                    g.getMessage();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                String text = delCustDelTxt.getText();
                try {
                    if((text.length() < 10)&&(text.length() > 0)) {
                        int num = Integer.parseInt(text + "");
                    }
                }
                catch(NumberFormatException f){
                    JOptionPane.showMessageDialog(null, "Please enter digits only.", "Digits Only", JOptionPane.INFORMATION_MESSAGE);
                    delCustDelTxt.requestFocus();
                    delCustDelTxt.setText("");
                    return;
                }
            }
        });

        searchCustIDTxt.addKeyListener(new java.awt.event.KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){}
            @Override
            public void keyPressed(KeyEvent e){
                String text = searchCustIDTxt.getText();
                try {
                    if (text.length() > 10) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid ID number.");
                        searchCustIDTxt.setText(searchCustIDTxt.getText(0, 10));
                    }
                }
                catch(BadLocationException g){
                    g.getMessage();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                String text = searchCustIDTxt.getText();
                try {
                    if((text.length() < 10)&&(text.length() > 0)) {
                        int num = Integer.parseInt(text + "");
                    }
                }
                catch(NumberFormatException f){
                    JOptionPane.showMessageDialog(null, "Please enter digits only.", "Digits Only", JOptionPane.INFORMATION_MESSAGE);
                    searchCustIDTxt.requestFocus();
                    searchCustIDTxt.setText("");
                    return;
                }
            }
        });

        addCreditAmtTxt.addKeyListener(new java.awt.event.KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                String text = addCreditAmtTxt.getText();
                try {
                    if (text.length() > 10) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid ID number.");
                        addCreditAmtTxt.setText(addCreditAmtTxt.getText(0, 10));
                    }
                }
                catch(BadLocationException g){
                    g.getMessage();
                }
            }
            @Override
            public void keyReleased(KeyEvent e){
                String text = addCreditAmtTxt.getText();
                try {
                    if((text.length() < 10)&&(text.length() > 0)) {
                        int num = Integer.parseInt(text + "");
                    }
                }
                catch(NumberFormatException f){
                    JOptionPane.showMessageDialog(null, "Please enter digits only.", "Digits Only", JOptionPane.INFORMATION_MESSAGE);
                    addCreditAmtTxt.requestFocus();
                    addCreditAmtTxt.setText("");
                    return;
                }
            }
        });

        addCreditCustIDTxt.addKeyListener(new java.awt.event.KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){}
            @Override
            public void keyPressed(KeyEvent e){
                String text = addCreditCustIDTxt.getText();
                try {
                    if (text.length() > 10){
                        JOptionPane.showMessageDialog(null, "Please enter a valid ID number.");
                        addCreditCustIDTxt.setText(addCreditCustIDTxt.getText(0, 10));
                    }
                }
                catch(BadLocationException g){
                    g.getMessage();
                }
            }
            @Override
            public void keyReleased(KeyEvent e){
                String text = addCreditCustIDTxt.getText();
                try {
                    if((text.length() < 10)&&(text.length() > 0)){
                        int num = Integer.parseInt(text + "");
                    }
                }
                catch(NumberFormatException f){
                    JOptionPane.showMessageDialog(null, "Please enter digits only.", "Digits Only", JOptionPane.INFORMATION_MESSAGE);
                    addCreditCustIDTxt.requestFocus();
                    addCreditCustIDTxt.setText("");
                    return;
                }
            }
        });


        addDvdIDTxt.addKeyListener(new java.awt.event.KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                String text = addDvdIDTxt.getText();
                try {
                    if (text.length() > 10) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid ID number.");
                        addDvdIDTxt.setText(addDvdIDTxt.getText(0, 10));
                    }
                }
                catch(BadLocationException g){
                    g.getMessage();
                }
            }
            @Override
            public void keyReleased(KeyEvent e){
                String text = addDvdIDTxt.getText();
                try {
                    if((text.length() < 10)&&(text.length() > 0)){
                        int num = Integer.parseInt(text + "");
                    }
                }
                catch(NumberFormatException f){
                    JOptionPane.showMessageDialog(null, "Please enter digits only.", "Digits Only", JOptionPane.INFORMATION_MESSAGE);
                    addDvdIDTxt.requestFocus();
                    addDvdIDTxt.setText("");
                    return;
                }
            }
        });

        addcustIDTxt.addKeyListener(new java.awt.event.KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){}
            @Override
            public void keyPressed(KeyEvent e){
                String text = addcustIDTxt.getText();
                try {
                    if (text.length() > 10){
                        JOptionPane.showMessageDialog(null, "Please enter a valid ID number.");
                        addcustIDTxt.setText(addcustIDTxt.getText(0, 10));
                    }
                }
                catch(BadLocationException g){
                    g.getMessage();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                String text = addcustIDTxt.getText();
                try {
                    if((text.length() < 10)&&(text.length() > 0)) {
                        int num = Integer.parseInt(text + "");
                    }
                }
                catch(NumberFormatException f){
                    JOptionPane.showMessageDialog(null, "Please enter digits only.", "Digits Only", JOptionPane.INFORMATION_MESSAGE);
                    addcustIDTxt.requestFocus();
                    addcustIDTxt.setText("");
                    return;
                }
            }
        });

        addcustPhoneTxt.addKeyListener(new java.awt.event.KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                String text = addcustPhoneTxt.getText();
                try {
                    if (text.length() > 10) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid phone number.");
                        addcustPhoneTxt.setText(addcustPhoneTxt.getText(0, 10));
                    }
                }
                catch(BadLocationException g){
                    g.getMessage();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                String text = addcustPhoneTxt.getText();
                try {
                    if((text.length() < 10)&&(text.length() > 0)) {
                        int num = Integer.parseInt(text + "");
                    }
                }
                catch(NumberFormatException f){
                    JOptionPane.showMessageDialog(null, "Please enter digits only.", "Digits Only", JOptionPane.INFORMATION_MESSAGE);
                    addcustPhoneTxt.requestFocus();
                    addcustPhoneTxt.setText("");
                    return;
                }
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dvd Rental Application");

        dynamicPanel.setBackground(new java.awt.Color(51, 51, 51));

        jTabbedPane1.setBackground(new java.awt.Color(102, 102, 102));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTabbedPane2.setBackground(new java.awt.Color(102, 102, 102));
        jTabbedPane2.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N

        jPanel17.setBackground(new java.awt.Color(51, 51, 51));

        addcustIDTxt.setBackground(new java.awt.Color(102, 102, 102));
        addcustIDTxt.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        addcustIDTxt.setForeground(new java.awt.Color(255, 255, 255));
        addcustIDTxt.setToolTipText("Enter customer ID.");

        addcustNameTxt.setBackground(new java.awt.Color(102, 102, 102));
        addcustNameTxt.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        addcustNameTxt.setForeground(new java.awt.Color(255, 255, 255));
        addcustNameTxt.setToolTipText("Enter customer name.");

        addcustSurnameTxt.setBackground(new java.awt.Color(102, 102, 102));
        addcustSurnameTxt.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        addcustSurnameTxt.setForeground(new java.awt.Color(255, 255, 255));
        addcustSurnameTxt.setToolTipText("Enter customer surname.");

        addCustAddBtn.setBackground(new java.awt.Color(204, 204, 204));
        addCustAddBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        addCustAddBtn.setForeground(new java.awt.Color(51, 51, 51));
        addCustAddBtn.setText("Add");
        addCustAddBtn.setToolTipText("Click here to add a customer.");
        addCustAddBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        addCustAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustAddBtnActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 2, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Customer ID:");

        jLabel11.setFont(new java.awt.Font("Arial", 2, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Customer Name:");

        jLabel12.setFont(new java.awt.Font("Arial", 2, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Customer Surname:");

        jPanel18.setBackground(new java.awt.Color(102, 102, 102));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ADD CUSTOMER");

        jLabel15.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Please fill in customer details:");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel15))
                                .addContainerGap(451, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15)
                                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Arial", 2, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Customer Phone:");

        addcustPhoneTxt.setBackground(new java.awt.Color(102, 102, 102));
        addcustPhoneTxt.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        addcustPhoneTxt.setForeground(new java.awt.Color(255, 255, 255));
        addcustPhoneTxt.setToolTipText("Enter customer phone number.");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel17Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel11)
                                                        .addComponent(jLabel12)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel18))
                                                .addGap(22, 22, 22)
                                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(addcustIDTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                                        .addComponent(addcustNameTxt)
                                                        .addComponent(addcustSurnameTxt)
                                                        .addComponent(addcustPhoneTxt)))
                                        .addGroup(jPanel17Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(addCustAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(addcustIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addcustNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addcustSurnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel18)
                                        .addComponent(addcustPhoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addComponent(addCustAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 633, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 341, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Customer", jPanel7);

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setPreferredSize(new java.awt.Dimension(275, 263));

        jPanel14.setBackground(new java.awt.Color(102, 102, 102));
        jPanel14.setPreferredSize(new java.awt.Dimension(151, 58));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DELETE CUSTOMER");

        jLabel14.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Please enter a customer ID:");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel14))
                                .addContainerGap(461, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                                .addContainerGap(21, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14)
                                .addContainerGap())
        );

        delCustDelBtn.setBackground(new java.awt.Color(204, 204, 204));
        delCustDelBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        delCustDelBtn.setForeground(new java.awt.Color(51, 51, 51));
        delCustDelBtn.setText("Delete");
        delCustDelBtn.setToolTipText("Click here to delete a customer.");
        delCustDelBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        delCustDelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delCustDelBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Customer ID:");

        delCustDelTxt.setBackground(new java.awt.Color(102, 102, 102));
        delCustDelTxt.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        delCustDelTxt.setForeground(new java.awt.Color(255, 255, 255));
        delCustDelTxt.setToolTipText("Enter the customers ID.");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(delCustDelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(delCustDelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(delCustDelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                                .addComponent(delCustDelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 633, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 341, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Delete Customer", jPanel8);

        jPanel32.setBackground(new java.awt.Color(51, 51, 51));

        jPanel33.setBackground(new java.awt.Color(102, 102, 102));
        jPanel33.setForeground(new java.awt.Color(102, 102, 102));

        jLabel41.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("ADD CREDIT:");

        jLabel42.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Please enter the customers details below:");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
                jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel33Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel41)
                                        .addComponent(jLabel42))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
                jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel33Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel42)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel43.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Please enter customer ID:");

        jLabel44.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Please enter amount:");

        addCreditCustIDTxt.setBackground(new java.awt.Color(102, 102, 102));
        addCreditCustIDTxt.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        addCreditCustIDTxt.setForeground(new java.awt.Color(255, 255, 255));
        addCreditCustIDTxt.setToolTipText("Enter customer ID.");

        addCreditAmtTxt.setBackground(new java.awt.Color(102, 102, 102));
        addCreditAmtTxt.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        addCreditAmtTxt.setForeground(new java.awt.Color(255, 255, 255));
        addCreditAmtTxt.setToolTipText("Enter credit amount.");

        addCreditAddBtn.setBackground(new java.awt.Color(204, 204, 204));
        addCreditAddBtn.setForeground(new java.awt.Color(51, 51, 51));
        addCreditAddBtn.setText("Add");
        addCreditAddBtn.setToolTipText("Click here to add credits.");
        addCreditAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCreditAddBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
                jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel32Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel32Layout.createSequentialGroup()
                                                .addComponent(jLabel43)
                                                .addGap(18, 18, 18)
                                                .addComponent(addCreditCustIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel32Layout.createSequentialGroup()
                                                .addComponent(jLabel44)
                                                .addGap(43, 43, 43)
                                                .addComponent(addCreditAmtTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(addCreditAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(353, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
                jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel32Layout.createSequentialGroup()
                                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel43)
                                        .addComponent(addCreditCustIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addCreditAmtTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel44))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                .addComponent(addCreditAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jTabbedPane2.addTab("Add Credits", jPanel32);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane2)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("Customer", jPanel1);

        jTabbedPane3.setBackground(new java.awt.Color(102, 102, 102));
        jTabbedPane3.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane3.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));

        jPanel12.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADD DVD");

        jLabel17.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Please enter dvd details:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel17))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(jLabel17)
                                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Dvd ID:");

        jLabel3.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dvd Title:");

        jLabel4.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Category:");

        jLabel5.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("New Release:");

        addDvdAddBtn.setBackground(new java.awt.Color(204, 204, 204));
        addDvdAddBtn.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        addDvdAddBtn.setForeground(new java.awt.Color(51, 51, 51));
        addDvdAddBtn.setText("Add");
        addDvdAddBtn.setToolTipText("Click here to add a dvd.");
        addDvdAddBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        addDvdAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDvdAddBtnActionPerformed(evt);
            }
        });

        addDvdIDTxt.setBackground(new java.awt.Color(102, 102, 102));
        addDvdIDTxt.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        addDvdIDTxt.setForeground(new java.awt.Color(255, 255, 255));
        addDvdIDTxt.setToolTipText("Enter DVD ID.");

        addDvdTitleTxt.setBackground(new java.awt.Color(102, 102, 102));
        addDvdTitleTxt.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        addDvdTitleTxt.setForeground(new java.awt.Color(255, 255, 255));
        addDvdTitleTxt.setToolTipText("Enter DVD title.");

        addDvdCatComBox.setBackground(new java.awt.Color(204, 204, 204));
        addDvdCatComBox.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        addDvdCatComBox.setForeground(new java.awt.Color(51, 51, 51));
        addDvdCatComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horror", "Sci-fi", "Drama", "Romance", "Comedy", "Action", "Cartoon" }));
        addDvdCatComBox.setToolTipText("Select a category.");

        addDvdNewRelComBox.setBackground(new java.awt.Color(204, 204, 204));
        addDvdNewRelComBox.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        addDvdNewRelComBox.setForeground(new java.awt.Color(51, 51, 51));
        addDvdNewRelComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Yes" }));
        addDvdNewRelComBox.setToolTipText("Select release.");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addDvdAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5))
                                                .addGap(48, 48, 48)
                                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(addDvdNewRelComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(addDvdCatComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(addDvdTitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(addDvdIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(401, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(addDvdIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(addDvdTitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(addDvdCatComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(addDvdNewRelComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(addDvdAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 633, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 341, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Add Dvd", jPanel9);

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));

        jPanel16.setBackground(new java.awt.Color(102, 102, 102));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DELETE DVD");

        jLabel16.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Please enter dvd ID:");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel16))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Enter Dvd ID:");

        DelDvdDelBtn.setBackground(new java.awt.Color(204, 204, 204));
        DelDvdDelBtn.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        DelDvdDelBtn.setForeground(new java.awt.Color(51, 51, 51));
        DelDvdDelBtn.setText("Delete");
        DelDvdDelBtn.setToolTipText("Click here to delete this dvd.");
        DelDvdDelBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        DelDvdDelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelDvdDelBtnActionPerformed(evt);
            }
        });

        DelDvdIDTxt.setBackground(new java.awt.Color(102, 102, 102));
        DelDvdIDTxt.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        DelDvdIDTxt.setForeground(new java.awt.Color(255, 255, 255));
        DelDvdIDTxt.setToolTipText("Enter DVD ID.");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DelDvdDelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)
                                                .addComponent(DelDvdIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 427, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DelDvdIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                                .addComponent(DelDvdDelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 633, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 341, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Delete DVD", jPanel10);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane3)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane3)
        );

        jTabbedPane1.addTab("Dvd", jPanel2);

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setForeground(new java.awt.Color(102, 102, 102));

        jPanel19.setBackground(new java.awt.Color(102, 102, 102));
        jPanel19.setForeground(new java.awt.Color(153, 153, 153));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("RENT A DVD");

        jLabel20.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Please select a customer, movie category and movie below:");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
                jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel19Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel20))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
                jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addRentalCustList.setBackground(new java.awt.Color(102, 102, 102));
        addRentalCustList.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        addRentalCustList.setForeground(new java.awt.Color(255, 255, 255));
        addRentalCustList.setToolTipText("A list of all available customers.");
        addRentalCustList.setSelectionMode(SINGLE_SELECTION);
        jScrollPane1.setViewportView(addRentalCustList);

        jLabel21.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Please select a customer below:");

        jLabel22.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Please select a category, then a dvd:");

        addRentalDvdByCategoryJList.setBackground(new java.awt.Color(102, 102, 102));
        addRentalDvdByCategoryJList.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        addRentalDvdByCategoryJList.setForeground(new java.awt.Color(255, 255, 255));
        addRentalDvdByCategoryJList.setToolTipText("A list of DVDs by category.");
        addRentalDvdByCategoryJList.setSelectionMode(SINGLE_SELECTION);
        jScrollPane2.setViewportView(addRentalDvdByCategoryJList);

        addRentalRentBtn.setBackground(new java.awt.Color(204, 204, 204));
        addRentalRentBtn.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        addRentalRentBtn.setForeground(new java.awt.Color(51, 51, 51));
        addRentalRentBtn.setText("Rent");
        addRentalRentBtn.setToolTipText("Click here to rent a dvd.");
        addRentalRentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRentalRentBtnActionPerformed(evt);
            }
        });

        addRentalCatComBox.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        addRentalCatComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "horror", "Sci-fi", "Drama", "Romance", "Comedy", "Action", "Cartoon" }));
        addRentalCatComBox.setToolTipText("Select a category.");
        addRentalCatComBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRentalCatComBoxActionPerformed(evt);
            }
        });

        addRentalRefreshBtn.setBackground(new java.awt.Color(204, 204, 204));
        addRentalRefreshBtn.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        addRentalRefreshBtn.setForeground(new java.awt.Color(51, 51, 51));
        addRentalRefreshBtn.setText("Refresh");
        addRentalRefreshBtn.setToolTipText("Click here to refresh lists");
        addRentalRefreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRentalRefreshBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addRentalRentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(addRentalRefreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel22)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(addRentalCatComBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addRentalCatComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addRentalRentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addRentalRefreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 370, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Rent", jPanel3);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jPanel25.setBackground(new java.awt.Color(102, 102, 102));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("RETURN A DVD");

        jLabel24.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Please enter the rental number below:");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
                jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel23))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
                jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel24)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel25.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Enter rental ID:");

        returnRentalIDTxt.setBackground(new java.awt.Color(102, 102, 102));
        returnRentalIDTxt.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        returnRentalIDTxt.setForeground(new java.awt.Color(255, 255, 255));
        returnRentalIDTxt.setToolTipText("Enter the rentals ID.");

        returnPanelReturnBtn.setBackground(new java.awt.Color(204, 204, 204));
        returnPanelReturnBtn.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        returnPanelReturnBtn.setForeground(new java.awt.Color(51, 51, 51));
        returnPanelReturnBtn.setText("Return");
        returnPanelReturnBtn.setToolTipText("Click here to return a rental.");
        returnPanelReturnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnPanelReturnBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(returnPanelReturnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel25)
                                                .addGap(18, 18, 18)
                                                .addComponent(returnRentalIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(400, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel25)
                                        .addComponent(returnRentalIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                                .addComponent(returnPanelReturnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Return", jPanel4);

        jTabbedPane7.setBackground(new java.awt.Color(102, 102, 102));
        jTabbedPane7.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane7.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N

        jPanel20.setBackground(new java.awt.Color(51, 51, 51));
        jPanel20.setForeground(new java.awt.Color(255, 255, 255));

        reportCustTable.setBackground(new java.awt.Color(51, 51, 51));
        reportCustTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        reportCustTable.setForeground(new java.awt.Color(255, 255, 255));
        reportCustTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Name", "Surname", "ID", "Phone No", "Credit", "Can Rent"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reportCustTable.setToolTipText("A list of all customers organized alphbteically.");
        jScrollPane3.setViewportView(reportCustTable);

        reportCustTableRefeshBtn.setBackground(new java.awt.Color(204, 204, 204));
        reportCustTableRefeshBtn.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        reportCustTableRefeshBtn.setForeground(new java.awt.Color(51, 51, 51));
        reportCustTableRefeshBtn.setText("Refresh");
        reportCustTableRefeshBtn.setToolTipText("Click here to refresh the customer list.");
        reportCustTableRefeshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportCustTableRefeshBtnActionPerformed(evt);
            }
        });

        jPanel29.setBackground(new java.awt.Color(102, 102, 102));
        jPanel29.setPreferredSize(new java.awt.Dimension(210, 80));

        jLabel26.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("List of all customers (alphabetical):");

        jLabel38.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("CUSTOMER REPORT");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
                jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel29Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel38)
                                        .addComponent(jLabel26))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
                jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
                jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel20Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                                        .addGroup(jPanel20Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(reportCustTableRefeshBtn)))
                                .addContainerGap())
                        .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
                jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(reportCustTableRefeshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
        );

        jTabbedPane7.addTab("Customers", jPanel20);

        jPanel22.setBackground(new java.awt.Color(51, 51, 51));
        jPanel22.setForeground(new java.awt.Color(255, 255, 255));

        reportsRentalComBox.setBackground(new java.awt.Color(204, 204, 204));
        reportsRentalComBox.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        reportsRentalComBox.setForeground(new java.awt.Color(51, 51, 51));
        reportsRentalComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Date", "Outstanding" }));
        reportsRentalComBox.setToolTipText("Select  a sort method.");
        reportsRentalComBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportsRentalComBoxActionPerformed(evt);
            }
        });

        reportRentalTable.setBackground(new java.awt.Color(51, 51, 51));
        reportRentalTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        reportRentalTable.setForeground(new java.awt.Color(255, 255, 255));
        reportRentalTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Rental ID", "Date Rented", "Date Returned", "Customer ID", "DVD ID"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reportRentalTable.setToolTipText("A list of rentals by date or outstanding.");
        jScrollPane5.setViewportView(reportRentalTable);

        jPanel30.setBackground(new java.awt.Color(102, 102, 102));
        jPanel30.setPreferredSize(new java.awt.Dimension(257, 80));

        jLabel28.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("List of rentals sorted by date or outstanding:");

        jLabel39.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("RENTALS REPORT");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
                jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel30Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel39)
                                        .addComponent(jLabel28))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
                jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                                .addContainerGap(19, Short.MAX_VALUE)
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel28)
                                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
                jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                        .addGroup(jPanel22Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(reportsRentalComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
                jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reportsRentalComBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTabbedPane7.addTab("Rentals", jPanel22);

        jPanel21.setBackground(new java.awt.Color(51, 51, 51));
        jPanel21.setForeground(new java.awt.Color(255, 255, 255));

        reportsDVDTable.setBackground(new java.awt.Color(51, 51, 51));
        reportsDVDTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        reportsDVDTable.setForeground(new java.awt.Color(255, 255, 255));
        reportsDVDTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Category", "Title", "DVD ID", "Price", "New Release", "Available"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reportsDVDTable.setToolTipText("An alphabetical list of DVDs by category.");
        jScrollPane4.setViewportView(reportsDVDTable);

        reportDVDComBox.setBackground(new java.awt.Color(204, 204, 204));
        reportDVDComBox.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        reportDVDComBox.setForeground(new java.awt.Color(51, 51, 51));
        reportDVDComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "horror", "Sci-fi", "Drama", "Romance", "Comedy", "Action", "Cartoon" }));
        reportDVDComBox.setToolTipText("Select a category.");
        reportDVDComBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportDVDComBoxActionPerformed(evt);
            }
        });

        jPanel31.setBackground(new java.awt.Color(102, 102, 102));

        jLabel27.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("An alphabetical list of DVDs by category:");

        jLabel40.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("DVD Report");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
                jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel31Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel27)
                                        .addComponent(jLabel40))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
                jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                                .addContainerGap(17, Short.MAX_VALUE)
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel27)
                                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
                jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                                        .addGroup(jPanel21Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(reportDVDComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
                jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reportDVDComBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jTabbedPane7.addTab("DVDs", jPanel21);

        jTabbedPane1.addTab("Reports", jTabbedPane7);

        jTabbedPane4.setBackground(new java.awt.Color(153, 153, 153));
        jTabbedPane4.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane4.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        jPanel26.setBackground(new java.awt.Color(102, 102, 102));

        jLabel29.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Search Customers");

        jLabel30.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Please enter the customers details below:");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
                jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel26Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel29)
                                        .addComponent(jLabel30))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
                jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(jLabel30)
                                .addContainerGap())
        );

        searchCustIDTxt.setBackground(new java.awt.Color(102, 102, 102));
        searchCustIDTxt.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        searchCustIDTxt.setForeground(new java.awt.Color(255, 255, 255));
        searchCustIDTxt.setToolTipText("Enter Customer ID.");

        jLabel31.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Please enter customer ID:");

        searchCustResultsTable.setBackground(new java.awt.Color(51, 51, 51));
        searchCustResultsTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        searchCustResultsTable.setForeground(new java.awt.Color(255, 255, 255));
        searchCustResultsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "Name", "Surname", "Phone No", "Credit", "Can Rent"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        searchCustResultsTable.setToolTipText("Field showing requested customer.");
        jScrollPane6.setViewportView(searchCustResultsTable);

        searchCustSearchBtn.setBackground(new java.awt.Color(204, 204, 204));
        searchCustSearchBtn.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        searchCustSearchBtn.setForeground(new java.awt.Color(51, 51, 51));
        searchCustSearchBtn.setText("Search");
        searchCustSearchBtn.setToolTipText("Click here to search for a customer.");
        searchCustSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCustSearchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel31)
                                                .addGap(18, 18, 18)
                                                .addComponent(searchCustIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(searchCustSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel31)
                                        .addComponent(searchCustIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchCustSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(157, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Customers", jPanel5);

        jPanel23.setBackground(new java.awt.Color(51, 51, 51));

        jPanel27.setBackground(new java.awt.Color(102, 102, 102));

        jLabel32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Search DVDs:");

        jLabel33.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Please enter details below:");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
                jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel27Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel33)
                                        .addComponent(jLabel32))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
                jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel27Layout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel33)
                                .addGap(14, 14, 14))
        );

        jLabel34.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Please enter the first letter of the DVD title:");

        searchDVDtitleTxt.setBackground(new java.awt.Color(102, 102, 102));
        searchDVDtitleTxt.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        searchDVDtitleTxt.setForeground(new java.awt.Color(255, 255, 255));
        searchDVDtitleTxt.setToolTipText("Enter the first character of the DVD name.");

        searchDVDTable.setBackground(new java.awt.Color(51, 51, 51));
        searchDVDTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        searchDVDTable.setForeground(new java.awt.Color(255, 255, 255));
        searchDVDTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Title", "ID", "Category", "Price", "New Release", "Available"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        searchDVDTable.setToolTipText("A table of dvd results (by title searched).");
        jScrollPane7.setViewportView(searchDVDTable);

        searchDVDSearchBtn.setBackground(new java.awt.Color(204, 204, 204));
        searchDVDSearchBtn.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        searchDVDSearchBtn.setForeground(new java.awt.Color(51, 51, 51));
        searchDVDSearchBtn.setText("Search");
        searchDVDSearchBtn.setToolTipText("Click here to search for a DVD.");
        searchDVDSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDVDSearchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
                jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel23Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel23Layout.createSequentialGroup()
                                                .addComponent(jLabel34)
                                                .addGap(18, 18, 18)
                                                .addComponent(searchDVDtitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                                                .addComponent(searchDVDSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane7))
                                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
                jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchDVDtitleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel34)
                                        .addComponent(searchDVDSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTabbedPane4.addTab("DVDs", jPanel23);

        jPanel34.setBackground(new java.awt.Color(51, 51, 51));

        jPanel35.setBackground(new java.awt.Color(102, 102, 102));

        jLabel45.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Search DVDs:");

        jLabel46.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Please enter details below:");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
                jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel35Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel46)
                                        .addComponent(jLabel45))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
                jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel46)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel47.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Please enter DVD ID:");

        searchDVDIDTxt.setBackground(new java.awt.Color(102, 102, 102));
        searchDVDIDTxt.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        searchDVDIDTxt.setForeground(new java.awt.Color(255, 255, 255));
        searchDVDIDTxt.setToolTipText("Please enter DVD ID.");

        searchDVDIDBtn.setBackground(new java.awt.Color(153, 153, 153));
        searchDVDIDBtn.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        searchDVDIDBtn.setForeground(new java.awt.Color(51, 51, 51));
        searchDVDIDBtn.setText("Search");
        searchDVDIDBtn.setToolTipText("Click here to search for a DVD.");
        searchDVDIDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDVDIDBtnActionPerformed(evt);
            }
        });

        searchDVDIDTable.setBackground(new java.awt.Color(51, 51, 51));
        searchDVDIDTable.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        searchDVDIDTable.setForeground(new java.awt.Color(255, 255, 255));
        searchDVDIDTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Title", "ID", "Category", "Price", "New Release", "Available"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        searchDVDIDTable.setToolTipText("A list containing a DVD searched by ID.");
        jScrollPane9.setViewportView(searchDVDIDTable);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
                jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                                        .addGroup(jPanel34Layout.createSequentialGroup()
                                                .addComponent(jLabel47)
                                                .addGap(18, 18, 18)
                                                .addComponent(searchDVDIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(searchDVDIDBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20))
        );
        jPanel34Layout.setVerticalGroup(
                jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel34Layout.createSequentialGroup()
                                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchDVDIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchDVDIDBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel47))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 137, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("DVD ID", jPanel34);

        jPanel24.setBackground(new java.awt.Color(51, 51, 51));

        jPanel28.setBackground(new java.awt.Color(102, 102, 102));

        jLabel35.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Search Rentals");

        jLabel36.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Please enter rental details below:");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
                jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel28Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel35)
                                        .addComponent(jLabel36))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
                jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(jLabel36)
                                .addContainerGap())
        );

        jLabel37.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Please enter a date (E.g 21 Jan 2018):");

        searchRentalsDateTxt.setBackground(new java.awt.Color(102, 102, 102));
        searchRentalsDateTxt.setForeground(new java.awt.Color(255, 255, 255));
        searchRentalsDateTxt.setToolTipText("Please enter a valid date (yyyy MMM dd).");

        searchRentalsTable.setBackground(new java.awt.Color(51, 51, 51));
        searchRentalsTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        searchRentalsTable.setForeground(new java.awt.Color(255, 255, 255));
        searchRentalsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Rental ID", "Date Rented", "Date Returned", "Customer ID", "dvd id"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        searchRentalsTable.setToolTipText("A table containing rentals sorted by date.");
        jScrollPane8.setViewportView(searchRentalsTable);

        renralReportSearchBtn.setBackground(new java.awt.Color(204, 204, 204));
        renralReportSearchBtn.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        renralReportSearchBtn.setForeground(new java.awt.Color(51, 51, 51));
        renralReportSearchBtn.setText("Search");
        renralReportSearchBtn.setToolTipText("Click here to search for rentals.");
        renralReportSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentalReportSearchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
                jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel24Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane8)
                                        .addGroup(jPanel24Layout.createSequentialGroup()
                                                .addComponent(jLabel37)
                                                .addGap(18, 18, 18)
                                                .addComponent(searchRentalsDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                                                .addComponent(renralReportSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
                jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel37)
                                                .addComponent(searchRentalsDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(renralReportSearchBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTabbedPane4.addTab("Rentals", jPanel24);

        jTabbedPane1.addTab("Search", jTabbedPane4);

        javax.swing.GroupLayout dynamicPanelLayout = new javax.swing.GroupLayout(dynamicPanel);
        dynamicPanel.setLayout(dynamicPanelLayout);
        dynamicPanelLayout.setHorizontalGroup(
                dynamicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dynamicPanelLayout.createSequentialGroup()
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 10, Short.MAX_VALUE))
        );
        dynamicPanelLayout.setVerticalGroup(
                dynamicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dynamicPanelLayout.createSequentialGroup()
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dynamicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dynamicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void rentalReportSearchBtnActionPerformed(ActionEvent evt) {

        DefaultTableModel model = (DefaultTableModel) searchRentalsTable.getModel();

        boolean valid = false;

        if(searchRentalsDateTxt.getText().equals("")){
            valid = false;
        }
        else{
            valid = true;
        }

        if(valid){
            try {
                model = (DefaultTableModel) searchRentalsTable.getModel();
                Object rowData[] = new Object[5];

                String sDate1 = searchRentalsDateTxt.getText();

                SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
                Calendar cal1 = Calendar.getInstance();
                cal1.setTime(sdf.parse(sDate1));

                model.setRowCount(0);

                for(int i = 0;i < guiRentals.size();i++){

                    String dateString = "";
                    dateString = guiRentals.get(i).getDateRented();

                    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
                    Calendar cal2 = Calendar.getInstance();
                    cal2.setTime(sdf2.parse(dateString));

                    if(cal1.compareTo(cal2) == 0){
                        rowData[0] = guiRentals.get(i).getRentalNumber();
                        rowData[1] = guiRentals.get(i).getDateRented();
                        rowData[2] = guiRentals.get(i).getDateReturned();
                        rowData[3] = guiRentals.get(i).getCustNumber();
                        rowData[4] = guiRentals.get(i).getDvdNumber();
                        model.addRow(rowData);
                    }
                }

                searchRentalsDateTxt.setText("");
                searchRentalsDateTxt.requestFocus();

            } catch (ParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Invalid date entered, please re-enter date (E.g 30 Dec 2018).", "Error", JOptionPane.INFORMATION_MESSAGE);
                model.setRowCount(0);
                searchRentalsDateTxt.requestFocus();
                searchRentalsDateTxt.setText("");
            }
        }
        if(!valid){
            JOptionPane.showMessageDialog(null, "Please ensure all values have been entered.", "Error", JOptionPane.INFORMATION_MESSAGE);
            searchRentalsDateTxt.requestFocus();
            searchRentalsDateTxt.setText("");
        }
    }


    private int setCategory(int comboIndex){
        int i = 0;

        switch (comboIndex)
        {
            case 0: i = 1;
                break;

            case 1: i = 2;
                break;

            case 2: i = 3;
                break;

            case 3: i = 4;
                break;

            case 4: i = 5;
                break;

            case 5: i = 6;
                break;

            case 6: i = 7;
        }
        return i;
    }

    public String setDBCategory(int sCategory)
    {
        String category = "";
        switch(sCategory)
        {
            case 1:
                category = "horror";
                break;
            case 2:
                category = "Sci-fi";
                break;
            case 3:
                category = "Drama";
                break;
            case 4:
                category = "Romance";
                break;
            case 5:
                category = "Comedy";
                break;
            case 6:
                category = "Action";
                break;
            case 7:
                category = "Cartoon";
                break;
        }
        return category;
    }

    private boolean setRel(int i){

        boolean newRel;

        if(i==0){
            newRel=false;
        }
        else{
            newRel = true;
        }
        return newRel;
    }

    public String getStringCanRent(boolean can){
        String result;
        if(can){
            result = "Yes";
        }else{
            result = "No";
        }
        return result;
    }

    private void DelDvdDelBtnActionPerformed(java.awt.event.ActionEvent evt) {

        boolean exists = false;
        boolean valid = false;

        if(DelDvdIDTxt.getText().equals("")){
            valid = false;
        }else{
            valid = true;
        }
        if(valid) {

            for (int i = 0; i < guiDVDs.size(); i++) {
                if (Integer.parseInt(DelDvdIDTxt.getText()) == guiDVDs.get(i).getDvdNumber()) {
                    exists = true;
                }
            }
            if (!exists) {
                JOptionPane.showMessageDialog(null, "A DVD with this ID does not exist, please re-enter ID.", "Error", JOptionPane.INFORMATION_MESSAGE);
                DelDvdIDTxt.setText("");
            }
            if (exists) {

                boolean isAvailable = false;

                for (int i = 0; i < guiDVDs.size(); i++) {
                    if (Integer.parseInt(DelDvdIDTxt.getText()) == guiDVDs.get(i).getDvdNumber()) {
                        if (guiDVDs.get(i).isAvailable() == true) {
                            isAvailable = true;
                        }
                    }
                }
                if (!isAvailable){
                    if (JOptionPane.showConfirmDialog(null, "This DVD is currently being rented, are you sure you wish to delete? \n                                (This will remove it's rental).", "WARNING",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                        int tempCustID = 0;
                        int tempDvdID = 0;

                        for (int i = 0; i < guiDVDs.size(); i++) {
                            if (Integer.parseInt(DelDvdIDTxt.getText()) == guiDVDs.get(i).getDvdNumber()) {
                                tempDvdID = guiDVDs.get(i).getDvdNumber();
                                guiDVDs.remove(i);
                            }
                        }
                        for (int i = 0; i < guiRentals.size(); i++) {
                            if (guiRentals.get(i).getDvdNumber() == tempDvdID) {
                                tempCustID = guiRentals.get(i).getCustNumber();
                                guiRentals.remove(i);
                            }
                        }
                        for (int i = 0; i < guiCusts.size(); i++) {
                            if (guiCusts.get(i).getCustNumber() == tempCustID) {
                                guiCusts.get(i).setCanRent(true);
                            }
                        }
                        cl.communicate("FUPDATE customer SET canRent = 1 WHERE id = " + tempCustID);
                        cl.getResponse();
                        cl.communicate("DDELETE FROM dvd WHERE dvdId = " + Integer.parseInt(DelDvdIDTxt.getText()) + ";");
                        JOptionPane.showMessageDialog(null, cl.getResponse(), "Successful", JOptionPane.INFORMATION_MESSAGE);
                        DelDvdIDTxt.setText("");
                        DelDvdIDTxt.requestFocus();

                        addRentalRefreshBtnActionPerformed(evt);
                    }
                }
                if (isAvailable) {
                    int tempDvdNo = 0;
                    for (int j = 0; j < guiDVDs.size(); j++) {
                        if (guiDVDs.get(j).getDvdNumber() == Integer.parseInt(DelDvdIDTxt.getText())){
                            tempDvdNo = guiDVDs.get(j).getDvdNumber();
                            guiDVDs.remove(j);
                        }
                    }
                    cl.communicate("ODELETE FROM dvd WHERE dvdId = " + tempDvdNo);
                    cl.getResponse();
                    JOptionPane.showMessageDialog(null, cl.getResponse(), "Successful", JOptionPane.INFORMATION_MESSAGE);
                    DelDvdIDTxt.setText("");
                    DelDvdIDTxt.requestFocus();

                    addRentalRefreshBtnActionPerformed(evt);
                }
            }
        }
        if(!valid){
            JOptionPane.showMessageDialog(null, "Please ensure all fields have been entered correctly.", "Warning.", JOptionPane.INFORMATION_MESSAGE);
            delCustDelTxt.requestFocus();
        }
    }

    private void addDvdAddBtnActionPerformed(java.awt.event.ActionEvent evt) {

        boolean titleExists= false;
        boolean exists = false;
        boolean valid = false;


        if(addDvdIDTxt.getText().equals("")||addDvdTitleTxt.getText().equals("")) {
            valid = false;
        }
        else{
            valid = true;
        }

        if(valid){
            for (int i = 0; i < guiDVDs.size(); i++) {
                if ((Integer.parseInt(addDvdIDTxt.getText()) == guiDVDs.get(i).getDvdNumber())) {
                    exists = true;
                }
            }
        }

        for(int i =0;i < guiDVDs.size();i++){
            if(addDvdTitleTxt.getText().equalsIgnoreCase(guiDVDs.get(i).getTitle())){
                titleExists = true;
            }
        }

        if(!valid){
            JOptionPane.showMessageDialog(null, "Please make sure all values have been entered.");
        }

        if(exists){
            JOptionPane.showMessageDialog(null, "A dvd with this ID already exists, please re-enter value.", "Error", JOptionPane.INFORMATION_MESSAGE);
            addDvdIDTxt.setText("");
            addDvdTitleTxt.requestFocus();
        }

        if(titleExists){
            JOptionPane.showMessageDialog(null, "A dvd with this title already exists, please re-enter value.", "Error", JOptionPane.INFORMATION_MESSAGE);
            addDvdTitleTxt.setText("");
            addDvdTitleTxt.requestFocus();
        }


        try {
            if (!addDvdIDTxt.getText().equals("")&&!addDvdTitleTxt.getText().equals("")) {
                guiDVDs.add(new DVD(Integer.parseInt(addDvdIDTxt.getText()), addDvdTitleTxt.getText(), setCategory(addDvdCatComBox.getSelectedIndex()), setRel(addDvdNewRelComBox.getSelectedIndex()), true));
                cl.communicate("CINSERT INTO DVD(dvdId, title, category, newRelease, available) VALUES(" + Integer.parseInt(addDvdIDTxt.getText()) + "," + "'" + addDvdTitleTxt.getText() + "'" + "," + "'" + setDBCategory(setCategory(addDvdCatComBox.getSelectedIndex())) + "'" + "," + setRel(addDvdNewRelComBox.getSelectedIndex()) + "," + true + ")");
                JOptionPane.showMessageDialog(null, cl.getResponse(), "Successful", JOptionPane.INFORMATION_MESSAGE);
                addDvdCatComBox.setSelectedIndex(0);
                addDvdIDTxt.setText("");
                addDvdTitleTxt.setText("");
                addDvdNewRelComBox.setSelectedIndex(0);
                addRentalRefreshBtnActionPerformed(evt);
            }
        }catch(Exception e){
            e.getMessage();
        }
    }

    private void addCustAddBtnActionPerformed(java.awt.event.ActionEvent evt) {

        boolean exists = false;
        boolean valid = false;

        if((addcustIDTxt.getText().equals(""))||(addcustNameTxt.getText().equals(""))||(addcustSurnameTxt.getText().equals(""))||(addcustPhoneTxt.getText().equals(""))){
            valid = false;
        }
        else{
            valid = true;
        }

        if(valid) {
            for (int i = 0; i < guiCusts.size(); i++) {
                if (Integer.parseInt(addcustIDTxt.getText()) == guiCusts.get(i).getCustNumber()) {
                    exists = true;
                }
            }
        }

        if(!valid){
            JOptionPane.showMessageDialog(null, "Please make sure all values have been entered.");
        }

        if(exists){
            JOptionPane.showMessageDialog(null, "A customer with this ID already exists, please re-enter values.", "Error", JOptionPane.INFORMATION_MESSAGE);
            addcustIDTxt.setText("");
        }

        if(!exists){

            if(valid) {
                guiCusts.add(new Customer(Integer.parseInt(addcustIDTxt.getText()), addcustNameTxt.getText(), addcustSurnameTxt.getText(), addcustPhoneTxt.getText(), 100.00, true));
                cl.communicate("AINSERT INTO CUSTOMER(id, name, surname, phone, credit, canRent) VALUES(" + Integer.parseInt(addcustIDTxt.getText()) + "," + "'" + addcustNameTxt.getText() + "'" + "," + "'" + addcustSurnameTxt.getText() + "'" + "," + "'" + addcustPhoneTxt.getText() +  "'" + "," + 100.00 + ","
                        + true + ")");
                JOptionPane.showMessageDialog(null, "Prompt customer to pay account fee (R100).", "Reminder",JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, cl.getResponse(), "Successful", JOptionPane.INFORMATION_MESSAGE);
                addcustIDTxt.setText("");
                addcustNameTxt.setText("");
                addcustSurnameTxt.setText("");
                addcustPhoneTxt.setText("");
                addRentalRefreshBtnActionPerformed(evt);
            }
        }
    }

    private void addRentalRefreshBtnActionPerformed(java.awt.event.ActionEvent evt) {

        addRentalCustList.setModel(new DefaultListModel());
        DefaultListModel custListModel = (DefaultListModel) addRentalCustList.getModel();
        custListModel.removeAllElements();
        addRentalDvdByCategoryJList.setModel(new DefaultListModel());
        DefaultListModel dvdListModel = (DefaultListModel) addRentalDvdByCategoryJList.getModel();
        dvdListModel.removeAllElements();
        Font defaultCustListFont = addRentalCustList.getFont();
        Font defaultDvdListFont = addRentalDvdByCategoryJList.getFont();
        addRentalCustList.setFont(new Font("monospaced",defaultCustListFont.getStyle(),defaultCustListFont.getSize()));
        addRentalDvdByCategoryJList.setFont(new Font("monospaced",defaultDvdListFont.getStyle(), defaultDvdListFont.getSize()));

        for(int i = 0;i < guiCusts.size();i++){
            if(guiCusts.get(i).canRent()){
                custListModel.addElement(String.format("%-1d :%-9s :%-10s :R%-1.2f  ", guiCusts.get(i).getCustNumber(), guiCusts.get(i).getName(), guiCusts.get(i).getSurname(), guiCusts.get(i).getCredit()));
            }
        }

        for(int i = 0;i < guiDVDs.size();i++){
            if(guiDVDs.get(i).isAvailable()){
                dvdListModel.addElement(String.format("%-1d :%-34s :R%-6.2f :%-1s", guiDVDs.get(i).getDvdNumber(),guiDVDs.get(i).getTitle(),guiDVDs.get(i).getPrice(),getStringCanRent(guiDVDs.get(i).isNewRelease())));
            }
        }
        addRentalDvdByCategoryJList.setModel(dvdListModel);
        addRentalCustList.setModel(custListModel);
    }

    private void addRentalRentBtnActionPerformed(java.awt.event.ActionEvent evt) {

        if (addRentalCustList.isSelectionEmpty() || addRentalDvdByCategoryJList.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Please make sure both a DVD and customer are selcted before attempting to rent.", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String custValues = addRentalCustList.getSelectedValue();
            String dvdValues = addRentalDvdByCategoryJList.getSelectedValue();

            String[] custValArr = custValues.split(":");
            String[] dvdValArr = dvdValues.split(":");

            String custId = custValArr[0];
            String formattedCustId = custId.replaceAll(" ", "");

            String dvdId = dvdValArr[0];
            String formattedDvdId = dvdId.replaceAll(" ", "");

            double custCred = 0;
            double dvdCost = 0;

            for (int i = 0; i < guiCusts.size(); i++) {
                if (guiCusts.get(i).getCustNumber() == Integer.parseInt(formattedCustId)) {
                    custCred = guiCusts.get(i).getCredit();
                }
            }

            for (int i = 0; i < guiDVDs.size(); i++) {
                if (guiDVDs.get(i).getDvdNumber() == Integer.parseInt(formattedDvdId)) {
                    dvdCost = guiDVDs.get(i).getPrice();
                }
            }

            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
            LocalDate now = LocalDate.now();

            String intDate = "";

            switch (LocalDate.now().getMonth()) {
                case JANUARY:
                    intDate = "01";
                    break;
                case FEBRUARY:
                    intDate = "02";
                    break;
                case MARCH:
                    intDate = "03";
                    break;
                case APRIL:
                    intDate = "04";
                    break;
                case MAY:
                    intDate = "05";
                    break;
                case JUNE:
                    intDate = "06";
                    break;
                case JULY:
                    intDate = "07";
                    break;
                case AUGUST:
                    intDate = "08";
                    break;
                case SEPTEMBER:
                    intDate = "09";
                    break;
                case OCTOBER:
                    intDate = "10";
                    break;
                case NOVEMBER:
                    intDate = "11";
                    break;
                case DECEMBER:
                    intDate = "12";
                    break;
            }

            String date = "";

            date = (LocalDate.now().getYear()+"/"+ intDate +"/"+LocalDate.now().getDayOfMonth());

            /*boolean badDate = false;
            String userDate;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");

            try {
                userDate = JOptionPane.showInputDialog(null, "Please input the date: Eg(12 Aug 2018).", "Enter Date", JOptionPane.INFORMATION_MESSAGE);
                Date convertedCurrentDate = simpleDateFormat.parse(userDate);
                date =  sdf2.format(convertedCurrentDate );

            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Invalid date, please retry.", "Enter Date", JOptionPane.INFORMATION_MESSAGE);
                badDate = true;
            }

            //&& !badDate
            */
                if (custCred >= dvdCost ) {

                        for (int i = 0; i < guiCusts.size(); i++) {
                            if (guiCusts.get(i).getCustNumber() == Integer.parseInt(formattedCustId)) {
                                guiCusts.get(i).setCredit(custCred - dvdCost);
                                guiCusts.get(i).setCanRent(false);
                            }
                        }

                        String dvdTitle = "";

                        for (int i = 0; i < guiDVDs.size(); i++) {
                            if (guiDVDs.get(i).getDvdNumber() == Integer.parseInt(formattedDvdId)) {
                                guiDVDs.get(i).setAvailable(false);
                                dvdTitle = guiDVDs.get(i).getTitle();
                            }
                        }

                        guiRentals.add(new Rental(rentalIdCounter, date, Integer.parseInt(formattedCustId), Integer.parseInt(formattedDvdId)));

                        cl.communicate("FUPDATE customer SET canRent = 0 WHERE id = " + Integer.parseInt(formattedCustId));
                        cl.getResponse();
                        cl.communicate("FUPDATE customer SET credit = " + (custCred - dvdCost) + " WHERE id = " + Integer.parseInt(formattedCustId));
                        cl.getResponse();
                        cl.communicate("FUPDATE dvd SET available = 0 WHERE dvdId = " + Integer.parseInt(formattedDvdId));
                        cl.getResponse();
                        cl.communicate("FINSERT INTO rental(rentalId, dateRented, dateReturned, custId, dvdIdNo) VALUES(" + rentalIdCounter + "," + "'" + date + "'" + "," + "'NA'" + "," + Integer.parseInt(formattedCustId) + "," + Integer.parseInt(formattedDvdId) + ")");

                        for (int i = 0; i < guiCusts.size(); i++) {
                            if (guiCusts.get(i).getCustNumber() == Integer.parseInt(formattedCustId)) {
                                JOptionPane.showMessageDialog(null, "*************** T & C's Receipt ***************\n"
                                        + "\n"
                                        + "------------------------------------------------------------\n"
                                        + "\n"
                                        + "Name: " + guiCusts.get(i).getName() + "\n"
                                        + "Surname: " + guiCusts.get(i).getSurname() + "\n"
                                        + "Customer ID: " + guiCusts.get(i).getCustNumber() + "\n"
                                        + "DVD Rented: " + dvdTitle + "\n"
                                        + "DVD number: " + formattedDvdId + "\n"
                                        + "DVD price: R" + dvdCost + "0\n"
                                        + "Date rented: " + date + "\n"
                                        + "\n"
                                        + "Remaining credits: R" + (custCred - dvdCost) + "\n"
                                        + "------------------------------------------------------------\n"
                                        + "\n"
                                        + "Please note that the DVD is rented for 24 \n"
                                        + "hours a PENALTY FEE of R5 will be charged \n"
                                        + "once every day after the initial 24 hour period. \n"
                                        + "\n"
                                        + "****************** Thank you ******************");
                            }
                        }
                        rentalIdCounter += 1;
                        addRentalRefreshBtnActionPerformed(evt);
                    }


                if (custCred < dvdCost) {
                    if (JOptionPane.showConfirmDialog(null, "You do not have enough credit to complete this rental.\n        Would you like to add 100 credits to your account?", "WARNING",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                        String custName = "";

                        for (int i = 0; i < guiCusts.size(); i++) {
                            if (guiCusts.get(i).getCustNumber() == Integer.parseInt(formattedCustId)) {
                                guiCusts.get(i).setCredit((custCred + 100) - dvdCost);
                                guiCusts.get(i).setCanRent(false);
                                custName = guiCusts.get(i).getName();
                            }
                        }

                        String dvdTitle = "";

                        for (int i = 0; i < guiDVDs.size(); i++) {
                            if (guiDVDs.get(i).getDvdNumber() == Integer.parseInt(formattedDvdId)) {
                                guiDVDs.get(i).setAvailable(false);
                                dvdTitle = guiDVDs.get(i).getTitle();
                            }
                        }

                        JOptionPane.showMessageDialog(null, "100 credits added to " + custName + "'s account.", "Successful", JOptionPane.INFORMATION_MESSAGE);

                        guiRentals.add(new Rental(rentalIdCounter, date, Integer.parseInt(formattedCustId), Integer.parseInt(formattedDvdId)));

                        cl.communicate("FUPDATE customer SET canRent = 0 WHERE id = " + Integer.parseInt(formattedCustId));
                        cl.getResponse();
                        cl.communicate("FUPDATE customer SET credit = " + ((custCred + 100) - dvdCost) + " WHERE id = " + Integer.parseInt(formattedCustId));
                        cl.getResponse();
                        cl.communicate("FUPDATE dvd SET available = 0 WHERE dvdId = " + Integer.parseInt(formattedDvdId));
                        cl.getResponse();
                        cl.communicate("FINSERT INTO rental(rentalId, dateRented, dateReturned, custId, dvdIdNo) VALUES(" + rentalIdCounter + "," + "'" + date + "'" + "," + "'NA'" + "," + Integer.parseInt(formattedCustId) + "," + Integer.parseInt(formattedDvdId) + ")");

                        for (int i = 0; i < guiCusts.size(); i++) {
                            if (guiCusts.get(i).getCustNumber() == Integer.parseInt(formattedCustId)) {
                                JOptionPane.showMessageDialog(null, "*************** T & C's Receipt ***************\n"
                                        + "\n"
                                        + "------------------------------------------------------------\n"
                                        + "\n"
                                        + "Name: " + guiCusts.get(i).getName() + "\n"
                                        + "Surname: " + guiCusts.get(i).getSurname() + "\n"
                                        + "Customer ID: " + guiCusts.get(i).getCustNumber() + "\n"
                                        + "DVD Rented: " + dvdTitle + "\n"
                                        + "DVD number: " + formattedDvdId + "\n"
                                        + "DVD price: R" + dvdCost + "0\n"
                                        + "Date rented: " + date + "\n"
                                        + "\n"
                                        + "Remaining credit: R" + ((custCred + 100) - dvdCost) + "\n"
                                        + "------------------------------------------------------------\n"
                                        + "\n"
                                        + "Please note that the DVD is rented for 24 \n"
                                        + "hours a PENALTY FEE of R5 will be charged \n"
                                        + "once every day after the initial 24 hour period. \n"
                                        + "\n"
                                        + "****************** Thank you ******************");
                            }
                        }
                        rentalIdCounter += 1;
                        addRentalRefreshBtnActionPerformed(evt);
                    } else {
                        if (JOptionPane.showConfirmDialog(null, "Would you like to pay the fee for this rental?\nCost: R" + dvdCost, "WARNING",
                                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                            double rentalFeeCred = ((custCred + dvdCost) - dvdCost);

                            String custName = "";

                            for (int i = 0; i < guiCusts.size(); i++) {
                                if (guiCusts.get(i).getCustNumber() == Integer.parseInt(formattedCustId)) {
                                    guiCusts.get(i).setCredit(rentalFeeCred);
                                    guiCusts.get(i).setCanRent(false);
                                    custName = guiCusts.get(i).getName();
                                }
                            }

                            String dvdTitle = "";

                            for (int i = 0; i < guiDVDs.size(); i++) {
                                if (guiDVDs.get(i).getDvdNumber() == Integer.parseInt(formattedDvdId)) {
                                    guiDVDs.get(i).setAvailable(false);
                                    dvdTitle = guiDVDs.get(i).getTitle();
                                }
                            }

                            JOptionPane.showMessageDialog(null, "Added " + dvdCost + " credits added to " + custName + "'s account.", "Successful", JOptionPane.INFORMATION_MESSAGE);

                            guiRentals.add(new Rental(rentalIdCounter, date, Integer.parseInt(formattedCustId), Integer.parseInt(formattedDvdId)));

                            cl.communicate("FUPDATE customer SET canRent = 0 WHERE id = " + Integer.parseInt(formattedCustId));
                            cl.getResponse();
                            cl.communicate("FUPDATE customer SET credit = " + rentalFeeCred + " WHERE id = " + Integer.parseInt(formattedCustId));
                            cl.getResponse();
                            cl.communicate("FUPDATE dvd SET available = 0 WHERE dvdId = " + Integer.parseInt(formattedDvdId));
                            cl.getResponse();
                            cl.communicate("FINSERT INTO rental(rentalId, dateRented, dateReturned, custId, dvdIdNo) VALUES(" + rentalIdCounter + "," + "'" + date + "'" + "," + "'NA'" + "," + Integer.parseInt(formattedCustId) + "," + Integer.parseInt(formattedDvdId) + ")");

                            for (int i = 0; i < guiCusts.size(); i++) {
                                if (guiCusts.get(i).getCustNumber() == Integer.parseInt(formattedCustId)) {
                                    JOptionPane.showMessageDialog(null, "*************** T & C's Receipt ***************\n"
                                            + "\n"
                                            + "------------------------------------------------------------\n"
                                            + "\n"
                                            + "Name: " + guiCusts.get(i).getName() + "\n"
                                            + "Surname: " + guiCusts.get(i).getSurname() + "\n"
                                            + "Customer ID: " + guiCusts.get(i).getCustNumber() + "\n"
                                            + "DVD Rented: " + dvdTitle + "\n"
                                            + "DVD number: " + formattedDvdId + "\n"
                                            + "DVD price: R" + dvdCost + "0\n"
                                            + "Date rented: " + date + "\n"
                                            + "\n"
                                            + "Remaining credits: R" + rentalFeeCred + "\n"
                                            + "------------------------------------------------------------\n"
                                            + "\n"
                                            + "Please note that the DVD is rented for 24 \n"
                                            + "hours a PENALTY FEE of R5 will be charged \n"
                                            + "once every day after the initial 24 hour period. \n"
                                            + "\n"
                                            + "****************** Thank you ******************");
                                }
                            }
                            rentalIdCounter += 1;
                            addRentalRefreshBtnActionPerformed(evt);
                        } else {
                            JOptionPane.showMessageDialog(null, "Rental cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        }

    private void returnPanelReturnBtnActionPerformed(java.awt.event.ActionEvent evt) {

        boolean valid = false;
        boolean exists = false;

        if (returnRentalIDTxt.getText().equals("")) {
            valid = false;
        } else {
            valid = true;
        }

        if(!valid){
            JOptionPane.showMessageDialog(null, "Please ensure that all values have been correctly entered.", "Warning", JOptionPane.INFORMATION_MESSAGE);
            returnRentalIDTxt.setText("");
            returnRentalIDTxt.requestFocus();
        }

        if (valid) {
            for (int i = 0; i < guiRentals.size(); i++) {
                if(Integer.parseInt(returnRentalIDTxt.getText())==(guiRentals.get(i).getRentalNumber())){
                    exists = true;
                }
            }
        }

        if(!exists){
            JOptionPane.showMessageDialog(null, "A rental with this rental number does not exist.", "Warning", JOptionPane.INFORMATION_MESSAGE);
            returnRentalIDTxt.setText("");
            returnRentalIDTxt.requestFocus();
        }

        if(exists){

            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
            LocalDate now = LocalDate.now();
            String intDate = "";

            switch(LocalDate.now().getMonth())
            {
                case JANUARY:
                    intDate = "01";
                    break;
                case FEBRUARY:
                    intDate = "02";
                    break;
                case MARCH:
                    intDate = "03";
                    break;
                case APRIL:
                    intDate = "04";
                    break;
                case MAY:
                    intDate = "05";
                    break;
                case JUNE:
                    intDate = "06";
                    break;
                case JULY:
                    intDate = "07";
                    break;
                case AUGUST:
                    intDate = "08";
                    break;
                case SEPTEMBER:
                    intDate = "09";
                    break;
                case OCTOBER:
                    intDate = "10";
                    break;
                case NOVEMBER:
                    intDate = "11";
                    break;
                case DECEMBER:
                    intDate = "12";
                    break;
            }

            String date = (LocalDate.now().getYear()+"/"+ intDate +"/"+LocalDate.now().getDayOfMonth());

            String custName = "";
            String dvdName = "";
            int custId = 0;
            int dvdId = 0;
            int rentalId = 0;
            double cost = 0;
            double custCred = 0;
            boolean alreadyReturned = true;

            for(int i = 0;i < guiRentals.size();i++){
                if(Integer.parseInt(returnRentalIDTxt.getText())==(guiRentals.get(i).getRentalNumber())){
                    custId = guiRentals.get(i).getCustNumber();
                    dvdId = guiRentals.get(i).getDvdNumber();
                    rentalId = guiRentals.get(i).getRentalNumber();
                }
            }

            for(int i = 0;i < guiRentals.size();i++){
                if(guiRentals.get(i).getRentalNumber() == rentalId){
                    if(guiRentals.get(i).getDateReturned().equals("NA")) {
                        alreadyReturned = false;
                    }
                }
            }

            if(alreadyReturned){
                JOptionPane.showMessageDialog(null, "This rental has already been returned.", "Error", JOptionPane.INFORMATION_MESSAGE);
                returnRentalIDTxt.setText("");
                returnRentalIDTxt.requestFocus();
            }

            if(!alreadyReturned) {
                for(int i = 0;i < guiRentals.size();i++){
                    if(Integer.parseInt(returnRentalIDTxt.getText()) == (guiRentals.get(i).getRentalNumber())){
                        guiRentals.get(i).setDateReturned(date);
                        guiRentals.get(i).determineTotalPenaltyCost();
                        cost = guiRentals.get(i).getTotalPenaltyCost();
                    }
                }
            }

            for(int i = 0;i < guiCusts.size();i++){
                if(guiCusts.get(i).getCustNumber() == custId){
                    custCred = guiCusts.get(i).getCredit();
                    custName = guiCusts.get(i).getName();
                }
            }

            for(int i = 0;i < guiDVDs.size();i++){
                if(guiDVDs.get(i).getDvdNumber() == dvdId){
                    dvdName = guiDVDs.get(i).getTitle();
                }
            }

            if((cost == 0)&&(!alreadyReturned)){
                for(int i = 0;i < guiCusts.size();i++){
                    if(guiCusts.get(i).getCustNumber() == custId){
                        guiCusts.get(i).setCanRent(true);
                    }
                }

                for(int i = 0;i < guiDVDs.size();i++){
                    if(guiDVDs.get(i).getDvdNumber() == dvdId){
                        guiDVDs.get(i).setAvailable(true);
                    }
                }

                cl.communicate("FUPDATE RENTAL SET dateReturned = " + "'" + date + "'" + " WHERE rentalID = " + rentalId);
                cl.getResponse();
                cl.communicate("FUPDATE customer SET canRent = 1 WHERE id = " + custId);
                cl.getResponse();
                cl.communicate("FUPDATE dvd SET available = 1 WHERE dvdID = " + dvdId);
                cl.getResponse();

                JOptionPane.showMessageDialog(null, "*************** T & C's Receipt ***************\n"
                        + "\n"
                        + "------------------------------------------------------------\n"
                        + "\n"
                        + "Name: " + custName + "\n"
                        + "Customer ID: " + custId + "\n"
                        + "DVD Rented: " + dvdName + "\n"
                        + "DVD number: " + dvdId + "\n"
                        + "Overdue: R" + cost + "0\n"
                        + "Date renturned: " + date + "\n"
                        + "\n"
                        + "Remaining credits: R" + custCred + "\n"
                        + "------------------------------------------------------------\n"
                        + "\n"
                        + "DVD returned. Thank you for using T & C DVD    \n"
                        + "rentals. Remember, returning your rental within\n"
                        + "24h prevents any overdue charges on your acc.  \n"
                        + "\n"
                        + "****************** Thank you ******************");

                returnRentalIDTxt.setText("");
                returnRentalIDTxt.requestFocus();
                addRentalRefreshBtnActionPerformed(evt);
            }

            if((custCred >= cost)&&(cost != 0)&&(!alreadyReturned)){

                double afterFee = 0;

                for(int i = 0;i < guiCusts.size();i++){
                    if(guiCusts.get(i).getCustNumber() == custId){
                        guiCusts.get(i).setCanRent(true);
                        guiCusts.get(i).setCredit(custCred - cost);
                        afterFee = guiCusts.get(i).getCredit();
                    }
                }

                for(int i = 0;i < guiDVDs.size();i++){
                    if(guiDVDs.get(i).getDvdNumber() == dvdId){
                        guiDVDs.get(i).setAvailable(true);
                    }
                }

                cl.communicate("FUPDATE RENTAL SET dateReturned = " + "'" + date + "'" + " WHERE rentalID = " + rentalId);
                cl.getResponse();
                cl.communicate("FUPDATE customer SET canRent = 1 WHERE id = " + custId);
                cl.getResponse();
                cl.communicate("FUPDATE customer SET credit = " + afterFee + "WHERE id = " + custId);
                cl.getResponse();
                cl.communicate("FUPDATE dvd SET available = 1 WHERE dvdID = " + dvdId);
                cl.getResponse();

                JOptionPane.showMessageDialog(null, "*************** T & C's Receipt ***************\n"
                        + "\n"
                        + "------------------------------------------------------------\n"
                        + "\n"
                        + "Name: " + custName + "\n"
                        + "Customer ID: " + custId + "\n"
                        + "DVD Rented: " + dvdName + "\n"
                        + "DVD number: " + dvdId + "\n"
                        + "Overdue: R" + cost + "0\n"
                        + "Date renturned: " + date + "\n"
                        + "\n"
                        + "Remaining credits: R" + afterFee + "\n"
                        + "------------------------------------------------------------\n"
                        + "\n"
                        + "DVD returned. Thank you for using T & C DVD    \n"
                        + "rentals. Remember, returning your rental within\n"
                        + "24h prevents any overdue charges on your acc.  \n"
                        + "\n"
                        + "****************** Thank you ******************");

                returnRentalIDTxt.setText("");
                returnRentalIDTxt.requestFocus();
                addRentalRefreshBtnActionPerformed(evt);
            }

            if((custCred < cost)&&(cost != 0)&&(!alreadyReturned)){
                if(JOptionPane.showConfirmDialog(null, "You do not have sufficient credit to pay the outstanding fee: R" + cost + "\nWould you like to pay this fee (cash)?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){

                    double afterFee = 0;

                    for(int i = 0;i < guiCusts.size();i++){
                        if(guiCusts.get(i).getCustNumber() == custId){
                            guiCusts.get(i).setCanRent(true);
                            guiCusts.get(i).setCredit((custCred + cost) - cost);
                            afterFee = guiCusts.get(i).getCredit();
                        }
                    }

                    for(int i = 0;i < guiDVDs.size();i++){
                        if(guiDVDs.get(i).getDvdNumber() == dvdId){
                            guiDVDs.get(i).setAvailable(true);
                        }
                    }

                    cl.communicate("FUPDATE RENTAL SET dateReturned = " + "'" + date + "'" + " WHERE rentalID = " + rentalId);
                    cl.getResponse();
                    cl.communicate("FUPDATE customer SET canRent = 1 WHERE id = " + custId);
                    cl.getResponse();
                    cl.communicate("FUPDATE customer SET credit = " + afterFee + "WHERE id = " + custId);
                    cl.getResponse();
                    cl.communicate("FUPDATE dvd SET available = 1 WHERE dvdID = " + dvdId);
                    cl.getResponse();

                    JOptionPane.showMessageDialog(null, "*************** T & C's Receipt ***************\n"
                            + "\n"
                            + "------------------------------------------------------------\n"
                            + "\n"
                            + "Name: " + custName + "\n"
                            + "Customer ID: " + custId + "\n"
                            + "DVD Rented: " + dvdName + "\n"
                            + "DVD number: " + dvdId + "\n"
                            + "Overdue: R" + cost + "0\n"
                            + "Date renturned: " + date + "\n"
                            + "\n"
                            + "Remaining credits: R" + afterFee + "\n"
                            + "------------------------------------------------------------\n"
                            + "\n"
                            + "DVD returned. Thank you for using T & C DVD    \n"
                            + "rentals. Remember, returning your rental within\n"
                            + "24h prevents any overdue charges on your acc.  \n"
                            + "\n"
                            + "****************** Thank you ******************");

                    returnRentalIDTxt.setText("");
                    returnRentalIDTxt.requestFocus();
                    addRentalRefreshBtnActionPerformed(evt);
                }else{
                    for(int i = 0;i < guiRentals.size();i++){
                        if(rentalId == guiRentals.get(i).getRentalNumber()){
                            guiRentals.get(i).setDateReturned("NA");
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Return cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    private void reportCustTableRefeshBtnActionPerformed(java.awt.event.ActionEvent evt) {

        DefaultTableModel model = (DefaultTableModel) reportCustTable.getModel();
        model.setRowCount(0);
        alphaCusts.removeAll(alphaCusts);

        model = (DefaultTableModel) reportCustTable.getModel();
        ArrayList<Customer> alphaCusts = new ArrayList<Customer>(Database.getAllCustomers());

        Collections.sort(alphaCusts, new Comparator<Customer>() {

            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getSurname().toUpperCase().compareTo(o2.getSurname().toUpperCase());
            }
        });

        Object rowData[] = new Object[6];

        for(int i =0;i < alphaCusts.size();i++) {
            rowData[0] = alphaCusts.get(i).getSurname();
            rowData[1] = alphaCusts.get(i).getName();
            rowData[2] = alphaCusts.get(i).getCustNumber();
            rowData[3] = alphaCusts.get(i).getPhoneNum();
            rowData[4] = "R" + alphaCusts.get(i).getCredit();
            rowData[5] = getStringCanRent(alphaCusts.get(i).canRent());
            model.addRow(rowData);
        }
    }

    private void reportsRentalComBoxActionPerformed(java.awt.event.ActionEvent evt) {

        DefaultTableModel model = (DefaultTableModel) reportRentalTable.getModel();
        model.setRowCount(0);
        reportRentals.removeAll(reportRentals);

        Object rowData[] = new Object[5];
        ArrayList<Rental> reportRentals = new ArrayList<Rental>(Database.getAllRentals());

        int selection = reportsRentalComBox.getSelectedIndex();

        if(selection == 0) {
            for (int i = 0; i < reportRentals.size(); i++) {

                rowData[0] = reportRentals.get(i).getRentalNumber();
                rowData[1] = reportRentals.get(i).getDateRented();
                rowData[2] = reportRentals.get(i).getDateReturned();
                rowData[3] = reportRentals.get(i).getCustNumber();
                rowData[4] = reportRentals.get(i).getDvdNumber();
                model.addRow(rowData);

                Collections.sort(reportRentals, new Comparator<Rental>() {

                    @Override
                    public int compare(Rental o1, Rental o2) {

                        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
                        Calendar cal1 = Calendar.getInstance();
                        Calendar cal2 = Calendar.getInstance();
                        try {
                            cal1.setTime(sdf2.parse(o1.getDateRented()));
                            cal2.setTime(sdf2.parse(o2.getDateRented()));
                        }catch(ParseException e){
                            e.getMessage();
                        }
                        return cal1.compareTo(cal2);
                    }
                });
            }
        }
        if(selection == 1){
            for(int i = 0;i < reportRentals.size();i++){
                if(reportRentals.get(i).getDateReturned().toUpperCase().equals("NA")) {
                    rowData[0] = reportRentals.get(i).getRentalNumber();
                    rowData[1] = reportRentals.get(i).getDateRented();
                    rowData[2] = reportRentals.get(i).getDateReturned();
                    rowData[3] = reportRentals.get(i).getCustNumber();
                    rowData[4] = reportRentals.get(i).getDvdNumber();
                    model.addRow(rowData);
                }
            }
        }
    }

    private void reportDVDComBoxActionPerformed(java.awt.event.ActionEvent evt) {

        DefaultTableModel model = (DefaultTableModel) reportsDVDTable.getModel();
        model.setRowCount(0);
        reportDVDs.removeAll(reportDVDs);

        model = (DefaultTableModel) reportsDVDTable.getModel();
        Object rowData[] = new Object[6];
        ArrayList<DVD> reportDVDs = new ArrayList<DVD>(Database.getAllDVDs());

        String selection = setDBCategory(setCategory(reportDVDComBox.getSelectedIndex()));

        Collections.sort(reportDVDs, new Comparator<DVD>() {

            @Override
            public int compare(DVD o1, DVD o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        for(int i = 0;i < reportDVDs.size();i++) {
            if (selection.equalsIgnoreCase(reportDVDs.get(i).getCategory())){
                rowData[0] = reportDVDs.get(i).getCategory();
                rowData[1] = reportDVDs.get(i).getTitle();
                rowData[2] = reportDVDs.get(i).getDvdNumber();
                rowData[3] = "R" + reportDVDs.get(i).getPrice();
                rowData[4] = getStringCanRent(reportDVDs.get(i).isNewRelease());
                rowData[5] = getStringCanRent(reportDVDs.get(i).isAvailable());
                model.addRow(rowData);
            }
        }
    }

    private void searchCustSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {

        boolean exists = false;
        boolean valid = false;

        DefaultTableModel model = (DefaultTableModel) searchCustResultsTable.getModel();
        model.setRowCount(0);

        if(searchCustIDTxt.getText().equals("")){
            valid = false;
        }else{
            valid = true;
        }

        if(valid){

            for(int i = 0;i < guiCusts.size();i++){
                if(Integer.parseInt(searchCustIDTxt.getText()) == guiCusts.get(i).getCustNumber()){
                    exists = true;
                }
            }
            if(!exists){
                JOptionPane.showMessageDialog(null, "A customer with this ID does not exist, please re-enter ID.", "Error", JOptionPane.INFORMATION_MESSAGE);
                searchCustIDTxt.setText("");
            }
        }
        if(!valid){
            JOptionPane.showMessageDialog(null, "Please ensure all values have been entered.");
        }
        if(exists){

            model = (DefaultTableModel) searchCustResultsTable.getModel();

            Object rowData[] = new Object[6];

            for(int i =0;i < guiCusts.size();i++){
                if(Integer.parseInt(searchCustIDTxt.getText())==guiCusts.get(i).getCustNumber()){
                    rowData[0] = guiCusts.get(i).getCustNumber();
                    rowData[1] = guiCusts.get(i).getName();
                    rowData[2] = guiCusts.get(i).getSurname();
                    rowData[3] = guiCusts.get(i).getPhoneNum();
                    rowData[4] = "R" + guiCusts.get(i).getCredit();
                    rowData[5] = getStringCanRent(guiCusts.get(i).canRent());
                    model.addRow(rowData);
                }
            }
            searchCustIDTxt.setText("");
            searchCustIDTxt.requestFocus();
        }
    }

    public char getFirstCharTitle(String title) {
        return title.toUpperCase().charAt(0);
    }

    private void searchDVDSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {

        DefaultTableModel model = (DefaultTableModel) searchDVDTable.getModel();
        model.setRowCount(0);

        searchDvds.removeAll(searchDvds);
        ArrayList<DVD> searchDvds = new ArrayList<DVD>(Database.getAllDVDs());

        if(searchDVDtitleTxt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please ensure all values have been entered correctly.", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            try {
                char x = searchDVDtitleTxt.getText().toUpperCase().charAt(0);
                model = (DefaultTableModel) searchDVDTable.getModel();
                Object rowData[] = new Object[6];

                if (!searchDvds.isEmpty()) {

                    Collections.sort(searchDvds, new Comparator<DVD>() {
                        @Override
                        public int compare(DVD o1, DVD o2) {
                            return o1.getTitle().compareTo(o2.getTitle());
                        }
                    });

                    for (int i = 0; i < searchDvds.size(); i++) {
                        if (getFirstCharTitle(searchDvds.get(i).getTitle()) == x) {
                            rowData[0] = searchDvds.get(i).getTitle();
                            rowData[1] = searchDvds.get(i).getDvdNumber();
                            rowData[2] = searchDvds.get(i).getCategory();
                            rowData[3] = "R" + searchDvds.get(i).getPrice();
                            rowData[4] = getStringCanRent(searchDvds.get(i).isNewRelease());
                            rowData[5] = getStringCanRent(searchDvds.get(i).isAvailable());
                            model.addRow(rowData);
                        }
                        searchDVDtitleTxt.requestFocus();
                        searchDVDtitleTxt.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No Movies To Search For.", "Error", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    private void addRentalCatComBoxActionPerformed(java.awt.event.ActionEvent evt) {

        addRentalDvdByCategoryJList.setModel(new DefaultListModel());
        DefaultListModel dvdListModel1 = (DefaultListModel) addRentalDvdByCategoryJList.getModel();
        dvdListModel1.clear();
        Font defaultDvdListFont = addRentalDvdByCategoryJList.getFont();
        addRentalDvdByCategoryJList.setFont(new Font("monospaced",defaultDvdListFont.getStyle(), defaultDvdListFont.getSize()));

        String selection = setDBCategory(setCategory(addRentalCatComBox.getSelectedIndex()));

        Collections.sort(guiDVDs, new Comparator<DVD>() {
            @Override
            public int compare(DVD o1, DVD o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        for(int i = 0;i < guiDVDs.size();i++) {
            if (selection.equalsIgnoreCase(guiDVDs.get(i).getCategory())){
                if(guiDVDs.get(i).isAvailable()) {
                    dvdListModel1.addElement(String.format("%-1d :%-34s :R%-6.2f :%-1s", guiDVDs.get(i).getDvdNumber(), guiDVDs.get(i).getTitle(), guiDVDs.get(i).getPrice(), getStringCanRent(guiDVDs.get(i).isNewRelease())));
                }
            }
            addRentalDvdByCategoryJList.setModel(dvdListModel1);
        }
    }

    private void delCustDelBtnActionPerformed(java.awt.event.ActionEvent evt) {

        boolean exists = false;
        boolean valid = false;

        if(delCustDelTxt.getText().equals("")){
            valid = false;
        }else{
            valid = true;
        }
        if(valid) {

            for (int i = 0; i < guiCusts.size(); i++) {
                if (Integer.parseInt(delCustDelTxt.getText()) == guiCusts.get(i).getCustNumber()) {
                    exists = true;
                }
            }
            if (!exists) {
                JOptionPane.showMessageDialog(null, "A customer with this ID does not exist, please re-enter ID.", "Error", JOptionPane.INFORMATION_MESSAGE);
                delCustDelTxt.setText("");
            }
            if (exists) {

                boolean isRenting = false;

                for (int i = 0; i < guiCusts.size(); i++) {
                    if (Integer.parseInt(delCustDelTxt.getText()) == guiCusts.get(i).getCustNumber()) {
                        if (guiCusts.get(i).canRent() == false) {
                            isRenting = true;
                        }
                    }
                }
                if (isRenting){
                    if (JOptionPane.showConfirmDialog(null, "This customer is currently renting, are you sure you wish to delete? \n                                (This will remove their rental)", "WARNING",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                        int tempCustID = 0;
                        int tempDvdID = 0;

                        for (int i = 0; i < guiCusts.size(); i++) {
                            if (Integer.parseInt(delCustDelTxt.getText()) == guiCusts.get(i).getCustNumber()) {
                                tempCustID = guiCusts.get(i).getCustNumber();
                                guiCusts.remove(i);
                            }
                        }
                        for (int i = 0; i < guiRentals.size(); i++) {
                            if (guiRentals.get(i).getCustNumber() == tempCustID) {
                                tempDvdID = guiRentals.get(i).getDvdNumber();
                                guiRentals.remove(i);
                            }
                        }
                        for (int i = 0; i < guiDVDs.size(); i++) {
                            if (guiDVDs.get(i).getDvdNumber() == tempDvdID) {
                                guiDVDs.get(i).setAvailable(true);
                            }
                        }
                        cl.communicate("BDELETE FROM CUSTOMER WHERE id = " + Integer.parseInt(delCustDelTxt.getText()) + ";");
                        JOptionPane.showMessageDialog(null, cl.getResponse(), "Successful", JOptionPane.INFORMATION_MESSAGE);
                        delCustDelTxt.setText("");

                        delCustDelTxt.setText("");
                        delCustDelTxt.requestFocus();

                        cl.communicate("FUPDATE DVD SET available = 1 WHERE dvdId = " + tempDvdID);
                        cl.getResponse();

                        addRentalRefreshBtnActionPerformed(evt);
                    }
                }
                if (!isRenting) {
                    int tempCustNo = 0;
                    for (int j = 0; j < guiCusts.size(); j++) {
                        if (guiCusts.get(j).getCustNumber() == Integer.parseInt(delCustDelTxt.getText())){
                            tempCustNo = guiCusts.get(j).getCustNumber();
                            guiCusts.remove(j);
                        }
                    }

                    cl.communicate("LDELETE FROM customer WHERE id = " + tempCustNo);
                    cl.getResponse();
                    JOptionPane.showMessageDialog(null, cl.getResponse(), "Successful", JOptionPane.INFORMATION_MESSAGE);
                    delCustDelTxt.setText("");

                    addRentalRefreshBtnActionPerformed(evt);
                }
            }
        }
        if(!valid){
            JOptionPane.showMessageDialog(null, "Please ensure all fields have been entered correctly.", "Warning.", JOptionPane.INFORMATION_MESSAGE);
            delCustDelTxt.requestFocus();
        }
    }

    private void addCreditAddBtnActionPerformed(java.awt.event.ActionEvent evt) {

        boolean exists = false;
        boolean valid = false;

        if((addCreditCustIDTxt.getText().equals(""))||(addCreditAmtTxt.getText().equals(""))){
            valid = false;
        }
        else{
            valid = true;
        }

        if(valid) {

            for (int i = 0; i < guiCusts.size(); i++) {
                if (Integer.parseInt(addCreditCustIDTxt.getText()) == guiCusts.get(i).getCustNumber()) {
                    exists = true;
                }
            }
            if(!exists){
                JOptionPane.showMessageDialog(null, "A customer with this ID does not exist, please re-enter ID.");
                addCreditCustIDTxt.setText("");
            }
        }

        if(!valid){
            JOptionPane.showMessageDialog(null, "Please ensure all values have been entered.");
        }

        if(exists){

            if(Double.parseDouble(addCreditAmtTxt.getText()) > 999){
                JOptionPane.showMessageDialog(null, "Number too large, please ensure credit amount is correct (0 - 999).");
                addCreditAmtTxt.setText("");
            }
            else{
                double cred = 0;
                int custToAddCred = 0;
                for(int i = 0;i < guiCusts.size();i++) {
                    if (Integer.parseInt(addCreditCustIDTxt.getText()) == guiCusts.get(i).getCustNumber()) {
                        cred = Double.parseDouble(addCreditAmtTxt.getText());
                        custToAddCred = i;
                    }
                }
                double currCred = guiCusts.get(custToAddCred).getCredit();
                guiCusts.get(custToAddCred).setCredit(currCred + cred);
                cl.communicate("KUPDATE customer SET credit = " + (currCred + cred) + " WHERE id = " + addCreditCustIDTxt.getText());
                addCreditCustIDTxt.setText("");
                addCreditAmtTxt.setText("");
                JOptionPane.showMessageDialog(null, cl.getResponse());

                addRentalRefreshBtnActionPerformed(evt);
            }
        }
    }

    private void searchDVDIDBtnActionPerformed(java.awt.event.ActionEvent evt) {

        boolean exists = false;
        boolean valid = false;

        DefaultTableModel model = (DefaultTableModel) searchDVDIDTable.getModel();
        model.setRowCount(0);

        if(searchDVDIDTxt.getText().equals("")){
            valid = false;
        }else{
            valid = true;
        }

        if(valid){

            for(int i = 0;i < guiDVDs.size();i++){
                if(Integer.parseInt(searchDVDIDTxt.getText()) == guiDVDs.get(i).getDvdNumber()){
                    exists = true;
                }
            }
            if(!exists){
                JOptionPane.showMessageDialog(null, "A dvd with this ID does not exist, please re-enter ID.", "Error", JOptionPane.INFORMATION_MESSAGE);
                searchDVDIDTxt.setText("");
            }
        }
        if(!valid){
            JOptionPane.showMessageDialog(null, "Please ensure all values have been entered.");
        }
        if(exists){

            model = (DefaultTableModel) searchDVDIDTable.getModel();

            Object rowData[] = new Object[6];

            for(int i =0;i < guiDVDs.size();i++){
                if(Integer.parseInt(searchDVDIDTxt.getText())== guiDVDs.get(i).getDvdNumber()){
                    rowData[0] = guiDVDs.get(i).getTitle();
                    rowData[1] = guiDVDs.get(i).getDvdNumber();
                    rowData[2] = guiDVDs.get(i).getCategory();
                    rowData[3] = "R" +guiDVDs.get(i).getPrice();
                    rowData[4] = getStringCanRent(guiDVDs.get(i).isNewRelease());
                    rowData[5] = getStringCanRent(guiDVDs.get(i).isAvailable());
                    model.addRow(rowData);
                }
            }
            searchDVDIDTxt.setText("");
            searchDVDIDTxt.requestFocus();
        }
    }

    private javax.swing.JButton DelDvdDelBtn;
    private javax.swing.JTextField DelDvdIDTxt;
    private javax.swing.JButton addCreditAddBtn;
    private javax.swing.JTextField addCreditAmtTxt;
    private javax.swing.JTextField addCreditCustIDTxt;
    private javax.swing.JButton addCustAddBtn;
    private javax.swing.JButton addDvdAddBtn;
    private javax.swing.JComboBox<String> addDvdCatComBox;
    private javax.swing.JTextField addDvdIDTxt;
    private javax.swing.JComboBox<String> addDvdNewRelComBox;
    private javax.swing.JTextField addDvdTitleTxt;
    private javax.swing.JComboBox<String> addRentalCatComBox;
    private javax.swing.JList<String> addRentalCustList;
    private javax.swing.JList<String> addRentalDvdByCategoryJList;
    private javax.swing.JButton addRentalRefreshBtn;
    private javax.swing.JButton addRentalRentBtn;
    private javax.swing.JTextField addcustIDTxt;
    private javax.swing.JTextField addcustNameTxt;
    private javax.swing.JTextField addcustPhoneTxt;
    private javax.swing.JTextField addcustSurnameTxt;
    private javax.swing.JButton delCustDelBtn;
    private javax.swing.JTextField delCustDelTxt;
    private javax.swing.JPanel dynamicPanel;
    private javax.swing.JButton renralReportSearchBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTable reportCustTable;
    private javax.swing.JButton reportCustTableRefeshBtn;
    private javax.swing.JComboBox<String> reportDVDComBox;
    private javax.swing.JTable reportRentalTable;
    private javax.swing.JTable reportsDVDTable;
    private javax.swing.JComboBox<String> reportsRentalComBox;
    private javax.swing.JButton returnPanelReturnBtn;
    private javax.swing.JTextField returnRentalIDTxt;
    private javax.swing.JTextField searchCustIDTxt;
    private javax.swing.JTable searchCustResultsTable;
    private javax.swing.JToggleButton searchCustSearchBtn;
    private javax.swing.JButton searchDVDIDBtn;
    private javax.swing.JTable searchDVDIDTable;
    private javax.swing.JTextField searchDVDIDTxt;
    private javax.swing.JToggleButton searchDVDSearchBtn;
    private javax.swing.JTable searchDVDTable;
    private javax.swing.JTextField searchDVDtitleTxt;
    private javax.swing.JTextField searchRentalsDateTxt;
    private javax.swing.JTable searchRentalsTable;
}
