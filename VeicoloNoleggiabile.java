/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A4R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Phoenix
 */
public class VeicoloNoleggiabile extends VeicoloPersonalizzato {

    public VeicoloNoleggiabile(int codice, Concessionario concessionario, int prezzoBase, String produttore, String modello, int cilindrata, String tipoVeicolo, HashMap<String, DescrizioneOptional> mappaDO, ArrayList<Foto> listaFoto, int prezzoGiornaliero) {
        super(codice, concessionario, prezzoBase, produttore, modello, cilindrata, tipoVeicolo, mappaDO, listaFoto);
        this.C = concessionario;
        this.prezzoGiornaliero = prezzoGiornaliero;
    }

    private int prezzoGiornaliero;
    private Concessionario C;
    private Noleggio noleggio = null;
    private boolean inNoleggio = false;

    public String recuperaLuogo() {
        return C.getLuogo();
    }

    //Getter/Setter
    public int getPrezzoGiornaliero() {
        return prezzoGiornaliero;
    }

    public void setPrezzoGiornaliero(int prezzoGiornaliero) {
        this.prezzoGiornaliero = prezzoGiornaliero;
    }

    public Noleggio getNoleggio() {
        return noleggio;
    }

    public void setNoleggio(Noleggio noleggio) {
        this.noleggio = noleggio;
    }

    public boolean getInNoleggio() {
        return inNoleggio;
    }
}
