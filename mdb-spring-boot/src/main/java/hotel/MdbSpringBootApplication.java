//package hotel;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import hotel.Enums.Nacionalidade;
//import hotel.model.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//import hotel.repository.CustomItemRepository;
//import hotel.repository.ClienteRepository;
//
//@SpringBootApplication
//@EnableMongoRepositories
//public class MdbSpringBootApplication implements CommandLineRunner{
//
//	@Autowired
//	ClienteRepository clienteRepository;
//
//	@Autowired
//	CustomItemRepository customRepo;
//
//	List<ProdutoItem> produtoItems = new ArrayList<ProdutoItem>();
//	List<ClienteItem> clienteItems = new ArrayList<ClienteItem>();
//	List<FuncionarioItem> funcionarioItems = new ArrayList<FuncionarioItem>();
//	List<HotelItem> hotelItems = new ArrayList<HotelItem>();
//	List<QuartoItem> quartoItems = new ArrayList<QuartoItem>();
//	List<ReservaItem> reservaItems = new ArrayList<ReservaItem>();
//	List<ContaItem> contaItems = new ArrayList<ContaItem>();
//
//	public static void main(String[] args) {
//		SpringApplication.run(MdbSpringBootApplication.class, args);
//	}
//
//	public void run(String... args) {
//
//		// Clean up any previous data
//		clienteRepository.deleteAll(); // Doesn't delete the collection
//
//		System.out.println("-------------CREATE HOTEL ITEMS-------------------------------\n");
//
//		createGroceryItems();
//
//		System.out.println("\n----------------SHOW ALL HOTEL ITEMS---------------------------\n");
//
//		showAllClientItems();
//
//		System.out.println("\n--------------GET ITEM BY NAME-----------------------------------\n");
//
//		getClientItemByName("Pedro Lucho");
//
//		System.out.println("\n-----------GET CLIENTS BY NAME---------------------------------\n");
//
//		getClientByName("Teilor Miotto");
//
//		System.out.println("\n-----------UPDATE COUNTRY OF ALL CLIENTS ----------------\n");
//
//		updateClientsCountry("Brazil");
//
//		System.out.println("\n-----------UPDATE ADDRESS OF A CLIENT ITEM------------------------\n");
//
//		updateClientAddress("Teilor Miotto", "Imaculada Conceicao");
//
//		System.out.println("\n----------DELETE A GROCERY ITEM----------------------------------\n");
//
//		deleteGroceryItem("4");
//
//		System.out.println("\n------------FINAL COUNT OF CLIENT ITEMS-------------------------\n");
//
//		findCountOfAllClients();
//
//		System.out.println("\n-------------------THANK YOU---------------------------");
//
//	}
//
//	// CRUD operations
//
//	//CREATE
//	void createGroceryItems() {
//		System.out.println("Data creation started...");
//
//		HotelItem hotelItem = new HotelItem("1", "HOTEL AGHAHTHAS", "Rua das Christies 9001", "154 243 534");
//
//		clienteRepository.save(new ClienteItem("1", "Teilor Miotto", "Rua 1", Nacionalidade.BRASILEIRO, "tm@email.com", "12345678", hotelItem));
//		clienteRepository.save(new ClienteItem("2", "Pedro Lucho", "Rua 2", Nacionalidade.BRASILEIRO, "pl@email.com", "12345678", hotelItem));
//		clienteRepository.save(new ClienteItem("3", "Duda Grein", "Rua 3", Nacionalidade.BRASILEIRO, "dg@email.com", "12345678", hotelItem));
//		clienteRepository.save(new ClienteItem("4", "Agatha Christie", "Rua 4", Nacionalidade.BRASILEIRO, "ac@email.com", "12345678", hotelItem));
//
//		System.out.println("Data creation complete...");
//	}
//
//	// READ
//	// 1. Show all the data
//	 public void showAllClientItems() {
//
//		 clienteItems = clienteRepository.findAll();
//
//		 clienteItems.forEach(item -> System.out.println(getClientDetails(item)));
//	 }
//
//	 // 2. Get item by name
//	 public void getClientItemByName(String name) {
//		 System.out.println("Getting item by name: " + name);
//		 ClienteItem item = clienteRepository.findClienteItemByName(name);
//		 System.out.println(getClientDetails(item));
//	 }
//
//	 // 3. Get name and items of a all items of a particular category
//	 public void getClientByName(String name) {
//		 System.out.println("Getting client by name: " + name);
//		 List<ClienteItem> list = clienteRepository.findAll(name);
//
//		 list.forEach(item -> System.out.println("Name: " + item.getname() + ", Email: " + item.getEmail()));
//	 }
//
//	 // 4. Get count of documents in the collection
//	 public void findCountOfAllClients() {
//		 long count = clienteRepository.count();
//		 System.out.println("Number of documents in the collection = " + count);
//	 }
//
//	 // UPDATE APPROACH 1: Using MongoRepository
//	 public void updateClientsCountry(String country) {
//
//		 // Change to this new value
//		 String newCountry = "Brazil";
//
//		 // Find all the items with the category
//		 List<ClienteItem> list = clienteRepository.findAll(country);
//
//		 list.forEach(item -> {
//			 // Update the category in each document
//			 item.setaddress(newCountry);
//		 });
//
//		 // Save all the items in database
//		 List<ClienteItem> itemsUpdated = clienteRepository.saveAll(list);
//
//		 if(itemsUpdated != null)
//			 System.out.println("Successfully updated " + itemsUpdated.size() + " items.");
//	 }
//
//	 // UPDATE APPROACH 2: Using MongoTemplate
//	 public void updateClientAddress(String name, String address) {
//		 System.out.println("Updating address for " + name);
//		 customRepo.updateItemAddress(name, address);
//	 }
//
//	 // DELETE
//	 public void deleteGroceryItem(String id) {
//		 clienteRepository.deleteById(id);
//		 System.out.println("Item with id " + id + " deleted...");
//	 }
//	 // Print details in readable form
//
//	 public String getClientDetails(ClienteItem item) {
//
//		 System.out.println(
//		 "Client Id: " + item.getId() +
//		 ", \nClient Name: " + item.getname() +
//		 ", \nClient Address: " + item.getaddress() +
//		 ", \nClient Email: " + item.getEmail() +
//		 ", \nClient Nacionality: " + item.getNacionalidade() +
//		 ", \nClient Phone: " + item.getphone()
//		 );
//
//		 return "";
//	 }
//}
//
