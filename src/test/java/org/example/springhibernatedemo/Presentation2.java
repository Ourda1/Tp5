package org.example.springhibernatedemo;

import org.example.springhibernatedemo.dao.IDao;
import org.example.springhibernatedemo.entities.Category;
import org.example.springhibernatedemo.entities.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.example.springhibernatedemo.util.HibernateConfig;

public class Presentation2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Product> productDao = context.getBean("productDaoImpl", IDao.class);
        IDao<Category> categoryDao = context.getBean("categoryDaoImpl", IDao.class);

        Category category = new Category();
        category.setName("Catégorie 1");

        Product product = new Product();
        product.setName("Produit 1");
        product.setPrice(100.0);
        product.setCategory(category);

        categoryDao.create(category);
        productDao.create(product);

        System.out.println("Produit sauvegardé : " + product.getName());
        System.out.println("Caetgorie sauvegardé : " + category.getName());
    }
}