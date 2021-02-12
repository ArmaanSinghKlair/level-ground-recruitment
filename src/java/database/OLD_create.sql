drop table `lgrdb`.application cascade;
drop table `lgrdb`.log cascade;
drop table `lgrdb`.job_posting cascade;
drop table `lgrdb`.business_client cascade;
drop table `lgrdb`.candidate cascade;
drop table `lgrdb`.advisor cascade;

# advisor table`
create table `lgrdb`.advisor
(
    advisorID         int auto_increment,
    advisor_username  varchar(45) not null,
    advisor_password  varchar(64) not null,
    advisor_firstName varchar(45) not null,
    advisor_lastName  varchar(45) not null,
    advisor_Email     varchar(45) not null,
    constraint advisorID_UNIQUE
        unique (advisorID),
    constraint advisor_Email_UNIQUE
        unique (advisor_Email),
    constraint advisor_username_UNIQUE
        unique (advisor_username)
);

alter table `lgrdb`.advisor
    add primary key (advisorID);

# Log Table
create table `lgrdb`.log
(
    logID       int auto_increment
        primary key,
    advisorID   int                                 not null,
    login_date  timestamp default CURRENT_TIMESTAMP not null,
    logout_date timestamp                           null,
    description varchar(255)                        null,
    constraint FK_log_advisor
        foreign key (advisorID) references `lgrdb`.advisor (advisorID)
);

create index advisorID_idx
    on `lgrdb`.log (advisorID);

# Business_Client
create table `lgrdb`.business_client
(
    business_clientID    int auto_increment
        primary key,
    advisorID            int          null,
    bus_client_username  varchar(45)  not null,
    bus_client_password  varchar(64)  not null,
    bus_client_firstName varchar(45)  not null,
    bus_client_lastName  varchar(45)  not null,
    bus_client_email     varchar(255) not null,
    bus_client_phone     varchar(10)  null,
    bus_client_payment   varchar(255) not null,
    constraint bus_client_email_UNIQUE
        unique (bus_client_email),
    constraint bus_client_username_UNIQUE
        unique (bus_client_username),
    constraint FK_BUSINESS_CLIENT_ADVISOR
        foreign key (advisorID) references `lgrdb`.advisor (advisorID)
);

create index FK_BUSINESS_CLIENT_ADVISOR_idx
    on `lgrdb`.business_client (advisorID);

# Candidate Table
create table `lgrdb`.candidate
(
    candidateID         int auto_increment
        primary key,
    advisorID           int          null,
    can_username        varchar(45)  not null,
    can_password        varchar(64)  not null,
    can_firstName       varchar(45)  not null,
    can_lastName        varchar(45)  not null,
    can_email           varchar(255) not null,
    can_phone_no        varchar(10)  null,
    work_history        varchar(255) null,
    primary_education   varchar(255) null,
    secondary_education varchar(255) null,
    certificates        varchar(255) null,
    key_skills          varchar(255) null,
    interested_roles    varchar(255) null,
    placed              tinyint(1)   null,
    constraint can_email_UNIQUE
        unique (can_email),
    constraint can_password_UNIQUE
        unique (can_password),
    constraint can_username_UNIQUE
        unique (can_username),
    constraint FK_CANDIDATE_ADVISOR
        foreign key (advisorID) references `lgrdb`.advisor (advisorID)
);

create index FK_CANDIDATE_ADVISOR_idx
    on `lgrdb`.candidate (advisorID);

# Job Posting TABLE
CREATE TABLE `lgrdb`.`job_posting`
(
    `job_postingID`     INT          NOT NULL AUTO_INCREMENT,
    `business_clientID` INT          NOT NULL,
    `requirements`      VARCHAR(255) NOT NULL,
    `start_date`        DATETIME     NULL DEFAULT CURRENT_TIMESTAMP,
    `end_date`          DATETIME     NULL,
    `applicants`        VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`job_postingID`),
    INDEX `FK_JOB_POSTING_BUSINESS_CLIENT_idx` (`business_clientID` ASC) VISIBLE,
    UNIQUE INDEX `business_clientID_UNIQUE` (`business_clientID` ASC) VISIBLE,
    CONSTRAINT `FK_JOB_POSTING_BUSINESS_CLIENT`
        FOREIGN KEY (`business_clientID`)
            REFERENCES `lgrdb`.business_client (`business_clientID`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

# Application Table
create table `lgrdb`.application
(
    candidateID   int not null,
    job_postingID int not null,
    primary key (candidateID, job_postingID),
    constraint FK_APPLICATION_CANDIDATE
        foreign key (candidateID) references `lgrdb`.candidate (candidateID),
    constraint FK_APPLICATION_JOB_POSTING
        foreign key (job_postingID) references `lgrdb`.job_posting (job_postingID)
);

create index FK_APPLICATION_JOB_POSTING_idx
    on `lgrdb`.application (job_postingID);

# Set auto increment default value
alter table `lgrdb`.advisor
    Auto_Increment = 1001;

alter table `lgrdb`.log
    auto_increment = 1001;

alter table `lgrdb`.candidate
    auto_increment = 1001;

alter table `lgrdb`.job_posting
    auto_increment = 1001;

alter table `lgrdb`.business_client
    auto_increment = 1001;

