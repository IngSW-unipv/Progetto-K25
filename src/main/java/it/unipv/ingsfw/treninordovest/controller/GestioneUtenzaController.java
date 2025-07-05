package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.model.facade.login.RegistrationFacade;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JTreniNordOvestFrame;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.login.LoginPanel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.CustomerRegistrationPanel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.dipendente.EmployeeRegistrationPanel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.menu.MainMenuPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.time.LocalDate;
import java.util.UUID;

public class GestioneUtenzaController implements ActionListener{


    private final RegistrationFacade loginFacade;
    private JTreniNordOvestFrame frame;
    private MainMenuPanel viewMainPanel;
    private LoginPanel viewLoginPanel;
    private CustomerRegistrationPanel viewCustomerRegistrationPanel;


    //Costruttore per la registazione clienti
    public GestioneUtenzaController( JTreniNordOvestFrame frame) {
        this.viewMainPanel = frame.getMainMenuPanel();
        this.frame = (JTreniNordOvestFrame) frame;
        this.loginFacade = new RegistrationFacade();


        viewMainPanel.addActionListener(this);
        frame.addActionListener(this);

    }



    private void registraCliente(){

        String nome,cognome,sesso,password,cellulare,email,indirizzo,luogoNascita;
        Date dataNascita;
        Cliente cliente;

        try {

            nome = frame.getCustomerRegistrationPanel().getTxtNome().getText();
            cognome = frame.getCustomerRegistrationPanel().getTxtCognome().getText();
            sesso = frame.getCustomerRegistrationPanel().getComboSesso();

            dataNascita  = frame.getCustomerRegistrationPanel().getDataNascita().getDate();
            if(dataNascita==null){
                JOptionPane.showMessageDialog(null,"Data nascita non inserita","Error",JOptionPane.ERROR_MESSAGE);
            }
            LocalDate dataNascitaLocal= dataNascita.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            cellulare = frame.getCustomerRegistrationPanel().getTxtCellulare().getText();
            email = frame.getCustomerRegistrationPanel().getTxtEmail().getText();
            password = frame.getCustomerRegistrationPanel().getTxtPassword().getText();
            indirizzo = frame.getCustomerRegistrationPanel().getTxtIndirizzo().getText();
            luogoNascita = frame.getCustomerRegistrationPanel().getTxtLuogoNascita().getText();



            if (!password.isEmpty() && !nome.isEmpty() && !cognome.isEmpty() && !email.isEmpty() && !sesso.isEmpty() && !luogoNascita.isEmpty() && !cellulare.isEmpty() && !indirizzo.isEmpty() && !(dataNascita ==null)) {

                cliente = new Cliente(UUID.randomUUID(),password,nome,cognome,luogoNascita,sesso,dataNascitaLocal,cellulare,indirizzo,0, email);

                if (loginFacade.registraCliente(cliente)){

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

        String nome,cognome,sesso,cellulare,indirizzo,luogoNascita,ruolo;
        char[] password;
        Date dataNascita;
        Dipendente dipendente;

        try {

            nome = frame.getEmployeeRegistrationPanel().getTxtNome().getText();
            cognome = frame.getEmployeeRegistrationPanel().getTxtCognome().getText();
            sesso = frame.getEmployeeRegistrationPanel().getComboSesso();

            dataNascita  = frame.getEmployeeRegistrationPanel().getDataNascita().getDate();
            if(dataNascita==null){
                JOptionPane.showMessageDialog(null,"Data nascita non inserita","Error",JOptionPane.ERROR_MESSAGE);
            }
            LocalDate dataNascitaLocal= dataNascita.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            cellulare = frame.getEmployeeRegistrationPanel().getTxtCellulare().getText();
            password = frame.getEmployeeRegistrationPanel().getTxtPassword().getPassword();
            indirizzo = frame.getEmployeeRegistrationPanel().getTxtIndirizzo().getText();
            luogoNascita = frame.getEmployeeRegistrationPanel().getTxtLuogoNascita().getText();
            ruolo = frame.getEmployeeRegistrationPanel().getComboRuolo().toString();



            if (!password.toString().isEmpty() && !nome.isEmpty() && !cognome.isEmpty() && !sesso.isEmpty() && !luogoNascita.isEmpty() && !cellulare.isEmpty() && !indirizzo.isEmpty() && !(dataNascita ==null)&& !dataNascitaLocal.isAfter(LocalDate.now())) {

                dipendente= new Dipendente(UUID.randomUUID(),password.toString(), nome, cognome, sesso, luogoNascita,dataNascitaLocal, cellulare, indirizzo, Dipendente.getStipendioByRuolo(ruolo), ruolo);

                if (loginFacade.registraDipendente(dipendente)){

                    JOptionPane.showMessageDialog(null,"Dipendente registrato correttamente", "Info", JOptionPane.INFORMATION_MESSAGE);
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
        String identificativo =  frame.getLoginPanel().getCampoUtente().getText();
        String password = Arrays.toString(frame.getLoginPanel().getCampoPassword().getPassword());
        String tipoUtente = (String )frame.getLoginPanel().getComboRuolo().getSelectedItem();

        try {
            if (loginFacade.login(identificativo,password,tipoUtente)){
                JOptionPane.showMessageDialog(null,"Login effettuato correttamente", "Info", JOptionPane.INFORMATION_MESSAGE);

                frame.showPanel(frame.getLoginPanel().getComboRuolo().getSelectedItem().toString());
            }
            else
                JOptionPane.showMessageDialog(null, "Problema durante il login", "Errore", JOptionPane.ERROR_MESSAGE);

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



    private void addClienteRegistrationListener(){
        frame.getCustomerRegistrationPanel().getBtnRegister().addActionListener(e -> {
            if(frame.getCustomerRegistrationPanel().getBtnRegister().getActionCommand().equals(CustomerRegistrationPanel.CMD_Register)){
                registraCliente();
            }
        });

        frame.getCustomerRegistrationPanel().getBtnMenuPrincipal().addActionListener(e->{
            if (frame.getCustomerRegistrationPanel().getBtnMenuPrincipal().getActionCommand().equals(CustomerRegistrationPanel.CMD_Back)){
                frame.showPanel(JTreniNordOvestFrame.MAIN_MENU);
            }
        });

    }
    private void addDipendenteRegistrationListener(){
        frame.getEmployeeRegistrationPanel().getBtnRegister().addActionListener(e -> {
            if(frame.getEmployeeRegistrationPanel().getBtnRegister().getActionCommand().equals(EmployeeRegistrationPanel.CMD_Register)){
                registraDipendente();
            }
        });

        frame.getEmployeeRegistrationPanel().getBtnMenuPrincipal().addActionListener(e->{
          if(frame.getEmployeeRegistrationPanel().getBtnMenuPrincipal().getActionCommand().equals(EmployeeRegistrationPanel.CMD_Back)){
                frame.showPanel(JTreniNordOvestFrame.MAIN_MENU);
            }

        });


    }
    private void addLoginListener(){

        frame.getLoginPanel().getBottoneAccesso().addActionListener(e -> {


        });

        frame.getLoginPanel().getBottoneIndietro().addActionListener(e -> {

        });


        loginFacade.addPropertyChangeListener(frame);


    }
    private void addMainMenuListener(){



        frame.getMainMenuPanel().getAccesso().addActionListener(e -> {

            if (frame.getMainMenuPanel().getAccesso().getActionCommand().equals("login")){
                System.out.println("Accesso al login");
                frame.showPanel( JTreniNordOvestFrame.LOGIN );
            }
        });

        frame.getMainMenuPanel().getRegistrazioneDipendente().addActionListener(e -> {
            System.out.println("Registrazione dipendente");
            frame.showPanel(JTreniNordOvestFrame.EMPLOYEE_REGISTRATION);
        });

        frame.getMainMenuPanel().getRegistrazioneCliente().addActionListener(e -> {
            System.out.println("Registrazione cliente");
            frame.showPanel(JTreniNordOvestFrame.CUSTOMER_REGISTRATION);
        });



    }



    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        // Usa uno switch per eseguire l'azione corretta per ogni comando
        // CONTROLLA ATTENTAMENTE QUESTA PARTE NEL TUO CODICE!
        switch (command) {
            case "login":
                // Se il comando è "login", mostra il pannello di LOGIN
                frame.showPanel(JTreniNordOvestFrame.LOGIN);
                break;

            case "customerRegistration":
                // Se è "customerRegistration", mostra il pannello di REGISTRAZIONE CLIENTE
                frame.showPanel(JTreniNordOvestFrame.CUSTOMER_REGISTRATION);
                break;

            case "employeeRegistration":
                // E così via...
                frame.showPanel(JTreniNordOvestFrame.EMPLOYEE_REGISTRATION);
                break;

            // È buona norma avere un caso di default
            default:
                System.err.println("Comando non riconosciuto: " + command);
                break;
        }


    }
}
