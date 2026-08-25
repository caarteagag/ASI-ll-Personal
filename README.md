# ASI-ll

# Misión 5: Reflexión Arquitectónica

## 1. Cambio de base de datos

Si la tostaduría cambia la base de datos en memoria por PostgreSQL, tendría que modificar o reemplazar los adaptadores de infraestructura, por ejemplo `InMemoryInventoryAdapter` e `InMemoryOrderAdapter`, creando adaptadores que se conecten a PostgreSQL. También tendría que actualizar `Main` para configurar e inyectar esos nuevos adaptadores y, si fuera necesario, agregar la configuración de conexión y las dependencias correspondientes.

Se mantendrían intactos el dominio (`CoffeeBean`, `Order` y las excepciones), los puertos de entrada y salida (`ProcessCoffeeOrderUseCase`, `InventoryPort` y `OrderRepositoryPort`) y el caso de uso `ProcessCoffeeOrderService`, porque la lógica de negocio depende de interfaces y no de una base de datos concreta.

## 2. Independencia del caso de uso

Es importante que `ProcessCoffeeOrderUseCase` no conozca `InMemoryInventoryAdapter` porque el caso de uso pertenece a la aplicación y debe mantenerse independiente de los detalles de infraestructura. Al depender de `InventoryPort`, se puede cambiar el adaptador en memoria por uno de PostgreSQL sin modificar la lógica del pedido. Esto facilita el mantenimiento, las pruebas y la aplicación de la inversión de dependencias propia de la arquitectura hexagonal.

### 📝 Tus Respuestas Aquí:

Las respuestas se encuentran desarrolladas en los apartados anteriores.
