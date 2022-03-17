package controller;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.*;
import java.util.Calendar;
import java.util.HashSet;

import gui.Gui;
import utils.IOUtils;
import model.Client;
import model.ClientStore;
import model.Item;
import model.Reservation;
import model.ReservationStore;
import model.itemStore;

public class ReservationController {
	Gui gui = new Gui();
	ReservationStore rs = new ReservationStore();
	
	
	public void run() {
		
		int option = -1;
		do {
			gui.showReservationMenu();
			option = utils.IOUtils.validaEntero("Elija una opción: ", 0, 4); //Modificar y usar el metodo de la clase Gui
			switchOption(option);
		} while (option != 0);
		new AppController().appInit();
	}
	
	/**
	 * Es elmenu de opciones, segun la opcion que eligas se podra introducir,
	 * buscar, eliminar o actualizar una reserva
	 * @param option
	 */
	public void switchOption(int option) {
		switch (option) {
		case 1:
			//se llama a insertReservation para introducir una reserva
			insertReservation();
			break;
		case 2:
			//si la ReservatioStore tiene alguna reserva llama al metodo 
			//searchReservation y busca la reserva
		/*
			if(!rs.isEmpty()) {
				searchReservation();
			}
			else {
				gui.showMessage("No existen clientes aún.");
			}
			*/
		case 3:
			//si la ReservatioStore tiene alguna reserva llama al metodo 
			//removeReservatio para eliminar la reserva
			/*
				if(!rs.isEmpty()) {
					removeReservation();
				}
				else {
					gui.showMessage("No existen reservas aún.");
				}
				*/
			break;
		case 4:
			//si la ReservatioStore tiene alguna reserva llama al metodo 
			//updateReservation para actualizar la reserva
			/*
				if(!rs.isEmpty()) {
					updateReservation();
				}
				else {
					gui.showMessage("No existen reservas aún.");
				}
				*/
			break;
		case 0: 
			break;
		default:
			// si el usuario se equivoca de opcion le mostrara lo siguiente:
			gui.showMessage("Opción incorrecta.");
			
		}
	}
	private void insertReservation() {
		
		HashSet<Client> clientes = new HashSet<Client>();
		HashSet<Item> items = new HashSet<Item>();		
		
		String id = gui.validateString("Inserte el id de la reserva: ");
		LocalDateTime dateIni = LocalDateTime.now();
		LocalDateTime dateEnd = LocalDateTime.now();
		dateEnd=dateEnd.plusDays(1);
		LocalDateTime dateFinished = null;
		/*
		ClientController cc = new ClientController();
		Client cli=cc.searchClient();
		ItemController ic = new ItemController();
		Item itm = itm.searchItem();
		*/
		
		
		
		
		
		if(rs.addReservation(new Reservation (id, dateIni, dateEnd, dateFinished, false, cli,itm ))) {
			gui.showMessage("Alta realizada correctamente.");
		}
		else {
			gui.showMessage("No se pudo dar de alta al cliente.");
		}
	}
	
	
	public Reservation searchReservation() {
		Reservation c=null;
		String id = gui.validateKey("Inserte el DNI del cliente a buscar: ");
		if(rs.searchReservation(id)!=null) {
			c=rs.searchReservation(id);
			gui.showMessage("" + c);
		}
		else {
			gui.showMessage("Cliente no encontrado.");
		}
		return c;
	}
	
	public Reservation removeReservation() {
		Reservation c= searchReservation();
		if(c!=null) {
			rs.removeReservation(c);
			gui.showMessage("Reserva eliminada correctamente");
		}else {
			gui.showMessage("No se ha podido eliminar la reserva");
		}
		return c;
	}
	
	public void updateReservation(){
		Reservation c= searchReservation();
		if(c!=null) {
			c.setDateFinished(LocalDateTime.now());
			//c.status
			gui.showMessage("Reserva modificada correctamente");
		}else {
			gui.showMessage("No se ha podido modificar la reserva");
		}
	}
	
	
	
	
	
	
	
	
	
	
}
