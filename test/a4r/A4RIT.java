/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4r;

import A4R.Parco;
import A4R.A4R;
import A4R.Acquisto;
import A4R.Noleggio;
import A4R.VeicoloNoleggiabile;
import A4R.VeicoloPersonalizzato;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author phili
 */
public class A4RIT {
    
    public A4RIT() {
        A4R a4r = A4R.getInstance();
        Parco p = Parco.getInstance();
        a4r.startup(p);
    }

    
    
    @BeforeAll
    public static void beforeEachTest(){
        //con startup vengono creati 10 veicoli base 
        //A4R a4r = A4R.getInstance();
        //Parco p = Parco.getInstance();
        //a4r.startup(p);
    }
    
    
    @Test
    @DisplayName("Test su scegli veicolo - Acquisto")
    public void testScegliVeicoloAcquisto() {
        A4R a4r = A4R.getInstance();
        Parco p = Parco.getInstance();
        System.out.println("------------------ testScegliVeicoloAcquisto ------------------");
        
        System.out.println("mappa veicoli --->" + p.getMappaVeicoli() );

       //scegli Veicolo per l'acquisto con il codice corretto (da 1 a 26)
        VeicoloPersonalizzato VP1 = a4r.scegliVeicoloAcquisto(1);
        assertNotNull(VP1);
        
        //scegli Veicolo per l'acquisto con il codice uguale a 13 
        VeicoloPersonalizzato VP13 = a4r.scegliVeicoloAcquisto(13);
        assertNotNull(VP13);
        
        //scegli Veicolo per l'acquisto con il codice uguale a 14 
        VeicoloPersonalizzato VP14 = a4r.scegliVeicoloAcquisto(14);
        assertNull(VP14);
        
        //scegli Veicolo per l'acquisto con il codice uguale a 0, NON corretto 
        VeicoloPersonalizzato VP1000 = a4r.scegliVeicoloAcquisto(0);
        assertNull(VP1000);
        
        //scegli Veicolo per l'acquisto con il codice uguale a -1, NON corretto 
        VeicoloPersonalizzato VPnegativo = a4r.scegliVeicoloAcquisto(-1);
        assertNull(VPnegativo);
        System.out.println("\n");
    }
    
    @Test
    @DisplayName("Test su scegli pagamento")
    public void testScegliPagamento() {
        A4R a4r = A4R.getInstance();
       // Parco p = Parco.getInstance();
        System.out.println("------------------ testScegliPagamento ------------------");

        a4r.scegliVeicoloAcquisto(1);
        
        //passo un metodo di pagamento corretto
        a4r.scegliPagamento(1);
        
        //se metodoPagamentto con codice 1 è uguale al MetodoPagamentoAdapter attuale allora è stato impostato correttamente
        assertEquals(a4r.getMappaMetodoPagamento().get(1),a4r.getMetodoPagamentoAdapter());
        
        //Passo un metodo pagamento NON corretto
        a4r.scegliPagamento(-1);
        assertNull(a4r.getMetodoPagamentoAdapter());
       
        //Passo un metodo pagamento NON corretto
        a4r.scegliPagamento(0);
        assertNull(a4r.getMetodoPagamentoAdapter());

        System.out.println("\n");
    }
    
    
    
    @Test
    @DisplayName("Test su effettua pagamento - Acquisto")
    public void testEffettuaPagamentoAcquisto() {
        A4R a4r = A4R.getInstance();
      //  Parco p = Parco.getInstance();
        System.out.println("------------------ testEffettuaPagamentoAcquisto ------------------");
        a4r.scegliVeicoloAcquisto(1);
        a4r.scegliPagamento(1);
        
        int ordiniIniziali = a4r.getOrdiniErogati().size();
       
     //    System.out.println("mappa veicoli --->" + p.getMappaVeicoli() );
        
        //effettuo un acquisto con un prezzo lecito
        a4r.effettuaPagamentoAcquisto(a4r.getPrezzoFinale());
        Acquisto acquisto = a4r.getRicevutaAcquisto();

        //controllo che l'ordine sisa stato aggiunto alla lista degli ordine erogati
        assertEquals(ordiniIniziali + 1, a4r.getOrdiniErogati().size());
        //controllo che l'acquisto che ho pagato è quello inserito per ultimo nella lista
        assertEquals(acquisto, a4r.getOrdiniErogati().get(ordiniIniziali));
        
        //cerco di pagare un acquisto uguale a 0
        a4r.effettuaPagamentoAcquisto(0);
        assertEquals(ordiniIniziali + 1, a4r.getOrdiniErogati().size());
        
        //cerco di pagare un acquisto uguale a -1
        a4r.effettuaPagamentoAcquisto(-1);
        assertEquals(ordiniIniziali + 1, a4r.getOrdiniErogati().size());
        
       System.out.println("\n");
    }
    
    
    @Test
    @DisplayName("Test su scegli veicolo  - Noleggio")
    public void testScegliVeicoloNoleggio() {
        A4R a4r = A4R.getInstance();
        Parco p = Parco.getInstance();
        System.out.println("------------------ testScegliVeicoloNoleggio ------------------");
        
         System.out.println("mappa veicoli --->" + p.getMappaVeicoli() );
        
        System.out.println("VEICOLI NOLEGGIABILI:   --->" + p.getMappaVeicoliNoleggiabili());
        
       //scegli Veicolo per l'acquisto con il codice corretto (da 1 a 10)
        VeicoloPersonalizzato VP1 = a4r.scegliVeicoloNoleggio(1);
        assertNotNull(VP1);
        
        //scegli Veicolo per il noleggio con il codice corretto (da 1 a 6)
        VeicoloPersonalizzato VP6 = a4r.scegliVeicoloNoleggio(6);
        System.out.println( VP6);
        assertNotNull(VP6);
       
        //scegli Veicolo per il noleggio con il codice uguale a 7, NON corretto 
        VeicoloPersonalizzato VP7 = p.getMappaVeicoliNoleggiabili().get(7);
        assertNull(VP7);
     
        //scegli Veicolo per  il noleggio con il codice uguale a 0, NON corretto 
        VeicoloPersonalizzato VP1000 = p.getMappaVeicoliNoleggiabili().get(0);
        assertNull(VP1000);
        
        //scegli Veicolo per  il noleggio con il codice uguale a -1, NON corretto 
        VeicoloPersonalizzato VPnegativo = p.getMappaVeicoliNoleggiabili().get(-1);
        assertNull(VPnegativo);
        System.out.println("\n");
    }
    
    @Test
    @DisplayName("Test su effettua pagamento - Noleggio")
    public void testEffettuaPagamentoNoleggio() {
        A4R a4r = A4R.getInstance();
    //    Parco p = Parco.getInstance();
        System.out.println("------------------ testEffettuaPagamentoNoleggio ------------------");
        
        int ordiniIniziali = a4r.getOrdiniErogati().size();

        // VN.setPrezzoGiornaliero(100);
        // LocalDate dataInizio =  LocalDate.of(2023, 3, 12);
        // LocalDate dataFine =  LocalDate.of(2023, 4, 16);

        VeicoloNoleggiabile VN = a4r.scegliVeicoloNoleggio(1);
        System.out.println(VN);
         
        Noleggio N =  a4r.getRicevutaNoleggio();
        System.out.println(N);
 
        // N.calcolaDurata(dataInizio, dataFine);
        
        VN.setNoleggio(N);
        VN.getNoleggio().setDurataNoleggio(30);
       
        a4r.scegliPagamento(1);
        
        a4r.effettuaPagamentoNoleggio( VN.getNoleggio().getPrezzoFinale());
        
        Noleggio noleggio = a4r.getRicevutaNoleggio();
        System.out.println(noleggio);
        
        System.out.println(a4r.getOrdiniErogati());
       
        //controllo se sono presenti 2 noleggi
        assertEquals(ordiniIniziali + 1, a4r.getOrdiniErogati().size());
        //controllo se l'ultimo noleggio inserito è quello che ho appena pagato
        assertEquals(noleggio, a4r.getOrdiniErogati().get(ordiniIniziali));
        
        a4r.effettuaPagamentoNoleggio(0);
        
        //controllo se i noleggi  sono rimasti 3, e quindi l'ultimo (errato) non  è stato inserito
        assertEquals(ordiniIniziali + 1, a4r.getOrdiniErogati().size());
        
        a4r.effettuaPagamentoNoleggio(-1);
       
        //controllo se i noleggi  sono rimasti 2, e quindi l'ultimo (errato) non  è stato inserito
        assertEquals(ordiniIniziali + 1, a4r.getOrdiniErogati().size());
        System.out.println("\n");
    }
}
