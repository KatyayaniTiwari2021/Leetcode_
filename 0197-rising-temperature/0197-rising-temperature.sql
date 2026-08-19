# Write your MySQL query statement below
select id from 
(
    select id, 
    temperature, 
    recordDate,
    LAG(temperature) OVER(ORDER BY recordDate) as prev_temp,
    LAG(recordDate) OVER (ORDER BY recordDate) AS prev_date
    from Weather 
)t

where prev_temp < temperature
and datediff(recordDate, prev_date) = 1; 
