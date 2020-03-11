# ExpenseManager
A Spring Boot Application to Track Expenses.

Create Postgres Database Tables Using :-

```javascript
CREATE TABLE public.expenses
(
  id integer NOT NULL DEFAULT nextval('expenses_id_seq'::regclass),
  "user" text NOT NULL,
  date text NOT NULL,
  description text,
  category text,
  amount bigint,
  CONSTRAINT expenses_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.expenses
  OWNER TO postgres;
  
  ________________________________________________________________
  
  CREATE TABLE public.expense
(
  date text NOT NULL,
  expenditure text NOT NULL,
  outstanding text NOT NULL
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.expense
  OWNER TO postgres;
  

