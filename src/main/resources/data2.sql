CREATE TABLE food(
  food_no_ VARCHAR PRIMARY KEY ,
  food_name_ VARCHAR NOT NULL,
  food_price_ INTEGER NOT NULL,
  food_category_ VARCHAR NOT NULL,
  food_buy_time_ TIMESTAMP ,
  food_eated_time_ TIMESTAMP
);

INSERT INTO food (food_no_,food_name_, food_price_, food_category_, food_buy_time_, food_eated_time_)
VALUES
(001,'漢堡', 85, '美式', '2018-06-06',NULL),
(002,'薯條', 50, '美式', '2018-07-01',NULL ),
(003,'鬆餅', 70, '美式', '2018-06-15',NULL ),
(004,'壽司', 250, '日式', '2017-03-03', NULL ),
(005,'韓式烤肉', 500, '韓式', '2018-02-22', NULL ),
(006,'滷肉飯', 40, '台式', '2016-10-07', NULL ),
(007,'牛排', 1500, '美式', '2017-12-08', NULL ),
(008,'月亮蝦餅', 150, '泰式', '2017-07-24', NULL),
(009,'牛肉湯', 100, '台式', '2016-01-25', NULL),
(010,'便當', 85, '日式', '2016-04-27', NULL);