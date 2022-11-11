package hotel.repository;

import java.util.List;

import hotel.model.ClienteItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface ClienteRepository extends MongoRepository<ClienteItem, String> {
	
	@Query("{name:'?0'}")
	ClienteItem findClienteItemByName(String nome);

//	@Query("{quarto:'?0'}")
//	QuartoItem

	@Query(value="{name:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
	List<ClienteItem> findAll(String category);
	
	public long count();

	//	  private String nome;
	//    private String endereco;
	//    private Nacionalidade nacionalidade;
	//    private String email;
	//    private String telefone;
	//    private HotelItem hotelItem;

}
