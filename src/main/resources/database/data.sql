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
--(id, name, brand_id)
(1, 'ВАЗ 2107', 1),
(2, 'ВАЗ 2110', 1),
(3, 'LADA Priora 1', 1),
(4, 'LADA Priora 1 rest', 1),
(5, 'LADA Granta 1', 1),
(6, 'LADA Granta 1 rest', 1),
(7, 'LADA Vesta 1', 1),
(8, 'Ford Focus 2 rest', 2),
(9, 'Ford Focus 3', 2),
(10, 'Ford Focus 3 rest', 2),
(11, 'Renault Logan 1 rest', 3),
(12, 'Renault Logan 2', 3),
(13, 'Renault Logan 2 rest', 3),
(14, 'Renault Sandero 1', 3),
(15, 'Renault Sandero 2', 3),
(16, 'Renault Sandero 2 rest', 3),
(17, 'Renault Duster 1', 3),
(18, 'Renault Duster 1 rest', 3),
(19, 'Renault Duster 2', 3),
(20, 'Volkswagen Polo 5', 4),
(21, 'Volkswagen Polo 5 rest', 4),
(22, 'Volkswagen Polo 6', 4),
(23, 'Hyundai Solaris 1', 5),
(24, 'Hyundai Solaris 1 rest', 5),
(25, 'Hyundai Solaris 2', 5),
(26, 'Hyundai Solaris 2 rest', 5),
(27, 'Kia Rio 2 rest', 6),
(28, 'Kia Rio 3', 6),
(29, 'Kia Rio 3 rest', 6),
(30, 'Kia Rio 4', 6),
(31, 'Kia Rio 4 rest', 6),
(32, 'Skoda Octavia 1 rest (A4)', 7),
(33, 'Skoda Octavia 2 rest (A5)', 7),
(34, 'Skoda Octavia 3 (A7)', 7),
(35, 'Skoda Octavia 3 rest (A7)', 7),
(36, 'Skoda Octavia 4 (A8)', 7),
(37, 'Skoda Rapid 1', 7),
(38, 'Skoda Rapid 1 rest', 7),
(39, 'Skoda Rapid 2', 7);

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