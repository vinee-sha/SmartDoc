package com.ts;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ts.dao.AssistantDao;
import com.ts.dao.DoctorDao;
import com.ts.dao.PatientDao;
import com.ts.dao.PharmacistDao;
import com.ts.dto.Assistant;
import com.ts.dto.Doctor;
import com.ts.dto.Patient;
import com.ts.dto.Pharmacist;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}

	@Path("getPatientByUserPass/{userName}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getPatientByUserPass(@PathParam("userName") String userName, @PathParam("password") String password) {
		System.out.println("Recieved path params: " + userName + " " + password);
		PatientDao patientDao = new PatientDao();
		Patient patient = (Patient) patientDao.getPatientByUserPass(userName, password);
		return patient;
	}

	@Path("registerPatient")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void registerPatient(Patient patient) {
		System.out.println("Patient Registered!" + patient);
		PatientDao patientDao = new PatientDao();
		patientDao.register(patient);
	}

	@Path("registerDoctor")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void registerDoctor(Doctor doctor) {
		DoctorDao doctorDao = new DoctorDao();
		doctorDao.register(doctor);
	}

	@Path("registerAssistant")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void registerAssistant(Assistant assistant) {
		AssistantDao assistantDao = new AssistantDao();
		assistantDao.register(assistant);
	}

	@Path("registerPharmacist")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void registerPharmacist(Pharmacist pharmacist) {
		PharmacistDao pharmacistDao = new PharmacistDao();
		pharmacistDao.register(pharmacist);
	}

	@Path("getDoctorByUserPass/{loginId}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getDoctorByUserPass(@PathParam("loginId") String loginId, @PathParam("password") String password) {
		System.out.println("Recieved path params: " + loginId + " " + password);
		DoctorDao doctorDao = new DoctorDao();
		Doctor doctor = (Doctor) doctorDao.getDoctorByUserPass(loginId, password);
		return doctor;
	}

	@Path("getPharmacistByUserPass/{loginId}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getPharmacistByUserPass(@PathParam("loginId") String loginId,
			@PathParam("password") String password) {
		System.out.println("Recieved path params: " + loginId + " " + password);
		PharmacistDao pharmacistDao = new PharmacistDao();
		Pharmacist pharmacist = (Pharmacist) pharmacistDao.getPharmacistByUserPass(loginId, password);
		return pharmacist;
	}

	@Path("getAssistantByUserPass/{loginId}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getAssistantByUserPass(@PathParam("loginId") String loginId, @PathParam("password") String password) {
		System.out.println("Recieved path params: " + loginId + " " + password);
		AssistantDao AssistantDao = new AssistantDao();
		Assistant assistant = (Assistant) AssistantDao.getAssistantByUserPass(loginId, password);
		return assistant;
	}

}