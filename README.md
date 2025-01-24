LibraryV2 med Spring Boot och Hibernate,Apache Freemarker ✨
applications körs på port http://localhost:8083/

Målet med projektet LibraryV2 är att bygga och utveckla en enkel applikation för att hantera uppgifter.
LibraryV2-applikationen som tillåter användaren att låna en book, lämna tillbaka, sortera böcker på category, visa alla uppgifter.

Backend byggt på MVC design pattern (Model –View –Controller) är som separerar koden för data-modellen (M) från användargränssnitt (V och C). Projektet använder DTO som står för Data Transfer Object, vilket är ett designmönster. Programmet använder service, model, repository,transformer. Service är en Java-klass som innehåller Business Logic, inkapsling av applikationsfunktionalitet. Application använder Spring Boot Security att hantera inloggning-registration. Uppgifterna lagras i en enkel databas MySql med Docker-compose. Projktet använder Hibarnate ORM för att hantera SQL requester.

Att starta applicationen
För att köra applicationen behövs installeras IntellijIdea Ultimate Edition, Docker. Man starta services i docker-compose.yml fil. Database library.sql finns i folder sql i resources.

När projektet oppnas, i projektverktygsfönstret leta upp källan | main | java | LibraryV2Application. java-filen och öppna den i editorn/ IntelliJIdea. applications körs på port http://localhost:8083/
