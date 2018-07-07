一、oracle建立索引需要注意的知识点

符合的情况：
1.某表的某个字段有主键约束或唯一性约束，则Oracle 则会自动在相应的约束列上建议唯一索引

2.索引应该经常建在Where 子句经常用到的列上。如果某个大表经常使用某个字段进行查询，并且检索行数小于总表行数的5%，则应该考虑建立索引。

3.对于两表连接的字段，应该建立索引。

4.如果经常在某表的一个字段进行Order By，应该建立索引。

不符合的情况：
1.不应该在小表上建设索引。

2.索引主要进行提高数据的查询速度。 当进行DML时，会更新索引。因此索引越多，则DML越慢，其需要维护索引。 因此在创建索引及DML需要权衡。


二、单一索引和复合索引区别
    单一索引:Create Index <Index-Name> On <Table_Name>(Column_Name);

　复合索引: Create Index i_deptno_job on emp(deptno,job); —>在emp表的deptno、job列建立索引。

　　select * from emp where deptno=66 and job='sals' ->走索引。

　　select * from emp where deptno=66 OR job='sals' ->将进行全表扫描。不走索引

　　select * from emp where deptno=66 ->走索引。

　　select * from emp where job='sals' ->进行全表扫描、不走索引。

　　如果在where 子句中有OR 操作符或单独引用Job 列(索引列的后面列) 则将不会走索引，将会进行全表扫描。