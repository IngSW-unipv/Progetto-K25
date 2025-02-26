INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR001', 'Milano Centrale - Monza', 20);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR002', 'Milano Centrale - Saronno', 30);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR003', 'Milano Centrale - Seregno', 25);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR004', 'Milano Centrale - Varese', 50);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR005', 'Milano Centrale - Como', 55);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR006', 'Milano Centrale - Pavia', 35);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR007', 'Milano Centrale - Bergamo', 40);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR008', 'Milano Centrale - Lodi', 15);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR009', 'Milano Centrale - Rho', 18);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR010', 'Milano Centrale - Abbiategrasso', 22);




/*Tratte*/
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR001', 'Milano Centrale - Monza', 20);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR002', 'Milano Centrale - Saronno', 30);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR003', 'Milano Centrale - Seregno', 25);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR004', 'Milano Centrale - Varese', 50);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR005', 'Milano Centrale - Como', 55);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR006', 'Milano Centrale - Pavia', 35);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR007', 'Milano Centrale - Bergamo', 40);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR008', 'Milano Centrale - Lodi', 15);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR009', 'Milano Centrale - Rho', 18);
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES ('TR010', 'Milano Centrale - Abbiategrasso', 22);


/*Assegnazioni Tratte e treni*/
INSERT INTO trenotratta (IDTratta, IDTreno, NumTreno) VALUES ('TR001', 'T001', 1);
INSERT INTO trenotratta (IDTratta, IDTreno, NumTreno) VALUES ('TR002', 'T002', 1);
INSERT INTO trenotratta (IDTratta, IDTreno, NumTreno) VALUES ('TR003', 'T003', 1);
INSERT INTO trenotratta (IDTratta, IDTreno, NumTreno) VALUES ('TR004', 'T004', 1);
INSERT INTO trenotratta (IDTratta, IDTreno, NumTreno) VALUES ('TR005', 'T005', 1);
INSERT INTO trenotratta (IDTratta, IDTreno, NumTreno) VALUES ('TR006', 'T006', 1);
INSERT INTO trenotratta (IDTratta, IDTreno, NumTreno) VALUES ('TR007', 'T007', 1);
INSERT INTO trenotratta (IDTratta, IDTreno, NumTreno) VALUES ('TR008', 'T008', 1);
INSERT INTO trenotratta (IDTratta, IDTreno, NumTreno) VALUES ('TR009', 'T009', 1);
INSERT INTO trenotratta (IDTratta, IDTreno, NumTreno) VALUES ('TR010', 'T010', 1);


/*Fermate*/
-- Milano Centrale è il punto di partenza comune
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES ('F001', 'Milano Centrale', 12);
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES ('F002', 'Monza', 4);
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES ('F003', 'Saronno', 3);
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES ('F004', 'Seregno', 2);
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES ('F005', 'Varese', 3);
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES ('F006', 'Como', 4);
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES ('F007', 'Pavia', 3);
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES ('F008', 'Bergamo', 4);
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES ('F009', 'Lodi', 2);
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES ('F010', 'Rho', 2);
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES ('F011', 'Abbiategrasso', 2);



/*Tratta fermata*/
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR001', 1, 'F001', 1, '08:00:00', '08:05:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR001', 2, 'F002', 2, '08:06:00', '08:10:00');


INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR002', 1, 'F001', 1, '08:10:00', '08:15:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR002', 2, 'F003', 2, '08:16:00', '08:25:00');


INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR003', 1, 'F001', 1, '08:20:00', '08:25:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR003', 2, 'F004', 2, '08:26:00', '08:35:00');


INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR004', 1, 'F001', 1, '08:30:00', '08:35:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR004', 2, 'F005', 2, '08:36:00', '08:50:00');


INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR005', 1, 'F001', 1, '08:40:00', '08:45:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR005', 2, 'F006', 2, '08:46:00', '09:00:00');

INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR006', 1, 'F001', 1, '08:50:00', '08:55:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR006', 2, 'F007', 2, '08:56:00', '09:05:00');

INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR007', 1, 'F001', 1, '09:00:00', '09:05:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR007', 2, 'F008', 2, '09:06:00', '09:20:00');

INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR008', 1, 'F001', 1, '09:10:00', '09:15:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR008', 2, 'F009', 2, '09:16:00', '09:25:00');

INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR009', 1, 'F001', 1, '09:20:00', '09:25:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR009', 2, 'F010', 2, '09:26:00', '09:35:00');


INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR010', 1, 'F001', 1, '09:30:00', '09:35:00');
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo)
VALUES ('TR010', 2, 'F011', 2, '09:36:00', '09:45:00');




