Relationships of tables
sql generation happens by jpa - we have to do configuration in our entity classes

One to One Relationship
what is one to One relationship?
ans:when one record in a table(entity) is associated with one record in other table
foreign key 
Table
Book:
Book_id Book_name Author_id

Table
Author: 
author_id  author_name

[ORM Concepts]
spring -data -jpa
1.One-to-One [unidirectional data flow]
2.One-to-Many
3.Many-to-one
4.Many-to-Many

1.One-2-One : one record of a table associated with one record in other table
example: user - email
         user - address [single address]
         spouse - spouse
         country - capital






