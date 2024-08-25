-- Insert records into the Member table with references to the Content records
INSERT INTO Members (Firstname, Lastname, Password, Phone, Email, Description, created_date, update_time) VALUES ('John', 'Doe', 'password1', '1234567890', 'john.doe1@example.com', 'Description 1', '2023-10-01', '2023-10-01');
INSERT INTO Members (Firstname, Lastname, Password, Phone, Email, Description, created_date, update_time) VALUES ('Jane', 'Doe', 'password2', '1234567891', 'jane.doe2@example.com', 'Description 2', '2023-10-02', '2023-10-02');
INSERT INTO Members (Firstname, Lastname, Password, Phone, Email, Description, created_date, update_time) VALUES ('Jim', 'Beam', 'password3', '1234567892', 'jim.beam3@example.com', 'Description 3', '2023-10-03', '2023-10-03');
INSERT INTO Members (Firstname, Lastname, Password, Phone, Email, Description, created_date, update_time) VALUES ('Jack', 'Daniels', 'password4', '1234567893', 'jack.daniels4@example.com', 'Description 4', '2023-10-04', '2023-10-04');
INSERT INTO Members (Firstname, Lastname, Password, Phone, Email, Description, created_date, update_time) VALUES ('Johnny', 'Walker', 'password5', '1234567894', 'johnny.walker5@example.com', 'Description 5', '2023-10-05', '2023-10-05');

-- Insert records into the Content table
INSERT INTO Content (Title, Brief, ContentText, createddate, updatedtime, author_id) VALUES ('Title 1', 'Brief 1', 'Content 1', '2023-10-01', '2023-10-01', 1);
INSERT INTO Content (Title, Brief, ContentText, createddate, updatedtime, author_id) VALUES ('Title 2', 'Brief 2', 'Content 2', '2023-10-02', '2023-10-02', 1);
INSERT INTO Content (Title, Brief, ContentText, createddate, updatedtime, author_id) VALUES ('Title 3', 'Brief 3', 'Content 3', '2023-10-03', '2023-10-03', 1);
INSERT INTO Content (Title, Brief, ContentText, createddate, updatedtime, author_id) VALUES ('Title 4', 'Brief 4', 'Content 4', '2023-10-04', '2023-10-04', 1);
INSERT INTO Content (Title, Brief, ContentText, createddate, updatedtime, author_id) VALUES ('Title 5', 'Brief 5', 'Content 5', '2023-10-05', '2023-10-05', 1);