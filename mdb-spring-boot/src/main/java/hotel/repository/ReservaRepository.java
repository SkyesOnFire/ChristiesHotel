package hotel.repository;

import hotel.model.ReservaItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReservaRepository extends MongoRepository<ReservaItem, String> {
	
	@Query("{tipo:'?0'}")
	Optional<ReservaItem> findReservaItemByQuartoItem_Tipo(String quartoTipo);

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
