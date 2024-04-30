package com.testing.kbright.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.testing.kbright.models.Book;
import com.testing.kbright.service.attachement.BookService;

@WebMvcTest(BookController.class)
public class BookControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private BookService bookService;

  Book bookMock = new Book(2, "Livre 1", "Description", 3);
  String exampleBookJson = "{\"id\":2,\"titre\":\"Livre 1\",\"description\":\"Description\",\"rating\":3}";


  @BeforeAll
  static void launch(){
    System.out.println("Man with mission");
  }

  @Test
  public void getAllEmployeesAPI() throws Exception {
    Mockito.when(bookService.findById(Mockito.anyInt())).thenReturn(bookMock);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
        "/book/2").accept(
            MediaType.APPLICATION_JSON);

    MvcResult result = mvc.perform(requestBuilder).andReturn();

    String expected = "{\"id\":2,\"titre\":\"Livre 1\",\"description\":\"Description\",\"rating\":3}";

    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
  }


  /**
   * Test case for the deleteBookById API endpoint.
   *
   * Sends a DELETE request to the /book/{id} endpoint
   * and verifies that the BookService's deleteById method is called once with the argument 2.
   *
   * @throws Exception if something goes wrong during the test
   */
  @Test
  void testDelete() throws Exception {
    // Sending the request to the BookController and storing the result
    // This performs a DELETE request to the /book/2 endpoint
    mvc.perform(MockMvcRequestBuilders.delete("/book/2"))
      .andExpect(MockMvcResultMatchers.status().isOk()); // Expects a 200 OK status

    // Verifying that the deleteById method of the BookService was called once with an argument of 2
    Mockito.verify(bookService, Mockito.times(1)).deleteById(2);
  }

  /**
   * Test case for the getBookById API endpoint.
   *
   * @throws Exception if something goes wrong during the test
   */
  @Test
  void testGetBookById() throws Exception {
    // Mock the BookService to return the mockBook when findById(2) is called
    Mockito.when(bookService.findById(2)).thenReturn(bookMock);

    // Create a GET request to the /book/2 endpoint
    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/book/2")
        .accept(MediaType.APPLICATION_JSON);

    // Send the request and store the result
    MvcResult result = mvc.perform(requestBuilder).andReturn();

    // Define the expected JSON response
    String expected = "{\"id\":2,\"titre\":\"Livre 1\",\"description\":\"Description\",\"rating\":3}";

    // Assert that the response matches the expected JSON
    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

    // Verify that the findById method of the BookService was called once with an argument of 2
    Mockito.verify(bookService, Mockito.times(1)).findById(2);
  }

  @Test
  void testRegister() throws Exception {

    // studentService.addCourse to respond back with mockCourse
    Mockito.when(bookService.register(
        Mockito.any(Book.class))).thenReturn(bookMock);

    // Send course as body to /students/Student1/courses
    RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/book")
        .accept(MediaType.APPLICATION_JSON).content(exampleBookJson)
        .contentType(MediaType.APPLICATION_JSON);

    MvcResult result = mvc.perform(requestBuilder).andReturn();

    MockHttpServletResponse response = result.getResponse();

    assertEquals(200, response.getStatus());
  }

  @Test
  void testUpdate() {

  }
}
