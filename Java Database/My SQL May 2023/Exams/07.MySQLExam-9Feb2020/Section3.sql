#Section 3: Querying – 50 pts

#05.Players
SELECT p.first_name, p.age, p.salary
FROM players AS p
ORDER BY p.salary DESC;

#06.Young offense players without contract
SELECT p.id,
       CONCAT_WS(' ', p.first_name, p.last_name) AS 'full_name',
       p.age,
       p.position,
       hire_date
FROM players AS p
         JOIN skills_data AS sd ON sd.id = p.skills_data_id
WHERE p.hire_date IS NULL
  AND p.position = 'A'
  AND p.age < 23
  AND sd.strength > 50
ORDER BY p.salary, p.age;

#07.Detail info for all teams
SELECT
    t.name AS 'team_name',
    t.established,
    t.fan_base,
    COUNT(p.id) AS 'players_count'
FROM teams AS t
         LEFT JOIN players AS p ON t.id = p.team_id
GROUP BY t.id
ORDER BY players_count DESC, t.fan_base DESC;

#08.The fastest player by towns
SELECT MAX(sd.speed) AS 'max_speed', tw.name AS 'town_name'
FROM towns AS tw
LEFT JOIN stadiums AS s ON tw.id = s.town_id
LEFT JOIN teams AS t2 ON s.id = t2.stadium_id
LEFT JOIN players AS p ON t2.id = p.team_id
LEFT JOIN skills_data AS sd ON p.skills_data_id = sd.id
WHERE t2.name != 'Devify'
GROUP BY tw.name
ORDER BY max_speed DESC, tw.name

# 09.Total salaries and players by country
SELECT cn.name,
       COUNT(p.id) AS 'total_count_of_players',
       SUM(p.salary) AS 'total_sum_of_salaries'
FROM countries AS cn
LEFT JOIN towns AS tw ON cn.id = tw.country_id
LEFT JOIN stadiums AS s ON tw.id = s.town_id
LEFT JOIN teams AS te ON s.id = te.stadium_id
LEFT JOIN players AS p ON te.id = p.team_id
GROUP BY cn.id
ORDER BY total_count_of_players DESC, cn.name;
