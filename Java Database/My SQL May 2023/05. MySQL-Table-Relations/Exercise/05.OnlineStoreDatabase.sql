CREATE TABLE `items`(
`item_id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50),
`item_type_id` INT(11)
);

CREATE TABLE `item_types`(
`item_type_id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50)
);

CREATE TABLE `order_items`(
`order_id` INT(11),
`item_id` INT(11),
CONSTRAINT pk
PRIMARY KEY (`order_id`, `item_id`)
);

CREATE TABLE `orders`(
`order_id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`customer_id` INT(11)
);

CREATE TABLE `customers`(
`customer_id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50),
`birthday` DATE,
`city_id` INT(11)
);

CREATE TABLE `cities`(
`city_id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50)
);

ALTER TABLE `items`
ADD CONSTRAINT fk_item_type
FOREIGN KEY (`item_type_id`)
REFERENCES `item_types`(`item_type_id`);

ALTER TABLE `order_items`
ADD CONSTRAINT fk_oder_id
FOREIGN KEY (`item_id`)
REFERENCES `items`(`item_id`),
ADD CONSTRAINT fk_item_id
FOREIGN KEY (`order_id`)
REFERENCES `orders`(`order_id`);

ALTER TABLE `orders`
ADD CONSTRAINT fk_customer_id
FOREIGN KEY (`customer_id`)
REFERENCES `customers`(`customer_id`);

ALTER TABLE `customers`
ADD CONSTRAINT fk_city_id
FOREIGN KEY (`city_id`)
REFERENCES `cities`(`city_id`);
