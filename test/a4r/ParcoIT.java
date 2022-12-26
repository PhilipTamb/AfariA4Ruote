/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4r;

import A4R.Concessionario;
import A4R.DescrizioneOptional;
import A4R.Foto;
import A4R.Parco;
import A4R.Veicolo;
import A4R.VeicoloNoleggiabile;
import A4R.VeicoloPersonalizzato;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

//import static org.junit.Assert.*;

/**
 *
 * @author phili
 */
public class ParcoIT {
    
    public ParcoIT() {
    }

    /**
     * Test of filtraVeicoliAcquisto method, of class Parco.
     * 
     */

    
    @Test 
    @DisplayName("Test di caricamento del veicolo")
    public void testCaricaMezzo() {
        System.out.println("-------------- testCaricaMezzo ----------------");
        Parco P = Parco.getInstance();
        
        int sizeIniziale =  P.getMappaVeicoli().size();
        
        Concessionario mucarauto = new Concessionario(1, "Mu.Car.Auto", "Aci San Filippo", 0);
        Concessionario virauto = new Concessionario(2, "Virauto", "Catania", 10);
        
        P.caricaMezzo(mucarauto, 1000, "FIAT", "Panda", 1000, "Automobile");
        P.caricaMezzo(virauto, 5000, "Audi", "A1", 1800, "Automobile");
        
        System.out.println("P.getMappaVeicoli()  " + P.getMappaVeicoli());

        //vengono inseriti 2 veicoli correttamente
        assertEquals(sizeIniziale+2, P.getMappaVeicoli().size());
        
        //Creo veicoli che dovrebbero essere impossibili da caricare per mancanza di paramentri
        P.caricaMezzo(null, 1000, "ModelX", "ModelX", 1300, "Automobile");
        P.caricaMezzo(virauto, 0, "ModelX", "ModelX", 1300, "Automobile");
        P.caricaMezzo(mucarauto, 1000, "", "ModelX", 1300, "Automobile");
        P.caricaMezzo(mucarauto, 1000, "ModelX", "", 1300, "Automobile");
        P.caricaMezzo(mucarauto, 1000, "ModelX", "ModelX", 0, "Automobile");
        P.caricaMezzo(mucarauto, 1000, "ModelX", "ModelX", 1300, "");
       
       assertEquals(sizeIniziale+2,P.getMappaVeicoli().size());
       
       System.out.println("\n");
    }
    
    
    
    @Test
    @DisplayName("Test per filtrare i veicoli - Acquisto")
    public void testFiltraVeicoliAcquisto() {
        System.out.println("------------------ testFiltraVeicoliAcquisto -----------------");
        Parco P = Parco.getInstance(); 

        //veicolo esistente -> stampa il veicolo
        P.filtraVeicoliAcquisto("FIAT", "Panda", "Automobile");
        
        //veicolo NON esistente -> non stampa niente
        P.filtraVeicoliAcquisto("Tesla", "ModelX", "Automobile");  
        
        System.out.println("\n");
    }
    
    @Test 
    @DisplayName("Test per concludere la personalizzazione di un veicolo")
    public void testTerminaPersonalizzazione() {
        System.out.println("------------- testTerminaPersonalizzazione ---------------");
        Parco P = Parco.getInstance();
        
        Concessionario C = new Concessionario(1, "VirAuto", "Catania", 0);
        Veicolo V1 = new Veicolo(1, C, 1000, "FIAT", "Panda", 1000, "Automobile"); 
        Veicolo V2 = new Veicolo(2, C, 4000, "Tesla", "ModelX", 2000, "Automobile"); 

         // Descrizioni optional
        DescrizioneOptional specchietti = new DescrizioneOptional("Specchietti", 20, "Rossi");
        DescrizioneOptional verniceGialla = new DescrizioneOptional("Vernice gialla", 50, "Giallo");
   
        //aggiunta Descrizioni Optional alla mappa DescrizioniOptional del veicolo
        V1.getMappaDO().put(specchietti.getNome(), specchietti);
        V1.getMappaDO().put(verniceGialla.getNome(), verniceGialla);
        V2.getMappaDO().put(verniceGialla.getNome(), verniceGialla);

        // Foto
        Foto f1 = new Foto("Avanti");
        Foto f2 = new Foto("Dietro");
        
        // Inserimento foto --> Veicoli
        V1.getListaFoto().add(f1);
        V1.getListaFoto().add(f2);
        V2.getListaFoto().add(f1);
        V2.getListaFoto().add(f2);

        VeicoloPersonalizzato VP1 = V1.creaVeicoloPersonalizzato();
        VeicoloPersonalizzato VP2 = V2.creaVeicoloPersonalizzato();
  
        //aggiungi optional 
        VP1.aggiungiOptional("Specchietti");
        VP1.aggiungiOptional("Vernice gialla");
        VP2.aggiungiOptional("Vernice gialla");
        
        P.terminaPersonalizzazione(VP1);
        
        //controllo gli optional
        assertEquals(2, VP1.getListaOptional().size());
        // controllo che nella mappa di Veicoli Personalizzati ci sia VP1
        assertEquals(VP1, P.getMappaVeicoliPersonalizzati().get(1));
        //controllo che la mappa di veicoli personalizzati abbia un solo elemento
        assertEquals(1, P.getMappaVeicoliPersonalizzati().size());
        
        
        P.terminaPersonalizzazione(VP2);
        //controllo che nella mappa ci siano 2 elementi
        assertEquals(2, P.getMappaVeicoliPersonalizzati().size());
        
        System.out.println("\n");
    }
    
    
    @Test
    @DisplayName("Test per filtrare la lista di veicoli - Noleggio")
    public void testFiltraVeicoliNoleggio() {
        System.out.println("------------------ testFiltraVeicoliNoleggio -----------------");
        Parco P = Parco.getInstance();
        
        
        Concessionario C = new Concessionario(1, "Mu.Car.Auto", "Aci San Filippo", 0); 
        P.caricaMezzo(C, 1000, "FIAT", "Panda", 1000, "Automobile");
        
        
        Veicolo V = P.getVeicolo();
        
        // Descrizioni optional
        DescrizioneOptional specchietti = new DescrizioneOptional("Specchietti", 20, "Rossi");
        DescrizioneOptional verniceGialla = new DescrizioneOptional("Vernice gialla", 50, "Giallo");
        
        //aggiunta Descrizioni Optional alla mappa DescrizioniOptional del veicolo
        V.getMappaDO().put(specchietti.getNome(), specchietti);
        V.getMappaDO().put(verniceGialla.getNome(), verniceGialla);
        
        // Foto
        Foto f1 = new Foto("Avanti");
        Foto f2 = new Foto("Dietro");
        
        // Inserimento foto --> Veicoli
        V.getListaFoto().add(f1);
        V.getListaFoto().add(f2);
        
        VeicoloPersonalizzato VP = V.creaVeicoloPersonalizzato(); 
        
        //aggiungi optional esistente
        VP.aggiungiOptional("Specchietti");
        VP.aggiungiOptional("Vernice gialla");
        
        VeicoloNoleggiabile VN = VP.creaVeicoloNoleggiabile();

        P.getMappaVeicoliNoleggiabili().put(VN.getCodice(),VN);

        //veicolo esistente -> lo mostra
        P.filtraVeicoliNoleggio("FIAT", "Panda", "Automobile");
        
        //veicolo NON esistente -> non mostra nulla
        P.filtraVeicoliNoleggio("Tesla", "ModelX", "Automobile");  
        
        System.out.println("\n");
    }  
}
