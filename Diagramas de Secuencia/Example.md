```mermaid
sequenceDiagram
    autonumber
    actor U as Usuario
    participant FE as Front End
    participant BE as Back End
    participant DB as Base de datos

    U->>FE: Enviar formulario
    FE->>BE: POST /validar(datos)
    activate BE
    BE->>DB: Buscar usuario / comprobar datos
    activate DB
    DB-->>BE: Resultado
    deactivate DB

    alt Datos inválidos
        BE-->>FE: 400 Bad Request (errores)
        FE-->>U: Mostrar errores
    else Datos válidos
        alt Requiere verificación extra
            BE->>DB: Verificar reglas adicionales
            DB-->>BE: OK
        else
            DB-->>BE: FAIL
        end

        loop Reintentos (máx. 3)
            BE->>DB: Intentar operación
            DB-->>BE: OK / ERROR
        end

        BE-->>FE: 200 OK
        FE-->>U: Continuar
    end
    deactivate BE
```
```mermaid
classDiagram
    class SuperMarket {
      <<Singleton>>
      -mySM : SuperMarket
      -registers : Collection~CashRegister~
      +SuperMarket()
      +getSuperMarket() SuperMarket
      +getIterator() Iterator~CashRegister~
      +update() void
    }

    class CashRegister {
      -id : Str
      -sales : Collection~Sale~
      +CashRegister(...)
      +getIterator() Iterator~Sale~
      +update() void
    }

    class Sale {
      -artCode : Str
      -number : int
      +Sale(...)
      +update() void
    }

    %% Relaciones
    SuperMarket ..> CashRegister : <<uses>>
    CashRegister ..> Sale : <<uses>>
```
