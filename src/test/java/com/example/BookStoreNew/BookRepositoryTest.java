package com.example.BookStoreNew;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.BookStoreNew.domain.Book;
import com.example.BookStoreNew.domain.BookRepository;
import com.example.BookStoreNew.domain.Category;
import com.example.BookStoreNew.domain.CategoryRepository;
import com.example.BookStoreNew.domain.User;
import com.example.BookStoreNew.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

		@Autowired
		private BookRepository repository;
		@Autowired
		private CategoryRepository crepository;
		@Autowired
		private UserRepository usrepository;
		
	@Test
		public void findBynameShouldReturnBook() {
		List<Book> books = repository.findByName("Liikkuva Linna");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getName()).isEqualTo("Liikkuva Linna");
		}
		
	@Test
		public void createNewBook() {
		Book book = new Book("Kätkijät", "Hayao", "978-951-1-34784-2", 2002, new Category("Gibli"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
		}
	@Test
	public void deleteNewBook() {
	Book book = new Book("Kätkijät", "Hayao", "978-951-1-34784-2", 2002, new Category("Gibli"));
	repository.save(book);
	repository.deleteAll();
	assertThat(repository.count()).isEqualTo(0);
	
	}  
    
    @Test
    public void findByNameCategoryTest() {
    	List<Category> cats = crepository.findByName("Gibli");
    	assertThat(cats).hasSize(1);
        assertThat(cats.get(0).getName()).isEqualTo("Gibli");
    }
    
    @Test
    public void CreateNewCategoryTest() {
       	Category cat = new Category("History");
    	crepository.save(cat);
    	assertThat(cat.getCategoryId()).isNotNull();
    }
    
    @Test
    public void deleteCatsTests() {
    	Category cat = new Category("Science-Fiction");
    	crepository.save(cat);
    	crepository.deleteAll();
    	assertThat(crepository.count()).isEqualTo(0); // Testing deletes with size.
    }   
    
    @Test
    public void findByUsernameUserTest() {
        User user = usrepository.findByUsername("user");
        assertThat(user.getUsername()).isNotNull();
        assertThat(user.getRole()).isEqualTo("USER");
    }
    
    @Test
    public void createNewUserTest() {
    	User user = new User("Kristiina", "$2a$09$Z0WM3EGzz5sJJj3fA5KOnuvUHhrMO4tCcnRHFbM7HT4aBbyZ4G.AO", "USER");
    	usrepository.save(user);
    	assertThat(user.getId()).isNotNull();
    }  
    
    @Test
    public void deleteAllUsersTest() {
    	User user = new User("Kaukonen", "$2a$09$glF.zGYv.66kknTC4oLTkepUOPrMMlxTeLVRcjiDU1Q5e6te3cc0K", "USER");
    	usrepository.save(user);
    	usrepository.deleteAll();
    	assertThat(usrepository.count()).isEqualTo(0); // Testing deletes with size. Everything works - need to have different usernames...
    	// .. because of constraints in the SQL tables and columns - good and efficient.
    }   

}
		


