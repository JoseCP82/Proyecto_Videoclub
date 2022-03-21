package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import dao.ClientDAO;
import dao.ItemDAO;
import dao.ReservationDAO;
import gui.Gui;
import model.Client;
import model.Item;
import model.Reservation;
import model.Status;

public class ReservationController {
	
	final String URL_CLI="clients.xml";
	Gui gui = new Gui();
	ReservationDAO rd = new ReservationDAO();
	
	/**
	 * Método que inicia el uso de la clase. Muestra el menú referente a las
	 * opciones de Reservas. Obtiene la opción elegida.
	 */
	public void run() {
		int option = -1;
		do {
			gui.showReservationMenu();
			option = gui.validateRangeInt("Elija una opción: ", 0, 5);
			switchOption(option);
			gui.showMessage("");
		} while (option != 0);	
	}

	/**
	 * Es elmenu de opciones, segun la opcion que eligas se podra introducir,
	 * buscar, eliminar o actualizar una reserva
	 * @param option
	 */
	public void switchOption(int option) {
		gui.showMessage("");
		switch (option) {
			case 1:
				insertReservation();
				break;
			case 2:			
				if(!rd.isEmpty()) {
					searchReservation();
				}
				else {
					gui.showMessage("No existen clientes aún.");
				}
				break;
			case 3:
				if(!rd.isEmpty()) {
					removeReservation();
				}
				else {
					gui.showMessage("No existen reservas aún.");
				}	
				break;
			case 4:
				if(!rd.isEmpty()) {
					updateReservation();
				}
				else {
					gui.showMessage("No existen reservas aún.");
				}
				break;
			case 5:
				if(!rd.isEmpty()) {
					gui.showMessage(rd.toString());
				}
				else {
					gui.showMessage("No existen reservas aún.");
				}
				break;
			case 0: 
				break;
			default:
				gui.showMessage("Opción incorrecta.");	
		}
	}
	
	/**
	 * inserta una nueva reserva con un cliente y articulo ya existentes,
	 * la fecha de entrega prevista sera un dia despues del que ha hecho
	 * la reserva
	 */
	private void insertReservation() {		
		ClientDAO cd = new ClientDAO();
		ItemDAO itd = new ItemDAO();
		String idCli = gui.validateDni("Introduzca el DNI del cliente: ");
		Client c = cd.searchClient(idCli);
		if(c!=null) {
			String idItem = gui.validateName("Introduzca el nombre del artículo: ");
			Item i = itd.searchItem(idItem); 
			if(i!=null) {
				String dateIni = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss").format(Calendar.getInstance().getTime());
				Calendar cNow = Calendar.getInstance();
				cNow.add(Calendar.DATE, 1);
				String dateEnd = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss").format(cNow.getTime());			
				if(rd.addReservation(new Reservation (dateIni, dateEnd, idCli, i.getName()))) {
					gui.showMessage("Reserva realizada correctamente.");
				}
				else {
					gui.showMessage("No se pudo realizar la reserva.");
				}
			}
			else {
				gui.showMessage("El articulo no existe.");
			}
		}
		else {
			gui.showMessage("El cliente no existe.");
		}
	}
	
	/**
	 * busca la reserva por su id, si lo encuentra muestra la reserva y si
	 * no hay una reserva con el id introucido muestra: "Cliente no Encontrado"
	 * @return el cliente encontrado o null si no lo encuentra
	 */
	public Reservation searchReservation() {
		String id = gui.readString("Inserte el nombre de la reserva a buscar: ");
		Reservation c=rd.searchReservation(id);
		if(c!=null) {
			gui.showMessage(c.toString());
		}
		else {
			gui.showMessage("Reserva no encontrada.");
		}
		return c;
	}
	
	/**
	 * busca la reserva que se quiere eliminar, si la encuentra la
	 * elimina y muestra: "Reserva eliminada correctamente" y si no
	 * la encuentra muestra: "No se ha podido eliminar la reserva
	 * @return
	 */
	public void removeReservation() {
		Reservation c= searchReservation();
		if(c!=null) {
			rd.removeReservation(c);
			gui.showMessage("Reserva eliminada correctamente");
		}else {
			gui.showMessage("No se ha podido eliminar la reserva");
		}
	}
	
	/**
	 * busca la reserva que se quiere actualizar y si la encuentra
	 * pone que el usuario ha entregado el articulo en la fecha actual,
	 * mostrara: "Reserva modificada correctamente", y si no la encuentra 
	 * mostrará: "No se ha podido modificar la reserva
	 */
	public void updateReservation(){
		Reservation c = searchReservation();
		if(c!=null) {
			String dateFinish = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss").format(Calendar.getInstance().getTime());
			rd.updateReservation(c.getId(), dateFinish, Status.INLOWRESERVE);
			gui.showMessage("Reserva modificada correctamente");
			gui.showMessage(c.toString());
		}else {
			gui.showMessage("No se ha podido modificar la reserva");
		}
	}
	
}

