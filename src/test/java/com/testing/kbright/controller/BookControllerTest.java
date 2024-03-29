package com.testing.kbright.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.testing.kbright.models.Book;
import com.testing.kbright.service.attachement.BookService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService bookService;

    Book bookMock = new Book(2,"Livre 1","Description",3);
    String exampleBookJson = "{\"id\":2,\"titre\":\"Livre 1\",\"description\":\"Description\",\"rating\":3}";

    @Test
    public void getAllEmployeesAPI() throws Exception {
        Mockito.when(bookService.findById(Mockito.anyInt())).thenReturn(bookMock);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/book/2").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"id\":2,\"titre\":\"Livre 1\",\"description\":\"Description\",\"rating\":3}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    void testDelete() {

    }

    @Test
    void testGetBookById() {

    }

    @Test
    void testIndex() {

    }

    @Test
    void testRegister() {

    }

    @Test
    void testUpdate() {

    }
}