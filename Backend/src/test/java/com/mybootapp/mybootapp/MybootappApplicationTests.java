package com.mybootapp.mybootapp;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import com.bankApp.model.Customer;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MybootappApplicationTests {

//	@LocalServerPort
//	private int port;
//	
//	private String baseUrl ="http://localhost:";
//	
//	private static RestTemplate restTemplate;
//	
//	@Autowired
//	private TestH2Repository h2Repository;
//	
//	@BeforeAll
//	public static void init() {
//		restTemplate = new RestTemplate();
//	}
//	
//	@BeforeEach
//	public void SetUp() {
//		baseUrl = baseUrl.concat(port+"").concat("/api/v1/customers");
//	}
//	
//	@Test
//	@Sql(statements = "DELETE FROM Bank_Cust WHERE id = 1", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//	public void testInseretCustomer() {
//		Customer c = new Customer(1, "koshango@gmail.com", "Koshang Oberoi", "Godam ki Talai", 150.0f, 650);
//		Customer response = restTemplate.postForObject(baseUrl, c, Customer.class);
//		assertEquals("Koshang Oberoi", response.getName());
//		assertEquals(150.0f,response.getBal());
//		assertEquals("Godam ki Talai", response.getAddress());
//		assertEquals(1, h2Repository.findAll().size());
//	}
//	
//	@Test
//	@Sql(statements = "INSERT INTO Bank_Cust(id, custemail, name, address, bal, CIBILscore) VALUES (4, 'koshango@gmail.com', 'Koshang Oberoi', 'Godam ki Talai', 150.0, 650)", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//	@Sql(statements = "DELETE FROM Bank_Cust WHERE id = 4", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//	public void testGetCustomer() {
//		List<Customer> customers = restTemplate.getForObject(baseUrl, List.class);
//		assertEquals(1, customers.size());
//		assertEquals(1, h2Repository.findAll().size());
//	}
//	
//	@Test
//	@Sql(statements = "INSERT INTO Bank_Cust(id, custemail, name, address, bal, CIBILscore) VALUES (3, 'koshango@gmail.com', 'Koshang Oberoi', 'Godam ki Talai', 150.0, 650)", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//	@Sql(statements = "DELETE FROM Bank_Cust WHERE id = 3", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//	public void testGetCustomerById() {
//		Customer c = restTemplate.getForObject(baseUrl+"/{custId}", Customer.class, 3);
//		assertAll(
//			() -> assertNotNull(c),
//			() -> assertEquals(3, c.getCustId())
//		);
//	}
//	
//	@Test
//	@Sql(statements = "INSERT INTO Bank_Cust(id, custemail, name, address, bal, CIBILscore) VALUES (12, 'koshango@gmail.com', 'Koshang Oberoi', 'Godam ki Talai', 150.0, 650)", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//	@Sql(statements = "DELETE FROM Bank_Cust WHERE id = 12", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//	public void testUpdate() {
//		Customer cust = new Customer(12, "koshango@gmail.com", "Oberoi", "Godam ki Talai", 150.0f, 650);
//		restTemplate.put(baseUrl, cust, Customer.class, 12);
//		Customer c = h2Repository.findById(12L).get();
//		assertAll(
//			() -> assertNotNull(c),
//			() -> assertEquals(12, c.getCustId())
//		);
//	}
//	
//	@Test
//	@Sql(statements = "INSERT INTO Bank_Cust(id, custemail, name, address, bal, CIBILscore) VALUES (5, 'koshango@gmail.com', 'Koshang Oberoi', 'Godam ki Talai', 150.0, 650)", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//	public void testDeleteCustomer() {
//		int recordCount = h2Repository.findAll().size();
//		assertEquals(1, recordCount);
//		restTemplate.delete(baseUrl+"/{custId}", 5);
//		assertEquals(0, h2Repository.findAll().size());
//	}
	
}
