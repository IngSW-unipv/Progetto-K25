package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.model.dto.LoginDTO;
import it.unipv.ingsfw.treninordovest.model.facade.TreniNordOvestFacade;
import it.unipv.ingsfw.treninordovest.model.service.utente.ProfiloUtenteModel;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JTreniNordOvestFrame;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.CustomerProfilePanel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.dipendente.panels.EmployeeProfilePanel;
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


    private final TreniNordOvestFacade facade;
    private JTreniNordOvestFrame frame;
    private MainMenuPanel viewMainPanel;
    private ProfiloUtenteModel profiloUtenteModel;


    //Costruttore per la registazione clienti
    public GestioneUtenzaController( JTreniNordOvestFrame frame) {
        //this.viewMainPanel = frame.getMainMenuPanel();
        this.frame = (JTreniNordOvestFrame) frame;
        this.facade = TreniNordOvestFacade.getInstance();
        this.profiloUtenteModel=new ProfiloUtenteModel();

       // viewMainPanel.addActionListener(this);

        addActionListener();

    }



    private void registraCliente(){

        String nome,cognome,sesso,cellulare,email,indirizzo,luogoNascita;
        Date dataNascita;
        Cliente cliente;
        char[] password;

        try {

            nome = frame.getCustomerRegistrationPanel().getTxtNome().getText();
            cognome = frame.getCustomerRegistrationPanel().getTxtCognome().getText();
            sesso = frame.getCustomerRegistrationPanel().getComboSesso();

            dataNascita  = frame.getCustomerRegistrationPanel().getDataNascita().getDate();
            if(dataNascita==null){
                JOptionPane.showMessageDialog(null,"Data nascita non inserita","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            LocalDate dataNascitaLocal= dataNascita.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            cellulare = frame.getCustomerRegistrationPanel().getTxtCellulare().getText();
            email = frame.getCustomerRegistrationPanel().getTxtEmail().getText();
            password = frame.getCustomerRegistrationPanel().getTxtPassword().getPassword();

            String passwordString = new String(password); // <-- Conversione corretta
            java.util.Arrays.fill(password, ' ');


            indirizzo = frame.getCustomerRegistrationPanel().getTxtIndirizzo().getText();
            luogoNascita = frame.getCustomerRegistrationPanel().getTxtLuogoNascita().getText();



            if (!passwordString.isEmpty() && !nome.isEmpty() && !cognome.isEmpty() && !email.isEmpty() && !sesso.isEmpty() && !luogoNascita.isEmpty() && !cellulare.isEmpty() && !indirizzo.isEmpty()) {

                cliente = new Cliente(UUID.randomUUID(),passwordString,nome,cognome,luogoNascita,sesso,dataNascitaLocal,cellulare,indirizzo,0, email);

                if (facade.getRegistrationFacade().registraCliente(cliente)){

                    JOptionPane.showMessageDialog(null,"Cliente registrato correttamente", "Info", JOptionPane.INFORMATION_MESSAGE);
                }

            } else
            {
                JOptionPane.showMessageDialog(null, "Compilazione di tutti i campi obbligatoria", "Errore", JOptionPane.ERROR_MESSAGE);
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
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
                return;
            }
            LocalDate dataNascitaLocal= dataNascita.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            cellulare = frame.getEmployeeRegistrationPanel().getTxtCellulare().getText();

            password = frame.getEmployeeRegistrationPanel().getTxtPassword().getPassword();
            String passwordString = new String(password); // <-- Conversione corretta
            java.util.Arrays.fill(password, ' ');

            indirizzo = frame.getEmployeeRegistrationPanel().getTxtIndirizzo().getText();
            luogoNascita = frame.getEmployeeRegistrationPanel().getTxtLuogoNascita().getText();
            ruolo = frame.getEmployeeRegistrationPanel().getComboRuolo().toString();



            if (!Arrays.toString(password).isEmpty() && !nome.isEmpty() && !cognome.isEmpty() && !sesso.isEmpty() && !luogoNascita.isEmpty() && !cellulare.isEmpty() && !indirizzo.isEmpty() && !dataNascitaLocal.isAfter(LocalDate.now())) {


                dipendente= new Dipendente(UUID.randomUUID(), passwordString, nome, cognome, sesso, luogoNascita,dataNascitaLocal, cellulare, indirizzo, Dipendente.getStipendioByRuolo(ruolo), ruolo);

                if (facade.getRegistrationFacade().registraDipendente(dipendente)){

                    JOptionPane.showMessageDialog(null,"Dipendente registrato correttamente\n Questo è il tuo nuovo id \n" + dipendente.getId(), "Info", JOptionPane.INFORMATION_MESSAGE);
                }

            } else
            {
                JOptionPane.showMessageDialog(null, "Dati non sufficienti o errati", "Errore", JOptionPane.ERROR_MESSAGE);
            }


        }catch (Exception e){
            System.out.println(e.getMessage());

        }



    }
    private void login(){
        String identificativo =  frame.getLoginPanel().getCampoUtente().getText();

        char[] passwordInCaratteri = frame.getLoginPanel().getCampoPassword().getPassword();
        String password = new String(passwordInCaratteri);
        // Pulisci l'array per sicurezza subito dopo l'uso
        java.util.Arrays.fill(passwordInCaratteri, ' ');
        String tipoUtente = (String )frame.getLoginPanel().getComboRuolo().getSelectedItem();

        if(password.isEmpty() || identificativo.isEmpty()){
            JOptionPane.showMessageDialog(null,"Compilazione di tutti i campi obbligatoria", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LoginDTO loginDTO = new LoginDTO(identificativo,password,tipoUtente);

        try {
            if (facade.getRegistrationFacade().login(loginDTO)){
                frame.showPanel(frame.getLoginPanel().getComboRuolo().getSelectedItem().toString());
                JOptionPane.showMessageDialog(null,"Accesso effettuato correttamente", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null, "Dati inseriti non validi", "Errore", JOptionPane.ERROR_MESSAGE);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }




    }
    private  void logout(){

        facade.getRegistrationFacade().logout();

    }
    private void modificaDatiCliente(){

        char[] passwordChar = frame.getCustomerMainPanel().getProfilePanel().getTxtPassword().getPassword();
        String password = new String(passwordChar);


        if (facade.getUtenteFacade().aggiornaPasswordCliente(password)){
            JOptionPane.showMessageDialog(null,"Password aggiornata correttamente", "Info", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    private void modificaDatiDipendente(){

        char[] passwordChar = frame.getEmployeeMainPanel().getProfilePanel().getTxtPassword().getPassword();
        String password = new String(passwordChar);


        if(facade.getUtenteFacade().aggiornaPasswordDipendente(password)){
            JOptionPane.showMessageDialog(null,"Password aggiornata correttamente", "Info", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    private void aggiornaDatiProfiloCliente(){

        if (facade.getUtenteFacade().aggiornaProfiloCliente()){
            profiloUtenteModel.setCliente(SessionManager.getInstance().getCurrentUser());
            JOptionPane.showMessageDialog(null,"Profilo aggiornato correttamente", "Info", JOptionPane.INFORMATION_MESSAGE);
        }


    }
    private void aggiornaDatiProfiloDipendente(){
        Dipendente dipendente = facade.getUtenteFacade().aggiornaProfiloDipendente();
        profiloUtenteModel.setDipendente(dipendente);
        JOptionPane.showMessageDialog(null,"Profilo aggiornato correttamente", "Info", JOptionPane.INFORMATION_MESSAGE);

    }



    private void addActionListener(){

        //Action del pannello login
       frame.getLoginPanel().getBottoneAccesso().addActionListener(this);
        frame.getLoginPanel().getBottoneIndietro().addActionListener(this);

        //Action dei menu di registrazione
        frame.getCustomerRegistrationPanel().getBtnRegister().addActionListener(this);
       frame.getEmployeeRegistrationPanel().getBtnRegister().addActionListener(this);
        frame.getCustomerRegistrationPanel() .getBtnMenuPrincipal().addActionListener(this);
        frame.getEmployeeRegistrationPanel().getBtnMenuPrincipal().addActionListener(this);

        //Action del menu principale
        frame.getMainMenuPanel().getRegistrazioneDipendente().addActionListener(this);
        frame.getMainMenuPanel().getRegistrazioneCliente().addActionListener(this);
        frame.getMainMenuPanel().getAccesso().addActionListener(this);

        //Action menu profilo cliente
        frame.getCustomerMainPanel().getProfilePanel().getBtnEsci().addActionListener(this);
        frame.getCustomerMainPanel().getProfilePanel().getBtnAggiornaPassword().addActionListener(this);
        frame.getCustomerMainPanel().getProfilePanel().getBtnAggiornaProfilo().addActionListener(this);

        //Action menu profilo dipendente
        frame.getEmployeeMainPanel().getProfilePanel().getBtnEsci().addActionListener(this);
        frame.getEmployeeMainPanel().getProfilePanel().getBtnAggionaProfilo().addActionListener(this);
        frame.getEmployeeMainPanel().getProfilePanel().getBtnAggiornaPassword().addActionListener(this);

        profiloUtenteModel.addPropertyChangeListener(frame.getCustomerMainPanel().getProfilePanel());
        profiloUtenteModel.addPropertyChangeListener(frame.getEmployeeMainPanel().getProfilePanel());

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        // Usa uno switch per eseguire l'azione corretta per ogni comando
        // CONTROLLA ATTENTAMENTE QUESTA PARTE NEL TUO CODICE!
        switch (command) {
            case MainMenuPanel.CMD_Accesso:
                // Se il comando è "login", mostra il pannello di LOGIN
                frame.showPanel(JTreniNordOvestFrame.LOGIN);
                break;
            case MainMenuPanel.CMD_RegistrazioneCliente:
                // Se è "customerRegistration", mostra il pannello di REGISTRAZIONE CLIENTE
                frame.showPanel(JTreniNordOvestFrame.CUSTOMER_REGISTRATION);
                break;
            case MainMenuPanel.CMD_RegistrazioneDipendente:
                // E così via...
                frame.showPanel(JTreniNordOvestFrame.EMPLOYEE_REGISTRATION);
                break;
            case CustomerRegistrationPanel.CMD_Register:
                   registraCliente();
                    break;
            case EmployeeRegistrationPanel.CMD_Register:
               registraDipendente();
                break;
            case CustomerRegistrationPanel.CMD_Back:
                frame.showPanel(JTreniNordOvestFrame.MAIN_MENU);
                break;
            case EmployeeRegistrationPanel.CMD_Back:
                frame.showPanel(JTreniNordOvestFrame.MAIN_MENU);
                break;
            case LoginPanel.CMD_Login:
                login();
                frame.getLoginPanel().getCampoUtente().setText("");
                frame.getLoginPanel().getCampoPassword().setText("");
                break;
            case LoginPanel.CMD_Back:
                frame.showPanel(JTreniNordOvestFrame.MAIN_MENU);
                break;

            case CustomerProfilePanel.CMD_AGPROFILO:
                aggiornaDatiProfiloCliente();
                break;

            case CustomerProfilePanel.CMD_AGPASS:
                if(frame.getCustomerMainPanel().getProfilePanel().getTxtPassword().getPassword().length>8){
                    modificaDatiCliente();
                    logout();
                    frame.showPanel(JTreniNordOvestFrame.MAIN_MENU);
                } else
                    JOptionPane.showMessageDialog(null,"Password troppo corta", "Errore", JOptionPane.ERROR_MESSAGE);

                break;

            case EmployeeProfilePanel.CMD_UpdateProfile:
                aggiornaDatiProfiloDipendente();
                break;

            case EmployeeProfilePanel.CMD_ChangePassword:

                if(frame.getEmployeeMainPanel().getProfilePanel().getTxtPassword().getPassword().length>8){
                    modificaDatiDipendente();
                    logout();
                    frame.showPanel(JTreniNordOvestFrame.MAIN_MENU);
                }else
                    JOptionPane.showMessageDialog(null,"Password troppo corta", "Errore", JOptionPane.ERROR_MESSAGE);
                break;

            case EmployeeProfilePanel.CMD_Logout:
                logout();
                frame.showPanel(JTreniNordOvestFrame.MAIN_MENU);
                break;

            default:
                System.err.println("Comando non riconosciuto: " + command);
                break;
        }


    }
}
