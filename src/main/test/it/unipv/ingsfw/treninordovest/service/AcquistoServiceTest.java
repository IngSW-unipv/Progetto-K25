package it.unipv.ingsfw.treninordovest.service;

import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import org.junit.jupiter.api.Test;

public class AcquistoServiceTest {


    @Test
    void AcquistoAbbonamentoTest() {

        AcquistoService service = new AcquistoService();
        String tipoAbb="settimanale";
        String tipoPag="cartacredito";
        int quantita=5;

        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();

        Cliente cliente= clienteDAO.get(new Cliente ("32e4e573-8a97-4dc2-a9bd-71c770f59360"));

        SessionManager.getInstance().setCurrentUser(cliente);


        if (service.acquistoAbbonamento(tipoAbb,tipoPag,quantita)){
            System.out.println("Acquisto Abbonamento completato");
        } else {
            System.out.println("Errore acquisto abbonamento");
        }

    }
}
