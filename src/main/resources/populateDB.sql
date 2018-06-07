DELETE FROM user_roles;
DELETE FROM menu;
DELETE FROM users;
DELETE FROM dish;
DELETE FROM restoran;
DELETE FROM voting;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

INSERT INTO restoran (name) VALUES
  ('Пушкин'),
  ('Турандот'),
  ('Москафе');

INSERT INTO menu (operdate, restoran) VALUES
  ('2018-05-30', 100002),
  ('2018-05-30', 100003),
  ('2018-05-30', 100004);

INSERT INTO dish (name, price, menu) VALUES
  ('Салат Татьяна', 70, 100005),
  ('Суп-лапша куриная', 200, 100005),
  ('Пятачок на грядке', 500, 100005),
  ('Рис', 50, 100005),
  ('Морс', 500, 100005),
  ('Цезарь с курицей', 170, 100006),
  ('Щи зеленые со сметаной', 220, 100006),
  ('Гуляш', 470, 100006),
  ('Гречка', 100, 100006),
  ('Кофе', 150, 100006),
  ('Оливье', 120, 100007),
  ('Борщ', 150, 100007),
  ('Бифстроганов', 300, 100007);

insert into voting(user_id, menu, operdate) values
  (100000, 100005, '2018-05-30 10:00:00'),
  (100001, 100006, '2018-06-01 10:00:00');