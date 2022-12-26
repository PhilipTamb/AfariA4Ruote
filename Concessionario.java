/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A4R;

/**
 *
 * @author Phoenix
 */
public class Concessionario {

    public Concessionario(int codice, String nome, String luogo, int scontoConcessionario) {
        this.codice = codice;
        this.nome = nome;
        this.luogo = luogo;
        this.scontoConcessionario = scontoConcessionario;
    }
        

    private int codice;
    private String nome;
    private String luogo;
    private int scontoConcessionario;

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

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public int getScontoConcessionario() {
        return scontoConcessionario;
    }

    public void setScontoConcessionario(int scontoConcessionario) {
        this.scontoConcessionario = scontoConcessionario;
    }
}
