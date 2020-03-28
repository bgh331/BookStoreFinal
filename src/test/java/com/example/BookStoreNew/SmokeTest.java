package com.example.BookStoreNew;

import static org.assertj.core.api.Assertions.assertThat; 

import org.junit.jupiter.api.Test;
//import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.BookStoreNew.domain.UserRepository;
import com.example.BookStoreNew.web.BookController;
import com.example.BookStoreNew.web.UserDetailServiceImpl;



@RunWith(SpringRunner.class)
@SpringBootTest
class BookstoreApplicationTests {

	@Test
	void contextLoadsOther() {
	}

	
	// SMOKE TESTS TO see if there are actually contents / stuff inside each of the controllers. Leaving out Web Layer / HttpRequests ...
	// ... since there are no such prints here and the port is determined by a working software.
	@Autowired
    private BookController bookController;
	@Autowired
	private UserRepository usrepository;
	@Autowired
	private UserDetailServiceImpl udsi;
	

    @Test
    public void contexLoads() throws Exception {
        assertThat(bookController).isNotNull();
    }
    
    @Test
    public void contexLoads1() throws Exception {
        assertThat(usrepository).isNotNull();
    }	
    
    @Test
    public void contexLoads2() throws Exception {
        assertThat(udsi).isNotNull();
    }	
}

