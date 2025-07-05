package it.unipv.ingsfw.treninordovest.view.frames.mainmenu;

import it.unipv.ingsfw.treninordovest.model.service.RegistrationService;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.CustomerMainPanel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.dipendente.panels.EmployeeMainPanel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.login.LoginPanel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.CustomerRegistrationPanel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.dipendente.EmployeeRegistrationPanel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.menu.MainMenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class JTreniNordOvestFrame extends JFrame implements PropertyChangeListener {

    // Define constants for the panel names. This avoids typos.
    public static final String MAIN_MENU = "MAIN_MENU";
    public static final String CUSTOMER_REGISTRATION = "CUSTOMER_REGISTRATION";
    public static final String EMPLOYEE_REGISTRATION = "EMPLOYEE_REGISTRATION";
    public static final String LOGIN = "LOGIN";
    public static final String CUSTOMER_MAINFRAME = "Cliente";
    public static final String EMPLOYEE_MAINFRAME = "Dipendente";



    public static final int WIDHT=1280;
    public static final int HEIGHT=720;

    private final MainMenuPanel mainMenuPanel;
    private final CustomerRegistrationPanel customerRegistrationPanel;
    private final EmployeeRegistrationPanel employeeRegistrationPanel;
    private final LoginPanel loginPanel;
    private final CustomerMainPanel customerMainPanel;
    private final EmployeeMainPanel employeeMainPanel;

    private CardLayout cardLayout;
    private JPanel mainContainer;

    public JTreniNordOvestFrame() {
        this.mainMenuPanel = new MainMenuPanel();
        this.customerRegistrationPanel = new CustomerRegistrationPanel();
        this.employeeRegistrationPanel = new EmployeeRegistrationPanel();
        this.loginPanel = new LoginPanel();
        this.customerMainPanel = new CustomerMainPanel();
        this.employeeMainPanel = new EmployeeMainPanel();

        setTitle("Treninordovest - Benvenuti");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDHT, HEIGHT);
        setLocationRelativeTo(null);
        initComponents();
        initListeners();
        initController();

    }

    private void initComponents() {
        // 1. Create the CardLayout and the main container panel
        cardLayout = new CardLayout();
        mainContainer = new JPanel(cardLayout);

        // 2. Initialize all your panels
        // You'll need to pass 'this' or a controller to it

        // 3. Add each panel to the container with its unique name (key)
        mainContainer.add(mainMenuPanel, MAIN_MENU);
        mainContainer.add(customerRegistrationPanel, CUSTOMER_REGISTRATION);
        mainContainer.add(employeeRegistrationPanel, EMPLOYEE_REGISTRATION);
        mainContainer.add(loginPanel, LOGIN);
        mainContainer.add(customerMainPanel, CUSTOMER_MAINFRAME);
        mainContainer.add(employeeMainPanel, EMPLOYEE_MAINFRAME);

        // 4. Add the main container to the JFrame
        this.add(mainContainer);

        // 5. Show the main menu panel first
        cardLayout.show(mainContainer, MAIN_MENU);

    }

    private void initListeners(){
    }

    private void initController(){
        //new GestioneUtenzaController(this.mainMenuPanel,this);
        //new AcquistoController(this.customerMainPanel);
    }

    /**
     * Public method that allows other parts of your application (like controllers)
     * to switch the visible panel.
     * @param panelName The name of the panel to show (use the constants).
     */
    public void showPanel(String panelName) {
        cardLayout.show(mainContainer, panelName);
    }

    public CustomerRegistrationPanel getCustomerRegistrationPanel() {
        return customerRegistrationPanel;
    }

    public EmployeeRegistrationPanel getEmployeeRegistrationPanel() {
        return employeeRegistrationPanel;
    }

    public MainMenuPanel getMainMenuPanel() {
        return mainMenuPanel;
    }

   public LoginPanel getLoginPanel() {
        return loginPanel;
    }
    public CustomerMainPanel getCustomerMainPanel() {
        return customerMainPanel;
    }
    public EmployeeMainPanel getEmployeeMainPanel() {
        return employeeMainPanel;
    }


    public static void main(String[] args) {
        JTreniNordOvestFrame frame = new JTreniNordOvestFrame();
        frame.setVisible(true);
    }




    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (RegistrationService.ptNameLogin.equalsIgnoreCase(evt.getPropertyName())){
            System.out.println("Login avvenuto con successo");
        }
        if ("customer_registration".equalsIgnoreCase(evt.getPropertyName()) ){
            System.out.println("Registrazione Cliente avvenuta con successo");
        }
        if ("employee_registration".equalsIgnoreCase(evt.getPropertyName()) ){
            System.out.println("Registrazione Dipendente avvenuta con successo");
        }
        else System.out.println("Errore generico");
    }


}