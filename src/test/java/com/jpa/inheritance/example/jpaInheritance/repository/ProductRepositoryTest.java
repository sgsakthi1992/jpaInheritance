package com.jpa.inheritance.example.jpaInheritance.repository;

import com.jpa.inheritance.example.jpaInheritance.model.singletable.Book;
import com.jpa.inheritance.example.jpaInheritance.model.singletable.Pen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository<Book> bookProductRepository;

    @Autowired
    private ProductRepository<Pen> penProductRepository;

    @BeforeEach
    void setup() {
        var book = new Book();
        book.setProductId(1L);
        book.setName("Book 1");
        book.setAuthor("Author 1");
        bookProductRepository.save(book);

        var pen = new Pen();
        pen.setProductId(2L);
        pen.setName("Pen 1");
        pen.setColor("Green");
        penProductRepository.save(pen);
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
                () -> assertEquals("Pen 1", pens.get(0).getName()),
                () -> assertEquals("Green", pens.get(0).getColor())
        );
    }

}