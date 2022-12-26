/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4r;

import A4R.Concessionario;
import A4R.Veicolo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author phili
 */
public class VeicoloIT {
    
    public VeicoloIT() {
    }

    /**
     * Test of creaVeicoloPersonalizzato method, of class Veicolo.
     */
    
    @Test
    @DisplayName("Test per caricare le descrizioni degli optional")
    public void testCaricaDescrizioneOptional(){
       System.out.println("---------------- testCaricaDescrizioneOptional -----------------");
       Concessionario C = new Concessionario(1, "VirAuto", "Catania", 0);
       Veicolo V = new Veicolo(1, C, 1000, "FIAT", "Panda", 1000, "Automobile"); 
       
       //caricamento di una descrizione optional lecita
       V.caricaDescrizioneOptional("Aria Condizionata", 1000 , "nessuno");
       assertEquals(1, V.getMappaDO().size());
       
       //caricamento di una descrizione optional NON lecita
       V.caricaDescrizioneOptional("", 1000 , "nessuno");
       System.out.println(V.getMappaDO());
       assertEquals(1, V.getMappaDO().size());
       
       //caricamento di una descrizione optional NON lecita
       V.caricaDescrizioneOptional("Aria Condizionata", 1000 , "");
       assertEquals(1, V.getMappaDO().size());
    }
}
