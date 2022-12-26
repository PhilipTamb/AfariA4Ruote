/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4r;

import A4R.Concessionario;
import A4R.Foto;
import A4R.Veicolo;
import A4R.VeicoloPersonalizzato;
import A4R.DescrizioneOptional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author phili
 */
public class VeicoloPersonalizzatoIT {
    
    public VeicoloPersonalizzatoIT() {
    }

    /**
     * Test of aggiungiOptional method, of class VeicoloPersonalizzato.
     */
    
    
    @Test
    @DisplayName("Test per aggiungere optional in un veicolo personalizzato")
    public void testAggiungiOptional() {
        System.out.println("testAggiungiOptional");
        Concessionario C = new Concessionario(1, "VirAuto", "Catania", 0);
        Veicolo V = new Veicolo(1, C, 1000, "FIAT", "Panda", 1000, "Automobile"); 
        
         // Descrizioni optional
        DescrizioneOptional specchietti = new DescrizioneOptional("Specchietti", 20, "Rossi");
        DescrizioneOptional verniceGialla = new DescrizioneOptional("Vernice gialla", 50, "Giallo");
        DescrizioneOptional marmittaNuova = new DescrizioneOptional("Marmitta nuova", 100, "Nero");
        DescrizioneOptional vetriOscurati = new DescrizioneOptional("Vetri oscurati", 150, "Nero");
        DescrizioneOptional alettone = new DescrizioneOptional("Alettone", 1000, "Nero");
        
        //aggiunta Descrizioni Optional alla mappa DescrizioniOptional del veicolo
        V.getMappaDO().put(specchietti.getNome(), specchietti);
        V.getMappaDO().put(verniceGialla.getNome(), verniceGialla);
        V.getMappaDO().put(marmittaNuova.getNome(), marmittaNuova);
        V.getMappaDO().put(vetriOscurati.getNome(), vetriOscurati);
        V.getMappaDO().put(alettone.getNome(), alettone);
        
        // Foto
        Foto f1 = new Foto("Avanti");
        Foto f2 = new Foto("Dietro");
        Foto f3 = new Foto("Sinistra");
        Foto f4 = new Foto("Destra");
        
        // Inserimento foto --> Veicoli
        V.getListaFoto().add(f1);
        V.getListaFoto().add(f2);
        V.getListaFoto().add(f3);
        V.getListaFoto().add(f4);
        
        VeicoloPersonalizzato VP = V.creaVeicoloPersonalizzato(); 
       
        //aggiungi optional esistente
        VP.aggiungiOptional("Specchietti");
        assertEquals(1, VP.getListaOptional().size());
        
        //Aggiungi optional con nome sbagiato
        VP.aggiungiOptional("Specchiet");
        assertEquals(1, VP.getListaOptional().size());
        
        //Aggiungi optional non esistente
        VP.aggiungiOptional("Abbaglianti");
        assertEquals(1, VP.getListaOptional().size());
        
        //Aggiungi optional passando un null
        VP.aggiungiOptional(null);
        assertEquals(1, VP.getListaOptional().size());
        
        //Aggiungi optional passando un null
        VP.aggiungiOptional(" ");
        assertEquals(1, VP.getListaOptional().size());
    }
}
