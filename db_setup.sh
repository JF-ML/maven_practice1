export ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe; 
export ORACLE_SID=XE; 
$ORACLE_HOME/bin/sqlplus -S travis/travis <<SQL
whenever sqlerror exit 2;
create table "ALUMNO"("ID" varchar2(20), "NOMBRE" varchar2(50), "EDAD" varchar2(10), "PROMEDIO" varchar2(20),"EMAIL"varchar2(50));

SQL