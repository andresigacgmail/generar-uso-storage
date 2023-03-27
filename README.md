# Consultar uso de disco 


<h1 align="center">
  <p align="center">Consultar Uso</p>
  <img src="https://raw.githubusercontent.com/andresigacgmail/generar-uso-storage/main/src/main/resources/static/img/generar%20uso.gif" alt="encriptador texto">
</h1>

> **Se propuso crear un web service que describiera el estado del disco duro del servidor (disponible, total, uso) .**


>
## Requisitos:
	- El web service debe:
- Consultar el estado del disco duro diariamente.
- Persister los datos en PostgreSql
- Acceder a la api por medio del protocolo http.


```Por ejemplo:
"http://10.23.13.5:8080/stat" => "{"discos":[{"path":"C:\\","disco_total":126.0,"disco_disponible":87.0,"disco_uso":38.0},{"path":"D:\\","disco_total":31.0,"disco_disponible":28.0,"disco_uso":3.0},{"path":"F:\\","disco_total":399.0,"disco_disponible":191.0,"disco_uso":208.0}],"memoria_total":3.08,"memoria_uso":3.08,"memoria_disponible":1.12}"
```

