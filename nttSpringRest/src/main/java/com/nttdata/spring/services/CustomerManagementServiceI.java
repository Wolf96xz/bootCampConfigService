package com.nttdata.spring.services;

import java.util.List;

import com.nttdata.spring.repository.Customer;

/**
 * Formación - Spring - Taller 4
 * 
 * Servicio.
 * 
 * @author NTT Data Sevilla
 *
 */
public interface CustomerManagementServiceI {

	/**
	 * Añade un nuevo cliente.
	 * 
	 * @param newCustomer
	 * @return Customer
	 */
	public Customer insertNewCustomer(final Customer newCustomer);

	/**
	 * Consulta todos los clientes.
	 * 
	 * @return List<Customer>
	 */
	public List<Customer> searchAllCustomers();

	/**
	 * Búsqueda por nombre completo.
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @return List<Customer>
	 */
	public List<Customer> searchByFullName(final String name, final String surname1, final String surname2);

	/**
	 * Búsqueda por nombre.
	 * 
	 * @param name
	 * @return List<Customer>
	 */
	public List<Customer> searchByName(final String name);

	/**
	 * Obtención del cliente mediante el número de documento de identidad.
	 * 
	 * @param identityDocNumber
	 * @return Customer
	 */
	public Customer searchByIdentityDocNumber(final String identityDocNumber);

	/**
	 * Borrar por ID.
	 * 
	 * @param customerId
	 */
	public void deleteById(final Long customerId);

}
