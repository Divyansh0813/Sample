package com.sopra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class ExampleServiceMockTest {
    
    @Mock    
    private ExampleRepositoryImpl exampleRepo;
    
    @InjectMocks// auto inject helloRepository
    private ExampleServiceImpl helloService = new ExampleServiceImpl();
    
    
    @BeforeEach
    void setMockOutput()
    {
        when(exampleRepo.get()).thenReturn("Hello Mockito From Repository");
        when(exampleRepo.getById(any(Integer.class))).thenReturn("This is dummy value"+10);



   }
    
    @DisplayName("Test Mock helloService + helloRepository")
    @Test
    void testGet()
    {
        assertEquals("Hello Mockito From Repository",helloService.get());
    }

    @Test 
    void testgetById() {
    	
    	int id= 10;
    	String result = helloService.getById(id);
    	equals("This is dummy value"+result);
    }
    
    @Test
    void testgetByIdEx() {
    	assertThrows(RuntimeException.class, () -> helloService.getById(420));
    }

}