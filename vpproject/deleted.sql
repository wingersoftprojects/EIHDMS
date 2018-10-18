CREATE TABLE base_data_deleted2 AS SELECT
base_data_deleted_id,
base_data_id,
batch_id,
data_element_id,
data_element_value,
health_facility_id,
parish_id,
sub_county_id,
county_id,
district_id,
financial_year_id,
report_period_month,
report_period_week,
report_period_year,
report_period_quarter,
report_period_from_date,
report_period_to_date,
is_deleted,
is_active,
add_date,
add_by,
last_edit_date,
last_edit_by,
report_period_bi_month,
report_form_id,
deleted_by,
delete_date,
report_form_group_id,
rec_id,
entry_mode,
"" AS district_name,
"" AS county_name,
"" AS sub_county_name,
"" AS parish_name,
"" AS health_facility_name,
"" AS section_name,
"" AS sub_section_name,
"" AS data_element_name,
"" AS data_element_context,
"" AS data_type,
"" AS data_size,
"" AS age_category,
"" AS sex_category,
"" AS other_category,
"" AS technical_area_name
FROM
base_data_deleted