package Scrutineer.Participants;

import Scrutineer.Utils.DataSetGeneric;
import Scrutineer.Utils.Measurable;

public class Couple implements Measurable {
	private int coupleNum; // Add coupleNum field
	private DataSetGeneric<Person> couple = new DataSetGeneric<>();
	private Coach coach;

	public Couple() {

	}

	// Modify the constructor to accept coupleNum
	public Couple(int coupleNum, Dancer d1, Dancer d2) {
		this.coupleNum = coupleNum;
		couple.add(d1);
		couple.add(d2);
	}


	// Modify the constructor to accept coupleNum and Coach
	public Couple(int coupleNum, Dancer d1, Dancer d2, Coach c) {
		this.coupleNum = coupleNum;
		couple.add(d1);
		couple.add(d2);
		coach = c;
	}

	public int getCoupleNum() {
		return coupleNum;
	}

	public void setCoupleNum(int coupleNum) {
		this.coupleNum = coupleNum;
	}

	public DataSetGeneric<Person> getCouple() {
		return couple;
	}

	public void setCouple(DataSetGeneric<Person> couple) {
		this.couple = couple;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	// Add a method to add a coach to the couple
	public boolean addCoach(Coach coach) {
		boolean isAdded;
		if (couple.contains(coach)) {
			isAdded = false;
			System.out.print("This coach is already added");
		} else {
			couple.add(coach);
			coach.incrementNumberOfStudents();
			//coach.setCoupleNum(coupleNum);
			isAdded = true;
		}

		return isAdded;
	}

	// Add a method to remove a coach from the couple
	public boolean removeCoach(Coach coach) {
		boolean isRemoved;
		if (couple.contains(coach)) {
			couple.remove(coach);
			coach.decrementNumberOfStudents();
			//coach.setCoupleNum(0);
			isRemoved = true;
		} else {
			isRemoved = false;
			System.out.print("This coach is not in the couple");
		}

		return isRemoved;
	}

	// Add a method to add a dancer to the  couple make sure that the couple has no more than 2 dancers
	public boolean addDancer(Dancer dancer) {
		boolean isAdded;
		if (couple.contains(dancer)) {
			isAdded = false;
			System.out.print("This dancer is already added");
		} else if (couple.size() == 2) {
			isAdded = false;
			System.out.print("This couple already has 2 dancers");
		} else {
			couple.add(dancer);
			isAdded = true;
		}

		return isAdded;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Couple ").append(coupleNum).append(":\n");
		for (Person person : couple) {
			if (person instanceof Coach) {
				sb.append("\tCoach: ").append(person.toString()).append("\n");
			} else {
				sb.append("\tDancer: ").append(person.toString()).append("\n");
			}
		}
		return sb.toString();
	}

	@Override
	public int getMeasure() {
		int highestAge = 0;

		for (Person person : couple) {
			if (person instanceof Dancer) {
				Dancer dancer = (Dancer) person;
				int age = dancer.getAge();
				if (age > highestAge) {
					highestAge = age;
				}
			}
		}

		return highestAge;
	}
}
