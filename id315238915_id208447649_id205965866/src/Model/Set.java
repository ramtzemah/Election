package Model;

import java.util.ArrayList;

// Generic class
public class Set<T extends Citizen> {
	private ArrayList<T> list;

	public Set(T t) { // Full constructor
		list = new ArrayList<T>();
	}

	public Set() {// Default constructor
		list = new ArrayList<T>();
	}

	public ArrayList<T> getList() {
		return list;
	}

	public T get(int index) {
		return list.get(index);
	}

	public void AddObject(T t) { // Add to the list of citizens
		list.add(t);
	}

	public boolean CheckIfListContainObject(T t) { // A check that the citizen is no founder on the // list
		boolean iamhere = true;
		for (int i = 0; i < list.size(); i++) {
			if (t.getId() == list.get(i).getId()) {
				System.out.println("This citizen is already exist");
				iamhere = false;
			}
		}
		return iamhere;

	}

	public boolean CheckIfObjectCitizen(T t) { // Check that object are from citizen type
		if (t instanceof Citizen)
			return true;
		else
			System.out.println("the object is not a citizen");
		return false;

	}

	public boolean checkObject(T t) {
		if (CheckIfListContainObject(t) == true && CheckIfObjectCitizen(t) == true) {
			return true;
		}
		return false;
	}
}
