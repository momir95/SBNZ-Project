package com.example.drools;

import com.example.drools.model.Review;
import com.example.drools.model.Symptom;
import com.example.drools.repository.ReviewRepository;
import com.example.drools.repository.SymptomRepository;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DroolsApplication implements CommandLineRunner {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	SymptomRepository symptomRepository;


	public static void main(String[] args) {
		SpringApplication.run(DroolsApplication.class, args);
	}

	@Bean
	public KieContainer kieContainer() {
		return KieServices.Factory.get().getKieClasspathContainer();
	}

	@Override
	public void run(String... strings) throws Exception {

//		reviewRepository.deleteAllInBatch();
//		symptomRepository.deleteAllInBatch();
//
//		Symptom symptom1 = new Symptom(null, "Bol u grlu", null, null);
//		Symptom symptom2 = new Symptom(null, "Visoka temperatura", null, null);
//
//		Set<Symptom> symptoms1 = new HashSet<>();
//		symptoms1.add(symptom1);
//		symptoms1.add(symptom2);
//
//		Review review1 = new Review(null, null, null, null, symptoms1);
//
//
//		Review r = reviewRepository.save(review1);
//
//		Symptom s = symptomRepository.find(1);
//
//		System.out.println("------------SIMPROM1------------------");
//		for(Symptom symptom: r.getSymptoms())
//			System.out.println(symptom);
//
//		Set<Symptom> symptoms2 = new HashSet<>();
//		symptoms2.add(new Symptom(null, "Bol u grlu", null, null));
//
//
//
//		Review review2 = new Review(null, null, null, null, symptoms2);
//
//
//		Review r1 = reviewRepository.save(review2);
//
//		System.out.println("------------SIMPROM1------------------");
//		for(Symptom symptom: r1.getSymptoms())
//			System.out.println(symptom);


	}
}
