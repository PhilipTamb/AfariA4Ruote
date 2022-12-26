/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A4R;

/**
 *
 * @author Phoenix
 */

import java.time.LocalDate;

public abstract class Ordine {

    protected String tipologiaOrdine;
    protected String luogoRitiro;
    protected final int IVA = 22;
    protected float tasseDogane = 2.50f;
    protected int commissioneA4R = 3;
    protected float commissionePagamento;
    protected float costoSpedizione;
    protected int scontoA4R = 0;
    protected float prezzoFinale;
    protected VeicoloNoleggiabile veicoloNoleggiabile;

    public abstract float impostaOrdine(MetodoPagamentoAdapter metodoPagamentoAdapter);
    public abstract void scegliLuogoRitiro(String luogoRitiro);
    public abstract void aggiornaTasseDogane(String luogoRitiro);
    public abstract void aggiornaCostoSpedizione(String luogoRitiro);
    public abstract float calcoloTotaleAcquisto(int prezzoBase, int IVA, float tasseDogane, int commissioneA4R, float commissionePagamento, float costoSpedizione, int scontoPremium, int scontoA4R, int scontoconcessionario, int prezzoOptional);
    public abstract void aggiornaAcquisto(LocalDate dataAcquisto);

    public String getTipologiaOrdine(){
        return tipologiaOrdine;
    }

    public void setTipologiaOrdine (String tipologiaOrdine){
        this.tipologiaOrdine = tipologiaOrdine;
    }
}
