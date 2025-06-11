package it.unipv.ingsfw.treninordovest.controller;

import com.mysql.cj.log.Log;
import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.view.frames.customer.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.customer.JCustomerRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JLoginFrame;
import it.unipv.ingsfw.treninordovest.view.panels.finance.SubscriptionPanel;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.LoginPanel;
import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;

import java.sql.Date;
import java.time.LocalDate;

public class GestioneUtenzaController {
    private CustomerRegistrationPanel viewcustomerRegistrationPanel;
    private LoginPanel viewLoginPanel;
    private JCustomerMainFrame frameCustomer;
    private JLoginFrame frameLogin;


    public GestioneUtenzaController(CustomerRegistrationPanel view, JCustomerMainFrame frame) {
        this.viewcustomerRegistrationPanel = view;
        this.frameCustomer = frame;
    }

    public GestioneUtenzaController(LoginPanel view, JLoginFrame frame) {
        this.viewLoginPanel = view;
        this.frameLogin = frame;
    }



    private void registraCliente(){

        String nome = this.viewcustomerRegistrationPanel.getTxtNome().getText();
        String cognome = this.viewcustomerRegistrationPanel.getTxtNome().getText();
        String sesso = this.viewcustomerRegistrationPanel.getComboSesso();
        Date dataNascita  = (Date) this.viewcustomerRegistrationPanel.getDataNascita().getDate();
        LocalDate dataNascitaLocal= dataNascita.toLocalDate();
       String cellulare = this.viewcustomerRegistrationPanel.getTxtCellulare().getText();
       String email = this.viewcustomerRegistrationPanel.getTxtEmail().getText();
       String password = this.viewcustomerRegistrationPanel.getTxtPassword().getText();
       String indirizzo = this.viewcustomerRegistrationPanel.getTxtIndirizzo().getText();


       /**
        * Passaggio dell'oggetto a una facade
        **/





    }
    private void registraDipendente(){}
    private void login(){}
    private  void logout(){}
    private void modificaDatiCliente(){}
    private void modificaDatiDipendente(){}
    private void aggiornaDatiProfilo(){}


    public static void main(){
        JCustomerRegFrame frame = new JCustomerRegFrame();
       frame.setVisible(true);
    }


}
