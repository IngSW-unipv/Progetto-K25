package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.facade.registazioniutenti.UserRegistrationFacade;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.view.frames.customer.JCustomerRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.employee.JEmployeeMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.employee.JEmployeeRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JLoginFrame;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.LoginPanel;
import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;
import it.unipv.ingsfw.treninordovest.view.panels.users.EmployeeRegistrationPanel;

import javax.swing.*;
import java.time.ZoneId;
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

    }



    private void registraCliente(){

        String nome,cognome,sesso,password,cellulare,email,indirizzo,luogoNascita;
        Date dataNascita;
        Cliente cliente;

        try {

            nome = viewcustomerRegistrationPanel.getTxtNome().getText();
            cognome = viewcustomerRegistrationPanel.getTxtNome().getText();
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
            cognome = viewemployeeRegistrationPanel.getTxtNome().getText();
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



            if (!password.isEmpty() && !nome.isEmpty() && !cognome.isEmpty() && !sesso.isEmpty() && !luogoNascita.isEmpty() && !cellulare.isEmpty() && !indirizzo.isEmpty() && !(dataNascita ==null)) {

                dipendente= new Dipendente(UUID.randomUUID(),password, nome, cognome, sesso, luogoNascita,dataNascitaLocal, cellulare, indirizzo, 0, ruolo);

                if (userRegistrationFacade.registraDipendente(dipendente)){

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



    }
    private void login(){}
    private  void logout(){}
    private void modificaDatiCliente(){}
    private void modificaDatiDipendente(){}
    private void aggiornaDatiProfilo(){}

    ///Test -- Rimuovere
    public static void main(){
        JCustomerRegFrame frame = new JCustomerRegFrame();
       frame.setVisible(true);
       JEmployeeRegFrame frame2 = new JEmployeeRegFrame();
       frame2.setVisible(true);

    }



    private void addClienteRegistrationListener(){
        frameCustomerReg.getCustomerRegistrationPanel().getBtnRegister().addActionListener(e -> {

            if(frameCustomerReg.getCustomerRegistrationPanel().getBtnRegister().getActionCommand().equals("register")){
                registraCliente();
            }


        });

    }

    private void addDipendenteRegistrationListener(){
        frameEmployeeReg.getEmployeeRegistrationPanel().getBtnRegister().addActionListener(e -> {
            if(frameEmployeeReg.getEmployeeRegistrationPanel().getBtnRegister().getActionCommand().equals("register")){
                registraDipendente();
            }
        });


    }


}
