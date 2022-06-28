package ctrl;

import java.util.ArrayList;
import java.util.List;

public class Observable {

	private List<Observer> observers;
	
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
		this.notifyObservers();
	}
	
	public Observable() {
		observers = new ArrayList<Observer>();
	}
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		for(Observer obs:observers) {
			obs.update(message);
		}
	}
}
