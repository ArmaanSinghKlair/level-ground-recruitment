/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  AmirS
 * Created: Apr 17, 2021
 */

# Candidate
INSERT INTO qvt0v9the6uowez2.candidate (can_username, can_password, can_description, can_firstName, can_lastName,
                                        can_email, can_phone_no)
VALUES ('garnet', 'password',
        'Software developer with 5 years of experience in the IT industry. Looking for new Opportunities',
        'Garnet', 'DuBuque', 'predovic.john@jacobi.com', '5644484814');

INSERT INTO qvt0v9the6uowez2.candidate (can_username, can_password, can_description, can_firstName, can_lastName,
                                        can_email, can_phone_no)
VALUES ('dhaley', 'password',
        'Independent full stack web designer and web developer. Worked with companies like A, B, and C.',
        'Zackary', 'Berge', 'angelica.pfannerstill@boyer.com', '2010944683');

INSERT INTO qvt0v9the6uowez2.candidate (can_username, can_password, can_description, can_firstName, can_lastName,
                                        can_email, can_phone_no)
VALUES ('tia05', 'password',
        'Civil engineer with 10 years of experience in the variety of projects. Worked with latest design and analysis software.',
        'Eriberto', 'Haley', 'lindsey.von@yahoo.com', '6765250867');

INSERT INTO qvt0v9the6uowez2.candidate (can_username, can_password, can_description, can_firstName, can_lastName,
                                        can_email, can_phone_no)
VALUES ('daphne_cassin', 'password',
        'App developer with 3 years of experience with React and React Native.',
        'Daphne', 'Cassin', 'runolfsdottir.issac@doyle.com', '5004765184');

INSERT INTO qvt0v9the6uowez2.candidate (can_username, can_password, can_description, can_firstName, can_lastName,
                                        can_email, can_phone_no)
VALUES ('jamey_hammes', 'password',
        'Junior database administrator with 2 years of experience with relational databases such as Oracle and MySQL, etc.',
        'Jamey', 'Hammes', 'stephania27@hirthe.com', '7057537044');

# Business
INSERT INTO qvt0v9the6uowez2.business_client (bus_client_username, bus_client_password, bus_client_company,
                                              bus_client_description, bus_client_address, bus_client_email,
                                              bus_client_phone, bus_client_website)
VALUES ('graham_kovacek', 'password', 'Graham-Kovacek Inc', 'Grow Next-Generation Partnerships',
        '6055 Dicki Fields Trenton, NJ 08650', 'bstroman@rice.info', '7135081285', 'pacificwestedge.com');

INSERT INTO qvt0v9the6uowez2.business_client (bus_client_username, bus_client_password, bus_client_company,
                                              bus_client_description, bus_client_address, bus_client_email,
                                              bus_client_phone, bus_client_website)
VALUES ('kerlukeplc', 'password', 'Kerluke-Hartmann PLC', 'Cross-Group Impactful Encryption',
        '43484 Franecki Vista Apt. 067West Jamar, QC X4N3P0', 'adolphus.mertz@balistreri.com', '4692242549',
        'miamibestbuys.com');

INSERT INTO qvt0v9the6uowez2.business_client (bus_client_username, bus_client_password, bus_client_company,
                                              bus_client_description, bus_client_address, bus_client_email,
                                              bus_client_phone, bus_client_website)
VALUES ('weberllc', 'password', 'Weber LLC Inc', 'Customer-Focused Multimedia Paradigm',
        '99103 Vella Ford Apt. 759Tatyanabury, NB T8L 9N4', 'mswift@hotmail.com', '5199090706', 'CleaningBasics.ca');

INSERT INTO qvt0v9the6uowez2.business_client (bus_client_username, bus_client_password, bus_client_company,
                                              bus_client_description, bus_client_address, bus_client_email,
                                              bus_client_phone, bus_client_website)
VALUES ('schulist', 'password', 'Schulist, Gusikowski and Keebler and Sons', 'Robust Systematic Synergy',
        '346 Schuppe RidgeLake Tanner, NU V7Y 8N5', 'leffler.kiana@lemke.biz', '6048571575', 'SearchRoofing.ca');

INSERT INTO qvt0v9the6uowez2.business_client (bus_client_username, bus_client_password, bus_client_company,
                                              bus_client_description, bus_client_address, bus_client_email,
                                              bus_client_phone, bus_client_website)
VALUES ('walsh', 'password', 'Walsh and Sons', 'Compatible High-Level Portal',
        '218 Legros ForksNicholashaven, NU V1J2C4', 'dosinski@shanahan.org', '5700426654', 'AccomodationRentals.ca
');

# Advisor
INSERT INTO qvt0v9the6uowez2.advisor (advisor_username, advisor_password, advisor_firstName, advisor_lastName,
                                      advisor_Email)
VALUES ('genesis_caroll', 'password', 'Genesis', 'Carroll', 'moore.leonie@nicolas.biz');

INSERT INTO qvt0v9the6uowez2.advisor (advisor_username, advisor_password, advisor_firstName, advisor_lastName,
                                      advisor_Email)
VALUES ('yemard', 'password', 'Madyson', 'Ullrich', 'madyson74@haag.biz');

INSERT INTO qvt0v9the6uowez2.advisor (advisor_username, advisor_password, advisor_firstName, advisor_lastName,
                                      advisor_Email)
VALUES ('dharber', 'password', 'Andreanne', 'Oberbrunner', 'cary45@gmail.com');

INSERT INTO qvt0v9the6uowez2.advisor (advisor_username, advisor_password, advisor_firstName, advisor_lastName,
                                      advisor_Email)
VALUES ('esther81', 'password', 'Yasmeen', 'Mosciski', 'melany14@mills.biz');

INSERT INTO qvt0v9the6uowez2.advisor (advisor_username, advisor_password, advisor_firstName, advisor_lastName,
                                      advisor_Email)
VALUES ('brendon10', 'password', 'Elton', 'Dietrich', 'bboyle@yahoo.com');

# Candidate Role
INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (1, 1);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (1, 2);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (1, 12);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (1, 22);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (2, 4);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (2, 6);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (2, 18);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (2, 20);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (3, 3);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (3, 14);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (3, 15);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (3, 1);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (3, 25);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (4, 21);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (4, 22);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (4, 23);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (4, 13);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (5, 19);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (5, 18);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (5, 17);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (5, 16);

INSERT INTO qvt0v9the6uowez2.candidate_role (candidateID, roleID)
VALUES (5, 15);

# Candidate Skill
INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (1, 1, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (1, 2, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (1, 3, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (1, 4, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (1, 5, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (2, 6, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (2, 7, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (2, 8, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (2, 9, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (2, 10, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (3, 11, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (3, 12, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (3, 13, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (3, 14, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (3, 15, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (3, 16, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (4, 17, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (4, 18, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (4, 19, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (4, 20, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (4, 21, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (5, 5, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (5, 25, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (5, 30, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (5, 9, null);

INSERT INTO qvt0v9the6uowez2.candidate_skill (candidateID, skillID, added_date)
VALUES (5, 29, null);

# Job Posting
INSERT INTO qvt0v9the6uowez2.job_posting (advisorID, business_clientID, job_title, post_date, job_status,
                                          job_description, requirements, wage, location, start_date, end_date,
                                          applicants)
VALUES (2, 2, 'SCADA Developer', DEFAULT, 'fullTime',
        'The SCADA developer will create, implement, and support innovative technology solutions for SCADA platforms, IIoT, and automation middleware.',
        '2 to 5+ years of experience as a developer', 129000, 'Calgary', '2021-05-01', '2021-12-31', 0);

INSERT INTO qvt0v9the6uowez2.job_posting (advisorID, business_clientID, job_title, post_date, job_status,
                                          job_description, requirements, wage, location, start_date, end_date,
                                          applicants)
VALUES (3, 3, 'Java Engineer', DEFAULT, 'fullTime',
        'We are looking for Software Engineers to join our Infrastructure team to design and develop highly distributed microservices that together form an API our customers rely upon, that drives our “Network as a Service” platform. This is a unique opportunity that will give the selected candidate(s) the ability to learn about the operation of a mobile network and hands-on experience developing software systems that form the backbone of our services.',
        'Bachelor’s Degree in Computer Science or a related field
3+ years development experience in Java (preferably working with Spring) . Nice, but not mandatory, experience in another language (OOP or other)',
        61000, 'Calgary', '2021-05-01', '2021-12-31', 0);

INSERT INTO qvt0v9the6uowez2.job_posting (advisorID, business_clientID, job_title, post_date, job_status,
                                          job_description, requirements, wage, location, start_date, end_date,
                                          applicants)
VALUES (3, 4, 'Junior Java Developer', DEFAULT, 'fullTime',
        'Responsible for the development and maintenance of the company''s existing integrated platform.',
        '1+ years of experience developing software in Java.',
        40000, 'Calgary', '2021-05-01', '2021-12-31', 0);

INSERT INTO qvt0v9the6uowez2.job_posting (advisorID, business_clientID, job_title, post_date, job_status,
                                          job_description, requirements, wage, location, start_date, end_date,
                                          applicants)
VALUES (3, 4, 'Java Developer', DEFAULT, 'fullTime',
        'Metal Supermarkets, the world’s largest supplier of small-quantity metals, is seeking a Java Developer to join our team.',
        'Bachelor’s Degree in software engineering, Computer Science, or a related along with 5-6 years of experience.',
        45000, 'Calgary', '2021-05-01', '2021-12-31', 0);

INSERT INTO qvt0v9the6uowez2.job_posting (advisorID, business_clientID, job_title, post_date, job_status,
                                          job_description, requirements, wage, location, start_date, end_date,
                                          applicants)
VALUES (4, 5, 'Full Stack Developer', DEFAULT, 'fullTime',
        'Global IQX is looking for software engineers that are enthusiastic, interested in exploring new technology, enjoy developing innovative products, and love being part of a team.',
        'Computer Science / Engineering related university / college degree or higher.',
        60000, 'Calgary', '2021-05-01', '2021-12-31', 0);




