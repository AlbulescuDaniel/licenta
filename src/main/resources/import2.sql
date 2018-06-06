INSERT INTO T_PATIENT (ID_PATIENT, password, firstName, lastName, age, phone, city, COUNTRY, postalCode, email, cnp, ADDRESS_LINE, birthDate, gender)
 VALUES (1, 'aaa', 'ana', 'ana', '68', '0752222232', 'Brasov', 'Romania' , '882830', 'aaa@aaa', '2300000000000000', 'undeva', '1950-03-03', 'male');


INSERT INTO T_HOSPITAL (HospitalId, HOSPITAL_NAME, STREET , STREET_NUMBER, CITY, STATE, ZIP_CODE, PHONE, EMAIL)
 VALUES (1, 'judetean', 'Calea Bucuresti', '8', 'Brasov', 'Romania', '989898', '07565656565', 'hospital@hospital.com');


INSERT INTO T_DOCTOR (iddoctor, First_Name, Last_Name, Age, Department, Street, City, State, Zip_Code, Phone, Email, Password, HospitalId)
 VALUES (1, 'doctor', 'doctor', '55', 'acolo', 'Memo', 'Brasov', 'Romania', '882830', '09898989', 'doctor@doctor', 'doctor' , 1);


INSERT INTO T_SPECIALITY (ID_SPECIALITY, SPECIALITY_NAME, DESCRIPTION) VALUES (1, 'generalist', 'generalist');


INSERT INTO T_DOCTOR_SPECIALITY(ID, iddoctor, idspeciality) VALUES (1 ,1 ,1);


INSERT INTO T_PRESCRIPTION (ID_PRESCRIPTION, idDoctor, idPatient, diagnostic, days, datePrescripted)
 VALUES (1, 1, 1, 'p1', '28', '2018-03-03');


INSERT INTO T_MEDICAMENT (ID_MEDICAMENT, MEDICAMENT_NAME, DESCRIPTION, FABRICANT, ACTIVE_COMPONENT)
 VALUES (1, 'med1', 'med1', 'med1', 'med1');


INSERT INTO T_PRESCRIPTION_MEDICAMENT (ID, idPrescription, idMedicament, checked, description, pillsNumber) VALUES (1, 1, 1, 1, '2 pe zip', 1000);


INSERT INTO T_PHARMACY (ID_PHARMACY, PHARMACY_NAME, LEAD_PHARMACIST, STREET, STREET_NUMBER, CITY, STATE, ZIP_CODE, PHONE, EMAIL)
 VALUES (1, 'catena', 'cantena', 'Lunga', '10', 'Brasov',  'Romania', '98798', '07990009', 'ph@ph.com');


INSERT INTO T_PHARMACY_STOCK (ID_PHARMACY_STOCK, PHARMACY_ID, MEDICAMENT_ID, PRICE, QUANTITY) VALUES (1,1,1,70,10);