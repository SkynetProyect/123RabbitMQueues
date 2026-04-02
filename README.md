123+
<h1>How to connect a Webflux project with 2 databases </h1>
<h1>Como conectar un projecto java webflux a dos bases de datos </h1>

<p style="color: blue"> By Lenin Ospina L</p>
<p style="color: blue"> Software Engineer</p>
<p style="color: blue"> Medellin's University</p>

</br>

<p style="color: red"> straight forward !: </p>
All you need is the configuration inside of application/src...
/co/configuration

Here you will see a **DatabaseProperties** File, copy it, don't modify it.
Also there is a **MultiDatabaseConfig** file, here is the important \
To be able of connecting multiple databases to your backend you will have to define multiple beans, for each conection you will need a **ConnectionFactory** and a **R2dbcEntityTemplate**.

Good news, you don't need to configure it, it's already done, all you have to do is, for each ConnectionFactory, create another funcion with the name of your database variable defined in your application.properties. \
you can make the comparison watching line 45: 
<p style="color: pink">return createConnectionFactory("emergenciasdb");</p>
with my application.properties:
<p style="color: pink">spring.r2dbc.databases.emergenciasdb.url=r2dbc:postgresql://localhost:5433/emergenciasdb</p>

And for each **R2dbcEntityTemplate**, create another function and give
it any name you want as in line 48 (check MultiDatabaseConfig file).

Remember all templates must have its name.

To finish, we will have to create other files to let springboot (spring webflux in this case) know which repositorys will connect to your primary and secondary or third or seventeen database configuration.
For Each connection you will need a ${dbname}Config file,
check the EmergenciesDbConfig file.
All you have to do is create one of these files for each connection and define the route of your repositories, in basePackages, and define the template ( The same Bean name as in MultiDatabaseConfig) in entityOperationsRef.\
That's all.\
You're Welcome.

postman gets: 
- http://localhost:8080/citizens/all
- http://localhost:8080/emergencies/all

</br>

<h2 style="color: red"> Project information </h2>

this project have the connection with different queues i said will need in our project
It is build with hexagonal multi module architecture and SpringWebflux, this to allow me implement the best clean code rules and apply binary convertion
with graalvm at the end to have the fastest and cheapest executable possible.

some of you may not understand this architecture, specially if you are in Colombia, this is a little advanced for our current tech.
anyway its something easy to understand, let me know if you need a video explaining it.

this project allows to connect two databases at same time, you could connect more if needed changing configurations in gov.co.configuration folder





by Lenin Ospina Lamprea \
University Of Medellin \
Antioquia - Colombia 

<p style="color :red">Thanks to: </p> 
<a href=https://heromann.medium.com/how-to-configure-multiple-database-connections-in-spring-boot-reactive-applications-ff3e2087d1c5>these website</a>
for providing me a more accurate idea than claude and ChatGpt about how to do this.
Experienced coders will always be betters than AI.


</br>

PENDIENTES: 
- testear rabbitmq
- conectar flujos con solicitudes a bases de datos
- agregar rabbitmq en el docker compose
- conectar una base de datos no relacional
- binarizar con graalvm
