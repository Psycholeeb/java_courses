insert into address (address) value ('Ap #999-6608 Felis, St.');
insert into address (address) value ('8403 In Road');
insert into address (address) value ('4895 Dolor. Road');
insert into address (address) value ('233-3092 Sem Av.');
insert into address (address) value ('Ap #258-8948 At, Rd.');
insert into address (address) value ('2911 Nec, Rd.');
insert into address (address) value ('7886 Proin St.');
insert into address (address) value ('Ap #314-418 Lorem Av.');
insert into address (address) value ('Ap #650-4921 Aptent Ave');
insert into address (address) value ('Ap #821-4665 Lorem, Rd.');

insert into person (first_name, last_name, address_id) values ('Vincent', 'Keith', 1);
insert into person (first_name, last_name, address_id) values ('Fritz', 'Bray', 2);
insert into person (first_name, last_name, address_id) values ('Lyle', 'Patterson', 3);
insert into person (first_name, last_name, address_id) values ('Holmes', 'Hardy', 4);
insert into person (first_name, last_name, address_id) values ('Cody', 'Larson', 5);
insert into person (first_name, last_name, address_id) values ('Gary', 'Ellis', 6);
insert into person (first_name, last_name, address_id) values ('Victor', 'Jensen', 7);
insert into person (first_name, last_name, address_id) values ('Galvin', 'Freeman', 8);
insert into person (first_name, last_name, address_id) values ('Jack', 'Foley', 9);
insert into person (first_name, last_name, address_id) values ('Christian', 'Torres', 10);
insert into person (first_name, last_name, address_id) values ('Peter', 'Haney', 3);
insert into person (first_name, last_name, address_id) values ('Cameron', 'Barry', 2);
insert into person (first_name, last_name, address_id) values ('Aladdin', 'Barnett', 9);
insert into person (first_name, last_name, address_id) values ('Lionel', 'Soto', 1);
insert into person (first_name, last_name, address_id) values ('Preston', 'Trujillo', 1);

select first_name, last_name from person where first_name like'G%';
select id, address from address where id>5;