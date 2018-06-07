create table item_(
itemNo VARCHAR PRIMARY KEY ,
itemName VARCHAR NOT NULL ,
itemPrice INTEGER NOT NULL ,
itemCategory VARCHAR NOT NULL ,
itemCreateTime TIMESTAMP ,
itemFDropTime TIMESTAMP );

INSERT INTO item_ (itemNo, itemName, itemPrice, itemCategory, itemCreateTime, itemFDropTime)
VALUES
(001, 'ASUS ROG Zephyrus M', 85000, 'NB', '2018-06-06',NULL),
(002, 'TOYOTA Auris', 900000, '汽車', '2018-07-01',NULL ),
(003, 'HTC U12 plus', 24900, '通訊', '2018-06-15',NULL ),
(004, 'NINTENDO Switch', 12999, '數位', '2017-03-03', NULL ),
(005, 'HTC VIVE PRO', 24988, '數位', '2018-02-22', NULL ),
(006, 'SONY RX100 V', 29980, '數位', '2016-10-07', NULL ),
(007, 'TT曜越 新聖櫃', 388000, '3C', '2017-12-08', NULL ),
(008, 'SAMSUNG C49HG90DME', '42900', '3C', '2017-07-24', NULL),
(009, 'B&O Play S8(II)', 52990, '家電', '2016-01-25', NULL),
(010, 'OSIM uInfinity Luxe', 215800, '運動', '2016-04-27', NULL);