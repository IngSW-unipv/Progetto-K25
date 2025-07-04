package it.unipv.ingsfw.treninordovest.service;

import it.unipv.ingsfw.treninordovest.model.service.AcquistoService;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import org.junit.jupiter.api.Test;

public class AcquistoServiceTest {


    @Test
    void AcquistoAbbonamentoTest() {

        AcquistoService service = new AcquistoService();
        String tipoAbb="annuale";
        String tipoPag="cartacredito";
        String idCliente="32e4e573-8a97-4dc2-a9bd-71c770f59360";
        String idCliente2="d7b414df-9012-45b5-a0b8-792bd1a59c80";
        int quantita=3;

        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();

        Cliente cliente= clienteDAO.get(new Cliente (idCliente2));

        SessionManager.getInstance().setCurrentUser(cliente);


        if (service.acquistoAbbonamento(tipoAbb,tipoPag,quantita)){
            System.out.println("Acquisto Abbonamento completato");
        } else {
            System.out.println("Errore acquisto abbonamento");
        }

    }
}
