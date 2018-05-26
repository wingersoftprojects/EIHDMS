alter table batch_mob_app modify column add_date datetime;
alter table batch_mob_app modify column last_edit_date datetime;
alter table batch_mob_app add column status_m varchar(50);
alter table batch_mob_app add column status_m_desc text;
alter table batch_mob_app modify column add_date datetime;
alter table batch_mob_app modify column last_edit_date datetime;
alter table batch_mob_app add column batch_id int(11);
