
# Proyecto Calculadora

Este es un proyecto de microservicio de calculadora construido con Maven y Spring Boot.

## Dependencias

Este proyecto incluye las siguientes dependencias:

1. **Spring Web**: Esta dependencia es necesaria para construir aplicaciones web con Spring Boot, incluyendo aplicaciones RESTful usando Spring MVC.

2. **Spring Boot DevTools**: Esta dependencia proporciona herramientas de desarrollo automáticas, como el recargado automático de la aplicación siempre que se realicen cambios en los archivos.

3. **Lombok**: Esta dependencia es una biblioteca de Java que ayuda a reducir el código boilerplate en el código Java, como los métodos getter, setter, constructores, etc.

4. **Spring Boot Test**: Esta dependencia se utiliza para facilitar la prueba de los componentes de la aplicación Spring Boot. Proporciona anotaciones y clases de utilidad para escribir pruebas.

Por favor, consulte el `pom.xml` para obtener una lista completa de las dependencias utilizadas en este proyecto.

## Pasos

1.**primer paso**: 
Voy a desarrollar el controlador y el servicio.Este enfoque me permitirá tener el núcleo de la aplicación en funcionamiento 
y probar rápidamente el microservicio.
2.**segundo paso**: 
Implementar la arquitectura con el servicio y la configuración para el tracer.
3.**tercero paso**: 
Hacer la classe de pueba.

## Compilación y Empaquetado

Para compilar y empaquetar la aplicación, sigue estos pasos:

1. **Abre una terminal en el directorio raíz del proyecto.**
2. **Ejecuta el siguiente comando**:
bash
mvn clean install

Ejecución
Para ejecutar la aplicación, sigue estos pasos:

3.**Asegúrate de que la compilación se ha realizado con éxito y que el archivo JAR está en el directorio target.
Ejecuta el siguiente comando**:
bash
Copy code
java -jar target/nombre-del-archivo.jar
O también puedes lanzar la ejecución desde el método main de tu aplicación.

4.**Pruebas con el API
Puedes probar el API con los siguientes comandos curl o directamente desde tu navegador (ya que los endpoints utilizan el método GET)**:
curl:
curl "http://localhost:8080/calculadora/sumar?num1=5&num2=3"
curl "http://localhost:8080/calculadora/restar?num1=5&num2=3"

Componentes de la aplicación:

La aplicación se compone de los siguientes elementos:

Compartimentación: Cada componente de la aplicación ha sido dividido y compartimentado para asegurar una buena organización del código.

Gestión de excepciones: Se han adoptado dos enfoques para la gestión de excepciones. El primero consiste en utilizar un servicio dedicado para manejar múltiples excepciones con precisión. El segundo enfoque utiliza directamente una clase personalizada, lo cual es más adecuado para una arquitectura de menor escala que requiere mensajes precisos.

Servicios: Los servicios han sido diseñados con varios métodos específicos en lugar de un método general. Este enfoque facilita el mantenimiento y escalabilidad del código, ya que solo se necesita agregar nuevas funcionalidades como operaciones individuales, como la división.

Pruebas: Se han implementado pruebas que cubren el 84% del código. Esto garantiza una buena cobertura de las funcionalidades y contribuye a la calidad general del software.

Configuración del rastreador: Se ha configurado el rastreador para llamar al método en el archivo JAR utilizando Spring Boot. Esto permite mantener un registro de cada operación realizada en la aplicación.