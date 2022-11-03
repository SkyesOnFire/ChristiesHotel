// Java Program to Illustrate BookRepo File

import com.globallogic.spring.mongodb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepo
	extends MongoRepository<Book, Integer> {
}
