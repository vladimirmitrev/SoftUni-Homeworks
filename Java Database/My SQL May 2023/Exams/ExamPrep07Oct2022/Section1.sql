#Section 1: Data Definition Language (DDL) – 40 pts
DROP DATABASE IF EXISTS football_sc ;
CREATE DATABASE football_sc;
use football_sc;

#01.Table Design
CREATE TABLE countries
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL
);

CREATE TABLE towns
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(45) NOT NULL,
    country_id INT         NOT NULL,
    CONSTRAINT fk_towns_countries
        FOREIGN KEY (country_id)
            REFERENCES countries (id)
);

CREATE TABLE stadiums
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(45) NOT NULL,
    capacity INT         NOT NULL,
    town_id  INT         NOT NULL,
    CONSTRAINT fk_stadiums_towns
        FOREIGN KEY (town_id)
            REFERENCES towns (id)
);

CREATE TABLE teams
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(45) NOT NULL,
    established DATE        NOT NULL,
    fan_base    BIGINT      NOT NULL DEFAULT (0),
    stadium_id  INT         NOT NULL,
    CONSTRAINT fk_teams_stadiums
        FOREIGN KEY (stadium_id)
            REFERENCES stadiums (id)
);

CREATE TABLE skills_data
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    dribbling INT DEFAULT (0),
    pace      INT DEFAULT (0),
    passing   INT DEFAULT (0),
    shooting  INT DEFAULT (0),
    speed     INT DEFAULT (0),
    strength  INT DEFAULT (0)
);

CREATE TABLE coaches
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    first_name  VARCHAR(10)    NOT NULL,
    last_name   VARCHAR(20)    NOT NULL,
    salary      DECIMAL(10, 2) NOT NULL DEFAULT (0),
    coach_level INT            NOT NULL DEFAULT (0)
);

CREATE TABLE players
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    first_name     VARCHAR(10)    NOT NULL,
    last_name      VARCHAR(20)    NOT NULL,
    age            INT            NOT NULL DEFAULT (0),
    position       char(1)        NOT NULL,
    salary         DECIMAL(10, 2) NOT NULL DEFAULT (0),
    hire_date      DATETIME,
    skills_data_id INT            NOT NULL,
    team_id        INT,
    CONSTRAINT fk_players_skills_data
        FOREIGN KEY (skills_data_id)
            REFERENCES skills_data (id),
    CONSTRAINT fk_players_teams
        FOREIGN KEY (team_id)
            REFERENCES teams (id)
);

CREATE TABLE players_coaches
(
    player_id INT,
    coach_id  INT,
    CONSTRAINT fk_players_coaches_players
        FOREIGN KEY (player_id)
            REFERENCES players (id),
    CONSTRAINT fk_players_coaches_coaches
        FOREIGN KEY (coach_id)
            REFERENCES coaches (id)
);

#Inserting data to tables

insert into countries (id, name) values (1, 'Morocco');
insert into countries (id, name) values (2, 'China');
insert into countries (id, name) values (4, 'Russia');
insert into countries (id, name) values (5, 'Indonesia');
insert into countries (id, name) values (6, 'Bangladesh');
insert into countries (id, name) values (8, 'Ireland');
insert into countries (id, name) values (11, 'Poland');
insert into countries (id, name) values (12, 'Ghana');
insert into countries (id, name) values (13, 'Armenia');
insert into countries (id, name) values (15, 'Nigeria');
insert into countries (id, name) values (17, 'Canada');
insert into countries (id, name) values (19, 'Cameroon');
insert into countries (id, name) values (22, 'Malaysia');
insert into countries (id, name) values (24, 'Colombia');
insert into countries (id, name) values (28, 'Botswana');
insert into countries (id, name) values (31, 'Syria');
insert into countries (id, name) values (32, 'United States');
insert into countries (id, name) values (33, 'Japan');
insert into countries (id, name) values (34, 'Philippines');
insert into countries (id, name) values (35, 'Ethiopia');
insert into countries (id, name) values (36, 'Macedonia');
insert into countries (id, name) values (38, 'Finland');
insert into countries (id, name) values (39, 'France');
insert into countries (id, name) values (40, 'Thailand');
insert into countries (id, name) values (43, 'Liechtenstein');
insert into countries (id, name) values (45, 'Portugal');
insert into countries (id, name) values (47, 'Sweden');
insert into countries (id, name) values (48, 'Sudan');
insert into countries (id, name) values (49, 'Afghanistan');
insert into countries (id, name) values (50, 'Iran');
insert into countries (id, name) values (51, 'Mexico');
insert into countries (id, name) values (56, 'Denmark');
insert into countries (id, name) values (61, 'Israel');
insert into countries (id, name) values (63, 'Greece');
insert into countries (id, name) values (66, 'Peru');
insert into countries (id, name) values (72, 'Central African Republic');
insert into countries (id, name) values (76, 'Netherlands');
insert into countries (id, name) values (77, 'Guatemala');
insert into countries (id, name) values (78, 'Argentina');
insert into countries (id, name) values (80, 'Aruba');
insert into countries (id, name) values (83, 'Kosovo');
insert into countries (id, name) values (91, 'Vietnam');
insert into countries (id, name) values (97, 'New Zealand');
insert into countries (id, name) values (92, 'Brazil');
insert into countries (id, name) values (93, 'Germany');
insert into countries (id, name) values (94, 'Italy');
insert into countries (id, name) values (95, 'Spain');



insert into towns (id, name, country_id) values (1, 'Samsan', 2);
insert into towns (id, name, country_id) values (2, 'Saint Petersburg', 4);
insert into towns (id, name, country_id) values (3, 'Gaoliban', 2);
insert into towns (id, name, country_id) values (4, 'Bangbayang Kaler', 5);
insert into towns (id, name, country_id) values (5, 'Porto Seguro', 92);
insert into towns (id, name, country_id) values (6, 'Lameira', 45);
insert into towns (id, name, country_id) values (8, 'Bromma', 47);
insert into towns (id, name, country_id) values (9, 'Irákleia', 63);
insert into towns (id, name, country_id) values (10, 'Santa Catalina', 34);
insert into towns (id, name, country_id) values (11, 'Dongqianhu', 2);
insert into towns (id, name, country_id) values (12, 'Raoshi', 2);
insert into towns (id, name, country_id) values (13, 'Jönköping', 47);
insert into towns (id, name, country_id) values (14, 'Riachão das Neves', 92);
insert into towns (id, name, country_id) values (16, 'Zongjia', 2);
insert into towns (id, name, country_id) values (17, 'Mākū', 50);
insert into towns (id, name, country_id) values (18, 'Łobez', 11);
insert into towns (id, name, country_id) values (19, 'Novotroitskaya', 4);
insert into towns (id, name, country_id) values (20, 'Pashkovskiy', 4);
insert into towns (id, name, country_id) values (21, 'Junbu', 2);
insert into towns (id, name, country_id) values (22, 'Smolensk', 4);
insert into towns (id, name, country_id) values (23, 'Ipoh', 22);
insert into towns (id, name, country_id) values (24, 'Lühua', 2);
insert into towns (id, name, country_id) values (25, 'Santa Helena de Goiás', 92);
insert into towns (id, name, country_id) values (26, 'Passos', 92);
insert into towns (id, name, country_id) values (27, 'Nierumai', 2);
insert into towns (id, name, country_id) values (28, 'Coronel Fabriciano', 92);
insert into towns (id, name, country_id) values (29, 'Tomioka', 33);
insert into towns (id, name, country_id) values (32, 'Nevers', 39);
insert into towns (id, name, country_id) values (33, 'Ribeira Grande', 45);
insert into towns (id, name, country_id) values (36, 'Gon’ba', 4);
insert into towns (id, name, country_id) values (37, 'Ban Talat Bueng', 40);
insert into towns (id, name, country_id) values (38, 'Montréal-Ouest', 17);
insert into towns (id, name, country_id) values (39, 'Svalöv', 47);
insert into towns (id, name, country_id) values (40, 'Jeponkrajan', 5);
insert into towns (id, name, country_id) values (41, 'Priozërsk', 4);
insert into towns (id, name, country_id) values (42, 'Genteng', 5);
insert into towns (id, name, country_id) values (43, 'Chilliwack', 17);
insert into towns (id, name, country_id) values (44, 'Qinnan', 2);
insert into towns (id, name, country_id) values (45, 'Dalubian', 2);
insert into towns (id, name, country_id) values (48, 'Santo Antônio do Amparo', 92);
insert into towns (id, name, country_id) values (49, 'Rajal Norte', 34);
insert into towns (id, name, country_id) values (50, 'Alvaro Obregon', 51);
insert into towns (id, name, country_id) values (52, 'Montbéliard', 39);
insert into towns (id, name, country_id) values (53, 'Fredrikstad', 11);
insert into towns (id, name, country_id) values (54, 'Wushan', 2);
insert into towns (id, name, country_id) values (55, 'Połomia', 11);
insert into towns (id, name, country_id) values (56, 'Usuki', 33);
insert into towns (id, name, country_id) values (57, 'Pikalëvo', 4);
insert into towns (id, name, country_id) values (58, 'Dresden', 93);
insert into towns (id, name, country_id) values (62, 'Bobolice', 11);
insert into towns (id, name, country_id) values (63, 'Huanuni', 92);
insert into towns (id, name, country_id) values (68, 'Bagacay', 34);
insert into towns (id, name, country_id) values (71, 'Pueblo Nuevo', 91);
insert into towns (id, name, country_id) values (72, 'Thị Trấn Mường Khương', 91);
insert into towns (id, name, country_id) values (73, 'Korsakovo', 4);
insert into towns (id, name, country_id) values (75, 'Genova', 94);
insert into towns (id, name, country_id) values (76, 'Maurole', 5);
insert into towns (id, name, country_id) values (77, 'Ulanov', 4);
insert into towns (id, name, country_id) values (78, 'Lubomierz', 11);
insert into towns (id, name, country_id) values (79, 'Yeroẖam', 61);
insert into towns (id, name, country_id) values (80, 'Kaltan', 4);
insert into towns (id, name, country_id) values (82, 'Três Passos', 92);
insert into towns (id, name, country_id) values (83, 'Hongshi', 2);
insert into towns (id, name, country_id) values (84, 'Piskivka', 4);
insert into towns (id, name, country_id) values (85, 'Lianzhou', 2);
insert into towns (id, name, country_id) values (86, 'Nirasaki', 33);
insert into towns (id, name, country_id) values (87, 'Dimayon', 34);
insert into towns (id, name, country_id) values (88, 'Vostochnyy', 4);
insert into towns (id, name, country_id) values (90, 'Meijiang', 2);
insert into towns (id, name, country_id) values (91, 'Podbuzh', 4);
insert into towns (id, name, country_id) values (92, 'Francisco Beltrão', 92);
insert into towns (id, name, country_id) values (93, 'Taraju', 5);
insert into towns (id, name, country_id) values (94, 'Przeworsk', 11);
insert into towns (id, name, country_id) values (95, 'Sacsamarca', 66);
insert into towns (id, name, country_id) values (96, 'Cacequi', 92);
insert into towns (id, name, country_id) values (97, 'Almeria', 95);
insert into towns (id, name, country_id) values (99, 'Zavolzh’ye', 4);
insert into towns (id, name, country_id) values (100, 'Bascaron', 34);


insert into stadiums (id, name, capacity, town_id) values (1, 'Demimbu', 21998, 68);
insert into stadiums (id, name, capacity, town_id) values (2, 'Mybuzz', 9347, 8);
insert into stadiums (id, name, capacity, town_id) values (3, 'Jayo', 77956, 50);
insert into stadiums (id, name, capacity, town_id) values (4, 'Cogibox', 53572, 28);
insert into stadiums (id, name, capacity, town_id) values (6, 'BlogXS', 1530, 85);
insert into stadiums (id, name, capacity, town_id) values (7, 'Brainsphere', 97725, 52);
insert into stadiums (id, name, capacity, town_id) values (8, 'Innojam', 80645, 53);
insert into stadiums (id, name, capacity, town_id) values (9, 'Roomm', 52456, 3);
insert into stadiums (id, name, capacity, town_id) values (10, 'Gabcube', 91778, 28);
insert into stadiums (id, name, capacity, town_id) values (11, 'Wikido', 82541, 38);
insert into stadiums (id, name, capacity, town_id) values (14, 'Jaxspan', 10076, 99);
insert into stadiums (id, name, capacity, town_id) values (15, 'Zoomcast', 43803, 5);
insert into stadiums (id, name, capacity, town_id) values (16, 'Chatterbridge', 44401, 26);
insert into stadiums (id, name, capacity, town_id) values (17, 'Riffpedia', 83548, 14);
insert into stadiums (id, name, capacity, town_id) values (18, 'Tagchat', 87630, 27);
insert into stadiums (id, name, capacity, town_id) values (19, 'Realfire', 50446, 16);
insert into stadiums (id, name, capacity, town_id) values (20, 'Kamba', 57210, 1);
insert into stadiums (id, name, capacity, town_id) values (21, 'Kimia', 97795, 26);
insert into stadiums (id, name, capacity, town_id) values (22, 'Skippad', 50321, 96);
insert into stadiums (id, name, capacity, town_id) values (24, 'InnoZ', 31402, 72);
insert into stadiums (id, name, capacity, town_id) values (25, 'Edgeblab', 97227, 62);
insert into stadiums (id, name, capacity, town_id) values (26, 'Photospace', 45816, 95);
insert into stadiums (id, name, capacity, town_id) values (27, 'Cogidoo', 68002, 44);
insert into stadiums (id, name, capacity, town_id) values (28, 'Dabjam', 86041, 22);
insert into stadiums (id, name, capacity, town_id) values (29, 'Zoombeat', 84070, 4);
insert into stadiums (id, name, capacity, town_id) values (30, 'Browsebug', 28123, 4);
insert into stadiums (id, name, capacity, town_id) values (31, 'Vitz', 65484, 49);
insert into stadiums (id, name, capacity, town_id) values (32, 'Feedfire', 97762, 40);
insert into stadiums (id, name, capacity, town_id) values (33, 'Vidoo', 59493, 39);
insert into stadiums (id, name, capacity, town_id) values (34, 'Feedmix', 51604, 17);
insert into stadiums (id, name, capacity, town_id) values (36, 'Buzzbean', 56063, 4);
insert into stadiums (id, name, capacity, town_id) values (37, 'Kwimbee', 25939, 27);
insert into stadiums (id, name, capacity, town_id) values (38, 'Fivechat', 71732, 58);
insert into stadiums (id, name, capacity, town_id) values (40, 'Kaymbo', 85718, 56);
insert into stadiums (id, name, capacity, town_id) values (41, 'Bluezoom', 97346, 4);
insert into stadiums (id, name, capacity, town_id) values (42, 'Einti', 62201, 73);
insert into stadiums (id, name, capacity, town_id) values (43, 'Skimia', 9147, 42);
insert into stadiums (id, name, capacity, town_id) values (44, 'Edgetag', 81952, 2);
insert into stadiums (id, name, capacity, town_id) values (45, 'Zazio', 85645, 25);
insert into stadiums (id, name, capacity, town_id) values (46, 'JumpXS', 54109, 45);
insert into stadiums (id, name, capacity, town_id) values (47, 'Blogpad', 24940, 26);
insert into stadiums (id, name, capacity, town_id) values (48, 'Topicstorm', 51470, 14);
insert into stadiums (id, name, capacity, town_id) values (50, 'Kare', 86490, 24);
insert into stadiums (id, name, capacity, town_id) values (51, 'Quinu', 84837, 11);
insert into stadiums (id, name, capacity, town_id) values (52, 'Oba', 64364, 49);
insert into stadiums (id, name, capacity, town_id) values (53, 'Youspan', 89397, 2);
insert into stadiums (id, name, capacity, town_id) values (54, 'Meemm', 59073, 57);
insert into stadiums (id, name, capacity, town_id) values (55, 'Tavu', 49969, 38);
insert into stadiums (id, name, capacity, town_id) values (56, 'Yotz', 88681, 79);
insert into stadiums (id, name, capacity, town_id) values (57, 'Realpoint', 99933, 96);
insert into stadiums (id, name, capacity, town_id) values (58, 'Blogtags', 97294, 6);
insert into stadiums (id, name, capacity, town_id) values (59, 'Eare', 70126, 87);
insert into stadiums (id, name, capacity, town_id) values (60, 'Skippad', 65372, 53);
insert into stadiums (id, name, capacity, town_id) values (61, 'Jaloo', 14002, 3);
insert into stadiums (id, name, capacity, town_id) values (63, 'Eire', 28968, 10);
insert into stadiums (id, name, capacity, town_id) values (64, 'Mymm', 67757, 37);
insert into stadiums (id, name, capacity, town_id) values (65, 'Quaxo', 26706, 94);
insert into stadiums (id, name, capacity, town_id) values (66, 'Kazio', 39267, 49);
insert into stadiums (id, name, capacity, town_id) values (67, 'Eamia', 85236, 99);
insert into stadiums (id, name, capacity, town_id) values (68, 'Agivu', 26828, 18);
insert into stadiums (id, name, capacity, town_id) values (69, 'Zoovu', 18090, 8);
insert into stadiums (id, name, capacity, town_id) values (70, 'Trudoo', 83935, 58);
insert into stadiums (id, name, capacity, town_id) values (71, 'Wordware', 39600, 72);
insert into stadiums (id, name, capacity, town_id) values (72, 'Dabvine', 71041, 68);
insert into stadiums (id, name, capacity, town_id) values (73, 'Avaveo', 42490, 52);
insert into stadiums (id, name, capacity, town_id) values (74, 'Topiczoom', 51142, 2);
insert into stadiums (id, name, capacity, town_id) values (75, 'Thoughtbeat', 12302, 29);
insert into stadiums (id, name, capacity, town_id) values (76, 'Flipstorm', 92857, 62);
insert into stadiums (id, name, capacity, town_id) values (79, 'Trilith', 93996, 72);
insert into stadiums (id, name, capacity, town_id) values (80, 'Eadel', 73873, 83);
insert into stadiums (id, name, capacity, town_id) values (81, 'Viva', 98698, 62);
insert into stadiums (id, name, capacity, town_id) values (83, 'Mydeo', 47344, 94);
insert into stadiums (id, name, capacity, town_id) values (84, 'Linkbuzz', 14802, 88);
insert into stadiums (id, name, capacity, town_id) values (85, 'Innotype', 49692, 58);
insert into stadiums (id, name, capacity, town_id) values (86, 'Izio', 79836, 14);
insert into stadiums (id, name, capacity, town_id) values (87, 'Edgeify', 61464, 100);
insert into stadiums (id, name, capacity, town_id) values (88, 'Divape', 24058, 24);
insert into stadiums (id, name, capacity, town_id) values (89, 'Realblab', 50504, 97);
insert into stadiums (id, name, capacity, town_id) values (90, 'Dazzlesphere', 25051, 23);
insert into stadiums (id, name, capacity, town_id) values (91, 'Jaxworks', 95281, 13);
insert into stadiums (id, name, capacity, town_id) values (94, 'Pixonyx', 18757, 75);
insert into stadiums (id, name, capacity, town_id) values (96, 'Voolith', 35062, 33);
insert into stadiums (id, name, capacity, town_id) values (97, 'Zooveo', 39163, 99);
insert into stadiums (id, name, capacity, town_id) values (98, 'Leexo', 10848, 55);
insert into stadiums (id, name, capacity, town_id) values (99, 'Linklinks', 54085, 75);
insert into stadiums (id, name, capacity, town_id) values (100, 'Twitterbridge', 28230, 49);



insert into teams (id, name, established, fan_base, stadium_id) values (1, 'Skyble', '1953-11-14', 5381600486852672412, 69);
insert into teams (id, name, established, fan_base, stadium_id) values (2, 'Skajo', '1947-01-13', 3060821043074282055, 94);
insert into teams (id, name, established, fan_base, stadium_id) values (3, 'Yadel', '1944-03-01', 6386246859904901308, 51);
insert into teams (id, name, established, fan_base, stadium_id) values (4, 'Devpoint', '1961-02-22', 6215350118892605178, 85);
insert into teams (id, name, established, fan_base, stadium_id) values (6, 'Roombo', '1977-12-26', 7073663598690561405, 80);
insert into teams (id, name, established, fan_base, stadium_id) values (8, 'Realcube', '2006-01-04', 7021566034033315258, 25);
insert into teams (id, name, established, fan_base, stadium_id) values (9, 'Feednation', '1915-03-16', 3982306259829591228, 40);
insert into teams (id, name, established, fan_base, stadium_id) values (10, 'Wikizz', '1904-05-26', 1436596681261571018, 45);
insert into teams (id, name, established, fan_base, stadium_id) values (13, 'Tanoodle', '1904-12-27', 3287399043417734666, 50);
insert into teams (id, name, established, fan_base, stadium_id) values (14, 'Photolist', '2005-06-05', 876656133954277640, 36);
insert into teams (id, name, established, fan_base, stadium_id) values (15, 'Pixope', '1992-09-23', 1729201483122224567, 40);
insert into teams (id, name, established, fan_base, stadium_id) values (16, 'Bubbletube', '1918-05-18', 7140299616505850269, 38);
insert into teams (id, name, established, fan_base, stadium_id) values (17, 'Jetwire', '1945-08-28', 5375286698890587231, 38);
insert into teams (id, name, established, fan_base, stadium_id) values (21, 'Photobean', '2002-05-21', 8178357466089602342, 58);
insert into teams (id, name, established, fan_base, stadium_id) values (22, 'Divape', '1922-07-11', 6963522629534850779, 48);
insert into teams (id, name, established, fan_base, stadium_id) values (23, 'Dablist', '1997-10-24', 794437919525920573, 54);
insert into teams (id, name, established, fan_base, stadium_id) values (24, 'Fadeo', '1905-02-09', 3698680202724931601, 32);
insert into teams (id, name, established, fan_base, stadium_id) values (25, 'Myworks', '1982-01-09', 7780349345745097505, 26);
insert into teams (id, name, established, fan_base, stadium_id) values (26, 'Feedmix', '2013-02-19', 5138699256958311659, 91);
insert into teams (id, name, established, fan_base, stadium_id) values (27, 'Voolith', '1914-11-24', 7043720697648815633, 89);
insert into teams (id, name, established, fan_base, stadium_id) values (28, 'Yata', '1932-01-30', 1268602933821301763, 56);
insert into teams (id, name, established, fan_base, stadium_id) values (29, 'Flipopia', '2008-04-24', 6672653436110284307, 22);
insert into teams (id, name, established, fan_base, stadium_id) values (30, 'Fiveclub', '1997-07-01', 1536691600011844615, 6);
insert into teams (id, name, established, fan_base, stadium_id) values (31, 'Voomm', '1978-01-10', 4105417083349095755, 46);
insert into teams (id, name, established, fan_base, stadium_id) values (32, 'Skyvu', '2004-05-26', 1160854837502637250, 1);
insert into teams (id, name, established, fan_base, stadium_id) values (33, 'Tagcat', '2018-07-03', 5826937455976510417, 1);
insert into teams (id, name, established, fan_base, stadium_id) values (34, 'Trilith', '1940-05-03', 8216613172238695440, 16);
insert into teams (id, name, established, fan_base, stadium_id) values (35, 'Dabtype', '2014-03-18', 911369134867223134, 38);
insert into teams (id, name, established, fan_base, stadium_id) values (36, 'Voolia', '1918-09-08', 1333656558698142583, 89);
insert into teams (id, name, established, fan_base, stadium_id) values (37, 'Shuffletag', '1960-08-18', 8190843914298347287, 21);
insert into teams (id, name, established, fan_base, stadium_id) values (38, 'Pixonyx', '1976-04-27', 319927746577385011, 28);
insert into teams (id, name, established, fan_base, stadium_id) values (40, 'Skiptube', '1961-11-04', 8935340069190771592, 52);
insert into teams (id, name, established, fan_base, stadium_id) values (41, 'Quinu', '1994-06-12', 5876435157776002083, 94);
insert into teams (id, name, established, fan_base, stadium_id) values (43, 'Realbridge', '1969-01-05', 4541229891367264937, 34);
insert into teams (id, name, established, fan_base, stadium_id) values (44, 'Fatz', '1983-05-05', 4790331150070136719, 69);
insert into teams (id, name, established, fan_base, stadium_id) values (45, 'Ntags', '1981-06-05', 3508984270641351110, 16);
insert into teams (id, name, established, fan_base, stadium_id) values (46, 'Browsebug', '1930-09-08', 1801270536254666585, 55);
insert into teams (id, name, established, fan_base, stadium_id) values (48, 'Skivee', '1931-02-05', 736740182984678619, 56);
insert into teams (id, name, established, fan_base, stadium_id) values (49, 'Katz', '1913-09-29', 5012189250438264342, 40);
insert into teams (id, name, established, fan_base, stadium_id) values (50, 'Dabfeed', '1940-04-28', 1819467455864248592, 48);
insert into teams (id, name, established, fan_base, stadium_id) values (52, 'Twinte', '1994-04-22', 9146216041973848053, 27);
insert into teams (id, name, established, fan_base, stadium_id) values (53, 'Eire', '1927-03-06', 5482061253080674936, 14);
insert into teams (id, name, established, fan_base, stadium_id) values (54, 'Edgetag', '1907-05-14', 6158211782371509093, 81);
insert into teams (id, name, established, fan_base, stadium_id) values (55, 'Yakitri', '1980-11-25', 7105240609489291112, 27);
insert into teams (id, name, established, fan_base, stadium_id) values (56, 'Yodoo', '1944-01-03', 3469901618101059464, 84);
insert into teams (id, name, established, fan_base, stadium_id) values (57, 'Vinte', '2014-05-21', 4388010667399843460, 59);
insert into teams (id, name, established, fan_base, stadium_id) values (58, 'Jamia', '1951-02-27', 5742547975482276839, 72);
insert into teams (id, name, established, fan_base, stadium_id) values (59, 'Miboo', '1971-08-02', 30087062078800256, 27);
insert into teams (id, name, established, fan_base, stadium_id) values (60, 'Cogilith', '1905-03-06', 8494896707349423124, 90);
insert into teams (id, name, established, fan_base, stadium_id) values (61, 'Meembee', '1920-09-19', 3623803303972110845, 72);
insert into teams (id, name, established, fan_base, stadium_id) values (62, 'Ailane', '1963-08-20', 6711237100133852778, 91);
insert into teams (id, name, established, fan_base, stadium_id) values (63, 'Zoombox', '1928-06-23', 5587047626464497328, 83);
insert into teams (id, name, established, fan_base, stadium_id) values (64, 'Wikibox', '1936-12-10', 7279586585838963694, 61);
insert into teams (id, name, established, fan_base, stadium_id) values (65, 'Browsetype', '1925-08-17', 5292240404387586366, 21);
insert into teams (id, name, established, fan_base, stadium_id) values (66, 'Ntag', '2000-09-27', 7755181941187484930, 51);
insert into teams (id, name, established, fan_base, stadium_id) values (67, 'Buzzbean', '2018-11-15', 666316370089900538, 29);
insert into teams (id, name, established, fan_base, stadium_id) values (68, 'Skaboo', '1984-01-19', 2615683851634869122, 52);
insert into teams (id, name, established, fan_base, stadium_id) values (69, 'Livetube', '1944-08-07', 5735345547221813220, 48);
insert into teams (id, name, established, fan_base, stadium_id) values (70, 'Divavu', '1922-09-16', 244790118398382264, 65);
insert into teams (id, name, established, fan_base, stadium_id) values (71, 'Meetz', '1902-05-21', 2285861017794534935, 69);
insert into teams (id, name, established, fan_base, stadium_id) values (72, 'Tagopia', '1968-06-08', 2067286362619260830, 84);
insert into teams (id, name, established, fan_base, stadium_id) values (73, 'Zoonoodle', '1910-02-05', 4705666461892628623, 87);
insert into teams (id, name, established, fan_base, stadium_id) values (74, 'Kanoodle', '2013-05-23', 5695178504367952624, 76);
insert into teams (id, name, established, fan_base, stadium_id) values (75, 'Tagchat', '1907-12-12', 2153317859111089038, 27);
insert into teams (id, name, established, fan_base, stadium_id) values (78, 'Vinder', '1983-08-28', 5521362466164868088, 61);
insert into teams (id, name, established, fan_base, stadium_id) values (79, 'Yombu', '1974-11-12', 2242657548817015598, 88);
insert into teams (id, name, established, fan_base, stadium_id) values (80, 'Photobug', '1985-02-07', 6590272482775810761, 65);
insert into teams (id, name, established, fan_base, stadium_id) values (81, 'Gabtype', '2001-08-10', 5538742810653865932, 79);
insert into teams (id, name, established, fan_base, stadium_id) values (82, 'Meevee', '1900-11-09', 3089350741966143308, 11);
insert into teams (id, name, established, fan_base, stadium_id) values (83, 'Thoughtstorm', '1975-05-22', 2713385532319684164, 11);
insert into teams (id, name, established, fan_base, stadium_id) values (84, 'Eamia', '1911-03-15', 4143670135638409582, 51);
insert into teams (id, name, established, fan_base, stadium_id) values (86, 'Mymm', '2014-08-05', 1590890837666208012, 88);
insert into teams (id, name, established, fan_base, stadium_id) values (87, 'Tekfly', '1911-12-12', 664362306291639287, 24);
insert into teams (id, name, established, fan_base, stadium_id) values (88, 'Dabshots', '1997-11-08', 2430628559570464120, 36);
insert into teams (id, name, established, fan_base, stadium_id) values (89, 'Abatz', '1973-04-06', 7761143031795602215, 70);
insert into teams (id, name, established, fan_base, stadium_id) values (90, 'Shufflester', '1982-04-25', 7180824955244215528, 33);
insert into teams (id, name, established, fan_base, stadium_id) values (91, 'Gabcube', '2010-03-08', 9081583761206262386, 33);
insert into teams (id, name, established, fan_base, stadium_id) values (92, 'Skipstorm', '1943-05-09', 7026806565631068300, 91);
insert into teams (id, name, established, fan_base, stadium_id) values (93, 'Dabshots', '1933-12-06', 1315623029582223186, 14);
insert into teams (id, name, established, fan_base, stadium_id) values (94, 'Snaptags', '1903-02-23', 2925448464723899669, 30);
insert into teams (id, name, established, fan_base, stadium_id) values (95, 'Trupe', '2002-11-09', 8657673499207692507, 63);
insert into teams (id, name, established, fan_base, stadium_id) values (96, 'Fivespan', '1937-12-13', 1367828221665223895, 15);
insert into teams (id, name, established, fan_base, stadium_id) values (97, 'Plajo', '1952-06-14', 7105974836341759099, 15);
insert into teams (id, name, established, fan_base, stadium_id) values (98, 'Jabbercube', '1904-04-04', 8046368032925194865, 91);
insert into teams (id, name, established, fan_base, stadium_id) values (99, 'Devify', '1921-10-23', 6988886166251943170, 18);
insert into teams (id, name, established, fan_base, stadium_id) values (100, 'Demizz', '2018-12-14', 3696633192817061145, 55);

insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (1, 95, 65, 11, 98, 72, 54);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (2, 15, 94, 3, 27, 69, 97);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (3, 17, 46, 35, 84, 59, 89);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (4, 99, 38, 42, 44, 40, 22);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (5, 59, 46, 1, 29, 92, 48);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (6, 80, 69, 49, 9, 67, 37);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (7, 3, 71, 55, 64, 70, 34);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (8, 34, 21, 97, 8, 10, 20);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (9, 13, 40, 74, 21, 71, 4);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (10, 8, 62, 41, 68, 57, 7);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (11, 26, 54, 16, 9, 22, 21);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (12, 62, 14, 76, 63, 97, 24);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (13, 59, 56, 61, 73, 41, 52);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (14, 29, 34, 94, 47, 4, 92);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (15, 27, 37, 29, 74, 3, 68);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (16, 72, 30, 86, 8, 43, 64);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (17, 78, 11, 9, 43, 28, 74);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (18, 3, 9, 69, 3, 34, 51);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (19, 77, 26, 86, 15, 86, 6);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (20, 89, 89, 15, 53, 19, 16);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (21, 77, 1, 89, 19, 42, 42);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (22, 10, 54, 68, 38, 4, 76);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (23, 2, 36, 39, 34, 2, 21);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (24, 10, 94, 94, 73, 7, 3);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (25, 14, 27, 58, 5, 61, 7);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (26, 56, 78, 13, 92, 18, 55);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (27, 56, 26, 4, 29, 48, 87);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (28, 11, 77, 76, 15, 6, 7);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (29, 26, 77, 94, 50, 51, 67);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (30, 72, 63, 7, 49, 69, 67);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (31, 36, 37, 49, 20, 65, 26);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (32, 57, 36, 13, 8, 66, 22);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (33, 99, 77, 90, 24, 57, 60);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (34, 68, 41, 6, 75, 86, 77);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (35, 37, 20, 72, 27, 22, 56);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (36, 14, 81, 58, 77, 33, 7);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (37, 39, 70, 37, 47, 10, 14);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (38, 23, 6, 97, 94, 19, 84);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (39, 71, 37, 22, 3, 73, 87);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (40, 74, 29, 39, 72, 49, 55);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (41, 32, 4, 94, 73, 50, 18);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (42, 35, 86, 69, 56, 23, 97);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (43, 80, 81, 18, 23, 94, 7);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (44, 33, 4, 19, 9, 92, 62);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (45, 14, 82, 1, 68, 92, 9);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (46, 54, 72, 84, 44, 88, 73);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (47, 75, 67, 50, 77, 56, 8);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (48, 97, 46, 26, 1, 11, 61);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (49, 90, 49, 3, 16, 48, 24);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (50, 41, 67, 84, 52, 83, 97);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (51, 49, 82, 8, 11, 98, 86);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (52, 9, 53, 11, 66, 29, 52);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (53, 28, 22, 67, 89, 2, 66);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (54, 52, 90, 70, 33, 84, 13);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (55, 84, 51, 99, 51, 22, 5);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (56, 6, 86, 23, 33, 16, 46);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (57, 72, 43, 79, 83, 52, 60);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (58, 71, 32, 16, 18, 42, 27);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (59, 78, 49, 70, 67, 51, 25);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (60, 28, 2, 62, 43, 54, 63);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (61, 51, 48, 87, 9, 63, 13);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (62, 16, 93, 57, 99, 5, 27);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (63, 4, 37, 32, 50, 37, 68);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (64, 41, 63, 82, 37, 97, 86);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (65, 70, 98, 44, 91, 89, 65);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (66, 50, 4, 92, 67, 5, 17);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (67, 17, 91, 31, 34, 88, 91);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (68, 44, 43, 4, 44, 65, 44);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (69, 93, 88, 76, 79, 18, 43);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (70, 68, 3, 53, 21, 86, 50);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (71, 14, 57, 18, 57, 14, 63);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (72, 33, 17, 11, 5, 84, 58);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (73, 68, 67, 90, 93, 90, 13);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (74, 18, 31, 74, 17, 92, 53);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (75, 26, 70, 46, 55, 47, 55);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (76, 53, 70, 73, 97, 59, 54);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (77, 48, 61, 11, 87, 41, 8);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (78, 11, 2, 82, 45, 36, 5);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (79, 97, 83, 6, 22, 24, 14);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (80, 95, 94, 55, 66, 42, 2);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (81, 43, 24, 45, 58, 43, 34);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (82, 1, 24, 5, 88, 47, 53);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (83, 27, 24, 7, 42, 25, 99);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (84, 13, 17, 18, 38, 70, 79);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (85, 75, 1, 35, 56, 65, 51);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (86, 91, 71, 35, 95, 9, 89);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (87, 83, 32, 40, 85, 33, 9);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (88, 23, 79, 6, 8, 2, 30);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (89, 19, 26, 70, 32, 66, 90);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (90, 57, 41, 42, 10, 14, 57);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (91, 24, 7, 82, 32, 89, 62);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (92, 79, 87, 47, 7, 40, 5);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (93, 95, 25, 23, 88, 20, 62);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (94, 40, 43, 22, 99, 80, 11);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (95, 95, 67, 48, 38, 63, 36);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (96, 92, 57, 75, 39, 24, 40);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (97, 66, 99, 42, 29, 13, 63);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (98, 85, 43, 27, 31, 15, 29);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (99, 72, 82, 50, 73, 87, 51);
insert into skills_data (id, dribbling, pace, passing, shooting, speed, strength) values (100, 56, 40, 54, 87, 67, 32);

insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (1, 'Alden', 'Wrettum', 21, 'A', 32283.83, NULL, 87, NULL);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (2, 'Dayna', 'Halesworth', 23, 'M', 897853.69, '2020-01-15 07:26:33', 88, 91);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (3, 'Estelle', 'Aldred', 46, 'D', 937362.62, '2014-06-08 10:27:48', 4, 91);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (4, 'Bibbye', 'O''Lunney', 44, 'A', 961275.08, '2019-04-11 22:55:37', 40, 45);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (5, 'Lin', 'Teasdale-Markie', 47, 'M', 920520.47, '2018-12-05 03:42:21', 36, 62);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (6, 'Walther', 'Olenchenko', 28, 'D', 796695.25, NULL, 68, NULL);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (7, 'Harlie', 'Sandells', 50, 'M', 790427.89, '2011-02-25 04:35:48', 59, 37);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (8, 'Urbanus', 'Costin', 26, 'A', 479024.79, '2019-11-25 18:40:55', 6, 86);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (9, 'Jorrie', 'Huguenet', 20, 'D', 753355.32, NULL, 55, NULL);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (10, 'Lammond', 'Lightbowne', 27, 'A', 862676.3, '2013-12-13 11:32:38', 18, 98);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (11, 'Curry', 'Brando', 17, 'M', 511422.9, '2019-08-16 16:02:01', 34, 45);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (12, 'Thor', 'Serrels', 24, 'D', 455601.67, '2013-03-19 15:23:23', 47, 45);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (13, 'Berkie', 'Maryin', 45, 'A', 698230.79, '2016-12-27 13:45:05', 65, 91);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (14, 'Kiersten', 'Maidlow', 29, 'M', 791199.55, '2015-05-04 19:21:41', 15, 83);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (15, 'Barnabas', 'Micah', 46, 'A', 565713.54, '2019-09-09 12:43:08', 87, 43);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (16, 'Eldin', 'Gravet', 35, 'D', 821422.57, '2019-03-23 11:24:11', 69, 64);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (17, 'Glory', 'Crosetti', 28, 'A', 394462.27, '2010-08-05 19:01:14', 13, 1);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (18, 'Doretta', 'Rignold', 42, 'M', 665969.43, '2015-09-18 11:43:44', 40, 79);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (19, 'Gwendolen', 'Semple', 17, 'D', 407582.09, NULL, 94, NULL);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (20, 'Launce', 'Perchard', 44, 'A', 899242.3, '2013-09-13 14:16:39', 70, 17);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (21, 'Vasili', 'Grigorescu', 45, 'M', 46428.66, '2013-12-13 07:18:46', 91, 90);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (22, 'Esta', 'Ingarfill', 48, 'D', 663175.46, '2013-10-17 12:28:11', 94, 62);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (23, 'Kalvin', 'Bewley', 19, 'A', 550420.42, NULL, 15, NULL);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (24, 'Goldi', 'Gouly', 20, 'A', 914066.1, '2016-06-12 22:08:30', 75, 90);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (25, 'Isaak', 'Duncombe', 47, 'D', 586243.8, '2015-01-18 14:33:08', 17, 83);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (26, 'Bartlett', 'Rigglesford', 22, 'M', 414010.4, '2016-11-30 19:14:19', 45, 45);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (27, 'Halsy', 'Scales', 40, 'A', 12794.6, '2015-05-31 23:18:49', 46, 43);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (28, 'Sisely', 'Feares', 20, 'A', 413707.4, '2017-10-09 12:03:13', 28, 1);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (29, 'Dav', 'Durber', 31, 'D', 745029.69, '2016-09-22 06:04:47', 50, 1);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (30, 'Perren', 'Widdowes', 27, 'M', 11423.39, '2012-11-10 07:08:59', 48, 38);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (31, 'Stacy', 'de Copeman', 36, 'A', 156851.33, '2018-11-09 07:12:33', 52, 1);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (32, 'Roosevelt', 'Frape', 36, 'D', 725185.0, '2019-09-03 19:43:30', 76, 1);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (33, 'Ada', 'Doumic', 41, 'M', 271526.17, '2014-11-02 22:11:50', 46, 54);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (34, 'Carolin', 'Petyanin', 49, 'D', 128940.13, '2013-12-12 04:53:00', 14, 34);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (35, 'Blanch', 'Dast', 29, 'A', 138262.58, '2010-12-10 19:29:34', 64, 38);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (36, 'Steffie', 'Emberton', 48, 'A', 72310.29, '2015-09-08 23:55:27', 71, 95);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (37, 'Saw', 'Riste', 29, 'M', 35822.1, '2016-04-03 12:55:50', 81, 36);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (38, 'Ricca', 'Lawrance', 28, 'A', 231233.93, '2019-09-21 17:24:59', 47, 45);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (39, 'Camey', 'Michurin', 27, 'D', 53172.2, '2018-04-08 06:46:25', 14, 38);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (40, 'Carlen', 'Hadny', 18, 'A', 336677.23, NULL, 85, NULL);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (41, 'Mollie', 'Duerdin', 24, 'M', 966079.07, '2010-04-18 06:10:43', 13, 40);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (42, 'Myer', 'Daenen', 16, 'A', 109521.1, '2017-06-19 08:25:13', 3, 100);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (43, 'Jacqueline', 'Mowat', 16, 'A', 78877.68, '2014-08-05 10:03:53', 91, 62);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (44, 'Harmon', 'Phette', 31, 'D', 117039.21, '2010-05-28 12:25:24', 67, 1);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (45, 'Georgie', 'Fildes', 28, 'A', 898257.96, '2011-09-16 12:29:29', 47, 62);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (46, 'Cecilla', 'Clausen-Thue', 36, 'A', 369418.03, '2011-02-06 23:04:31', 99, 45);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (47, 'Ayn', 'Tomsu', 19, 'A', 817970.65, NULL, 8, NULL);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (48, 'Ashley', 'Noyce', 31, 'A', 460354.93, '2019-12-29 10:48:10', 11, 3);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (49, 'Gordan', 'Tuxsell', 21, 'M', 637799.93, '2012-12-14 18:33:29', 24, 62);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (50, 'Millard', 'Danahar', 38, 'D', 118710.45, '2018-01-08 11:19:36', 9, 43);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (51, 'Cristian', 'Tamas', 34, 'A', 56839.58, '2017-04-03 13:32:59', 57, 62);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (52, 'Malissa', 'Paylie', 27, 'A', 397352.27, '2012-05-01 07:52:22', 17, 48);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (53, 'Gerhardine', 'Dow', 39, 'D', 623042.86, '2015-03-27 15:49:01', 30, 52);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (54, 'De witt', 'Blodgett', 35, 'A', 519212.34, '2013-01-27 19:57:56', 17, 45);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (55, 'Tadd', 'Gorbell', 48, 'M', 456460.8, '2015-01-19 02:34:29', 98, 30);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (56, 'Eileen', 'Sowte', 20, 'D', 414352.39, '2010-12-15 05:32:20', 18, 15);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (57, 'Simmonds', 'Brockest', 18, 'A', 522570.7, '2017-03-06 18:24:13', 19, 38);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (58, 'Perl', 'Dawidsohn', 17, 'A', 888546.65, NULL, 48, NULL);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (59, 'Nettle', 'Lund', 38, 'M', 680019.08, '2015-03-07 16:51:02', 25, 45);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (60, 'Marni', 'McDonald', 42, 'D', 298219.2, '2012-04-08 23:10:52', 63, 96);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (61, 'Roxane', 'Lestrange', 33, 'A', 152195.68, '2014-02-13 17:02:02', 97, 57);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (62, 'Akim', 'Rathe', 31, 'M', 982188.88, '2015-04-23 22:36:03', 21, 96);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (63, 'Jonis', 'Kibel', 49, 'D', 851683.55, '2015-02-22 15:16:17', 27, 92);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (64, 'Brendis', 'Sauvage', 46, 'A', 786921.96, '2012-01-08 03:05:39', 54, 38);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (65, 'Kirstyn', 'Menego', 47, 'D', 257056.58, '2013-03-11 22:20:31', 68, 62);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (66, 'Chickie', 'Pellatt', 34, 'A', 704831.0, '2011-07-10 19:00:10', 71, 86);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (67, 'Flemming', 'Tuffey', 17, 'M', 644275.94, NULL, 21, NULL);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (68, 'Fredrika', 'Kobierra', 36, 'D', 532527.47, '2012-09-26 06:56:11', 85, 81);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (69, 'Kinna', 'Tryhorn', 19, 'A', 188978.96, '2012-02-25 02:35:51', 67, 81);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (70, 'Elenore', 'Ventura', 31, 'A', 622814.15, '2011-08-11 01:03:48', 50, 38);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (71, 'Maryl', 'Angelini', 25, 'M', 371245.5, '2013-10-28 14:03:43', 25, 31);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (72, 'Bobette', 'McGenis', 24, 'D', 163624.46, '2013-05-28 13:11:29', 54, 62);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (73, 'Tonnie', 'Hanburry', 38, 'A', 790860.06, '2011-06-25 11:27:16', 55, 83);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (74, 'Zuzana', 'Kempstone', 34, 'M', 1620.25, '2019-10-05 20:09:24', 57, 96);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (75, 'Aldon', 'Spadazzi', 40, 'D', 631331.47, '2016-08-16 00:43:07', 81, 70);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (76, 'Grethel', 'Checchetelli', 45, 'A', 95594.73, '2015-12-01 15:18:49', 94, 38);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (77, 'Jemie', 'Coniff', 40, 'A', 840606.23, '2010-04-29 22:32:55', 45, 45);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (78, 'Alethea', 'Lednor', 21, 'M', 719049.22, NULL, 31, NULL);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (79, 'Roscoe', 'Durkin', 29, 'D', 452790.68, '2016-02-29 18:24:54', 1, 33);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (80, 'Royal', 'Deakes', 19, 'A', 49162.77, '2012-12-02 04:22:43', 44, 1);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (81, 'Elysee', 'Dunstone', 33, 'M', 817944.93, '2016-04-03 00:38:48', 4, 62);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (82, 'Carola', 'Alelsandrovich', 32, 'A', 512204.06, '2011-06-08 12:39:58', 31, 1);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (83, 'Roxi', 'Stanyland', 22, 'A', 876807.09, NULL, 2, NULL);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (84, 'Chrisse', 'Piser', 20, 'D', 949206.14, '2016-10-06 00:35:33', 97, 62);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (85, 'Carlynne', 'Padillo', 49, 'M', 316299.71, '2012-05-16 13:59:35', 7, 96);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (86, 'Lyell', 'Scrowton', 43, 'M', 117038.47, '2018-05-27 22:56:39', 20, 43);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (87, 'Pet', 'Malzard', 19, 'D', 487243.87, NULL, 95, NULL);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (88, 'Seth', 'Samme', 20, 'A', 547008.09, '2017-07-15 02:07:39', 14, 58);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (89, 'Renault', 'Keighly', 24, 'A', 984113.71, '2014-12-15 08:15:47', 45, 86);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (90, 'Melodee', 'McVey', 22, 'A', 578112.19, '2018-02-11 08:41:37', 99, 26);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (91, 'Helen', 'Ell', 32, 'M', 213091.23, '2012-03-07 10:15:22', 30, 55);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (92, 'Shamus', 'Illingsworth', 39, 'D', 5735.23, '2012-09-12 21:57:07', 11, 44);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (93, 'Curtis', 'Lawrenceson', 41, 'A', 37071.45, '2013-06-21 15:31:00', 96, 96);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (94, 'Gaby', 'Yare', 45, 'A', 690051.9, '2015-06-11 17:08:01', 29, 52);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (95, 'Marquita', 'Sigert', 27, 'D', 619853.74, '2017-02-19 23:07:14', 46, 92);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (96, 'Kate', 'Taylder', 36, 'M', 495908.54, '2013-11-23 16:47:29', 61, 99);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (97, 'Gianni', 'Morrow', 16, 'A', 762456.74, NULL, 45, NULL);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (98, 'Meredith', 'Duffett', 46, 'D', 77373.25, '2015-10-30 16:20:42', 26, 64);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (99, 'Miranda', 'Frichley', 45, 'A', 307130.04, '2019-06-20 16:31:41', 53, 29);
insert into players (id, first_name, last_name, age, position, salary, hire_date, skills_data_id, team_id) values (100, 'Jorrie', 'Lumsden', 50, 'M', 508035.44, '2010-09-19 11:52:56', 4, 65);


insert into coaches (id, first_name, last_name, coach_level) values (1, 'Anollie', 'Phelip', 4);
insert into coaches (id, first_name, last_name, coach_level) values (2, 'Aster', 'Krolak', 1);
insert into coaches (id, first_name, last_name, coach_level) values (3, 'Aesra', 'Simoneton', 4);
insert into coaches (id, first_name, last_name, coach_level) values (4, 'Acad', 'Clyne', 1);
insert into coaches (id, first_name, last_name, coach_level) values (5, 'Arcos', 'Chettle', 8);
insert into coaches (id, first_name, last_name, coach_level) values (6, 'Reynard', 'Gravenor', 2);
insert into coaches (id, first_name, last_name, coach_level) values (7, 'Mickey', 'Dabernott', 7);
insert into coaches (id, first_name, last_name, coach_level) values (8, 'Chilton', 'Cookley', 4);
insert into coaches (id, first_name, last_name, coach_level) values (9, 'Rudie', 'Gorgl', 2);
insert into coaches (id, first_name, last_name, coach_level) values (10, 'Lewes', 'Dymocke', 7);


insert into players_coaches(player_id , coach_id) VALUE (1, 1);
insert into players_coaches(player_id , coach_id) VALUE (54, 2);
insert into players_coaches(player_id , coach_id) VALUE (17, 5);
insert into players_coaches(player_id , coach_id) VALUE (33, 4);
insert into players_coaches(player_id , coach_id) VALUE (24, 8);
insert into players_coaches(player_id , coach_id) VALUE (66, 10);
insert into players_coaches(player_id , coach_id) VALUE (90, 5);
insert into players_coaches(player_id , coach_id) VALUE (4, 6);
insert into players_coaches(player_id , coach_id) VALUE (39, 10);
insert into players_coaches(player_id , coach_id) VALUE (71, 8);