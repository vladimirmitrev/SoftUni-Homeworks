DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value (sum DECIMAL(19,4) , yearly_interest_rate DOUBLE, YEARS INT)
RETURNS DECIMAL (19,4)
DETERMINISTIC

BEGIN
    DECLARE sum_with_interest DECIMAL(19,4);
    SET sum_with_interest := sum * POW(1 + yearly_interest_rate, YEARS);
    RETURN sum_with_interest;
END$$

set @sum = 5000;
set @yearly_interest_rate = 2;
set @YEARS = 5;
select ufn_calculate_future_value(
               @sum,
               @yearly_interest_rate,
               @YEARS
           );