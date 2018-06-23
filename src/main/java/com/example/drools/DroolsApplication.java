package com.example.drools;

import com.example.drools.model.Disease;
import com.example.drools.model.MedicalRecord;
import com.example.drools.model.Symptom;
import com.example.drools.payload.Diagnose;
import com.example.drools.repository.DiseaseRepository;
import com.example.drools.repository.MedicalRecordRepository;
import com.example.drools.repository.SymptomRepository;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DroolsApplication /*implements CommandLineRunner */{

	@Autowired
	private SymptomRepository symptomRepository;

	@Autowired
	DiseaseRepository diseaseRepository;

	@Autowired
	MedicalRecordRepository medicalRecordRepository;


//	private final KieContainer kieContainer;
//
//	@Autowired
//	public DroolsApplication(KieContainer kieContainer) {
//		this.kieContainer = kieContainer;
//	}


	public static void main(String[] args) {
		SpringApplication.run(DroolsApplication.class, args);
	}

	@Bean
	public KieContainer kieContainer() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.newKieContainer(ks.newReleaseId("drools-spring-project","drools-spring-project-kjar", "0.0.1-SNAPSHOT"));
		KieScanner kScanner = ks.newKieScanner(kContainer);
		kScanner.start(10_000);
		return kContainer;
	}

//	@Override
//	public void run(String... strings) throws Exception {
//
//		KieSession ksession = null;
//
//		try {
//
//			ksession = kieContainer.newKieSession();
//
//			Diagnose diagnose = new Diagnose();
//			diagnose.setNbrSymptoms(0);
//
//			List<Symptom> symptoms = this.symptomRepository.findAll();
//
//			Set<Symptom> diagnoseSymptoms = new HashSet<>();
//
//			for(Symptom symptom: symptoms)
//				diagnoseSymptoms.add(symptom);
//
//			diagnose.setSymptoms(diagnoseSymptoms);
//
//
//
//			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//			LocalDateTime now = LocalDateTime.now();
//
////			now = now.plusMonths(6);
////			System.out.println("Rezultat: " + now);
//
//			MedicalRecord medicalRecord = this.medicalRecordRepository.findById(1);
//
//
//
//
//			ksession.setGlobal("diagnose", diagnose);
//			ksession.setGlobal("currentDate", now);
//
//			List<Disease> diseases = this.diseaseRepository.findAll();
//
//			for (Disease disease : diseases)
//				ksession.insert(disease);
//
//			for (Symptom symptom : symptoms)
//				ksession.insert(symptom);
//
//			ksession.insert(medicalRecord);
//
//			ksession.fireAllRules();
//
//			//Diagnose diagnose1 = (Diagnose) ksession.getGlobal("diagnose");
//
//			System.out.println("Bolest: " + diagnose.getDisease().getName());
//
//
//		}catch (Throwable t) {
//			t.printStackTrace();
//		} finally {
//			ksession.dispose();
//		}
//	}
}
