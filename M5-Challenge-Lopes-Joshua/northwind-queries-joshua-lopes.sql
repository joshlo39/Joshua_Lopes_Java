-- What are the categories of products in the database?
select category 
from products p 
-- What products are made by Dell?
select * 
from products p
where product_name = 'Dell Inspirion'
-- List all the orders shipped to Pennsylvania.
select *
from orders
where ship_state  = 'Pennsylvania'
-- List the first name and last name of all employees with last names that start with the letter W.
select first_name, last_name
from employees e 
where last_name 
like "W%"
-- List all customers from zip codes that start with 55
select * 
from customers c 
where postal_code
like '55%'
-- List all customers from zip codes that start with 55
select * 
from customers c 
where postal_code
like '%0'
-- List the first name, last name, and email for all customers with a ".org" email address.
select first_name,last_name,email
from customers c 
where email 
like '%org'
-- List the first name, last name, and email for all customers with a ".org" email address.
select first_name,last_name,phone
from customers c 
where phone 
like '1-(202)%'
-- List the first name, last name, and phone number for all customers from the 202 area code, ordered by last name, first name.
select first_name, last_name ,phone 
from customers c
where phone
like '1-(202)%'
order by last_name, first_name 
