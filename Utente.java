/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A4R;

/**
 *
 * @author Phoenix
 */
public class Utente {

    public Utente(int codice, String nome, String cognome, String domicilio, int scontoPremium, boolean millemiglia) {
        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
        this.domicilio = domicilio;
        this.scontoPremium = scontoPremium;
        this.millemiglia = millemiglia;
    }

    private int codice;
    private String nome;
    private String cognome;
    private String domicilio;
    private int scontoPremium = 0;
    private boolean millemiglia = false;

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getScontoPremium() {
        return scontoPremium;
    }

    public void setScontoPremium(int scontoPremium) {
        this.scontoPremium = scontoPremium;
    }

    public boolean isMillemiglia() {
        return millemiglia;
    }

    public void setMillemiglia(boolean millemiglia) {
        this.millemiglia = millemiglia;
    }
}
