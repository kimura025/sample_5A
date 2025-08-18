DROP DATABASE sampledb;
DROP USER app_user@'%';

CREATE DATABASE sampledb;
CREATE USER 'app_user'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON sampledb.* TO 'app_user'@'%';

CREATE TABLE sampledb.shop (
  shop_id INT AUTO_INCREMENT,
  shop_name VARCHAR(20) NOT NULL,
  PRIMARY KEY (shop_id)
);

CREATE TABLE sampledb.item (
  shop_id INT,	
  item_id INT,
  item_name VARCHAR(20) NOT NULL,
  item_describe VARCHAR(200) NOT NULL,
  item_price INT NOT NULL,
  item_regist BOOLEAN NOT NULL,
  PRIMARY KEY (shop_id , item_id),
  FOREIGN KEY (shop_id) REFERENCES sampledb.shop(shop_id)
);

INSERT INTO sampledb.shop(shop_name) VALUES('店A');
INSERT INTO sampledb.shop(shop_name) VALUES('店B');
INSERT INTO sampledb.shop(shop_name) VALUES('店C');

INSERT INTO sampledb.item(shop_id, item_id, item_name, item_describe, item_price,item_regist) VALUES(1, 1, '店Aの品物A', '店Aの品物A説明', 100,0);
INSERT INTO sampledb.item(shop_id, item_id, item_name, item_describe, item_price,item_regist) VALUES(1, 2, '店Aの品物B', '店Aの品物B説明', 1000,0);
INSERT INTO sampledb.item(shop_id, item_id, item_name, item_describe, item_price,item_regist) VALUES(1, 3, '店Aの品物C', '店Aの品物B説明', 10000,1);
INSERT INTO sampledb.item(shop_id, item_id, item_name, item_describe, item_price,item_regist) VALUES(3, 1, '店Cの品物A', '店Cの品物A説明', 999999,1);
INSERT INTO sampledb.item(shop_id, item_id, item_name, item_describe, item_price,item_regist) VALUES(3, 2, '店Cの品物B', '店Cの品物B説明', 9999999,1);