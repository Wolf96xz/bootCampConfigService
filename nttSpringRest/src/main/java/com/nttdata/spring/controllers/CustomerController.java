package com.nttdata.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.spring.repository.Customer;
import com.nttdata.spring.services.CustomerManagementServiceI;

/**
 * Formación - Spring - Taller 4
 * 
 * Controlador de clientes.
 * 
 * @author NTT Data Sevilla
 *
 */
@Controller
public class CustomerController {

	/** Servicio: gestión de clientes */
	@Autowired
	private CustomerManagementServiceI customerService;

	/**
	 * Muestra todos los clientes.
	 * 
	 * @param model
	 * @return String
	 */
	@GetMapping("/showCustomersView")
	public String showCustomers(Model model) {

		// Obtención de los clientes.
		final List<Customer> customersList = customerService.searchAllCustomers();

		// Carga de datos al modelo.
		model.addAttribute("customersList", customersList);
		model.addAttribute("btnDropCustomerEnabled", Boolean.FALSE);

		return ViewNames.CUSTOMERS_VIEW;
	}

	/**
	 * Elimina un cliente por ID.
	 * 
	 * @param customerId
	 * @return String
	 */
	@RequestMapping(path = "/actDropCustomer", method = RequestMethod.POST)
	public String deleteCustomer(@RequestParam String customerId) {

		// Se elimina el cliente por ID.
		customerService.deleteById(Long.valueOf(customerId));

		return ViewNames.REDIR_CUSTOMERS_C;
	}

	/**
	 * Añade un nuevo cliente.
	 * 
	 * @param newCustomer
	 * @param result
	 * @return String
	 */
	@PostMapping("/actAddCustomer")
	public String submitAddCustomerForm(@Valid @ModelAttribute Customer newCustomer, BindingResult result) {

		// Se añade el nuevo cliente.
		customerService.insertNewCustomer(newCustomer);

		return ViewNames.REDIR_CUSTOMERS_C;
	}


	@PostMapping("/actSearchCustomer")
	public String submitSearchCustomerForm(@ModelAttribute Customer searchedCustomer, Model model) {

		// Posibilidad de múltiples resultados.
		List<Customer> customersList = new ArrayList<Customer>();

		// Búsqueda por nombre o nombre completo.
		if (searchedCustomer != null) {

			// Obtención de filtro de búsqueda.
			final String name = searchedCustomer.getName();
			final String surName1 = searchedCustomer.getSurName1();
			final String surName2 = searchedCustomer.getSurName2();
			final String identityDocNumber = searchedCustomer.getIdentityDocNumber();

			if (StringUtils.hasText(identityDocNumber)) {

				// Búsqueda de cliente único por documento de identidad.
				searchedCustomer = customerService.searchByIdentityDocNumber(identityDocNumber);
				customersList.add(searchedCustomer);

			} else if (StringUtils.hasText(name) && (!StringUtils.hasText(surName1) || !StringUtils.hasText(surName2))) {

				// Búsqueda por nombre.
				customersList = customerService.searchByName(name);

			} else if (StringUtils.hasText(name) && StringUtils.hasText(surName1) && StringUtils.hasText(surName2)) {

				// Búsqueda por nombre completo.
				customersList = customerService.searchByFullName(name, surName1, surName2);
			}
		}

		// Carga de datos al modelo.
		model.addAttribute("customersList", customersList);
		model.addAttribute("btnDropCustomerEnabled", Boolean.TRUE);

		return ViewNames.CUSTOMERS_VIEW;
	}

}
