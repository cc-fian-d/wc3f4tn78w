package ctrl.jsf;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LifeCycleListener implements PhaseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent after) {
		System.out.println("\n\n------ afterPhase ------");
		System.out.println(after.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent before) {
		System.out.println("\n\n------ beforePhase ------");
		System.out.println(before.getPhaseId());
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
