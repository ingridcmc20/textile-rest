## Pasos
### Compilar 

mvn -Dhttps.protocols=TLSv1.2 install

mvn clean install

### Copiar war en Tomcat
En la carpeta target, copiar el archivo .war generado.

Luego dirigirse a la carpeta webapps del tomcat y colocar el war.

Iniciar tomcat.

### Probar URLS

#### Lista Ordenes de trabajo por usuario

http://localhost:8080/textile-rest/services/ot/listaOTXUsuario

{
	"id_perfil_sel" : "3",
	"id_usuario" : "3"
}

#### Validar usuario

http://localhost:8080/textile-rest/services/login/validaUsuario

{
	"login" : "jalvarado",
	"password" : "123"
}

#### Terminar orden de trabajo

http://localhost:8080/textile-rest/services/ot/terminarOT

{
	"id_ordentrabajo" : "1",
	"id_etapa" : "1"
}

#### Listar pedidos por cliente

http://localhost:8080/textile-rest/services/pedido/listaPedidoXCliente

{
	"id_empresa" : "1"
}