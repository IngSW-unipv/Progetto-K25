#Permessi ed utenti
use treninordovest;
create user 'trenino'@'localhost' identified by "TreniNordOvest@2025";
grant select,update,insert,delete on treninordovest.* to 'trenino'@'localhost';

