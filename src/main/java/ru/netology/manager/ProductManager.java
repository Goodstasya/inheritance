package ru.netology.manager;

import ru.netology.domain.*;
import ru.netology.repository.*;

public class ProductManager {
    // добавьте необходимые поля, конструкторы и методы
    private ProductRepository repository;

    public ProductManager() { }

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void save(Product item) {
        repository.save(item);
    }

    public Product[] findAll() {
        return repository.findAll();
    }

    public Product[] searchBy(String text) {
        int resultLen = 0;
        Product[] items = repository.findAll();
        Product[] matchedItems = new Product[items.length];
        for (Product item : items) {
            if (matches(item, text) == true) {
                matchedItems[resultLen] = item;
                resultLen += 1;
            }
        }

        Product[] result = new Product[resultLen];
        System.arraycopy(matchedItems, 0, result, 0, resultLen);

        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }

        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getProducer().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }

        return false;
    }
}
