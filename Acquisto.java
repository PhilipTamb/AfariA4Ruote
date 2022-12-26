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

public class Acquisto extends Ordine {

    public Acquisto(Utente utente, VeicoloPersonalizzato VPcorrente) {
        super();
        this.utente = utente;
        this.VPcorrente = VPcorrente;
        this.setTipologiaOrdine("Acquisto");
    }

    private LocalDate dataAcquisto;
    private Utente utente;
    private VeicoloPersonalizzato VPcorrente;
    private int scontoConcessionario;
    private int prezzoOptional;
    private int prezzoBase;
    private int scontoPremium;

    @Override
    public float impostaOrdine(MetodoPagamentoAdapter metodoPagamentoAdapter) {
        scontoPremium = utente.getScontoPremium();
        prezzoBase = VPcorrente.getPrezzoBase();
        prezzoOptional = VPcorrente.getPrezzoOptional();
        scontoConcessionario = VPcorrente.recuperaScontoConcessionario();
        commissionePagamento = metodoPagamentoAdapter.getCommissioniPagamento();
        return prezzoFinale = calcoloTotaleAcquisto(prezzoBase, IVA, tasseDogane, commissioneA4R, commissionePagamento, costoSpedizione, scontoPremium, scontoA4R, scontoConcessionario, prezzoOptional);
    }

    @Override
    public void scegliLuogoRitiro(String luogoRitiro) {
        this.luogoRitiro = luogoRitiro;
        aggiornaCostoSpedizione(luogoRitiro);
        aggiornaTasseDogane(luogoRitiro);
    }

    @Override
    public void aggiornaTasseDogane(String luogoRitiro) {
        switch (luogoRitiro) {
            case "Catania":
                this.tasseDogane = 0;
                break;

            case "Sapporo":
                this.tasseDogane = 300;
                break;

            case "London":
                this.tasseDogane = 150;
                break;

            case "":
                this.tasseDogane = 0;
                break;

            default:
                this.tasseDogane = 30;
        }
    }

    @Override
    public void aggiornaCostoSpedizione(String luogoRitiro) {
        switch (luogoRitiro) {
            case "Catania":
                this.costoSpedizione = 0;
                break;

            case "Sapporo":
                this.costoSpedizione = 1000;
                break;

            case "London":
                this.costoSpedizione = 500;
                break;

            case "":
                this.costoSpedizione = 0;
                break;

            default:
                this.costoSpedizione = 50;
        }
    }

    @Override
    public float calcoloTotaleAcquisto(int prezzoBase, int IVA, float tasseDogane, int commissioneA4R, float commissionePagamento, float costoSpedizione, int scontoPremium, int scontoA4R, int scontoConcessionario, int prezzoOptional) {
        if (prezzoBase != 0) {
            return (prezzoBase + ((prezzoBase * IVA) / 100) + tasseDogane + commissioneA4R + commissionePagamento + costoSpedizione - ((prezzoBase * scontoPremium) / 100) - ((prezzoBase * scontoA4R) / 100) - ((prezzoBase * scontoConcessionario) / 100));
        }
        return 0;
    }

    @Override
    public void aggiornaAcquisto(LocalDate dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    public float getTasseDogane() {
        return this.tasseDogane;
    }

    public int getCommissioneA4R() {
        return commissioneA4R;
    }

    public int getPrezzoBase() {
        return prezzoBase;
    }

    public void setPrezzoBase(int prezzoBase) {
        this.prezzoBase = prezzoBase;
    }

    public int getIva() {
        return IVA;
    }

    public float getCommissionePagamento() {
        return commissionePagamento;
    }

    public float getCostoSpedizione() {
        return costoSpedizione;
    }

    public int getScontoPremium() {
        return scontoPremium;
    }

    public int getScontoA4R() {
        return scontoA4R;
    }

    public int getScontoConcessionario() {
        return scontoConcessionario;
    }

    public int getPrezzoOptional() {
        return prezzoOptional;
    }

    public LocalDate getDataAcquisto() {
        return dataAcquisto;
    }
}
