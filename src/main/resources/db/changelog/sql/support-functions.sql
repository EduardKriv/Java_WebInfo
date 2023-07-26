-- procedures for import data into tables from csv files and export data from tables to csv files
CREATE OR REPLACE FUNCTION fnc_get_columns_names(tablename text)
    RETURNS TEXT AS $$
BEGIN
    RETURN (SELECT string_agg(format('%s', quote_ident(column_name)), ',' ) FROM ( SELECT column_name
                                                                                   FROM information_schema.columns
                                                                                   WHERE table_schema='public' AND table_name = tablename
                                                                                     AND NOT column_name = 'id') AS names);
END;$$
    LANGUAGE plpgsql;

CREATE OR REPLACE PROCEDURE pr_fill_table_from_csv(IN tablename text,IN path text,IN delim text)
    LANGUAGE plpgsql as $$
BEGIN
    -- чтобы в файлах не надо было руками заполнять столбец id, при заполнении таблицы перечисляем список столбцов кроме id
    EXECUTE format('COPY %1$s(%4$s) FROM %2$L WITH DELIMITER ''%3$s'' CSV HEADER', $1, $2, $3, fnc_get_columns_names(tablename));
-- проверка что есть колонка id в таблице
    IF exists ( SELECT 1
                FROM information_schema.columns
                WHERE table_schema='public' AND table_name = tablename
                  AND column_name='id')
    THEN
        EXECUTE format('SELECT setval(''%1$s_id_seq'', (SELECT MAX(id) FROM %1$s));', $1); -- сброс счетчика на текущее max(id)
    END IF;
END;$$;

CREATE OR REPLACE PROCEDURE pr_fill_csv_from_table(IN tablename text,IN path text,IN delim text)
    LANGUAGE plpgsql AS $$
BEGIN
    EXECUTE format('COPY %s TO %L DELIMITER ''%s'' CSV HEADER;', $1, $2, $3);
END;$$;
-- end procedures for import data into tables from csv files and export data from tables to csv files
