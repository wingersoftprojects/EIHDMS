DROP TRIGGER IF EXISTS trig_pivot_egpaf_surge_form;
DELIMITER //
CREATE TRIGGER trig_pivot_egpaf_surge_form 
AFTER INSERT ON base_data_39 
FOR EACH ROW 
BEGIN 
	SET @report_period_year=NEW.report_period_year;
	SET @report_period_week=NEW.report_period_week;
	-- update
END//
DELIMITER ;



