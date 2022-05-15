INSERT INTO cities VALUES
--(id, name)
(1, 'Воронеж'),
(2, 'Курск'),
(3, 'Липецк'),
(4, 'Белгород');

INSERT INTO service_sites VALUES
--(id, url)
(1, 'https://gk-avtocity.ru/kuzovnoy-remont/'),
(2, 'http://xn--80adopldd2bo6e.xn--p1ai/%D0%BF%D0%BE%D0%BA%D1%80%D0%B0%D1%81%D0%BA%D0%B0-%D0%BA%D1%83%D0%B7%D0%BE%D0%B2%D0%B0-%D0%B0%D0%B2%D1%82%D0%BE%D0%BC%D0%BE%D0%B1%D0%B8%D0%BB%D1%8F-%D0%B2-%D0%B2%D0%BE%D1%80%D0%BE%D0%BD%D0%B5%D0%B6/'),
(3, 'http://kuzovnoy-remont-voronezh.ru/price#top'),
(4, 'https://sto-kursk.ru/uslugi-avtoservisa-partner-avto/kuzovnoy-i-malyarnyy-remont/'),
(5, 'http://xn--48-6kcay8apn5a.xn--p1ai/tseny'),
(6, 'https://kuzov31.ru/kuzovnoi-remont/'),
-- для всех
(7, 'http://autoservis48.ru/price/'),
(8, 'https://lipetsk.kuzov-ring.ru/');

INSERT INTO cities_service_сites VALUES
--(city_id, service_site_id)
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(3, 5),
(4, 6),
(1, 7),
(1, 8),
(2, 7),
(2, 8),
(3, 7),
(3, 8),
(4, 7),
(4, 8);

-- todo заменять "vendor_code" на артикул в коде потом
INSERT INTO detail_sites VALUES
--(id, url)
(1, 'https://baza.drom.ru/sell_spare_parts/?query=vendor_code&sortBy=pricea');

INSERT INTO brands VALUES
--(id, name)
(1, 'ВАЗ (Lada)'),
(2, 'Ford'),
(3, 'Renault'),
(4, 'Volkswagen'),
(5, 'Hyundai'),
(6, 'Kia'),
(7, 'Skoda');

INSERT INTO models VALUES
--(id, auto_ru_code, name, brand_id)
(1, 'vaz/2107/', 'ВАЗ 2107', 1),
(2, 'vaz/2110/', 'ВАЗ 2110', 1),
(3, 'vaz/2170/2307319/', 'LADA Priora 1', 1),
(4, 'vaz/2170/20067929/', 'LADA Priora 1 rest', 1),
(5, 'vaz/granta/7684102/', 'LADA Granta 1', 1),
(6, 'vaz/granta/21377296/', 'LADA Granta 1 rest', 1),
(7, 'vaz/vesta/20417749/', 'LADA Vesta 1', 1),
(8, 'ford/focus/2306579/', 'Ford Focus 2 rest', 2),
(9, 'ford/focus/7306596/', 'Ford Focus 3', 2),
(10, 'ford/focus/20243246/', 'Ford Focus 3 rest', 2),
(11, 'renault/logan/6065201/', 'Renault Logan 1 rest', 3),
(12, 'renault/logan/9284092/', 'Renault Logan 2', 3),
(13, 'renault/logan/21335370/', 'Renault Logan 2 rest', 3),
(14, 'renault/sandero/6094595/', 'Renault Sandero 1', 3),
(15, 'renault/sandero/9348009/', 'Renault Sandero 2', 3),
(16, 'renault/sandero/21335771/', 'Renault Sandero 2 rest', 3),
(17, 'renault/duster/7795156/', 'Renault Duster 1', 3),
(18, 'renault/duster/20417950/', 'Renault Duster 1 rest', 3),
(19, 'renault/duster/22764257/', 'Renault Duster 2', 3),
(20, 'volkswagen/polo/5019213/', 'Volkswagen Polo 5', 4),
(21, 'volkswagen/polo/20113124/', 'Volkswagen Polo 5 rest', 4),
(22, 'volkswagen/polo/22163516/', 'Volkswagen Polo 6', 4),
(23, 'hyundai/solaris/6847474/', 'Hyundai Solaris 1', 5),
(24, 'hyundai/solaris/20162370/', 'Hyundai Solaris 1 rest', 5),
(25, 'hyundai/solaris/20922677/', 'Hyundai Solaris 2', 5),
(26, 'hyundai/solaris/21796089/', 'Hyundai Solaris 2 rest', 5),
(27, 'kia/rio/6211420/', 'Kia Rio 2 rest', 6),
(28, 'kia/rio/7694524/', 'Kia Rio 3', 6),
(29, 'cars/kia/rio/20508999/', 'Kia Rio 3 rest', 6),
(30, 'kia/rio/21028015/', 'Kia Rio 4', 6),
(31, 'kia/rio/22500704/', 'Kia Rio 4 rest', 6),
(32, 'skoda/octavia/2309186/', 'Skoda Octavia 1 rest (A4)', 7),
(33, 'skoda/octavia/4560887/', 'Skoda Octavia 2 rest (A5)', 7),
(34, 'skoda/octavia/9338208/', 'Skoda Octavia 3 (A7)', 7),
(35, 'skoda/octavia/20898195/', 'Skoda Octavia 3 rest (A7)', 7),
(36, 'skoda/octavia/21713968/', 'Skoda Octavia 4 (A8)', 7),
(37, 'skoda/rapid/9275797/', 'Skoda Rapid 1', 7),
(38, 'skoda/rapid/21005574/', 'Skoda Rapid 1 rest', 7),
(39, 'skoda/rapid/21738448/', 'Skoda Rapid 2', 7);

INSERT INTO repair_types VALUES
--(id, name)
(1, 'Полировка'),
(2, 'Перекрас элемента'),
(3, 'Ремонт, перекрас'),
(4, 'Замена элемента на новый в цвет'),
(5, 'Замена элемента на новый с покраской'),
(6, 'Удаление вмятин без покраски');

INSERT INTO defects VALUES
--(id, name, repair_type_id)
(1, 'Легкие царапины (на лаке)', 1),
(2, 'Глубокие царапины или скол (до краски - металла)', 2),
(3, 'Рваная дыра', 3),
(4, 'Не сквозная коррозия', 2),
(5, 'Сквозная коррозия', 3),
(6, 'Вмятина без повреджения лкп', 6),
(7, 'Вмятина с повреждением лкп', 3);

INSERT INTO details VALUES
--(id, name)
(1, 'Передний бампер'),
(2, 'Задний бампер'),
(3, 'Переднее левое крыло'),
(4, 'Переднее правое крыло'),
(5, 'Заднее левое крыло'),
(6, 'Заднее правое крыло'),
(7, 'Капот'),
(8, 'Крышка багажника'),
(9, 'Правый порог'),
(10, 'Левый порог'),
(11, 'Крыша'),
(12, 'Передняя левая дверь'),
(13, 'Передняя правая дверь'),
(14, 'Задняя левая дверь'),
(15, 'Задняя правая дверь');

INSERT INTO part_codes VALUES
--(id, vendor_code, detail_id, model_id)
--vaz 2107
(1, '21070280301510', 1, 1),
(2, '21070280401510', 2, 1),
(3, '21058403011', 3, 1),
(4, '21058403010', 4, 1),
(5, '21078404011', 5, 1),
(6, '21078404010', 6, 1),
(7, '21078402012', 7, 1),
(8, '21075604010', 8, 1),
--(9, 'Правый порог', ''),
--(10, 'Левый порог', ''),
(9, '21010570101200', 11, 1),
(10, '21076100015', 12, 1),
(11, '21076100014', 13, 1),
(12, '21056200014', 14, 1),
(13, '21056200015', 15, 1);
--lada vesta
--(1, 'Передний бампер', ''),
--(2, 'Задний бампер', ''),
--(3, 'Переднее левое крыло', ''),
--(4, 'Переднее правое крыло', ''),
--(5, 'Заднее левое крыло', ''),
--(6, 'Заднее правое крыло', ''),
--(7, 'Капот', ''),
--(7, 'Крышка багажника', ''),
--(7, 'Правый порог', ''),
--(7, 'Левый порог', ''),
--(7, 'Крыша', ''),
--(7, 'Передняя левая дверь', ''),
--(7, 'Передняя правая дверь', ''),
--(7, 'Задняя левая дверь', ''),
--(7, 'Задняя правая дверь', ''),
-- renault logan 1 rest
--(7, '', ''),
--(100, '', '');

-- только локальный перекрас (полировка)
INSERT INTO service_xpaths VALUES
--(id, value, service_site_id)
(1, '/html/body/div[1]/div[9]/div/div[7]/div/div[9]/div[2]', 1);

INSERT INTO repair_types_service_xpaths VALUES
--(repair_type_id, service_xpath_id)
(1, 1);

-- полировка каждого элемента
INSERT INTO details_service_xpaths VALUES
--(detail_id, service_xpath_id)
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(11, 1),
(12, 1),
(13, 1),
(14, 1),
(15, 1);

-- цена первого в выдаче результата
INSERT INTO detail_xpaths VALUES
--(id, value, detail_site_id)
(1, '/html/body/div[2]/div[5]/form/table/tbody/tr[3]/td/table/tbody[1]/tr[1]/td/div/div/div[2]/div[1]/div[1]/div/div/div/span[1]', 1);