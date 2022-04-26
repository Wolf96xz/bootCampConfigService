package com.nttdata.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Formación - Spring - Taller 4
 * 
 * Controlador principal.
 * 
 * @author NTT Data Sevilla
 *
 */
@Controller
@RequestMapping("*")
public class SystemController {

	/**
	 * Capta cualquier solicitud y muestra el menú.
	 * 
	 * @return String
	 */
	/*
	@GetMapping("/*")
	public String showMenu() {
		return ViewNames.MENU_VIEW;
	}
/*
	/**
	 * Redirecciona al controlador encargado de los clientes.
	 * 
	 * @return String
	 */
	@GetMapping("/customersView")
	public String redirectToCustomerController() {
		return ViewNames.REDIR_CUSTOMERS_C;
	}

	/**
	 * Redirecciona a la vista de insercción de cliente.
	 * 
	 * @return String
	 */
	@GetMapping("/newCustomerView")
	public String addNewCustomer() {
		return ViewNames.ADD_CUSTOMER_VIEW;
	}

	/**
	 * Redirecciona a la vista de búsqueda de clientes.
	 * 
	 * @return String
	 */
	@GetMapping("/searchCustomerByView")
	public String searchCustomer() {
		return ViewNames.SEARCH_CUSTOMER_VIEW;
	}

}
