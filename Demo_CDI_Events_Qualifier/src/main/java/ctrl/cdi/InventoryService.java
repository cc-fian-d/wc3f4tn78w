package ctrl.cdi;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;

import model.Auto;

@ApplicationScoped
@Named("inventory")
public class InventoryService {

	private List<Auto> autos;

	public List<Auto> getAutos() {
		return autos;
	}

	public void setAutos(List<Auto> autos) {
		this.autos = autos;
	}

	public InventoryService() {
		autos = new ArrayList<Auto>();
	}
	
	public void addAuto(@Observes @Inventory Auto auto) {
		System.out.println("Auto wird eingelagert");
		autos.add(auto);
	}
	
	public void removeAuto(Auto auto) {
		System.out.println("Auto wird entfernt");
		autos.remove(auto);
	}
	
}
