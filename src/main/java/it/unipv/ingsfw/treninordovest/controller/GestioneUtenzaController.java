package it.unipv.ingsfw.treninordovest.controller;

import com.mysql.cj.log.Log;
import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.facade.registazioniutenti.UserRegistrationFacade;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.view.frames.customer.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.customer.JCustomerRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JLoginFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.panels.finance.SubscriptionPanel;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.LoginPanel;
import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;

import javax.swing.*;
import java.time.ZoneId;
import java.util.Date;
import java.time.LocalDate;
import java.util.UUID;

public class GestioneUtenzaController {
    private CustomerRegistrationPanel viewcustomerRegistrationPanel;
    private LoginPanel viewLoginPanel;
    private JCustomerRegFrame frameCustomerReg;
    private JLoginFrame frameLogin;
    private UserRegistrationFacade userRegistrationFacade;


    public GestioneUtenzaController(CustomerRegistrationPanel view, JCustomerRegFrame frame) {
        this.viewcustomerRegistrationPanel = view;
        this.frameCustomerReg = frame;
        this.userRegistrationFacade = new UserRegistrationFacade();
        addRegistrationListener();
    }

    public GestioneUtenzaController(LoginPanel view, JLoginFrame frame) {
        this.viewLoginPanel = view;
        this.frameLogin = frame;

    }



    private void registraCliente(){


        Cliente cliente;
        String nome = viewcustomerRegistrationPanel.getTxtNome().getText();
        String cognome = viewcustomerRegistrationPanel.getTxtNome().getText();
        String sesso =viewcustomerRegistrationPanel.getComboSesso();
        Date dataNascita  =  viewcustomerRegistrationPanel.getDataNascita().getDate();
        LocalDate dataNascitaLocal= dataNascita.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
       String cellulare = viewcustomerRegistrationPanel.getTxtCellulare().getText();
       String email = viewcustomerRegistrationPanel.getTxtEmail().getText();
       String password = viewcustomerRegistrationPanel.getTxtPassword().getText();
       String indirizzo = viewcustomerRegistrationPanel.getTxtIndirizzo().getText();
       String luogoNascita = viewcustomerRegistrationPanel.getTxtLuogoNascita().getText();


        if (password.isEmpty() || nome.isEmpty() || cognome.isEmpty() || email.isEmpty() || sesso.isEmpty() || luogoNascita.isEmpty() || cellulare.isEmpty() || indirizzo.isEmpty() ) {

            JOptionPane.showMessageDialog(null, "Compilazione di tutti i campi obbligatoria", "Errore", JOptionPane.ERROR_MESSAGE);

        }

        if (dataNascitaLocal.isAfter(LocalDate.now())) {
            JOptionPane.showMessageDialog(null, "La data di nascita non può essere nel futuro", "Errore", JOptionPane.ERROR_MESSAGE);
        }
        else {
            cliente = new Cliente(UUID.randomUUID(),password,nome,cognome,luogoNascita,sesso,dataNascitaLocal,cellulare,indirizzo,0, email);

               if (userRegistrationFacade.registraCliente(cliente)){
                   JOptionPane.showMessageDialog(null,"Cliente registrato correttamente", "Info", JOptionPane.INFORMATION_MESSAGE);
               }
        }


       /**
        * Passaggio dell'oggetto a una facade
        **/

    }
    private void registraDipendente(){

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

    }



    private void addRegistrationListener(){
        frameCustomerReg.getCustomerRegistrationPanel().getBtnRegister().addActionListener(e -> {

            if(frameCustomerReg.getCustomerRegistrationPanel().getBtnRegister().getActionCommand().equals("register")){
                registraCliente();
            }


        });

    }


}
