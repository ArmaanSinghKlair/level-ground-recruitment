# advisor table
INSERT INTO `lgrdb`.advisor (advisor_username, advisor_password, advisor_firstName, advisor_lastName,
                                          advisor_Email)
VALUES ('Vany1966', '233abcf8008e249629ee9bdcdac22d751c02332c80a5d555a6febea15e0d9f9c', 'Teresa', 'Keller', 'TeresaMKeller@rhyta.com');
INSERT INTO `lgrdb`.advisor (advisor_username, advisor_password, advisor_firstName, advisor_lastName,
                                          advisor_Email)
VALUES ('Rearmiend', '14709cafbceece732d03c2f3128d74ab9dd9ce328dc4fa014b0f0600f7068405', 'Candace', 'McHale', 'CandaceWMcHale@teleworm.us');
INSERT INTO `lgrdb`.advisor (advisor_username, advisor_password, advisor_firstName, advisor_lastName,
                                          advisor_Email)
VALUES ('Laboyes85', '2e8479d62b592a7e534f06375a4503500b69fd12072cf6ff09594d9ce9e1bb1c', 'Michael', 'Brown', 'MichaelIBrown@armyspy.com');
INSERT INTO `lgrdb`.advisor (advisor_username, advisor_password, advisor_firstName, advisor_lastName,
                                          advisor_Email)
VALUES ('Herecintedid', '8b975785e58dc0b98fd2c7caca8048b35ad98c52933763934d69f3cdaf491a05', 'George', 'Gonzales', 'GeorgeJGonzales@rhyta.com');

# log table
INSERT INTO `lgrdb`.log (advisorID, login_date, logout_date, description)
VALUES (1001, now(), '2021-02-08 08:23:17', 'N/A');

# candidate table
INSERT INTO `lgrdb`.candidate (advisorID, can_username, can_password, can_firstName, can_lastName,
                                            can_email, can_phone_no, work_history, primary_education,
                                            secondary_education, certificates, key_skills, interested_roles, placed)
VALUES (1001, 'Whisce63', '787c0b64f9dfdaeeb6dd8f6ef1f87083c9b33a9fa9bef73775daebf56d4611f0', 'Gerald', 'Grenier', 'GeraldBGrenier@jourrapide.com', '9193178095'
           , 'n/a', 'n/a', 'n/a',
        'n/a', 'n/a', 'n/a', -1);
INSERT INTO `lgrdb`.candidate (advisorID, can_username, can_password, can_firstName, can_lastName,
                                            can_email, can_phone_no, work_history, primary_education,
                                            secondary_education, certificates, key_skills, interested_roles, placed)
VALUES (1002, 'Satterep', 'e276686c9d814d5e765bd30953b8393849f97ae7770c31aa599d08d1d54bce35', 'Kristina', 'Campbell', 'KristinaJCampbell@teleworm.us', '9076335785'
           , 'n/a', 'n/a', 'n/a',
        'n/a', 'n/a', 'n/a', 1);
INSERT INTO `lgrdb`.candidate (advisorID, can_username, can_password, can_firstName, can_lastName,
                                            can_email, can_phone_no, work_history, primary_education,
                                            secondary_education, certificates, key_skills, interested_roles, placed)
VALUES (1001, 'Onvalcor', '1dfdedd9f8e49ae330b66db8981b30edab681bb7632bc923ad18094069abd0cc', 'Robby', 'Gonzalez', 'RobbyMGonzalez@rhyta.com', '6019950841', 'n/a', 'n/a',
        'n/a',
        'n/a', 'n/a', 'n/a', -1);
INSERT INTO `lgrdb`.candidate (advisorID, can_username, can_password, can_firstName, can_lastName,
                                            can_email, can_phone_no, work_history, primary_education,
                                            secondary_education, certificates, key_skills, interested_roles, placed)
VALUES (1003, 'Sols1978', 'e1f248ce7bc41379df9ebc9d342f8e5539b6b252757391816185dd25a61b0b34', 'Richard', 'Morales', 'RichardDMorales@dayrep.com', '2625238583', 'n/a', 'n/a',
        'n/a',
        'n/a', 'n/a', 'n/a', -1);
INSERT INTO `lgrdb`.candidate (advisorID, can_username, can_password, can_firstName, can_lastName,
                                            can_email, can_phone_no, work_history, primary_education,
                                            secondary_education, certificates, key_skills, interested_roles, placed)
VALUES (1004, 'Dereat', '197848652dfe3d1e3402ee2dad735f0e08b58554462dd0a027b1ea7314ea479f', 'Michael', 'Daye', 'MichaelGDaye@rhyta.com', '2163902611', 'n/a', 'n/a', 'n/a',
        'n/a', 'n/a', 'n/a', -1);
INSERT INTO `lgrdb`.candidate (advisorID, can_username, can_password, can_firstName, can_lastName,
                                            can_email, can_phone_no, work_history, primary_education,
                                            secondary_education, certificates, key_skills, interested_roles, placed)
VALUES (1004, 'Antandigule', '257eeaae08f04dcbd7bf6bd12973b5b11c9403339d3ac872410cdc1fb5dab293', 'Alice', 'Montano', 'AliceJMontano@rhyta.com', '2138390502', 'n/a', 'n/a',
        'n/a', 'n/a', 'n/a', 'n/a', 1);

commit;
# business client table
INSERT INTO `lgrdb`.business_client (advisorID, bus_client_username, bus_client_password,
                                                  bus_client_firstName, bus_client_lastName, bus_client_email,
                                                  bus_client_phone, bus_client_payment)
VALUES (1001, 'Dinew1982', '9ddc6572c802379c46f81a217ec910f9398aa1cf5f07f23f50a8ba7de9c1c1e1', 'Daniele', 'Brown', 'DanieleDBrown@teleworm.us', 5864182559, 'n/a');
INSERT INTO `lgrdb`.business_client (advisorID, bus_client_username, bus_client_password,
                                                  bus_client_firstName, bus_client_lastName, bus_client_email,
                                                  bus_client_phone, bus_client_payment)
VALUES (1002, 'Warang', '18cc4dfc98be33603d2f0af0a705c99f5a690299991a8eb54a4d504fd62e832a', 'Michael', 'McGuire', 'MichaelPMcGuire@dayrep.com', 8592181198, 'n/a');
INSERT INTO `lgrdb`.business_client (advisorID, bus_client_username, bus_client_password,
                                                  bus_client_firstName, bus_client_lastName, bus_client_email,
                                                  bus_client_phone, bus_client_payment)
VALUES (1002, 'Upast1993', '434060aae1f8f17ca3525467ea42864873b13d59cd702026b90f786164e7c1fb', 'Scott', 'Harris', 'ScottRHarris@dayrep.com', 9034567642, 'n/a');
INSERT INTO `lgrdb`.business_client (advisorID, bus_client_username, bus_client_password,
                                                  bus_client_firstName, bus_client_lastName, bus_client_email,
                                                  bus_client_phone, bus_client_payment)
VALUES (1001, 'Foress', 'de19af0135563015bff8faf0debb568e30fbfaa2f6d250f2cd9820de8917e26d', 'Colleen', 'Tuttle', 'ColleenCTuttle@teleworm.us', 9709635084, 'n/a');
INSERT INTO `lgrdb`.business_client (advisorID, bus_client_username, bus_client_password,
                                                  bus_client_firstName, bus_client_lastName, bus_client_email,
                                                  bus_client_phone, bus_client_payment)
VALUES (1001, 'Staided', '6e234059c36404d3ff8acf8c7c5af912e8e5b12897991246a00916b8ba6a64a4', 'Paul', 'Alvarez', 'PaulHAlvarez@armyspy.com', 2172575051, 'n/a');

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
