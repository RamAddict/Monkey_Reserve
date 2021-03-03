package zoo;

public class Finance {
	private double reserveBalance;
	private double monthlyInput;
	private double reserveInput;
	private double reserveOutput;
	
public Finance(double aReserveBalance, double aMonthlyInput) {
	reserveBalance = aReserveBalance;
	monthlyInput = aMonthlyInput;
}

public Finance() {
	
}

public double getReserveBalance() {
	return reserveBalance;
}

public double getReserveInput() {
	return reserveInput;
}

public double getReserveOutput() {
	return reserveOutput;
}

public void setReserveOutput(Monkeys newMonkeys[],int monkeyCont,Persons newPersons[],int personCont) {
	for(int i = 1;i<monkeyCont;i++) {
		reserveOutput += newMonkeys[i].getMonkeyUpKeep();
		
	}
	for(int i = 1;i<personCont;i++) {
		reserveOutput += newPersons[i].getPersonSalary();
	}
}
public double showReserveOutput(Monkeys newMonkeys[],int monkeyCont) {
	double op = reserveOutput;
	for(int i = 1;i<monkeyCont;i++) {
		op += newMonkeys[i].getMonkeyUpKeep();
	}
	return op;
}

public void setBalance() {
	reserveBalance += monthlyInput + reserveInput - reserveOutput;
}

public void resetMonth() {
	reserveInput = 0;
	reserveOutput = 0;
}

public void addReserveOutput(double addValue) {
	reserveOutput += addValue;
}

public void addReserveInput(double addValue) {
	reserveInput += addValue;
}

public String showMonthlyBalance() {
	String out;
	if(monthlyInput>reserveOutput) {
		out = "Saldo mensal positivo.";
	}
	else if(monthlyInput==reserveOutput) {
		out = "Saldo mensal neutro.";
	}
	else {
		out = "Saldo mensal negativo.";
	}
	return out;
	
}
}
