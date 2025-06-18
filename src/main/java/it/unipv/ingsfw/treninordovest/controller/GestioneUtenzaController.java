package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.facade.login.LoginFacade;
import it.unipv.ingsfw.treninordovest.facade.registazioniutenti.UserRegistrationFacade;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.registrazione.JCustomerRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.dipendenti.menu.registrazione.JEmployeeRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.login.JLoginFrame;
import it.unipv.ingsfw.treninordovest.view.frames.login.LoginPanel;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.registrazione.CustomerRegistrationPanel;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.dipendenti.menu.registrazione.EmployeeRegistrationPanel;

import javax.swing.*;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.time.LocalDate;
import java.util.UUID;

public class GestioneUtenzaController {
    private CustomerRegistrationPanel viewcustomerRegistrationPanel;
    private EmployeeRegistrationPanel viewemployeeRegistrationPanel;
    private LoginPanel viewLoginPanel;
    private JCustomerRegFrame frameCustomerReg;
    private JEmployeeRegFrame frameEmployeeReg;
    private JLoginFrame frameLogin;
    private UserRegistrationFacade userRegistrationFacade;
    private LoginFacade loginFacade;


    //Costruttore per la registazione clienti
    public GestioneUtenzaController(CustomerRegistrationPanel view, JCustomerRegFrame frame) {
        this.viewcustomerRegistrationPanel = view;
        this.frameCustomerReg = frame;
        this.userRegistrationFacade = new UserRegistrationFacade();
        addClienteRegistrationListener();
    }


    public GestioneUtenzaController(EmployeeRegistrationPanel view, JEmployeeRegFrame frame) {
        this.viewemployeeRegistrationPanel= view;
        this.frameEmployeeReg = frame;
        this.userRegistrationFacade = new UserRegistrationFacade();
        addDipendenteRegistrationListener();
    }


    //Costruttore per il login
    public GestioneUtenzaController(LoginPanel view, JLoginFrame frame) {
        this.viewLoginPanel = view;
        this.frameLogin = frame;
        this.loginFacade = new LoginFacade();
        addLoginListener();

    }



    private void registraCliente(){

        String nome,cognome,sesso,password,cellulare,email,indirizzo,luogoNascita;
        Date dataNascita;
        Cliente cliente;

        try {

            nome = viewcustomerRegistrationPanel.getTxtNome().getText();
            cognome = viewcustomerRegistrationPanel.getTxtCognome().getText();
            sesso =viewcustomerRegistrationPanel.getComboSesso();

            dataNascita  =  viewcustomerRegistrationPanel.getDataNascita().getDate();
            if(dataNascita==null){
                JOptionPane.showMessageDialog(null,"Data nascita non inserita","Error",JOptionPane.ERROR_MESSAGE);
            }
            LocalDate dataNascitaLocal= dataNascita.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            cellulare = viewcustomerRegistrationPanel.getTxtCellulare().getText();
            email = viewcustomerRegistrationPanel.getTxtEmail().getText();
            password = viewcustomerRegistrationPanel.getTxtPassword().getText();
            indirizzo = viewcustomerRegistrationPanel.getTxtIndirizzo().getText();
            luogoNascita = viewcustomerRegistrationPanel.getTxtLuogoNascita().getText();



            if (!password.isEmpty() && !nome.isEmpty() && !cognome.isEmpty() && !email.isEmpty() && !sesso.isEmpty() && !luogoNascita.isEmpty() && !cellulare.isEmpty() && !indirizzo.isEmpty() && !(dataNascita ==null)) {

                cliente = new Cliente(UUID.randomUUID(),password,nome,cognome,luogoNascita,sesso,dataNascitaLocal,cellulare,indirizzo,0, email);

                if (userRegistrationFacade.registraCliente(cliente)){

                    JOptionPane.showMessageDialog(null,"Cliente registrato correttamente", "Info", JOptionPane.INFORMATION_MESSAGE);
                }

            } else
            {
                JOptionPane.showMessageDialog(null, "Compilazione di tutti i campi obbligatoria", "Errore", JOptionPane.ERROR_MESSAGE);
            }


        }catch (NullPointerException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


       /**
        * Passaggio dell'oggetto a una facade
        **/

    }
    private void registraDipendente(){

        String nome,cognome,sesso,password,cellulare,indirizzo,luogoNascita,ruolo;
        Date dataNascita;
        Dipendente dipendente;

        try {

            nome = viewemployeeRegistrationPanel.getTxtNome().getText();
            cognome = viewemployeeRegistrationPanel.getTxtCognome().getText();
            sesso =viewemployeeRegistrationPanel.getComboSesso();

            dataNascita  =  viewemployeeRegistrationPanel.getDataNascita().getDate();
            if(dataNascita==null){
                JOptionPane.showMessageDialog(null,"Data nascita non inserita","Error",JOptionPane.ERROR_MESSAGE);
            }
            LocalDate dataNascitaLocal= dataNascita.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            cellulare = viewemployeeRegistrationPanel.getTxtCellulare().getText();
            password = viewemployeeRegistrationPanel.getTxtPassword().getText();
            indirizzo = viewemployeeRegistrationPanel.getTxtIndirizzo().getText();
            luogoNascita = viewemployeeRegistrationPanel.getTxtLuogoNascita().getText();
            ruolo = viewemployeeRegistrationPanel.getComboRuolo();



            if (!password.isEmpty() && !nome.isEmpty() && !cognome.isEmpty() && !sesso.isEmpty() && !luogoNascita.isEmpty() && !cellulare.isEmpty() && !indirizzo.isEmpty() && !(dataNascita ==null)&& !dataNascitaLocal.isAfter(LocalDate.now())) {

                dipendente= new Dipendente(UUID.randomUUID(),password, nome, cognome, sesso, luogoNascita,dataNascitaLocal, cellulare, indirizzo, Dipendente.getStipendioByRuolo(ruolo), ruolo);

                if (userRegistrationFacade.registraDipendente(dipendente)){

                    JOptionPane.showMessageDialog(null,"Cliente registrato correttamente", "Info", JOptionPane.INFORMATION_MESSAGE);
                }

            } else
            {
                JOptionPane.showMessageDialog(null, "Dati non sufficienti o errati", "Errore", JOptionPane.ERROR_MESSAGE);
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }



    }
    private void login(){
        String identificativo =  viewLoginPanel.getCampoUtente().getText();
        String password = Arrays.toString(viewLoginPanel.getCampoPassword().getPassword());
        String tipoUtente = (String )viewLoginPanel.getComboRuolo().getSelectedItem();

        try {
            if (loginFacade.login(identificativo,password,tipoUtente)){
                JOptionPane.showMessageDialog(null,"Cliente login correttamente", "Info", JOptionPane.INFORMATION_MESSAGE);

            }
            else
                JOptionPane.showMessageDialog(null, "Cliente login errati", "Errore", JOptionPane.ERROR_MESSAGE);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }




    }
    private  void logout(){

        loginFacade.logout();

    }
    private void modificaDatiCliente(){}
    private void modificaDatiDipendente(){}
    private void aggiornaDatiProfilo(){}

    ///Test -- Rimuovere
    public static void main(){
        JCustomerRegFrame frame = new JCustomerRegFrame();
       frame.setVisible(true);
       JEmployeeRegFrame frame2 = new JEmployeeRegFrame();
       frame2.setVisible(true);
       JLoginFrame frame3 = new JLoginFrame();
       frame3.setVisible(true);
        JCustomerMainFrame customerMainFrame = new JCustomerMainFrame();
        customerMainFrame.setVisible(true);

    }



    private void addClienteRegistrationListener(){
        frameCustomerReg.getCustomerRegistrationPanel().getBtnRegister().addActionListener(e -> {

            if(frameCustomerReg.getCustomerRegistrationPanel().getBtnRegister().getActionCommand().equals(CustomerRegistrationPanel.CMD_Register)){
                registraCliente();
            }


        });

    }

    private void addDipendenteRegistrationListener(){
        frameEmployeeReg.getEmployeeRegistrationPanel().getBtnRegister().addActionListener(e -> {
            if(frameEmployeeReg.getEmployeeRegistrationPanel().getBtnRegister().getActionCommand().equals(EmployeeRegistrationPanel.CMD_Register)){
                registraDipendente();
            }
        });


    }

    private void addLoginListener(){

        frameLogin.getLoginPanel().getBottoneAccesso().addActionListener(e -> {
            if(frameLogin.getLoginPanel().getBottoneAccesso().getActionCommand().equals(LoginPanel.CMD_Login)){
                login();
            }
        });

    }


}
