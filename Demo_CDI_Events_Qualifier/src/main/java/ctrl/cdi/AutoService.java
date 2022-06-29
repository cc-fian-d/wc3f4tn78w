package ctrl.cdi;

import java.io.Serializable;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.event.Event;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
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
	private Auto injectedAuto;// WeldClientProxy

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
		System.out.println(injectedAuto.getClass());
		System.out.println(injectedAuto + " createAuto");
//		inventoryService.addAuto(injectedAuto.clone());
		createEvent.fire(injectedAuto);// Achtung. Wenn CDI dann wird das Proxy-Objekt weitergeleitet
	}

//	public void createBenziner(Auto auto) {
	public void createBenziner() {// Weil mit CDI und Proxy Object wird auf die Clone Methode gesetzt
		System.out.println(injectedAuto.getClass());
		System.out.println("createBenziner : " + injectedAuto);
//		inventoryService.addAuto(injectedAuto.clone());
		createEvent.fire(injectedAuto);
	}

//	public void createDiesel(Auto auto) {
	public void createDiesel() {// Weil mit CDI und Proxy Object wird auf die Clone Methode gesetzt

		/**
		 * CDI 2.0
		 * 
		 * BeanManager erhalten wir über die CDI
		 * 
		 * Aus der CDI ziehen wir die Referenz auf das Injizierte Objekt
		 */
		BeanManager bm = CDI.current().getBeanManager();
		Set<Bean<?>> setOfBeans = bm.getBeans(Auto.class);
		Bean<Auto> bean = (Bean<Auto>) setOfBeans.iterator().next();

		System.out.println("bean :" + bean);
		System.out.println("bean.getName() :" + bean.getName());
		System.out.println("bean.getClass() :" + bean.getClass());
		System.out.println("bean.getBeanClass() :" + bean.getBeanClass());
		System.out.println("bean.getInjectionPoints() :" + bean.getInjectionPoints());
		System.out.println("bean.getQualifiers() :" + bean.getQualifiers());

		/**
		 * Holen wir aus den BeanManager mit der Bean und dem CreationalContext die
		 * Referenz auf die Injizierte Bean
		 */
		CreationalContext<Auto> ctx = bm.createCreationalContext(bean);
		Auto restoredReference = (Auto) bm.getReference(bean, Auto.class, ctx);
		
		System.out.println("restoredReference.getClass()" + restoredReference.getClass());
		
		System.out.println("ohne BeanManager");
		injectedAuto.setMotor(new DieselMotor());
		System.out.println(injectedAuto.getClass());
		System.out.println(injectedAuto + " createDiesel");
//		inventoryService.addAuto(injectedAuto.clone());
//		createEvent.fire(injectedAuto);
		createEvent.fire(restoredReference);
	}

}
