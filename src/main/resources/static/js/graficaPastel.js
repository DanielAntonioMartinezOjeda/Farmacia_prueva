$(function() {
   
   
   var label=[];
   var valor=[];
   let total=0;
   
   
    $('#valuesGraficas input').each(function(){ //recorrido de arreglo para obtener total de reportes	 	
	 	total +=parseInt(this.value);  
    });
    
    $('#valuesGraficas input').each(function(){	//se recorre el arreglo 	 
	    var num = parseInt(this.value);// se obtiene el num de reporte convertido a entero
	    var resul= (num*100)/total; //se convierte en porcentaje el num de reporte
	    
	    if(num != 0){ //si el porcentaje es diferente a cero entra en esta condicion
		if(resul%1==0){//se valida que el porcentaje sea entero
		valor.push(resul);	
		}else{// si el porcentaje contine decimal 
		valor.push(resul.toFixed(2));	//solo se toman dos decimales y se agrega al arreglo valor
		}			
	    }else{//si el porcentaje es cero ,se manda un valor vacio al arreglo valor
		valor.push();
	    }
	    
	 		
	     });

  
const pieData = {
    labels:label,
    datasets: [{
      data: valor,
      backgroundColor: [
        "rgb(73, 255, 51)",
        "rgb(51, 119, 255)",
      ],
      borderColor:'rgb(3, 9, 21)',
      hoverOffset: 4,
    }],
  };
  
  var pieCtx = myPieGraph.getContext('2d');
      
  var myPieChart = new Chart(pieCtx, {
    /* IMPORTANTE: cargamos el complemento */
    plugins: [ChartDataLabels],
    type: 'pie',
    data: pieData,
    options: {
	responsive:true,
	maintainAspectRatio:false,
      plugins: {
        datalabels: {
          /* anchor puede ser "start", "center" o "end" */
          anchor: "center",
          /* Podemos modificar el texto a mostrar */
          formatter: (dato) => dato + "%",
          /* Color del texto */
          color: "black",
          /* Formato de la fuente */
          font: {
            family: '"Times New Roman", Times, serif',
            size: "15",
            weight: "bold",
          },
          /* Formato de la caja contenedora */
          //padding: "4",
          //borderWidth: 2,
          //borderColor: "darkblue",
          //borderRadius: 8,
          //backgroundColor: "lightblue"
        }
      }
    }
  });


});