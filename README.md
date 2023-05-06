# LABORATORIO DE SISTEMAS MOVILES Y UBICUOS 

#### *Fecha: 11/05/2023*
#### *Autores : Rubén Manzanas Rodríguez, Estela Cameo Pereira y Gonzalo García-Augustín García*

<br>

# Aplicación FruitShop

>## Introducción

El objetivo principal de esta aplicación es crear una plataforma cuya funcionalidad sea realizar compras online en diferentes secciones como frutería, carnicería, pescadería y tienda de deportes y, así, poder llegar al mayor número de clientes posible.

<br>

>## Contenido proyecto

Para el desarrollo de esta aplicación creamos un proyecto con el IDE Android Studio utilizando como lenguaje Kotlin.
Al crear un proyecto de Kotlin en Android Studio, se genera la carpeta "app" y la carpeta "gradle". Cuando creamos el proyecto, el sistema crea "app" y la aplicación lanza una "activity" (pantalla).

- La carpeta "app" contiene el software relacionado con nuestra aplicación, donde incluiremos los archivos necesarios para que nuestra aplicación sea empaquetada. Dentro de esta carpeta, podemos acceder a otras. Por ejemplo en la carpeta manifests, podemos observar el archivo AndroidManifest.xml en que se declara todo aquello que realiza nuestra aplicación, así como si requiere unos permisos... En la carpeta res, podemos encontrar otras subcarpetas, como por ejemplo, layout que contiene el archivo activity_main.xml. Si accedemos a ese archivo y en la barra de herramientas del archivo en el margen superior derecho,hacemos clic en Split, aparece una representación de nuestra aplicación. Los layouts son unos contenedores y se utilizan para dar formato al diseño de nuestra aplicación introduciendo elementos como botones, spinner, seekbar textos...

- La carpeta "gradle" contiene un paquete de herramientas de compilación avanzadas, para automatizar y administrar el proceso de compilación y, al mismo tiempo, definir configuraciones de compilación personalizadas y flexibles.

<br>

>## Desarrollo

>### Requisitos del prototipo básico

Al ejecutar la aplicación, lo primero que veremos será la pantalla principal, que nos brindará acceso a diferentes secciones de la tienda, como la frutería, carnicería, pescadería y la tienda de deportes. Al seleccionar la imagen de alguna de estas secciones, la aplicación nos llevará directamente a la pantalla correspondiente.

En la parte de navegación se ha implementado un práctico "Drawer Menu", lo que facilita la navegación en la aplicación y permite al usuario acceder rápidamente a cualquier sección disponible en el "Drawer Menu".

<br>

Al desplegar el "Drawer Menu", en primer lugar aparecerá en la parte superior el logo de la empresa. Debajo de este, se encuentran cuatro opciones de navegación que nos permiten acceder a las diferentes secciones de la aplicación. Cada opción se representa con un icono específico y su respectivo nombre:

1. El primer icono que aparece en el "Drawer Menu" es el "User". Al seleccionar esta opción, la aplicación nos llevará a un formulario en el que se puede iniciar sesión en la cuenta de usuario. Este formulario consta de dos campos: "User" y "Password". Si el usuario ya tiene una cuenta, puede ingresar su información en los campos correspondientes y luego hacer clic en el botón "Sign In" para acceder a la cuenta.
También se puede crear una cuenta de usuario haciendo clic en el botón "Sign Up" y completando los campos necesarios en el formulario. En ambos casos, si los campos de usuario y contraseña no se han completado correctamente, no se podrá iniciar sesión ni registrarse. Una vez que se ha iniciado sesión o registrado una cuenta nueva, la aplicación nos llevará a la misma pantalla del "User" donde se le dará la bienvenida junto con su nombre de usuario y se le brindará la opción de cerrar sesión gracias a un botón. Si el usuario decide cerrar sesión, volverá a la pantalla de inicio de sesión con los formularios de registro disponibles.


2. El segundo icono que aparece en el "Drawer Menu" es el "Chat". Al seleccionar esta opción, la aplicación nos llevará a una pantalla de chat simulado donde el usuario puede interactuar con la tienda. El usuario puede escribir mensajes en el campo de entrada y enviarlos presionando el botón "Enviar". Los mensajes aparecerán en la ventana de chat, debajo del último mensaje enviado.
Si el usuario sale de la pantalla del "Chat" y vuelve a ingresar, los mensajes que haya escrito anteriormente se habrán guardado y aparecerán en el chat. Esta función permite al usuario continuar con la conversación desde donde la dejó anteriormente.  


3. El tercer icono que aparece en el "Drawer Menu" es el "Inbox". Al seleccionar esta opción, la aplicación nos llevará al inbox de la tienda, donde el usuario puede ver todos los mensajes enviados.
Si el usuario ha enviado algún mensaje, se proporcionará un botón que permite al usuario borrar todos los mensajes enviados.


4. El cuarto icono que aparece en el "Drawer Menu" es el "Total Basket". Al seleccionar esta opción, la aplicación llevará al usuario a la pantalla que muestra la lista de todos los productos que han sido seleccionados en la frutería, carnicería, pescadería y tienda de deportes, junto con la cantidad de cada item que se ha seleccionado.
En la parte inferior de la cesta, aparecerá el precio total de la compra. Esta función permite al usuario tener una vista general de todo lo que ha seleccionado y asegurarse de que no haya errores.
Se proporcionarán dos botones, uno para vaciar la cesta y otro para finalizar la compra. El botón "Vaciar cesta" permite al usuario eliminar todos los productos que ha seleccionado. El botón "Comprar cesta" permite al usuario "finalizar la compra".


<br>

Si accedemos a la sección de frutería desde la pantalla principal, seremos llevados a una nueva pantalla que muestra, un spinner con el que podemos seleccionar la fruta deseada, una cesta vacía y un icono que nos llevará a la pantalla de "Total Basket".
Al desplegar el spinner, se mostrarán las frutas disponibles con sus respectivas imágenes. Al seleccionar una fruta, aparecerá un "SeekBar" que nos permitirá seleccionar la cantidad que deseamos de la fruta elegida. Una vez seleccionada la cantidad, se mostrará el precio por unidad y el precio de la fruta asociado a la cantidad elegida. Si pulsamos el botón "Add", la fruta será añadida a la cesta. La cesta se actualizará y mostrará la foto del producto y la cantidad seleccionada. Además, se actualizará el precio de la cesta de frutas y el precio total de la compra.
La aplicación proporcionará la opción de vaciar la cesta de frutas solo si hay elementos en ella.
Si seleccionamos "Select the fruit" en el spinner (el elemento neutro), los elementos para añadir una fruta como el SeekBar, botón "Add"... desaparecerán de la vista del usuario.
Si seleccionamos el icono "Total Basket", seremos llevados a la cesta total donde aparecerán todos los elementos de cualquier sección que hayamos seleccionado para comprar, junto con el precio total de toda la compra.

<br>

La pescadería, la carnicería y la tienda de deportes, tienen la misma funcionalidad que la frutería pero personalizada para cada sección, ofreciendo los productos correspondientes a cada una de ellas y respetando los precios de la cesta de cada sección.

<br>

La aplicación garantiza la persistencia de la información en todo momento. Lo que significa que los productos seleccionados, las cantidades elegidas, los precios y otros datos relevantes se mantienen guardados incluso en caso de que se produzcan cambios de configuración en el dispositivo móvil. De esta manera, el usuario puede continuar desde donde dejó su actividad en la aplicación sin perder información importante.

<br>

Cuando accedamos a cualquiera de las secciones de la aplicación, se mostrará automáticamente un botón de "Atrás" en lugar del "Drawer Menu". Esto nos permitirá regresar fácilmente a la pantalla anterior.

******************************************EXPLICAR LO NUEVO********************************************************

<br>

>### Requisitos extras

Los extras que se han incluido en la aplicación son:

* Definición de un nombre para la aplicación "Fresh".
* Se ha limitado la prueba de concepto a cuatro productos de cada tipo.
* Soporte multilenguaje Inglés/Español según la configuración del teléfono.
* Persistencia de la información entre cambios de orientación.
* Las pantallas horizontal y vertical tendrán un layout diferente acorde con el espacio proporcionado. En algunos casos hemos utilizado un ScrollView.
* Fotografía del producto en las opciones del Spinner.
* Fotografía del producto en los productos añadidos a la cesta.
* Evitar tener que pulsar el botón para seleccionar una producto en el Spinner
* Se muestra el precio/pieza del producto seleccionado.
* Dos opciones de acceso para el usuario: iniciar sesión o registrarse.
* Guardar el nombre del usuario que inició la sesión.
* Posibilidad de cerrar la sesion si el usuario inició la sesión anteriormente.
* "Flecha Hacia Atrás" que permite volver a la pantalla anterior.
* En el drawer menu se encuentra un botón para acceder a User, Chat, Inbox y Total Basket.
* Cambio automatico del "Drawer Menu" por una "Flecha Hacia Atrás" para poder acceder a la anterior pantalla.
* En la barra de título superior de la aplicación aparece el nombre de la pantalla en la que nos situamos.
* Posibilidad de vaciar la cesta de una sección.
* Posibilidad de vaciar la cesta total.
* Posibilidad de vaciar cada tipo de producto en la cesta total.
* Posibilidad de comprar los productos que hay en la cesta total.
* No permitir que el usuario inicie sesion o cree una cuenta si todos los campos no estan rellenos.
* Boton dentro del Inbox que permite borrar los mensajes escritos por el usuario.
* Logica de negicio del User.
* Logica de negocio del Chat.
* Logica de negocio del Inbox.
* Todos los recursos se han definido en el directorio res siguiendo un modelo de buenas prácticas.
****************************LOGIN EXPLICAR RUBÉN************************************************************************

* Mejora que haga la pantalla más atractiva desde el punto de vista funcional como:
    * Logo de la empresa
    * Cambio de color de los elementos en función del fragment.
    * Delimitación de la cesta entre barras.
    * Integracion de iconos en las respectivas secciones.
    * Letras de distinto tamaño y colores.
    * Botones de diferentes colores en función de su utilidad. 
    * Cambio de color del SeekBar. 
    * Cambio de nombre del Navigation en función del fragment. 
Para ello, se han utilizado: padding, gravity, layout_gravity, layout_height, layout_weight, layout_margin (Top, Bottom, Start, End), textColor, progressTint, textSize, backgroundTint, textStyle...









**********************************************************************************************************************************************************************************************************************************************
Cuando se ejecute nuestra aplicación observaremos distintos elementos: el título de nuestra app "Room"; dos "EditText" para introducir el nombre y apellido del cliente; un botón para poder guardar los datos del cliente y listar dicha información debajo de los "EditText"; un "TextView" como título "Nombre y apellidos:" para indicar la región en la que aparecerán los datos guardados de los distintos clientes; y otro "TextView" para mostrar dichos datos de cada cliente. Además, observamos otro botón para poder eliminar la base de datos completa. De forma que. podemos ver que, al hacer click en dicho botón, se vacía: 

- El TextView en el que se guardan los datos de los distintos clientes tras hacer click en el botón de "Añadir".
- La tabla de datos de "App Inspection".

Nota: hay que tener especial cuidado al hacer click en el botón de "Eliminar datos" ya que, sin darnos cuenta, podemos eliminar datos que no deseamos eliminar y ya no podemos recuperarlos.

Si giramos la orientación del dispositivo, podemos observar que se persistirá esta información y esto, lo realizamos utilizando View Model.

Además, para actualizar el campo de texto donde iremos listando el nombre y apellido de los clientes se utiliza Live Data.

Por último, para almacenar los datos de los distintos clientes en una base de datos utilizaremos Room.
**********************************************************************************************************************************************************************************************************************************************




*******************************************USUARIOS SE ALMACENAN EN BASE DE DATOS***************************
******************************************VACIAR BASE DE DATOS**********************************************
******************************************EXPLICAR LO NUEVO********************************************************

    


>## Explicación de conceptos

Para la realizacion de la practica ha sido necesario introducir nuevas librerias y nuevos conceptos.

- ViewModel: El ViewModel es responsable de mantener y administrar los datos relacionados con la interfaz de usuario, se ocupa de la supervivencia a los cambios de configuración

- LiveData es una clase que se utiliza para almacenar y observar datos. Los objetos LiveData son observados desde el ViewModel y actualizados automáticamente cuando cambian los datos.

- Romm *********************************ROOM***************************
- Recycler View *********************************Recycler View***************************

>## Directorios relevantes

1. ViewModel y LiveData:

    Para implementar el ViewModel y el LiveData es necesario crear una nueva clase que permita separar la lógica de la interfaz de usuario de la actividad o el fragmento de la logica de negocio.
    
    En esta práctica, se ha implementado una clase ViewModel para cada fragmento, a excepción de aquellos fragmentos que compartían datos, los cuales han usado la misma clase ViewModel.
    Estos fragmentos se encuentran en el directorio java.

2.  Room y Recycler View: *****************************************************LO NUEVO*********************************

    Para implementar el ViewModel y el LiveData es necesario crear una nueva clase que permita separar la lógica de la interfaz de usuario de la actividad o el fragmento de la logica de negocio.

    En esta práctica, se ha implementado una clase ViewModel para cada fragmento, a excepción de aquellos fragmentos que compartían datos, los cuales han usado la misma clase ViewModel.
    Estos fragmentos se encuentran en el directorio java.

3. Navegacion:

    Para la realización de la navegacion, es necesario crearnos una nueva carpeta que sea de tipo "Navigation", definir un grafo de navegación xml (en nuestro caso se llama "navigation.xml") que será el encargado de realizar la navegación.

4. Imágenes:

    Todas las imagenes de los distintos tipos de productos disponibles en la tienda que se usan en la aplicación están en el directorio drawable, que se encuentra dentro del directorio res.

5. Layouts:

    En los layouts se han definido los distintos elementos para perfeccionar la vista de nuestra aplicacion teniendo en cuenta las distintas secciones cuando presenta orientación vertical y, los layouts (land) en los que se han definido los distintos elementos para perfeccionar la vista de nuestra aplicacion cuando presenta orientación horizontal. Además, se ha creado el fichero itemspinner.xml que contiene las vistas del texto e imagen del producto seleccionado en el spinner de cada sección de la tienda y el fichero nav_header.xml que contiene los elementos para dar vista a la pestaña de menú de nuestra aplicación. Estos ficheros se encuentran en el directorio layout que se encuentra dentro del directorio res.

6. Values:

    El fichero strings.xml contiene los textos con nombre único que se utilizan para acceder a ellos desde el código de la aplicación y, también encontramos el fichero strings.xml (con miniatura bandera de españa) que contiene los textos definidos en strings.xml pero traducidos al español. Esto es útil si un usuario desea cambiar el idioma del inglés al español. Estos ficheros se encuentran en el directorio strings que se encuentra dentro del directorio values, y a su vez, se encuentra dentro del directorio res.
    **********************AÑADIR LO DE LOS OTROS IDIOMAS******************************



>## Imágenes
<br>


Fotos de la aplicación al ejecutarse:
<br>


* ## Orientación vertical: 


    * ![menu](images/horizontal/menu.png)
    * ![drawerMenu](images/horizontal/drawerMenu.png)
    * ![user](images/horizontal/user.png)
    * ![userLogout](images/horizontal/user_logout.png)
    * ![chat](images/horizontal/chat.png)
    * ![inbox](images/horizontal/inbox.png)
    * ![fishShop](images/horizontal/fish1.png)
    * ![fishShop1](images/horizontal/fish2.png)
    * ![fishShop2](images/horizontal/fish3.png)
    * ![fruitShop1](images/horizontal/fruit.png)
    * ![butcherShop](images/horizontal/meat.png)
    * ![sportShop](images/horizontal/sport.png)
    * ![basketTotal](images/horizontal/basketTotal.png)
    *******************IMÁGENES DE LO NUEVO**************************************

<br>

<br>

* ## Orientación horizontal:

    * ![menu](images/vertical/menuLand.png)
    * ![drawerMenu](images/vertical/drawerMenuLand.png)
    * ![drawerMenu1](images/vertical/drawerMenuLand1.png)
    * ![user](images/vertical/userLand.png)
    * ![userLogout](images/vertical/user_logoutLand.png)
    * ![chat](images/vertical/chatLand.png)
    * ![inbox](images/vertical/inboxLand.png)
    * ![fruitShop1](images/vertical/fruitLand.png)
    * ![fruitShop2](images/vertical/fruitLand2.png)
    * ![fruitShop3](images/vertical/fruitLand3.png)
    * ![fishShop](images/vertical/fishLand.png)
    * ![butcherShop](images/vertical/meatLand.png)
    * ![sportShop](images/vertical/sportLand.png)
    * ![basketTotal](images/vertical/basketLand.png)
        *******************IMÁGENES DE LO NUEVO**************************************



<br>

<br>

* ## Aplicación en español: 
* A continuación se muestran dos imágenes en las que se ha cambiado el idioma del dispositivo al español.

   * ![menuEspañolVetical](images/españolVertical.png)
   * ![menuEspañolHorizontal](images/españolHorizontal.png)


>## Pre-requisitos

-Android Studio.

-JDK (Java Development Kit).

-Un dispositivo Android.
<br>

>## Procedimiento

Abrimos la aplicación Android Studio y creamos un nuevo proyecto. Para ello, en la barra de herramientas del margen superior izquierdo, hacemos clic en File, New, New Project. Se muestra una ventana para crear el nuevo proyecto, seleccionamos Empty Activity, asignamos el nombre "FruitStore" a nuestra aplicación, elegimos la ruta donde se va a guardar el proyecto, utilizamos lenguaje Kotlin, y hacemos clic en Finish. Ya hemos generado nuestro proyecto.

Después, creamos el dispositivo. Si nuestro dispositivo es un Smarthphone, en la barra de herramientas del margen superior derecho, hacemos clic en Device Manager, en la pestaña de Virtual, clicamos en Create device. Se muestra una ventana para seleccionar el hardware, seleccionamos: Pixel 6 como definición del dispositivo, Oreo (API Level 27) como imagen del sistema (tiene que ser descargada), Portrait como orientación de inicio y clicamos en Finish. Ya tenemos nuestro dispositivo creado. Si nuestro dispositivo es una tablet y queremos ejecutar nuestra aplicación en una tablet física, configuramos dicha tablet en modo desarrollador, en las opciones de este modo, seleccionamos las opciones: Depuración de USB y verificar aplicaciones por USB. 
<br>

>## Ejecución del proyecto

Si nuestro dispositivo es un Smarthphone, en la herramienta de Device Manager, en la pestaña de Virtual clicamos el botón de play del dispositivo creado. Podemos observar que en la heramienta Emulator, aparece el dispositivo creado para poder probar sus funcionalidades. Después, ejecutamos la aplicación, clicando el botón de Run 'app'. Si nuestro dispositivo es una tablet, conectamos la tablet al ordenador en el que hemos desarrollado nuestra aplicación y en el IDE Android Studio, en la barra de herramientas del margen superior derecho, hacemos clic en Device Manager, en la pestaña de Physical, podemos observar nuestro dispositivo conectado, lo seleccionamos y ejecutamos la aplicación, clicando el botón de Run 'app'.

   
