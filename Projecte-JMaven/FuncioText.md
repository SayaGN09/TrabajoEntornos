# Treball d'Entorns

## 1. Funció de Test en Java

Per validar una funció senzilla, com una que suma dos números enters, utilitzarem JUnit. A continuació, es mostra el codi de la funció i el seu test.

### Codi de la Funció

```java
public class Calculadora {
    public int suma(int a, int b) {
        return a + b;
    }
}
```

### Codi del Test

```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    @Test
    void testSuma() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.suma(2, 3), "La suma de 2 i 3 ha de ser 5");
    }
}
```

### Executar el Test

Per executar el test en un projecte Maven, es pot utilitzar la següent comanda:

```sh
mvn test
```

Aquest test comprova que la funció `suma` de la classe `Calculadora` retorna el valor esperat quan es crida amb els arguments 2 i 3.

---

## 2. Generació de documentació JavaDoc

JavaDoc és una eina per generar documentació en format HTML a partir de comentaris en el codi Java.

### Exemple de comentaris JavaDoc

```java
/**
 * Classe que representa una calculadora bàsica.
 */
public class Calculadora {
    /**
     * Suma dos números enters.
     * 
     * @param a Primer número enter
     * @param b Segon número enter
     * @return La suma de a i b
     */
    public int suma(int a, int b) {
        return a + b;
    }
}
```

### Generar la documentació en HTML

Per generar la documentació en un projecte Maven, executar:

```sh
mvn javadoc:javadoc
```

Això generarà els fitxers HTML a `target/site/apidocs/`.

---

## 3. Diagrames de Classes

Els diagrames de classes representen l'estructura del codi i les relacions entre les seves classes. 

### Tipus de Relacions
- **Herència**: Quan una classe extén una altra.
- **Composició**: Una classe conté instàncies d'una altra com a part fonamental.
- **Agregació**: Una classe conté instàncies d'una altra, però no és essencial per la seva existència.
- **Dependència**: Una classe utilitza una altra temporalment.

### Exemple de Diagrama de Classes
*(Afegir imatge amb el diagrama de classes del projecte.)*

---

## 4. Entrega del Projecte

El projecte Java/Maven ha d'incloure:
- Codi Java amb diferents objectes.
- Funció de test per validar almenys un mètode.
- Documentació generada amb JavaDoc.
- Diagrames de classes.
- Aquest document en format Markdown (`.md`).

