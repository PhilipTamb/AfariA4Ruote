/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A4R;

import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author Phoenix
 */
public class VeicoloPersonalizzato extends Veicolo {

    public VeicoloPersonalizzato(int codice, Concessionario concessionario, int prezzoBase, String produttore, String modello, int cilindrata, String tipoVeicolo, HashMap<String, DescrizioneOptional> mappaDO, ArrayList<Foto> listaFoto) {
        super(codice, concessionario, prezzoBase, produttore, modello, cilindrata, tipoVeicolo);
        this.mappaDO = mappaDO;
        this.listaFoto = listaFoto;
        this.C = concessionario;
        listaOptional = new ArrayList<Optional>();
    }

    private Optional optional;
    private ArrayList<Optional> listaOptional;
    private Concessionario C;
    private DescrizioneOptional descrizioneOptional;
    protected int prezzoOptional = 0;

    // Stampa elenco degli optional
    public void mostraDescrizioniOptional() {
        boolean found = false;
        for (String nome : mappaDO.keySet()) {
            System.out.println("Codice: " + nome);
            found = true;
        }
        if(found == false)
            System.out.println("Nessun optional trovato.");
    }

    public void aggiungiOptional(String nomeOptional) {
        try {
            descrizioneOptional = mappaDO.get(nomeOptional);
            System.out.println("Optional scelto: " + descrizioneOptional.getNome());
            optional = new Optional(descrizioneOptional);
            listaOptional.add(optional);
            // Prezzo totale + prezzo dell'optional appena aggiunto
            setPrezzoOptional(prezzoOptional + descrizioneOptional.getPrezzo());
        } catch (NullPointerException e) {
            System.err.println("NOME NON VALIDO. Ritorno al menu' in corso...");
        }
    }

    public int recuperaScontoConcessionario() {
        return concessionario.getScontoConcessionario();
    }

    public VeicoloNoleggiabile creaVeicoloNoleggiabile(){
        if(mappaDO != null && listaFoto != null){
            return new VeicoloNoleggiabile(codice, concessionario, prezzoBase, produttore, modello, cilindrata, tipoVeicolo, mappaDO, listaFoto, 0);
        }
        System.err.println("INFORMAZIONI NON VALIDE");
        return null;
    }


// Getter/Setter
    public int getPrezzoOptional() {
        return prezzoOptional;
    }

    public void setPrezzoOptional(int prezzoOptional) {
        this.prezzoOptional = prezzoOptional;
    }

    public DescrizioneOptional getDescrizioneOptional() {
        return descrizioneOptional;
    }

    public void setDescrizioneOptional(DescrizioneOptional descrizioneOptional) {
        this.descrizioneOptional = descrizioneOptional;
    }

    public Optional getOptional() {
        return optional;
    }

    public void setOptional(Optional optional) {
        this.optional = optional;
    }

    public ArrayList<Optional> getListaOptional() {
        return listaOptional;
    }

    public void setListaOptional(ArrayList<Optional> listaOptional) {
        this.listaOptional = listaOptional;
    }

    public Concessionario getC() {
        return C;
    }

    public void setC(Concessionario C) {
        this.C = C;
    }
}
