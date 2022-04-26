package com.nttdata.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.spring.repository.Customer;
import com.nttdata.spring.repository.CustomerRepository;

/**
 * Formación - Spring - Taller 4
 * 
 * Servicio.
 * 
 * @author NTT Data Sevilla
 *
 */
@Service
public class CustomerManagementServiceImpl implements CustomerManagementServiceI {

	/** Repositorio - Tabla: T_CUSTOMER */
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer insertNewCustomer(Customer newCustomer) {

		// Verificación de nulidad.
		if (newCustomer != null && newCustomer.getId() == null) {

			// Insercción de cliente.
			newCustomer = customerRepository.save(newCustomer);
		}

		return newCustomer;
	}

	@Override
	public List<Customer> searchAllCustomers() {

		// Consulta clientes.
		final List<Customer> customerList = customerRepository.findAll();

		return customerList;
	}

	@Override
	public List<Customer> searchByFullName(final String name, final String surname1, final String surname2) {

		// Obtención del listado de clientes por nombre completo.
		final List<Customer> searchCustomers = customerRepository.findByNameAndSurName1AndSurName2(name, surname1, surname2);

		// Muestra el listado obtenido.
		return searchCustomers;
	}

	@Override
	public List<Customer> searchByName(final String name) {

		// Obtención del listado de clientes por nombre.
		final List<Customer> searchCustomers = customerRepository.findByName(name);

		return searchCustomers;
	}

	@Override
	public Customer searchByIdentityDocNumber(final String identityDocNumber) {

		// Obtención del listado de clientes por nombre.
		final Customer searchCustomer = customerRepository.findByIdentityDocNumber(identityDocNumber);

		return searchCustomer;
	}

	@Override
	public void deleteById(final Long customerId) {

		// Baja al cliente.
		this.customerRepository.deleteById(customerId);

	}

}
