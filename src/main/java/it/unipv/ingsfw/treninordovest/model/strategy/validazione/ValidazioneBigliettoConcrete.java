package it.unipv.ingsfw.treninordovest.model.strategy.validazione;

import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.BigliettoDAO;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.titoli.titoloviaggio.TitoloViaggio;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.titolitable.TitoliViaggioTablePanel;

public class ValidazioneBigliettoConcrete implements IValidazioneTitoliStrategy{
    @Override
    public boolean getValidazione(String idTitolo) {
        BigliettoDAO bigliettoDAO = new BigliettoDAOImpl();
        Biglietto biglietto = bigliettoDAO.get(new Biglietto(idTitolo));

        if(biglietto!=null){

            if (biglietto.isValidato()){
                System.out.println("DEBUG: Strategia Validazione Biglietto ok");
                return biglietto.isValidato();
            }

        }

        return false;
    }

    @Override
    public void valida(String idTitolo) {
        BigliettoDAO bigliettoDAO = new BigliettoDAOImpl();
        bigliettoDAO.update(new Biglietto(idTitolo));

    }
}
