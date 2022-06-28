package ctrl.cdi;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
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
public class AutoService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2753246121074809744L;

//	@Inject
//	private Auto auto;
	
	@Inject
	private InventoryService inventoryService;
	
	public void createAuto(Auto auto) {
		System.out.println(auto.getClass());
		System.out.println(auto + " createAuto");
		inventoryService.addAuto(auto);
	}
	
	public void createBenziner(Auto auto) {
		System.out.println(auto.getClass());
		System.out.println(auto + " createBenziner");
		inventoryService.addAuto(auto);
	}
	
	public void createDiesel(Auto auto) {
		auto.setMotor(new DieselMotor());
		System.out.println(auto.getClass());
		System.out.println(auto + " createDiesel");
		inventoryService.addAuto(auto);
	}
	

}
