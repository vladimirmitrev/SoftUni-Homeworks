#Find all countries along with information about their currency.
 #Display the country name, country code and information about its currency:
 #either "Euro" or "Not Euro". Sort the results by country name alphabetically. 

SELECT `country_name`, `country_code`,
IF (`currency_code` = "EUR", "Euro", "Not Euro")
AS `currency`
FROM `countries`
ORDER BY `country_name`;