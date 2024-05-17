package com.testing.kbright.repository;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.testing.kbright.models.Book;
import com.testing.kbright.service.implementation.BookServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BookRepositoryTest {

    /**
     * Le repository de livre qui sera mock (c'est-a-dire que nous allons
     * donner les valeurs que le repository doit retourner lors des tests)
     */
    @Mock
    private BookRepository bookRepository;

    /**
     * Le service de livre qui utilise le repository
     */
    @InjectMocks
    private BookServiceImpl bookService;

    /**
     * Le livre que nous allons utiliser pour mocker les valeurs
     * retournes par le repository
     */
    private Book bookMock;

    /**
     * Cette methode est appelee avant chaque test. C'est l'endroit
     * ou nous initialisons les donnees necessaires pour les tests
     */
    @BeforeEach
    void setUp() {
        bookMock = new Book(2, "Livre 1", "Description", 3);
    }

    /**
     * Ce test verifie que lorsque nous appelons la methode findById du service
     * de livre, le repository est bien appele avec l'argument attendu et
     * que la valeur retournee est bien la meme que celle attendue
     */
    @Test
    void testFindBookById() {
        // On mock le repository pour qu'il soit appele avec l'argument 12,
        // il retourne le livre mock
        when(bookRepository.findBookById(12)).thenReturn(bookMock);

        // On appelle la methode findById du service de livre
        Book book = bookService.findById(12);

        // On verifie que le repository a bien ete appele une fois
        // avec l'argument 12
        verify(bookRepository, Mockito.times(1)).findBookById(12);

        // On verifie que la valeur retournee est bien le livre mock
        assertNotNull(book);
        assertEquals(bookMock, book);
    }
}


