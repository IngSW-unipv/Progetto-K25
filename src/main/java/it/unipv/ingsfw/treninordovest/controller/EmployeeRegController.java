package it.unipv.ingsfw.treninordovest.controller;


import it.unipv.ingsfw.treninordovest.dao.implementations.ferrovia.TrenoDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.DipendenteDAOImpl;
import it.unipv.ingsfw.treninordovest.main.Main;
import it.unipv.ingsfw.treninordovest.model.ferrovia.Treno;
import it.unipv.ingsfw.treninordovest.model.utenti.Dipendente;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JEmployeeRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.panels.users.EmployeeRegistrationPanel;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class EmployeeRegController {

    private EmployeeRegistrationPanel view;
    private DipendenteDAOImpl dipendenteDAO;
    private JEmployeeRegFrame employeeRegFrame;

    public EmployeeRegController (EmployeeRegistrationPanel view, JEmployeeRegFrame employeeRegFrame) {
        this.view = view;
        this.employeeRegFrame = employeeRegFrame;
        initController();
    }

    private void initController() {
        view.getBtnRegister().addActionListener(e -> createEmployee());
        view.getBtnMenuPrincipal().addActionListener(e -> tornaAlMenuPrincipale());
    }
    private void createEmployee() {
        GeneraID idGen = new GeneraID("DP");
        String id = idGen.getID();
        String password = view.getTxtPassword().getText();  /*Appunto : Mettere la crittazione della password */
        String nome = view.getTxtNome().getText();
        String cognome = view.getTxtCognome().getText();
        String sesso = view.getComboSesso();
        String luogoNascita = view.getTxtLuogoNascita().getText();

        Date dataNascita = view.getDataNascita().getDate();
        LocalDate dataNascitaLocal =dataNascita.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String cellulare = view.getTxtCellulare().getText();
        String indirizzo = view.getTxtIndirizzo().getText();
        double stipendio = 0;
        String codTreno= randTreno();
        //String codTreno= "FS1127";
        String ruolo = view.getComboRuolo();


        try {
            if (password.isEmpty() || nome.isEmpty() || cognome.isEmpty()|| sesso.isEmpty() || luogoNascita.isEmpty() || cellulare.isEmpty() || indirizzo.isEmpty() || (dataNascitaLocal.isAfter(LocalDate.now()) || dataNascitaLocal==null)) {
                JOptionPane.showMessageDialog(view, "Compilazione di tutti i campi obbligatoria", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }catch (NullPointerException e) {
            e.printStackTrace();
            e.getMessage();
        }



        Dipendente dipendenteinserito = new Dipendente(id,password,nome,cognome,luogoNascita,sesso,dataNascitaLocal,cellulare,indirizzo,codTreno,stipendio,ruolo);
        dipendenteDAO = new DipendenteDAOImpl();
        try  {
            dipendenteDAO.insert(dipendenteinserito);
            JOptionPane.showMessageDialog(view,"Registrazione avvenuta con successo !!"+"\nSalvati il tuo ID dipendente:    "+id);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Errore riprovare...", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tornaAlMenuPrincipale(){
        JMainMenuFrame mainMenuFrame = new JMainMenuFrame();
        employeeRegFrame.setVisible(false);
        mainMenuFrame.setVisible(true);
    }

    private String randTreno(){
        String codTreno;
        TrenoDAOImpl trenoDAO = new TrenoDAOImpl();
        List<Treno> treni = new ArrayList<>();

        try {
            treni=trenoDAO.getAll();

            Random random = new Random();
            int indiceCasuale = random.nextInt(treni.size());
            codTreno=treni.get(indiceCasuale).getIdTreno();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return codTreno;
    }

}
