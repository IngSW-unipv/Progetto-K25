package it.unipv.ingsfw.treninordovest.model.utenti.cliente;

import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

public class ClienteTest {

    @Test
    void createUserFromInterface() {

        Cliente cliente ;

        ClienteDAOImpl dao = new ClienteDAOImpl();

        cliente = new Cliente();

        cliente.setId(UUID.randomUUID());
        cliente.setNome("Mario");
        cliente.setCognome("Pini");
        cliente.setUserPassword("sadadsadt");
        cliente.setIndirizzo("wqqw");
        cliente.setCellulare("d32423424");
        cliente.setDataNascita(LocalDate.now());
        cliente.setSesso("T");
        cliente.setLuogoNascita("xyz");
        cliente.setBilancio(20000);
        cliente.setEmail("lfdm");



        //dao.insert(cliente);

        System.out.println(cliente.getBilancio());
        System.out.println(cliente.getWallet().getValue());

        Pagamento pagamento = new Pagamento();

        pagamento.setDataPagamento(LocalDate.now());
        pagamento.setIdPagamento(UUID.randomUUID().toString());
        pagamento.setTipo("Wallet");
        pagamento.setTotale(220);

        cliente.getWallet().preleva(pagamento.getTotale());

        System.out.println("Bilancio post pagamento:" + cliente.getWallet().getValue());



    }
}
