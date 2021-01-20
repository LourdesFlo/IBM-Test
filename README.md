# IBM-Test

##Toma de decisiones
Se decide no utilizar BBDD 'MySQL' por no tenerlo instalado. Se opta por la utilización de una BBDD en memoria 'h2'. Se crea una única tabla 'Provider' y se delega en spring data la responsabilidad de generar la tabla si no existe.

##Ejecución del programa
Basta con ejecutar el jar generado al hacer 'mvn install' indicando el código de cliente (parámetro) con el que se realiza la consulta.

El fichero plano se almacena en la misma ruta en la que se encuentra el jar ejecutado.

Se han utilizado dependencias jpa y h2 para la gestión de la BBDD en memoria.

Las consultas se realizan a través de un servicio que llama al repositorio encargado de hacer las consultas a BBDD.

Para la generación del fichero, simplemente se ha hecho uso de FileWriter.
