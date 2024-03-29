drop table lgrdb.application cascade;
drop table lgrdb.candidate_role cascade;
drop table lgrdb.candidate_skill cascade;
drop table lgrdb.education cascade;
drop table lgrdb.job_posting cascade;
drop table lgrdb.business_client cascade;
drop table lgrdb.log cascade;
drop table lgrdb.role cascade;
drop table lgrdb.skill cascade;
drop table lgrdb.work_history cascade;
drop table lgrdb.candidate cascade;
drop table lgrdb.advisor cascade;

create table advisor
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

alter table advisor
    add primary key (advisorID);

create table business_client
(
    business_clientID      int auto_increment
        primary key,
    bus_client_username    varchar(45)  not null,
    bus_client_password    varchar(64)  not null,
    bus_client_company     varchar(50)  not null,
    bus_client_description text         null,
    bus_client_address     varchar(255) null,
    bus_client_email       varchar(255) not null,
    bus_client_phone       varchar(10)  null,
    bus_client_website     varchar(255) null,
    constraint bus_client_email_UNIQUE
        unique (bus_client_email),
    constraint bus_client_username_UNIQUE
        unique (bus_client_username)
);

create table candidate
(
    candidateID   int auto_increment
        primary key,
    advisorID     int          null,
    can_username  varchar(45)  not null,
    can_password  varchar(64)  not null,
    can_description text           null,
    can_firstName varchar(45)  not null,
    can_lastName  varchar(45)  not null,
    can_email     varchar(255) not null,
    can_phone_no  varchar(10)  null,
    placed        tinyint(1)   null,
    constraint can_email_UNIQUE
        unique (can_email),
    constraint can_username_UNIQUE
        unique (can_username),
    constraint FK_CANDIDATE_ADVISOR
        foreign key (advisorID) references advisor (advisorID)
            on delete cascade
);

create index FK_CANDIDATE_ADVISOR_idx
    on candidate (advisorID);

create table education
(
    educationID int auto_increment
        primary key,
    candidateID int                  null,
    level       varchar(55)          not null,
    institution varchar(255)         not null,
    subject     varchar(255)         not null,
    start_date  datetime             not null,
    end_date    datetime             null,
    type        tinyint(1) default 1 not null,
    constraint FK_EDUCATION_CANDIDATE
        foreign key (candidateID) references candidate (candidateID)
            on delete cascade
);

create index FK_EDUCATION_CANDIDATE_idx
    on education (candidateID);

create table job_posting
(
    job_postingID     int auto_increment
        primary key,
    advisorID         int                      not null,
    business_clientID int                      not null,
    job_title         text                     not null,
    post_date         datetime default now()   not null,
    job_status        varchar(45)              null,
    job_description   text                     null,
    requirements      text                     null,
    wage              double                   null,
    location          varchar(45)              null,
    start_date        date                     null,
    end_date          date                     null,
    applicants        int                      null,
    constraint FK_JOB_P_ADVISOR
        foreign key (advisorID) references advisor (advisorID),
    constraint FK_JOB_P_BUS_CLIENT
        foreign key (business_clientID) references business_client (business_clientID)
            on delete cascade
);

create table application
(
    applicationID int auto_increment
        primary key,
    candidateID   int               null,
    job_postingID int               null,
    status        tinyint default 0 null,
    constraint FK_APPLICATION_JP
        foreign key (job_postingID) references job_posting (job_postingID)
            on delete cascade,
    constraint FK_APPLICATION_CAN
        foreign key (candidateID) references candidate (candidateID)
            on delete cascade
);

create index FK_APPLICAITON_JP_idx
    on application (job_postingID);

create index FK_APPLICATION_CAN_idx
    on application (candidateID);

create index FK_JOB_P_ADVISOR_idx
    on job_posting (advisorID);

create index FK_JOB_P_BUS_CLIENT_idx
    on job_posting (business_clientID);

create table log
(
    logID       int auto_increment
        primary key,
    advisorID   int                       not null,
    login_date  timestamp default now()   not null,
    logout_date timestamp                 null,
    description varchar(255)              null,
    constraint FK_log_advisor
        foreign key (advisorID) references advisor (advisorID)
            on delete cascade
);

create index advisorID_idx
    on log (advisorID);

create table role
(
    roleID      int auto_increment not null
        primary key,
    description varchar(255) null
);

create table candidate_role
(
	can_roleID int auto_increment 
		primary key,
    candidateID int not null,
    roleID      int not null,
    constraint FK_CANDIDATE_ROLE_CANDIDATE
        foreign key (candidateID) references candidate (candidateID)
            on delete cascade,
    constraint FK_CANDIDATE_ROLE_ROLE
        foreign key (roleID) references role (roleID)
            on delete cascade
);

create index FK_CANDIDATE_ROLE_ROLE_idx
    on candidate_role (roleID);

create table skill
(
    skillID     int auto_increment not null
        primary key,
    description varchar(255) not null
);

create table candidate_skill
(
    can_skillID int auto_increment
        primary key,
    candidateID int  null,
    skillID     int  null,
    added_date  date null,
    constraint FK_CAN_SKILL_CAN
        foreign key (candidateID) references candidate (candidateID)
            on delete cascade,
    constraint FK_CAN_SKILL_SKILL
        foreign key (skillID) references skill (skillID)
            on delete cascade
);

create index FK_CAN_SKILL_CAN_idx
    on candidate_skill (candidateID);

create index FK_CAN_SKILL_SKILL_idx
    on candidate_skill (skillID);

create table work_history
(
    work_historyID int auto_increment
        primary key,
    candidateID    int          null,
    company        varchar(100) not null,
    title          varchar(100) not null,
    start_date     datetime     not null,
    end_date       datetime     null,
    reference      varchar(255) null,
    constraint FK_WORK_HISTORY_CANDIDATE
        foreign key (candidateID) references candidate (candidateID)
            on delete cascade
);

create index FK_WORK_HISTORY_CANDIDATE_idx
    on work_history (candidateID);