function mostrarHora(){
    momentoActual = new Date();
    hora= momentoActual.getHours();
    minuto= momentoActual.getMinutes();
    
    horaImprimible = hora + " : " + minuto;
     //salida
    document.getElementById('mostrarHora').innerHTML = horaImprimible;
}


