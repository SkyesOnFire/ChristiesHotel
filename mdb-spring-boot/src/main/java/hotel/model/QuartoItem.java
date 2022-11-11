package hotel.model;

import hotel.Enums.Tipo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("QuartoItem")
public class QuartoItem {

    @Id
    private String id;

    private int numero;
    private Tipo tipo;
    private long valor;
    private boolean adaptado;
    private HotelItem hotelItem;

    public QuartoItem(String id, int numero, Tipo tipo, long valor, boolean adaptado, HotelItem hotelItem) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.valor = valor;
        this.adaptado = adaptado;
        this.hotelItem = hotelItem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public boolean isAdaptado() {
        return adaptado;
    }

    public void setAdaptado(boolean adaptado) {
        this.adaptado = adaptado;
    }

    public HotelItem getHotelItem() {
        return hotelItem;
    }

    public void setHotelItem(HotelItem hotelItem) {
        this.hotelItem = hotelItem;
    }
}
