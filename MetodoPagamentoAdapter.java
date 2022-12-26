/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A4R;

/**
 *
 * @author Phoenix
 */
public class MetodoPagamentoAdapter implements MetodoPagamento {
    private String nome;
    private int codice;
    private int commissioniPagamento;
    
    public MetodoPagamentoAdapter (String nome, int codice, int commissioniPagamento){
        this.nome = nome;
        this.codice = codice;
        this.commissioniPagamento = commissioniPagamento;
    }
    
    @Override
    public String effettuaPagamento(float prezzoTotale, String tipologiaOrdine) {
        return "OK";
    }

// Getter/Setter
    public int getCodice() {
        return codice;
    }
    
    public String getNome() {
        return nome;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public int getCommissioniPagamento() {
        return commissioniPagamento;
    }

    public void setCommissioniPagamento(int commissioniPagamento) {
        this.commissioniPagamento = commissioniPagamento;
    }

}
