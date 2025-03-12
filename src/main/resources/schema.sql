CREATE TABLE IF NOT EXISTS USERS (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name varchar(250) NOT NULL,
    last_name varchar(250) NOT NULL,
    username varchar(250) UNIQUE NOT NULL,
    email varchar(50) UNIQUE NOT NULL,
    password varchar(250) NOT NULL,
    roles varchar(250) not null,
    enabled BOOLEAN NOT NULL
);

insert
into
    users
(email, enabled, first_name, last_name, password, roles, username, user_id)
values
    ('admin@gmail.com', true, 'admin', 'admin', '$2a$10$/B44UB93wY.gaqXwmbR5x.BOqD2Q2HgnPE8L3zk/95nwWb4ylE1Ea', 'ROLE_ADMIN', 'admin', default);

insert
into
    users
(email, enabled, first_name, last_name, password, roles, username, user_id)
values
    ('tenchev@gmail.com', true, 'Tsvetelin', 'Enchev', '$2a$10$4RFb.wFhnBDwXQpsFjhIE.DxGN3cYeCBgkzdafjX41Wng693sCrH6', 'ROLE_USER', 'tenchev', default);

insert
into
    users
(email, enabled, first_name, last_name, password, roles, username, user_id)
values
    ('ipetkov@gmail.com', true, 'Ivan', 'Petkov', '$2a$10$4RFb.wFhnBDwXQpsFjhIE.DxGN3cYeCBgkzdafjX41Wng693sCrH6', 'ROLE_USER,ROLE_HOTELIER', 'ipetkov', default);


CREATE TABLE Hotels (
    hotel_id INT AUTO_INCREMENT PRIMARY KEY,
    owner VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    rating DECIMAL(3,2),
    description TEXT,
    email VARCHAR(255),
    phone VARCHAR(20)
);

INSERT INTO Hotels (owner, name, address, city, country, rating, description, email, phone)
VALUES ('ipetkov','Grand Hotel', '123 Main St', 'Sofia', 'Bulgaria', 4.5, 'Luxurious hotel in the heart of the city.', 'info@grandhotel.com', '+359123456789');

CREATE TABLE Rooms (
                       room_id INT AUTO_INCREMENT PRIMARY KEY,
                       hotel_id INT NOT NULL,
                       room_number INT NOT NULL,
                       room_type VARCHAR(100) NOT NULL,
                       price_per_night DECIMAL(10,2) NOT NULL,
                       capacity INT NOT NULL,
                       amenities TEXT,
                       is_available BOOLEAN DEFAULT TRUE,
                       FOREIGN KEY (hotel_id) REFERENCES Hotels(hotel_id) ON DELETE CASCADE
);

INSERT INTO Rooms (hotel_id, room_number, room_type, price_per_night, capacity, amenities)
VALUES (1, 1,'Double Room', 150.00, 2, 'Free WI-FI / AC / Parking');

INSERT INTO Rooms (hotel_id, room_number, room_type, price_per_night, capacity, amenities)
VALUES (1, 2,'Double Room', 150.00, 2, 'Free WI-FI / AC / Parking');

INSERT INTO Rooms (hotel_id, room_number, room_type, price_per_night, capacity, amenities)
VALUES (1, 3,'Double Room', 150.00, 2, 'Free WI-FI / AC / Parking');

INSERT INTO Rooms (hotel_id, room_number, room_type, price_per_night, capacity, amenities)
VALUES (1, 4,'Apartment', 250.00, 4, 'Free WI-FI / AC / Parking');

INSERT INTO Rooms (hotel_id, room_number, room_type, price_per_night, capacity, amenities)
VALUES (1, 5,'Apartment', 250.00, 4, 'Free WI-FI / AC / Parking');

CREATE TABLE Bookings (
                          booking_id INT AUTO_INCREMENT PRIMARY KEY,
                          user_id INT NOT NULL,
                          hotel_id INT NOT NULL,
                          room_id INT NOT NULL,
                          check_in_date DATE NOT NULL,
                          check_out_date DATE NOT NULL,
                          total_price DECIMAL(10,2) NOT NULL,
                          status VARCHAR(50) DEFAULT 'pending',
                          FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
                          FOREIGN KEY (hotel_id) REFERENCES HOTELS(hotel_id) ON DELETE CASCADE,
                          FOREIGN KEY (room_id) REFERENCES Rooms(room_id) ON DELETE CASCADE
);

-- INSERT INTO Hotels (name, address, city, country, star_rating, description, contact_email, contact_phone)
-- VALUES ('Grand Hotel', '123 Main St', 'Sofia', 'Bulgaria', 4.5, 'Luxurious hotel in the heart of the city.', 'info@grandhotel.com', '+359123456789');
--
-- INSERT INTO Rooms (hotel_id, room_type, price_per_night, capacity, amenities)
-- VALUES (1, 'Double Room', 150.00, 2, '{"wifi": true, "tv": true, "breakfast": true}');
--
-- INSERT INTO Rooms (hotel_id, room_type, price_per_night, capacity, amenities)
-- VALUES (1, 'Double Room', 150.00, 2, '{"wifi": true, "tv": true, "breakfast": true}');
--
-- INSERT INTO Rooms (hotel_id, room_type, price_per_night, capacity, amenities)
-- VALUES (1, 'Double Room', 150.00, 2, '{"wifi": true, "tv": true, "breakfast": true}');
--
-- INSERT INTO Rooms (hotel_id, room_type, price_per_night, capacity, amenities)
-- VALUES (1, 'Apartment', 250.00, 4, '{"wifi": true, "tv": true, "breakfast": true}');
--
-- INSERT INTO Rooms (hotel_id, room_type, price_per_night, capacity, amenities)
-- VALUES (1, 'Apartment', 250.00, 4, '{"wifi": true, "tv": true, "breakfast": true}');
--
--
--
--
--
--
-- INSERT INTO Bookings (user_id, room_id, check_in_date, check_out_date, total_price)
-- VALUES (1, 1, '2023-10-15', '2023-10-20', 750.00);
--
-- INSERT INTO Offers (hotel_id, room_id, discount_percent, start_date, end_date)
-- VALUES (1, 1, 10.00, '2023-10-01', '2023-10-31');