/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : eihdms

Target Server Type    : MYSQL
Target Server Version : 50199
File Encoding         : 65001

Date: 2016-10-10 10:48:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- View structure for vw_base_data
-- ----------------------------
DROP VIEW IF EXISTS `vw_base_data`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `vw_base_data` AS select `r`.`region_name` AS `region_name`,`d`.`district_name` AS `district_name`,`c`.`county_name` AS `county_name`,`sc`.`sub_county_name` AS `sub_county_name`,`p`.`parish_name` AS `parish_name`,`h`.`health_facility_name` AS `health_facility_name`,`bd`.`base_data_id` AS `base_data_id`,`bd`.`data_element_id` AS `data_element_id`,`bd`.`data_element_value` AS `data_element_value`,`bd`.`health_facility_id` AS `health_facility_id`,`bd`.`parish_id` AS `parish_id`,`bd`.`district_id` AS `district_id`,`bd`.`report_period_from_date` AS `report_period_from_date`,`bd`.`report_period_to_date` AS `report_period_to_date`,`bd`.`is_deleted` AS `is_deleted`,`bd`.`is_active` AS `is_active`,`bd`.`add_date` AS `add_date`,`bd`.`add_by` AS `add_by`,`bd`.`last_edit_date` AS `last_edit_date`,`bd`.`last_edit_by` AS `last_edit_by`,`bd`.`financial_year_id` AS `financial_year_id`,`bd`.`report_period_quarter` AS `report_period_quarter`,`bd`.`sub_county_id` AS `sub_county_id`,`bd`.`batch_id` AS `batch_id`,`bd`.`report_period_month` AS `report_period_month`,`bd`.`report_period_week` AS `report_period_week`,`bd`.`report_period_year` AS `report_period_year`,`bd`.`report_period_bi_month` AS `report_period_bi_month`,`de`.`data_element_name` AS `data_element_name`,`de`.`data_element_code` AS `data_element_code`,`de`.`age_category` AS `age_category`,`de`.`sex_category` AS `sex_category`,`de`.`other_category` AS `other_category`,`de`.`data_element_context` AS `data_element_context`,`rf`.`report_form_name` AS `report_form_name`,`rfg`.`report_form_group_name` AS `report_form_group_name`,`de`.`report_form_id` AS `report_form_id`,`de`.`report_form_group_id` AS `report_form_group_id`,`r`.`region_id` AS `region_id`,`c`.`county_id` AS `county_id` from (((((((((`base_data` `bd` join `district` `d` on((`bd`.`district_id` = `d`.`district_id`))) join `region` `r` on((`d`.`region_id` = `r`.`region_id`))) left join `sub_county` `sc` on((`bd`.`sub_county_id` = `sc`.`sub_county_id`))) left join `county` `c` on((`c`.`county_id` = `bd`.`county_id`))) left join `parish` `p` on((`bd`.`parish_id` = `p`.`parish_id`))) left join `health_facility` `h` on((`bd`.`health_facility_id` = `h`.`health_facility_id`))) join `data_element` `de` on((`bd`.`data_element_id` = `de`.`data_element_id`))) join `report_form` `rf` on((`de`.`report_form_id` = `rf`.`report_form_id`))) join `report_form_group` `rfg` on((`de`.`report_form_group_id` = `rfg`.`report_form_group_id`))) ; ;

-- ----------------------------
-- View structure for vw_interface_data
-- ----------------------------
DROP VIEW IF EXISTS `vw_interface_data`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `vw_interface_data` AS select `interface_data`.`interface_data_id` AS `interface_data_id`,`interface_data`.`data_element_id` AS `data_element_id`,`interface_data`.`data_element_value` AS `data_element_value`,`interface_data`.`health_facility_name` AS `health_facility_name`,`interface_data`.`parish_name` AS `parish_name`,`interface_data`.`district_name` AS `district_name`,`interface_data`.`report_period_from_date` AS `report_period_from_date`,`interface_data`.`report_period_to_date` AS `report_period_to_date`,`interface_data`.`is_deleted` AS `is_deleted`,`interface_data`.`is_active` AS `is_active`,`interface_data`.`add_date` AS `add_date`,`interface_data`.`add_by` AS `add_by`,`interface_data`.`last_edit_date` AS `last_edit_date`,`interface_data`.`last_edit_by` AS `last_edit_by`,`interface_data`.`financial_year_id` AS `financial_year_id`,`interface_data`.`report_period_quarter` AS `report_period_quarter`,`data_element`.`data_element_name` AS `data_element_name`,`report_form`.`report_form_id` AS `report_form_id`,`report_form_group`.`report_form_group_id` AS `report_form_group_id`,`interface_data`.`sub_county_name` AS `sub_county_name`,`interface_data`.`batch_id` AS `batch_id`,`interface_data`.`county_name` AS `county_name` from (((`interface_data` join `data_element` on((`interface_data`.`data_element_id` = `data_element`.`data_element_id`))) join `report_form` on((`report_form`.`report_form_id` = `data_element`.`report_form_id`))) join `report_form_group` on(((`report_form_group`.`report_form_id` = `report_form`.`report_form_id`) and (`report_form_group`.`report_form_group_id` = `data_element`.`report_form_group_id`)))) ; ;

-- ----------------------------
-- View structure for vw_location
-- ----------------------------
DROP VIEW IF EXISTS `vw_location`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `vw_location` AS SELECT
hf.health_facility_id,
hf.health_facility_name,
hf.parish_id,
p.parish_name,
hf.sub_county_id,
sc.sub_county_name,
hf.county_id,
c.county_name,
hf.district_id,
d.district_name,
hf.is_active AS hf_is_active,
p.is_active AS p_is_active,
d.is_active AS d_is_active
FROM health_facility hf 
inner join parish p on hf.parish_id=p.parish_id 
inner join sub_county sc on hf.sub_county_id=sc.sub_county_id 
inner join county c on hf.county_id=c.county_id 
inner join district d on hf.district_id=d.district_id ;
