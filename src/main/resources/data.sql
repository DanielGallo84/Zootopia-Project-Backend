/* Types */
INSERT INTO types (id_type, type) VALUES (default, 'Capybara');
INSERT INTO types (id_type, type) VALUES (default, 'Scorpion');
INSERT INTO types (id_type, type) VALUES (default, 'Rabbit');
INSERT INTO types (id_type, type) VALUES (default, 'Red Panda');

/* Families */
INSERT INTO families (id_family, family) VALUES (default, 'Félidos');
INSERT INTO families (id_family, family) VALUES (default, 'Cánidos ');
INSERT INTO families (id_family, family) VALUES (default, 'Reptiles');
INSERT INTO families (id_family, family) VALUES (default, 'Mustelids');
INSERT INTO families (id_family, family) VALUES (default, 'Leporidae');

/* Genders */
INSERT INTO genders (id_gender, gender) VALUES (default, 'Male');
INSERT INTO genders (id_gender, gender) VALUES (default, 'Female');

/* Animals */
INSERT INTO animals (id_animal, name, admission_date, type_id, family_id, gender_id) VALUES (default, 'Mark', CURRENT_TIMESTAMP, 1, 1, 1);

/* Roles */
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_USER');

/* Users */
INSERT INTO users (id_user, username, password) VALUES (default, 'VeroLaJefe', '$2a$12$6w1wl3EyzUOTHxX/NHDBWOkXiQQuDwT31k5jWPxkxp1WXXSEspsqi');

/* Roles_Users */
INSERT INTO roles_users (user_id, role_id) VALUES (1, 1);