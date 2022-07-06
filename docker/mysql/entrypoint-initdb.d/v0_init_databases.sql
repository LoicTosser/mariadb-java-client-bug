CREATE DATABASE IF NOT EXISTS `test_mariadb_client`
CHARACTER SET latin1 COLLATE latin1_swedish_ci; -- The default charset in prod. It is overriden in all tables.

USE `test_mariadb_client`;
SOURCE /docker-entrypoint-initdb.d/create_tables;