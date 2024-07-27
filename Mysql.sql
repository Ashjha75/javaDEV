# SHOW DATABASES ;
# SHOW TABLES;
# CREATE DATABASE IF NOT EXISTS walletDb;
# use walletDb;
#  SELECT * FROM users;
#     ----- check structure of table
#     DESCRIBE transactions;

#     ----------------------------------------------------------------** CREATE COMMANDS **-----------------------------------------------------
# CREATE TABLE IF NOT EXISTS users
# (
#     userId    INT AUTO_INCREMENT PRIMARY KEY,
#     userName  VARCHAR(255) UNIQUE NOT NULL,
#     password  VARCHAR(255)        NOT NULL,
#     email     VARCHAR(255) UNIQUE NOT NULL,
#     createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
#     updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
#     age       TINYINT UNSIGNED,
#     mobile    VARCHAR(15) UNIQUE  NOT NULL,
#     location  VARCHAR(255)        NOT NULL
# );
# CREATE TABLE IF NOT EXISTS transactions (
#     transactionId INT AUTO_INCREMENT PRIMARY KEY,
#     userId INT NOT NULL,
#     type ENUM('credit', 'debit') NOT NULL,
#     amount DECIMAL(10, 2) NOT NULL,
#     transactionDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
#     description VARCHAR(255),
#     FOREIGN KEY (userId) REFERENCES users(userId) ON DELETE CASCADE
# );
# CREATE TABLE IF NOT EXISTS wallets (
#     walletId INT AUTO_INCREMENT PRIMARY KEY,
#     userId INT NOT NULL,
#     balance DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
#     currency VARCHAR(3) NOT NULL,
#     createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
#     updatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
#     FOREIGN KEY (userId) REFERENCES users(userId) ON DELETE CASCADE
# );

# CREATE TABLE IF NOT EXISTS cards (
#     cardId INT AUTO_INCREMENT PRIMARY KEY,
#     userId INT NOT NULL,
#     cardNumber VARCHAR(16) UNIQUE NOT NULL,
#     cardHolderName VARCHAR(255) NOT NULL,
#     expiryDate DATE NOT NULL,
#     cvv SMALLINT NOT NULL,
#     createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
#     FOREIGN KEY (userId) REFERENCES users(userId) ON DELETE CASCADE
# );

# CREATE TABLE IF NOT EXISTS payments (
#     paymentId INT AUTO_INCREMENT PRIMARY KEY,
#     transactionId INT NOT NULL,
#     recipient VARCHAR(255) NOT NULL,
#     paymentMethod ENUM('wallet', 'card') NOT NULL,
#     status ENUM('pending', 'completed', 'failed') NOT NULL,
#     FOREIGN KEY (transactionId) REFERENCES transactions(transactionId) ON DELETE CASCADE
# );

#     ----------------------------------------------------------------** INSERT COMMANDS **-----------------------------------------------------

# INSERT into users(userId ,userName, password, email,  age, mobile, location)
# VALUES (3,'admin2', 'admin2', 'admin2@gmail.com', 25, '1324357890', 'India');
# SELECT  * FROM users;

# INSERT into transactions(userId, type, amount, description)
# VALUES (1, 'credit', 1000.00, 'Initial deposit');
# SELECT * FROM transactions;

# INSERT INTO wallets(userId, balance, currency)
# VALUES (1, 1000.00, 'USD');
# SELECT * FROM wallets;

# INSERT INTO cards(userId, cardNumber, cardHolderName, expiryDate, cvv)
# VALUES
# (1, '1234567890123456', 'John Doe', '2023-12-31', 123);
# SELECT * FROM cards;

# INSERT INTO payments(transactionId, recipient, paymentMethod, status)
# VALUES (1, 'John Doe', 'wallet', 'completed');
# SELECT * FROM payments;
















