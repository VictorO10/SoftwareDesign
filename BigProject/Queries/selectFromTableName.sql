SELECT category FROM categories WHERE categories_id=1 into @table_name2; 

set @Expression := concat('SELECT * FROM ',@table_name2);

PREPARE myquery FROM @Expression;
EXECUTE myquery;