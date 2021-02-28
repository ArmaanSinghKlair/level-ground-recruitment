
drop table lgrdb.work_history cascade;


create table lgrdb.work_history
(
    work_history_id int auto_increment
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

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  839645
 * Created: Feb 26, 2021
 */

