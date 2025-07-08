use treninordovest;

-- Dati per la tabella "treno"
INSERT INTO treno (IDTreno, Modello, KW, NumPosti) VALUES
                                                       ('TRN001', 'Frecciarossa 1000', 6000, 450),
                                                       ('TRN002', 'Italo EVO', 5500, 380),
                                                       ('TRN003', 'Intercity Giorno', 4000, 300),
                                                       ('TRN004', 'Regionale Veloce', 3000, 250),
                                                       ('TRN005', 'Frecciargento ETR 600', 5800, 360);

-- Dati per la tabella "tratta"
INSERT INTO tratta (IDTratta, Nome, Lunghezza) VALUES
                                                   ('TRA001', 'Milano Centrale - Roma Termini', 570),
                                                   ('TRA002', 'Roma Termini - Napoli Centrale', 190),
                                                   ('TRA003', 'Torino Porta Nuova - Venezia Santa Lucia', 380),
                                                   ('TRA004', 'Bologna Centrale - Firenze Santa Maria Novella', 95),
                                                   ('TRA005', 'Milano Centrale - Venezia Santa Lucia', 270);

-- Dati per la tabella "fermata"
INSERT INTO fermata (IDFermata, Citta, NumBinari) VALUES
                                                      ('FRM001', 'Milano', 24),
                                                      ('FRM002', 'Bologna', 20),
                                                      ('FRM003', 'Firenze', 16),
                                                      ('FRM004', 'Roma', 29),
                                                      ('FRM005', 'Napoli', 25),
                                                      ('FRM006', 'Torino', 20),
                                                      ('FRM007', 'Venezia', 16),
                                                      ('FRM008', 'Verona', 12),
                                                      ('FRM009', 'Padova', 11);

-- Dati per la tabella "trenotratta"
-- Associa i treni alle tratte con un numero commerciale specifico del treno
INSERT INTO trenotratta (IDTratta, IDTreno, NumTreno) VALUES
                                                          ('TRA001', 'TRN001', 'FR9502'), -- Frecciarossa Milano-Roma
                                                          ('TRA001', 'TRN002', 'IT9910'), -- Italo Milano-Roma
                                                          ('TRA002', 'TRN003', 'IC703'),  -- Intercity Roma-Napoli
                                                          ('TRA003', 'TRN005', 'FA8406'), -- Frecciargento Torino-Venezia
                                                          ('TRA004', 'TRN004', 'RV2177'), -- Regionale Veloce Bologna-Firenze
                                                          ('TRA005', 'TRN001', 'FR9725'); -- Frecciarossa Milano-Venezia

-- Dati per la tabella "trattafermata"
-- Definisce le fermate e gli orari all'interno di ciascuna tratta
-- Tratta: TRA001 (Milano - Roma)
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo) VALUES
                                                                                                ('TRA001', 1, 'FRM001', 10, '08:00:00', '08:00:00'), -- Milano (Partenza)
                                                                                                ('TRA001', 2, 'FRM002', 5, '09:05:00', '09:00:00'),  -- Bologna (Fermata)
                                                                                                ('TRA001', 3, 'FRM004', 1, '11:15:00', '11:15:00'); -- Roma (Arrivo)

-- Tratta: TRA002 (Roma - Napoli)
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo) VALUES
                                                                                                ('TRA002', 1, 'FRM004', 15, '12:00:00', '12:00:00'), -- Roma (Partenza)
                                                                                                ('TRA002', 2, 'FRM005', 12, '13:10:00', '13:10:00'); -- Napoli (Arrivo)

-- Tratta: TRA003 (Torino - Venezia)
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo) VALUES
                                                                                                ('TRA003', 1, 'FRM006', 8, '07:30:00', '07:30:00'), -- Torino (Partenza)
                                                                                                ('TRA003', 2, 'FRM008', 3, '09:00:00', '08:55:00'),  -- Verona (Fermata)
                                                                                                ('TRA003', 3, 'FRM009', 7, '09:50:00', '09:45:00'),  -- Padova (Fermata)
                                                                                                ('TRA003', 4, 'FRM007', 4, '10:15:00', '10:15:00'); -- Venezia (Arrivo)

-- Tratta: TRA004 (Bologna - Firenze)
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo) VALUES
                                                                                                ('TRA004', 1, 'FRM002', 6, '14:00:00', '14:00:00'), -- Bologna (Partenza)
                                                                                                ('TRA004', 2, 'FRM003', 9, '14:40:00', '14:40:00'); -- Firenze (Arrivo)

-- Tratta: TRA005 (Milano - Venezia)
INSERT INTO trattafermata (IDTratta, NumOrdine, IDFermata, Binario, OraPartenza, OraArrivo) VALUES
                                                                                                ('TRA005', 1, 'FRM001', 11, '16:00:00', '16:00:00'), -- Milano (Partenza)
                                                                                                ('TRA005', 2, 'FRM008', 4, '18:10:00', '18:05:00'),  -- Verona (Fermata)
                                                                                                ('TRA005', 3, 'FRM007', 5, '19:00:00', '19:00:00'); -- Venezia (Arrivo)


-- Dati per la tabella "viaggio"
-- Questi sono i "viaggi" specifici che la compagnia mette a disposizione
-- Nota: OrarioPartenza/Arrivo e IDPartenza/Arrivo dovrebbero corrispondere alle fermate iniziali/finali della tratta
-- per il rispettivo NumTreno.

-- Viaggio TRA001 - FR9502 (Milano-Roma)
INSERT INTO viaggio (IDViaggio, IDTratta, IDPartenza, IDArrivo, DataViaggio, OrarioPartenza, OrarioArrivo, NumTreno) VALUES
    ('VGG001', 'TRA001', 'FRM001', 'FRM004', '2025-07-15', '08:00:00', '11:15:00', 'FR9502');
INSERT INTO viaggio (IDViaggio, IDTratta, IDPartenza, IDArrivo, DataViaggio, OrarioPartenza, OrarioArrivo, NumTreno) VALUES
    ('VGG002', 'TRA001', 'FRM004', 'FRM001', '2025-07-17', '18:00:00', '21:15:00', 'IT9910'); -- Viaggio di ritorno per un A/R
INSERT INTO viaggio (IDViaggio, IDTratta, IDPartenza, IDArrivo, DataViaggio, OrarioPartenza, OrarioArrivo, NumTreno) VALUES
    ('VGG003', 'TRA001', 'FRM001', 'FRM004', '2025-07-16', '08:30:00', '11:45:00', 'IT9910'); -- Altro viaggio Milano-Roma

-- Viaggio TRA002 - IC703 (Roma-Napoli)
INSERT INTO viaggio (IDViaggio, IDTratta, IDPartenza, IDArrivo, DataViaggio, OrarioPartenza, OrarioArrivo, NumTreno) VALUES
    ('VGG004', 'TRA002', 'FRM004', 'FRM005', '2025-07-16', '12:00:00', '13:10:00', 'IC703');

-- Viaggio TRA003 - FA8406 (Torino-Venezia)
INSERT INTO viaggio (IDViaggio, IDTratta, IDPartenza, IDArrivo, DataViaggio, OrarioPartenza, OrarioArrivo, NumTreno) VALUES
    ('VGG005', 'TRA003', 'FRM006', 'FRM007', '2025-07-18', '07:30:00', '10:15:00', 'FA8406');

-- Viaggio TRA004 - RV2177 (Bologna-Firenze)
INSERT INTO viaggio (IDViaggio, IDTratta, IDPartenza, IDArrivo, DataViaggio, OrarioPartenza, OrarioArrivo, NumTreno) VALUES
    ('VGG006', 'TRA004', 'FRM002', 'FRM003', '2025-07-19', '14:00:00', '14:40:00', 'RV2177');

-- Viaggio TRA005 - FR9725 (Milano-Venezia)
INSERT INTO viaggio (IDViaggio, IDTratta, IDPartenza, IDArrivo, DataViaggio, OrarioPartenza, OrarioArrivo, NumTreno) VALUES
    ('VGG007', 'TRA005', 'FRM001', 'FRM007', '2025-07-20', '16:00:00', '19:00:00', 'FR9725');

-- Dati aggiuntivi per la tabella "viaggio"
-- Generati mantenendo la coerenza con tratte, fermate e orari esistenti.

-- Altri viaggi per la tratta TRA001 (Milano-Roma e viceversa)
INSERT INTO viaggio (IDViaggio, IDTratta, IDPartenza, IDArrivo, DataViaggio, OrarioPartenza, OrarioArrivo, NumTreno) VALUES
                                                                                                                         ('VGG008', 'TRA001', 'FRM001', 'FRM004', '2025-07-21', '08:00:00', '11:15:00', 'FR9502'), -- Altro Frecciarossa Milano-Roma
                                                                                                                         ('VGG009', 'TRA001', 'FRM004', 'FRM001', '2025-07-22', '18:00:00', '21:15:00', 'IT9910'), -- Altro Italo di ritorno Roma-Milano
                                                                                                                         ('VGG010', 'TRA001', 'FRM001', 'FRM004', '2025-07-24', '08:30:00', '11:45:00', 'IT9910'); -- Altro Italo Milano-Roma

-- Viaggio di ritorno per la tratta TRA002 (Napoli-Roma)
INSERT INTO viaggio (IDViaggio, IDTratta, IDPartenza, IDArrivo, DataViaggio, OrarioPartenza, OrarioArrivo, NumTreno) VALUES
    ('VGG011', 'TRA002', 'FRM005', 'FRM004', '2025-07-23', '15:00:00', '16:10:00', 'IC703'); -- Ritorno Napoli-Roma in orario diverso

-- Viaggio di ritorno per la tratta TRA003 (Venezia-Torino)
INSERT INTO viaggio (IDViaggio, IDTratta, IDPartenza, IDArrivo, DataViaggio, OrarioPartenza, OrarioArrivo, NumTreno) VALUES
    ('VGG012', 'TRA003', 'FRM007', 'FRM006', '2025-07-18', '19:00:00', '21:45:00', 'FA8406'); -- Frecciargento di ritorno in serata

-- Viaggio di ritorno per la tratta TRA004 (Firenze-Bologna)
INSERT INTO viaggio (IDViaggio, IDTratta, IDPartenza, IDArrivo, DataViaggio, OrarioPartenza, OrarioArrivo, NumTreno) VALUES
    ('VGG013', 'TRA004', 'FRM003', 'FRM002', '2025-07-26', '09:00:00', '09:40:00', 'RV2177'); -- Regionale Veloce di ritorno in mattinata

-- Altri viaggi e ritorni per la tratta TRA005 (Milano-Venezia)
INSERT INTO viaggio (IDViaggio, IDTratta, IDPartenza, IDArrivo, DataViaggio, OrarioPartenza, OrarioArrivo, NumTreno) VALUES
                                                                                                                         ('VGG014', 'TRA005', 'FRM001', 'FRM007', '2025-07-27', '16:00:00', '19:00:00', 'FR9725'), -- Altro Frecciarossa Milano-Venezia
                                                                                                                         ('VGG015', 'TRA005', 'FRM007', 'FRM001', '2025-07-28', '10:15:00', '13:15:00', 'FR9725'); -- Frecciarossa di ritorno Venezia-Milano

-- Un'altra corsa per il Roma-Napoli
INSERT INTO viaggio (IDViaggio, IDTratta, IDPartenza, IDArrivo, DataViaggio, OrarioPartenza, OrarioArrivo, NumTreno) VALUES
    ('VGG016', 'TRA002', 'FRM004', 'FRM005', '2025-07-29', '12:00:00', '13:10:00', 'IC703');

-- Ulteriore blocco di 15 viaggi per popolare il database
INSERT INTO viaggio (IDViaggio, IDTratta, IDPartenza, IDArrivo, DataViaggio, OrarioPartenza, OrarioArrivo, NumTreno) VALUES
                                                                                                                         ('VGG017', 'TRA001', 'FRM001', 'FRM004', '2025-08-01', '08:00:00', '11:15:00', 'FR9502'), -- Inizio agosto, alta stagione Mi-Rm
                                                                                                                         ('VGG018', 'TRA001', 'FRM004', 'FRM001', '2025-08-01', '17:00:00', '20:15:00', 'FR9502'), -- Ritorno in giornata
                                                                                                                         ('VGG019', 'TRA002', 'FRM004', 'FRM005', '2025-08-02', '12:00:00', '13:10:00', 'IC703'),  -- Roma-Napoli per il weekend
                                                                                                                         ('VGG020', 'TRA003', 'FRM006', 'FRM007', '2025-08-03', '07:30:00', '10:15:00', 'FA8406'), -- Torino-Venezia
                                                                                                                         ('VGG021', 'TRA005', 'FRM001', 'FRM007', '2025-08-04', '16:00:00', '19:00:00', 'FR9725'), -- Milano-Venezia
                                                                                                                         ('VGG022', 'TRA005', 'FRM007', 'FRM001', '2025-08-05', '09:15:00', '12:15:00', 'FR9725'), -- Ritorno Venezia-Milano
                                                                                                                         ('VGG023', 'TRA004', 'FRM002', 'FRM003', '2025-08-06', '14:00:00', '14:40:00', 'RV2177'), -- Bologna-Firenze
                                                                                                                         ('VGG024', 'TRA004', 'FRM003', 'FRM002', '2025-08-06', '19:20:00', '20:00:00', 'RV2177'), -- Ritorno in serata
                                                                                                                         ('VGG025', 'TRA001', 'FRM001', 'FRM004', '2025-08-08', '08:30:00', '11:45:00', 'IT9910'), -- Italo Mi-Rm, pre-ferragosto
                                                                                                                         ('VGG026', 'TRA001', 'FRM004', 'FRM001', '2025-08-10', '18:00:00', '21:15:00', 'IT9910'), -- Ritorno Roma-Milano
                                                                                                                         ('VGG027', 'TRA003', 'FRM007', 'FRM006', '2025-08-11', '19:00:00', '21:45:00', 'FA8406'), -- Ritorno Venezia-Torino
                                                                                                                         ('VGG028', 'TRA002', 'FRM005', 'FRM004', '2025-08-12', '08:00:00', '09:10:00', 'IC703'),  -- Ritorno Napoli-Roma mattutino
                                                                                                                         ('VGG029', 'TRA001', 'FRM001', 'FRM004', '2025-08-14', '08:00:00', '11:15:00', 'FR9502'), -- Viaggio della vigilia di Ferragosto
                                                                                                                         ('VGG030', 'TRA005', 'FRM001', 'FRM007', '2025-08-14', '16:00:00', '19:00:00', 'FR9725'), -- Altro viaggio della vigilia
                                                                                                                         ('VGG031', 'TRA001', 'FRM004', 'FRM001', '2025-08-17', '19:00:00', '22:15:00', 'FR9502'); -- Ritorno post-Ferragosto

