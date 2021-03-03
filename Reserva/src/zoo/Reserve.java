package zoo;

public class Reserve {
 public int monkeyPopulation = 0;
 public int personPopulation = 0;
 public int month;
 public int maxMonkeys;
 public int maxPersons;

 public Reserve(int maxMonkeys,int maxPersons) {
  this.month = 11;
  this.maxMonkeys = maxMonkeys;
  this.maxPersons = maxPersons;

 }
 
 public Reserve(int monkeyCont,int maxMonkeys,int maxPersons) {
	 this.month = 11;
	 this.maxMonkeys = maxMonkeys;
	 this.maxPersons = maxPersons;
	 
 }
 
 public int getMaxMonkeys() {
	 return maxMonkeys;
 }
 
 public int getMaxPersons() {
	 return maxPersons;
 }
 
 public void addMonkeyPopulation() {
	 monkeyPopulation++;
 }
 
 public void decreaseMonkeyPopulation() {
	 monkeyPopulation--;
 }
 
 public void addPersonPopulation() {
	 personPopulation++;
 }
 
 public void decreasePersonPopulation() {
	personPopulation--;
 }
 
 public void setMonkeyPopulation(Monkeys monkeys[]) {
	 monkeyPopulation = 0;
	 for(int i = 0;i<999;i++) {
		 if(monkeys[i].getMonkeyID() != 0) monkeyPopulation++;
	 }
 }
 
 public void setPersonPopulation(Persons persons[]) {
	 personPopulation = 0;
	 for(int i = 0;i<999;i++) {
		 if(persons[i].getPersonID() != 0) personPopulation++;
	 }
 }
 
 public int getMonkeyPopulation() {
	 return monkeyPopulation;
 }
 
 public int getPersonPopulation() {
	 return personPopulation;
 }
 
 public String showPopulation() {
	 return ""+monkeyPopulation+" macacos e "+personPopulation+" funcionários cadastrados.";
 }
 public void passMonth() {
	 if(month == 12) { month = 1;}
	 else month++;
 }
 public String getMonth() {
  String output = "";
  switch (month) {
   case 1:
    output = "Janeiro;";
    break;
   case 2:
    output = "Fevereiro";
    break;
   case 3:
    output = "Março";
    break;
   case 4:
    output = "Abril";
    break;
   case 5:
    output = "Maio";
    break;
   case 6:
    output = "Junho";
    break;
   case 7:
    output = "Julho";
    break;
   case 8:
    output = "Agosto";
    break;
   case 9:
    output = "Setembro";
    break;
   case 10:
    output = "Outubro";
    break;
   case 11:
    output = "Novembro";
    break;
   case 12:
    output = "Dezembro";
   
  }
  return output;
 }
}