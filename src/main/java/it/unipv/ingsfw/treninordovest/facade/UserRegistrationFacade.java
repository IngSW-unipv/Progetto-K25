package it.unipv.ingsfw.treninordovest.facade;

import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.DipendenteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.ferrovia.TrenoDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.interfaces.ClienteDAO;
import it.unipv.ingsfw.treninordovest.dao.interfaces.DipendenteDAO;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.utils.PasswordUtils;
import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;
import it.unipv.ingsfw.treninordovest.view.panels.users.EmployeeRegistrationPanel;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRegistrationFacade implements IUserRegistrationFacade {
    
    private static final Logger LOGGER = Logger.getLogger(UserRegistrationFacade.class.getName());
    
    private final ClienteDAO clienteDAO;
    private final DipendenteDAO dipendenteDAO;
    private final TrenoDAOImpl trenoDAO;
    
    public UserRegistrationFacade() {
        this.clienteDAO = new ClienteDAOImpl();
        this.dipendenteDAO = new DipendenteDAOImpl();
        this.trenoDAO = new TrenoDAOImpl();
    }
    
    // Costruttore per iniezione dipendenze nei test
    public UserRegistrationFacade(ClienteDAO clienteDAO, DipendenteDAO dipendenteDAO, TrenoDAOImpl trenoDAO) {
        this.clienteDAO = clienteDAO;
        this.dipendenteDAO = dipendenteDAO;
        this.trenoDAO = trenoDAO;
    }
    
    @Override
    public String registraCliente(CustomerRegistrationPanel view, JComponent componenteParent) {
        try {
            // Genera ID per il cliente
            GeneraID idGen = new GeneraID("CL");
            String id = idGen.getID();
            
            // Raccogli i dati dal form
            String password = view.getTxtPassword().getText();
            String nome = view.getTxtNome().getText();
            String cognome = view.getTxtCognome().getText();
            String email = view.getTxtEmail().getText();
            String sesso = view.getComboSesso();
            String luogoNascita = view.getTxtLuogoNascita().getText();
            Date dataNascita = view.getDataNascita().getDate();
            String cellulare = view.getTxtCellulare().getText();
            String indirizzo = view.getTxtIndirizzo().getText();
            
            // Validazione dei dati
            if (password.isEmpty() || nome.isEmpty() || cognome.isEmpty() || 
                email.isEmpty() || sesso.isEmpty() || luogoNascita.isEmpty() || 
                cellulare.isEmpty() || indirizzo.isEmpty() || dataNascita == null) {
                
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
            


            // Creazione cliente
            Cliente clienteInserito = new Cliente(id, password, nome, cognome, luogoNascita, sesso, dataNascitaLocal, cellulare, indirizzo, 0, email);
            
            // Inserimento nel DB
            clienteDAO.insert(clienteInserito);
            
            // Messaggio di successo
            JOptionPane.showMessageDialog(componenteParent,
                    "Registrazione avvenuta con successo!!\nSalvati il tuo ID cliente: " + id);
            
            return id;
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Errore durante la registrazione del cliente", e);
            JOptionPane.showMessageDialog(componenteParent, 
                    "Errore durante la registrazione: " + e.getMessage(), 
                    "Errore", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String registraDipendente(EmployeeRegistrationPanel view, JComponent componenteParent) {
        // Implementazione per registrare un dipendente
        // (da implementare con una logica simile a registraCliente)
        return null;
    }
}