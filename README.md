# ExpenseManager
An Spring Boot Application to Track Expenses.

Create Postgres Database Using :-

-- Table: public.expenses

-- DROP TABLE public.expenses;

```javascript
 CREATE TABLE public.expenses
(
  id integer NOT NULL DEFAULT nextval('expenses_id_seq'::regclass),
  date text,
  description text,
  category text,
  amount bigint,
  CONSTRAINT expenses_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.expenses
  OWNER TO postgres;```
  

