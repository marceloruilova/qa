Prerequisitos:

Aquí describiremos las versiones de las dependencias, packages u otro tecnología que se debe tener configurado en su maquina.

Sistema Operativo: Windows 11 Home Single Language RAM: 16.0 GB PROCESSOR: 11th Gen Intel(R) Core(TM) i7-1165G7

IDE: IntelliJ IDEA 2024.1.4, se puede usar jetbrains toolbox para instalación.

Maven: 4.0.0

JDK: versión 17

ScreenPlay: 4.1.14

Comandos de instalación


INTELLIJ:
1. Dirigirse a la barra derecha y hacer click en la m (maven).
2. Clikear lifecycle y luego en install.

COMMANDOS(Para utilizar esta opción asegurarse de tener bien configuradas las variables de entorno,
deben estar configuradas el JAVA_HOME y MAVEN_HOME):
1. mvn clean (Para limpiar indexes, builds y archivos compilados)
2. mvn compile

Instrucciones para ejecutar los test

INTELLIJ:
1. Dirigirse a la barra derecha y hacer click en la m (maven).
2. Clikear lifecycle y luego en test.

COMMANDOS(Para utilizar esta opción asegurarse de tener bien configuradas las variables de entorno,
deben estar configuradas el JAVA_HOME y MAVEN_HOME):
https://mkyong.com/maven/how-to-install-maven-in-windows/
1. mvn clean (remueve el target, builds y componentes compilados).
2. mvn compile
3. mvn test (corre todos los tests sin interfaz gráfica)
4. mvn test -Dtest=CartRunner (corre el test CartRunner específico con interfaz gráfica)

REPORTES:
1. Se utilizó los reportes de serenity, para esto dirigirse a la carpeta /target/site/serenity/index.html
2. Para encontrar dicho archivo primero correr los siguientes comandos:
mvn compile
mvn test
mvn serenity:aggregate

Una mejor forma de probar y como yo la hice es dirigirse al archivo
CartRunner y al lado de public aparece un icono para correr el test o debugear

Información adicional

A tener en cuenta el agregar variables de entorno.
La mejor manera de testearlo es dirigiendose al archivo CartRunner.
Se puede utilizar headless para que los tests se ejecuten mas rapido.