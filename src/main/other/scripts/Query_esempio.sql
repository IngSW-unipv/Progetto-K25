

use treninordovest;

select * from utente;
select * from cliente;
select * from abbonamento;
select * from rimborso;
select * from biglietto;

select * from (treno tr join trenotratta tt on tr.IDTreno=tt.IDTreno)join tratta ta on tt.IDTratta=ta.IDTratta;



select * from pagamento;
select * from storicopagamento;
select * from viaggio;
select * from tratta;
select * from trattafermata;
select * from fermata;
select * from treno;
select * from cliente;




