/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4r;

import A4R.Acquisto;
import A4R.Concessionario;
import A4R.MetodoPagamentoAdapter;
import A4R.Utente;
import A4R.Veicolo;
import A4R.VeicoloPersonalizzato;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author phili
 */
public class AcquistoIT {
    
    public AcquistoIT() {
    }
    
    
    @Test
    @DisplayName("Test per scegliere il luogo di ritiro dell'acquisto")
    public void testScegliLuogoRitiro(){
        System.out.println("------------------ testScegliLuogoRitiro ------------------");
        Utente U = new Utente(1, "Riccardo", "Castorina", "Via Zafferana Milo", 0, false);
        Concessionario C = new Concessionario(1, "VirAuto", "Catania", 0);
        Veicolo V = new Veicolo(1, C, 1000, "FIAT", "Panda", 1000, "Automobile"); 
        VeicoloPersonalizzato VP = new VeicoloPersonalizzato(4, C, 1700, "FIAT", "Panda", 1200, "Autoveicolo", V.getMappaDO(), V.getListaFoto());

        
        //scegli luogo esistente
        Acquisto A = new Acquisto(U, VP);
        A.scegliLuogoRitiro("Catania");
        assertEquals(0,A.getTasseDogane(), 0.1);
        assertEquals(0,A.getCostoSpedizione(), 0.1);

      
        //scegli luogo esistente
        Acquisto A1 = new Acquisto(U, VP);
        A1.scegliLuogoRitiro("London");
        assertEquals(150,A1.getTasseDogane(), 0.1);
        assertEquals(500,A1.getCostoSpedizione(), 0.1);
        
        //scegli luogo NON esistente
        Acquisto A2 = new Acquisto(U, VP);
        A2.scegliLuogoRitiro("Roma");
        assertEquals(30,A2.getTasseDogane(), 0.1);
        assertEquals(50,A2.getCostoSpedizione(), 0.1);
        
        //Nome del luogo vuoto -> ""; Istruzione non valida
        Acquisto A3 = new Acquisto(U, VP);
        A3.scegliLuogoRitiro("");
        assertEquals(0, A3.getTasseDogane(), 0.1);
        assertEquals(0, A3.getCostoSpedizione(), 0.1);
    }
    
    
    @Test
    @DisplayName("Test per calcolare il prezzo finale - Acqusito")
    public void testCalcoloTotaleAcquisto(){    
        System.out.println("------------------ testCostoFinale ------------------");
        Utente U = new Utente(1, "Riccardo", "Castorina", "Via Zafferana Milo", 0, false);
        Concessionario C = new Concessionario(1, "VirAuto", "Catania", 0);
        Veicolo V = new Veicolo(1, C, 1000, "FIAT", "Panda", 1000, "Automobile"); 
        VeicoloPersonalizzato VP = new VeicoloPersonalizzato(4, C, 1700, "FIAT", "Panda", 1200, "Autoveicolo", V.getMappaDO(), V.getListaFoto());
        Acquisto A = new Acquisto(U, VP);
        MetodoPagamentoAdapter MP = new  MetodoPagamentoAdapter("payPal",1,10);
        
        A.impostaOrdine(MP); 
        A.aggiornaTasseDogane(C.getLuogo());

        //Controllo calcolo totale dell'acquisto
        float prezzo = 1700 + ((1700*22)/100) + 0 + 3 + 10 + 0 - ((1700*0)/100) - ((1700*0)/100) - ((1700*0)/100);
        float totale = A.calcoloTotaleAcquisto(A.getPrezzoBase(), A.getIva(), A.getTasseDogane(), A.getCommissioneA4R(), A.getCommissionePagamento(), A.getCostoSpedizione(), A.getScontoPremium(), A.getScontoA4R(), A.getScontoConcessionario(), A.getPrezzoOptional());
        assertEquals(prezzo,totale, 0.1);
        
        //Calcolo nullo se è assente il prezzo del veicolo
        Veicolo V1 = new Veicolo(1, C, 0, "FIAT", "Panda", 1000, "Automobile"); 
        A.setPrezzoBase(V1.getPrezzoBase());
        float totale1 = A.calcoloTotaleAcquisto(A.getPrezzoBase(), A.getIva(), A.getTasseDogane(), A.getCommissioneA4R(), A.getCommissionePagamento(), A.getCostoSpedizione(), A.getScontoPremium(), A.getScontoA4R(), A.getScontoConcessionario(), A.getPrezzoOptional());
        assertEquals(0,totale1, 0.1);
    } 
}
