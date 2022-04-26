package com.nttdata.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Formación - Spring - Taller 4
 * 
 * Repositorio.
 * 
 * @author NTT Data Sevilla
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	/**
	 * Obtención del cliente mediante el número de documento de identidad.
	 * 
	 * @param identityDocNumber
	 * @return Customer
	 */
	public Customer findByIdentityDocNumber(final String identityDocNumber);

	/**
	 * Obtención del cliente mediante el nombre.
	 * 
	 * @param name
	 * @return List<EverisClient>
	 */
	public List<Customer> findByName(final String name);

	/**
	 * Obtención del cliente mediante el nombre completo.
	 * 
	 * @param name
	 * @return List<Customer>
	 */
	public List<Customer> findByNameAndSurName1AndSurName2(final String name, final String surname1, final String surname2);

}
