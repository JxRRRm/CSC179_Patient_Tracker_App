CREATE TABLE Patients (
    id INTEGER PRIMARY KEY,
    name TEXT,
    age INTEGER
    date_of_birth DATE,
    gender CHAR,
    height INTEGER,
    weight INTEGER,
    Race TEXT,
    ethnicity TEXT,
    primary_language TEXT,
    address TEXT,
    phone_number TEXT,
    mobile_number TEXT,
    email TEXT,
);

CREATE TABLE MedicalRecords (
    id INTEGER PRIMARY KEY,
    patient_id INTEGER,
    diagnosis TEXT,
    treatment TEXT,
    date_of_visit TEXT,
    doctor TEXT,
    recorder TEXT,
    FOREIGN KEY (patient_id) REFERENCES Patients(id)
);

CREATE TABLE EmergencyContacts (
    id INTEGER PRIMARY KEY,
    patient_id INTEGER,
    name TEXT,
    primary_language TEXT,
    address TEXT,
    phone_number TEXT,
    mobile_number TEXT,
    email TEXT,
    FOREIGN KEY (patient_id) REFERENCES Patients(id)
);