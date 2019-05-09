# Test_Felipe_Inostroza
Aplicación que permite el ingreso y despliegue paginado de documentos bajo spring framework 

La aplicacion consta de 2 funciones principales:

  1.-Listar Documentos: este modulo se ha configurado con un despligue de dos registros como maximo para mostrar la funcionalidad del paginador,
    El paginador cumple las funciones de:
      a.-Mostrar primera pagina
      b.-Mostrar Pagina Siguiente
      c.-Mostrar Pagina Anterior
      d.-Numeros de pagina de la seccion de interes.
      e.-Mostrar ultima Pagina
  2.-Modulo de Ingreso de documentos: Este modulo es un pequeño formulario que permite el ingreso de documentos que posterior a dicho ingreso,
    Apareceran en el modulo de listado, el envio de los datos es mediante POST y recepcionado por un controlador REST que toma los registros y 
    los ingresa a una BD embedida (H2) mediante el uso de JPA.
    
    
      
  
