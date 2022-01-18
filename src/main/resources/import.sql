INSERT INTO tb_covid_info(uid, cases, date_time, deaths, refuses, state, suspects) VALUES (1, 10, current_timestamp, 10, 5, 'São paulo', 5);
INSERT INTO uf (uf, covid_id) VALUES ('SP', 1);
INSERT INTO uf (uf, covid_id) VALUES ('RJ', null);