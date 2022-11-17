package hotel.repository;

import hotel.model.ReservaItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface ReservaRepository extends MongoRepository<ReservaItem, String> {
	
	@Query("{name:'?0'}")
	ReservaItem findClienteItemByName(String nome);

//	@Query("{quarto:'?0'}")
//	QuartoItem

	@Query(value="{name:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
	List<ReservaItem> findAll(String category);
	
	public long count();

	//	  private String nome;
	//    private String endereco;
	//    private Nacionalidade nacionalidade;
	//    private String email;
	//    private String telefone;
	//    private HotelItem hotelItem;

}
