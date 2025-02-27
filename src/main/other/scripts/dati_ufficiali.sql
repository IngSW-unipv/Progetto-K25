-- Inserimenti per la tabella "treno"
INSERT INTO treno (IDTreno, Modello, KW, NumPosti) VALUES ('T001', 'Frecciarossa', 5000, 400);
INSERT INTO treno (IDTreno, Modello, KW, NumPosti) VALUES ('T002', 'Italo', 4500, 350);
INSERT INTO treno (IDTreno, Modello, KW, NumPosti) VALUES ('T003', 'Pendolino', 4000, 300);
INSERT INTO treno (IDTreno, Modello, KW, NumPosti) VALUES ('T004', 'Eurostar', 5500, 380);
INSERT INTO treno (IDTreno, Modello, KW, NumPosti) VALUES ('T005', 'Intercity', 4200, 320);

-- Inserimenti per la tabella "tratta"
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('R001', 'Milano - Roma', 600);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('R002', 'Milano - Napoli', 700);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('R003', 'Torino - Firenze', 450);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('R004', 'Bologna - Venezia', 500);

-- Inserimenti per la tabella "trenotratta"
-- Associazioni: ad esempio, la tratta R001 viene effettuata da T001 e T002
INSERT INTO trenotratta (IDTratta, IDTreno, NumTreno) VALUES ('R001', 'T001', 1);
INSERT INTO trenotratta (IDTratta, IDTreno, NumTreno) VALUES ('R001', 'T002', 2);
INSERT INTO trenotratta (IDTratta, IDTreno, NumTreno) VALUES ('R002', 'T003', 1);
INSERT INTO trenotratta (IDTratta, IDTreno, NumTreno) VALUES ('R003', 'T004', 1);
INSERT INTO trenotratta (IDTratta, IDTreno, NumTreno) VALUES ('R004', 'T005', 1);

-- Inserimenti per la tabella "fermata"
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES ('F001', 'Milano', 6);
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES ('F002', 'Roma', 4);
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES ('F003', 'Napoli', 3);
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES ('F004', 'Torino', 5);
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES ('F005', 'Firenze', 3);
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES ('F006', 'Bologna', 4);
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES ('F007', 'Venezia', 2);

-- Inserimenti per la tabella "trattafermata"
-- Tratta R001: Milano - Roma (con sosta a Bologna)
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('R001', 1, 'F001', 2, '08:00:00', '08:00:00'); -- Partenza da Milano
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('R001', 2, 'F006', 3, '09:00:00', '08:55:00'); -- Sosta a Bologna
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('R001', 3, 'F002', 1, '10:30:00', '10:30:00'); -- Arrivo a Roma

-- Tratta R002: Milano - Napoli (con sosta a Bologna)
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('R002', 1, 'F001', 2, '07:30:00', '07:30:00'); -- Partenza da Milano
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('R002', 2, 'F006', 3, '08:45:00', '08:40:00'); -- Sosta a Bologna
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('R002', 3, 'F003', 1, '10:15:00', '10:15:00'); -- Arrivo a Napoli

-- Tratta R003: Torino - Firenze
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('R003', 1, 'F004', 2, '09:00:00', '09:00:00'); -- Partenza da Torino
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('R003', 2, 'F005', 1, '10:20:00', '10:20:00'); -- Arrivo a Firenze

-- Tratta R004: Bologna - Venezia
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('R004', 1, 'F006', 3, '11:00:00', '11:00:00'); -- Partenza da Bologna
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('R004', 2, 'F007', 1, '12:30:00', '12:30:00'); -- Arrivo a Venezia
