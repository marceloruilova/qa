# Prerequisitos

Aquí describiremos las versiones de las dependencias, paquetes u otras tecnologías que se deben tener configuradas en su máquina.

### Sistema Operativo
- **Windows 11 Home Single Language**

### RAM
- **16.0 GB**

### Procesador
- **11th Gen Intel(R) Core(TM) i7-1165G7**

### IDE
- **IntelliJ IDEA 2024.1.4**
    - Se puede usar [JetBrains Toolbox](https://www.jetbrains.com/toolbox-app/) para la instalación.

### Maven
- **4.0.0**

### JDK
- **Versión 17**

### ScreenPlay
- **Versión 4.1.14**

---

# Comandos de instalación

### IntelliJ:
1. Dirígete a la barra derecha y haz clic en la `m` (Maven).
2. Haz clic en `Lifecycle` y luego en `install`.

### Comandos
> **Nota:** Para utilizar esta opción, asegúrate de tener bien configuradas las variables de entorno `JAVA_HOME` y `MAVEN_HOME`.

1. `mvn clean` (Limpia índices, builds y archivos compilados)
2. `mvn compile`

---

# Instrucciones para ejecutar los tests

### IntelliJ:
1. Dirígete a la barra derecha y haz clic en la `m` (Maven).
2. Haz clic en `Lifecycle` y luego en `test`.

### Comandos
> **Nota:** Para utilizar esta opción, asegúrate de tener bien configuradas las variables de entorno `JAVA_HOME` y `MAVEN_HOME`. Puedes consultar [esta guía](https://mkyong.com/maven/how-to-install-maven-in-windows/) para más detalles.

1. `mvn clean` (Remueve el target, builds y componentes compilados)
2. `mvn compile`
3. `mvn test` (Ejecuta todos los tests sin interfaz gráfica)
4. `mvn test -Dtest=CartRunner` (Ejecuta el test `CartRunner` específico con interfaz gráfica)

---

# Reportes

1. Se utilizan los reportes de Serenity. Dirígete a la carpeta: `/target/site/serenity/index.html`
2. Para generar los reportes, primero ejecuta los siguientes comandos:
   ```sh
   mvn compile
   mvn test
   mvn serenity:aggregate
# Reportes con Cucumber-Reports

## Requisitos

1. Cuenta de GitHub para iniciar sesión en Cucumber Reports o una cuenta de Cucumber Reports.

## Funcionamiento

Para utilizar Cucumber Reports, sigue estos pasos:

1. **Exportar el token:**
    - Abre el terminal de Windows como administrador.
    - Haz clic en el menú de inicio, busca "cmd" o "terminal", haz clic derecho sobre él y selecciona "Ejecutar como administrador".
    - Navega a la carpeta donde se encuentra tu proyecto de testing usando el comando `cd`. Ejemplo:
      ```sh
      cd .\Desktop\ntt-data\qa
      ```
    - Exporta el token de Cucumber Reports con el siguiente comando:
      ```sh
      setx /M CUCUMBER_PUBLISH_TOKEN "tu-token"
      ```

2. **Ejecutar las pruebas:**
    - Ejecuta las pruebas con el comando:
      ```sh
      mvn test -Dtest=CartRunner
      ```
   > **Consideraciones:**
   > - Asegúrate de usar el terminal de comandos para estos pasos, ya que el IDE debe configurar sus propias variables de entorno.
   > - Los screenshots no se generarán desde el terminal del IDE por lo de la configuración; solo se generarán desde el terminal de comandos, sin importar si estás ejecutándolo como administrador o no.

3. **Ver los reportes:**
    - Los reportes se reflejarán en la página de Cucumber Reports.
