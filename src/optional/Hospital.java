package optional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

public class Hospital {

	private List<Doctor> doctors = new ArrayList<Doctor>();
	private List<Patient> patients = new ArrayList<Patient>();
	private List<Zombie> zombies = new ArrayList<Zombie>();

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public List<Zombie> getZombies() {
		return zombies;
	}

	public void addDoctor(Doctor d) {
		this.doctors.add(d);
	}

	public void addPatient(Patient p) {
		this.patients.add(p);
	}

	public void assignPatientsToDoctors() {
		ListIterator<Patient> iteratorPatient = patients.listIterator();
		ListIterator<Doctor> iteratorDoctor = doctors.listIterator();
		while (iteratorDoctor.hasNext()) {
			Doctor d = iteratorDoctor.next();
			while (iteratorPatient.hasNext()) {
				try {
					d.assignPatient(iteratorPatient.next());
				} catch (DoctorFullException dfe) {
					iteratorPatient.previous();
					break;
				}
			}
		}
	}

	public void add(Object o) {
		if (o instanceof Doctor)
			addDoctor((Doctor) o);
		else if (o instanceof Patient)
			addPatient((Patient) o);
	}

	public void makeDoctorsWork() {
		for (Doctor d : doctors) {
			d.doMedicine();
			List<Patient> oneDoc = d.getPatients();
			for (int i = 0; i < oneDoc.size(); i++) {
				if (!oneDoc.get(i).isAlive()) {
					patients.remove(oneDoc.get(i));
					oneDoc.remove(i);
					i--;
					zombies.add(new Zombie(new Date().toString()));
				}
			}
		}
	}
}
