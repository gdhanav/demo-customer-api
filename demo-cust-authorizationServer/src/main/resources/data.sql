INSERT INTO app_role (id, role_name, description) VALUES (1, 'USER', 'Normal User');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN', 'Admin User');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (1, 'test', 'user1', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 'test.user1');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (2, 'test', 'user2', '$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu', 'test.user2');


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);