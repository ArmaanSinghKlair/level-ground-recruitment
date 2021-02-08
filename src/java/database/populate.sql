# advisor table
INSERT INTO `lgrdb`.advisor (advisor_username, advisor_password, advisor_firstName, advisor_lastName,
                                          advisor_Email)
VALUES ('Vany1966', 'No6Ahcohch', 'Teresa', 'Keller', 'TeresaMKeller@rhyta.com');
INSERT INTO `lgrdb`.advisor (advisor_username, advisor_password, advisor_firstName, advisor_lastName,
                                          advisor_Email)
VALUES ('Rearmiend', 'aobai3ieYoh', 'Candace', 'McHale', 'CandaceWMcHale@teleworm.us');
INSERT INTO `lgrdb`.advisor (advisor_username, advisor_password, advisor_firstName, advisor_lastName,
                                          advisor_Email)
VALUES ('Laboyes85', 'cheeSh2ei', 'Michael', 'Brown', 'MichaelIBrown@armyspy.com');
INSERT INTO `lgrdb`.advisor (advisor_username, advisor_password, advisor_firstName, advisor_lastName,
                                          advisor_Email)
VALUES ('Herecintedid', 'CieFiri8Aas', 'George', 'Gonzales', 'GeorgeJGonzales@rhyta.com');

# log table
INSERT INTO `lgrdb`.log (advisorID, login_date, logout_date, description)
VALUES (1001, now(), '2021-02-08 08:23:17', 'N/A');

# candidate table
INSERT INTO `lgrdb`.candidate (advisorID, can_username, can_password, can_firstName, can_lastName,
                                            can_email, can_phone_no, work_history, primary_education,
                                            secondary_education, certificates, key_skills, interested_roles, placed)
VALUES (1001, 'Whisce63', 'ooth8Eeng', 'Gerald', 'Grenier', 'GeraldBGrenier@jourrapide.com', '9193178095'
           , 'n/a', 'n/a', 'n/a',
        'n/a', 'n/a', 'n/a', -1);
INSERT INTO `lgrdb`.candidate (advisorID, can_username, can_password, can_firstName, can_lastName,
                                            can_email, can_phone_no, work_history, primary_education,
                                            secondary_education, certificates, key_skills, interested_roles, placed)
VALUES (1002, 'Satterep', 'eebohno7Tha', 'Kristina', 'Campbell', 'KristinaJCampbell@teleworm.us', '9076335785'
           , 'n/a', 'n/a', 'n/a',
        'n/a', 'n/a', 'n/a', 1);
INSERT INTO `lgrdb`.candidate (advisorID, can_username, can_password, can_firstName, can_lastName,
                                            can_email, can_phone_no, work_history, primary_education,
                                            secondary_education, certificates, key_skills, interested_roles, placed)
VALUES (1001, 'Onvalcor', 'meeduuDee9', 'Robby', 'Gonzalez', 'RobbyMGonzalez@rhyta.com', '6019950841', 'n/a', 'n/a',
        'n/a',
        'n/a', 'n/a', 'n/a', -1);
INSERT INTO `lgrdb`.candidate (advisorID, can_username, can_password, can_firstName, can_lastName,
                                            can_email, can_phone_no, work_history, primary_education,
                                            secondary_education, certificates, key_skills, interested_roles, placed)
VALUES (1003, 'Sols1978', 'Zaeghoo4Joh', 'Richard', 'Morales', 'RichardDMorales@dayrep.com', '2625238583', 'n/a', 'n/a',
        'n/a',
        'n/a', 'n/a', 'n/a', -1);
INSERT INTO `lgrdb`.candidate (advisorID, can_username, can_password, can_firstName, can_lastName,
                                            can_email, can_phone_no, work_history, primary_education,
                                            secondary_education, certificates, key_skills, interested_roles, placed)
VALUES (1004, 'Dereat', 'Ahthu3eeph7', 'Michael', 'Daye', 'MichaelGDaye@rhyta.com', '2163902611', 'n/a', 'n/a', 'n/a',
        'n/a', 'n/a', 'n/a', -1);
INSERT INTO `lgrdb`.candidate (advisorID, can_username, can_password, can_firstName, can_lastName,
                                            can_email, can_phone_no, work_history, primary_education,
                                            secondary_education, certificates, key_skills, interested_roles, placed)
VALUES (1004, 'Antandigule', 'co6Aishoo', 'Alice', 'Montano', 'AliceJMontano@rhyta.com', '2138390502', 'n/a', 'n/a',
        'n/a', 'n/a', 'n/a', 'n/a', 1);

commit;
# business client table
INSERT INTO `lgrdb`.business_client (advisorID, bus_client_username, bus_client_password,
                                                  bus_client_firstName, bus_client_lastName, bus_client_email,
                                                  bus_client_phone, bus_client_payment)
VALUES (1001, 'Dinew1982', 'maup8Bai7v', 'Daniele', 'Brown', 'DanieleDBrown@teleworm.us', 5864182559, 'n/a');
INSERT INTO `lgrdb`.business_client (advisorID, bus_client_username, bus_client_password,
                                                  bus_client_firstName, bus_client_lastName, bus_client_email,
                                                  bus_client_phone, bus_client_payment)
VALUES (1002, 'Warang', 've6Cheefee3', 'Michael', 'McGuire', 'MichaelPMcGuire@dayrep.com', 8592181198, 'n/a');
INSERT INTO `lgrdb`.business_client (advisorID, bus_client_username, bus_client_password,
                                                  bus_client_firstName, bus_client_lastName, bus_client_email,
                                                  bus_client_phone, bus_client_payment)
VALUES (1002, 'Upast1993', 'nah9aisooM', 'Scott', 'Harris', 'ScottRHarris@dayrep.com', 9034567642, 'n/a');
INSERT INTO `lgrdb`.business_client (advisorID, bus_client_username, bus_client_password,
                                                  bus_client_firstName, bus_client_lastName, bus_client_email,
                                                  bus_client_phone, bus_client_payment)
VALUES (1001, 'Foress', 'nephu2Phu9ie', 'Colleen', 'Tuttle', 'ColleenCTuttle@teleworm.us', 9709635084, 'n/a');
INSERT INTO `lgrdb`.business_client (advisorID, bus_client_username, bus_client_password,
                                                  bus_client_firstName, bus_client_lastName, bus_client_email,
                                                  bus_client_phone, bus_client_payment)
VALUES (1001, 'Staided', 'kooS9ulood', 'Paul', 'Alvarez', 'PaulHAlvarez@armyspy.com', 2172575051, 'n/a');

commit;

# Job Posting table
INSERT INTO `lgrdb`.job_posting (business_clientID, requirements, start_date, end_date, applicants)
VALUES (1001, 'n/a', now(), '2021-12-01', 'n/a');
INSERT INTO `lgrdb`.job_posting (business_clientID, requirements, start_date, end_date, applicants)
VALUES (1002, 'n/a', now(), '2021-04-05', 'n/a');
INSERT INTO `lgrdb`.job_posting (business_clientID, requirements, start_date, end_date, applicants)
VALUES (1003, 'n/a', now(), '2021-05-15', 'n/a');
INSERT INTO `lgrdb`.job_posting (business_clientID, requirements, start_date, end_date, applicants)
VALUES (1004, 'n/a', now(), '2021-09-01', 'n/a');


commit;
