insert into Event values(1,'Event 1',0)
insert into Event values(2,'Event 2',0)
insert into Event values(3,'Event 3',0)
insert into Event values(4,'Event 4',0)
insert into Event values(5,'Event 5',0)
insert into Event values(6,'Event 6',0)

insert into Participant(id,name) values(1,'Participant 1')
insert into Participant(id,name) values(2,'Participant 2')
insert into Participant(id,name) values(3,'Participant 3')
insert into Participant(id,name) values(4,'Participant 4')
insert into Participant(id,name) values(5,'Participant 5')

insert into Skill(id,name) values(1,'Java');
insert into Skill(id,name) values(2,'Javascript');
insert into Skill(id,name) values(3,'Android');
insert into Skill(id,name) values(4,'Ruby');
insert into Skill(id,name) values(5,'Python');

insert into Event_Participant(participants_id,events_id) values (1,1);
insert into Event_Participant(participants_id,events_id) values (2,1);
insert into Event_Participant(participants_id,events_id) values (2,2);
insert into Event_Participant(participants_id,events_id) values (3,1);
insert into Event_Participant(participants_id,events_id) values (5,2);

insert into Participant_Skill values (1,1);
insert into Participant_Skill values (1,2);
insert into Participant_Skill values (2,3);
insert into Participant_Skill values (3,4);
insert into Participant_Skill values (3,5);
