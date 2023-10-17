package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository){
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Customer stan = new Customer();
        stan.setFirstName("Stan");
        stan.setLastName("Bee");
        stan.setAddress("123 Street Lane");
        stan.setPostal_code("97478");
        stan.setPhone("8088088008");


        Customer megan = new Customer();
        megan.setFirstName("Megan");
        megan.setLastName("Mck");
        megan.setAddress("251 Burger Ave");
        megan.setPostal_code("97477");
        megan.setPhone("5505505550");

        Customer cy = new Customer();
        cy.setFirstName("Cy");
        cy.setLastName("Hauck");
        cy.setAddress("351 Royal Ln");
        cy.setPostal_code("97476");
        cy.setPhone("5415415411");



        Customer marcus = new Customer();
        marcus.setFirstName("Marcus");
        marcus.setLastName("Kick");
        marcus.setAddress("Flint Water Ave");
        marcus.setPostal_code("97475");
        marcus.setPhone("2599638520");


        Customer aidan = new Customer();
        aidan.setFirstName("Aidan");
        aidan.setLastName("Demp");
        aidan.setAddress("Atlanda");
        aidan.setPostal_code("97474");
        aidan.setPhone("1011011001");


        customerRepository.save(stan);
        customerRepository.save(megan);
        customerRepository.save(cy);
        customerRepository.save(marcus);
        customerRepository.save(aidan);
    }

}
