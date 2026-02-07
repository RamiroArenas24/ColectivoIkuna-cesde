Documentación de la API (Backend)
 URL Base
El backend corre por defecto en el puerto 8080.

http://localhost:8080/api/
1. Autenticación (Admin)
Gestión de acceso al panel administrativo.

Iniciar Sesión
Método: POST

Endpoint: /admin/login

Body (JSON):

JSON
{
"username": "admin",
"password": "ikuna2024"
}
Inicializar Sistema (Primer Admin)
Método: POST

Endpoint: /admin/init

Descripción: Crea el usuario admin si la base de datos está vacía.

2. Gestión de Usuarios (Admin Panel)
Endpoints para gestionar el acceso de colaboradores.

Obtener Solicitudes Pendientes
Método: GET

Endpoint: /admin/users/pending

Respuesta (JSON Array):

JSON
[
{
"id": 1,
"fullName": "Carlos Ruiz",
"email": "carlos@ikuna.com",
"username": "cruiz",
"role": "COLLABORATOR",
"status": "PENDING",
"requestDate": "2024-02-06"
}
]
Obtener Usuarios Activos
Método: GET

Endpoint: /admin/users/active

Respuesta: Mismo formato que el anterior.

Registrar Nuevo Usuario (Solicitud)
Método: POST

Endpoint: /admin/users/register

Body (JSON):

JSON
{
"fullName": "María González",
"email": "maria@ikuna.com",
"username": "mgonzalez",
"password": "PasswordSeguro123",
"role": "COLLABORATOR"
}
Nota: El campo role es opcional (por defecto es COLLABORATOR). El status se asigna automáticamente como PENDING.

Aprobar Usuario
Método: PATCH

Endpoint: /admin/users/{id}/approve

Ejemplo: /admin/users/5/approve

Rechazar Usuario
Método: DELETE

Endpoint: /admin/users/{id}/reject

Ejemplo: /admin/users/5/reject

3. Gestión de Proyectos (Ikuna)
Gestión del portafolio cultural.

Obtener Portafolio
Método: GET

Endpoint: /ikuna/portfolio

Crear Proyecto
Método: POST

Endpoint: /ikuna/projects

Body (JSON):

JSON
{
"title": "Festival de Teatro 2024",
"category": "Eventos",
"status": "in-progress",
"progress": 20,
"date": "2024-11-15",
"description": "Evento principal del año",
"imageUrl": "https://url-imagen.com",
"teamMembers": [
{ "name": "Ana", "email": "ana@ikuna.com", "role": "Líder" }
],
"tasks": [
{
"title": "Logística",
"assignedTo": "Ana",
"startDate": "2024-10-01",
"endDate": "2024-10-05",
"status": "pending"
}
]
}
Actualizar Proyecto
Método: PUT

Endpoint: /ikuna/projects/{id}

Body: Debe enviarse el objeto completo (igual al de crear), ya que reemplaza la información anterior.