package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.dao.implementations.ferrovia.TrattaDAOImpl;
import it.unipv.ingsfw.treninordovest.model.ferrovia.Tratta;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.panels.finance.TicketPurchasePanel;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.TratteTablePanel;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTicketController {

    private TratteTablePanel tratteTablePanel;
    private JCustomerMainFrame customerMainFrame;
    private TicketPurchasePanel ticketPurchasePanel;
    private TrattaDAOImpl trattaDAO;

    public CustomerTicketController(JCustomerMainFrame frame, TratteTablePanel tratteTablePanel,TicketPurchasePanel ticketPurchasePanel) {
        this.customerMainFrame = frame;
        this.tratteTablePanel = tratteTablePanel;
        this.ticketPurchasePanel = ticketPurchasePanel;

    }

    private void initController() {

        //ticketPurchasePanel.getButtonMostraTratte().addActionListener(e -> {})

    }

    public List<Tratta> getTratte() throws SQLException {
        trattaDAO = new TrattaDAOImpl();
        List<Tratta> tratte;
        try {
           tratte = trattaDAO.getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return tratte;
    }



}
