```mermaid
sequenceDiagram
actor U as Usuario

participant PD as Pedidos diarios
participant Pe as Pedido
participant PP as PlatoPedido
participant C as Carta de platos
participant Pl as Plato
participant I as Ingrediente
participant A as Almacén de existencias
participant IA as Ingrediente de Almacén

U->>PD: tratarPedidos() : void
PD->>PD: getIterator():Iterator~Pedido~
loop while hasNext()
  PD->>Pe: tratarPedido() : bool
  Pe->>Pe: getIterator():Iterator~Plato~
  loop while hasNext()
    Pe->>PP: tratarPedido() : bool
    PP->>C: buscarPlato(String código, Integer numPlatos) : bool
    C->>C: getIterator():Iterator~Plato~
    loop while hasNext() && !encontrado
      C->>Pl: compararCódigos(String código) : bool
      Pl-->>C: bool
      opt true
        C->>Pl: eliminarIngredientes(Integer numPlatos) : bool
        Pl->>Pl: getIterator():Iterator~Ingrediente~
        loop while hasNext()
          Pl->>I: eliminarIngrediente(Integer numPlatos) : bool
          I->>A: eliminarIngrediente(Integer numPlatos, String nombreI, Integer cantidad)
          A->>A: getIterator():Iterator~Ingredientes~
          loop while hasNext() && !encontrado
            A->>IA: eliminarIngrediente(String nombreI, Integer cantidad, Integer numPlatos) : bool
            IA->>IA: compararNombres(String nombreI) : bool
            opt true
              IA->>IA: eliminarIngrediente(Integer cantidad, Integer numPlatos)
              IA-->>A: bool
            end
          A-->>I: bool
          end
        I-->>Pl: bool
        end
      Pl-->>C: bool
      end
    end
    C-->>PP: bool
    PP-->>Pe: bool
  end
  Pe-->>PD: bool
  opt = true
  PD->>PD: eliminarPedido() : void
  end
end
```
