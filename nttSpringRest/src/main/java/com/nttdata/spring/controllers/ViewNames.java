package com.nttdata.spring.controllers;

/**
 * Formación - Spring - Taller 4
 * 
 * Clase de constantes.
 * 
 * @author NTT Data Sevilla
 *
 */
public final class ViewNames {

	/** Vista asociada al menú */
	public static String MENU_VIEW = "systemMenu";
	
	/** Vista asociada al listado de clientes */
	public static String CUSTOMERS_VIEW = "showCustomers";
	
	/** Vista asociada al formulario de insercción de clientes */
	public static String ADD_CUSTOMER_VIEW = "newCustomer";
	
	/** Vista asociada al formulario de búsqueda de clientes */
	public static String SEARCH_CUSTOMER_VIEW = "searchCustomerBy";

	/** Controlador de clientes */
	public static String REDIR_CUSTOMERS_C = "redirect:showCustomersView";

	/** Mantener la vista */
	public static String SAME_VIEW = "/";
}
