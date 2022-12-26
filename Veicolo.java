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

public class Veicolo {

    public Veicolo(int codice, Concessionario concessionario, int prezzoBase, String produttore, String modello, int cilindrata, String tipoVeicolo) {
        this.codice = codice;
        this.concessionario = concessionario;
        this.prezzoBase = prezzoBase;
        this.produttore = produttore;
        this.modello = modello;
        this.cilindrata = cilindrata;
        this.tipoVeicolo = tipoVeicolo;
        this.listaFoto = new ArrayList<>();
        mappaVeicoliPersonalizzati = new HashMap<>();
        mappaDO = new HashMap<>(); 
    }

    protected int codice;
    protected int prezzoBase;
    protected String produttore;
    protected String modello;
    protected int cilindrata;
    protected String tipoVeicolo;
    protected Noleggio noleggio;
    protected HashMap<Integer, VeicoloPersonalizzato> mappaVeicoliPersonalizzati;
    protected ArrayList<Foto> listaFoto;
    protected Concessionario concessionario;
    protected HashMap<String, DescrizioneOptional> mappaDO;
    private VeicoloPersonalizzato VP;
    private DescrizioneOptional descrizioneOptional;

    public VeicoloPersonalizzato creaVeicoloPersonalizzato() {
        if(mappaDO != null && listaFoto != null){
          return new VeicoloPersonalizzato(codice, concessionario, prezzoBase, produttore, modello, cilindrata, tipoVeicolo, mappaDO, listaFoto);
        }
        System.err.println("INFORMAZIONI NON VALIDE");
        return null;
    }

    public DescrizioneOptional caricaDescrizioneOptional(String nomeDO, int prezzoDO, String coloreDO){
        try {
            if(!nomeDO.equals("") && prezzoDO >= 0 && !coloreDO.equals("")){
                descrizioneOptional = new DescrizioneOptional(nomeDO, prezzoDO, coloreDO);
                mappaDO.put(nomeDO, descrizioneOptional);
            }else{
                System.out.println("Descrizione Optional non valida");
            }
        } catch (NullPointerException e) {
            System.err.println("NOME NON VALIDO. Ritorno al menu' in corso...");
            return null;
        }
        return descrizioneOptional;
    }

    public void aggiungiFoto(Foto foto) {
        listaFoto.add(foto);
    }

    // Getter/Setter
    public HashMap<String, DescrizioneOptional> getMappaDO() {
        return mappaDO;
    }

    public void setMappaDO(HashMap<String, DescrizioneOptional> mappaDO) {
        this.mappaDO = mappaDO;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public int getPrezzoBase() {
        return prezzoBase;
    }

    public void setPrezzoBase(int prezzoBase) {
        this.prezzoBase = prezzoBase;
    }

    public String getProduttore() {
        return produttore;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public String getTipoVeicolo() {
        return tipoVeicolo;
    }

    public void setTipoVeicolo(String tipoVeicolo) {
        this.tipoVeicolo = tipoVeicolo;
    }

    public Noleggio getNoleggio() {
        return noleggio;
    }

    public void setNoleggio(Noleggio noleggio) {
        this.noleggio = noleggio;
    }

    public HashMap<Integer, VeicoloPersonalizzato> getMappaVeicoliPersonalizzati() {
        return mappaVeicoliPersonalizzati;
    }

    public void setMappaVeicoliPersonalizzati(HashMap<Integer, VeicoloPersonalizzato> mappaVeicoliPersonalizzati) {
        this.mappaVeicoliPersonalizzati = mappaVeicoliPersonalizzati;
    }

    public VeicoloPersonalizzato getVP() {
        return VP;
    }

    public void setVP(VeicoloPersonalizzato VP) {
        this.VP = VP;
    }

    public ArrayList<Foto> getListaFoto() {
        return listaFoto;
    }

    public void setListaFoto(ArrayList<Foto> listaFoto) {
        this.listaFoto = listaFoto;
    }

    public Concessionario getConcessionario() {
        return concessionario;
    }

    public void setConcessionario(Concessionario concessionario) {
        this.concessionario = concessionario;
    }
}
