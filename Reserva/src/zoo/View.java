package zoo;

import javax.swing.JOptionPane;
public class View {
	private int mainMenu, reserveMenu, financialMenu, personalMenu, monkeyCont = 1, personCont = 1;
	public View() {
	}
	public View(int monkeyCont, int personCont) {
		this.monkeyCont = monkeyCont;
		this.personCont = personCont;
	}


	public boolean validateInput(String entry, int Integer) {
		boolean valid = true;
		if (entry.equals(null) || entry.equals("")) {
			valid = false;
		}
		for (int i = 0; i < entry.length(); i++) {
			if (entry.charAt(i) != '0' && entry.charAt(i) != '1' && entry.charAt(i) != '2' &&
					entry.charAt(i) != '3' && entry.charAt(i) != '4' && entry.charAt(i) != '5' &&
					entry.charAt(i) != '6' && entry.charAt(i) != '7' && entry.charAt(i) != '8' &&
					entry.charAt(i) != '9') {
				valid = false;
			}
		}
		if (valid == false) JOptionPane.showMessageDialog(null, "Número inválido.\nDigite um número inteiro.");
		return valid;
	}

	public boolean validateInput(String entry, double Double) {
		int counter = 0;
		boolean valid = true;
		counter = 0;
		if (entry.equals(null) || entry.equals("") || entry.charAt(0) == '.' || entry.charAt(0) == ',') {
			valid = false;
		}
		entry = entry.replace(',', '.');
		for (int i = 0; i < entry.length(); i++) {

			if (entry.charAt(i) == '.') {
				counter++;
			}
			if (entry.charAt(i) != '0' && entry.charAt(i) != '1' && entry.charAt(i) != '2' &&
					entry.charAt(i) != '3' && entry.charAt(i) != '4' && entry.charAt(i) != '5' &&
					entry.charAt(i) != '6' && entry.charAt(i) != '7' && entry.charAt(i) != '8' &&
					entry.charAt(i) != '9' && entry.charAt(i) != '.') {
				valid = false;
			}
		}
		if (counter > 1) valid = false;
		if (valid == false) JOptionPane.showMessageDialog(null, "Número inválido.\nDigite um número real.");
		return valid;
	}

	public boolean validateInput(String entry, char Character) {
		if (entry.equals("")) {
			return false;
		}
		entry.toLowerCase();
		if (entry.equals("f") || entry.equals("m")) {
			return true;
		} else {
			return false;
		}
	}

	public int arrayMonkeySize() {
		String entry;
		do {
			entry = JOptionPane.showInputDialog("Digite a quantidade máxima de macacos: " );
			if(validateInput(entry,monkeyCont) && Integer.parseInt(entry) < 1) JOptionPane.showMessageDialog(null, "Digite um número maior que 0"); 
		}while(!validateInput(entry,monkeyCont) || (validateInput(entry,monkeyCont) && Integer.parseInt(entry) < 1));
		return Integer.parseInt(entry)+1;
	}

	public int arrayPersonSize() {
		String entry;
		do {
			entry = JOptionPane.showInputDialog("Digite a quantidade máxima de funcionários: " );
			if(validateInput(entry,personCont) && Integer.parseInt(entry) < 1) JOptionPane.showMessageDialog(null, "Digite um número maior que 0"); 
		}while(!validateInput(entry,personCont) || (validateInput(entry,personCont) && Integer.parseInt(entry) < 1));
		return Integer.parseInt(entry)+1;
	}

	public void arrayOverFlow() {
		JOptionPane.showMessageDialog(null, "#ERRO:\nNúmero insuficiente de veterinários ou Capacidade máxima de cadastros excedida.");
	}

	public boolean checkEmptyMonkeys(Monkeys monkeys[]) {
		for(int i = 0;i<999;i++) {
			if(monkeys[i].getExistence()) return true;
		}
		return false;

	}

	public boolean thereIsVeterinaries(Persons persons[]) {
		for(int i = 1;i<999;i++) {
			if(persons[i].getVeterinary() && persons[i].thereIsSpaceHere() && persons[i].getPersonID() != 02) {
				return true;
			}
		}
		return false;
	}

	public boolean checkEmptyPersons() {
		if(personCont <= 1) {
			JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada.");
			return false;
		}
		else return true;

	}

	public boolean isIDMonkeyAvailable(String entry, Monkeys monkeys[]) {
		if(!validateInput(entry,monkeyCont)) {JOptionPane.showMessageDialog(null, "ID indisponível");return false;}
		int ID = Integer.parseInt(entry);
		if(ID == 0) {JOptionPane.showMessageDialog(null,"O ID deve ser diferente de 0"); return false;}
		for(int i = 1;i<999;i++) {
			if(ID == monkeys[i].getMonkeyID()) {JOptionPane.showMessageDialog(null, "ID indisponível");return false;}
		}
		return true;
	}

	public boolean isIDPersonAvailable(String entry, Persons persons[]) {
		if(!validateInput(entry,monkeyCont)) {JOptionPane.showMessageDialog(null, "ID indisponível");return false;}
		int ID = Integer.parseInt(entry);
		if(ID == 0) {JOptionPane.showMessageDialog(null,"O ID deve ser diferente de 0");return false;}
		for(int i = 1;i<999;i++) {
			if(ID == persons[i].getPersonID()) {JOptionPane.showMessageDialog(null, "ID indisponível");return false;}
		}
		return true;
	}

	public int mainMenu(String month, String balance, String status, boolean testMode) {
		String entry;
		do {
			do {
				if (testMode) {
					entry = JOptionPane.showInputDialog("RESERVA DE MACACOS  (modo teste)\nMês: " + month + "\nStatus lotação: " + status + "\n"+ balance+"\n\nMenu Principal." + "\n1- Manutenção da Reserva." + "\n2- Financeiro." + "\n3- Gerenciamento Pessoal." + "\n4- Sair da versão de testes." + "\n5- Sair.");
				} else {
					entry = JOptionPane.showInputDialog("RESERVA DE MACACOS\nMês: " + month + "\nStatus lotação: " + status + "\n"+ balance+"\n\nMenu Principal." + "\n1- Manutenção da Reserva." + "\n2- Financeiro." + "\n3- Gerenciamento Pessoal." + "\n4- Iniciar versão de testes." + "\n5- Sair.");
				}
			} while (validateInput(entry, monkeyCont) == false);
			mainMenu = Integer.parseInt(entry);
		} while (mainMenu != 5 && mainMenu != 4 && mainMenu != 3 && mainMenu != 2 && mainMenu != 1);
		return mainMenu;
	}

	public int reserveMenu(String month, String balance, String status) {
		String entry;

		do {
			do {
				entry = JOptionPane.showInputDialog("RESERVA DE MACACOS\nMês: " + month + "\nStatus lotação: " + status + "\n"+ balance+"\n\nManutenção da Reserva." + "\n1- Cadastrar novo macaco." + "\n2- Mostrar relatório geral de um macaco." + "\n3- Mostrar prontuário de um macaco." + "\n4- Alterar dados de um macaco." + "\n5- Alterar dados de um prontuário." + "\n6- Declarar morte de macaco." + "\n7- Mostrar listagem de macacos." + "\n8- Voltar.");
			} while (validateInput(entry, reserveMenu) == false);
			reserveMenu = Integer.parseInt(entry);
		} while (reserveMenu != 1 && reserveMenu != 2 && reserveMenu != 3 && reserveMenu != 4 && reserveMenu != 5 && reserveMenu != 6 && reserveMenu != 7 && reserveMenu != 8);
		return reserveMenu;
	}

	public int financialMenu(String month, String balance, String status) {
		String entry;
		do {
			do {
				entry = JOptionPane.showInputDialog("RESERVA DE MACACOS\nMês: " + month + "\nStatus lotação: " + status + "\n"+ balance+"\n\nMenu Financeiro." + "\n1- Iniciar novo caixa." + "\n2- Mostrar saldo." + "\n3- Mostrar gastos." + "\n4- Fechar balanço." + "\n5- Adicionar gasto." + "\n6- Adicionar receita." + "\n7- Voltar.");
			} while (validateInput(entry, financialMenu) == false);
			financialMenu = Integer.parseInt(entry);
		} while (financialMenu > 7 || financialMenu < 1);
		return financialMenu;
	}

	public int personalMenu(String month, String balance, String status) {
		String entry;
		do {
			do {
				entry = JOptionPane.showInputDialog("RESERVA DE MACACOS\nMês: " + month + "\nStatus lotação: " + status + "\n"+ balance+"\n\nRecursos Humanos." + "\n1- Cadastrar funcionário." + "\n2- Mostrar relatório de um funcionário." + "\n3- Alterar dados de um funcionário." + "\n4- Demitir funcionário." + "\n5- Mostrar listagem de funcionários." + "\n6- Voltar.");
			} while (validateInput(entry, personalMenu) == false);
			personalMenu = Integer.parseInt(entry);
		} while (personalMenu > 6 || personalMenu < 1);
		return personalMenu;
	}

	public boolean isVeterinary(int personID, Persons persons[]) {
		for(int i = 1;i<personCont;i++) {
			if(persons[i].getPersonID() == personID && persons[i].getVeterinary()) {
				return true;
			}
		}
		return false;
	}

	public Monkeys registerMonkey(Monkeys monkeys[], Persons persons[]) {
		String entry;
		double monkeyWeight = 0;
		String monkeyName = JOptionPane.showInputDialog("Digite o nome do macaco: #" + monkeyCont);
		int monkeyID = 0;
		do {
			entry = JOptionPane.showInputDialog("Digite o ID deste macaco.");
		}while(!isIDMonkeyAvailable(entry,monkeys));
		monkeyID = Integer.parseInt(entry);
		do {
			entry = JOptionPane.showInputDialog("Digite a idade deste macaco.");
		} while (validateInput(entry, monkeyCont) == false);
		int monkeyAge = Integer.parseInt(entry);
		do {
			entry = JOptionPane.showInputDialog("Digite o peso deste macaco.");
		} while (validateInput(entry, monkeyWeight) == false);
		monkeyWeight = Double.parseDouble(entry);
		String monkeySpecies = JOptionPane.showInputDialog("Digite a espécie deste macaco.");
		int caretaker = 0;
		boolean valid = true;
		do {
			valid = true;
			int which;
			do {
				entry = JOptionPane.showInputDialog("Digite o ID do veterinário que ficará responsável por este macaco.");
			}while(!validateInput(entry,monkeyCont));
			which = Integer.parseInt(entry);
			if(!isVeterinary(which,persons)) {
				JOptionPane.showMessageDialog(null, "Digite um ID referente a um veterinário cadastrado.");
				valid = false;
			}
			else if(!persons[which].thereIsSpaceHere()) {
				JOptionPane.showMessageDialog(null, "Este veterinário já chegou em sua capacidade máxima de macacos.");
				valid = false;
			}
		}while(!valid);
		
		caretaker = Integer.parseInt(entry);
		String diseases = JOptionPane.showInputDialog("Caso este macaco tenha uma doença contagiosa, especifique-a.");
		String observations = JOptionPane.showInputDialog("Informações adicionais sobre este macaco.");
		do {
			entry = JOptionPane.showInputDialog("Avalie os gastos adicionais necessários deste macaco.\n (Digite um inteiro entre [0, 10], sendo 0 nenhum gasto e 10 o máximo de gastos.)");
		} while (validateInput(entry, monkeyCont) == false);
		int medicalGrade = Integer.parseInt(entry);
		do {
			entry = JOptionPane.showInputDialog("Qual gasto médio mensal deste macaco?");
		} while (validateInput(entry, monkeyWeight) == false);
		double upKeep = Double.parseDouble(entry);
		boolean agressive;
		if (JOptionPane.showConfirmDialog(null, "Este macaco tem histórico de agressividade?") == 0) {
			agressive = true;
		} else {
			agressive = false;
		}
		MedicalRecords monkeyRecord = new MedicalRecords(caretaker,agressive, diseases, observations, upKeep, medicalGrade);

		Monkeys aMonkey = new Monkeys(monkeyName, monkeyAge, monkeyWeight, monkeyRecord, monkeySpecies, monkeyID);
		monkeyCont++;
		return aMonkey;
	}

	public Persons registerPerson(Persons persons[]) {
		String entry;
		String personName = JOptionPane.showInputDialog("Digite o nome do novo funcionário(#" + personCont + "):");
		int personID = 0;
		do {
			entry = JOptionPane.showInputDialog("Digite o ID deste funcionário.");
		}while(!isIDPersonAvailable(entry,persons));
		personID = Integer.parseInt(entry);
		do {
			entry = JOptionPane.showInputDialog("Digite a idade deste funcionário: ");
		} while (validateInput(entry, monkeyCont) == false);
		int personAge = Integer.parseInt(entry);
		char personSex = 'X';
		do {
			entry = JOptionPane.showInputDialog("Digite o sexo deste funcionário:\nM para masculino.\nF para feminino.");

			if (!validateInput(entry, personSex)) JOptionPane.showMessageDialog(null, "Entrada inválida. Digite M ou F.");
		} while (!validateInput(entry, personSex));
		personSex = entry.charAt(0);
		double personSalary = 0;
		do {
			entry = JOptionPane.showInputDialog("Digite o salário do novo funcionário: ");
		} while (!validateInput(entry, personSalary));

		personSalary = Double.parseDouble(entry);
		if(JOptionPane.showConfirmDialog(null, "Este funcionário é um veterinário?")==0) {
			int graduation;
			do {
				do {
					entry = JOptionPane.showInputDialog("Digite o número referente a graduação deste veterinário. "
							+ "\n1- Graduado."
							+ "\n2- Mestrado."
							+ "\n3- Doutorado."
							+ "\n4- Pós-Doutorado.");
				}while(!validateInput(entry,personCont));
				graduation = Integer.parseInt(entry);
			}while(graduation < 1 || graduation > 4);
			graduation = Integer.parseInt(entry);
			Veterinaries aPerson = new Veterinaries(personName, personAge, personSex, personSalary, personID, graduation,true);
			personCont++;
			return aPerson;
		}
		else {
			Persons aPerson = new Persons(personName, personAge, personSex, personSalary, personID,false);
			personCont++;
			return aPerson;
		}
	}

	public Monkeys updateMonkey(int ID, MedicalRecords aMedicalRecord) {
		String entry, monkeyName, monkeySpecies;
		int monkeyAge = 0;
		double monkeyWeight = 0;
		monkeyName = JOptionPane.showInputDialog("Alterar dados do macaco: #" + ID + "\nDigite o nome do macaco.");
		do {
			entry = JOptionPane.showInputDialog("Digite a idade deste macaco.");
		} while (validateInput(entry, monkeyCont) == false);
		monkeyAge = Integer.parseInt(entry);
		do {
			entry = JOptionPane.showInputDialog("Digite o peso deste macaco.");
		} while (validateInput(entry, monkeyWeight) == false);
		monkeyWeight = Double.parseDouble(entry);
		monkeySpecies = JOptionPane.showInputDialog("Digite a espécie deste macaco.");
		int monkeyID = ID;
		Monkeys aMonkey = new Monkeys(monkeyName, monkeyAge, monkeyWeight, aMedicalRecord, monkeySpecies, monkeyID);
		return aMonkey;
	}

	public Persons updatePerson(Persons persons[]) {
		String personName, entry;
		int personAge = 0;
		double personSalary = 0;
		char personSex;
		personName = JOptionPane.showInputDialog("Digite novo nome: ");
		do {
			do {
				entry = JOptionPane.showInputDialog("Digite o ID deste funcionário.");
			}while(!validateInput(entry,personCont));
		}while(!isIDPersonAvailable(entry,persons));
		int personID = Integer.parseInt(entry);
		do {
			entry = JOptionPane.showInputDialog("Atualize a idade do funcionário: ");
		} while (validateInput(entry, monkeyCont) == false);
		personAge = Integer.parseInt(entry);
		do {
			personSex = JOptionPane.showInputDialog("Atualize o sexo deste funcionário:\nM para masculino.\nF para feminino.").toLowerCase().charAt(0);
		} while (personSex != 'f' && personSex != 'm');
		do {
			entry = JOptionPane.showInputDialog("Atualize o salário do novo funcionário: ");
		} while (validateInput(entry, personSalary) == false);
		personSalary = Double.parseDouble(entry);
		if(JOptionPane.showConfirmDialog(null, "Este funcionário é um veterinário?")==0) {
			int graduation;
			do {
				do {
					entry = JOptionPane.showInputDialog("Digite o número referente a graduação deste veterinário. "
							+ "\n1- Graduado."
							+ "\n2- Mestrado."
							+ "\n3- Doutorado."
							+ "\n4- Pós-Doutorado.");
				}while(!validateInput(entry,personCont));
				graduation = Integer.parseInt(entry);
			}while(graduation < 1 || graduation > 4);
			Veterinaries aPerson = new Veterinaries(personName, personAge, personSex, personSalary, personCont, graduation,true);
			return aPerson;
		}
		else {
			Persons aPerson = new Persons(personName, personAge, personSex, personSalary, personID,false);
			return aPerson;
		}
	}

	public MedicalRecords updateMedicalRecords(int ID,Persons persons[]) {
		String diseases, observations, entry;
		int medicalGrade = 0,caretaker = 0;;
		double upKeep = 0;
		boolean valid = true;
		do {
			valid = true;
			int which;
			do {
				entry = JOptionPane.showInputDialog("Digite o ID do veterinário que ficará responsável por este macaco.");
			}while(!validateInput(entry,monkeyCont));
			which = Integer.parseInt(entry);
			if(!isVeterinary(which,persons)) {
				JOptionPane.showMessageDialog(null, "Digite um ID referente a um veterinário cadastrado.");
				valid = false;
			}
			else if(!persons[which].thereIsSpaceHere()) {
				JOptionPane.showMessageDialog(null, "Este veterinário já chegou em sua capacidade máxima de macacos.");
				valid = false;
			}
		}while(!valid);
		caretaker = Integer.parseInt(entry);
		diseases = JOptionPane.showInputDialog("Caso este macaco tenha uma doença contagiosa, especifique-a.");
		observations = JOptionPane.showInputDialog("Informações adicionais sobre este macaco.");
		do {
			entry = JOptionPane.showInputDialog("Avalie os gastos adicionais necessários deste macaco.\n (Digite um inteiro entre [0, 10], sendo 0 nenhum gasto e 10 o máximo de gastos.)");
		} while (validateInput(entry, monkeyCont) == false);
		medicalGrade = Integer.parseInt(entry);
		do {
			entry = JOptionPane.showInputDialog("Digite o gasto minimo mensal deste macaco.");
		} while (validateInput(entry, upKeep) == false);
		upKeep = Double.parseDouble(entry);
		boolean agressive;
		if (JOptionPane.showConfirmDialog(null, "Este macaco tem histórico de agressividade?") == 0) {
			agressive = true;
		} else {
			agressive = false;
		}
		MedicalRecords monkeyRecord = new MedicalRecords(caretaker, agressive, diseases, observations, upKeep, medicalGrade);
		return monkeyRecord;
	}

	public int getMonkeyCont() {
		return monkeyCont;
	}

	public int getPersonCont() {
		return personCont;
	}

	public void reportMonkey(Monkeys aMonkey) {
		JOptionPane.showMessageDialog(null, "Relatório do Macaco: " + aMonkey.getMonkeyName() + " #" + aMonkey.getMonkeyID() + "\nIdade: " + aMonkey.getMonkeyAge() + "\nPeso: " + aMonkey.getMonkeyWeight() + "\nCusto Mensal: " + aMonkey.getMonkeyUpKeep() + "\nEspécie: " + aMonkey.getMonkeySpecies());
	}

	public void reportPerson(Persons aPerson) {
		JOptionPane.showMessageDialog(null, "RELATÓRIO DO FUNCIONÁRIO: " + aPerson.getPersonName() + " #" + aPerson.getPersonID() 
		+ "\n"+ aPerson.isVeterinary()
		+ "\nIdade: " + aPerson.getPersonAge() 
		+ "\nSexo: " + aPerson.getPersonSex() 
		+ "\nSalario: " + aPerson.getPersonSalary());
	}

	public void medicalReportMonkey(MedicalRecords aMedicalRecord) {
		JOptionPane.showMessageDialog(null, "-Relatório Médico:"
				+ "\nDoenças: " + aMedicalRecord.getDiseases() 
				+ "\n" + aMedicalRecord.getAgressive() 
				+ "\nObservações: " + aMedicalRecord.getObservations()
				+ "\nNível de gasto adicional([0,10]): " + aMedicalRecord.getMedicalGrade() 
				+ "\nGasto mínimo mensal: " + aMedicalRecord.getUpKeep());
	}

	public void showMonkeys(Monkeys monkeys[]) {
		String out = "Listagem de Macacos Cadastrados: \n Nomes                   ID\n";
		for (int i = 1; i < monkeyCont; i++) {
			if(monkeys[i].getExistence()) {
				out += "Nome: " + monkeys[i].getMonkeyName() + "  #" + monkeys[i].getMonkeyID() + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, out);
	}

	public void showPersons(Persons persons[]) {
		String out = "Listagem de Funcionários Cadastrados: \n Nomes                   ID\n";
		for (int i = 1; i < personCont; i++) {
			if(persons[i].getExistence()) {
				out += "Nome: " + persons[i].getPersonName() + "  #" + persons[i].getPersonID() + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, out);
	}


	public int whichMonkey(Monkeys monkeys[]) {
		String entry;
		do {
			do {
				entry = JOptionPane.showInputDialog("Digite o ID referente ao macaco:");
			}while(!validateInput(entry,monkeyCont));
			for(int i = 0;i<999;i++) {
				if(Integer.parseInt(entry) == monkeys[i].getMonkeyID() && Integer.parseInt(entry) != 0) return i;
			}
			JOptionPane.showMessageDialog(null, "ERRO: Macaco não cadastrado.");
		}while(true);
	}

	public int whichPerson(Persons persons[]) {
		String entry;
		do {
			do {
				entry = JOptionPane.showInputDialog("Digite o ID referente a pessoa:");
			}while(!validateInput(entry,personCont));
			for(int i = 0;i<999;i++) {
				if(Integer.parseInt(entry) == persons[i].getPersonID() && Integer.parseInt(entry) != 0) return i;
			}
			JOptionPane.showMessageDialog(null, "ERRO: Pessoa não cadastrado.");
		}while(true);

	}


	public Finance newBalance() {
		String entry;
		double reserveBalance = 0;
		do {
			entry = JOptionPane.showInputDialog("INICIANDO CAIXA: \nDigite o saldo inicial da reserva: ");
		} while (validateInput(entry, reserveBalance) == false);
		reserveBalance = Double.parseDouble(entry);
		do {
			entry = JOptionPane.showInputDialog("Digite a entrada mensal fixa da reserva: ");
		} while (validateInput(entry, reserveBalance) == false);
		double monthlyInput = Double.parseDouble(entry);
		Finance aFinance = new Finance(reserveBalance, monthlyInput);
		return aFinance;
	}

	public void showBalance(Finance aFinance, Monkeys newMonkeys[], int monkeyCont) {
		JOptionPane.showMessageDialog(null, "O saldo atual da reserva é: " + aFinance.getReserveBalance() + "\nValores a entrar: " + aFinance.getReserveInput() + "\nValores a sair: " + aFinance.showReserveOutput(newMonkeys, monkeyCont));
	}

	public void showOutput(double aReserveOutput) {
		JOptionPane.showMessageDialog(null, "Os gastos deste mês são: " + aReserveOutput);
	}

	public double addOutput() {

		String entry;
		double newOutput = 0;
		do {
			entry = JOptionPane.showInputDialog("Digite o valor do gasto a ser adicionado: ");
		} while (validateInput(entry, newOutput) == false);
		return Double.parseDouble(entry);
	}

	public double addReserveInput() {
		double addedInput = 0;
		String entry;
		do {
			entry = JOptionPane.showInputDialog("Digite o valor a ser adicionado às entradas do mês: ");
		} while (validateInput(entry, addedInput) == false);
		return Double.parseDouble(entry);

	}

	public void firePerson() {
		personCont--;
	}

	public void deadMonkey() {
		System.out.println("Thoughts and prayers");
		monkeyCont--; 
	}

	public boolean testMode() {
		int test = JOptionPane.showConfirmDialog(null, "Ao entrar na versão de testes todos os dados atuais são armazenados e substituidos por dados padrão.\n" + "Tem certeza que deseja continuar?\n");
		return test == 0;
	}

	public Monkeys[] setTestMonkeys(int maxMonkeys,Monkeys testMonkeys[]) {
		Monkeys monkeys[] = testMonkeys;
		MedicalRecords aMedicalRecord = new MedicalRecords();
		Monkeys aMonkey = new Monkeys("Harambe", 20, 180, aMedicalRecord, 666.6, "Gorila", 0);
		monkeys[0] = aMonkey;
		for(int i = 1;i<maxMonkeys;i++) {
			aMedicalRecord = new MedicalRecords(0,false,("Doença"+Integer.toString(i)),("Observações"+Integer.toString(i)),i,i%10);
			aMonkey = new Monkeys(("Macaco"+Integer.toString(i)),i,i,aMedicalRecord,("Espécie"+Integer.toString(i)),i);
			aMonkey.computeMonkeyUpKeep();
			monkeys[i] = aMonkey;
		}
		return monkeys;
	}

	public Persons[] setTestPersons(int maxMonkeys,int maxPersons,Persons testPersons[],Monkeys testMonkeys[]) {
		Persons persons[] = testPersons;
		persons[0].voidPerson();
		for(int i = 1;i<maxPersons;i++) {
			if(i%3==1) {
				Monkeys monkeys[] = new Monkeys[5];
				Veterinaries aVeterinary = new Veterinaries("Veterinário"+Integer.toString(i),i,'f',i,i,true,(i%4)+1,monkeys,0);
				persons[i] = aVeterinary;
			}

			else {
				Persons aPerson = new Persons("Funcionário"+Integer.toString(i),i,'m',i,i,false);
				persons[i] = aPerson;
			}
		}
		return persons;
	}

}