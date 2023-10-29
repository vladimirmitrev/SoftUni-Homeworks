-- some test users

INSERT INTO user_roles (id, user_role)
values
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO users (id, email, first_name, last_name, image_url, is_active, password)
VALUES
    (1, 'admin@example.com', 'Admin', 'Adminov', null, 1, '08c1a0ac6c5749f92e0b6d00544093ec1128c0f408aa8c20a688b1cf2d14dd68bb286938b92334f991836ed3c94ad99e'),
    (2, 'user@example.com', 'User', 'Userov', null, 1, '08c1a0ac6c5749f92e0b6d00544093ec1128c0f408aa8c20a688b1cf2d14dd68bb286938b92334f991836ed3c94ad99e'),
    (3, 'vladi@example.com', 'Vladimir', 'Mitrev', null, 1, '08c1a0ac6c5749f92e0b6d00544093ec1128c0f408aa8c20a688b1cf2d14dd68bb286938b92334f991836ed3c94ad99e');


INSERT INTO users_user_roles (user_entity_id, user_roles_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2),
    (3, 1),
    (3, 2);



INSERT INTO brands (id, name)
VALUES (1, 'Ford'),
       (2, 'Toyota');

INSERT INTO models (id, name, category, start_year, end_year, brand_id, image_url)
VALUES (1, 'Fiesta', 'CAR', 1976, null, 1, 'https://upload.wikimedia.org/wikipedia/commons/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg'),
       (2, 'Escort', 'CAR', 1968, 2000, 1, 'https://www.auto-data.net/images/f110/Ford-Escort-VII-Hatch-GAL-AFL.jpg'),
       (3, 'Yaris', 'CAR', 1999, null, 2, 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg/1280px-2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg');

INSERT INTO offers (id, description, engine, image_url, mileage, price, transmission, year, model_id, seller_id)
VALUES
    ('5ebdd23e-7bf3-4166-ab67-98242b871f6a', 'Качваш са, караш са, отиваш на фиеста 1. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320001, 2601, 'MANUAL', 2005, 1, 2),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f6b', 'Качваш са, караш са, отиваш на фиеста 2. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320002, 2602, 'MANUAL', 2005, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f6c', 'Качваш са, караш са, отиваш на фиеста 3. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320003, 2603, 'MANUAL', 2005, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f6d', 'Качваш са, караш са, отиваш на фиеста 4. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320004, 2605, 'MANUAL', 2005, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f6e', 'Качваш са, караш са, отиваш на фиеста 5. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320005, 2604, 'MANUAL', 2005, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f6f', 'Качваш са, караш са, отиваш на фиеста 6. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320006, 2606, 'MANUAL', 2005, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f60', 'Качваш са, караш са, отиваш на фиеста 7. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320007, 2607, 'MANUAL', 2005, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f61', 'Качваш са, караш са, отиваш на фиеста 8. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320008, 2609, 'MANUAL', 2005, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f62', 'Качваш са, караш са, отиваш на фиеста 9. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320009, 2640, 'MANUAL', 2005, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f63', 'Качваш са, караш са, отиваш на фиеста 10. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320010, 2630, 'MANUAL', 2005, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f64', 'Качваш са, караш са, отиваш на фиеста 11. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320011, 2633, 'MANUAL', 2005, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f65', 'Качваш са, караш са, отиваш на фиеста 12. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320012, 2654, 'MANUAL', 2005, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f66', 'Качваш са, караш са, отиваш на фиеста 13. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320013, 2612, 'MANUAL', 2005, 1, 1),
    ('5ebdd23e-7bf3-4166-ab67-98242b871f67', 'Качваш са, караш са, отиваш на фиеста 13. С Форд Ескорт.', 'DIESEL', 'https://upload.wikimedia.org/wikipedia/commons/b/b7/1995_Ford_Escort_1.6_Sapphire_%2819773828282%29.jpg', 320016, 2614, 'AUTOMATIC', 1990, 2, 3);



# INSERT INTO mobilele.offers (id, description, engine, image_url, mileage, price, transmission, year, model_id, seller_id, uuid) VALUES (1, 'dasdasdasdasdasd', 'GASOLINE', 'https://autozona.bg/wp-content/uploads/2022/06/ford-fiesta-st-line-2022.jpg', 20000, 3000.00, 'AUTOMATIC', 2012, 1, 10, null);
# INSERT INTO mobilele.offers (id, description, engine, image_url, mileage, price, transmission, year, model_id, seller_id, uuid) VALUES (2, 'fdgdfhdfgfggd', 'ELECTRIC', 'https://hips.hearstapps.com/hmg-prod/amv-prod-cad-assets/images/media/267369/2008-toyota-yaris-photo-198079-s-original.jpg', 10000, 1000.00, 'AUTOMATIC', 2008, 3, 10, null);
# INSERT INTO mobilele.offers (id, description, engine, image_url, mileage, price, transmission, year, model_id, seller_id, uuid) VALUES (3, 'mnogo qk braaaat', 'GASOLINE', 'https://123auta.s3.amazonaws.com/prodej/ford/escort/f_20507_ford_escort_1.jpg', 25000, 4000.00, 'MANUAL', 2005, 2, null, null);
# INSERT INTO mobilele.offers (id, description, engine, image_url, mileage, price, transmission, year, model_id, seller_id, uuid) VALUES (5, 'Amazing small car', 'HYBRID', 'https://scene7.toyota.eu/is/image/toyotaeurope/toyota-yaris-grs-2022-alternate-01?wid=1280&fit=fit,1&ts=0&resMode=sharp2&op_usm=1.75,0.3,2,0', 1000, 40000.00, 'AUTOMATIC', 2022, 3, 15, null);
# INSERT INTO mobilele.offers (id, description, engine, image_url, mileage, price, transmission, year, model_id, seller_id, uuid) VALUES (6, 'Върви', 'DIESEL', 'https://th.bing.com/th/id/OIP.vHOAMAW_twHpwnEzWSPZzAHaE6?w=295&h=196&c=7&r=0&o=5&dpr=1.3&pid=1.7', 80000, 11000.00, 'MANUAL', 2013, 3, 25, null);
#
# INSERT INTO mobilele.offers (id, description, engine, image_url, mileage, price, transmission, year, model_id, seller_id, uuid) VALUES (7, 'dasdasdasdasdasd', 'GASOLINE', 'https://autozona.bg/wp-content/uploads/2022/06/ford-fiesta-st-line-2022.jpg', 20000, 3000.00, 'AUTOMATIC', 2012, 1, 10, null);
# INSERT INTO mobilele.offers (id, description, engine, image_url, mileage, price, transmission, year, model_id, seller_id, uuid) VALUES (8, 'fdgdfhdfgfggd', 'ELECTRIC', 'https://hips.hearstapps.com/hmg-prod/amv-prod-cad-assets/images/media/267369/2008-toyota-yaris-photo-198079-s-original.jpg', 10000, 1000.00, 'AUTOMATIC', 2008, 3, 10, null);
# INSERT INTO mobilele.offers (id, description, engine, image_url, mileage, price, transmission, year, model_id, seller_id, uuid) VALUES (9, 'mnogo qk braaaat', 'GASOLINE', 'https://123auta.s3.amazonaws.com/prodej/ford/escort/f_20507_ford_escort_1.jpg', 25000, 4000.00, 'MANUAL', 2005, 2, null, null);
# INSERT INTO mobilele.offers (id, description, engine, image_url, mileage, price, transmission, year, model_id, seller_id, uuid) VALUES (10, 'Amazing small car', 'HYBRID', 'https://scene7.toyota.eu/is/image/toyotaeurope/toyota-yaris-grs-2022-alternate-01?wid=1280&fit=fit,1&ts=0&resMode=sharp2&op_usm=1.75,0.3,2,0', 1000, 40000.00, 'AUTOMATIC', 2022, 3, 15, null);
# INSERT INTO mobilele.offers (id, description, engine, image_url, mileage, price, transmission, year, model_id, seller_id, uuid) VALUES (11, 'Върви', 'DIESEL', 'https://th.bing.com/th/id/OIP.vHOAMAW_twHpwnEzWSPZzAHaE6?w=295&h=196&c=7&r=0&o=5&dpr=1.3&pid=1.7', 80000, 11000.00, 'MANUAL', 2013, 3, 25, null);
#
#
# INSERT INTO offers (id, description, engine, image_url, mileage, price, transmission, year, model_id, seller_id)
# VALUES ('5ebdd23e-7bf3-4166-ab67-98242b871f6b', 'Качваш са, караш са, отиваш на фиеста. С Форд Фиеста.', 'GASOLINE', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg/280px-2005_Ford_Fiesta_%28WP%29_Ghia_5-door_hatchback_%282015-07-24%29_01.jpg', 320000, 2600, 'MANUAL', 2005, 1, 1)

