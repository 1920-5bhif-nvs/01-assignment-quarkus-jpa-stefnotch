# 01-assignment-quarkus-jpa-stefnotch
[Open in browser](http://localhost:8080)

Oh yeah, hot reloading is broken on Windows https://github.com/quarkusio/quarkus/issues/3592


TODO: https://quarkus.io/guides/hibernate-orm-panache-guide
## Quarkus setup
https://code.quarkus.io/

By the way, `@Stateless` isn't a thing in Quarkus. 

To get Json serialisation to work, you can add the following to the `pom.xml`
```
<dependency>
  <groupId>io.quarkus</groupId>
  <artifactId>quarkus-resteasy-jsonb</artifactId>
</dependency>
```
[Source](https://stackoverflow.com/a/56656851)

## Database starting (PostgreSQL)
```
D:/opt/pgsql/bin/pg_ctl.exe --pgdata=db start
```
And kill it with CTRL+C 
Or use
```
D:/opt/pgsql/bin/pg_ctl.exe --pgdata=db stop
```

## Database setup (PostgreSQL)

Create a database
```
D:\opt\pgsql\bin\initdb.exe --auth=trust --pgdata=db
```

Add some stuff to your `pom.xml`
```xml
<!-- Database stuff -->
<!-- Hibernate ORM specific dependencies -->
<dependency>
  <groupId>io.quarkus</groupId>
  <artifactId>quarkus-hibernate-orm</artifactId>
</dependency>

<!-- JDBC driver dependencies -->
<dependency>
  <groupId>io.quarkus</groupId>
  <artifactId>quarkus-jdbc-postgresql</artifactId>
</dependency>
```

And configure the database `src/main/resources/application.properties`
```
# configure your datasource
quarkus.datasource.url = jdbc:postgresql://localhost:5432/postgres
quarkus.datasource.driver = org.postgresql.Driver

# drop and create the database at startup (use `update` to only update the schema)
quarkus.hibernate-orm.database.generation=drop-and-create
```
[Source](https://quarkus.io/guides/hibernate-orm-guide)

## OpenAPI / Swagger

```
"./mvnw" quarkus:add-extension -Dextensions="openapi"
```

Then open [localhost:8080/openapi](http://localhost:8080/openapi) in your browser to see the schema. 
If you want to check out the Swagger UI, open [localhost:8080/swagger-ui](http://localhost:8080/swagger-ui).
The Swagger UI is only visible in development mode.

Do note that it's currently buggy and ignores inherited stuff.

[Source](https://quarkus.io/guides/openapi-swaggerui-guide)