create table Dealer
(
dealer_Id int IDENTITY(1,1) primary key,
company_Name varchar(30),
image_Id int,
dealer_Name varchar(30) not null,
username varchar(30) not null unique,
password varchar(30) not null,
contactnumber varchar(30),
address text
)
DROP DATABASE carhub
select * from order_details
select * from customer where customer_Nid='1234' and password='1234'
select * from dealer where exists (select * from dealer where username='12345' and password='12345')
delete from dealer where dealerid>=1

insert into Dealer(company_Name,dealer_Name, username, password,
contactnumber, address) values
('Honda Motors', 'Nipun Paul', '12345', '12345', '01778546619', 'Netrokona'),
('A Motors', 'Pranto', 'pranto123', 'password123', '01630674766', 'Mymensingh'),
('ABC Motors', 'Ishmam', 'mumdum', 'asdf123', '01991949048', 'Chittagong')

create table Services
(
service_Id int IDENTITY(1,1) primary key,
showroom_Id int,
dealer_Id int,
service_Type varchar(30) not null unique,
service_Desc text not null,
service_Cost decimal(12,2) not null,
available varchar(30) not null,
foreign key(dealer_Id) references Dealer on delete set null,
foreign key(showroom_Id) references Showroom on delete set null
)

insert into Services( service_Type, service_Desc, service_Cost, available) values
( 'Paint', '3D vinyl, Blue', 6000, 'Yes'),
( 'Wheels', 'added new wheels and rims', 12000, 'No')	

create table Vehicle
(
vehicle_Id int IDENTITY(1,1) primary key,
dealer_Id int,
vehicle_Name varchar(50) not null,
vehicle_Model varchar(50) not null,
vehicle_Type varchar(30) not null,
vehicle_Description text not null,
vehicle_Cost decimal(12,2) not null,
vehicle_Quantity decimal(12,2) not null,
showroom_Id int,
builddate date not null,
imageid int,
emi_available int not null,
foreign key(dealer_Id) references Dealer on delete set null,
foreign key(showroom_Id) references Showroom on delete set null
)

insert into Vehicle(vehicle_Name, vehicle_Model, vehicle_Type, vehicle_Description,
vehicle_Cost, vehicle_Quantity, builddate, emi_available) values
('Porche', '911 Carrera 4S 2021', '4 seater Coupe','2021 Porsche 911 Carrera 4S is a new-released 4-seater Coupe in Bangladesh, working on All Wheel Drive Engine. The car arrives with 8-speed automatic transmission, It has a more powerful and more efficient engine giving 443 horsepower, 390 lb ft torque.' , 10281600, 3, '2021-01-10', 12),
('BMW', 'M3', '5 seater Sedan','The car arrives with 6-speed Manual transmission, 473 horsepower, 406 lb ft torque, and Rack-Pinion Steering. Gas is primary fuel of BMW M3 and the fuel tank capacity is 15.6 gallons. BMW M3 gives 16 Mileage in City and 23 Mileage on Highway. Inside the car, there is a powerful 3.0-liter Twin-Turbo Inline-6 Gas engine. You are getting 13 ft trunk volume. Front and Rear Suspensions are Strut and Multi-link, respectively. The BMW car comes with Aluminum Wheels of the size, 18" x 9.5" front and 19" x 10.5" back. The tire size of BMW M3 is P275/40YR18 front and P285/35YR19 back. Co2 emission rate of BMW M3 is 15mi  per year (9.3 tons per year). You can buy BMW M3 2021 in following gorgeous colors, Alpine White, Sao Paulo Yellow, Black Sapphire Metallic, Brooklyn Grey Metallic, Frozen Brilliant White Metallic, Frozen Portimao Blue Metallic, Individual Dravit Grey Metallic, Isle of Man Green Metallic, Oxide Grey Metallic, Portimao Blue Metallic, Tanzanite Blue II Metallic, and Toronto Red Metallic.' , 5871600, 2, '2021-01-10', 12),
('Mercedes', 'AMG G63 SUV 2021', 'SUV','4.0L Twin-Turbo V8 Gas Engine, and All-Wheel Drive 9-speed automatic transmission. It is working on Rack-Pinion Steering, and Front independent double-wishbone/rear rigid axle with coil springs, AMG RIDE Suspensions. The Turning Diameter is 44.3 ft. The vehicle comes with 5 Leather Seats and 26.4 gallons of Fuel Tank Capacity. Coming to performance, It has a more powerful and more efficient engine giving 577 horsepower at 6000 rpm and 627 lb-ft torque at 2500 pm. The Mercedes AMG G63 travels for 13 Mileage in the City, 16 Mileage on the Highway, and 14 Mileage of Combine. The rate of Co2 emission is 12.6 Tons per Year.' , 13141800, 8, '2021-01-10', 12)


create table Accessories
(
accessories_Id int IDENTITY(1,1) primary key,
dealer_Id int,
showroom_Id int,
accessories_Name varchar(50) not null,
brand_Name varchar(50) not null,
accessories_Desc text not null,
accessories_Cost decimal(12,2) not null,
accessories_Quantity decimal(12,2) not null,
builddate date not null,
imageid int,
foreign key(dealer_Id) references Dealer on delete set null,
foreign key(showroom_Id) references Showroom on delete set null
)

insert into Accessories(accessories_Name, brand_Name, accessories_Desc, accessories_Cost, accessories_Quantity, builddate) values
('Mounted Seat', 'Trust Automobiles', 'Mounting Seat for Toyota G- Corolla , X – Corolla, Fielder (Allion Premio 2001-2006)', 5500, 3, '2020-12-12'),
('3D Multicolor Vinyl', 'Tut Kote Automotive Pvt Ltd.', '3D, Matt, Wraps - approx 1.22m ht x 20m, applicable in any brand cars', 4000, 20, '2020-03-03')


create table Showroom
(
showroom_Id int IDENTITY(1,1) primary key,
dealer_Id int,
showroom_Name varchar(50) not null,
showroom_Capacity int not null,
has_Vehicle int,
imagepath varchar(100),
contactno varchar(30) not null,
address text not null,
foreign key(dealer_Id) references Dealer on delete set null
)

insert into Showroom(showroom_Name, contactno,showroom_Capacity,
address) values
('Honda Motors','01778546619',100, 'Netrokona'),
('A Motors','01630674766',100, 'Mymensingh'),
('ABC Motors','01991949048',100, 'Chittagong')


create table Showroom_expense
(
expense_Id int IDENTITY(1,1) primary key,
showroom_Id int,
expense_Type varchar(30) not null,
expense_Desc text not null,
expense_Cost decimal(12,2) not null,
entrydate datetime not null,
foreign key(showroom_Id) references Showroom on delete set null
)
insert into Showroom_expense(showroom_Id, expense_Type, expense_Desc, expense_Cost, entrydate) values
('1', 'current bill', 'Current bill of 2 months', 12000, '2020-03-01'),
('1', 'window reparir', '1 broken window', 5000, '2020-02-28')


create table Customer
(
customer_Nid varchar(30) not null primary key,
customer_Name varchar(30) not null,
password varchar(30) not null,
vehicle_Id int,
accessories_Id int,
service_Id int,
contactno varchar(30) not null,
email varchar(30) not null unique,
address text not null,
foreign key(vehicle_Id) references Vehicle on delete set null,
foreign key(accessories_Id) references Accessories on delete set null,
foreign key(service_Id) references Services on delete set null
)

insert into Customer(customer_Nid,customer_Name,password, contactno, email, address) values
('1234','James Hetfield','1234', '011420420', 'jameshetfield@mail.com', 'Dhaka'),
('123','Light Yagami','1234', '013420420', 'yagamilight@deathmail.com','Chittagong')

create table Order_Details
(
order_Id varchar(255),
order_Type varchar(30) not null,
type_Id int not null,
customer_Nid varchar(30),
showroom_Id int,
cost decimal(12,2) not null,
order_date date not null,
delivery_date date not null,
description text,
emi_Check varchar(30) not null,
emi_Months int,
cost_Given decimal(12,2) not null,
foreign key(customer_Nid) references Customer on delete set null,
foreign key(showroom_Id) references Showroom on delete set null
)

create table Order_items
(
orderitems_Id int IDENTITY(1,1) primary key,
order_Id int,
item_Id int,
item_Name text,
item_Quantity int,
cost decimal(12,2) not null,
foreign key(order_ID) references Order_Details on delete set null
)

select * from Sales
