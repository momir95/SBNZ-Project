# INSERT INTO roles(id, role_name) VALUES(1, 'ROLE_DOCTOR');
# INSERT INTO roles(id, role_name) VALUES(2, 'ROLE_ADMIN');
#
# INSERT INTO user(id, firstname, lastname, password, username) VALUES(1, 'admin', 'admin', '$2a$10$OV9sEGdEfMR60pwl05RNz.i4RTpMb7jC219HVrGSQ4TmDptG3VSc2', 'kole95');
#
# INSERT INTO user_roles(user_id, role_id) VALUES(1, 2);
#
#
# INSERT INTO patient(id, firstname, lastname) VALUES(1, 'Pera', 'Peric');
#
# INSERT INTO medical_record(id, lbo, patient_id) VALUES(1, '1234', 1);
#
# INSERT INTO disease(id, name) VALUES(1, 'Prehlada');
#
# INSERT INTO review(id, date, disease_id, medical_record_id) VALUES(1, '2018-06-16 15:00:00', 1, 1);
#
# INSERT INTO symptom(id, name) VALUES(1, 'Visoka temperatura');
# INSERT INTO symptom(id, name) VALUES(2, 'Kasalj');
#
# INSERT INTO review_symptoms(review_id, symptom_id) VALUES(1, 1);
# INSERT INTO review_symptoms(review_id, symptom_id) VALUES(1, 2);
#
#
# INSERT INTO cure(id, name) VALUES(1, 'Aspirin');
# INSERT INTO cure(id, name) VALUES(2, 'Kafetin');
# INSERT INTO cure(id, name) VALUES(3, 'Brufen');
# INSERT INTO cure(id, name) VALUES(4, 'Gluformin');
#
# INSERT INTO ingredient(id, name) VALUES(1, 'Nitrat');
# INSERT INTO ingredient(id, name) VALUES(2, 'Karbon');
#
#
# INSERT INTO review_cures(review_id, cure_id) VALUES(1, 1);
# INSERT INTO review_cures(review_id, cure_id) VALUES(1, 4);
#
# INSERT INTO medical_record_cures(medical_record_id, cure_id) VALUES(1, 1);
# INSERT INTO medical_record_cures(medical_record_id, cure_id) VALUES(1, 2);
#
#
