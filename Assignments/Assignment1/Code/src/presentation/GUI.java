package presentation;

import businessLogic.contracts.IShowService;
import businessLogic.contracts.ITicketService;
import businessLogic.contracts.IUserService;
import businessLogic.model.ShowModel;
import businessLogic.model.TicketModel;
import businessLogic.model.UserModel;
import businessLogic.services.ShowService;
import businessLogic.services.TicketService;
import businessLogic.services.UserService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GUI {

    IUserService userService;
    IShowService showService;
    ITicketService ticketService;
    login loginPage;

    public GUI() {
        loginPage = new login();
        userService = new UserService();
        showService = new ShowService();
        ticketService = new TicketService();
//        new ReadShows();
//        new CreateShow();
//        new ReadCashiers();
//        new MainMenuAdmin();
//        new CreateCashier();
          //new CreateTicket();
//        new UpdateCashier(2);
//        new UpdateTicket(1);
//        new UpdateShow(3);
//        new ReadTickets(2);
    }

    public class login extends JFrame {
        JButton blogin;
        JPanel loginpanel;
        JTextField txuser;
        JTextField pass;
        JLabel username;
        JLabel password;



        public login(){
            super("Login Autentification");

            blogin = new JButton("Login");
            loginpanel = new JPanel();
            txuser = new JTextField(15);
            pass = new JPasswordField(15);
            username = new JLabel("User - ");
            password = new JLabel("Pass - ");

            setSize(300,200);
            setLocation(500,280);
            loginpanel.setLayout (null);


            txuser.setBounds(70,30,150,20);
            pass.setBounds(70,65,150,20);
            blogin.setBounds(110,100,80,20);
            username.setBounds(20,28,80,20);
            password.setBounds(20,63,80,20);

            loginpanel.add(blogin);
            loginpanel.add(txuser);
            loginpanel.add(pass);
            loginpanel.add(username);
            loginpanel.add(password);

            getContentPane().add(loginpanel);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);

            blogin.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String userName = txuser.getText();
                    String passwd = pass.getText();

                    int loginCode = userService.login(userName, passwd);
                    if (loginCode == 1) {
                         MainMenuAdmin menu =new MainMenuAdmin();
                         dispose();
                    } else if (loginCode == 2){
                        MainMenuCashier menu = new MainMenuCashier();
                        dispose();
                    } else if (userName.equals("") && passwd.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please insert Username and Password");
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong Username / Password");
                        txuser.setText("");
                        pass.setText("");
                        txuser.requestFocus();
                    }
                }
            });

        }

    }

    public class MainMenuCashier extends JFrame {

        JButton bReadTickets;
        JTextField tReadTickets;
        JButton bCreateTicket;
        JButton bDeleteTicket;
        JTextField tDeleteTicket;
        JButton bUpdateTicket;
        JTextField tUpdateTicket;

        JButton bReadShows;
        JButton bCreateShow;
        JButton bDeleteShow;
        JTextField tDeleteShow;
        JButton bUpdateShow;
        JTextField tUpdateShow;

        JTextField tExport;
        JButton bExportCSV;
        JButton bExportXML;

        JPanel jPanel;

        public MainMenuCashier(){

            super("Cashier Menu");

            System.out.println("LOGIN SUCCESSFUL Cashier");

            jPanel = new JPanel();
            bReadTickets = new JButton("Read Tickets");
            tReadTickets = new JTextField(2);
            bCreateTicket = new JButton("Create Ticket");
            bDeleteTicket = new JButton("Delete Ticket");
            tDeleteTicket = new JTextField(2);
            bUpdateTicket = new JButton("Update Ticket");
            tUpdateTicket = new JTextField(2);

            bReadShows = new JButton("Read Shows");
            bCreateShow = new JButton("Create Show");
            bDeleteShow = new JButton("Delete Show");
            tDeleteShow = new JTextField(2);
            bUpdateShow = new JButton("Update Show");
            tUpdateShow = new JTextField(2);

            tExport = new JTextField(2);
            bExportCSV = new JButton("Export Tickets as CSV");
            bExportXML = new JButton("Export Tickets as XML");

            setSize(800, 600);
            setLocation(500, 280);
            jPanel.setLayout(null);

            bReadTickets.setBounds(0, 0, 150, 60);
            tReadTickets.setBounds(150, 0, 30, 60);
            bCreateTicket.setBounds(0,65, 150, 60);
            bDeleteTicket.setBounds(0,130, 150, 60);
            tDeleteTicket.setBounds(150, 130, 30, 60);
            bUpdateTicket.setBounds(0,195, 150, 60);
            tUpdateTicket.setBounds(150,195, 30, 60);

            bReadShows.setBounds(400, 0, 150, 60);
            bCreateShow.setBounds(400,65, 150, 60);
            bDeleteShow.setBounds(400,130, 150, 60);
            tDeleteShow.setBounds(550, 130, 30, 60);
            bUpdateShow.setBounds(400,195, 150, 60);
            tUpdateShow.setBounds(550,195, 30, 60);

            tExport.setBounds(385, 350, 30, 50);
            bExportCSV.setBounds(200, 400, 200, 50);
            bExportXML.setBounds(400, 400, 200, 50);

            jPanel.add(bReadTickets);
            jPanel.add(tReadTickets);
            jPanel.add(bCreateTicket);
            jPanel.add(bDeleteTicket);
            jPanel.add(tDeleteTicket);
            jPanel.add(bUpdateTicket);
            jPanel.add(tUpdateTicket);

            jPanel.add(bReadShows);

            jPanel.add(tExport);
            jPanel.add(bExportCSV);
            jPanel.add(bExportXML);

            getContentPane().add(jPanel);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);


            //action listeners
            bReadTickets.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int idshow = Integer.parseInt(tReadTickets.getText());
                    ReadTickets readTickets = new ReadTickets(idshow);
                }
            });

            bCreateTicket.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CreateTicket createTicket = new CreateTicket();
                }
            });

            bDeleteTicket.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int idticket = Integer.parseInt(tDeleteTicket.getText());
                    System.out.println(idticket);

                    if (ticketService.deleteById(idticket) == true) {
                        JOptionPane.showMessageDialog(null, "Ticket deleted successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR while deleting Ticket");
                    }
                }
            });

            bUpdateTicket.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    UpdateTicket updateTicket = new UpdateTicket(Integer.parseInt(tUpdateTicket.getText()));
                }
            });

            bReadShows.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ReadShows readShows = new ReadShows();
                }
            });

            bCreateShow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CreateShow createShow = new CreateShow();
                }
            });

            bDeleteShow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int idshow = Integer.parseInt(tDeleteShow.getText());
                    System.out.println(idshow);

                    if (showService.deleteById(idshow) == true) {
                        JOptionPane.showMessageDialog(null, "Show deleted successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR while deleting Show");
                    }
                }
            });

            bUpdateShow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    UpdateShow updateShow = new UpdateShow(Integer.parseInt(tUpdateShow.getText()));
                }
            });
        }
    }

    public class MainMenuAdmin extends JFrame {

        JButton bReadCashiers;
        JButton bCreateCashier;
        JButton bDeleteCashier;
        JTextField tDeleteCashier;
        JButton bUpdateCashier;
        JTextField tUpdateCashier;

        JButton bReadShows;
        JButton bCreateShow;
        JButton bDeleteShow;
        JTextField tDeleteShow;
        JButton bUpdateShow;
        JTextField tUpdateShow;

        JTextField tExport;
        JButton bExportCSV;
        JButton bExportXML;

        JPanel jPanel;

        public MainMenuAdmin(){

            super("Admin Menu");

            System.out.println("LOGIN SUCCESSFUL Admin");

            jPanel = new JPanel();
            bReadCashiers = new JButton("Read Cashiers");
            bCreateCashier = new JButton("Create Cashier");
            bDeleteCashier = new JButton("Delete Cashier");
            tDeleteCashier = new JTextField(2);
            bUpdateCashier = new JButton("Update Cashier");
            tUpdateCashier = new JTextField(2);

            bReadShows = new JButton("Read Shows");
            bCreateShow = new JButton("Create Show");
            bDeleteShow = new JButton("Delete Show");
            tDeleteShow = new JTextField(2);
            bUpdateShow = new JButton("Update Show");
            tUpdateShow = new JTextField(2);

            tExport = new JTextField(2);
            bExportCSV = new JButton("Export Tickets as CSV");
            bExportXML = new JButton("Export Tickets as XML");

            setSize(800, 600);
            setLocation(500, 280);
            jPanel.setLayout(null);

            bReadCashiers.setBounds(0, 0, 150, 60);
            bCreateCashier.setBounds(0,65, 150, 60);
            bDeleteCashier.setBounds(0,130, 150, 60);
            tDeleteCashier.setBounds(150, 130, 30, 60);
            bUpdateCashier.setBounds(0,195, 150, 60);
            tUpdateCashier.setBounds(150,195, 30, 60);

            bReadShows.setBounds(400, 0, 150, 60);
            bCreateShow.setBounds(400,65, 150, 60);
            bDeleteShow.setBounds(400,130, 150, 60);
            tDeleteShow.setBounds(550, 130, 30, 60);
            bUpdateShow.setBounds(400,195, 150, 60);
            tUpdateShow.setBounds(550,195, 30, 60);

            tExport.setBounds(385, 350, 30, 50);
            bExportCSV.setBounds(200, 400, 200, 50);
            bExportXML.setBounds(400, 400, 200, 50);

            jPanel.add(bReadCashiers);
            jPanel.add(bCreateCashier);
            jPanel.add(bDeleteCashier);
            jPanel.add(tDeleteCashier);
            jPanel.add(bUpdateCashier);
            jPanel.add(tUpdateCashier);

            jPanel.add(bReadShows);
            jPanel.add(bCreateShow);
            jPanel.add(bDeleteShow);
            jPanel.add(tDeleteShow);
            jPanel.add(bUpdateShow);
            jPanel.add(tUpdateShow);

            jPanel.add(tExport);
            jPanel.add(bExportCSV);
            jPanel.add(bExportXML);

            getContentPane().add(jPanel);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);


            //action listeners
            bReadCashiers.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ReadCashiers readCashiers = new ReadCashiers();
                }
            });

            bCreateCashier.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CreateCashier createCashier = new CreateCashier();
                }
            });

            bDeleteCashier.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int idcashier = Integer.parseInt(tDeleteCashier.getText());
                    System.out.println(idcashier);

                    if (userService.deleteById(idcashier) == true) {
                        JOptionPane.showMessageDialog(null, "Cashier deleted successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR while deleting Cashier");
                    }
                }
            });

            bUpdateCashier.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    UpdateCashier updateCashier = new UpdateCashier(Integer.parseInt(tUpdateCashier.getText()));
                }
            });

            bReadShows.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ReadShows readShows = new ReadShows();
                }
            });

            bCreateShow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CreateShow createShow = new CreateShow();
                }
            });

            bDeleteShow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int idshow = Integer.parseInt(tDeleteShow.getText());
                    System.out.println(idshow);

                    if (showService.deleteById(idshow) == true) {
                        JOptionPane.showMessageDialog(null, "Show deleted successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR while deleting Show");
                    }
                }
            });

            bUpdateShow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    UpdateShow updateShow = new UpdateShow(Integer.parseInt(tUpdateShow.getText()));
                }
            });
        }
    }

    public class CreateShow extends JFrame {

        JTable shows;
        JPanel jPanel;
        JButton bCreateShow;

        public CreateShow(){

            super("Create Show");

            System.out.println("Create Show");

            jPanel = new JPanel();

            String col[] = {"Title", "Genre", "Distribution", "Date", "TotalTickets", "SoldTickets"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);
            shows = new JTable(tableModel);
            tableModel.addRow(col);
            tableModel.addRow(new Object[]{null, null, null, null, "100", "0"});

            bCreateShow = new JButton("Create Show");

            setSize(900, 200);
            setLocation(500, 280);
            jPanel.setLayout(null);

            shows.setBounds(0, 0, 900, 50);
            bCreateShow.setBounds(400, 100, 150, 50);

            jPanel.add(shows);
            jPanel.add(bCreateShow);

            getContentPane().add(jPanel);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);

            //actionListeners
            bCreateShow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //prepare Date
                    Date dateSql = null;
                    try {
                        dateSql = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS").parse(tableModel.getValueAt(1, 3).toString());
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                    //end prepare date

                    ShowModel showModel = new ShowModel();
                    showModel.setTitle(tableModel.getValueAt(1, 0).toString());
                    showModel.setGenre(tableModel.getValueAt(1, 1).toString());
                    showModel.setDistribution(tableModel.getValueAt(1, 2).toString());
                    showModel.setDate(dateSql);
                    showModel.setTotalTickets(Integer.parseInt(tableModel.getValueAt(1, 4).toString()));
                    showModel.setSoldTickets(Integer.parseInt(tableModel.getValueAt(1, 5).toString()));

                    showService.create(showModel);
                    System.out.println("ShowModel: " + showModel);
                }
            });
        }
    }

    public class CreateCashier extends JFrame {

        JTable cashiers;
        JPanel jPanel;
        JButton bCreateCashier;

        public CreateCashier(){

            super("Create Cashier");

            System.out.println("Create Cashier");

            jPanel = new JPanel();

            String col[] = {"Username", "Password", "Name"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);
            cashiers = new JTable(tableModel);
            tableModel.addRow(col);
            tableModel.addRow(new Object[]{null, null, null});

            bCreateCashier = new JButton("Create Cashier");

            setSize(900, 200);
            setLocation(500, 280);
            jPanel.setLayout(null);

            cashiers.setBounds(0, 0, 900, 50);
            bCreateCashier.setBounds(400, 100, 150, 50);

            jPanel.add(cashiers);
            jPanel.add(bCreateCashier);

            getContentPane().add(jPanel);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);

            //actionListeners
            bCreateCashier.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    UserModel userModel = new UserModel();
                    userModel.setUsername(tableModel.getValueAt(1, 0).toString());
                    userModel.setPassword(tableModel.getValueAt(1, 1).toString());
                    userModel.setName(tableModel.getValueAt(1, 2).toString());
                    userModel.setPermission("Cashier");

                    userService.create(userModel);
                    System.out.println("UserModel: " + userModel);
                }
            });
        }
    }

    public class CreateTicket extends JFrame {

        JTable tickets;
        JPanel jPanel;
        JButton bCreateTicket;

        public CreateTicket(){

            super("Create Ticket");

            System.out.println("Create Ticket");

            jPanel = new JPanel();

            String col[] = {"idshow", "seatnb", "rowNb", "onName"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);
            tickets = new JTable(tableModel);
            tableModel.addRow(col);
            tableModel.addRow(new Object[]{null, null, null, null});

            bCreateTicket = new JButton("Create Ticket");

            setSize(900, 200);
            setLocation(500, 280);
            jPanel.setLayout(null);

            tickets.setBounds(0, 0, 900, 50);
            bCreateTicket.setBounds(400, 100, 150, 50);

            jPanel.add(tickets);
            jPanel.add(bCreateTicket);

            getContentPane().add(jPanel);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);

            //actionListeners
            bCreateTicket.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    TicketModel ticketModel = new TicketModel();
                    ticketModel.setIdshow(Integer.parseInt(tableModel.getValueAt(1, 0).toString()));
                    ticketModel.setSeatNb(Integer.parseInt(tableModel.getValueAt(1, 1).toString()));
                    ticketModel.setRowNb(Integer.parseInt(tableModel.getValueAt(1, 2).toString()));
                    ticketModel.setOnName(tableModel.getValueAt(1, 3).toString());

                    ticketService.create(ticketModel);
                    System.out.println("TicketModel: " + ticketModel);
                }
            });
        }
    }

    public class UpdateShow extends JFrame {

        JTable shows;
        JPanel jPanel;
        JButton bUpdateShow;

        public UpdateShow(int idshow){

            super("Update Show");

            System.out.println("Update Show");

            jPanel = new JPanel();

            String col[] = {"Title", "Genre", "Distribution", "Date", "TotalTickets", "SoldTickets"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);
            shows = new JTable(tableModel);
            tableModel.addRow(col);

            ShowModel crtShow = showService.getById(idshow);
            tableModel.addRow(new Object[]{crtShow.getTitle(), crtShow.getGenre(), crtShow.getDistribution(), crtShow.getDate(), crtShow.getTotalTickets(), crtShow.getSoldTickets()});

            bUpdateShow = new JButton("Update Show");

            setSize(900, 200);
            setLocation(500, 280);
            jPanel.setLayout(null);

            shows.setBounds(0, 0, 900, 50);
            bUpdateShow.setBounds(400, 100, 150, 50);

            jPanel.add(shows);
            jPanel.add(bUpdateShow);

            getContentPane().add(jPanel);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);

            //actionListeners
            bUpdateShow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //prepare Date
                    Date dateSql = null;
                    try {
                        dateSql = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS").parse(tableModel.getValueAt(1, 3).toString());
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                    //end prepare date

                    crtShow.setTitle(tableModel.getValueAt(1, 0).toString());
                    crtShow.setGenre(tableModel.getValueAt(1, 1).toString());
                    crtShow.setDistribution(tableModel.getValueAt(1, 2).toString());
                    crtShow.setDate(dateSql);
                    crtShow.setTotalTickets(Integer.parseInt(tableModel.getValueAt(1, 4).toString()));
                    crtShow.setSoldTickets(Integer.parseInt(tableModel.getValueAt(1, 5).toString()));

                    showService.update(crtShow);
                    System.out.println("CrtShow: " + crtShow);
                }
            });
        }
    }

    public class UpdateCashier extends JFrame {

        JTable cashiers;
        JPanel jPanel;
        JButton bUpdateCashier;

        public UpdateCashier(int iduser){

            super("Update Cashier");

            System.out.println("Update Cashier");

            jPanel = new JPanel();

            String col[] = {"Username", "Password", "Name"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);
            cashiers = new JTable(tableModel);
            tableModel.addRow(col);

            UserModel crtUser = userService.getById(iduser);
            tableModel.addRow(new Object[]{crtUser.getUsername(), crtUser.getPassword(), crtUser.getName()});

            bUpdateCashier = new JButton("Update Cashier");

            setSize(900, 200);
            setLocation(500, 280);
            jPanel.setLayout(null);

            cashiers.setBounds(0, 0, 900, 50);
            bUpdateCashier.setBounds(400, 100, 150, 50);

            jPanel.add(cashiers);
            jPanel.add(bUpdateCashier);

            getContentPane().add(jPanel);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);

            //actionListeners
            bUpdateCashier.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    crtUser.setUsername(tableModel.getValueAt(1, 0).toString());
                    crtUser.setPassword(tableModel.getValueAt(1, 1).toString());
                    crtUser.setName(tableModel.getValueAt(1, 2).toString());
                    crtUser.setPermission("Cashier");

                    userService.update(crtUser);
                    System.out.println("crtUser: " + crtUser);
                }
            });
        }
    }

    public class UpdateTicket extends JFrame {

        JTable tickets;
        JPanel jPanel;
        JButton bUpdateTicket;

        public UpdateTicket(int idticket){

            super("Update Ticket");

            System.out.println("Update Ticket");

            jPanel = new JPanel();

            String col[] = {"idshow", "seatnb", "rowNb", "onName"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);
            tickets = new JTable(tableModel);
            tableModel.addRow(col);

            TicketModel crtTicket = ticketService.getById(idticket);
            tableModel.addRow(new Object[]{crtTicket.getIdshow(), crtTicket.getSeatNb(), crtTicket.getRowNb(), crtTicket.getOnName()});

            bUpdateTicket = new JButton("Update Ticket");

            setSize(900, 200);
            setLocation(500, 280);
            jPanel.setLayout(null);

            tickets.setBounds(0, 0, 900, 50);
            bUpdateTicket.setBounds(400, 100, 150, 50);

            jPanel.add(tickets);
            jPanel.add(bUpdateTicket);

            getContentPane().add(jPanel);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);

            //actionListeners
            bUpdateTicket.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    crtTicket.setIdshow(Integer.parseInt(tableModel.getValueAt(1, 0).toString()));
                    crtTicket.setSeatNb(Integer.parseInt(tableModel.getValueAt(1, 1).toString()));
                    crtTicket.setRowNb(Integer.parseInt(tableModel.getValueAt(1, 2).toString()));
                    crtTicket.setOnName(tableModel.getValueAt(1, 3).toString());

                    ticketService.update(crtTicket);
                    System.out.println("CrtTicket: " + crtTicket);
                }
            });
        }
    }


    public class ReadShows extends JFrame {

        JTable shows;
        JPanel jPanel;

        public ReadShows(){

            super("Shows");

            System.out.println("Read Shows");

            jPanel = new JPanel();

            String col[] = {"id", "Title", "Genre", "Distribution", "Date", "TotalTickets", "SoldTickets"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);
            shows = new JTable(tableModel);
            tableModel.addRow(col);

            //populate cashiers table
            for(ShowModel sM: showService.getAll()) {
                Object[] objs = {
                        sM.getIdshow(),
                        sM.getTitle(),
                        sM.getGenre(),
                        sM.getDistribution(),
                        sM.getDate(),
                        sM.getTotalTickets(),
                        sM.getSoldTickets()
                };

                tableModel.addRow(objs);
            }

            setSize(900, 200);
            setLocation(500, 280);
            jPanel.setLayout(null);

            shows.setBounds(0, 0, 900, 200);

            jPanel.add(shows);

            getContentPane().add(jPanel);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
        }
    }

    public class ReadCashiers extends JFrame {

        JTable cashiers;
        JPanel jPanel;

        public ReadCashiers(){

            super("Cashiers");

            System.out.println("Read Cashiers");

            jPanel = new JPanel();

            String col[] = {"id", "username", "password", "permission", "name"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);
            cashiers = new JTable(tableModel);
            tableModel.addRow(col);

            //populate cashiers table
            for(UserModel uM: userService.getAllCashiers()) {
                Object[] objs = {
                      uM.getIduser(),
                      uM.getUsername(),
                      uM.getPassword(),
                      uM.getPermission(),
                      uM.getName()
                };

                tableModel.addRow(objs);
            }

            setSize(500, 200);
            setLocation(500, 280);
            jPanel.setLayout(null);

            cashiers.setBounds(0, 0, 500, 200);

            jPanel.add(cashiers);

            getContentPane().add(jPanel);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
        }
    }

    public class ReadTickets extends JFrame {

        JTable tickets;
        JPanel jPanel;

        public ReadTickets(int idshow){

            super("Tickets");

            System.out.println("Read Tickets");

            jPanel = new JPanel();

            String col[] = {"idticket", "idshow", "seatnb", "rowNb", "onName"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);
            tickets = new JTable(tableModel);
            tableModel.addRow(col);

            //populate tickets table
            for(TicketModel uM: ticketService.getAllByShowid(idshow)) {
                Object[] objs = {
                        uM.getIdticket(),
                        uM.getIdshow(),
                        uM.getSeatNb(),
                        uM.getRowNb(),
                        uM.getOnName()
                };

                tableModel.addRow(objs);
            }

            setSize(500, 200);
            setLocation(500, 280);
            jPanel.setLayout(null);

            tickets.setBounds(0, 0, 500, 200);

            jPanel.add(tickets);

            getContentPane().add(jPanel);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
        }
    }


}
