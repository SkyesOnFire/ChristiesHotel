package hotel.model;

import hotel.Enums.Tipo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("ReservaItem")
public class ReservaItem {

    @Id
    private String id;
    private Tipo tipo;
    private Date checkin;
    private Date checkout;
    private QuartoItem quartoItem;
    private ClienteItem clienteItem;
    private FuncionarioItem funcionarioItem;

    public ReservaItem(String id, Tipo tipo, Date checkin, Date checkout, QuartoItem quartoItem, ClienteItem clienteItem, FuncionarioItem funcionarioItem) {
        this.id = id;
        this.tipo = tipo;
        this.checkin = checkin;
        this.checkout = checkout;
        this.quartoItem = quartoItem;
        this.clienteItem = clienteItem;
        this.funcionarioItem = funcionarioItem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public QuartoItem getQuartoItem() {
        return quartoItem;
    }

    public void setQuartoItem(QuartoItem quartoItem) {
        this.quartoItem = quartoItem;
    }

    public ClienteItem getClienteItem() {
        return clienteItem;
    }

    public void setClienteItem(ClienteItem clienteItem) {
        this.clienteItem = clienteItem;
    }

    public FuncionarioItem getFuncionarioItem() {
        return funcionarioItem;
    }

    public void setFuncionarioItem(FuncionarioItem funcionarioItem) {
        this.funcionarioItem = funcionarioItem;
    }
}
