package ctrl.cdi;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import model.Auto;
import model.BenzinMotor;
import model.DieselMotor;
import model.Motor;
import model.Reifen;

/**
 * Es soll nur eine Instanz von AutoService in der Applikation verhanden sein.
 *
 */
@ApplicationScoped
@Named("autoservice")
public class AutoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2753246121074809744L;

	@Inject
	private Auto auto;// WeldClientProxy

//	@Inject
//	private InventoryService inventoryService;
	
	@Inject
	@Added
	@Inventory
	private Event<Auto> createEvent;
	
	@Inject
	@Removed
	private Event<Auto> removeEvent;

//	public void createAuto(Auto auto) {
	public void createAuto() {// Weil mit CDI und Proxy Object wird auf die Clone Methode gesetzt
		System.out.println(auto.getClass());
		System.out.println(auto + " createAuto");
//		inventoryService.addAuto(auto.clone());
		createEvent.fire(auto);//Achtung. Wenn CDI dann wird das Proxy-Objekt weitergeleitet
	}

//	public void createBenziner(Auto auto) {
	public void createBenziner() {// Weil mit CDI und Proxy Object wird auf die Clone Methode gesetzt
		System.out.println(auto.getClass());
		System.out.println(auto + " createBenziner");
//		inventoryService.addAuto(auto.clone());
		createEvent.fire(auto);
	}

//	public void createDiesel(Auto auto) {
	public void createDiesel() {// Weil mit CDI und Proxy Object wird auf die Clone Methode gesetzt
		auto.setMotor(new DieselMotor());
		System.out.println(auto.getClass());
		System.out.println(auto + " createDiesel");
//		inventoryService.addAuto(auto.clone());
		createEvent.fire(auto);
	}

}
