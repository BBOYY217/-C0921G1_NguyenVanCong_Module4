-- DROP DATABASE IF EXISTS furama;
USE furama;

INSERT INTO education_degree (education_degree_name)
VALUES
('Trung cấp'),
('Cao đẳng'),
('Đại học'),
('Sau đại học');

INSERT INTO position (position_name)
VALUES
('Lễ tân'),
('Phục vụ'),
('Chuyên viên'),
('Giám sát'),
('Quản lý'),
('Giám đốc');

INSERT INTO division (division_name)
VALUES
('Sale - Marketing'),
('Hành chính'),
('Phục vụ'),
('Quản lý');

INSERT INTO customer_type (customer_type_name)
VALUES
('Diamond'),
('Platinium'),
('Gold'),
('Silver'),
('Member');

INSERT INTO service_type (service_type_name)
VALUES
('Villa'),
('House'),
('Room');

-- INSERT INTO users(username,passwords)
-- VALUES
-- ("ThiA","12345"),
-- ("ThiB","12345"),
-- ("ThiC","12345"),
-- ("ThiD","12345"),
-- ("ThiF","12345");

INSERT INTO customer(customer_type_id ,customer_name ,customer_birth ,customer_gender ,customer_id_card,
					customer_phone ,customer_email ,customer_address)
VALUES
("1","Nguyen Van A" ,"1999/03/12","nu","3456","123456789","VanA@gmail.com","DN"),
("1","Nguyen Van B" ,"1998/04/01","nam","3456","123456789","VanB@gmail.com","HN"),
("3","Nguyen Van C" ,"1997/01/23","nam","3456","123456789","VanC@gmail.com","QB"),
("4","Nguyen Van D" ,"1996/05/15","nu","3456","123456789","VanD@gmail.com","HA"),
("2","Nguyen Van F" ,"1995/06/09","nu","3456","123456789","VanF@gmail.com","SG");

INSERT INTO employee(employee_name ,employee_birth ,employee_id_card ,employee_salary ,employee_phone ,
					employee_email ,employee_address, flag, position_id, education_degree_id, division_id )
VALUES
("Tran Thi A","2001/04/12","1234","5000.0","987654321","ThiA@gmail.com","DN",0,"1","3","2"),
("Tran Thi B","2002/07/01","1234","5000.0","987654321","ThiB@gmail.com","HN",0,"2","3","2"),
("Tran Thi C","1998/06/20","1234","5000.0","987654321","ThiC@gmail.com","QN",0,"4","3","2"),
("Tran Thi D","2003/09/25","1234","5000.0","987654321","ThiD@gmail.com","NT",0,"3","3","2"),
("Tran Thi F","1999/12/15","1234","5000.0" ,"987654321","ThiF@gmail.com","VT",0,"5","3","3");

INSERT INTO rent_type(rent_type_name,rent_type_cost)
VALUES
("Giờ"  ,"100000.0"),
("Ngày" ,"1000000.0"),
("tháng","10000000.0"),
("Năm"  ,"100000000.0");
