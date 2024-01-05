-- Parents and Students DML Test Data generation
-- note run this script only ones!
-- ------------------------------------------------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------------------------------------------------
-- Inserting data into the Addresses table with 'Plovdiv' as the city name, postal code 4000, and including ID
INSERT INTO Addresses (id, city_name, postal_code, street_name, street_number) VALUES 
(1, 'Plovdiv', 4000, 'Tsanko Lavrenov Str', 1),
(2, 'Plovdiv', 4000, 'Dimcho Debelyanov Str', 2),
(3, 'Plovdiv', 4000, 'Krakra Str', 3),
(4, 'Plovdiv', 4000, 'Vasil Levski Str', 4),
(5, 'Plovdiv', 4000, 'Kapitan Petko Voivoda Str', 5),
(6, 'Plovdiv', 4000, 'Vazrajdane Str', 6),
(7, 'Plovdiv', 4000, 'Kuklensko Shosse Blvd', 7),
(8, 'Plovdiv', 4000, 'Vladimir Mayakovski Str', 8),
(9, 'Plovdiv', 4000, 'Paisii Hilendarski Blvd', 9),
(10, 'Plovdiv', 4000, 'Nikolay Gyaurov Str', 10),
(11, 'Plovdiv', 4000, 'Bacho Kiro Str', 11),
(12, 'Plovdiv', 4000, 'Peyo Yavorov Str', 12),
(13, 'Plovdiv', 4000, 'Bulgaria Blvd', 13),
(14, 'Plovdiv', 4000, 'Vasil Aprilov Blvd', 14),
(15, 'Plovdiv', 4000, 'Tsar Boris III Obedinitel Blvd', 15),
(16, 'Plovdiv', 4000, 'Ruski Blvd', 16),
(17, 'Plovdiv', 4000, 'Hristo Botev Blvd', 17),
(18, 'Plovdiv', 4000, 'Gen. Skobelev Blvd', 18),
(19, 'Plovdiv', 4000, 'Brezovska Str', 19),
(20, 'Plovdiv', 4000, 'Knyaz Alexander I Str', 20),
(21, 'Plovdiv', 4000, 'Bachkovo Str', 21),
(22, 'Plovdiv', 4000, 'Yanko Sakazov Str', 22),
(23, 'Plovdiv', 4000, 'Vazrazhdane Str', 23),
(24, 'Plovdiv', 4000, 'Otets Paisiy Str', 24),
(25, 'Plovdiv', 4000, 'Gladstone Str', 25),
(26, 'Plovdiv', 4000, 'Pere Toshev Str', 26),
(27, 'Plovdiv', 4000, 'Hristo G. Danov Str', 27),
(28, 'Plovdiv', 4000, 'Rayko Daskalov Str', 28),
(29, 'Plovdiv', 4000, 'Georgi S. Rakovski Str', 29),
(30, 'Plovdiv', 4000, 'Kapitan Raycho Str', 30),
(31, 'Plovdiv', 4000, 'Todor Diev Str', 31),
(32, 'Plovdiv', 4000, 'Gotse Delchev Str', 32),
(33, 'Plovdiv', 4000, 'Neofit Rilski Str', 33),
(34, 'Plovdiv', 4000, 'Ivan Vazov Str', 34),
(35, 'Plovdiv', 4000, 'Aleko Konstantinov Str', 35),
(36, 'Plovdiv', 4000, 'Stoyan Mihaylovski Str', 36),
(37, 'Plovdiv', 4000, 'Aleksandar Stamboliyski Str', 37),
(38, 'Plovdiv', 4000, 'Petko Todorov Str', 38),
(39, 'Plovdiv', 4000, 'Slivnitsa Blvd', 39),
(40, 'Plovdiv', 4000, 'Botevgrad Blvd', 40);

-- Inserting more data into the Addresses table with 'Plovdiv' as the city name, postal code 4000, and unique data
INSERT INTO Addresses (id, city_name, postal_code, street_name, street_number) VALUES 
(41, 'Plovdiv', 4000, 'Hristo Smirnenski Blvd', 41),
(42, 'Plovdiv', 4000, 'Ivan Vazov Blvd', 42),
(43, 'Plovdiv', 4000, 'Lyuben Karavelov Str', 43),
(44, 'Plovdiv', 4000, 'Nikola Furnadzhiev Str', 44),
(45, 'Plovdiv', 4000, 'Pencho Slaveykov Str', 45),
(46, 'Plovdiv', 4000, 'Kiril i Metodii Str', 46),
(47, 'Plovdiv', 4000, 'Slavianska Str', 47),
(48, 'Plovdiv', 4000, 'Han Kubrat Str', 48),
(49, 'Plovdiv', 4000, 'Pavel Banya Str', 49),
(50, 'Plovdiv', 4000, 'Zhelezarska Str', 50);


-- ------------------------------------------------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------------------------------------------------



-- Parents and Students DML Test Data generation
-- note run this script only ones!
-- ------------------------------------------------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------------------------------------------------
-- Inserting test data for parents with the same address for lookup
INSERT INTO Parents (parent_id, email, user_password, date_of_birth, phone, first_name, last_name, egn, age, gender, date_of_join, address_id, current_status)
SELECT
    ROW_NUMBER() OVER () AS parent_id,
    CONCAT('parent_email_', t.n),
    CONCAT('parent_pass_', t.n),
    '1980-01-01',
    CONCAT('1234', LPAD(t.n, 6, '0')),
    CONCAT('ParentFName', t.n),
    CONCAT('ParentLName', t.n),
    LPAD(t.n, 10, '0'),
    30 + MOD(t.n, 20),
    IF(MOD(t.n, 2) = 0, 'F', 'M'),
    '2023-01-01',
    t.n % 50 + 1,
    'active'
FROM (
    SELECT @row := @row + 1 AS n
    FROM (
        SELECT 0 AS num UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4
    ) AS num1
    CROSS JOIN (
        SELECT 0 AS num UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4
    ) AS num2
    CROSS JOIN (
        SELECT @row := 0
    ) AS init
) AS t;





-- Inserting test data for students with the same address for lookup linked to parents
INSERT INTO Students (email, user_password, date_of_birth, phone, first_name, last_name, egn, age, gender, parent_id, date_of_join, address_id, current_status)
SELECT
    CONCAT('student_email_', t.n),
    CONCAT('student_pass_', t.n),
    '2005-01-01',
    CONCAT('1234', LPAD(t.n, 6, '0')),
    CONCAT('StudentFName', t.n),
    CONCAT('StudentLName', t.n),
    LPAD(t.n, 10, '0'),
    10 + MOD(t.n, 15),
    IF(MOD(t.n, 2) = 0, 'F', 'M'),
    t.n,
    '2023-01-15',
    p.address_id,
    'active'
FROM (
    SELECT @row := @row + 1 AS n
    FROM (
        SELECT 0 AS num UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4
    ) AS num1
    CROSS JOIN (
        SELECT 0 AS num UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4
    ) AS num2
    CROSS JOIN (
        SELECT @row := 0
    ) AS init
) AS t
JOIN Parents p ON t.n = p.parent_id;


UPDATE Parents
SET 
  email = CASE 
    WHEN parent_id = 1 THEN  "Kurt_Glynn56441@gmail.com"
	WHEN parent_id = 2 THEN  "Chris_Grey59622@dir.bg"
	WHEN parent_id = 3 THEN  "Daniel_Collins23473@abv.bg"
	WHEN parent_id = 4 THEN  "Paige_Thatcher64734@gmail.com"
	WHEN parent_id = 5 THEN  "Gladys_Brown95235@dir.bg"
	WHEN parent_id = 6 THEN  "Savannah_Glynn64866@abv.bg"
	WHEN parent_id = 7 THEN  "Rufus_Vass83127@gmail.com"
	WHEN parent_id = 8 THEN  "Tony_Edwards2778@dir.bg"
	WHEN parent_id = 9 THEN  "Shannon_Dixon79479@abv.bg"
	WHEN parent_id = 10 THEN "Matt_Doherty272610@gmail.com"
	WHEN parent_id = 11 THEN "Shay_Pitt296411@dir.bg"
	WHEN parent_id = 12 THEN "Beatrice_Truscott355212@abv.bg"
	WHEN parent_id = 13 THEN "Nathan_Connell390013@gmail.com"
	WHEN parent_id = 14 THEN "Hayden_Yarwood473714@dir.bg"
	WHEN parent_id = 15 THEN "Brad_Hobbs164615@abv.bg"
	WHEN parent_id = 16 THEN "Stephanie_Booth678216@gmail.com"
	WHEN parent_id = 17 THEN "Caleb_Higgs487817@dir.bg"
	WHEN parent_id = 18 THEN "Marjorie_Holt837518@abv.bg"
	WHEN parent_id = 19 THEN "Percy_Harrison106719@gmail.com"
	WHEN parent_id = 20 THEN "Ron_Uttley425920@dir.bg"
	WHEN parent_id = 21 THEN "Brad_Myatt419021@abv.bg"
	WHEN parent_id = 22 THEN "Greta_Connor755622@gmail.com"
	WHEN parent_id = 23 THEN "Denis_Vinton670723@dir.bg"
	WHEN parent_id = 24 THEN "Ema_Forth149924@abv.bg"
    
  END,
  first_name = CASE 
    WHEN parent_id = 1 THEN  "Kurt"     
    WHEN parent_id = 2 THEN  "Chris"    
    WHEN parent_id = 3 THEN  "Daniel"   
    WHEN parent_id = 4 THEN  "Paige"    
    WHEN parent_id = 5 THEN  "Gladys"   
    WHEN parent_id = 6 THEN  "Savannah" 
    WHEN parent_id = 7 THEN  "Rufus"    
    WHEN parent_id = 8 THEN  "Tony"     
    WHEN parent_id = 9 THEN  "Shannon"  
    WHEN parent_id = 10 THEN "Matt"     
    WHEN parent_id = 11 THEN "Shay"     
    WHEN parent_id = 12 THEN "Beatrice" 
    WHEN parent_id = 13 THEN "Nathan"   
    WHEN parent_id = 14 THEN "Hayden"   
    WHEN parent_id = 15 THEN "Brad"     
    WHEN parent_id = 16 THEN "Stephanie"
    WHEN parent_id = 17 THEN "Caleb"    
    WHEN parent_id = 18 THEN "Marjorie" 
    WHEN parent_id = 19 THEN "Percy"    
    WHEN parent_id = 20 THEN "Ron"      
    WHEN parent_id = 21 THEN "Brad"     
    WHEN parent_id = 22 THEN "Greta"    
    WHEN parent_id = 23 THEN "Denis"    
    WHEN parent_id = 24 THEN "Ema"      
    
  END,
  last_name = CASE 
    WHEN parent_id = 1 THEN   "Glynn"
	WHEN parent_id = 2 THEN   "Grey"
	WHEN parent_id = 3 THEN   "Collins"
	WHEN parent_id = 4 THEN   "Thatcher"
	WHEN parent_id = 5 THEN   "Brown"
	WHEN parent_id = 6 THEN   "Glynn"
	WHEN parent_id = 7 THEN   "Vass"
	WHEN parent_id = 8 THEN   "Edwards"
	WHEN parent_id = 9 THEN   "Dixon"
	WHEN parent_id = 10 THEN  "Doherty"
	WHEN parent_id = 11 THEN  "Pitt"
	WHEN parent_id = 12 THEN  "Truscott"
	WHEN parent_id = 13 THEN  "Connell"
	WHEN parent_id = 14 THEN  "Yarwood"
	WHEN parent_id = 15 THEN  "Hobbs"
	WHEN parent_id = 16 THEN  "Booth"
	WHEN parent_id = 17 THEN  "Higgs"
	WHEN parent_id = 18 THEN  "Holt"
	WHEN parent_id = 19 THEN  "Harrison"
	WHEN parent_id = 20 THEN  "Uttley"
	WHEN parent_id = 21 THEN  "Myatt"
	WHEN parent_id = 22 THEN  "Connor"
	WHEN parent_id = 23 THEN  "Vinton"
	WHEN parent_id = 24 THEN  "Forth"
    
  END,
  phone = CASE 
    WHEN parent_id = 1 THEN 	"+35924123456"
	WHEN parent_id = 2 THEN 	"+35924123457"
	WHEN parent_id = 3 THEN 	"+35924123458"
	WHEN parent_id = 4 THEN 	"+35924123459"
	WHEN parent_id = 5 THEN 	"+35924123460"
	WHEN parent_id = 6 THEN 	"+35924123461"
	WHEN parent_id = 7 THEN 	"+35924123462"
	WHEN parent_id = 8 THEN 	"+35924123463"
	WHEN parent_id = 9 THEN 	"+35924123464"
	WHEN parent_id = 10 THEN	"+35924123465"
	WHEN parent_id = 11 THEN	"+35924123466"
	WHEN parent_id = 12 THEN	"+35924123467"
	WHEN parent_id = 13 THEN	"+35924123468"
	WHEN parent_id = 14 THEN	"+35924123469"
	WHEN parent_id = 15 THEN	"+35924123470"
	WHEN parent_id = 16 THEN	"+35924123471"
	WHEN parent_id = 17 THEN	"+35924123472"
	WHEN parent_id = 18 THEN	"+35924123473"
	WHEN parent_id = 19 THEN	"+35924123474"
	WHEN parent_id = 20 THEN	"+35924123475"
	WHEN parent_id = 21 THEN	"+35924123476"
	WHEN parent_id = 22 THEN	"+35924123477"
	WHEN parent_id = 23 THEN	"+35924123478"
	WHEN parent_id = 24 THEN	"+35924123479"
    
  END,
  egn = CASE 
    WHEN parent_id = 1 THEN 	"8001011234"
	WHEN parent_id = 2 THEN 	"8001012345"
	WHEN parent_id = 3 THEN 	"8001013456"
	WHEN parent_id = 4 THEN 	"8001014567"
	WHEN parent_id = 5 THEN 	"8001015678"
	WHEN parent_id = 6 THEN 	"8001016789"
	WHEN parent_id = 7 THEN 	"8001017890"
	WHEN parent_id = 8 THEN 	"8001018901"
	WHEN parent_id = 9 THEN 	"8001019012"
	WHEN parent_id = 10 THEN	"8001010123"
	WHEN parent_id = 11 THEN	"8001011235"
	WHEN parent_id = 12 THEN	"8001012346"
	WHEN parent_id = 13 THEN	"8001013457"
	WHEN parent_id = 14 THEN	"8001014568"
	WHEN parent_id = 15 THEN	"8001015679"
	WHEN parent_id = 16 THEN	"8001016780"
	WHEN parent_id = 17 THEN	"8001017891"
	WHEN parent_id = 18 THEN	"8001018902"
	WHEN parent_id = 19 THEN	"8001019013"
	WHEN parent_id = 20 THEN	"8001010124"
	WHEN parent_id = 21 THEN	"8001011236"
	WHEN parent_id = 22 THEN	"8001012347"
	WHEN parent_id = 23 THEN	"8001013458"
	WHEN parent_id = 24 THEN	"8001014569"

  END,
  user_password = CASE 
    WHEN parent_id = 1 THEN 	"Passw0rd!56441"
	WHEN parent_id = 2 THEN 	"SecurePwd59622@"
	WHEN parent_id = 3 THEN 	"Rand0mPwd23473#"
	WHEN parent_id = 4 THEN 	"Str0ngPwd64734$"
	WHEN parent_id = 5 THEN 	"P@ssw0rd95235"
	WHEN parent_id = 6 THEN 	"SecretPwd64866%"
	WHEN parent_id = 7 THEN 	"Password!83127"
	WHEN parent_id = 8 THEN 	"NewPwd2778@!"
	WHEN parent_id = 9 THEN 	"TestPassword79479#"
	WHEN parent_id = 10 THEN	"R@ndomPwd272610"
	WHEN parent_id = 11 THEN	"Pwd@Pitt296411"
	WHEN parent_id = 12 THEN	"Pwd355212@!"
	WHEN parent_id = 13 THEN	"Connell390013$"
	WHEN parent_id = 14 THEN	"HaydenPwd473714"
	WHEN parent_id = 15 THEN	"HobbsPwd164615"
	WHEN parent_id = 16 THEN	"BoothPwd678216"
	WHEN parent_id = 17 THEN	"Higgs487817Pwd!"
	WHEN parent_id = 18 THEN	"HoltPwd837518"
	WHEN parent_id = 19 THEN	"Percy106719Pwd@"
	WHEN parent_id = 20 THEN	"UttleyPwd425920"
	WHEN parent_id = 21 THEN	"MyattPwd419021"
	WHEN parent_id = 22 THEN	"GretaPwd755622%"
	WHEN parent_id = 23 THEN	"VintonPwd670723"
	WHEN parent_id = 24 THEN	"EmaPwd149924@"
  END,
  user_name = CASE 
	WHEN parent_id = 1 THEN 'Kurt_Glynn56441'
	WHEN parent_id = 2 THEN 'Chris_Grey59622'
	WHEN parent_id = 3 THEN 'Daniel_Collins23473'
	WHEN parent_id = 4 THEN 'Paige_Thatcher64734'
	WHEN parent_id = 5 THEN 'Gladys_Brown95235'
	WHEN parent_id = 6 THEN 'Savannah_Glynn64866'
	WHEN parent_id = 7 THEN 'Rufus_Vass83127'
	WHEN parent_id = 8 THEN 'Tony_Edwards2778'
	WHEN parent_id = 9 THEN 'Shannon_Dixon79479'
	WHEN parent_id = 10 THEN 'Matt_Doherty272610'
	WHEN parent_id = 11 THEN 'Shay_Pitt296411'
	WHEN parent_id = 12 THEN 'Beatrice_Truscott355212'
	WHEN parent_id = 13 THEN 'Nathan_Connell390013'
	WHEN parent_id = 14 THEN 'Hayden_Yarwood473714'
	WHEN parent_id = 15 THEN 'Brad_Hobbs164615'
	WHEN parent_id = 16 THEN 'Stephanie_Booth678216'
	WHEN parent_id = 17 THEN 'Caleb_Higgs487817'
	WHEN parent_id = 18 THEN 'Marjorie_Holt837518'
	WHEN parent_id = 19 THEN 'Percy_Harrison106719'
	WHEN parent_id = 20 THEN 'Ron_Uttley425920'
	WHEN parent_id = 21 THEN 'Brad_Myatt419021'
	WHEN parent_id = 22 THEN 'Greta_Connor755622'
	WHEN parent_id = 23 THEN 'Denis_Vinton670723'
	WHEN parent_id = 24 THEN 'Ema_Forth149924'
    END
WHERE parent_id BETWEEN 1 AND 25;


-- ------------------------------------------------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------------------------------------------------

-- Students Updates
-- ------------------------------------------------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------------------------------------------------
UPDATE Students
SET 
  email = CASE 
  
    WHEN student_id = 26 THEN "Aidan_Glynn56441@gmail.com"
	WHEN student_id = 27 THEN "Owen_Grey59622@dir.bg"
	WHEN student_id = 29 THEN "Ethan_Collins23473@abv.bg"
	WHEN student_id = 30 THEN "Lily_Thatcher64734@gmail.com"
	WHEN student_id = 31 THEN "Nora_Brown95235@dir.bg"
	WHEN student_id = 32 THEN "Isabella_Glynn64866@abv.bg"
	WHEN student_id = 33 THEN "Felix_Vass83127@gmail.com"
	WHEN student_id = 34 THEN "Liam_Edwards2778@dir.bg"
	WHEN student_id = 35 THEN "Harper_Dixon79479@abv.bg"
	WHEN student_id = 36 THEN "Caleb_Doherty272610@gmail.com"
	WHEN student_id = 37 THEN "Sophia_Pitt296411@dir.bg"
	WHEN student_id = 38 THEN "Charlotte_Truscott355212@abv.bg"
	WHEN student_id = 39 THEN "Isaac_Connell390013@gmail.com"
	WHEN student_id = 40 THEN "Mason_Yarwood473714@dir.bg"
	WHEN student_id = 41 THEN "Lucas_Hobbs164615@abv.bg"
	WHEN student_id = 42 THEN "Emily_Booth678216@gmail.com"
	WHEN student_id = 43 THEN "Henry_Higgs487817@dir.bg"
	WHEN student_id = 44 THEN "Violet_Holt837518@abv.bg"
	WHEN student_id = 45 THEN "Oscar_Harrison106719@gmail.com"
	WHEN student_id = 46 THEN "Levi_Uttley425920@dir.bg"
	WHEN student_id = 47 THEN "Samuel_Myatt419021@abv.bg"
	WHEN student_id = 48 THEN "Eva_Connor755622@gmail.com"
	WHEN student_id = 49 THEN "Adrian_Vinton670723@dir.bg"
	WHEN student_id = 50 THEN "Ava_Forth149924@abv.bg"
    
  END,
  first_name = CASE 
    WHEN student_id = 26	THEN "Aidan"
	WHEN student_id = 27	THEN "Owen"
	WHEN student_id = 29	THEN "Ethan"
	WHEN student_id = 30	THEN "Lily"
	WHEN student_id = 31	THEN "Nora"
	WHEN student_id = 32	THEN "Isabella"
	WHEN student_id = 33	THEN "Felix"
	WHEN student_id = 34	THEN "Liam"
	WHEN student_id = 35	THEN "Harper"
	WHEN student_id = 36 	THEN "Caleb"
	WHEN student_id = 37 	THEN "Sophia"
	WHEN student_id = 38 	THEN "Charlotte"
	WHEN student_id = 39 	THEN "Isaac"
	WHEN student_id = 40 	THEN "Mason"
	WHEN student_id = 41 	THEN "Lucas"
	WHEN student_id = 42 	THEN "Emily"
	WHEN student_id = 43 	THEN "Henry"
	WHEN student_id = 44 	THEN "Violet"
	WHEN student_id = 45 	THEN "Oscar"
	WHEN student_id = 46 	THEN "Levi"
	WHEN student_id = 47 	THEN "Samuel"
	WHEN student_id = 48 	THEN "Eva"
	WHEN student_id = 49 	THEN "Adrian"
	WHEN student_id = 50 	THEN "Ava"

  END,
  last_name = CASE 
    WHEN student_id = 26	THEN "Glynn"
	WHEN student_id = 27	THEN "Grey"
	WHEN student_id = 29	THEN "Collins"
	WHEN student_id = 30	THEN "Thatcher"
	WHEN student_id = 31	THEN "Brown"
	WHEN student_id = 32	THEN "Glynn"
	WHEN student_id = 33	THEN "Vass"
	WHEN student_id = 34	THEN "Edwards"
	WHEN student_id = 35	THEN "Dixon"
	WHEN student_id = 36 	THEN "Doherty"
	WHEN student_id = 37 	THEN "Pitt"
	WHEN student_id = 38 	THEN "Truscott" 
	WHEN student_id = 39 	THEN "Connell"
	WHEN student_id = 40 	THEN "Yarwood"
	WHEN student_id = 41 	THEN "Hobbs"
	WHEN student_id = 42 	THEN "Booth"
	WHEN student_id = 43 	THEN "Higgs"
	WHEN student_id = 44 	THEN "Holt"
	WHEN student_id = 45 	THEN "Harrison"
	WHEN student_id = 46 	THEN "Uttley"
	WHEN student_id = 47 	THEN "Myatt"
	WHEN student_id = 48 	THEN "Connor"
	WHEN student_id = 49 	THEN "Vinton"
	WHEN student_id = 50 	THEN "Forth"
    
  END,
  phone = CASE 
    WHEN student_id = 26	THEN "+359897123456"
	WHEN student_id = 27	THEN "+359888234567"
	WHEN student_id = 29	THEN "+359879345678"
	WHEN student_id = 30	THEN "+359898456789"
	WHEN student_id = 31	THEN "+359889567890"
	WHEN student_id = 32	THEN "+359877678901"
	WHEN student_id = 33	THEN "+359896789012"
	WHEN student_id = 34	THEN "+359887890123"
	WHEN student_id = 35	THEN "+359877901234"
	WHEN student_id = 36 	THEN "+359899012345"
	WHEN student_id = 37 	THEN "+359880123456"
	WHEN student_id = 38 	THEN "+359871234567"
	WHEN student_id = 39 	THEN "+359892345678"
	WHEN student_id = 40 	THEN "+359883456789"
	WHEN student_id = 41 	THEN "+359874567890"
	WHEN student_id = 42 	THEN "+359895678901"
	WHEN student_id = 43 	THEN "+359886789012"
	WHEN student_id = 44 	THEN "+359877890123"
	WHEN student_id = 45 	THEN "+359898901234"
	WHEN student_id = 46 	THEN "+359880012345"
	WHEN student_id = 47 	THEN "+359870123456"
	WHEN student_id = 48 	THEN "+359891234567"
	WHEN student_id = 49 	THEN "+359882345678"
	WHEN student_id = 50 	THEN "+359873456789"
    
  END,
  egn = CASE 
    WHEN student_id = 26	THEN "0501011234"
	WHEN student_id = 27	THEN "0501012345"
	WHEN student_id = 29	THEN "0501013456"
	WHEN student_id = 30	THEN "0501014567"
	WHEN student_id = 31	THEN "0501015678"
	WHEN student_id = 32	THEN "0501016789"
	WHEN student_id = 33	THEN "0501017890"
	WHEN student_id = 34	THEN "0501018901"
	WHEN student_id = 35	THEN "0501019012"
	WHEN student_id = 36 	THEN "0501010123"
	WHEN student_id = 37 	THEN "0501011235"
	WHEN student_id = 38 	THEN "0501012346"
	WHEN student_id = 39 	THEN "0501013457"
	WHEN student_id = 40 	THEN "0501014568"
	WHEN student_id = 41 	THEN "0501015679"
	WHEN student_id = 42 	THEN "0501016780"
	WHEN student_id = 43 	THEN "0501017891"
	WHEN student_id = 44 	THEN "0501018902"
	WHEN student_id = 45 	THEN "0501019013"
	WHEN student_id = 46 	THEN "0501010124"
	WHEN student_id = 47 	THEN "0501011236"
	WHEN student_id = 48 	THEN "0501012347"
	WHEN student_id = 49 	THEN "0501013458"
	WHEN student_id = 50 	THEN "0501014569"

  END,
  user_password = CASE 
    WHEN student_id = 26	THEN "Glynn56441"
	WHEN student_id = 27	THEN "Grey59622"
	WHEN student_id = 29	THEN "Collins23473"
	WHEN student_id = 30	THEN "Thatcher64734"
	WHEN student_id = 31	THEN "Brown95235"
	WHEN student_id = 32	THEN "Glynn64866"
	WHEN student_id = 33	THEN "Vass83127"
	WHEN student_id = 34	THEN "Edwards2778"
	WHEN student_id = 35	THEN "Dixon79479"
	WHEN student_id = 36 	THEN "Doherty272610"
	WHEN student_id = 37 	THEN "Pitt296411"
	WHEN student_id = 38 	THEN "Truscott355212"
	WHEN student_id = 39 	THEN "Connell390013"
	WHEN student_id = 40 	THEN "Yarwood473714"
	WHEN student_id = 41 	THEN "Hobbs164615"
	WHEN student_id = 42 	THEN "Booth678216"
	WHEN student_id = 43 	THEN "Higgs487817"
	WHEN student_id = 44 	THEN "Holt837518"
	WHEN student_id = 45 	THEN "Harrison106719"
	WHEN student_id = 46 	THEN "Uttley425920"
	WHEN student_id = 47 	THEN "Myatt419021"
	WHEN student_id = 48 	THEN "Connor755622"
	WHEN student_id = 49 	THEN "Vinton670723"
	WHEN student_id = 50 	THEN "Forth149924"
  END,
  user_name =CASE 
        WHEN student_id = 26	THEN 'Aidan_Glynn56441'
        WHEN student_id = 27	THEN 'Owen_Grey59622'
        WHEN student_id = 29	THEN 'Ethan_Collins23473'
        WHEN student_id = 30	THEN 'Lily_Thatcher64734'
        WHEN student_id = 31	THEN 'Nora_Brown95235'
        WHEN student_id = 32	THEN 'Isabella_Glynn64866'
        WHEN student_id = 33	THEN 'Felix_Vass83127'
        WHEN student_id = 34	THEN 'Liam_Edwards2778'
        WHEN student_id = 35	THEN 'Harper_Dixon79479'
        WHEN student_id = 36 	THEN 'Caleb_Doherty272610'
        WHEN student_id = 37 	THEN 'Sophia_Pitt296411'
        WHEN student_id = 38 	THEN 'Charlotte_Truscott355212'
        WHEN student_id = 39 	THEN 'Isaac_Connell390013'
        WHEN student_id = 40 	THEN 'Mason_Yarwood473714'
        WHEN student_id = 41 	THEN 'Lucas_Hobbs164615'
        WHEN student_id = 42 	THEN 'Emily_Booth678216'
        WHEN student_id = 43 	THEN 'Henry_Higgs487817'
        WHEN student_id = 44 	THEN 'Violet_Holt837518'
        WHEN student_id = 45 	THEN 'Oscar_Harrison106719'
        WHEN student_id = 46 	THEN 'Levi_Uttley425920'
        WHEN student_id = 47 	THEN 'Samuel_Myatt419021'
        WHEN student_id = 48 	THEN 'Eva_Connor755622'
        WHEN student_id = 49 	THEN 'Adrian_Vinton670723'
        WHEN student_id = 50 	THEN 'Ava_Forth149924'
    END
WHERE student_id BETWEEN 26 AND 50;


-- test the script
-- select p.first_name, p.last_name, s.first_name as "studentname", s.last_name as "studentlastname"
-- from parents as p
-- join students as s on s.parent_id = p.parent_id;
-- ------------------------------------------------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------------------------------------------------
select * from students;

-- Attendences test data
-- ------------------------------------------------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO Attendences (attendence_id,attendence_date, student_id, attendence_status, remarks) VALUES 
(1,'2023-01-01', 26, 'attendent', 'Regular attendance'),
(2,'2023-01-01', 27, 'attendent', 'Present in class'),
(3,'2023-01-01', 28, 'non_attendent', 'Absent today'),
(4,'2023-01-02', 29, 'attendent', 'Participated actively'),
(5,'2023-01-02', 30, 'non_attendent', 'Missed class'),
(6,'2023-01-02', 31, 'attendent', 'Arrived late but attended'),
(7,'2023-01-03', 32, 'non_attendent', 'Was sick'),
(8,'2023-01-03', 34, 'attendent', 'Made up for missed class'),
(9,'2023-01-03', 35, 'attendent', 'Joined class halfway through');

INSERT INTO Attendences (attendence_id, attendence_date, student_id, attendence_status, remarks) VALUES 
(10,'2023-01-04', 36, 'attendent', 'Completed assignments'),
(11,'2023-01-04', 37, 'non_attendent', 'Family emergency'),
(12,'2023-01-04', 38, 'attendent', 'Active participation in discussion'),
(13,'2023-01-05', 39, 'non_attendent', 'Attending doctor\'s appointment'),
(14,'2023-01-05', 40, 'attendent', 'Attended extra session'),
(16,'2023-01-05', 41, 'attendent', 'Excellent engagement in class'),
(17,'2023-01-06', 42, 'attendent', 'Contributed to group project'),
(18,'2023-01-06', 43, 'attendent', 'Attended study group'),
(19,'2023-01-06', 44, 'non_attendent', 'Out sick'),
(20,'2023-01-07', 45, 'attendent', 'Active participation in practical exercises'),
(21,'2023-01-07', 46, 'non_attendent', 'Personal reasons'),
(22,'2023-01-07', 47, 'attendent', 'Came in late but attended the entire session');
-- ------------------------------------------------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------------------------------------------------



-- TEACHER INSERT DATA 
-- ------------------------------------------------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO Teachers (teacher_id,user_name, email, user_password, date_of_birth, phone, first_name, last_name, egn, age, gender, date_of_join, address_id, current_status) VALUES 
(1,"johny2100","Johny_Shmith@gmail.com", 	   "JohnyShmith123", "1985-03-12", 		"+359888123456", "Johny",    "Shmith",    "8503127890", 36, "M", "2020-09-15", 1, "on_work"),
(1,"emilyjoo2","Emily_Joansom@gmail.com",    "EmilyJoansom123", "1980-06-25", 	"+359888234567", "Emily",    "Joansom",   "8006251234", 41, "F", "2015-08-20", 2, "on_work"),
(1,"michaellxxx","Michael_Willmard@gmail.com", "MichaelWillmard123", "1990-11-30",  "+359888345678", "Michael",  "Willmard",  "9011305678", 31, "M", "2018-05-10", 3, "on_work"),
(1,"sophiabreeN1","Sophia_Breen@gmail.com", 	   "SophiaBreen123", "1975-08-18", 		"+359888456789", "Sophia",   "Breen",     "7508182345", 46, "F", "2000-11-28", 4, "on_work"),
(1,"JenND","Jeen_Davitson@gmail.com",    "JeenDavitson123", "1988-02-05", 	"+359888567890", "Jeen",     "Davitson",  "8802056789", 33, "M", "2016-07-14", 5, "on_work");

-- ------------------------------------------------------------------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------------------------------------------------------------------


-- Technical Courses
INSERT INTO Courses (course_id, course_name, course_description) VALUES
(1, 'Mathematics', 'Comprehensive study of mathematical principles and problem-solving techniques.'),
(2, 'English Literature', 'Exploration of classic and contemporary English literature and writing styles.'),
(3, 'Science - Biology', 'Study of living organisms, their structure, functions, and interactions.'),
(4, 'History - World Civilizations', 'Examination of significant events and societies throughout world history.'),
(5, 'Computer Science - Programming Fundamentals', 'Introduction to programming concepts and coding practices.'),
(6, 'Arts - Visual Arts', 'Exploration of various artistic mediums and techniques.'),
(7, 'Physical Education', 'Incorporation of physical activities for health and fitness.'),
(8, 'Foreign Language - Spanish', 'Learning Spanish language fundamentals and communication skills.');

-- Additional Technical Courses
INSERT INTO Courses (course_id, course_name, course_description) VALUES
(9, 'Computer Science - Data Structures', 'Study of fundamental data structures and algorithms.'),
(10, 'Software Engineering', 'Principles of software design, development methodologies, and project management.'),
(11, 'Network Security', 'Understanding network vulnerabilities, encryption, and security protocols.'),
(12, 'Web Development - Frontend Technologies', 'Introduction to frontend technologies like HTML, CSS, and JavaScript.'),
(13, 'Database Management Systems', 'Exploration of database models, SQL, and database administration.'),
(14, 'Machine Learning', 'Introduction to machine learning algorithms and predictive modeling.'),
(15, 'Cybersecurity Fundamentals', 'Basic principles of cybersecurity, threat detection, and incident response.');

-- Miscellaneous Courses
INSERT INTO Courses (course_id, course_name, course_description) VALUES
(16, 'Psychology - Introduction to Human Behavior', 'Overview of human behavior, cognition, and psychological theories.'),
(17, 'Environmental Science', 'Exploration of ecological systems, conservation, and environmental challenges.'),
(18, 'Business Management Fundamentals', 'Introduction to business principles, leadership, and organizational behavior.'),
(19, 'Creative Writing Workshop', 'Hands-on exercises and workshops to enhance creative writing skills.'),
(20, 'Public Speaking and Communication', 'Techniques and practices for effective public speaking and communication.'),
(21, 'Music Theory and Composition', 'Understanding music theory, composition techniques, and musical structure.'),
(22, 'Photography - Visual Storytelling', 'Exploration of photography as a medium for visual storytelling.');

-- ------------------------------------------------
-- ------------------------------------------------


-- Classroom DML data
-- -----------------------------------------------------------------------------------
-- -----------------------------------------------------------------------------------
INSERT INTO Classrooms (classroom_year, course_id, classroom_status, teacher_id) VALUES 
(2023, 1, 'active', 51),  
(2023, 2, 'active', 52),  
(2023, 3, 'active', 53);  

INSERT INTO Classrooms (classroom_year, course_id, classroom_status, teacher_id) VALUES 
(2023, 4, 'active', 54), 
(2023, 5, 'active', 55), 
(2023, 6, 'active', 55); 
-- -----------------------------------------------------------------------------------
-- -----------------------------------------------------------------------------------


-- Exam_Types DML
-- -----------------------------------------------------------------------------------
-- -----------------------------------------------------------------------------------
INSERT INTO Exam_Types (exam_type_name, exam_type_description) VALUES 
('Midterm Exam', 'Midterm assessment for the course'),
('Final Exam', 'Final evaluation for the course'),
('Quiz', 'Short quiz conducted during class'),
('Project Presentation', 'Evaluation based on project presentations');

-- Another set of inserts for additional exam types
INSERT INTO Exam_Types (exam_type_name, exam_type_description) VALUES 
('Oral Exam', 'Verbal assessment of student knowledge'),
('Practical Exam', 'Hands-on examination of skills'),
('Mock Test', 'Simulated test for practice purposes');

INSERT INTO Exam_Types (exam_type_name, exam_type_description) VALUES 
('Term Paper', 'Written assignment covering course material'),
('Final Project', 'Culminating project demonstrating course knowledge'),
('Open-book Exam', 'Exam allowing reference materials'),
('Closed-book Exam', 'Exam without access to reference materials');

-- ------------------------------------------------
-- ------------------------------------------------


-- Exams DML
INSERT INTO Exams (exam_type_id, exam_name, start_date) VALUES 
(1, 'Midterm Exam 2', '2023-04-30'),
(2, 'Final Exam 2', '2023-06-25'),
(3, 'Quiz 1', '2023-03-10'),
(4, 'Project Presentation 1', '2023-05-05'),
(5, 'Oral Exam 1', '2023-04-20'),
(6, 'Practical Exam 1', '2023-05-15'),
(7, 'Mock Test 1', '2023-03-25'),
(8, 'Term Paper 1', '2023-04-05'),
(9, 'Final Project 1', '2023-06-01'),
(10, 'Open-book Exam 1', '2023-04-10'),
(11, 'Closed-book Exam 1', '2023-05-20');



-- Exam results
-- Exam_Results data
INSERT INTO Exam_Results (exam_id, student_id, course_id, grade, remarks) VALUES
(1, 1, 1, 85, 'Well done!'),
(2, 2, 1, 78, 'Good effort.'),
(3, 3, 2, 92, 'Excellent work.'),
(4, 4, 2, 70, 'Needs improvement.'),
(5, 5, 3, 88, 'Impressive.'),
(6, 6, 3, 95, 'Top performance.'),
(7, 7, 4, 80, 'Satisfactory.'),
(8, 8, 4, 65, 'Room for improvement.');

-- sample Exam_Results data
INSERT INTO Exam_Results (exam_id, student_id, course_id, grade, remarks) VALUES
(9, 9, 5, 72, 'Adequate performance.'),
(10, 10, 5, 85, 'Well done.'),
(11, 11, 6, 68, 'Work harder.');

select * from Classrooms;
select * from Teachers;
select * from Exam_Results;
select * from Attendences;
select * from Exams;
select * from Exam_Types;
select * from Students;
select * from Parents;
select * from Courses;
select * from Addresses;