package ctrl.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import model.Auto;

@ApplicationScoped
public class AutoLogging {
	
	public void createAutoLogging(@Observes @Added Auto auto) {
		System.out.println(auto + " wurde erzeugt");
	}
	
	public void removeAutoLogging(@Observes @Removed Auto auto) {
		System.out.println(auto + " wurde entfernt");
	}
}
