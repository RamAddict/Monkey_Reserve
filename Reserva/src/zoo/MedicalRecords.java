package zoo;

public class MedicalRecords {
	private int caretaker;
	private boolean agressive;
	private String diseases;
	private String observations;
	private double upKeep;
	private int medicalGrade;
	
	public MedicalRecords(int caretaker,boolean agressive, String diseases, String observations, double upKeep, int medicalGrade) {
		this.caretaker = caretaker;
		this.agressive = agressive;
		this.diseases = diseases;
		this.observations = observations;
		this.upKeep = upKeep;
		this.medicalGrade = medicalGrade;

	}

	public MedicalRecords() {
		
	}
	
	public double getUpKeep() {
		return upKeep;
	}

	public int getMedicalGrade() {
		return medicalGrade;
	}

	public String getAgressive() {
		String answer;
		if (agressive == true) answer = "Macaco com histórico de agressividade.";
		else answer = "Macaco sem histórico de agressividade.";
		return answer;
	}

	public String getDiseases() {
		return diseases;
	}

	public String getObservations() {
		return observations;
	}
	
	public void setCaretaker(int caretakerID) {
		caretaker = caretakerID;
	}

	public int getCaretaker() {
		return caretaker;
	}
}