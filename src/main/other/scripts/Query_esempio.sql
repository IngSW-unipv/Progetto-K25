

use treninordovest;

select * from utente;
select * from cliente;
select * from abbonamento;
select * from rimborso;
select * from biglietto;

select * from (treno tr join trenotratta tt on tr.IDTreno=tt.IDTreno)join tratta ta on tt.IDTratta=ta.IDTratta;

create view FermateTratte as
select fe.*,ta.*,tt.NumOrdine,tt.Binario,tt.OraPartenza,tt.OraArrivo from (fermata fe join trattafermata tt on fe.IDFermata=tt.IDFermata)join tratta ta on tt.IDTratta=ta.IDTratta;

select * from pagamento;
select * from storicopagamento;
select * from viaggio;
select * from tratta;
select * from trattafermata;
select * from fermata;
select * from treno;
select * from cliente;
select * from FermateTratte;


alter table pagamento add DataPagamento date not null ;
#alter table storicopagamento drop Dataora;

#alter table rimborso drop Dataora;
alter table rimborso add DataRimborso date;

