package com.testing.kbright.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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

  /**
   * Mock book used in tests. Contains id, title, description and rating
   */
  Book bookMock = new Book(2, "Livre 1", "Description", 3);

  /**
   * JSON string representation of the bookMock
   */
  String exampleBookJson = "{\"id\":2,\"titre\":\"Livre 1\",\"description\":\"Description\",\"rating\":3}";

  /**
   * Before all hook, prints a message
   */
  @BeforeAll
  static void launch() {
    System.out.println("Man with mission");
  }

  /**
   * Test case for the index API endpoint.
   *
   * Sends a GET request to the /book endpoint
   * and verifies that the response is a list of books.
   *
   * @throws Exception if something goes wrong during the test
   */
  @Test
  public void indexReturnsListOfBooks() throws Exception {
    List<Book> expectedBooks = List.of(new Book(1, "Mon livre", "Ce livre est riche en plein de choses", 4),
        new Book(2, "Livre 1", "Description", 3));
    Mockito.when(bookService.getAll()).thenReturn(expectedBooks);
    mvc.perform(MockMvcRequestBuilders.get("/book"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].titre").value("Mon livre"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
        .andExpect(MockMvcResultMatchers.jsonPath("$[1].titre").value("Livre 1"));
  }

  /**
   * Test case for the deleteBookById API endpoint.
   *
   * Sends a DELETE request to the /book/{id} endpoint
   * and verifies that the BookService's deleteById method is called once with the
   * argument 2.
   *
   * @throws Exception if something goes wrong during the test
   */
  @Test
  void shouldDeleteBookById() throws Exception {
    // Sending the request to the BookController and storing the result
    // This performs a DELETE request to the /book/2 endpoint
    mvc.perform(MockMvcRequestBuilders.delete("/book/2"))
        .andExpect(MockMvcResultMatchers.status().isOk()); // Expects a 200 OK status

    // Verifying that the deleteById method of the BookService was called once with
    // an argument of 2
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

    // Assert that the response matches the expected JSON
    assertEquals(200, result.getResponse().getStatus());

    // Verify that the findById method of the BookService was called once with an
    // argument of 2
    Mockito.verify(bookService, Mockito.times(1)).findById(2);
  }

  @Test
  void shouldRegisterABook() throws Exception { // Renamed the method

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
  void shouldUpdateBook() throws Exception {
    Integer id = 2;
    String json = "{\"id\":" + id + ",\"titre\":\"New book\",\"description\":\"Description\",\"rating\":3}";

    // Create the bookMock object with the same title as in the JSON
    Book bookMock = new Book(id, "New book", "Description", 3);

    Mockito.when(bookService.update(Mockito.eq(bookMock), Mockito.eq(id))).thenReturn(bookMock);

    RequestBuilder request = MockMvcRequestBuilders.put("/book/" + id)
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(json);

    MvcResult result = mvc.perform(request).andReturn();

    MockHttpServletResponse response = result.getResponse();

    assertEquals(200, response.getStatus());
  }
}
