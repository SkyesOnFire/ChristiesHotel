package hotel.repository;

import hotel.model.QuartoItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface QuartoRepository extends MongoRepository<QuartoItem, String> {
	
	@Query("{id:'?0'}")
	QuartoItem findQuartoItemById(String id);

//	@Query("{quarto:'?0'}")
//	QuartoItem

	@Query(value="{name:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
	List<QuartoItem> findAll(String category);
	
	public long count();

	//	  private String nome;
	//    private String endereco;
	//    private Nacionalidade nacionalidade;
	//    private String email;
	//    private String telefone;
	//    private HotelItem hotelItem;

}
