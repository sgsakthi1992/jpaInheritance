package com.jpa.inheritance.example.jpaInheritance.repository;

import com.jpa.inheritance.example.jpaInheritance.model.singletable.Book;
import com.jpa.inheritance.example.jpaInheritance.model.singletable.Pen;
import com.jpa.inheritance.example.jpaInheritance.model.singletable.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository<Book> bookProductRepository;

    @Autowired
    private ProductRepository<Pen> penProductRepository;

    @Autowired
    private ProductRepository<Product> productRepository;

    @BeforeEach
    void setup() {
        createBook(1L, "Book 1", "Author 1");
        createPen();
    }

    @Test
    void testBookByProductType() {
        var books = bookProductRepository.findByProductType("book");
        assertAll(
                () -> assertEquals(1, books.size()),
                () -> assertEquals(1, books.get(0).getProductId()),
                () -> assertEquals("Book 1", books.get(0).getName()),
                () -> assertEquals("Author 1", books.get(0).getAuthor())
        );
    }

    @Test
    void testPenByProductType() {
        var pens = penProductRepository.findByProductType("pen");
        assertAll(
                () -> assertEquals(1, pens.size()),
                () -> assertEquals(2L, pens.get(0).getProductId()),
                () -> assertEquals("Ballpoint Pen", pens.get(0).getName()),
                () -> assertEquals("Blue", pens.get(0).getColor())
        );
    }

    @Test
    void testBookPageable() {
        createBook(3L, "Book 3", "Author 3");
        createBook(4L, "Book 4", "Author 4");

        var firstTwoElements = PageRequest.of(0, 2, Sort.by("name").descending());
        var books = bookProductRepository.findByProductType("book", firstTwoElements);
        var nextBooks = bookProductRepository.findByProductType("book", firstTwoElements.next());
        assertAll(
                () -> assertEquals(2, books.size()),
                () -> assertEquals(1, nextBooks.size()),
                () -> assertEquals("Book 4", books.get(0).getName()),
                () -> assertEquals("Book 3", books.get(1).getName()),
                () -> assertEquals("Book 1", nextBooks.get(0).getName())
        );
        System.out.println(firstTwoElements.hasPrevious());
    }

    @Test
    void testPageableWithReturnTypePage() {
        createBook(3L, "Book 3", "Author 3");
        createBook(4L, "Book 4", "Author 4");

        var firstTwoElements = PageRequest.of(0, 2, Sort.by("name").descending());

        var productPage = productRepository.findAll(firstTwoElements);
        var products = productPage.getContent();

        if (productPage.hasNext()) {
            productPage = productRepository.findAll(productPage.nextPageable());
        }
        var nextProducts = productPage.getContent();

        assertAll(
                () -> assertEquals(2, products.size()),
                () -> assertEquals(2, nextProducts.size()),
                () -> assertEquals("Book 4", products.get(0).getName()),
                () -> assertEquals("Book 3", products.get(1).getName()),
                () -> assertEquals("Book 1", nextProducts.get(0).getName()),
                () -> assertEquals("Ballpoint Pen", nextProducts.get(1).getName())
        );

    }

    private void createBook(long productId, String name, String author) {
        var book1 = new Book();
        book1.setProductId(productId);
        book1.setName(name);
        book1.setAuthor(author);
        bookProductRepository.save(book1);
    }

    private void createPen() {
        var pen = new Pen();
        pen.setProductId(2L);
        pen.setName("Ballpoint Pen");
        pen.setColor("Blue");
        penProductRepository.save(pen);
    }

}