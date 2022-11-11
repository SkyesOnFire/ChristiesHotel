package hotel.model;

import hotel.Enums.Pagamento;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ContaItem")
public class ContaItem {

    @Id
    private String id;
    private ProdutoItem[] produtoItem;
    private String nf;
    private Pagamento pagamento;
    private boolean pago;
    private ClienteItem clienteItem;
    private ReservaItem reservaItem;
    private QuartoItem quartoItem;

    public ContaItem(String id, ProdutoItem[] produtoItem, String nf, Pagamento pagamento, boolean pago, ClienteItem clienteItem, ReservaItem reservaItem, QuartoItem quartoItem) {
        this.id = id;
        this.produtoItem = produtoItem;
        this.nf = nf;
        this.pagamento = pagamento;
        this.pago = pago;
        this.clienteItem = clienteItem;
        this.reservaItem = reservaItem;
        this.quartoItem = quartoItem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProdutoItem[] getProdutoItem() {
        return produtoItem;
    }

    public void setProdutoItem(ProdutoItem[] produtoItem) {
        this.produtoItem = produtoItem;
    }

    public String getNf() {
        return nf;
    }

    public void setNf(String nf) {
        this.nf = nf;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public ClienteItem getClienteItem() {
        return clienteItem;
    }

    public void setClienteItem(ClienteItem clienteItem) {
        this.clienteItem = clienteItem;
    }

    public ReservaItem getReservaItem() {
        return reservaItem;
    }

    public void setReservaItem(ReservaItem reservaItem) {
        this.reservaItem = reservaItem;
    }

    public QuartoItem getQuartoItem() {
        return quartoItem;
    }

    public void setQuartoItem(QuartoItem quartoItem) {
        this.quartoItem = quartoItem;
    }
}
