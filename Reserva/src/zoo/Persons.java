package zoo;

public class Persons {
	private String personName;
	private int personAge;
	private char personSex;
	private double personSalary;
	private int personID;
	protected boolean veterinary;

	public Persons() {
		this.personID = 0;
	}

	public Persons(String personName,int personAge, char personSex, double personSalary,int personID,boolean veterinary) {
		this.personName = personName;
		this.personAge = personAge;
		this.personSex = personSex;
		this.personSalary = personSalary;
		this.personID = personID;
		this.veterinary = veterinary;

	}

	public Persons voidPerson(){
		personName = "Inexistência.";
		personAge = 0;
		personSex = 'i';
		personSalary = 0;
		personID = 0;
		Persons aPerson = new Persons(personName,personAge,personSex,personSalary,personID,false);
		return aPerson;
	}

	public String getPersonName() {
		return personName;
	}

	public int getPersonID() {
		return personID;
	}

	public int getPersonAge() {
		return personAge;
	}

	public String getPersonSex() {
		String answer;
		if(personSex == 'f') {answer = "Feminino";}
		else {answer = "Masculino";}
		return answer;
	}
	public double getPersonSalary() {
		return personSalary;
	}
	public boolean getExistence() {
		if(personID == 0) return false;
		else return true;
	}
	public void firePerson() {
		personID = 0;
	}
	public boolean getVeterinary() {
		return false;
	}

	public String isVeterinary() {
		return "Este funcionário não é um veterinário.";
	}

	public boolean thereIsSpaceHere(){
		return false;
	}
	public void addMonkeyCounter() {
	}
}
