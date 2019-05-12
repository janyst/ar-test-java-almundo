Consigna:
Existe un call center donde hay 3 tipos de empleados: operador, supervisor y director. El proceso
de la atención de una llamada telefónica en primera instancia debe ser atendida por un operador,
si no hay ninguno libre debe ser atendida por un supervisor, y de no haber tampoco supervisores
libres debe ser atendida por un director.

Solución del desarrollador:
Para la atención del cliente se crearon dos clases, denominadas “AttentionClient, WaitClient” cada
clase tiene funcionalidades distintas, pero la principal es dormir el hilo, ya sea porque el cliente
está siendo atendido por un empleado o en espera. Por otro lado, sí el cliente no pudo ser
atendido, este queda en tiempo de espera (5 segundos) y tres reintentos, de no ser atendido se
colgará la llamada.

- Las clases desarrollados son:
o AttentionClient (sí entra a esta clase el cliente ha sido atendido por un empleado;
posee la lógica de negocio para liberar un empleado).
o WaitClient (sí entra a esta clase, el cliente está en espera para ser atendido).
o CountDTO (posee campos de configuración tales como: pool de empleados
disponibles/ocupados, cantidad de llamadas a recibir, máxima cantidad de llamas).
o Dispatcher (tiene la lógica de negocio para asignar llamadas a empleados
disponibles).
o Constant (contantes utilizadas en el codigo).