#================================ drop tables===========================
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

#================================ create tables===========================
create table lgrdb.advisor
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

alter table lgrdb.advisor
    add primary key (advisorID);

create table lgrdb.business_client
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
        foreign key (advisorID) references lgrdb.advisor (advisorID)
);

create index FK_BUSINESS_CLIENT_ADVISOR_idx
    on lgrdb.business_client (advisorID);

create table lgrdb.candidate
(
    candidateID   int auto_increment
        primary key,
    advisorID     int          null,
    can_username  varchar(45)  not null,
    can_password  varchar(64)  not null,
    can_firstName varchar(45)  not null,
    can_lastName  varchar(45)  not null,
    can_email     varchar(255) not null,
    can_phone_no  varchar(10)  null,
    placed        tinyint(1)   null,
    constraint can_email_UNIQUE
        unique (can_email),
    constraint can_password_UNIQUE
        unique (can_password),
    constraint can_username_UNIQUE
        unique (can_username),
    constraint FK_CANDIDATE_ADVISOR
        foreign key (advisorID) references lgrdb.advisor (advisorID)
);

create index FK_CANDIDATE_ADVISOR_idx
    on lgrdb.candidate (advisorID);

create table lgrdb.education
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
        foreign key (candidateID) references lgrdb.candidate (candidateID)
);

create index FK_EDUCATION_CANDIDATE_idx
    on lgrdb.education (candidateID);

create table lgrdb.job_posting
(
    job_postingID     int auto_increment
        primary key,
    business_clientID int                                not null,
    requirements      varchar(255)                       not null,
    title             varchar(100)                       not null,
    jop_description   varchar(255)                       null,
	job_status        varchar(30)                        null,
    start_date        datetime default CURRENT_TIMESTAMP null,
    end_date          datetime                           null,
    applicants        varchar(255)                       null,
    constraint business_clientID_UNIQUE
        unique (business_clientID),
    constraint FK_JOB_POSTING_BUSINESS_CLIENT
        foreign key (business_clientID) references lgrdb.business_client (business_clientID)
);

create table lgrdb.application
(
    candidateID   int not null,
    job_postingID int not null,
    primary key (candidateID, job_postingID),
    constraint FK_APPLICATION_CANDIDATE
        foreign key (candidateID) references lgrdb.candidate (candidateID),
    constraint FK_APPLICATION_JOB_POSTING
        foreign key (job_postingID) references lgrdb.job_posting (job_postingID)
);

create index FK_APPLICATION_JOB_POSTING_idx
    on lgrdb.application (job_postingID);

create index FK_JOB_POSTING_BUSINESS_CLIENT_idx
    on lgrdb.job_posting (business_clientID);

create table lgrdb.log
(
    logID       int auto_increment
        primary key,
    advisorID   int                                 not null,
    login_date  timestamp default CURRENT_TIMESTAMP not null,
    logout_date timestamp                           null,
    description varchar(255)                        null,
    constraint FK_log_advisor
        foreign key (advisorID) references lgrdb.advisor (advisorID)
);

create index advisorID_idx
    on lgrdb.log (advisorID);

create table lgrdb.role
(
    roleID      int          not null
        primary key,
    description varchar(255) null
);

create table lgrdb.candidate_role
(
    candidateID int not null,
    roleID      int not null,
    primary key (candidateID, roleID),
    constraint FK_CANDIDATE_ROLE_CANDIDATE
        foreign key (candidateID) references lgrdb.candidate (candidateID),
    constraint FK_CANDIDATE_ROLE_ROLE
        foreign key (roleID) references lgrdb.role (roleID)
);

create index FK_CANDIDATE_ROLE_ROLE_idx
    on lgrdb.candidate_role (roleID);

create table lgrdb.skill
(
    skillID     int          not null
        primary key,
    description varchar(255) not null
);

create table lgrdb.candidate_skill
(
    candidateID int      not null,
    skillID     int      not null,
    added_date  datetime null,
    primary key (candidateID, skillID),
    constraint FK_CANDIDATE_SKILLS_CANDIDATE
        foreign key (candidateID) references lgrdb.candidate (candidateID),
    constraint FK_CANDIDATE_SKILLS_SKILL
        foreign key (skillID) references lgrdb.skill (skillID)
);

create index FK_CANDIDATE_SKILLS_SKILL_idx
    on lgrdb.candidate_skill (skillID);

create table lgrdb.work_history
(
    work_hisotry_id int auto_increment
        primary key,
    candidateID     int          null,
    company         varchar(100) not null,
    title           varchar(100) not null,
    start_date      datetime     not null,
    end_date        datetime     null,
    reference       varchar(255) null,
    constraint FK_WORK_HISTORY_CANDIDATE
        foreign key (candidateID) references lgrdb.candidate (candidateID)
);

create index FK_WORK_HISTORY_CANDIDATE_idx
    on lgrdb.work_history (candidateID);

