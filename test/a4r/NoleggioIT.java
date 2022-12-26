/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4r;

import A4R.Concessionario;
import A4R.MetodoPagamentoAdapter;
import A4R.Noleggio;
import A4R.Utente;
import A4R.Veicolo;
import A4R.VeicoloNoleggiabile;
import A4R.VeicoloPersonalizzato;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author phili
 */
public class NoleggioIT {
    
    public NoleggioIT() {
    }
    
    
    @Test
    @DisplayName("Test per calcolare il costo finale - Noleggio")
    public void testCalcoloTotaleNoleggio(){    
        System.out.println("------------------ testCostoFinale ------------------");
        Utente U = new Utente(1, "Riccardo", "Castorina", "Via Zafferana Milo", 0, false);
        Concessionario C = new Concessionario(1, "VirAuto", "Catania", 0);
        Veicolo V = new Veicolo(1, C, 1000, "FIAT", "Panda", 1000, "Automobile"); 
        VeicoloNoleggiabile VN = new VeicoloNoleggiabile(4, C, 1700, "FIAT", "Panda", 1200, "Autoveicolo", V.getMappaDO(), V.getListaFoto(), 100);
        Noleggio N = new Noleggio(U, VN, "Catania" );
        System.out.println(N);
        MetodoPagamentoAdapter MP = new  MetodoPagamentoAdapter("payPal",1,10);

        N.setDurataNoleggio(60);
        N.setConcessionario(VN.getConcessionario());
        N.impostaOrdine(MP); 

        //Controllo calcolo totale del noleggio
        float prezzo = ((100 * 60) + ((1700 * 22) / 100) + 3 + 10 - ((1700 * 0) / 100) - ((1700 * 0) / 100) - ((1700 * 0) / 100));
        //controllo del prezzo finale
        assertEquals(prezzo,N.getPrezzoFinale(), 0.1);
        
        //Calcolo nullo se è assente il prezzo del veicolo
        Veicolo V1 = new Veicolo(1, C, 0, "FIAT", "Panda", 1000, "Automobile");
        VeicoloNoleggiabile VN1 = new VeicoloNoleggiabile(V1.getCodice(), V1.getConcessionario(), V1.getPrezzoBase(), V1.getProduttore(), V1.getModello(), V1.getCilindrata(), V1.getTipoVeicolo(), V1.getMappaDO(), V1.getListaFoto(), 100);
        N.setVeicoloNoleggiabile(VN1);
        float totale1 = N.calcoloTotaleNoleggio(VN1.getPrezzoGiornaliero(), N.getDurataNoleggio(), N.getIva(), N.getCommissioneA4R(), N.getCommissionePagamento(), N.getScontoPremium(), N.getScontoA4R(), N.getScontoConcessionario());
        assertEquals(0,totale1, 0.1);
    }
}
