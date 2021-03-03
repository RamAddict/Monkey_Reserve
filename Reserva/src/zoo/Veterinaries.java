package zoo;

import javax.swing.JOptionPane;

public class Veterinaries extends Persons {
	private int graduation;
	private Monkeys monkeysAssigned[] = new Monkeys[5];
	private int monkeyCounter = 0;

	public Veterinaries (String personName,int personAge, char personSex,double personSalary,int personID,int graduation,boolean veterinary) {
		super (personName,personAge,personSex,personSalary,personID,veterinary);
		this.veterinary = true;
		this.graduation = graduation;
	}

	public Veterinaries (String personName,int personAge, char personSex,double personSalary,int personID,boolean veterinary, int graduation, Monkeys designedMonkeys[], int monkeyCounter) {
		super (personName,personAge,personSex,personSalary,personID,veterinary);
		this.veterinary = true;
		this.graduation = graduation;
	}

	public boolean thereIsSpaceHere(){
		if(monkeyCounter<5) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addMonkeyCounter() {
		monkeyCounter++;
	}
	
	public String getGraduation() {
		switch(graduation) {
		case 1: return "Graduado.";
		case 2: return "Mestrado.";
		case 3: return "Doutorado.";
		case 4: return "Pós-Doutorado.";
		default: return "Erro";
		}
	}
	
	public boolean assignedMonkey(Monkeys monkey){
		if(monkeyCounter<5) {
			monkeysAssigned[monkeyCounter] = monkey;
			monkeyCounter++;
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Cada veterinário só pode cuidar de no máximo 5 macacos.");
			return false;
		}
	}
	
	public String isVeterinary() {
		return "Este funcionário é um veterinário de nível: "+getGraduation();
	}
	
	public boolean getVeterinary() {
		return true;
	}


}
