# NodePad med Spring Boot och React.js ✨
front körs på port http://localhost:5000
backend  http://localhost:8080

##### Målet med projektet NodePad är att bygga och  utveckla en enkel applikation för att hantera uppgifter.
NodePad-applikationen som tillåter användaren  att lägga till en ny uppgift- event, redigera en event, ta bort en uppgift, visa alla uppgifter.
Systemet bestå av en serverdel som hanterar API-anrop  med hjälp  av ramverk som Spring Boot och en frontend byggd med  React.js (Javascript -bibliotek som används 
för att bygga webbgränssnitt).
Jag har använt en extra bibliotek Animate On Scroll Library för animation och Bootstrap.

Backend byggt på MVC design pattern (Model –View –Controller) är som separerar koden för data-modellen (M) från användargränssnitt (V och C).
Projektet använder DTO som står för Data Transfer Object, vilket är ett designmönster. Programmet använder service, model, repository.
 Service är en Java-klass som innehåller Business Logic, inkapsling av applikationsfunktionalitet.
Application använder Spring Boot CRUD Operations som GET,PUT,POST,DELETE.
Uppgifterna lagras i en enkel datastruktur som en ArrayList.
Projktet använder React.js som FrontEnd. Som innehåller Cards, Header,Home komponenter.Jag använder Axios bibliotek för att skicka HTTP-förfrågningar från nod.js.
Jag  skickar GET-, POST-, PUT- och DELETE-begäranden till en server med hjälp av Axios.

## Struktur 

BackEnd

1.  Model
   Note class med implementerande specifika attribut, getter/setter metoder
2.  Dto
NoteDto class med implementerande specifika attribut, getter/setter metoder
3.  Service
inkluderar interface NodeService och impementerande class NodeServiceImpl av NodeService med metoder
4.  Repository
inkluderar interface NodeRepository och impementerande class NoteRepositoryImpl av NodeRepository med metoder
5.  Interfaces:
 ett interface NodeRepository med metoder för att spara note, hitta alla,radera, redigera note.
 ett interface NodeService med metoder för att spara noteDTO, hitta alla,radera noteDTO, redigera enoteDTO.

FrontEnd
1. Componeter Cards.js
2. Header.js
3. Home.js
4. App.js med routers
5. style.css extra fil for css


## Att strarta applicationen
För att köra applicationen behövs installeras node.js och npm, bootstap , samt React.js, Spring Boot, Axios,IntellijIdea Ultimate Edition
>npm install -g npm
### Download and install nvm:
>curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.1/install.sh | bash
### Download and install Node.js:
>nvm install 22
### Verify the Node.js version:
>node -v # Should print "v22.12.0".
>nvm current # Should print "v22.12.0".
### Verify npm version:
>npm -v # Should print "10.9.0".
### Instalera React
Installing ReactJS 
Now that you have NodeJS and NPM installed, You should now be able to install ReactJS in your project's directory by running:

>npm install --save react react-dom

###Creating a ReactJS project:

Now that you have ReactJS installed, you can create a new react project directory by running:

>npx create-react-app my-react-project

Once you're inside a terminal window inside of this react project, you can finally run the following command to start a development server on "localhost:3000":

>npm start

### Instalera Bootstrap
>npm install react-bootstrap bootstrap
### installera Axios i ditt projekt 

>npm install axios

### installera Axos i ditt projekt 

> npm install aos --save

När projektet oppnas, i projektverktygsfönstret  leta upp källan | main | java | NodePadApplication. java-filen och öppna den i editorn/ IntelliJIdea. I redigeraren klickar du på rännstensikonen för att köra programmet och väljer Kör 'NodePadApplication. main()'.
Att starta fronend  leta upp källan FrontNodePade->front->package.json sen välja man start.

## Hur man skickar en GET-begäran i JavaScript med hjälp av Axios
För att skicka en GET-begäran med hjälp av Axios så behöver du bara skicka in webbadressen till metoden get(), som returnerar ett
löfte. Svaret som returneras från löftet kan nås med hjälp av metoden then().
Låt oss se ett exempel:
 > axios.get("http://localhost:8080/getAllNote").then((response) => {const notes = response.data
setNotes(notes) })
