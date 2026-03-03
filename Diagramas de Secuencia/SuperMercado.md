"""mermaid
sequenceDiagram

actor U as User

participant F as Front
participant B as Back End
participant DB as Base de Datos

U ->> F : Envio de datos
F ->> B : Validación de datos
B ->> DB : Verifique la existencia
"""
