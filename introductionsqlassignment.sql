/* Write a query to list the product id, product name, and unit price of every 
product.*/
Select ProductID, productname, unitprice
From products;
 
/*3. Write a query to list the product id, product name, and unit price of every 
product.  Except this time, order then in ascending order by price.*/

SELECT  productid, productname, UnitPrice
FROM products
order by UnitPrice;

/*4. What are the products that we carry where the unit price is $7.50 or less?*/
SELECT *
FROM products
where unitprice < 7.50;

/* What are the products that we carry where we have at least 100 units on 
hand?  Order them in descending order by price.*/
SELECT *
FROM products
WHERE QuantityPerUnit > 90;

/* 6.What are the products that we carry where we have at least 100 units on 
hand?  Order them in descending order by price.   If two or more have the 
same price, list those in ascending order by product name. */
SELECT *
FROM products
WHERE QuantityPerUnit > 100 
ORDER BY unitprice desc ;

/*7. What are the products that we carry where we have no units on hand, but 1 
or more units of them on backorder?  Order them by product name.*/
SELECT *
FROM products
Where UnitsInStock < 1 or UnitsOnOrder > 1
order by productname;

/*What is the name of the table that holds the types (categories) of the items 
Northwind sells? */


/*9. Write a query that lists all of the columns and all of the rows of the 
categories table?  What is the category id of seafood? */
SELECT *
from orders;

/*10. Examine the Products table.  How does it identify the type (category) of 
each item sold?  Write a query to list all of the seafood items we carry.*/