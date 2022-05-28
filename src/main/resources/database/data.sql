INSERT INTO regulations VALUES
--(id, criterion_name, is_need_body_work)
(1, 'Замена шин', false),
(2, 'Замена тормозных трубок', false),
(3, 'Замена тормозных шлангов (передних)', false),
(4, 'Замена тормозных шлангов (задних, при наличии)', false),
(5, 'Замена тормозной жидкости', false),
(6, 'Замена передних тормозных дисковых колодок', false),
(7, 'Замена задних тормозных дисковых колодок (при наличии)', false),
(8, 'Замена передних тормозных дисков', false),
(9, 'Замена задних тормозных дисков (при наличии)', false),
(10, 'Замена задних барабанных колодок (при наличии)', false),
(11, 'Замена задних тормозных барабанов (при наличии)', false),
(12, 'Замена передних тормозных суппортов', false),
(13, 'Замена задних тормозных суппортов (при наличии)', false),
(14, 'Замена главного тормозного цилиндра', false),
(15, 'Замена вакуумного усилителя', false),
(16, 'Замена задних тормозных цилиндров (при наличии)', false),
(17, 'Замена жидкости ГУР (при наличии)', false),
(18, 'Замена насоса ГУР (при наличии)', false),
(19, 'Ремонт насоса ГУР (при наличии)', false),
(20, 'Замена рулевых тяг', false),
(21, 'Замена наконечников рулевых тяг (при наличии)', false),
(22, 'Замена пыльников рулевой рейки', false),
(23, 'Замена рулевой рейки', false),
(24, 'Ремонт рулевой рейки', false),
(25, 'Замена ГРМ', false),
(26, 'Замена приводного ремня ГУР (при наличии)', false),
(27, 'Замена приводного ремня кондиционера (при наличии)', false),
(28, 'Полировка фар головного света', false),
(29, 'Полировки задних фонарей', false),
(30, 'Замена левой фары головного света', false),
(31, 'Замена правой фары головного света', false),
(32, 'Замена левого заднего фонаря', false),
(33, 'Замена правого заднего фонаря', false),
(34, 'Замена передних стоек амортизаторов', false),
(35, 'Замена передних пружин', false),
(36, 'Замена задних стоек амортизаторов', false),
(37, 'Замена задних пружин', false),
(38, 'Замена стабилизатора поперечной устойчивости', false),
(39, 'Замена задней балки (при наличии)', false),
(40, 'Замена передних сайлентблоков', false),
(41, 'Замена задних сайлентблоков', false),
(42, 'Замена передних рычагов подвески', false),
(43, 'Замена задних рычагов подвески (при наличии)', false),
(44, 'Замена аккумулятора', false),
(45, 'Замена стартера', false),
(46, 'Ремонт стартера', false),
(47, 'Капитальный ремонт двигателя', false),
(48, 'Замена клапанной крышки', false),
(49, 'Замена прокладки клапанной крышки', false),
(50, 'Замена сальников распредвалов', false),
(51, 'Замена сальника коленвала', false),
(52, 'Замена масла', false),
(53, 'Замена антифриза', false),
(54, 'Ремонт КПП', false),
(55, 'Замена КПП', false),
(56, 'Замена переднего левого привода', false),
(57, 'Замена переднего правого привода', false),
(58, 'Замена пыльников переднего левого шруса', false),
(59, 'Замена пыльников переднего правого шруса', false),
(60, 'Повреждения переднего бампера', true),
(61, 'Повреждения заднего бампера', true),
(62, 'Повреждения переднего левого крыла', true),
(63, 'Повреждения переднего правого крыла', true),
(64, 'Повреждения заднего левого крыла', true),
(65, 'Повреждения заднего правого крыла', true),
(66, 'Повреждения капота', true),
(67, 'Повреждения крышки багажника', true),
(68, 'Повреждения правого порога', true),
(69, 'Повреждения левого порога', true),
(70, 'Повреждения крыши', true),
(71, 'Повреждения передней левой двери', true),
(72, 'Повреждения передней правой двери', true),
(73, 'Повреждения задней левой двери', true),
(74, 'Повреждения задней правой двери', true),
(75, 'Повреждения дна автомобиля', true),
(76, 'Замена лобового стекла', false),
(77, 'Замена заднего стекла', false),
(78, 'Замена переднего правого стекла', false),
(79, 'Замена переднего левого стекла', false),
(80, 'Замена заднего правого стекла', false),
(81, 'Замена заднего левого стекла', false);

INSERT INTO service_prices VALUES
--(id, price, regulations_id)
(1, 1500, 1),
(2, 1000, 2),
(3, 700, 3),
(4, 700, 4),
(5, 400, 5),
(6, 600, 6),
(7, 600, 7),
(8, 2000, 8),
(9, 2000, 9),
(10, 2000, 10),
(11, 600, 11),
(12, 2000, 12),
(13, 2000, 13),
(14, 1000, 14),
(15, 1000, 15),
(16, 1000, 16),
(17, 800, 17),
(18, 1800, 18),
(19, 2700, 19),
(20, 400, 20),
(21, 400, 21),
(22, 500, 22),
(23, 2000, 23),
(24, 7000, 24),
(25, 3000, 25),
(26, 1000, 26),
(27, 1000, 27),
(28, 600, 28),
(29, 600, 29),
(30, 500, 30),
(31, 500, 31),
(32, 500, 32),
(33, 500, 33),
(34, 4000, 34),
(35, 1500, 35),
(36, 1500, 36),
(37, 1000, 37),
(38, 2000, 38),
(39, 4000, 39),
(40, 400, 40),
(41, 1000, 41),
(42, 800, 42),
(43, 800, 43),
(44, 200, 44),
(45, 1000, 45),
(46, 1500, 46),
(47, 20000, 47),
(48, 600, 48),
(49, 600, 49),
(50, 500, 50),
(51, 1000, 51),
(52, 500, 52),
(53, 250, 53),
(54, 10000, 54),
(55, 6000, 55),
(56, 1000, 56),
(57, 1000, 57),
(58, 400, 58),
(59, 400, 59),
(60, 400, 60),
(61, 4000, 76),
(62, 4000, 77),
(63, 1500, 78),
(64, 1500, 79),
(65, 1500, 80),
(66, 1500, 81);

INSERT INTO body_works VALUES
--(id, name ,price)
(1, 'Полировка', 600),
(2, 'Локальная покраска', 1500),
(3, 'Полная покраска', 3000),
(4, 'Удаление вмятин с покраской', 2500),
(5, 'Удаление вмятин без покраски', 1000),
(6, 'Сварочные работы с покраской', 3500),
(7, 'Замена элемента', 1000),
(8, 'Локальный ремонт бампера', 1500);

INSERT INTO regulations_body_works VALUES
--(regulations_id, body_work_id)
(60, 1),
(60, 2),
(60, 3),
(60, 4),
(60, 5),
(60, 7),
(60, 8),
(61, 1),
(61, 2),
(61, 3),
(61, 4),
(61, 5),
(61, 7),
(61, 8),
(62, 1),
(62, 2),
(62, 3),
(62, 4),
(62, 5),
(62, 6),
(62, 7),
(63, 1),
(63, 2),
(63, 3),
(63, 4),
(63, 5),
(63, 6),
(63, 7),
(64, 1),
(64, 2),
(64, 3),
(64, 4),
(64, 5),
(64, 6),
(64, 7),
(65, 1),
(65, 2),
(65, 3),
(65, 4),
(65, 5),
(65, 6),
(65, 7),
(66, 1),
(66, 2),
(66, 3),
(66, 4),
(66, 5),
(66, 6),
(66, 7),
(67, 1),
(67, 2),
(67, 3),
(67, 4),
(67, 5),
(67, 6),
(67, 7),
(68, 1),
(68, 2),
(68, 3),
(68, 4),
(68, 5),
(68, 6),
(68, 7),
(69, 1),
(69, 2),
(69, 3),
(69, 4),
(69, 5),
(69, 6),
(69, 7),
(70, 1),
(70, 2),
(70, 3),
(70, 4),
(70, 5),
(70, 6),
(70, 7),
(71, 1),
(71, 2),
(71, 3),
(71, 4),
(71, 5),
(71, 6),
(71, 7),
(72, 1),
(72, 2),
(72, 3),
(72, 4),
(72, 5),
(72, 6),
(72, 7),
(73, 1),
(73, 2),
(73, 3),
(73, 4),
(73, 5),
(73, 6),
(73, 7),
(74, 1),
(74, 2),
(74, 3),
(74, 4),
(74, 5),
(74, 6),
(74, 7),
(75, 2),
(75, 3),
(75, 4),
(75, 5),
(75, 6),
(75, 7);

-- todo заменять "vendor_code" на артикул в коде потом
INSERT INTO supplier_sites VALUES
--(id, url)
(1, 'https://baza.drom.ru/sell_spare_parts/?query=vendor_code&sortBy=pricea');

-- цена первого в выдаче результата
INSERT INTO supplier_xpaths VALUES
--(id, value, supplier_site_id)
(1, '/html/body/div[2]/div[5]/form/table/tbody/tr[3]/td/table/tbody[1]/tr[1]/td/div/div/div[2]/div[1]/div[1]/div/div/div/span[1]', 1);

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