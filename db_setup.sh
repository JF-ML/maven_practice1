export ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe; 
export ORACLE_SID=XE; 
$ORACLE_HOME/bin/sqlplus -S travis/travis <<SQL
whenever sqlerror exit 2;
create table "alumno"("id" varchar2(20), "nombre" varchar2(50), "edad" varchar2(10), "promedio" varchar2(20),"email"varchar2(50));

SQL