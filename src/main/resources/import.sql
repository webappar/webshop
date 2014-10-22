ALTER DATABASE webshop DEFAULT CHARACTER SET = 'utf8' COLLATE = 'utf8_swedish_ci';

INSERT INTO Customer (userName, userEmail, password) VALUES('Harry','HarryMail','123pw');
INSERT INTO Customer (userName, userEmail, password) VALUES('Karlgren','KarlMail','wp321');
INSERT INTO Customer (userName, userEmail, password) VALUES('Victor','VictorMale','123wp');
INSERT INTO Customer (userName, userEmail, password) VALUES('Martin','MartinMail','wp123');
INSERT INTO Customer (userName, userEmail, password) VALUES('Dure','MailDure','321pw');
INSERT INTO Customer (userName, userEmail, password) VALUES('Britt-Olof','BriolfMail','321wp');
INSERT INTO Customer (userName, userEmail, password) VALUES('Britt-Erik','BrerikMail','w123p');
INSERT INTO Customer (userName, userEmail, password) VALUES('Kent-Morgan','KenoMail','p123w');
INSERT INTO Customer (userName, userEmail, password) VALUES('J Von Hacht','Hajen','somVissteforMkt');

INSERT INTO Products (artNr, proName, price, url, description) VALUES(12345,'Apple',10,'Apple.jpg','Hur m�nga �pplen hade fallit fr�n tr�d innan Sir Newton kom p� graviditeten? man skulle ju kunna tro att vi l�r oss l�ngsamt man det g�ller att man �r nyfiken.. som Nicke.');
INSERT INTO Products (artNr, proName, price, url, description) VALUES(54321,'Banana',12,'Banana.jpg','Bananer �r gula och b�jda, det var ocks� under medeltiden den generella tron att jorden var bananformad.');
INSERT INTO Products (artNr, proName, price, url, description) VALUES(51423,'Pear',14,'Pear.jpg','Vem var det som kom p� id�n med frukt? Det m�ste vara det sv�raste substantiv att skriva flummiga beskrivningar om, lyckligtvis kommer det �ven ett par seri�sa beskrivningar ocks�.');
INSERT INTO Products (artNr, proName, price, url, description) VALUES(34251,'Orange',15,'Orange.jpg','V�ran mest prestigefyllda citrusfrukt, som vilken annan som helst. Den �r ful och ser ut som en rund morot.');
INSERT INTO Products (artNr, proName, price, url, description) VALUES(32415,'Ferrari',18000,'Ferrari.jpg','Ferrari har annonserat att dom t�nker g�ra en hover-car convertible som kan konvertera fr�n hover-car till riktig car.. Snacka om ett riktigt "bad"-Car');
INSERT INTO Products (artNr, proName, price, url, description) VALUES(15243,'RangeRover',17,'RangeRover.jpg','Den h�r bilen gav mig och min endl�sa fantasi en tyst stund, hade ingen aning om vad jag kan skriva h�r s� den f�r bli s�n, //Harry');
INSERT INTO Products (artNr, proName, price, url, description) VALUES(12543,'ipren',100350,'ipren.jpg','N�got som Martin i v�ran grupp har anv�ndning av men han tycker nog att det �r f�r dyrt?');
INSERT INTO Products (artNr, proName, price, url, description) VALUES(54123,'Doorknob',805,'Doorknob.jpg','Alla har vi v�l k�nt att det �r motstridigt ibland? och d� vore v�l inget annat b�ttre �n att f� ett "handtag"? :D just nu, om du k�per detta handtag inom 10 sekunder s� f�r du �ven en penna, med n�gon annans namn, ingraverat i guld! Nice Price p� AweseomShop Deluxe');
INSERT INTO Products (artNr, proName, price, url, description) VALUES(78910,'Grape',25,'Grape.jpg','Frukt f�r vilken n�rdig health junky som helst, vi gilalr inte s�nna s� d�rf�r s�ger vi att vi s�ljer v�rldens b�sta frukt till ockerpriser. oj, nej, v�nta! kom detta in i produktbeskrivningen nu? :O helv***');
INSERT INTO Products (artNr, proName, price, url, description) VALUES(10987,'PolarBear',30,'PolarBear.jpg','En alldeles egen Isbj�rn finns att k�pa h�r till det helt incredible l�ga pris av det som st�r d�r ovanf�r.. �ter pingviner och saltgurka men passa er f�r att ge den pressad gurkmajon�s d� det kan ge upphov till gaser.. globala uppv�rmningsgaser!');
INSERT INTO Products (artNr, proName, price, url, description) VALUES(13337,'Porsche',512,'Porsche.jpg','En bil som s� m�nga andra, f�rutom att detta har v�rldens sk�naste s�ten, kunde n�stan tro att en viss tysk diktator designade den.. F�r han hade ju tydligen Great Succes med en viss "Mein Kampfy Chair"');
INSERT INTO Products (artNr, proName, price, url, description) VALUES(73331,'Milk',432,'Milk.jpg','Mj�lk �r naturens egen sportdryck, ihoppressat i alla fyra magar p� en slumpvis utvald ko, Vem hade kunnat ana att just den kon skulle g�ra just din mj�lk? :O mindBlown! Vi borde skriva ett "kon"trakt p� alla "kon"stiga id�er som "kon"stapel kal"kon" "ko"mmer p� inna vi g�r i "kon"kurs :D');
INSERT INTO Products (artNr, proName, price, url, description) VALUES(37313,'Fannerset',345,'Fannerset.jpg','Bestick av h�gst kvalit� f�r att kunna avnjuta allt, Kebabrullar fr�n Rolands k�tt & video till svindyr hummer fr�n en girig spansk hummer-fifflare. Imponera p� dina grannar, oerh�rt dyrt, fult men doftar gran.');
INSERT INTO Products (artNr, proName, price, url, description) VALUES(31373,'Shoehorn',789,'Shoehorn.jpg','Har du alltid tyckt att ditt skohorn �r f�r tungt? D� beh�ver du inte leta l�ngre, f�r h�r �r ShoehornSuperleggera1.0, ett skohorn gjort av kolfibrer. S� nu kan du �ntligen g�ra allt det d�r som du bara dr�mt om, n�r du har ett alldeles eget skohorn gjort av kolfibrer!!  :D ');
INSERT INTO Products (artNr, proName, price, url, description) VALUES(33317,'KalsongNr1',11,'KalsongNr1.jpg','Varf�r brann Hipstern inne i den stora branden? - Jo han tyckte n�dutg�ngen var f�r "mainstream".');
INSERT INTO Products (artNr, proName, price, url, description) VALUES(33371,'KalsongNr3',12,'KalsongNr3.jpg','�kta dressman, endast f�r riktiga m�n som spelar hockey och dricker �l. En man som torkar sina kl�der i ugnen ist�llet f�r torktummlarn, en man som parkerar sin motorcykel i vardagsrummet, en man som vars toarulle river som en tre-dagars sk�ggstubb i stj�ren.. D�r har vi mannen f�r dessa helt otroliga kalsonger!');
INSERT INTO Products (artNr, proName, price, url, description) VALUES(33731,'KalsongNr4',13,'KalsongNr4.jpg','Wow, vad tr�kiga alla vitsar om Zebror �r.. - Ja, dom �r ju lite l�ngrandiga.. ka-dom-tish!');
INSERT INTO Products (artNr, proName, price, url, description) VALUES(17333,'Asfalt',1300,'Asfalt.jpg','Finns det n�got mer manligare �n att komma hem svettig en torsdagseftermiddag, sl�nge upp f�tterna p� farmors gamla tr�pall, kn�cka en b�rs framf�r TV:n och bara ta och best�lla ett par hektar asfal,, (eller �r det i m^3 man k�per det i?. hmm..)');

INSERT INTO Orders (ordNr, ordDate, ordUser) VALUES(10,111014,'Karlgren');
INSERT INTO Orders (ordNr, ordDate, ordUser) VALUES(11,111014,'Harry');
INSERT INTO Orders (ordNr, ordDate, ordUser) VALUES(12,111014,'Martin');
INSERT INTO Orders (ordNr, ordDate, ordUser) VALUES(13,111014,'Victor');
INSERT INTO Orders (ordNr, ordDate, ordUser) VALUES(14,111014,'Harry');
INSERT INTO Orders (ordNr, ordDate, ordUser) VALUES(15,111014,'Harry');
INSERT INTO Orders (ordNr, ordDate, ordUser) VALUES(16,111016,'Harry');
INSERT INTO Orders (ordNr, ordDate, ordUser) VALUES(17,111016,'Victor');
INSERT INTO Orders (ordNr, ordDate, ordUser) VALUES(18,111016,'Britt-Olof');
INSERT INTO Orders (ordNr, ordDate, ordUser) VALUES(19,111016,'Britt-Erik');
INSERT INTO Orders (ordNr, ordDate, ordUser) VALUES(20,111016,'Kent-Morgan');
INSERT INTO Orders (ordNr, ordDate, ordUser) VALUES(21,111016,'J Von Hacht');

INSERT INTO Orderitem (ordNr, artNr, quant) VALUES(10,12345,50);
INSERT INTO Orderitem (ordNr, artNr, quant) VALUES(11,32415,2);
INSERT INTO Orderitem (ordNr, artNr, quant) VALUES(12,12543,3);
INSERT INTO Orderitem (ordNr, artNr, quant) VALUES(13,15243,1);
INSERT INTO Orderitem (ordNr, artNr, quant) VALUES(13,54321,2);
INSERT INTO Orderitem (ordNr, artNr, quant) VALUES(14,54123,1);
INSERT INTO Orderitem (ordNr, artNr, quant) VALUES(15,12345,7);
INSERT INTO Orderitem (ordNr, artNr, quant) VALUES(16,33317,5);
INSERT INTO Orderitem (ordNr, artNr, quant) VALUES(16,33371,5);
INSERT INTO Orderitem (ordNr, artNr, quant) VALUES(16,33731,5);
INSERT INTO Orderitem (ordNr, artNr, quant) VALUES(17,33731,3);
INSERT INTO Orderitem (ordNr, artNr, quant) VALUES(18,10987,100);
INSERT INTO Orderitem (ordNr, artNr, quant) VALUES(18,37313,1);
INSERT INTO Orderitem (ordNr, artNr, quant) VALUES(19,31373,2);
INSERT INTO Orderitem (ordNr, artNr, quant) VALUES(19,13337,1);
INSERT INTO Orderitem (ordNr, artNr, quant) VALUES(20,12345,7);
INSERT INTO Orderitem (ordNr, artNr, quant) VALUES(21,33371,40);
INSERT INTO Orderitem (ordNr, artNr, quant) VALUES(21,32415,1);
