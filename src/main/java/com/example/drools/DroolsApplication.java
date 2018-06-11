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
public class DroolsApplication /*implements CommandLineRunner*/ {

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

//	@Override
//	public void run(String... strings) throws Exception {
//
//		reviewRepository.deleteAllInBatch();
//		symptomRepository.deleteAllInBatch();
//
//		Symptom symptom1 = new Symptom("Bol u grlu");
//		Symptom symptom2 = new Symptom("Visoka temperatura");
//
//		Review review1 = new Review();
//		Review review2 = new Review();
//
//
//		//symptom1.getReviews().add(review1);
//		//symptom1.getReviews().add(review2);
//		//symptom2.getReviews().add(review1);
//		Symptom s1 = symptomRepository.save(symptom1);
//		Symptom s2 = symptomRepository.save(symptom2);
//
//		review1.getSymptoms().add(s1);
//		review1.getSymptoms().add(s2);
//
//		review2.getSymptoms().add(s1);
//
//		Review r = reviewRepository.save(review1);
//		Review r1 = reviewRepository.save(review2);
//
//		Review review3 = new Review();
//		review3.getSymptoms().add(s2);
//
//		//symptom2.getReviews().add(review3);
//
//		Review r2 = reviewRepository.save(review3);
//
//
//
//		System.out.println("------------REVIEW1------------------");
//		for(Symptom symptom: r.getSymptoms())
//			System.out.println(symptom);
//
//
//		System.out.println("------------REVIEW2------------------");
//		for(Symptom symptom: r1.getSymptoms())
//			System.out.println(symptom);
//
//		System.out.println("------------REVIEW3------------------");
//		for(Symptom symptom: r2.getSymptoms())
//			System.out.println(symptom);
//
//	}
}
