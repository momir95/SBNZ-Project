INSERT INTO roles(id, role_name) VALUES(1, 'ROLE_DOCTOR');
INSERT INTO roles(id, role_name) VALUES(2, 'ROLE_ADMIN');

INSERT INTO user(id, firstname, lastname, password, username) VALUES(1, 'admin', 'admin', '$2a$10$OV9sEGdEfMR60pwl05RNz.i4RTpMb7jC219HVrGSQ4TmDptG3VSc2', 'kole95');
INSERT INTO user(id, firstname, lastname, password, username) VALUES(2, 'N', 'N', '$2a$10$OV9sEGdEfMR60pwl05RNz.i4RTpMb7jC219HVrGSQ4TmDptG3VSc2', 'aaaaa');
INSERT INTO user(id, firstname, lastname, password, username) VALUES(3, 'N', 'P', '$2a$10$OV9sEGdEfMR60pwl05RNz.i4RTpMb7jC219HVrGSQ4TmDptG3VSc2', 'bbbbb');
INSERT INTO user(id, firstname, lastname, password, username) VALUES(4, 'R', 'K', '$2a$10$OV9sEGdEfMR60pwl05RNz.i4RTpMb7jC219HVrGSQ4TmDptG3VSc2', 'ccccc');


INSERT INTO user_roles(user_id, role_id) VALUES(1, 2);
INSERT INTO user_roles(user_id, role_id) VALUES(2, 1);
INSERT INTO user_roles(user_id, role_id) VALUES(3, 1);
INSERT INTO user_roles(user_id, role_id) VALUES(4, 1);



INSERT INTO patient(id, firstname, lastname) VALUES(1, 'Pera', 'Peric');
INSERT INTO patient(id, firstname, lastname) VALUES(2, 'Moma', 'Momic');


INSERT INTO medical_record(id, lbo, patient_id) VALUES(1, '1234', 1);
INSERT INTO medical_record(id, lbo, patient_id) VALUES(2, '1111', 2);


INSERT INTO disease(id, disease_group, name) VALUES(1, 'FIRST', 'Prehlada');
INSERT INTO disease(id, disease_group, name) VALUES(2, 'FIRST', 'Groznica');
INSERT INTO disease(id, disease_group, name) VALUES(3, 'FIRST', 'Sinusna infekcija');
INSERT INTO disease(id, disease_group, name) VALUES(4, 'SECOND', 'Dijabetes');
INSERT INTO disease(id, disease_group, name) VALUES(5, 'FIRST', 'Upala krajnika');
INSERT INTO disease(id, disease_group, name) VALUES(6, 'THIRD', 'Hronicna bubrezna bolest');
INSERT INTO disease(id, disease_group, name) VALUES(7, 'FIRST', 'Upala krajnika');









INSERT INTO review(id, date, disease_id, doctor_id, medical_record_id) VALUES(1, '2018-06-16 15:00:00', 3, 3, 1);
INSERT INTO review(id, date, disease_id, doctor_id, medical_record_id) VALUES(2, '2018-06-26 17:00:00', 3, 3, 1);
INSERT INTO review(id, date, disease_id, doctor_id, medical_record_id) VALUES(3, '2018-06-16 15:00:00', 3, 2, 1);
INSERT INTO review(id, date, disease_id, doctor_id, medical_record_id) VALUES(4, '2018-06-26 17:00:00', 3, 4, 1);
INSERT INTO review(id, date, disease_id, doctor_id, medical_record_id) VALUES(5, '2018-06-16 15:00:00', 3, 4, 1);
INSERT INTO review(id, date, disease_id, doctor_id, medical_record_id) VALUES(6, '2018-06-26 17:00:00', 3, 4, 1);

INSERT INTO review(id, date, disease_id, doctor_id, medical_record_id) VALUES(7, '2018-06-16 15:00:00', 3, 2, 2);
INSERT INTO review(id, date, disease_id, doctor_id, medical_record_id) VALUES(8, '2018-06-26 17:00:00', 3, 2, 2);
INSERT INTO review(id, date, disease_id, doctor_id, medical_record_id) VALUES(9, '2018-06-16 15:00:00', 3, 3, 2);
INSERT INTO review(id, date, disease_id, doctor_id, medical_record_id) VALUES(10, '2018-06-26 17:00:00', 3, 3, 2);
INSERT INTO review(id, date, disease_id, doctor_id, medical_record_id) VALUES(11, '2018-06-16 15:00:00', 3, 3, 2);
INSERT INTO review(id, date, disease_id, doctor_id, medical_record_id) VALUES(12, '2018-06-16 15:00:00', 3, 4, 2);

INSERT INTO review(id, date, disease_id, doctor_id, medical_record_id) VALUES(13, '2018-06-16 15:00:00', 3, 2, 1);
INSERT INTO review(id, date, disease_id, doctor_id, medical_record_id) VALUES(14, '2018-06-26 17:00:00', 3, 3, 1);
INSERT INTO review(id, date, disease_id, doctor_id, medical_record_id) VALUES(15, '2018-06-16 15:00:00', 3, 4, 1);
INSERT INTO review(id, date, disease_id, doctor_id, medical_record_id) VALUES(16, '2018-06-26 17:00:00', 3, 4, 1);
INSERT INTO review(id, date, disease_id, doctor_id, medical_record_id) VALUES(17, '2018-06-16 15:00:00', 3, 2, 1);
INSERT INTO review(id, date, disease_id, doctor_id, medical_record_id) VALUES(18, '2018-06-26 17:00:00', 3, 3, 1);



INSERT INTO symptom(id, name, symptom_type) VALUES(1, 'Temperatura veca od 38C', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(2, 'Kasalj', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(3, 'Curenje iz nosa', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(4, 'Bol u grlu', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(5, 'Glavobolja', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(6, 'Kijanje', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(7, 'Drhtavica', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(8, 'Gubitak apetita', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(9, 'Oticanje oko ociju', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(10, 'Zuti sekret iz nosa', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(11, 'Prehlada ili groznica u poslednjih 60 dana', 'SPECIFIC');
INSERT INTO symptom(id, name, symptom_type) VALUES(12, 'Visok pritisak', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(13, 'Bol koji se siri do usiju', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(14, 'Temperatura veca od 40C do 41C', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(15, 'Gubitak apetita', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(16, 'Umor', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(17, 'Cesto uriniranje', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(18, 'Gubitak telesne tezine', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(19, 'Mucnina i povracanje', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(20, 'Nocturija', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(21, 'Otoci nogu i zglobova', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(22, 'Bol u grudima', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(23, 'Dijareja', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(24, 'Gusenje', 'GENERAL');
INSERT INTO symptom(id, name, symptom_type) VALUES(25, 'Povisena temperatura u poslednjih 14 dana', 'SPECIFIC');
INSERT INTO symptom(id, name, symptom_type) VALUES(26, 'Primani antibiotici u poslednjih 21 dana', 'SPECIFIC');
















INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(1, 3);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(1, 4);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(1, 5);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(1, 6);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(1, 2);

INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(2, 3);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(2, 4);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(2, 5);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(2, 6);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(2, 2);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(2, 7);

INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(3, 9);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(3, 5);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(3, 10);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(3, 4);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(3, 2);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(3, 11);

INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(4, 17);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(4, 18);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(4, 16);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(4, 19);


INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(6, 16);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(6, 20);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(6, 21);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(6, 24);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(6, 22);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(6, 25);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(6, 26);

INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(7, 4);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(7, 13);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(7, 5);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(7, 14);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(7, 7);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(7, 18);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(7, 16);
INSERT INTO disease_symptoms(disease_id, symptom_id) VALUES(7, 10);





INSERT INTO review_symptoms(review_id, symptom_id) VALUES(1, 1);
INSERT INTO review_symptoms(review_id, symptom_id) VALUES(1, 2);
INSERT INTO review_symptoms(review_id, symptom_id) VALUES(1, 12);

INSERT INTO review_symptoms(review_id, symptom_id) VALUES(2, 1);
INSERT INTO review_symptoms(review_id, symptom_id) VALUES(2, 2);



INSERT INTO cure(id, cure_type, name) VALUES(1, 'ANTIBIOTIK', 'Aspirin');
INSERT INTO cure(id, cure_type, name) VALUES(2, 'ANTIBIOTIK', 'Kafetin');
INSERT INTO cure(id, cure_type, name) VALUES(3, 'ANALGETIK', 'Brufen');
INSERT INTO cure(id, cure_type, name) VALUES(4, 'ANALGETIK', 'Gluformin');

INSERT INTO ingredient(id, name) VALUES(1, 'Nitrat');
INSERT INTO ingredient(id, name) VALUES(2, 'Karbon');

INSERT INTO cure_ingredients(cure_id, ingredient_id) VALUES(4, 2);

INSERT INTO review_cures(review_id, cure_id) VALUES(1, 1);
INSERT INTO review_cures(review_id, cure_id) VALUES(2, 1);
INSERT INTO review_cures(review_id, cure_id) VALUES(3, 1);
INSERT INTO review_cures(review_id, cure_id) VALUES(4, 1);
INSERT INTO review_cures(review_id, cure_id) VALUES(5, 1);
INSERT INTO review_cures(review_id, cure_id) VALUES(6, 1);

INSERT INTO review_cures(review_id, cure_id) VALUES(13, 1);
INSERT INTO review_cures(review_id, cure_id) VALUES(14, 1);
INSERT INTO review_cures(review_id, cure_id) VALUES(15, 1);
INSERT INTO review_cures(review_id, cure_id) VALUES(16, 1);
INSERT INTO review_cures(review_id, cure_id) VALUES(17, 1);
INSERT INTO review_cures(review_id, cure_id) VALUES(18, 2);

INSERT INTO review_cures(review_id, cure_id) VALUES(7, 3);
INSERT INTO review_cures(review_id, cure_id) VALUES(8, 3);
INSERT INTO review_cures(review_id, cure_id) VALUES(9, 3);
INSERT INTO review_cures(review_id, cure_id) VALUES(10, 4);
INSERT INTO review_cures(review_id, cure_id) VALUES(11, 4);
INSERT INTO review_cures(review_id, cure_id) VALUES(12, 4);

INSERT INTO review_cures(review_id, cure_id) VALUES(2, 2);

INSERT INTO medical_record_cures(medical_record_id, cure_id) VALUES(1, 1);
INSERT INTO medical_record_cures(medical_record_id, cure_id) VALUES(1, 2);

INSERT INTO medical_record_ingredients(medical_record_id, ingredient_id) VALUES(1, 2);



