package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
  ProductRepository repository = new ProductRepository();
  ProductManager manager = new ProductManager(repository);

  Book book1 = new Book(1, "Book1", 1000, "Author1");
  Book book2 = new Book(2, "Book2", 1000, "Author2");
  Book book3 = new Book(3, "Book3", 1000, "Author3");
  Book book4 = new Book(4, "Book4", 1000, "Author2");
  Book book5 = new Book(5, "Book5", 1000, "Author1");

  Smartphone smartphone1 = new Smartphone(1, "Smartphone1", 1000, "Producer1");
  Smartphone smartphone2 = new Smartphone(2, "Smartphone2", 1000, "Producer2");
  Smartphone smartphone3 = new Smartphone(3, "Smartphone3", 1000, "Producer3");
  Smartphone smartphone4 = new Smartphone(4, "Smartphone4", 1000, "Producer2");
  Smartphone smartphone5 = new Smartphone(5, "Smartphone5", 1000, "Producer2");

  @BeforeEach
  public void setUp() {
    manager.save(book1);
    manager.save(book2);
    manager.save(book3);
    manager.save(book4);
    manager.save(book5);
    manager.save(smartphone1);
    manager.save(smartphone2);
    manager.save(smartphone3);
    manager.save(smartphone4);
    manager.save(smartphone5);
  }

  @Test
  public void shouldSearchByBookName(){
    String bookName = "Book4";
    Product[] expected = new Product[]{book4};
    Product[] actual = manager.searchBy(bookName);
    assertArrayEquals(actual, expected);
  }

  @Test
  public void shouldSearchByBookAuthor(){
    String bookAuthor = "Author2";
    Product[] expected = new Product[]{book2, book4};
    Product[] actual = manager.searchBy(bookAuthor);
    assertArrayEquals(actual, expected);
  }

  @Test
  public void shouldSearchBySmartphoneName(){
    String smartphoneName = "Smartphone3";
    Product[] expected = new Product[]{smartphone3};
    Product[] actual = manager.searchBy(smartphoneName);
    assertArrayEquals(actual, expected);
  }

  @Test
  public void shouldSearchBySmartphoneProducer(){
    String smartphoneProducer = "Producer2";
    Product[] expected = new Product[]{smartphone2, smartphone4,smartphone5};
    Product[] actual = manager.searchBy(smartphoneProducer);
    assertArrayEquals(actual, expected);
  }

  /*@Test
  public void shouldCastFromBaseClass() {
    Product product = new Book();
    if (product instanceof Book) {
      Book book = (Book) product;

    }
  }*/

  /*@Test
  public void shouldNotCastToDifferentClass() {
    Product product = new Book();
    TShirt shirt = (TShirt) product;
  }*/

  /*@Test
  public void shouldUseOverridedMethod() {
    Product product = new Book();
    // Вопрос к аудитории: чей метод вызовется?
    product.toString();
  }*/
}
