
# Trabajo práctico Orientación a objetos II

· Lopez Facundo,

· Midolo Sebastian,

· Leone Luciano



## API Reference

#### Obtener todos los usuarios

```http
  GET /usuario
```

| parametro | Tipo     | Descripcion                |
| :-------- | :------- | :------------------------- |
| `Authorization` | `tokenJWT` | **Requerido**. ROL ADMIN/AUDITORIA |

#### Obtener usuario por id

```http
  GET /usuario/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Authorization` | `tokenJWT` | **Requerido**. ROL ADMIN/AUDITORIA |
| `id`      | `int` | **Requerido**. ROL ADMIN/AUDITORIA |


#### Agregar usuario
```http
  POST /usuario
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Usuario`      | `Usuario` | Entidad usuario |


#### Agregar admin
```http
  POST /usuario/admin
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Authorization` | `tokenJWT` | **Requerido**. ROL ADMIN |
| `Usuario`      | `Usuario` | Entidad admin **REQUIERE SER ADMIN** |

#### Agregar auditoria
```http
  POST /usuario/auditoria
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Authorization` | `tokenJWT` | **Requerido**. ROL ADMIN |
| `Usuario`      | `Usuario` | Entidad auditoria |


#### Modificar usuario
```http
  PUT /usuario/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Authorization` | `tokenJWT` | **Requerido**. ROL ADMIN |
| `Usuario`      | `Usuario` | Entidad usuario |
| `id`      | `int` | numero entero perteneciente al id |

#### Eliminar un usuario
```http
  DELETE /usuario/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Authorization` | `tokenJWT` | **Requerido**. ROL ADMIN/AUDITORIA |
| `id`      | `int` | numero entero perteneciente al id |



