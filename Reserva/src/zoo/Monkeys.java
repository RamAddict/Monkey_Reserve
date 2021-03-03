package zoo;

public class Monkeys {
	private String monkeyName;
	private int monkeyID;
	private int monkeyAge;
	private double monkeyWeight;
	private MedicalRecords monkeyRecords;
	private double monkeyUpKeep;
	private String monkeySpecies;

 public Monkeys(String monkeyName, int monkeyAge, double monkeyWeight, MedicalRecords monkeyRecords, String monkeySpecies, int monkeyID) {
  this.monkeyName = monkeyName;
  this.monkeyAge = monkeyAge;
  this.monkeyWeight = monkeyWeight;
  this.monkeyRecords = monkeyRecords;
  this.monkeySpecies = monkeySpecies;
  this.monkeyID = monkeyID;
 }
 public Monkeys(String monkeyName, int monkeyAge, double monkeyWeight, MedicalRecords monkeyRecords, double monkeyUpKeep, String monkeySpecies, int monkeyID) {
  this.monkeyName = monkeyName;
  this.monkeyAge = monkeyAge;
  this.monkeyWeight = monkeyWeight;
  this.monkeyRecords = monkeyRecords;
  this.monkeyUpKeep = monkeyUpKeep;
  this.monkeySpecies = monkeySpecies;
  this.monkeyID = monkeyID;
 }
 public Monkeys(String monkeyName, int monkeyAge, double monkeyWeight, String monkeySpecies, int monkeyID) {
  this.monkeyName = monkeyName;
  this.monkeyAge = monkeyAge;
  this.monkeyWeight = monkeyWeight;
  this.monkeySpecies = monkeySpecies;
  this.monkeyID = monkeyID;
 }

 public Monkeys(MedicalRecords monkeyRecords) {
  this.monkeyRecords = monkeyRecords;
 }

 public Monkeys() {
this.monkeyID = 0;
 }

 public int getMonkeyID() {
  return monkeyID;
 }

 public void setMonkeyID(int monkeyID) {
  this.monkeyID = monkeyID;
 }

 public String getMonkeyName() {
  return monkeyName;
 }

 public int getMonkeyAge() {
  return monkeyAge;
 }

 public double getMonkeyWeight() {
  return monkeyWeight;
 }

 public double getMonkeyUpKeep() {
  return monkeyUpKeep;
 }

 public MedicalRecords getMonkeyRecords() {
  return monkeyRecords;
 }

 public void setMonkeyRecords(MedicalRecords monkeyRecords) {
  this.monkeyRecords = monkeyRecords;
 }

 public String getMonkeySpecies() {
  return monkeySpecies;
 }

 public void computeMonkeyUpKeep() {
  monkeyUpKeep = monkeyRecords.getUpKeep() * (1 + ((monkeyRecords.getMedicalGrade()) / 10));
 }
 
 public int getCaretaker() {
	 return monkeyRecords.getCaretaker();
 }

 public Monkeys voidMonkey() {
  String monkeyName = "Macaco Inexistente.";
  int monkeyAge = 0;
  double monkeyWeight = 0;
  int caretaker = 0;
  String diseases = "Inexistência.";
  String observations = "Inexistência.";
  int medicalGrade = 0;
  double upKeep = 0;
  boolean agressive = true;
  MedicalRecords monkeyRecord = new MedicalRecords(caretaker, agressive, diseases, observations, upKeep, medicalGrade);
  String monkeySpecies = "Inexistência.";
  int monkeyID = 0;
  Monkeys aMonkey = new Monkeys(monkeyName, monkeyAge, monkeyWeight, monkeyRecord, monkeySpecies, monkeyID);
  return aMonkey;
 }
 public boolean getExistence() {
	 if(monkeyID == 0) return false;
	 else return true; 
 }
 
 public void deadMonkey() {
	 monkeyID = 0;
 }
 
 public boolean needVeterinary() {
	 if(monkeyRecords.getCaretaker() == 0) return true;
	 else return false;
 }

}