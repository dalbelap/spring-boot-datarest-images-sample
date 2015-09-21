show tables;
/* 
 * Insert data on start application (mvn spring-boot:run)
 */
INSERT INTO user_profile(id, email, encrypted_password, first_name, last_name, role, enabled, created, version)
 VALUES (23, 'mperez@localhost', 'ab4572cf32523f234a', 'María', 'Pérez', 0, 1, now(), 0);
insert into user_profile(id, email, encrypted_password, first_name, last_name, role, enabled, created, version) VALUES(24, 'jfernandez@localhost', 'ab4572cf32523f234a', 'Jose', 'Fernandez', 0, 1, now(), 0);
insert into user_profile(id, email, encrypted_password, first_name, last_name, role, enabled, created, version) VALUES(25, 'cmaragallo@localhost', 'ab4572cf32523f234a', 'Carlos', 'Maragallo', 0, 1, now(), 0);

insert into picture(id, user_profile_id, picture_file, original_file_name, picture_title, picture_description, file_size, created, version) values(20, 23, 0xffff, 'onepicture.png', 'One Picture', 'descripcion', 12312, now(), 0);
insert into picture(id, user_profile_id, picture_file, original_file_name, picture_title, picture_description, file_size, created, version) values(21, 24, 0xffff, 'two_picture.png', 'Two Picture', 'descripcion', 12312, now(), 0);
insert into picture(id, user_profile_id, picture_file, original_file_name, picture_title, picture_description, file_size, created, version) values(22, 23, 0xffff, 'three_picture.png', 'Three Picture', 'descripcion', 12312, now(), 0);
insert into picture(id, user_profile_id, picture_file, original_file_name, picture_title, picture_description, file_size, created, version) values(23, 25, 0xffff, 'four_picture.png', 'Four Picture', 'descripcion', 12312, now(), 0);

insert into comment(user_profile_id, picture_id, comment_text, created) VALUES(23, 21, 'OMG, wonderful', now());
insert into comment(user_profile_id, picture_id, comment_text, created) VALUES(23, 23, 'Fantastic :)', now());
insert into comment(user_profile_id, picture_id, comment_text, created) VALUES(24, 20, 'Great!', now());
insert into comment(user_profile_id, picture_id, comment_text, created) VALUES(24, 22, 'This is the best', now());

insert into tag(id, tag_name, created) values(1, 'nature', now());
insert into tag(id, tag_name, created) values(2, 'urban', now());
insert into tag(id, tag_name, created) values(3, 'animals', now());

insert into picture_tags(picture_id, tag_id) values(20, 1);
insert into picture_tags(picture_id, tag_id) values(20, 3);
insert into picture_tags(picture_id, tag_id) values(23, 3);
insert into picture_tags(picture_id, tag_id) values(21, 2);
insert into picture_tags(picture_id, tag_id) values(22, 2);
