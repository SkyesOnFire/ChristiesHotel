package hotel.model;

import hotel.Enums.Nacionalidade;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ClienteItem")
public class ClienteItem {

    @Id
    private String id;

    private String name;
    private String address;
    private Nacionalidade nacionalidade;
    private String email;
    private String phone;
    private HotelItem hotelItem;

    public ClienteItem(String id, String name, String address, Nacionalidade nacionalidade, String email, String phone, HotelItem hotelItem) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.nacionalidade = nacionalidade;
        this.email = email;
        this.phone = phone;
        this.hotelItem = hotelItem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public Nacionalidade getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Nacionalidade nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public HotelItem getHotelItem() {
        return hotelItem;
    }

    public void setHotelItem(HotelItem hotelItem) {
        this.hotelItem = hotelItem;
    }
}
