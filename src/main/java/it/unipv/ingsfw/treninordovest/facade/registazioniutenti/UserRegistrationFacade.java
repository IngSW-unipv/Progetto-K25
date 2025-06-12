package it.unipv.ingsfw.treninordovest.facade.registazioniutenti;


import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.model.ferrovia.treno.Treno;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.DipendenteDAOImpl;
import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;
import it.unipv.ingsfw.treninordovest.view.panels.users.EmployeeRegistrationPanel;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;


import javax.swing.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

public class UserRegistrationFacade implements IUserRegistrationFacade {


    private ClienteDAOImpl clienteDAO;
    private DipendenteDAOImpl dipendenteDAO;

    /**
     * Costruttore privato per implementare il Singleton
     */
    public UserRegistrationFacade() {
        clienteDAO = new ClienteDAOImpl();
        dipendenteDAO = new DipendenteDAOImpl();
    }

    @Override
    public boolean registraCliente(Cliente cliente) {

        try {

            clienteDAO.insert(cliente);

            return true;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean registraDipendente(Dipendente dipendente) {
        /*
        try {

            // Raccogli i dati dal form
            String password = view.getTxtPassword().getText();
            String nome = view.getTxtNome().getText();
            String cognome = view.getTxtCognome().getText();
            String sesso = view.getComboSesso();
            String luogoNascita = view.getTxtLuogoNascita().getText();
            Date dataNascita = view.getDataNascita().getDate();
            String cellulare = view.getTxtCellulare().getText();
            String indirizzo = view.getTxtIndirizzo().getText();
            String ruolo = view.getComboRuolo();

            // Calcola lo stipendio in base al ruolo
            double stipendio = StipendioStrategyFactory.getStrategy(ruolo).calcolaStipendio();

            // Assegna un treno casuale al dipendente
            String codTreno = getRandomTreno();

            // Validazione dei dati
            if (password.isEmpty() || nome.isEmpty() || cognome.isEmpty() ||
                sesso.isEmpty() || luogoNascita.isEmpty() || cellulare.isEmpty() ||
                indirizzo.isEmpty() || dataNascita == null) {

                JOptionPane.showMessageDialog(componenteParent,
                        "Compilazione di tutti i campi obbligatoria",
                        "Errore", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            // Converti la data
            LocalDate dataNascitaLocal = dataNascita.toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();

            // Verifica data di nascita valida
            if (dataNascitaLocal.isAfter(LocalDate.now())) {
                JOptionPane.showMessageDialog(componenteParent,
                        "La data di nascita non può essere nel futuro",
                        "Errore", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            // Creazione dipendente
            Dipendente dipendenteInserito = new Dipendente(id, password, nome, cognome, luogoNascita, sesso, dataNascitaLocal, cellulare, indirizzo, codTreno, stipendio, ruolo);

            // Inserimento nel DB
            dipendenteDAO.insert(dipendenteInserito);

            // Messaggio di successo
            JOptionPane.showMessageDialog(componenteParent,
                    "Registrazione avvenuta con successo!!\nSalvati il tuo ID dipendente: " + id,
                    "Successo", JOptionPane.INFORMATION_MESSAGE);

            LOGGER.info("Dipendente registrato con successo: " + id);
            return id;

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Errore durante la registrazione del dipendente", e);
            JOptionPane.showMessageDialog(componenteParent,
                    "Errore durante la registrazione: " + e.getMessage(),
                    "Errore", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }*/return false;
    }

    /**
     * Restituisce l'ID di un treno casuale dal database
     *
     * @return ID del treno selezionato casualmente
     */
   /* private String getRandomTreno() {
        try {
            List<Treno> treni = trenoDAO.getAll();
            if (treni.isEmpty()) {
                LOGGER.warning("Nessun treno trovato nel database");
                return "";
            }

            Random random = new Random();
            int indiceCasuale = random.nextInt(treni.size());
            return treni.get(indiceCasuale).getIdTreno();

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Errore durante il recupero dei treni", e);
            return "";
        }
    }*/
}