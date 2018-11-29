## Pasos
### Compilar 

mvn clean install

### Copiar war en Tomcat
En la carpeta target, copiar el archivo .war generado.

Luego dirigirse a la carpeta webapps del tomcat y colocar el war.

Iniciar tomcat.

### Probar URLS

<<Ruta cloud>>/textile-rest/login/validaUsuario

Input:
{
	"login":"irakitic",
	"password":"123"
}

El resultado debe arrojar un JSON.
