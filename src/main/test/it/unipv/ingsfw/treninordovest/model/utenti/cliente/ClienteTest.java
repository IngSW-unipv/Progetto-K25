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



        cliente.getWallet().preleva(pagamento.getTotale());

        System.out.println("Bilancio post pagamento:" + cliente.getWallet().getValue());




    }

    @Test
    void loginUser() {
        String email = "marto44@gmail.com";
        String password = "pinirossi";

//        Cliente cliente= new Cliente(email, password) ;

//        if(cliente.login(email, password)){
//            System.out.println("Login correto");
//        }


    }



}
