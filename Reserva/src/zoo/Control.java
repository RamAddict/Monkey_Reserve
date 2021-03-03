package zoo;

import javax.swing.JOptionPane;
public class Control {
	public static void main(String[] args) {	 
		View ui = new View();
		int size1 = ui.arrayMonkeySize();
		int size2= ui.arrayPersonSize();
		
		Monkeys monkeys[] = new Monkeys[999];
		Persons persons[] = new Persons[999];
		Finance finances = new Finance();
		Reserve reserve = new Reserve(size1,size2);
		monkeys[0] = new Monkeys();
		persons[0] = new Persons();
		View testui = new View(size1, size2);
		Monkeys testmonkeys[] = new Monkeys[999];
		Persons testpersons[] = new Persons[999];
		Finance testfinances = new Finance(100000, 10000);
		Reserve testreserve = new Reserve(size1,size2);
		
		
		for (int i = 0; i < 999; i++) {
			monkeys[i] = monkeys[0].voidMonkey();
			testmonkeys[i] = monkeys[0].voidMonkey();
			persons[i] = persons[0].voidPerson();
			testpersons[i] = persons[0].voidPerson();
		}
		testmonkeys = ui.setTestMonkeys(reserve.getMaxMonkeys(),testmonkeys);
		testpersons = ui.setTestPersons(reserve.getMaxMonkeys(),reserve.getMaxPersons(),testpersons,testmonkeys);
		testreserve.setMonkeyPopulation(testmonkeys);
		testreserve.setPersonPopulation(testpersons);
		for (int i = 0; i < 999; i++) {
			monkeys[i] = monkeys[0].voidMonkey();
		}
		for (int i = 0; i < 999; i++) {
			persons[i] = persons[0].voidPerson();
		}
		finances = ui.newBalance();
		boolean end = false;
		boolean testMode = false;
		do {
			int op;
			int optionMainMenu = ui.mainMenu(reserve.getMonth(),finances.showMonthlyBalance(), reserve.showPopulation(), testMode);
			
			switch (optionMainMenu) {
			
			case 1:
				do {
					int optionReserveMenu = ui.reserveMenu(reserve.getMonth(),finances.showMonthlyBalance(), reserve.showPopulation());
					switch (optionReserveMenu) {
					case 1:
						if(reserve.getMonkeyPopulation()<reserve.getMaxMonkeys()-1 && ui.thereIsVeterinaries(persons)) {
							op = ui.getMonkeyCont();
							monkeys[op] = ui.registerMonkey(monkeys,persons);
							monkeys[op].computeMonkeyUpKeep();
							reserve.addMonkeyPopulation();
							persons[monkeys[op].getCaretaker()].addMonkeyCounter();
							break;
						}
						else ui.arrayOverFlow();
						break;
					case 2:
						if(reserve.getMonkeyPopulation() != 0) {
							ui.reportMonkey(monkeys[ui.whichMonkey(monkeys)]);
						}
						else JOptionPane.showMessageDialog(null, "Nenhum macaco cadastrado");
						break;
					case 3:
						if(reserve.getMonkeyPopulation() != 0) {
							op = ui.whichMonkey(monkeys);   
							ui.medicalReportMonkey(monkeys[op].getMonkeyRecords());
						}
						else JOptionPane.showMessageDialog(null, "Nenhum macaco cadastrado");
						break;
					case 4: // UPDATE MONKEY
						if(reserve.getMonkeyPopulation() != 0) {
							op = ui.whichMonkey(monkeys);
							monkeys[op] = ui.updateMonkey(monkeys[op].getMonkeyID(), monkeys[op].getMonkeyRecords());
							monkeys[op].computeMonkeyUpKeep();
							persons[monkeys[op].getCaretaker()].addMonkeyCounter();
						}
						else JOptionPane.showMessageDialog(null, "Nenhum macaco cadastrado");
						break;
					case 5:
						if(reserve.getMonkeyPopulation() != 0) {
							op = ui.whichMonkey(monkeys);
							monkeys[op].setMonkeyRecords(ui.updateMedicalRecords(monkeys[op].getMonkeyID(),persons));
							monkeys[op].computeMonkeyUpKeep();
						}
						else JOptionPane.showMessageDialog(null, "Nenhum macaco cadastrado");
						break;
					case 6:
						if(reserve.getMonkeyPopulation() != 0) {
							op = ui.whichMonkey(monkeys);
							monkeys[op].deadMonkey();
							reserve.decreaseMonkeyPopulation();
						}
						else JOptionPane.showMessageDialog(null, "Nenhum macaco cadastrado");
						break;
					case 7:
						if(reserve.getMonkeyPopulation() != 0) {
						ui.showMonkeys(monkeys);
						}
						else JOptionPane.showMessageDialog(null, "Nenhum macaco cadastrado");
						
						break;
					case 8:
						end = true;
						break;
					default:
						JOptionPane.showMessageDialog(null, "ERRO.\nOpção não consta no menu.");
					}
				} while (end == false);

				end = false;
				break;
			case 2:
				do {
					int optionFinancialMenu = ui.financialMenu(reserve.getMonth(),finances.showMonthlyBalance(), reserve.showPopulation());
					switch (optionFinancialMenu) {
					case 1:
						finances = ui.newBalance();
						break;
					case 2:
						ui.showBalance(finances, monkeys, ui.getMonkeyCont());
						break;
					case 3:
						ui.showOutput(finances.showReserveOutput(monkeys, ui.getMonkeyCont()));
						break;
					case 4:
						finances.setReserveOutput(monkeys, ui.getMonkeyCont(), persons, ui.getPersonCont());
						finances.setBalance();
						finances.resetMonth();
						reserve.passMonth();
						ui.showBalance(finances, monkeys, ui.getMonkeyCont());
						break;
					case 5:
						finances.addReserveOutput(ui.addOutput());
						break;
					case 6:
						finances.addReserveInput(ui.addReserveInput());
						break;
					case 7:
						end = true;
						break;
					default:
						JOptionPane.showMessageDialog(null, "ERRO.\nOpção não consta no menu.");
					}
				} while (end == false);
				end = false;
				break;
			case 3:
				do {
					int optionPersonalMenu = ui.personalMenu(reserve.getMonth(),finances.showMonthlyBalance(), reserve.showPopulation());
					switch (optionPersonalMenu) {
					case 1:
						if(reserve.getPersonPopulation()<reserve.getMaxPersons()-1) {
							op = ui.getPersonCont();
							persons[op] = ui.registerPerson(persons);
							reserve.addPersonPopulation();
							break;
						}
						else ui.arrayOverFlow();
						break;
					case 2:
						if(reserve.getPersonPopulation()!= 0) {
							ui.reportPerson(persons[ui.whichPerson(persons)]);
						}
						else JOptionPane.showMessageDialog(null, "Nenhum funcionário cadastrado");
						break;
					case 3:
						if(reserve.getPersonPopulation()!= 0) {
							op = ui.whichPerson(persons);
							persons[op] = ui.updatePerson(persons);
						}
						else JOptionPane.showMessageDialog(null, "Nenhum funcionário cadastrado");
						break;
					case 4:
						if(reserve.getPersonPopulation()!= 0) {
							op = ui.whichPerson(persons);
							persons[op].firePerson();
							reserve.decreasePersonPopulation();
						}
						else JOptionPane.showMessageDialog(null, "Nenhum funcionário cadastrado");
						break;
					case 5:
						if(reserve.getPersonPopulation()!= 0) {
						ui.showPersons(persons);}
						else JOptionPane.showMessageDialog(null, "Nenhum funcionário cadastrado");
						break;
					case 6:
						end = true;
						break;
					default: JOptionPane.showMessageDialog(null, "ERRO.\nOpção não consta no menu.");
					}
				} while (end == false);
				end = false;
				break;
			case 4:
				if (ui.testMode()) {
					if (testMode) testMode = false;
					else testMode = true;
					View uiop = ui;
					Monkeys monkeysop[] = monkeys;
					Persons personsop[] = persons;
					Finance financesop = finances;
					Reserve reserveop = reserve;
					ui = testui;
					monkeys = testmonkeys;
					persons = testpersons;
					finances = testfinances;
					reserve = testreserve;
					testui = uiop;
					testmonkeys = monkeysop;
					testpersons = personsop;
					testfinances = financesop;
					testreserve = reserveop;
				}
				break;
			case 5:
				JOptionPane.showMessageDialog(null,"Tchau. :(");
				System.exit(0);
				break;
			default: JOptionPane.showMessageDialog(null, "ERRO.\nOpção não consta no menu.");
			}
		} while (end == false);
	}
}