#Permessi ed utenti
use treninordovest;
create user 'trenino'@'localhost' identified by "TreniNordOvest@2025";
grant select,update,insert,delete on treninordovest.* to 'trenino'@'localhost';


select citta,IDFermata from tratteFermateCompleto t1
where NumOrdine = (
    select Max(Numordine)
    from tratteFermateCompleto t2
) and t1.IDTratta = 'R001'
;

select citta,IDFermata from tratteFermateCompleto t1
where NumOrdine = (
    select Min(Numordine)
    from tratteFermateCompleto t2
) and t1.IDTratta = 'R001'
;

