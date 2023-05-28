# Section 3: Querying – 50 pts

#05.Players
SELECT p.first_name, p.age, p.salary
FROM players AS p
ORDER BY p.salary DESC;

#06.Young offense players without contract
SELECT p.id,
       CONCAT_WS(' ', p.first_name, p.last_name),
       p.age,
       p.position,
       p.hire_date
FROM players AS p
JOIN skills_data AS sd on p.skills_data_id = sd.id
WHERE p.hire_date IS NULL AND
      p.position = 'A' AND
      sd.strength > 50
ORDER BY p.salary, p.age;

#07.Detail info for all teams
SELECT t.name AS team_name,
       t.established,
       t.fan_base,
        COUNT(p.id) AS 'players_count'
    FROM teams AS t
    LEFT JOIN players AS p ON t.id = p.team_id
GROUP BY t.id
ORDER BY players_count DESC, t.fan_base DESC;

#08.The fastest player by towns
SELECT MAX(sd.speed) AS 'max_speed', tw.name AS 'town_name'
FROM skills_data AS sd
         RIGHT JOIN players AS p on sd.id = p.skills_data_id
         RIGHT JOIN  teams AS t on t.id = p.team_id
         RIGHT JOIN  stadiums AS s on t.stadium_id = s.id
         RIGHT JOIN  towns AS tw on s.town_id = tw.id
WHERE t.name != 'Devify'
GROUP BY tw.name
ORDER BY max_speed DESC, tw.name;

#09. Total salaries and players by country
SELECT c.name,
       COUNT(p.id) AS 'total_count_of_players',
       SUM(p.salary) AS 'total_sum_of_salaries'
    FROM countries AS c
    LEFT JOIN towns AS tw on c.id = tw.country_id
    LEFT JOIN stadiums AS s on tw.id = s.town_id
    LEFT JOIN teams AS t on s.id = t.stadium_id
    LEFT JOIN players AS p on t.id = p.team_id
GROUP BY c.name
ORDER BY total_count_of_players DESC, c.name;



