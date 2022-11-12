<h1 align="center">Reto 01: ¡Arregla Twitter!</h1>


Problema:
--

Twitter ha sido comprado y quieren eliminar los bots.

Te han pedido ayuda para detectar el número de usuarios en su base de datos que tienen datos corruptos.

La base de datos es muy antigua y está en un formato extraño. Los perfiles requieren tener los siguientes datos:

```
usr: nombre de usuario
eme: email
psw: contraseña
age: edad
loc: ubicación
fll: número de seguidores
```

Todo está en un fichero donde los datos de usuario son una secuencia de pares `key:value`,
que pueden estar en la misma línea o separado por líneas, y cada usuario está separado por un salto de línea.

¡Ojo porque puede estar todo desordenado!


Ejemplo de input:
--

`usr:@midudev eme:mi@gmail.com psw:123456 age:22 loc:bcn fll:82` ➡️ SÍ es válido. Tiene todos los campos

`fll:111 eme:yrfa@gmail.com usr:@codember psw:123456 age:21 loc:World` ➡️ SÍ es válido. Tiene todos los campos

`psw:11133 loc:Canary fll:333 usr:@pheralb eme:pheralb@gmail.com` ➡️ NO es válido. Le falta el campo `age`

`usr:@itziar age:19 loc:isle psw:aaa fll:222 eme:itzi@gmail.com` ➡️ SÍ es válido. Tiene todos los campos
