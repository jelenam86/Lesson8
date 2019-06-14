package optional;

import java.util.ArrayList;
import java.util.List;

public class Doctor {

	private String speciality;
	private List<Patient> patients = new ArrayList<Patient>();
	private boolean isEvil;
	private Hospital hospital;

	public Doctor() {
		this.speciality = "not known";
	}

	public Doctor(String number) {
		this();
		if (number.equals("666"))
			isEvil = true;
	}

	public Doctor(String number, Hospital hospital) {
		this(number);
		this.hospital = hospital;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public List<Patient> getPatients() {
		return this.patients;
	}

	public int assignPatient(Patient p) throws DoctorFullException {
		if (this.patients.size() == 3)
			throw new DoctorFullException();
		this.patients.add(p);
		return this.patients.size();
	}

	public boolean performsSurgery() {
		if (this.speciality.equals("surgeon"))
			return true;
		return false;
	}

	public boolean makesHouseCalls() {
		if (this.speciality.equals("general practitioner"))
			return true;
		return false;
	}

	public void doMedicine() {
		for (Patient p : patients) {
			p.checkPulse();
			if (isEvil) {
				p.kill();
			}
		}
	}

	public boolean isEvil() {
		return this.isEvil;
	}

	public void joinTheDarkSide() {
		this.isEvil = true;
	}

	public Hospital getHospital() {
		return this.hospital;
	}
}
