
use treninordovest;

-- Assicurarsi di usare lo schema corretto
use treninordovest;

-----------------------------------------------------------
-- AREA TRENI
-----------------------------------------------------------
-- 1. Treno
INSERT INTO treno (IDTreno, Modello, KW, NumPosti)
VALUES
  ('TR001', 'Freccia Rossa', 5000, 200),
  ('TR002', 'Italo', 4500, 180);

-- 2. Tratta
INSERT INTO tratta (IDTratta, Nome, Lunghezza)
VALUES
  ('T001', 'Milano-Roma', 600),
  ('T002', 'Torino-Napoli', 700);

-- 3. Fermata
INSERT INTO fermata (IDFermata, Citta, NumBinari)
VALUES
  ('F001', 'Milano', 10),
  ('F002', 'Roma', 8),
  ('F003', 'Torino', 9),
  ('F004', 'Napoli', 7);

-- 4. Trenotratta (relazione tra treno e tratta)
INSERT INTO trenotratta (IDTratta, IDTreno, NumTreno)
VALUES
  ('T001', 'TR001', 1),
  ('T001', 'TR002', 2),
  ('T002', 'TR001', 1);

-- 5. Trattafermata (definizione dell'ordine e degli orari delle fermate per ogni tratta)
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES
  -- Per la tratta T001 (Milano-Roma)
  ('T001', 1, 'F001', 1, '07:50:00', '07:55:00'),
  ('T001', 2, 'F002', 2, '09:00:00', '09:05:00'),
  -- Per la tratta T002 (Torino-Napoli)
  ('T002', 1, 'F003', 1, '10:00:00', '10:05:00'),
  ('T002', 2, 'F004', 2, '12:00:00', '12:05:00');

-----------------------------------------------------------
-- AREA UTENZE
-----------------------------------------------------------
-- 6. Utente (10 record: 5 dipendenti e 5 clienti)
INSERT INTO utente (ID, UserPassword, Nome, Cognome, Sesso, LuogoNascita, DataNascita, Cellulare, Indirizzo)
VALUES
  -- Dipendenti
  ('U001', 'pwd1', 'Marco',    'Bianchi',  'M', 'Milano',  '1980-05-10', '3331112223', 'Via Dante 12, Milano'),
  ('U002', 'pwd2', 'Lucia',    'Verdi',    'F', 'Roma',    '1985-07-20', '3332223334', 'Via del Corso 45, Roma'),
  ('U003', 'pwd3', 'Giovanni', 'Neri',     'M', 'Torino',  '1978-12-01', '3333334445', 'Via Torino 56, Torino'),
  ('U004', 'pwd4', 'Anna',     'Russo',    'F', 'Napoli',  '1990-03-15', '3334445556', 'Via Partenope 78, Napoli'),
  ('U005', 'pwd5', 'Paolo',    'Ferrari',  'M', 'Bologna', '1982-11-30', '3335556667', 'Via Verdi 90, Bologna'),
  -- Clienti
  ('U006', 'pwd6', 'Sara',      'Gialli',    'F', 'Firenze', '1995-08-25', '3336667778', 'Via Uffizi 11, Firenze'),
  ('U007', 'pwd7', 'Luca',      'Rossi',     'M', 'Verona',  '1988-02-14', '3337778889', 'Via Arena 22, Verona'),
  ('U008', 'pwd8', 'Elena',     'Bianchi',   'F', 'Palermo', '1992-09-09', '3338889990', 'Via Libertà 33, Palermo'),
  ('U009', 'pwd9', 'Federico',  'Conti',     'M', 'Genova',  '1987-04-17', '3339990001', 'Via Garibaldi 44, Genova'),
  ('U010', 'pwd10','Martina',   'Esposito',  'F', 'Bari',    '1990-12-05', '3330001122', 'Via Murat 55, Bari');

-- 7. Dipendente (gli utenti U001-U005)
INSERT INTO dipendente (IDDipendente, Stipendio, Ruolo, CodTreno)
VALUES
  ('U001', 2600, 'Macchinista', 'TR001'),
  ('U002', 2400, 'Assistente',  'TR002'),
  ('U003', 2700, 'Macchinista', 'TR001'),
  ('U004', 2300, 'Controllore','TR002'),
  ('U005', 2500, 'Assistente',  'TR001');

-- 8. Cliente (gli utenti U006-U010)
INSERT INTO cliente (IDCliente, Bilancio, Email)
VALUES
  ('U006', 150.00, 'sara.gialli@example.com'),
  ('U007', 200.00, 'luca.rossi@example.com'),
  ('U008', 175.50, 'elena.bianchi@example.com'),
  ('U009', 220.75, 'federico.conti@example.com'),
  ('U010', 300.00, 'martina.esposito@example.com');

-- 9. Tessera (per ogni cliente)
INSERT INTO tessera (IDTessera, Emissione, Scadenza, IDCliente)
VALUES
  ('TS001', '2023-01-01', '2024-01-01', 'U006'),
  ('TS002', '2023-02-01', '2024-02-01', 'U007'),
  ('TS003', '2023-03-01', '2024-03-01', 'U008'),
  ('TS004', '2023-04-01', '2024-04-01', 'U009'),
  ('TS005', '2023-05-01', '2024-05-01', 'U010');

-- 10. Pagamento (relativo ai clienti)
INSERT INTO pagamento (IDPagamento, IDCliente, Totale, Tipo, Dataora)
VALUES
  ('P001', 'U006', 15.50, 'Carta', '2023-06-01 12:00:00'),
  ('P002', 'U007', 20.00, 'Contanti', '2023-06-02 13:00:00'),
  ('P003', 'U008', 18.75, 'Carta', '2023-06-03 14:00:00'),
  ('P004', 'U009', 22.00, 'Online', '2023-06-04 15:00:00'),
  ('P005', 'U010', 25.00, 'Carta', '2023-06-05 16:00:00');

-----------------------------------------------------------
-- AREA TITOLI
-----------------------------------------------------------
-- 11. Titoloviaggio (per i pagamenti sopra)
INSERT INTO titoloviaggio (IDTitolo, IDPagamento, Emissione, Prezzo)
VALUES
  ('TV001', 'P001', '2023-06-01', 15.50),
  ('TV002', 'P002', '2023-06-02', 20.00),
  ('TV003', 'P003', '2023-06-03', 18.75),
  ('TV004', 'P004', '2023-06-04', 22.00),
  ('TV005', 'P005', '2023-06-05', 25.00);

-- 12. Biglietto (associato al titoloviaggio, utilizza lo stesso ID)
INSERT INTO biglietto (IDBiglietto, Ritorno, Validato)
VALUES
  ('TV001', false, false),
  ('TV002', false, true),
  ('TV003', true, false),
  ('TV004', false, true),
  ('TV005', true, true);

-- 13. Abbonamento (abbonamento è un tipo di titoloviaggio, perciò creiamo un pagamento e un titoloviaggio aggiuntivo)
-- Pagamento per abbonamento
INSERT INTO pagamento (IDPagamento, IDCliente, Totale, Tipo, Dataora)
VALUES
  ('P006', 'U006', 50.00, 'Abbonamento', '2023-06-06 10:00:00');

-- Titolo di viaggio per abbonamento
INSERT INTO titoloviaggio (IDTitolo, IDPagamento, Emissione, Prezzo)
VALUES
  ('ABB001', 'P006', '2023-06-06', 50.00);

-- Inserimento abbonamento (associato ad una tessera, ad es. TS001 di U006)
INSERT INTO abbonamento (IDAbbonamento, Tipo, Scadenza, IDTessera)
VALUES
  ('ABB001', 'Mensile', '2023-07-06', 'TS001');

-- 14. Storico Pagamento (registrazione dello stato dei pagamenti)
INSERT INTO storicopagamento (IDStorico, IDPagamento, Dataora, Stato)
VALUES
  ('S001', 'P001', '2023-06-01 12:05:00', 'Completato'),
  ('S002', 'P002', '2023-06-02 13:05:00', 'Completato'),
  ('S003', 'P003', '2023-06-03 14:05:00', 'Fallito'),
  ('S004', 'P004', '2023-06-04 15:05:00', 'Completato'),
  ('S005', 'P005', '2023-06-05 16:05:00', 'Completato'),
  ('S006', 'P006', '2023-06-06 10:05:00', 'Completato');

-----------------------------------------------------------
-- AREA VIAGGI E COLLEGAMENTI
-----------------------------------------------------------
-- 15. Viaggio (informazioni sui viaggi effettuati)
INSERT INTO viaggio (IDViaggio, IDTratta, IDPartenza, IDArrivo, DataViaggio, OrarioPartenza, OrarioArrivo)
VALUES
  ('V001', 'T001', 'F001', 'F002', '2023-06-10', '08:00:00', '09:00:00'),
  ('V002', 'T002', 'F003', 'F004', '2023-06-11', '10:00:00', '12:00:00');

-- 16. Bigliettoviaggio (collegamento tra viaggi e biglietti)
INSERT INTO bigliettoviaggio (IDViaggio, IDBiglietto)
VALUES
  ('V001', 'TV001'),
  ('V002', 'TV002');

-- 17. Rimborso (registro dei rimborsi effettuati)
INSERT INTO rimborso (IDRimborso, Dataora, Totale, IDBiglietto, IDRichiedente)
VALUES
  ('R001', '2023-06-07 11:00:00', 18.75, 'TV003', 'U007');



-----------------------------------------------------------
-- Inserimento delle fermate (usiamo ID univoci per questa tratta)
-----------------------------------------------------------
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES
  ('F200', 'Vercelli',         5),
  ('F201', 'Palestro',         3),
  ('F202', 'Robbio',           3),
  ('F203', 'Nicorvo',          2),
  ('F204', 'Mortara',          4),
  ('F205', 'Gambolò Remondò',  3),
  ('F206', 'Tromello',         2),
  ('F207', 'Garlasco',         4),
  ('F208', 'Gropello Cairoli',  3),
  ('F209', 'Villanova Ardenghi',2),
  ('F210', 'Cava Carbonara',   3),
  ('F211', 'Pavia',            6);

-----------------------------------------------------------
-- Creazione della nuova tratta ufficiale
-----------------------------------------------------------
INSERT INTO tratta (IDTratta, Nome, Lunghezza)
VALUES ('T005', 'Ferrovia Vercelli-Pavia (Linea R36 ufficiale)', 67);

-----------------------------------------------------------
-- Associazione della tratta ad un treno (ad es. TR001 con NumTreno=6)
-----------------------------------------------------------
INSERT INTO trenotratta (IDTratta, IDTreno, NumTreno)
VALUES ('T005', 'TR001', 6);

-----------------------------------------------------------
-- Definizione delle fermate della tratta (in ordine)
-----------------------------------------------------------
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES
  -- 1. Vercelli (stazione di partenza)
  ('T005', 1, 'F200', 1, '06:00:00', '06:00:00'),
  -- 2. Palestro
  ('T005', 2, 'F201', 2, '06:10:00', '06:12:00'),
  -- 3. Robbio
  ('T005', 3, 'F202', 3, '06:20:00', '06:22:00'),
  -- 4. Nicorvo
  ('T005', 4, 'F203', 4, '06:30:00', '06:32:00'),
  -- 5. Mortara
  ('T005', 5, 'F204', 5, '06:40:00', '06:42:00'),
  -- 6. Gambolò Remondò
  ('T005', 6, 'F205', 6, '06:50:00', '06:52:00'),
  -- 7. Tromello
  ('T005', 7, 'F206', 7, '07:00:00', '07:02:00'),
  -- 8. Garlasco
  ('T005', 8, 'F207', 8, '07:10:00', '07:12:00'),
  -- 9. Gropello Cairoli
  ('T005', 9, 'F208', 9, '07:20:00', '07:22:00'),
  -- 10. Villanova Ardenghi
  ('T005', 10, 'F209', 10, '07:30:00', '07:32:00'),
  -- 11. Cava Carbonara
  ('T005', 11, 'F210', 11, '07:40:00', '07:42:00'),
  -- 12. Pavia (stazione di arrivo)
  ('T005', 12, 'F211', 12, '07:50:00', '07:50:00');

-- prova

-----------------------------------------------------------
-- Inserimento di 20 fermate (se non già presenti)
-----------------------------------------------------------
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES
  ('F301', 'Milano', 10),
  ('F302', 'Roma', 8),
  ('F303', 'Torino', 9),
  ('F304', 'Napoli', 7),
  ('F305', 'Firenze', 6),
  ('F306', 'Bologna', 8),
  ('F307', 'Genova', 7),
  ('F308', 'Palermo', 5),
  ('F309', 'Bari', 6),
  ('F310', 'Cagliari', 4),
  ('F311', 'Venezia', 7),
  ('F312', 'Verona', 6),
  ('F313', 'Trieste', 5),
  ('F314', 'Padova', 6),
  ('F315', 'Brescia', 7),
  ('F316', 'Parma', 5),
  ('F317', 'Modena', 6),
  ('F318', 'Reggio Calabria', 4),
  ('F319', 'Livorno', 7),
  ('F320', 'Perugia', 6);

-----------------------------------------------------------
-- Inserimento di 20 tratte
-----------------------------------------------------------
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES
  ('T101', 'Milano - Torino', 140),
  ('T102', 'Roma - Firenze', 230),
  ('T103', 'Napoli - Bari', 150),
  ('T104', 'Genova - Venezia', 300),
  ('T105', 'Palermo - Catania', 120),
  ('T106', 'Bologna - Modena', 40),
  ('T107', 'Verona - Padova', 80),
  ('T108', 'Trieste - Udine', 60),
  ('T109', 'Brescia - Parma', 90),
  ('T110', 'Reggio Calabria - Cosenza', 70),
  ('T111', 'Livorno - Pisa', 30),
  ('T112', 'Perugia - Terni', 50),
  ('T113', 'Milano - Bergamo', 35),
  ('T114', 'Torino - Genova', 110),
  ('T115', 'Roma - Napoli', 220),
  ('T116', 'Firenze - Bologna', 100),
  ('T117', 'Verona - Mantova', 60),
  ('T118', 'Padova - Rovigo', 45),
  ('T119', 'Trieste - Pordenone', 55),
  ('T120', 'Bari - Lecce', 80);

-----------------------------------------------------------
-- Inserimento in trattafermata: per ogni tratta inseriamo 2 fermate
-- (1 = origine, 2 = destinazione)
-----------------------------------------------------------

-- Per le prime 10 tratte (T101 - T110) utilizziamo fermate in ordine:
-- T101: origine = F301, destinazione = F302
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T101', 1, 'F301', 1, '06:00:00', '06:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T101', 2, 'F302', 2, '06:30:00', '06:30:00');

-- T102: origine = F303, destinazione = F304
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T102', 1, 'F303', 1, '07:00:00', '07:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T102', 2, 'F304', 2, '07:30:00', '07:30:00');

-- T103: origine = F305, destinazione = F306
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T103', 1, 'F305', 1, '08:00:00', '08:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T103', 2, 'F306', 2, '08:30:00', '08:30:00');

-- T104: origine = F307, destinazione = F308
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T104', 1, 'F307', 1, '09:00:00', '09:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T104', 2, 'F308', 2, '09:30:00', '09:30:00');

-- T105: origine = F309, destinazione = F310
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T105', 1, 'F309', 1, '10:00:00', '10:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T105', 2, 'F310', 2, '10:30:00', '10:30:00');

-- T106: origine = F311, destinazione = F312
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T106', 1, 'F311', 1, '11:00:00', '11:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T106', 2, 'F312', 2, '11:30:00', '11:30:00');

-- T107: origine = F313, destinazione = F314
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T107', 1, 'F313', 1, '12:00:00', '12:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T107', 2, 'F314', 2, '12:30:00', '12:30:00');

-- T108: origine = F315, destinazione = F316
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T108', 1, 'F315', 1, '13:00:00', '13:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T108', 2, 'F316', 2, '13:30:00', '13:30:00');

-- T109: origine = F317, destinazione = F318
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T109', 1, 'F317', 1, '14:00:00', '14:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T109', 2, 'F318', 2, '14:30:00', '14:30:00');

-- T110: origine = F319, destinazione = F320
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T110', 1, 'F319', 1, '15:00:00', '15:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T110', 2, 'F320', 2, '15:30:00', '15:30:00');

-- Per le tratte T111 - T120, riutilizziamo ciclicamente le fermate:
-- T111: origine = F301, destinazione = F302
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T111', 1, 'F301', 1, '16:00:00', '16:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T111', 2, 'F302', 2, '16:30:00', '16:30:00');

-- T112: origine = F303, destinazione = F304
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T112', 1, 'F303', 1, '17:00:00', '17:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T112', 2, 'F304', 2, '17:30:00', '17:30:00');

-- T113: origine = F305, destinazione = F306
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T113', 1, 'F305', 1, '18:00:00', '18:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T113', 2, 'F306', 2, '18:30:00', '18:30:00');

-- T114: origine = F307, destinazione = F308
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T114', 1, 'F307', 1, '19:00:00', '19:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T114', 2, 'F308', 2, '19:30:00', '19:30:00');

-- T115: origine = F309, destinazione = F310
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T115', 1, 'F309', 1, '20:00:00', '20:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T115', 2, 'F310', 2, '20:30:00', '20:30:00');

-- T116: origine = F311, destinazione = F312
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T116', 1, 'F311', 1, '21:00:00', '21:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T116', 2, 'F312', 2, '21:30:00', '21:30:00');

-- T117: origine = F313, destinazione = F314
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T117', 1, 'F313', 1, '22:00:00', '22:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T117', 2, 'F314', 2, '22:30:00', '22:30:00');

-- T118: origine = F315, destinazione = F316
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T118', 1, 'F315', 1, '23:00:00', '23:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T118', 2, 'F316', 2, '23:30:00', '23:30:00');

-- T119: origine = F317, destinazione = F318
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T119', 1, 'F317', 1, '00:00:00', '00:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T119', 2, 'F318', 2, '00:30:00', '00:30:00');

-- T120: origine = F319, destinazione = F320
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T120', 1, 'F319', 1, '01:00:00', '01:00:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('T120', 2, 'F320', 2, '01:30:00', '01:30:00');


