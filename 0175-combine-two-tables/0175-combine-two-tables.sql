# Write your MySQL query statement below

SELECT firstName, lastName, 
    (SELECT city from Address where Person.personId = Address.personId) AS city,
    (SELECT state from Address where Person.personId = Address.personId) AS state
from Person;

