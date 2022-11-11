package hotel.model;

import hotel.Enums.Cargo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("FuncionarioItem")
public class FuncionarioItem {

    @Id
    private String id;

    private String nome;
    private Cargo cargo;
    private HotelItem hotelItem;

    public FuncionarioItem(String id, String nome, Cargo cargo, HotelItem hotelItem) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.hotelItem = hotelItem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public HotelItem getHotelItem() {
        return hotelItem;
    }

    public void setHotelItem(HotelItem hotelItem) {
        this.hotelItem = hotelItem;
    }
}
