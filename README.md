El backend corre por defecto en el puerto 8080 --> url base http://localhost:8080/api

Endpoints:

1. Autenticación (Admin):
Gestión de acceso para el panel administrativo.

Inicializar Super Admin
Crea el usuario administrador por defecto si la base de datos está vacía (admin / ikuna2024).

Método: POST

Endpoint: /api/admin/init

Body: (Vacío)

Iniciar Sesión:
Verifica credenciales y retorna los datos del usuario.

Método: POST

Endpoint: /api/admin/login

Body (JSON):

JSON
{
  "username": "admin",
  "password": "ikuna2024"
}


-----------------------------------------------------------------------------
2. Gestión Ikuna (Proyectos)
Endpoints para listar, crear y editar el portafolio cultural.

Obtener Portafolio (Todos los proyectos)
Trae la lista completa de proyectos con sus tareas y miembros.

Método: GET

Endpoint: /api/ikuna/portfolio

Body: (Vacío)

Crear Nuevo Proyecto
Registra un nuevo proyecto cultural. Puedes enviar tareas y miembros al mismo tiempo.

Método: POST

Endpoint: /api/ikuna/projects

Body (JSON):

JSON
{
  "title": "Festival Cultural Ikuna 2024",
  "category": "Eventos",
  "status": "in-progress",
  "progress": 35,
  "date": "2024-10-20",
  "description": "Celebración anual de la cultura local con artistas invitados.",
  "imageUrl": "https://images.unsplash.com/photo-festival.jpg",
  "teamMembers": [
    {
      "name": "María González",
      "email": "maria@ikuna.com",
      "role": "Coordinadora General"
    },
    {
      "name": "Carlos Ruiz",
      "email": "carlos@ikuna.com",
      "role": "Logística"
    }
  ],
  "tasks": [
    {
      "title": "Contratación de sonido",
      "assignedTo": "Carlos Ruiz",
      "startDate": "2024-09-01",
      "endDate": "2024-09-15",
      "status": "completed"
    },
    {
      "title": "Diseño de publicidad",
      "assignedTo": "María González",
      "startDate": "2024-09-10",
      "endDate": "2024-09-20",
      "status": "in-progress"
    }
  ]
}
Actualizar Proyecto
Edita un proyecto existente (debes enviar el objeto completo). Sirve para agregar tareas nuevas o cambiar estados.

Método: PUT

Endpoint: /ikuna/projects/{id} (Ej: /api/ikuna/projects/1)

Body (JSON):

JSON
{
  "id": 1,
  "title": "Festival Cultural Ikuna 2024 - Edición Especial",
  "category": "Eventos",
  "status": "completed",
  "progress": 100,
  "date": "2024-10-20",
  "description": "Evento finalizado con éxito.",
  "imageUrl": "https://images.unsplash.com/photo-festival.jpg",
  "teamMembers": [],
  "tasks": [
     {
      "id": 1,
      "title": "Contratación de sonido",
      "assignedTo": "Carlos Ruiz",
      "startDate": "2024-09-01",
      "endDate": "2024-09-15",
      "status": "completed"
    }
  ]
}



