/* Types */
INSERT INTO types (id_type, type) VALUES (default, 'Capybara'), (default, 'Scorpion'), (default, 'Rabbit'), (default, 'Red Panda');

/* Families */
INSERT INTO families (id_family, family) VALUES (default, 'Félidos'), (default, 'Cánidos '), (default, 'Reptiles'), (default, 'Mustelids'), (default, 'Leporidae');

/* Genders */
INSERT INTO genders (id_gender, gender) VALUES (default, 'Male'), (default, 'Female');

/* Animals */
INSERT INTO animals (id_animal, name, admission_date, type_id, family_id, gender_id) VALUES (default, 'Mark', CURRENT_TIMESTAMP, 1, 1, 1);

/* Roles */
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_USER'), (default, 'ROLE_ADMIN');

/* Users */
INSERT INTO users (id_user, username, password) VALUES (default, 'VeroLaJefe', '$2a$12$6w1wl3EyzUOTHxX/NHDBWOkXiQQuDwT31k5jWPxkxp1WXXSEspsqi');

/* Roles_Users */
INSERT INTO roles_users (role_id, user_id) VALUES (1, 2);