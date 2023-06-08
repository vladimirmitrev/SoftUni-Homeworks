#Section 1: Data Definition Language (DDL) – 40 pts

# DROP DATABASE IF EXISTS softuni_influencers;
# CREATE DATABASE softuni_influencers;
# USE softuni_influencers;

#01.Table Design
CREATE TABLE users
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    username  VARCHAR(30) NOT NULL UNIQUE,
    password  VARCHAR(30) NOT NULL,
    email     VARCHAR(50) NOT NULL,
    gender    CHAR(1)     NOT NULL,
    age       INT         NOT NULL,
    job_title VARCHAR(40) NOT NULL,
    ip        VARCHAR(30) NOT NULL
);

CREATE TABLE addresses
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    address VARCHAR(30) NOT NULL,
    town    VARCHAR(30) NOT NULL,
    country VARCHAR(30) NOT NULL,
    user_id INT         NOT NULL,
    CONSTRAINT fk_addresses_users
        FOREIGN KEY (user_id)
            REFERENCES users (id)
);

CREATE TABLE photos
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    description TEXT     NOT NULL,
    date        DATETIME NOT NULL,
    views       INT      NOT NULL DEFAULT (0)
);

CREATE TABLE comments
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    comment  VARCHAR(255) NOT NULL,
    date     DATETIME     NOT NULL,
    photo_id INT          NOT NULL,
    CONSTRAINT fk_comments_photos
        FOREIGN KEY (photo_id)
            REFERENCES photos (id)
);

CREATE TABLE users_photos
(
    user_id  INT NOT NULL,
    photo_id INT NOT NULL,
    CONSTRAINT fk_users_photos_users
        FOREIGN KEY (user_id)
            REFERENCES users (id),
    CONSTRAINT fk_users_photos_photos
        FOREIGN KEY (photo_id)
            REFERENCES photos (id)
);

CREATE TABLE likes
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    photo_id INT,
    user_id  INT,
    CONSTRAINT fk_likes_photos
        FOREIGN KEY (photo_id)
            REFERENCES photos (id),
    CONSTRAINT fk_likes_users
        FOREIGN KEY (user_id)
            REFERENCES users (id)
);

insert into users (id, username, password, email, gender, age, job_title, ip) values (1, 'ygeratt0', '3rPO8dv0H', 'bjaszczak0@sitemeter.com', 'M', 71, 'Payment Adjustment Coordinator', '122.91.219.203');
insert into users (id, username, password, email, gender, age, job_title, ip) values (2, 'cdinesen1', 'hYFlUdgod', 'ekinforth1@wufoo.com', 'M', 11, 'Accounting Assistant IV', '247.227.234.168');
insert into users (id, username, password, email, gender, age, job_title, ip) values (3, 'djura2', '4BgVrIxhF2', 'jfanton2@washingtonpost.com', 'M', 68, 'Nuclear Power Engineer', '82.80.183.148');
insert into users (id, username, password, email, gender, age, job_title, ip) values (4, 'gjoannidi3', 'WEOjW29bH', 'dmingard3@domainmarket.com', 'M', 98, 'Engineer III', '8.5.83.122');
insert into users (id, username, password, email, gender, age, job_title, ip) values (5, 'hgrigoryov4', 'U9aH8s4wFns', 'mlittlekit4@cornell.edu', 'F', 4, 'Civil Engineer', '50.162.216.179');
insert into users (id, username, password, email, gender, age, job_title, ip) values (6, 'ftroppmann5', 'upbSORg4eaKF', 'kmedway5@weather.com', 'M', 1, 'Sales Associate', '163.36.202.248');
insert into users (id, username, password, email, gender, age, job_title, ip) values (7, 'wsline6', 'oeu5Gbdg0', 'bpidon6@clickbank.net', 'F', 21, 'VP Sales', '148.176.123.206');
insert into users (id, username, password, email, gender, age, job_title, ip) values (8, 'bvickress7', 'uof8US', 'lguildford7@github.io', 'F', 47, 'Marketing Assistant', '60.134.160.216');
insert into users (id, username, password, email, gender, age, job_title, ip) values (9, 'cbaythorp8', 'Wvv4a6', 'gbusby8@cmu.edu', 'M', 96, 'Operator', '191.229.117.229');
insert into users (id, username, password, email, gender, age, job_title, ip) values (10, 'oleckie9', 'r0yxd92hJ', 'tshippard9@dropbox.com', 'F', 77, 'Marketing Manager', '242.210.220.106');
insert into users (id, username, password, email, gender, age, job_title, ip) values (11, 'bgillingsa', 'kscOsFIZwN9', 'mcockshtta@hc360.com', 'F', 32, 'Sales Associate', '127.30.43.192');
insert into users (id, username, password, email, gender, age, job_title, ip) values (12, 'aroccob', 'BhDgNI', 'dpendrichb@hhs.gov', 'M', 77, 'Teacher', '138.207.96.207');
insert into users (id, username, password, email, gender, age, job_title, ip) values (13, 'mkitteringhamc', 'EymGHiRdq', 'bmillikenc@yolasite.com', 'F', 93, 'Programmer I', '2.102.135.89');
insert into users (id, username, password, email, gender, age, job_title, ip) values (14, 'ssantryd', 'TaaSt860lNym', 'phawksleed@va.gov', 'F', 52, 'Compensation Analyst', '62.112.67.85');
insert into users (id, username, password, email, gender, age, job_title, ip) values (15, 'cchadbournee', 'rn9E1VE', 'keime@sakura.ne.jp', 'M', 16, 'Senior Developer', '220.181.145.99');
insert into users (id, username, password, email, gender, age, job_title, ip) values (16, 'ebridatf', 'v5MjwBms', 'kgynnef@yale.edu', 'F', 98, 'Senior Financial Analyst', '110.171.38.253');
insert into users (id, username, password, email, gender, age, job_title, ip) values (17, 'bferenceg', '9DWf6M', 'fspontong@topsy.com', 'F', 50, 'Sales Associate', '209.13.165.58');
insert into users (id, username, password, email, gender, age, job_title, ip) values (18, 'jlutmanh', 'UWNMzJ', 'gyousefh@smh.com.au', 'F', 44, 'Clinical Specialist', '50.140.48.37');
insert into users (id, username, password, email, gender, age, job_title, ip) values (19, 'matthowei', 'RnJuNfYGY', 'sswepstonei@ifeng.com', 'F', 36, 'Internal Auditor', '236.183.33.245');
insert into users (id, username, password, email, gender, age, job_title, ip) values (20, 'rzywickij', 'L3RE59bc7UKT', 'mokinneallyj@google.com.au', 'M', 3, 'VP Marketing', '238.145.107.93');
insert into users (id, username, password, email, gender, age, job_title, ip) values (21, 'kwarbeyk', 'hJRjqLg7', 'cshirtk@census.gov', 'F', 72, 'Statistician I', '125.3.182.159');
insert into users (id, username, password, email, gender, age, job_title, ip) values (22, 'npaddisonl', 'PQJN1j4', 'thubanel@bing.com', 'F', 78, 'Research Associate', '172.15.110.96');
insert into users (id, username, password, email, gender, age, job_title, ip) values (23, 'rgreatreaxm', 'gUjBZkCsK3J', 'fsabatierm@barnesandnoble.com', 'M', 68, 'Research Nurse', '171.192.178.119');
insert into users (id, username, password, email, gender, age, job_title, ip) values (24, 'sknealen', 'oIDXyJd', 'mmatevosiann@wufoo.com', 'F', 4, 'Civil Engineer', '133.97.189.237');
insert into users (id, username, password, email, gender, age, job_title, ip) values (25, 'egurtono', 'a4mvibxK8x6K', 'csigarso@unesco.org', 'M', 71, 'Mechanical Systems Engineer', '236.250.246.104');
insert into users (id, username, password, email, gender, age, job_title, ip) values (26, 'ghingep', 'A7PgvgktisGD', 'dmacalessp@wordpress.com', 'M', 27, 'Geological Engineer', '200.102.183.66');
insert into users (id, username, password, email, gender, age, job_title, ip) values (27, 'mgethingq', 'QtqiTqO', 'jhexumq@techcrunch.com', 'M', 99, 'Software Consultant', '47.152.81.170');
insert into users (id, username, password, email, gender, age, job_title, ip) values (28, 'mbaxsterr', 'aZK2R53mHzzR', 'dlooneyr@linkedin.com', 'M', 93, 'Geologist IV', '209.80.102.59');
insert into users (id, username, password, email, gender, age, job_title, ip) values (29, 'dpauels', 'pYrcia', 'hmorhalls@tripadvisor.com', 'M', 58, 'Budget/Accounting Analyst III', '224.212.14.142');
insert into users (id, username, password, email, gender, age, job_title, ip) values (30, 'rmacauleyt', 'hNSexKJdW', 'aitzkint@liveinternet.ru', 'F', 40, 'Project Manager', '55.105.2.73');
insert into users (id, username, password, email, gender, age, job_title, ip) values (31, 'ceasonu', 'H0R3fZHg', 'sbuddingu@dedecms.com', 'F', 14, 'Computer Systems Analyst IV', '234.157.125.108');
insert into users (id, username, password, email, gender, age, job_title, ip) values (32, 'ichoakv', 'pVzO0J4qCkHd', 'cwaudv@prnewswire.com', 'F', 24, 'Graphic Designer', '68.224.67.251');
insert into users (id, username, password, email, gender, age, job_title, ip) values (33, 'htabordw', 'pQpesuiJ', 'rtwomeyw@wordpress.com', 'M', 18, 'Human Resources Assistant III', '194.95.118.38');
insert into users (id, username, password, email, gender, age, job_title, ip) values (34, 'prestorickx', 'ZFCo6cbFloq', 'rcrosslandx@fastcompany.com', 'M', 98, 'Design Engineer', '254.73.229.165');
insert into users (id, username, password, email, gender, age, job_title, ip) values (35, 'ylaimabley', 'GemK6Q', 'dfaichneyy@pinterest.com', 'M', 87, 'Recruiter', '9.96.57.246');
insert into users (id, username, password, email, gender, age, job_title, ip) values (36, 'chartfordz', 'KlUjNlk', 'acrakez@usatoday.com', 'M', 100, 'Web Designer IV', '204.216.76.85');
insert into users (id, username, password, email, gender, age, job_title, ip) values (37, 'chalgarth10', '4i7vhxzi', 'kwardesworth10@nationalgeographic.com', 'F', 34, 'Editor', '76.242.147.112');
insert into users (id, username, password, email, gender, age, job_title, ip) values (38, 'tduns11', 'njxK4Qg', 'jpollak11@sun.com', 'F', 61, 'General Manager', '254.69.68.200');
insert into users (id, username, password, email, gender, age, job_title, ip) values (39, 'lmckirdy12', 'yovJfc', 'ephilippard12@independent.co.uk', 'M', 30, 'Nuclear Power Engineer', '8.145.131.80');
insert into users (id, username, password, email, gender, age, job_title, ip) values (40, 'bfrichley13', 'pfcCeI7vT', 'anilles13@deviantart.com', 'M', 87, 'Help Desk Technician', '207.122.137.116');
insert into users (id, username, password, email, gender, age, job_title, ip) values (41, 'galchin14', 'xVO3qP9', 'jmarc14@usda.gov', 'F', 34, 'VP Sales', '21.54.65.122');
insert into users (id, username, password, email, gender, age, job_title, ip) values (42, 'rgurden15', 'HdSMTRgInY4', 'gmenichelli15@deviantart.com', 'M', 92, 'Civil Engineer', '25.66.13.208');
insert into users (id, username, password, email, gender, age, job_title, ip) values (43, 'rmcgirr16', 'vA7a5oE4DYJ4', 'ccraker16@studiopress.com', 'F', 25, 'Social Worker', '32.232.94.205');
insert into users (id, username, password, email, gender, age, job_title, ip) values (44, 'rdomeny17', '7Fe6yt', 'vbamforth17@bing.com', 'F', 77, 'Payment Adjustment Coordinator', '194.2.15.85');
insert into users (id, username, password, email, gender, age, job_title, ip) values (45, 'vlukasik18', '40zWlGSK', 'cmorshead18@mtv.com', 'M', 57, 'Accountant IV', '92.220.22.196');
insert into users (id, username, password, email, gender, age, job_title, ip) values (46, 'oseally19', 'uwP2utY', 'rshurmore19@geocities.jp', 'F', 77, 'Physical Therapy Assistant', '201.196.123.181');
insert into users (id, username, password, email, gender, age, job_title, ip) values (47, 'mhinsch1a', 'L0hzUJRFf', 'hfroggatt1a@wordpress.com', 'M', 72, 'Assistant Manager', '30.93.173.56');
insert into users (id, username, password, email, gender, age, job_title, ip) values (48, 'mosgood1b', 'fBALVc', 'fbattey1b@shop-pro.jp', 'M', 42, 'Tax Accountant', '2.9.107.221');
insert into users (id, username, password, email, gender, age, job_title, ip) values (49, 'mtansly1c', 'wF47C67c', 'ccozins1c@digg.com', 'M', 94, 'Nuclear Power Engineer', '83.145.203.194');
insert into users (id, username, password, email, gender, age, job_title, ip) values (50, 'mcaygill1d', '7j5UttHvB', 'lbelding1d@shinystat.com', 'F', 100, 'Office Assistant II', '222.71.252.186');
insert into users (id, username, password, email, gender, age, job_title, ip) values (51, 'btander1e', 'ezknvBcjIzs', 'adelue1e@cnet.com', 'F', 23, 'Research Associate', '208.112.162.223');
insert into users (id, username, password, email, gender, age, job_title, ip) values (52, 'koregan1f', 'un3tV7', 'ptelega1f@gravatar.com', 'F', 58, 'Compensation Analyst', '10.33.17.61');
insert into users (id, username, password, email, gender, age, job_title, ip) values (53, 'bkelling1g', 'CpZhojY', 'sglashby1g@desdev.cn', 'M', 49, 'Tax Accountant', '216.35.231.9');
insert into users (id, username, password, email, gender, age, job_title, ip) values (54, 'pcoomer1h', 'BpdKUNVBq', 'amcgahy1h@cornell.edu', 'F', 5, 'Sales Associate', '129.87.220.75');
insert into users (id, username, password, email, gender, age, job_title, ip) values (55, 'mvonoertzen1i', 'Ffy8msvHTa8', 'ojustun1i@mozilla.org', 'F', 40, 'Graphic Designer', '102.141.128.148');
insert into users (id, username, password, email, gender, age, job_title, ip) values (56, 'ndelamar1j', 'AB4RFbU8R2J', 'nflacknoe1j@apple.com', 'M', 11, 'Paralegal', '153.81.58.63');
insert into users (id, username, password, email, gender, age, job_title, ip) values (57, 'kbraitling1k', 'rOUewl0', 'katteridge1k@blogtalkradio.com', 'M', 41, 'Community Outreach Specialist', '170.167.138.146');
insert into users (id, username, password, email, gender, age, job_title, ip) values (58, 'thavoc1l', 'vxMv955Iw4Su', 'beick1l@plala.or.jp', 'F', 38, 'Pharmacist', '108.231.76.71');
insert into users (id, username, password, email, gender, age, job_title, ip) values (59, 'lcurtois1m', 'xD1DLJFAE', 'amurrock1m@nydailynews.com', 'F', 13, 'Project Manager', '152.1.228.136');
insert into users (id, username, password, email, gender, age, job_title, ip) values (60, 'jbousfield1n', '7xHZktv', 'blovart1n@lulu.com', 'F', 1, 'Media Manager IV', '181.127.73.11');
insert into users (id, username, password, email, gender, age, job_title, ip) values (61, 'abrameld1o', 'cm9bF1cCo7C', 'bpetrik1o@sitemeter.com', 'F', 56, 'Financial Advisor', '193.72.109.207');
insert into users (id, username, password, email, gender, age, job_title, ip) values (62, 'pbenes1p', '9yWEnJHr', 'istanlike1p@weebly.com', 'F', 12, 'Information Systems Manager', '97.25.153.174');
insert into users (id, username, password, email, gender, age, job_title, ip) values (63, 'pshellcross1q', 'C9vuYnzjP9M', 'ecurrm1q@rambler.ru', 'M', 79, 'Professor', '247.232.4.56');
insert into users (id, username, password, email, gender, age, job_title, ip) values (64, 'kkynoch1r', 'aJ48Y1OwP', 'ldunnet1r@devhub.com', 'F', 59, 'Media Manager IV', '173.87.190.122');
insert into users (id, username, password, email, gender, age, job_title, ip) values (65, 'dcrouch1s', 'Wy5GrY44vv', 'ebarck1s@gnu.org', 'M', 48, 'Senior Sales Associate', '221.189.39.91');
insert into users (id, username, password, email, gender, age, job_title, ip) values (66, 'ekennaway1t', 'cSfjMHzG2n', 'qdemeter1t@google.nl', 'M', 24, 'Quality Control Specialist', '123.130.49.187');
insert into users (id, username, password, email, gender, age, job_title, ip) values (67, 'jmauger1u', 'MGiJNeA', 'rgebbie1u@weather.com', 'F', 94, 'Compensation Analyst', '205.12.102.39');
insert into users (id, username, password, email, gender, age, job_title, ip) values (68, 'cmiddlemist1v', 'SCjLK36HtbEZ', 'npetrou1v@businessinsider.com', 'M', 84, 'Design Engineer', '92.23.118.154');
insert into users (id, username, password, email, gender, age, job_title, ip) values (69, 'moliveira1w', 'ztNbeirk', 'msoulsby1w@aboutads.info', 'F', 62, 'Research Nurse', '87.140.61.43');
insert into users (id, username, password, email, gender, age, job_title, ip) values (70, 'urihanek1x', 'V4ZWoTYY', 'mavison1x@imdb.com', 'F', 14, 'Sales Associate', '28.26.169.122');
insert into users (id, username, password, email, gender, age, job_title, ip) values (71, 'hmatonin1y', 'YjiCXwz', 'sdart1y@senate.gov', 'M', 66, 'General Manager', '132.184.167.20');
insert into users (id, username, password, email, gender, age, job_title, ip) values (72, 'aflexman1z', 'qoeI4nT', 'sjeannel1z@phoca.cz', 'M', 11, 'Sales Representative', '29.251.198.136');
insert into users (id, username, password, email, gender, age, job_title, ip) values (73, 'canscott20', 'K7wTETTV3', 'rkyngdon20@is.gd', 'F', 21, 'Electrical Engineer', '249.182.158.229');
insert into users (id, username, password, email, gender, age, job_title, ip) values (74, 'eblagden21', 'kANtau', 'eishak21@skyrock.com', 'M', 81, 'Associate Professor', '159.95.198.3');
insert into users (id, username, password, email, gender, age, job_title, ip) values (75, 'jgoody22', '3LU1ae', 'tpearson22@pbs.org', 'F', 8, 'Safety Technician IV', '225.16.97.183');
insert into users (id, username, password, email, gender, age, job_title, ip) values (76, 'joutright23', 'P6xHqcbdDa9p', 'jselbach23@taobao.com', 'M', 30, 'Environmental Tech', '161.97.33.126');
insert into users (id, username, password, email, gender, age, job_title, ip) values (77, 'vfaers24', 'e30sOBYHaZ1', 'dsauvain24@privacy.gov.au', 'F', 92, 'Sales Associate', '88.124.45.239');
insert into users (id, username, password, email, gender, age, job_title, ip) values (78, 'ebenoi25', 'en5iysah', 'ssheddan25@cocolog-nifty.com', 'M', 33, 'Actuary', '76.170.121.132');
insert into users (id, username, password, email, gender, age, job_title, ip) values (79, 'ddempster26', 'Sh72CkB9G2AO', 'zlates26@sfgate.com', 'F', 49, 'Web Designer III', '253.78.90.66');
insert into users (id, username, password, email, gender, age, job_title, ip) values (80, 'lizacenko27', '1yXTjx', 'dmcduffie27@multiply.com', 'M', 5, 'Librarian', '107.124.149.83');
insert into users (id, username, password, email, gender, age, job_title, ip) values (81, 'mbartles28', 'bIXO5oR', 'cmckeggie28@uol.com.br', 'M', 37, 'Account Representative II', '113.100.251.182');
insert into users (id, username, password, email, gender, age, job_title, ip) values (82, 'yzettoi29', 'ZB956UGda', 'xlancashire29@omniture.com', 'M', 62, 'Graphic Designer', '191.192.27.26');
insert into users (id, username, password, email, gender, age, job_title, ip) values (83, 'gciccottio2a', '1z6eAq1M3C', 'dgyer2a@cnbc.com', 'M', 65, 'Quality Control Specialist', '50.31.242.200');
insert into users (id, username, password, email, gender, age, job_title, ip) values (84, 'odalley2b', 'ckvXKP', 'dschrir2b@reddit.com', 'M', 96, 'Health Coach II', '38.54.250.164');
insert into users (id, username, password, email, gender, age, job_title, ip) values (85, 'sbarrowclough2c', 'apumztwX', 'etorbard2c@epa.gov', 'F', 21, 'Marketing Assistant', '254.148.230.146');
insert into users (id, username, password, email, gender, age, job_title, ip) values (86, 'ehayle2d', 'xPPoEsOnh', 'cmardell2d@goo.ne.jp', 'M', 5, 'Media Manager I', '59.30.175.162');
insert into users (id, username, password, email, gender, age, job_title, ip) values (87, 'efellibrand2e', '7ZA5l0lP', 'awinyard2e@reference.com', 'M', 74, 'Graphic Designer', '247.17.158.225');
insert into users (id, username, password, email, gender, age, job_title, ip) values (88, 'cvela2f', 'iwEiolT', 'ljackson2f@phoca.cz', 'M', 74, 'Administrative Officer', '255.20.9.183');
insert into users (id, username, password, email, gender, age, job_title, ip) values (89, 'agurney2g', 'j6VD5hZ2wTm', 'haikman2g@google.nl', 'M', 48, 'VP Product Management', '48.184.140.180');
insert into users (id, username, password, email, gender, age, job_title, ip) values (90, 'hbonelle2h', 'snT4sE8Q', 'mlyles2h@behance.net', 'M', 41, 'Assistant Professor', '181.159.73.18');
insert into users (id, username, password, email, gender, age, job_title, ip) values (91, 'akillelea2i', '5rUIEbpqzzC', 'mnorbury2i@sun.com', 'M', 8, 'Internal Auditor', '33.67.75.155');
insert into users (id, username, password, email, gender, age, job_title, ip) values (92, 'aosbourn2j', 'qxj95vBS', 'lbolley2j@is.gd', 'M', 75, 'Recruiting Manager', '202.14.140.226');
insert into users (id, username, password, email, gender, age, job_title, ip) values (93, 'gmintram2k', 'tOqncfhVuzG', 'atuckwood2k@hubpages.com', 'M', 4, 'Tax Accountant', '88.6.105.69');
insert into users (id, username, password, email, gender, age, job_title, ip) values (94, 'tszach2l', 'L16FlC', 'wzambonini2l@jiathis.com', 'M', 86, 'Geologist IV', '182.235.232.81');
insert into users (id, username, password, email, gender, age, job_title, ip) values (95, 'nclaye2m', '4SJbPw', 'cwennington2m@google.com.hk', 'F', 97, 'Staff Scientist', '222.104.84.31');
insert into users (id, username, password, email, gender, age, job_title, ip) values (96, 'bbodycombe2n', '9DKgekAUbb', 'lwoolrich2n@tuttocitta.it', 'M', 57, 'Data Coordiator', '157.3.62.40');
insert into users (id, username, password, email, gender, age, job_title, ip) values (97, 'godyvoy2o', 'e9VREWXB3w', 'lwakley2o@google.com.br', 'F', 11, 'Business Systems Development Analyst', '163.68.160.137');
insert into users (id, username, password, email, gender, age, job_title, ip) values (98, 'xbleby2p', 'YUhUbkriDWH7', 'mbuff2p@blogs.com', 'F', 69, 'Computer Systems Analyst III', '145.223.54.56');
insert into users (id, username, password, email, gender, age, job_title, ip) values (99, 'balbertson2q', 'dO29b9dn', 'brushton2q@jugem.jp', 'F', 84, 'Associate Professor', '77.198.52.22');
insert into users (id, username, password, email, gender, age, job_title, ip) values (100, 'lboultwood2r', 'aozaObAgzZY', 'lfortie2r@engadget.com', 'M', 48, 'Senior Developer', '14.159.202.220');

insert into addresses (id, address, town, country, user_id) values (1, '97 Valley Edge Parkway', 'Divinópolis', 'Brazil', 74);
insert into addresses (id, address, town, country, user_id) values (2, '0 Waubesa Road', 'Neundeut', 'Indonesia', 39);
insert into addresses (id, address, town, country, user_id) values (3, '177 Blue Bill Park Center', 'Yurimaguas', 'Peru', 70);
insert into addresses (id, address, town, country, user_id) values (4, '2604 Morrow Crossing', 'Verkh-Usugli', 'Russia', 23);
insert into addresses (id, address, town, country, user_id) values (5, '2382 Ridgeway Park', 'Boyu', 'China', 50);
insert into addresses (id, address, town, country, user_id) values (6, '574 Ohio Trail', 'Poitiers', 'France', 54);
insert into addresses (id, address, town, country, user_id) values (7, '6259 Farwell Avenue', 'Huayacundo Arma', 'Peru', 73);
insert into addresses (id, address, town, country, user_id) values (8, '929 Glacier Hill Place', 'Colmar', 'France', 63);
insert into addresses (id, address, town, country, user_id) values (9, '1 Vahlen Avenue', 'Lambayong', 'Philippines', 65);
insert into addresses (id, address, town, country, user_id) values (10, '47980 Westerfield Junction', 'Obollo-Afor', 'Nigeria', 89);
insert into addresses (id, address, town, country, user_id) values (11, '9189 Novick Hill', 'La Sarrosa', 'Honduras', 71);
insert into addresses (id, address, town, country, user_id) values (12, '15 Rusk Avenue', 'Nangan', 'Taiwan', 46);
insert into addresses (id, address, town, country, user_id) values (13, '002 Jay Pass', 'Valmiera', 'Latvia', 8);
insert into addresses (id, address, town, country, user_id) values (14, '64298 Parkside Circle', 'Jihuluntu Sumu', 'China', 64);
insert into addresses (id, address, town, country, user_id) values (15, '7079 Atwood Drive', 'Volovets', 'Ukraine', 99);
insert into addresses (id, address, town, country, user_id) values (16, '69 Talmadge Drive', 'Puerto Galera', 'Philippines', 94);
insert into addresses (id, address, town, country, user_id) values (17, '0610 Marcy Court', 'Itapissuma', 'Brazil', 61);
insert into addresses (id, address, town, country, user_id) values (18, '6308 Mallard Lane', 'Shibushi', 'Japan', 10);
insert into addresses (id, address, town, country, user_id) values (19, '06 Badeau Street', 'El Cerrito', 'Colombia', 86);
insert into addresses (id, address, town, country, user_id) values (20, '652 Saint Paul Road', 'Skien', 'Norway', 90);
insert into addresses (id, address, town, country, user_id) values (21, '028 Browning Junction', 'San Pedro Sacatepéquez', 'Guatemala', 84);
insert into addresses (id, address, town, country, user_id) values (22, '76801 Washington Point', 'Paris 13', 'France', 21);
insert into addresses (id, address, town, country, user_id) values (23, '94487 Dunning Place', 'Jonava', 'Lithuania', 53);
insert into addresses (id, address, town, country, user_id) values (24, '83 Monterey Center', 'Yangxiang', 'China', 15);
insert into addresses (id, address, town, country, user_id) values (25, '5 Marcy Crossing', 'Reda', 'Poland', 87);
insert into addresses (id, address, town, country, user_id) values (26, '9780 4th Center', 'Lincuo', 'China', 53);
insert into addresses (id, address, town, country, user_id) values (27, '5875 Donald Parkway', 'Maragogipe', 'Brazil', 57);
insert into addresses (id, address, town, country, user_id) values (28, '43 Forest Road', 'Congas', 'Peru', 47);
insert into addresses (id, address, town, country, user_id) values (29, '564 Melvin Park', 'Svetlogorsk', 'Russia', 21);
insert into addresses (id, address, town, country, user_id) values (30, '7 Dryden Avenue', 'Banjar Bias', 'Indonesia', 24);
insert into addresses (id, address, town, country, user_id) values (31, '0662 Petterle Plaza', 'Hauhena', 'Indonesia', 75);
insert into addresses (id, address, town, country, user_id) values (32, '80 Hansons Junction', 'Gorbunki', 'Russia', 28);
insert into addresses (id, address, town, country, user_id) values (33, '45 Annamark Way', 'Bassar', 'Togo', 48);
insert into addresses (id, address, town, country, user_id) values (34, '0 Dawn Trail', 'Itajubá', 'Brazil', 40);
insert into addresses (id, address, town, country, user_id) values (35, '40 Hansons Crossing', 'Kitami', 'Japan', 69);
insert into addresses (id, address, town, country, user_id) values (36, '5921 Farragut Terrace', 'Al Kittah', 'Jordan', 40);
insert into addresses (id, address, town, country, user_id) values (37, '44746 Nobel Drive', 'Pantaibesar', 'Indonesia', 70);
insert into addresses (id, address, town, country, user_id) values (38, '99066 Fairfield Junction', 'Xumai', 'China', 17);
insert into addresses (id, address, town, country, user_id) values (39, '43 Colorado Plaza', 'Caohe', 'China', 29);
insert into addresses (id, address, town, country, user_id) values (40, '518 Milwaukee Road', 'Sucre', 'Peru', 36);
insert into addresses (id, address, town, country, user_id) values (41, '4001 Straubel Trail', 'Karangcombong', 'Indonesia', 42);
insert into addresses (id, address, town, country, user_id) values (42, '95 American Place', 'Choco', 'Peru', 4);
insert into addresses (id, address, town, country, user_id) values (43, '5 Manufacturers Terrace', 'Sanlifan', 'China', 63);
insert into addresses (id, address, town, country, user_id) values (44, '8 Dapin Avenue', 'Xiaohe', 'China', 1);
insert into addresses (id, address, town, country, user_id) values (45, '00 Merchant Terrace', 'Naukot', 'Pakistan', 63);
insert into addresses (id, address, town, country, user_id) values (46, '98960 Fulton Hill', 'Neiva', 'Colombia', 52);
insert into addresses (id, address, town, country, user_id) values (47, '1279 Twin Pines Terrace', 'Tumba', 'China', 78);
insert into addresses (id, address, town, country, user_id) values (48, '77615 Mosinee Plaza', 'P’rimorsk’oe', 'Georgia', 85);
insert into addresses (id, address, town, country, user_id) values (49, '71 Emmet Circle', 'Al Wuday‘', 'Yemen', 76);
insert into addresses (id, address, town, country, user_id) values (50, '43457 Rowland Alley', 'Arauco', 'Chile', 96);
insert into addresses (id, address, town, country, user_id) values (51, '16416 Pierstorff Parkway', 'Mulyorejo', 'Indonesia', 45);
insert into addresses (id, address, town, country, user_id) values (52, '98 North Way', 'Boise', 'United States', 63);
insert into addresses (id, address, town, country, user_id) values (53, '139 Canary Crossing', 'Pak Phanang', 'Thailand', 84);
insert into addresses (id, address, town, country, user_id) values (54, '1737 Cody Plaza', 'Qijing', 'China', 70);
insert into addresses (id, address, town, country, user_id) values (55, '6 Ramsey Place', 'Rawa Mazowiecka', 'Poland', 48);
insert into addresses (id, address, town, country, user_id) values (56, '27400 Di Loreto Terrace', 'Marechal Deodoro', 'Brazil', 79);
insert into addresses (id, address, town, country, user_id) values (57, '7991 Esch Trail', 'Bartniczka', 'Poland', 56);
insert into addresses (id, address, town, country, user_id) values (58, '015 Goodland Circle', 'Lwówek Śląski', 'Poland', 76);
insert into addresses (id, address, town, country, user_id) values (59, '64236 Maple Wood Junction', 'Longtou’an', 'China', 100);
insert into addresses (id, address, town, country, user_id) values (60, '25 Saint Paul Crossing', 'Kumba', 'Cameroon', 42);
insert into addresses (id, address, town, country, user_id) values (61, '9793 Armistice Terrace', 'Haarlem', 'Netherlands', 9);
insert into addresses (id, address, town, country, user_id) values (62, '57 Springs Street', 'Ninomiya', 'Japan', 79);
insert into addresses (id, address, town, country, user_id) values (63, '8 Blackbird Trail', 'Néa Róda', 'Greece', 94);
insert into addresses (id, address, town, country, user_id) values (64, '1222 Stephen Place', 'Sembungan Kidul', 'Indonesia', 46);
insert into addresses (id, address, town, country, user_id) values (65, '3686 Division Junction', 'Bor Ondor', 'China', 30);
insert into addresses (id, address, town, country, user_id) values (66, '2 Ridge Oak Terrace', 'Thị Trấn Yên Cát', 'Vietnam', 6);
insert into addresses (id, address, town, country, user_id) values (67, '9 Village Avenue', 'Criação Velha', 'Portugal', 1);
insert into addresses (id, address, town, country, user_id) values (68, '90972 Burning Wood Junction', 'Haumeni', 'Indonesia', 78);
insert into addresses (id, address, town, country, user_id) values (69, '73 Northland Alley', 'Domašinec', 'Croatia', 26);
insert into addresses (id, address, town, country, user_id) values (70, '6904 Shopko Center', 'Santa Catalina', 'Venezuela', 17);
insert into addresses (id, address, town, country, user_id) values (71, '1154 Service Park', 'Gunungkendeng', 'Indonesia', 51);
insert into addresses (id, address, town, country, user_id) values (72, '276 Melrose Way', 'Seren Barat', 'Indonesia', 32);
insert into addresses (id, address, town, country, user_id) values (73, '8 Ryan Lane', 'Huaqiao', 'China', 14);
insert into addresses (id, address, town, country, user_id) values (74, '42 Menomonie Point', 'Dois Portos', 'Portugal', 22);
insert into addresses (id, address, town, country, user_id) values (75, '99299 Fallview Hill', 'Winduraja', 'Indonesia', 93);
insert into addresses (id, address, town, country, user_id) values (76, '13390 Dorton Pass', 'Brka', 'Bosnia and Herzegovina', 52);
insert into addresses (id, address, town, country, user_id) values (77, '733 Holy Cross Lane', 'Kuta', 'Nigeria', 77);
insert into addresses (id, address, town, country, user_id) values (78, '63 Mitchell Place', 'Labuhanjambu', 'Indonesia', 89);
insert into addresses (id, address, town, country, user_id) values (79, '144 Sachs Road', 'Campina Grande do Sul', 'Brazil', 35);
insert into addresses (id, address, town, country, user_id) values (80, '21264 Cottonwood Crossing', 'Yangjian', 'China', 91);
insert into addresses (id, address, town, country, user_id) values (81, '0245 Macpherson Parkway', 'Gembu', 'Nigeria', 100);
insert into addresses (id, address, town, country, user_id) values (82, '4 Sage Plaza', 'Pasirbitung', 'Indonesia', 55);
insert into addresses (id, address, town, country, user_id) values (83, '9 Old Shore Trail', 'Daliang', 'China', 41);
insert into addresses (id, address, town, country, user_id) values (84, '3 International Drive', 'Marseille', 'France', 67);
insert into addresses (id, address, town, country, user_id) values (85, '8 Gerald Parkway', 'Francisco Morato', 'Brazil', 43);
insert into addresses (id, address, town, country, user_id) values (86, '9338 Lukken Way', 'Cruz Alta', 'Brazil', 28);
insert into addresses (id, address, town, country, user_id) values (87, '4 Fulton Road', 'Santo Amaro', 'Portugal', 96);
insert into addresses (id, address, town, country, user_id) values (88, '9 Spenser Center', 'Sanshan', 'China', 28);
insert into addresses (id, address, town, country, user_id) values (89, '8184 Canary Center', 'Paulínia', 'Brazil', 65);
insert into addresses (id, address, town, country, user_id) values (90, '92 Bunting Street', 'Hengxi', 'China', 12);
insert into addresses (id, address, town, country, user_id) values (91, '8 Pond Junction', 'Oslo', 'Norway', 1);
insert into addresses (id, address, town, country, user_id) values (92, '6 Warrior Road', 'Cox’s Bāzār', 'Bangladesh', 85);
insert into addresses (id, address, town, country, user_id) values (93, '28390 Mayfield Crossing', 'Henglian', 'China', 53);
insert into addresses (id, address, town, country, user_id) values (94, '62795 Spohn Place', 'Kilkenny', 'Ireland', 70);
insert into addresses (id, address, town, country, user_id) values (95, '95 Colorado Drive', 'Futu', 'China', 12);
insert into addresses (id, address, town, country, user_id) values (96, '86740 East Way', 'Kairouan', 'Tunisia', 25);
insert into addresses (id, address, town, country, user_id) values (97, '3858 Prentice Hill', 'Kayes', 'Republic of the Congo', 46);
insert into addresses (id, address, town, country, user_id) values (98, '7 Grayhawk Trail', 'Malbork', 'Poland', 72);
insert into addresses (id, address, town, country, user_id) values (99, '43 Sommers Street', 'Komsomol’skiy', 'Russia', 96);
insert into addresses (id, address, town, country, user_id) values (100, '34 Nobel Point', 'Voloka', 'Ukraine', 87);

insert into photos (id, description, date, views) values (1, 'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.', '2019-09-22 14:48:03', 0);
insert into photos (id, description, date, views) values (2, 'Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.Fusce consequat. Nulla nisl. Nunc nisl.', '2020-02-03 10:29:22', 0);
insert into photos (id, description, date, views) values (3, 'Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.', '2019-11-01 06:51:47', 0);
insert into photos (id, description, date, views) values (4, 'Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.', '2019-05-16 20:59:44', 0);
insert into photos (id, description, date, views) values (5, 'Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi77 eu orci. Mauris lacinia sapien quis libero.Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.', '2019-06-25 17:58:28', 0);
insert into photos (id, description, date, views) values (6, 'Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', '2020-02-21 20:47:40', 0);
insert into photos (id, description, date, views) values (7, 'Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.Sed ante. Vivamus tortor. Duis mattis egestas metus.', '2019-06-07 18:46:03', 0);
insert into photos (id, description, date, views) values (8, 'Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.', '2019-09-04 08:47:14', 0);
insert into photos (id, description, date, views) values (9, 'Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.', '2019-11-26 17:43:49', 0);
insert into photos (id, description, date, views) values (10, 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', '2019-09-11 05:40:14', 0);
insert into photos (id, description, date, views) values (11, 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.', '2019-04-21 00:02:04', 0);
insert into photos (id, description, date, views) values (12, 'In congue. Etiam justo. Etiam pretium iaculis justo.', '2019-09-29 10:11:56', 0);
insert into photos (id, description, date, views) values (13, 'Fusce consequat. Nulla nisl. Nunc nisl.Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.', '2020-02-17 04:46:39', 0);
insert into photos (id, description, date, views) values (14, 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.Fusce consequat. Nulla nisl. Nunc nisl.', '2020-02-16 13:49:08', 0);
insert into photos (id, description, date, views) values (15, 'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.', '2019-06-02 00:38:03', 0);
insert into photos (id, description, date, views) values (16, 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.', '2019-12-11 12:31:32', 0);
insert into photos (id, description, date, views) values (17, 'Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.', '2020-02-02 09:14:40', 0);
insert into photos (id, description, date, views) values (18, 'Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.', '2019-10-27 08:48:46', 0);
insert into photos (id, description, date, views) values (19, 'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.', '2020-02-01 07:46:42', 0);
insert into photos (id, description, date, views) values (20, 'Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2019-05-10 14:23:11', 0);
insert into photos (id, description, date, views) values (21, 'Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', '2019-07-19 19:01:47', 0);
insert into photos (id, description, date, views) values (22, 'Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', '2019-11-24 07:45:45', 0);
insert into photos (id, description, date, views) values (23, 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.', '2019-10-13 14:13:42', 0);
insert into photos (id, description, date, views) values (24, 'Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.', '2020-01-28 02:06:00', 0);
insert into photos (id, description, date, views) values (25, 'In congue. Etiam justo. Etiam pretium iaculis justo.In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.', '2019-07-20 13:08:03', 0);
insert into photos (id, description, date, views) values (26, 'Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.', '2019-12-10 15:20:14', 0);
insert into photos (id, description, date, views) values (27, 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', '2020-03-08 14:36:04', 0);
insert into photos (id, description, date, views) values (28, 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.', '2019-05-23 19:11:19', 0);
insert into photos (id, description, date, views) values (29, 'Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.', '2019-04-29 00:55:07', 0);
insert into photos (id, description, date, views) values (30, 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.', '2019-08-31 11:10:56', 0);
insert into photos (id, description, date, views) values (31, 'Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', '2019-05-06 05:45:48', 0);
insert into photos (id, description, date, views) values (32, 'In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.', '2019-03-10 11:07:44', 0);
insert into photos (id, description, date, views) values (33, 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', '2019-07-07 15:36:28', 0);
insert into photos (id, description, date, views) values (34, 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', '2019-08-08 11:30:18', 0);
insert into photos (id, description, date, views) values (35, 'Sed ante. Vivamus tortor. Duis mattis egestas metus.Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', '2020-02-08 04:53:44', 0);
insert into photos (id, description, date, views) values (36, 'In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', '2019-09-28 06:48:11', 0);
insert into photos (id, description, date, views) values (37, 'In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.', '2019-06-30 14:53:38', 0);
insert into photos (id, description, date, views) values (38, 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.', '2019-04-21 18:51:46', 0);
insert into photos (id, description, date, views) values (39, 'Phasellus in felis. Donec semper sapien a libero. Nam dui.Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.', '2019-10-21 17:34:48', 0);
insert into photos (id, description, date, views) values (40, 'Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.', '2019-09-07 12:33:58', 0);
insert into photos (id, description, date, views) values (41, 'Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', '2020-02-03 00:44:25', 0);
insert into photos (id, description, date, views) values (42, 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.In congue. Etiam justo. Etiam pretium iaculis justo.', '2019-05-11 08:57:18', 0);
insert into photos (id, description, date, views) values (43, 'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.', '2019-12-07 17:10:45', 0);
insert into photos (id, description, date, views) values (44, 'Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', '2019-07-12 14:13:37', 0);
insert into photos (id, description, date, views) values (45, 'In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.', '2020-03-03 21:15:04', 0);
insert into photos (id, description, date, views) values (46, 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus.', '2020-02-20 12:09:00', 0);
insert into photos (id, description, date, views) values (47, 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.In congue. Etiam justo. Etiam pretium iaculis justo.', '2019-10-29 06:49:58', 0);
insert into photos (id, description, date, views) values (48, 'In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', '2019-07-20 22:37:34', 0);
insert into photos (id, description, date, views) values (49, 'In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.', '2019-08-17 05:10:37', 0);
insert into photos (id, description, date, views) values (50, 'Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.', '2019-11-30 15:13:14', 0);
insert into photos (id, description, date, views) values (51, 'In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', '2020-02-08 11:31:47', 0);
insert into photos (id, description, date, views) values (52, 'Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.Phasellus in felis. Donec semper sapien a libero. Nam dui.', '2019-11-06 00:48:48', 0);
insert into photos (id, description, date, views) values (53, 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.', '2020-03-09 01:13:10', 0);
insert into photos (id, description, date, views) values (54, 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.', '2020-02-09 03:29:50', 0);
insert into photos (id, description, date, views) values (55, 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.In congue. Etiam justo. Etiam pretium iaculis justo.', '2019-10-10 08:58:52', 0);
insert into photos (id, description, date, views) values (56, 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.', '2019-10-31 03:15:03', 0);
insert into photos (id, description, date, views) values (57, 'Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', '2019-07-19 02:50:14', 0);
insert into photos (id, description, date, views) values (58, 'Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2019-05-30 12:06:27', 0);
insert into photos (id, description, date, views) values (59, 'In congue. Etiam justo. Etiam pretium iaculis justo.In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.', '2019-07-22 20:32:43', 0);
insert into photos (id, description, date, views) values (60, 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.', '2019-05-10 14:40:22', 0);
insert into photos (id, description, date, views) values (61, 'Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', '2019-11-30 10:47:14', 0);
insert into photos (id, description, date, views) values (62, 'In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', '2019-10-17 04:14:21', 0);
insert into photos (id, description, date, views) values (63, 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.In congue. Etiam justo. Etiam pretium iaculis justo.In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.', '2019-04-25 18:15:18', 0);
insert into photos (id, description, date, views) values (64, 'In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', '2019-04-15 19:25:07', 0);
insert into photos (id, description, date, views) values (65, 'Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2019-03-17 20:00:22', 0);
insert into photos (id, description, date, views) values (66, 'Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', '2019-04-13 11:12:52', 0);
insert into photos (id, description, date, views) values (67, 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', '2019-10-20 02:01:46', 0);
insert into photos (id, description, date, views) values (68, 'Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.', '2019-06-20 00:45:13', 0);
insert into photos (id, description, date, views) values (69, 'Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.', '2020-02-22 11:22:31', 0);
insert into photos (id, description, date, views) values (70, 'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.', '2019-04-09 11:51:54', 0);
insert into photos (id, description, date, views) values (71, 'Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.', '2019-11-15 12:35:55', 0);
insert into photos (id, description, date, views) values (72, 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', '2019-10-11 07:41:23', 0);
insert into photos (id, description, date, views) values (73, 'Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.', '2019-11-29 22:35:21', 0);
insert into photos (id, description, date, views) values (74, 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', '2019-08-22 05:42:52', 0);
insert into photos (id, description, date, views) values (75, 'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.', '2019-12-26 07:39:13', 0);
insert into photos (id, description, date, views) values (76, 'In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.', '2019-10-20 20:47:48', 0);
insert into photos (id, description, date, views) values (77, 'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.', '2019-10-17 07:22:26', 0);
insert into photos (id, description, date, views) values (78, 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', '2019-11-24 04:43:03', 0);
insert into photos (id, description, date, views) values (79, 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2019-04-20 05:44:37', 0);
insert into photos (id, description, date, views) values (80, 'Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.', '2019-06-24 00:14:23', 0);
insert into photos (id, description, date, views) values (81, 'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.', '2019-06-11 08:05:29', 0);
insert into photos (id, description, date, views) values (82, 'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', '2019-04-17 15:53:56', 0);
insert into photos (id, description, date, views) values (83, 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', '2019-11-30 23:23:50', 0);
insert into photos (id, description, date, views) values (84, 'Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.', '2019-07-29 02:10:03', 0);
insert into photos (id, description, date, views) values (85, 'Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', '2020-02-23 23:55:36', 0);
insert into photos (id, description, date, views) values (86, 'Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.', '2019-07-30 19:28:29', 0);
insert into photos (id, description, date, views) values (87, 'Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', '2019-09-02 22:20:32', 0);
insert into photos (id, description, date, views) values (88, 'Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', '2020-01-23 09:43:44', 0);
insert into photos (id, description, date, views) values (89, 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.', '2019-03-14 08:04:04', 0);
insert into photos (id, description, date, views) values (90, 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.', '2019-11-23 13:58:33', 0);
insert into photos (id, description, date, views) values (91, 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', '2019-04-28 07:38:15', 0);
insert into photos (id, description, date, views) values (92, 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2019-07-05 22:20:32', 0);
insert into photos (id, description, date, views) values (93, 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.', '2020-02-05 23:16:19', 0);
insert into photos (id, description, date, views) values (94, 'Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.', '2019-12-08 14:04:01', 0);
insert into photos (id, description, date, views) values (95, 'Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.', '2019-03-23 14:59:46', 0);
insert into photos (id, description, date, views) values (96, 'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.', '2020-01-31 15:07:46', 0);
insert into photos (id, description, date, views) values (97, 'Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.Sed ante. Vivamus tortor. Duis mattis egestas metus.Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', '2019-07-09 17:14:52', 0);
insert into photos (id, description, date, views) values (98, 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.', '2019-04-25 02:26:39', 0);
insert into photos (id, description, date, views) values (99, 'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.', '2019-07-27 12:51:46', 0);
insert into photos (id, description, date, views) values (100, 'In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', '2020-03-02 06:00:36', 0);

insert into comments (id, comment, date, photo_id) values (1, 'enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa', '2019-06-30 02:41:20', 4);
insert into comments (id, comment, date, photo_id) values (2, 'et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum', '2019-10-03 22:43:29', 16);
insert into comments (id, comment, date, photo_id) values (3, 'turpis a pede posuere nonummy integer non velit donec diam neque vestibulum', '2019-03-30 12:16:55', 88);
insert into comments (id, comment, date, photo_id) values (4, 'gravida sem praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras', '2019-10-28 09:33:28', 31);
insert into comments (id, comment, date, photo_id) values (5, 'in eleifend quam a odio in hac habitasse platea dictumst maecenas ut', '2020-02-13 08:08:43', 68);
insert into comments (id, comment, date, photo_id) values (6, 'libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla', '2019-07-01 16:22:13', 17);
insert into comments (id, comment, date, photo_id) values (7, 'interdum in ante vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus', '2019-10-25 14:13:28', 58);
insert into comments (id, comment, date, photo_id) values (8, 'amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus', '2020-01-08 19:36:41', 85);
insert into comments (id, comment, date, photo_id) values (9, 'et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet', '2019-12-11 22:46:44', 33);
insert into comments (id, comment, date, photo_id) values (10, 'fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam', '2019-10-11 22:30:14', 32);
insert into comments (id, comment, date, photo_id) values (11, 'ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis', '2019-06-17 23:37:46', 19);
insert into comments (id, comment, date, photo_id) values (12, 'lectus pellentesque eget nunc donec quis orci eget orci vehicula', '2019-11-17 17:25:26', 25);
insert into comments (id, comment, date, photo_id) values (13, 'sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet', '2019-08-27 15:10:20', 72);
insert into comments (id, comment, date, photo_id) values (14, 'posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut', '2020-02-09 01:50:14', 68);
insert into comments (id, comment, date, photo_id) values (15, 'magnis dis parturient montes nascetur ridiculus mus etiam vel augue vestibulum rutrum rutrum', '2020-02-05 10:38:40', 20);
insert into comments (id, comment, date, photo_id) values (16, 'curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor', '2019-10-14 04:55:09', 75);
insert into comments (id, comment, date, photo_id) values (17, 'nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa', '2020-01-21 13:51:56', 87);
insert into comments (id, comment, date, photo_id) values (18, 'morbi vestibulum velit id pretium iaculis diam erat fermentum justo', '2019-06-23 03:14:16', 32);
insert into comments (id, comment, date, photo_id) values (19, 'amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi nulla', '2019-06-09 22:09:57', 1);
insert into comments (id, comment, date, photo_id) values (20, 'augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse', '2019-09-14 12:02:48', 86);
insert into comments (id, comment, date, photo_id) values (21, 'sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus', '2019-09-08 01:08:25', 31);
insert into comments (id, comment, date, photo_id) values (22, 'vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien', '2019-06-01 04:42:02', 86);
insert into comments (id, comment, date, photo_id) values (23, 'eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum ante ipsum primis in', '2019-06-23 09:37:03', 36);
insert into comments (id, comment, date, photo_id) values (24, 'quisque arcu libero rutrum ac lobortis vel dapibus at diam nam tristique tortor', '2019-08-19 10:22:39', 14);
insert into comments (id, comment, date, photo_id) values (25, 'lorem vitae mattis nibh ligula nec sem duis aliquam convallis nunc proin at turpis', '2019-04-28 02:29:51', 25);
insert into comments (id, comment, date, photo_id) values (26, 'pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula', '2019-06-04 16:15:48', 6);
insert into comments (id, comment, date, photo_id) values (27, 'platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer tincidunt ante vel ipsum', '2019-05-20 17:32:37', 23);
insert into comments (id, comment, date, photo_id) values (28, 'est congue elementum in hac habitasse platea dictumst morbi vestibulum velit', '2020-01-01 11:53:26', 41);
insert into comments (id, comment, date, photo_id) values (29, 'enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet', '2019-09-01 11:50:53', 95);
insert into comments (id, comment, date, photo_id) values (30, 'vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero', '2019-04-04 23:00:39', 30);
insert into comments (id, comment, date, photo_id) values (31, 'nam ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim sit', '2019-08-20 02:09:40', 37);
insert into comments (id, comment, date, photo_id) values (32, 'vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non', '2020-02-13 22:49:23', 51);
insert into comments (id, comment, date, photo_id) values (33, 'in lacus curabitur at ipsum ac tellus semper interdum mauris ullamcorper purus sit amet nulla quisque arcu libero', '2019-11-15 14:41:35', 63);
insert into comments (id, comment, date, photo_id) values (34, 'a ipsum integer a nibh in quis justo maecenas rhoncus', '2019-05-27 22:56:54', 94);
insert into comments (id, comment, date, photo_id) values (35, 'nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse', '2019-08-09 16:51:20', 61);
insert into comments (id, comment, date, photo_id) values (36, 'sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet', '2019-10-01 08:48:14', 15);
insert into comments (id, comment, date, photo_id) values (37, 'consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius integer', '2019-09-21 09:55:09', 99);
insert into comments (id, comment, date, photo_id) values (38, 'dolor vel est donec odio justo sollicitudin ut suscipit a feugiat et eros', '2020-03-07 03:34:42', 39);
insert into comments (id, comment, date, photo_id) values (39, 'est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi', '2019-04-19 10:47:36', 51);
insert into comments (id, comment, date, photo_id) values (40, 'sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis', '2019-10-26 22:54:08', 2);
insert into comments (id, comment, date, photo_id) values (41, 'convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum vestibulum', '2019-08-24 06:59:37', 27);
insert into comments (id, comment, date, photo_id) values (42, 'aliquam quis turpis eget elit sodales scelerisque mauris sit amet', '2020-02-18 21:43:48', 13);
insert into comments (id, comment, date, photo_id) values (43, 'quis turpis sed ante vivamus tortor duis mattis egestas metus aenean fermentum', '2019-05-13 17:46:32', 84);
insert into comments (id, comment, date, photo_id) values (44, 'elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla suscipit ligula', '2019-12-31 12:37:20', 35);
insert into comments (id, comment, date, photo_id) values (45, 'nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at', '2019-08-09 13:37:50', 18);
insert into comments (id, comment, date, photo_id) values (46, 'maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu mi', '2019-07-14 01:05:30', 80);
insert into comments (id, comment, date, photo_id) values (47, 'pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus', '2019-12-30 11:29:08', 36);
insert into comments (id, comment, date, photo_id) values (48, 'purus aliquet at feugiat non pretium quis lectus suspendisse potenti in eleifend quam a', '2020-03-02 11:38:38', 89);
insert into comments (id, comment, date, photo_id) values (49, 'dolor quis odio consequat varius integer ac leo pellentesque ultrices', '2019-12-13 16:08:33', 47);
insert into comments (id, comment, date, photo_id) values (50, 'consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae mauris', '2019-10-24 03:52:51', 63);
insert into comments (id, comment, date, photo_id) values (51, 'rutrum ac lobortis vel dapibus at diam nam tristique tortor', '2019-12-10 04:02:49', 48);
insert into comments (id, comment, date, photo_id) values (52, 'sit amet turpis elementum ligula vehicula consequat morbi a ipsum', '2019-08-10 17:18:23', 11);
insert into comments (id, comment, date, photo_id) values (53, 'rutrum nulla nunc purus phasellus in felis donec semper sapien a', '2019-04-14 16:50:46', 19);
insert into comments (id, comment, date, photo_id) values (54, 'nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum', '2019-11-16 16:52:26', 43);
insert into comments (id, comment, date, photo_id) values (55, 'ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo', '2020-01-24 08:44:53', 99);
insert into comments (id, comment, date, photo_id) values (56, 'in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum', '2019-08-15 03:39:32', 100);
insert into comments (id, comment, date, photo_id) values (57, 'proin leo odio porttitor id consequat in consequat ut nulla sed accumsan felis ut', '2019-03-18 02:19:14', 22);
insert into comments (id, comment, date, photo_id) values (58, 'velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo', '2019-10-01 16:54:02', 29);
insert into comments (id, comment, date, photo_id) values (59, 'maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat', '2020-01-08 20:47:38', 100);
insert into comments (id, comment, date, photo_id) values (60, 'morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor', '2019-10-09 02:51:18', 91);
insert into comments (id, comment, date, photo_id) values (61, 'amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere', '2019-11-23 12:54:40', 84);
insert into comments (id, comment, date, photo_id) values (62, 'suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit', '2019-10-29 09:05:45', 31);
insert into comments (id, comment, date, photo_id) values (63, 'nunc purus phasellus in felis donec semper sapien a libero nam dui', '2019-07-03 08:48:17', 74);
insert into comments (id, comment, date, photo_id) values (64, 'amet diam in magna bibendum imperdiet nullam orci pede venenatis', '2019-07-12 13:11:48', 23);
insert into comments (id, comment, date, photo_id) values (65, 'mi nulla ac enim in tempor turpis nec euismod scelerisque quam turpis adipiscing', '2019-08-10 07:09:26', 11);
insert into comments (id, comment, date, photo_id) values (66, 'augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet', '2019-07-26 13:31:51', 79);
insert into comments (id, comment, date, photo_id) values (67, 'vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere', '2019-10-26 15:10:13', 94);
insert into comments (id, comment, date, photo_id) values (68, 'rutrum at lorem integer tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat', '2019-04-04 14:26:33', 22);
insert into comments (id, comment, date, photo_id) values (69, 'ridiculus mus etiam vel augue vestibulum rutrum rutrum neque aenean auctor gravida sem praesent', '2020-01-27 08:14:52', 53);
insert into comments (id, comment, date, photo_id) values (70, 'amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum', '2019-03-14 12:13:49', 17);
insert into comments (id, comment, date, photo_id) values (71, 'magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien', '2019-09-26 22:52:48', 26);
insert into comments (id, comment, date, photo_id) values (72, 'iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris', '2019-09-17 18:39:23', 97);
insert into comments (id, comment, date, photo_id) values (73, 'tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante', '2020-01-08 18:03:46', 14);
insert into comments (id, comment, date, photo_id) values (74, 'libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas', '2019-11-09 03:19:30', 28);
insert into comments (id, comment, date, photo_id) values (75, 'nunc viverra dapibus nulla suscipit ligula in lacus curabitur at ipsum ac tellus semper interdum', '2019-11-01 05:46:48', 40);
insert into comments (id, comment, date, photo_id) values (76, 'in sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat', '2019-04-01 15:35:44', 40);
insert into comments (id, comment, date, photo_id) values (77, 'turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus', '2020-01-13 02:51:56', 23);
insert into comments (id, comment, date, photo_id) values (78, 'ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget', '2019-09-23 06:54:17', 66);
insert into comments (id, comment, date, photo_id) values (79, 'nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus', '2020-02-25 09:27:56', 17);
insert into comments (id, comment, date, photo_id) values (80, 'pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum', '2019-12-10 19:05:30', 87);
insert into comments (id, comment, date, photo_id) values (81, 'nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet', '2019-10-13 02:42:56', 60);
insert into comments (id, comment, date, photo_id) values (82, 'lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci', '2020-01-09 17:16:51', 83);
insert into comments (id, comment, date, photo_id) values (83, 'sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate', '2020-02-21 06:19:02', 6);
insert into comments (id, comment, date, photo_id) values (84, 'at nibh in hac habitasse platea dictumst aliquam augue quam sollicitudin vitae consectetuer eget rutrum at lorem integer', '2020-02-01 20:31:43', 99);
insert into comments (id, comment, date, photo_id) values (85, 'lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti', '2019-12-11 19:18:23', 28);
insert into comments (id, comment, date, photo_id) values (86, 'posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar', '2019-12-15 07:01:13', 26);
insert into comments (id, comment, date, photo_id) values (87, 'nibh in quis justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum', '2019-07-20 10:47:11', 3);
insert into comments (id, comment, date, photo_id) values (88, 'lectus aliquam sit amet diam in magna bibendum imperdiet nullam orci pede venenatis non sodales', '2020-02-01 19:49:30', 41);
insert into comments (id, comment, date, photo_id) values (89, 'dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat', '2019-08-09 20:41:13', 60);
insert into comments (id, comment, date, photo_id) values (90, 'sit amet nulla quisque arcu libero rutrum ac lobortis vel dapibus at diam', '2019-05-08 04:44:30', 37);
insert into comments (id, comment, date, photo_id) values (91, 'vestibulum sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus', '2019-06-30 17:48:34', 5);
insert into comments (id, comment, date, photo_id) values (92, 'venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet', '2019-07-28 18:14:25', 14);
insert into comments (id, comment, date, photo_id) values (93, 'lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices', '2019-10-04 07:38:15', 42);
insert into comments (id, comment, date, photo_id) values (94, 'lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti', '2019-05-13 11:51:30', 1);
insert into comments (id, comment, date, photo_id) values (95, 'elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in', '2019-08-10 11:46:04', 100);
insert into comments (id, comment, date, photo_id) values (96, 'amet cursus id turpis integer aliquet massa id lobortis convallis tortor risus dapibus augue vel accumsan', '2019-06-27 06:02:35', 40);
insert into comments (id, comment, date, photo_id) values (97, 'mi in porttitor pede justo eu massa donec dapibus duis at velit', '2020-01-12 00:42:35', 25);
insert into comments (id, comment, date, photo_id) values (98, 'blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing', '2019-04-30 07:05:41', 25);
insert into comments (id, comment, date, photo_id) values (99, 'morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla', '2019-12-14 21:29:01', 23);
insert into comments (id, comment, date, photo_id) values (100, 'praesent id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in', '2019-08-04 01:52:05', 33);

insert into users_photos (user_id, photo_id) values (8, 11);
insert into users_photos (user_id, photo_id) values (87, 8);
insert into users_photos (user_id, photo_id) values (32, 21);
insert into users_photos (user_id, photo_id) values (88, 43);
insert into users_photos (user_id, photo_id) values (63, 30);
insert into users_photos (user_id, photo_id) values (32, 23);
insert into users_photos (user_id, photo_id) values (13, 38);
insert into users_photos (user_id, photo_id) values (2, 93);
insert into users_photos (user_id, photo_id) values (20, 67);
insert into users_photos (user_id, photo_id) values (12, 12);
insert into users_photos (user_id, photo_id) values (73, 47);
insert into users_photos (user_id, photo_id) values (17, 25);
insert into users_photos (user_id, photo_id) values (70, 70);
insert into users_photos (user_id, photo_id) values (54, 54);
insert into users_photos (user_id, photo_id) values (65, 92);
insert into users_photos (user_id, photo_id) values (92, 99);
insert into users_photos (user_id, photo_id) values (27, 7);
insert into users_photos (user_id, photo_id) values (25, 2);
insert into users_photos (user_id, photo_id) values (29, 97);
insert into users_photos (user_id, photo_id) values (17, 80);
insert into users_photos (user_id, photo_id) values (99, 71);
insert into users_photos (user_id, photo_id) values (46, 61);
insert into users_photos (user_id, photo_id) values (100, 91);
insert into users_photos (user_id, photo_id) values (93, 96);
insert into users_photos (user_id, photo_id) values (60, 34);
insert into users_photos (user_id, photo_id) values (24, 88);
insert into users_photos (user_id, photo_id) values (80, 95);
insert into users_photos (user_id, photo_id) values (65, 27);
insert into users_photos (user_id, photo_id) values (47, 85);
insert into users_photos (user_id, photo_id) values (41, 52);
insert into users_photos (user_id, photo_id) values (67, 24);
insert into users_photos (user_id, photo_id) values (87, 58);
insert into users_photos (user_id, photo_id) values (64, 18);
insert into users_photos (user_id, photo_id) values (23, 83);
insert into users_photos (user_id, photo_id) values (49, 81);
insert into users_photos (user_id, photo_id) values (49, 87);
insert into users_photos (user_id, photo_id) values (75, 64);
insert into users_photos (user_id, photo_id) values (97, 75);
insert into users_photos (user_id, photo_id) values (80, 60);
insert into users_photos (user_id, photo_id) values (24, 33);
insert into users_photos (user_id, photo_id) values (71, 39);
insert into users_photos (user_id, photo_id) values (40, 62);
insert into users_photos (user_id, photo_id) values (73, 79);
insert into users_photos (user_id, photo_id) values (13, 90);
insert into users_photos (user_id, photo_id) values (41, 29);
insert into users_photos (user_id, photo_id) values (29, 31);
insert into users_photos (user_id, photo_id) values (14, 19);
insert into users_photos (user_id, photo_id) values (45, 4);
insert into users_photos (user_id, photo_id) values (22, 3);
insert into users_photos (user_id, photo_id) values (78, 6);
insert into users_photos (user_id, photo_id) values (85, 77);
insert into users_photos (user_id, photo_id) values (22, 28);
insert into users_photos (user_id, photo_id) values (6, 1);
insert into users_photos (user_id, photo_id) values (36, 40);
insert into users_photos (user_id, photo_id) values (78, 82);
insert into users_photos (user_id, photo_id) values (87, 50);
insert into users_photos (user_id, photo_id) values (14, 44);
insert into users_photos (user_id, photo_id) values (75, 32);
insert into users_photos (user_id, photo_id) values (23, 98);
insert into users_photos (user_id, photo_id) values (97, 76);
insert into users_photos (user_id, photo_id) values (92, 66);
insert into users_photos (user_id, photo_id) values (43, 26);
insert into users_photos (user_id, photo_id) values (38, 13);
insert into users_photos (user_id, photo_id) values (67, 65);
insert into users_photos (user_id, photo_id) values (40, 17);
insert into users_photos (user_id, photo_id) values (17, 20);
insert into users_photos (user_id, photo_id) values (31, 86);

insert into likes (id, user_id, photo_id) values (1, 78, 36);
insert into likes (id, user_id, photo_id) values (2, 47, 59);
insert into likes (id, user_id, photo_id) values (3, 9, 74);
insert into likes (id, user_id, photo_id) values (4, 64, 15);
insert into likes (id, user_id, photo_id) values (5, 47, 70);
insert into likes (id, user_id, photo_id) values (6, 44, 85);
insert into likes (id, user_id, photo_id) values (7, 35, 12);
insert into likes (id, user_id, photo_id) values (8, 59, 61);
insert into likes (id, user_id, photo_id) values (9, 86, 45);
insert into likes (id, user_id, photo_id) values (10, 62, 76);
insert into likes (id, user_id, photo_id) values (11, 52, 86);
insert into likes (id, user_id, photo_id) values (12, 82, 69);
insert into likes (id, user_id, photo_id) values (13, 55, 40);
insert into likes (id, user_id, photo_id) values (14, 84, 30);
insert into likes (id, user_id, photo_id) values (15, 4, 59);
insert into likes (id, user_id, photo_id) values (16, 22, 37);
insert into likes (id, user_id, photo_id) values (17, 50, 33);
insert into likes (id, user_id, photo_id) values (18, 54, 34);
insert into likes (id, user_id, photo_id) values (19, 15, 58);
insert into likes (id, user_id, photo_id) values (20, 42, 52);
insert into likes (id, user_id, photo_id) values (21, 23, 26);
insert into likes (id, user_id, photo_id) values (22, 17, 12);
insert into likes (id, user_id, photo_id) values (23, 66, 31);
insert into likes (id, user_id, photo_id) values (24, 91, 69);
insert into likes (id, user_id, photo_id) values (25, 25, 58);
insert into likes (id, user_id, photo_id) values (26, 99, 53);
insert into likes (id, user_id, photo_id) values (27, 84, 83);
insert into likes (id, user_id, photo_id) values (28, 84, 4);
insert into likes (id, user_id, photo_id) values (29, 75, 83);
insert into likes (id, user_id, photo_id) values (30, 40, 32);
insert into likes (id, user_id, photo_id) values (31, 74, 89);
insert into likes (id, user_id, photo_id) values (32, 62, 97);
insert into likes (id, user_id, photo_id) values (33, 53, 29);
insert into likes (id, user_id, photo_id) values (34, 97, 27);
insert into likes (id, user_id, photo_id) values (35, 60, 51);
insert into likes (id, user_id, photo_id) values (36, 75, 8);
insert into likes (id, user_id, photo_id) values (37, 42, 90);
insert into likes (id, user_id, photo_id) values (38, 8, 38);
insert into likes (id, user_id, photo_id) values (39, 33, 67);
insert into likes (id, user_id, photo_id) values (40, 61, 41);
insert into likes (id, user_id, photo_id) values (41, 36, 13);
insert into likes (id, user_id, photo_id) values (42, 23, 52);
insert into likes (id, user_id, photo_id) values (43, 84, 48);
insert into likes (id, user_id, photo_id) values (44, 63, 17);
insert into likes (id, user_id, photo_id) values (45, 3, 57);
insert into likes (id, user_id, photo_id) values (46, 46, 1);
insert into likes (id, user_id, photo_id) values (47, 89, 69);
insert into likes (id, user_id, photo_id) values (48, 36, 34);
insert into likes (id, user_id, photo_id) values (49, 36, 68);
insert into likes (id, user_id, photo_id) values (50, 5, 41);
insert into likes (id, user_id, photo_id) values (51, 90, 4);
insert into likes (id, user_id, photo_id) values (52, 10, 1);
insert into likes (id, user_id, photo_id) values (53, 18, 49);
insert into likes (id, user_id, photo_id) values (54, 31, 46);
insert into likes (id, user_id, photo_id) values (55, 60, 46);
insert into likes (id, user_id, photo_id) values (56, 63, 16);
insert into likes (id, user_id, photo_id) values (57, 18, 1);
insert into likes (id, user_id, photo_id) values (58, 71, 46);
insert into likes (id, user_id, photo_id) values (59, 65, 49);
insert into likes (id, user_id, photo_id) values (60, 24, 61);
insert into likes (id, user_id, photo_id) values (61, 47, 28);
insert into likes (id, user_id, photo_id) values (62, 73, 42);
insert into likes (id, user_id, photo_id) values (63, 80, 99);
insert into likes (id, user_id, photo_id) values (64, 54, 79);
insert into likes (id, user_id, photo_id) values (65, 98, 24);
insert into likes (id, user_id, photo_id) values (66, 62, 64);
insert into likes (id, user_id, photo_id) values (67, 22, 14);
insert into likes (id, user_id, photo_id) values (68, 82, 30);
insert into likes (id, user_id, photo_id) values (69, 48, 8);
insert into likes (id, user_id, photo_id) values (70, 1, 83);
insert into likes (id, user_id, photo_id) values (71, 95, 58);
insert into likes (id, user_id, photo_id) values (72, 37, 15);
insert into likes (id, user_id, photo_id) values (73, 48, 90);
insert into likes (id, user_id, photo_id) values (74, 17, 21);
insert into likes (id, user_id, photo_id) values (75, 8, 69);
insert into likes (id, user_id, photo_id) values (76, 76, 61);
insert into likes (id, user_id, photo_id) values (77, 16, 82);
insert into likes (id, user_id, photo_id) values (78, 73, 90);
insert into likes (id, user_id, photo_id) values (79, 50, 64);
insert into likes (id, user_id, photo_id) values (80, 78, 98);
insert into likes (id, user_id, photo_id) values (81, 95, 2);
insert into likes (id, user_id, photo_id) values (82, 57, 7);
insert into likes (id, user_id, photo_id) values (83, 1, 47);
insert into likes (id, user_id, photo_id) values (84, 23, 72);
insert into likes (id, user_id, photo_id) values (85, 52, 67);
insert into likes (id, user_id, photo_id) values (86, 12, 81);
insert into likes (id, user_id, photo_id) values (87, 15, 79);
insert into likes (id, user_id, photo_id) values (88, 28, 1);
insert into likes (id, user_id, photo_id) values (89, 3, 23);
insert into likes (id, user_id, photo_id) values (90, 85, 60);
insert into likes (id, user_id, photo_id) values (91, 31, 97);
insert into likes (id, user_id, photo_id) values (92, 39, 58);
insert into likes (id, user_id, photo_id) values (93, 43, 78);
insert into likes (id, user_id, photo_id) values (94, 93, 9);
insert into likes (id, user_id, photo_id) values (95, 65, 15);
insert into likes (id, user_id, photo_id) values (96, 82, 66);
insert into likes (id, user_id, photo_id) values (97, 19, 78);
insert into likes (id, user_id, photo_id) values (98, 23, 47);
insert into likes (id, user_id, photo_id) values (99, 27, 25);
insert into likes (id, user_id, photo_id) values (100, 6, 48);