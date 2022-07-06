# Mariadb-java-client UUID Bug


This repository aims to demonstrate the bug we discover while migrating from mariadb-java-client 2.7.1 to 3.0.5.

We store a `UUID` in a `BINARY(16)` column. We convert the UUID to a `byte[]` before writing. We convert back from `byte[]` to `UUID` when reading.

We migrated from Spring-boot 2.6.8 to Spring-boot 2.7.1. The new 2.7.1 version comes with `mariadb-java-connector:3.0.5.

With this new version, we have a `NumberFormatException` thrown when reading UUIDs from the DBs.
The UUID is correctly stored as byte[], but read as `String` in the JDBC ResultSet.

## How to reproduce
This repository contains a simple Entity, `EntityWithUuid`.
There is a Spring Data JDBC repository, `EntityWithUuidRepository` and its related test, `EntityWithUudRepositoryTest`.

To reproduce the issue:
* Launch the Mariadb service with this command:
``docker-compose up -d``
* Launch the test:
``./gradlew test``

Expected result: The test is successful.

Actual result: The test fails because of a `ConversionFailedException`


