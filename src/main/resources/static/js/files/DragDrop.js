/**
 * 
 */
 
$(function() {
	
	$('div#loading_block').remove();
	
	//selecting all required elements
	let 	dropArea = document.querySelector(".drag-area"),
			dragText = dropArea.querySelector("label"),
			buttonRemove = dropArea.querySelector(".removebtn"),		
			input = document.querySelector("input[name='files']"),
			spanFiles = dropArea.querySelector("span[name='files-set']");
			
	let filesList = [];
	let filesListNames = "";
	let flscnt = 0;
		
	buttonRemove.onclick = ()=>{
		filesList = [];
		filesListNames =
		spanFiles.innerHTML = "";
		flscnt = 0;
		$(input).val("");
		dropArea.classList.remove("active");
	    buttonRemove.classList.remove("active");
	    dragText.innerHTML = "<strong>Escoge un archivo JSON</strong><br>o arrastralo aqui";
	    
	}
	
	input.addEventListener("change", function(){
		/// Validacion de tener al menos un registro
		if(this.files[0]){
			dropArea.classList.add("active");
			setFile(this.files);
		}
	});
	
	//If user Drag File Over DropArea
	dropArea.addEventListener("dragover", (event)=>{
	  event.preventDefault();
	  
	  dropArea.classList.add("active");
	  dragText.textContent = "Suelte aquí el archivo";
	});
	
	//If user leave dragged File from DropArea
	dropArea.addEventListener("dragleave", ()=>{		
		dropArea.classList.remove("active");
		dragText.innerHTML = "<strong>Escoge un archivo JSON</strong><br>o arrastralo aqui";
	});
	
	//If user drop File on DropArea
	dropArea.addEventListener("drop", (event)=>{
 		event.preventDefault();
 		dragText.innerHTML = "<strong>Escoge un archivo JSON</strong><br>o arrastralo aqui";
		setFile(event.dataTransfer.files);
	});
	
	function setFile(files){
		if(files){
			
			let validExtensions = ["application/json"];
			let filesNames = "";
			let message = "";
			
			$.each(files, function(i, file) {
				
				filesNames += file.name + "<br>"; 
				
				if (!validExtensions.includes(file.type)){
					message = "Solo archivos de tipo JSON"; 
				}
			});
						
			if((flscnt + files.length) > 5){
				message = "Solo permite un máximo de 5 archivos";
			}
			
		  	if(!message && message == ""){
				filesListNames += filesNames;
		  		dragText.innerHTML = "<strong>Agregar</strong>";
				buttonRemove.classList.add("active");
				spanFiles.innerHTML = filesListNames;
				filesList.push(files);
				flscnt += files.length;
			 }
			 else{
				alert(message);	
			 }
			 
		}
	 }
	 
	$("#upload-form").on('submit', (function(ev) {
		ev.preventDefault();
		
		var ajaxData = new FormData(this);
				
		if (filesList) {
		    $.each( filesList, function(i, _files) {
				if(_files.length > 1){
					$.each(_files, function(j, file){
						ajaxData.append( input.getAttribute("name"), file );												
					});					
				}
				else{
					ajaxData.append( input.getAttribute("name"), _files[0]);	
				}
		    });
		}
		
		$.ajax({
		    xhr: function() {
		        var progress = $('.progress'),
		            xhr = $.ajaxSettings.xhr();
		
		        progress.show();
		
		        xhr.upload.onprogress = function(ev) {
		            $('#replace-div').empty()
		            loading({})
		        };
		
		        return xhr;
		    },
		    url: '/file/uploadFiles',
		    type: 'POST',
		    data: ajaxData,
		    contentType: false,
		    cache: false,
		    processData: false,
		    success: function(data, status, xhr) {
				let errorsCount = Object.keys(data).length
				
				let _title = 'Guardado!';
				let _text = 'Se guardó correctamente!';
				let _icon = 'success';
				
				if(errorsCount > 0){
					var myMap = new Map();

					$.each(data, function(i, val) {
						if (val.length > 0){
							var errorsArray = []
							for (let j = 0; j < val.length; j++) {
								errorsArray.push(JSON.parse(val[j]))
							}
							myMap.set(i,errorsArray)
						}
						if (val.length === 0){
							let obj = {isValid:"true"};
							myMap.set(i,obj)
						}
					});

					const out = Object.create(null)
					myMap.forEach((value, key) => {
						if (value instanceof Map) {
							out[key] = map_to_object(value)

						}
						else {
							out[key] = value
						}
					})
/*
					$('div#loading_block').remove();
					Swal.fire({
						title: "¡Se generaron incidencias!",
						text: "Algunos archivos no se pudieron guardar.",
						icon: 'info',
						allowOutsideClick: false
					}).then((result) => {
						if (result.isConfirmed) {
							getIncidentesReport(Object.fromEntries(myMap))
						}
					})*/
					getIncidentesReport(Object.fromEntries(myMap))


					//$.get('/content/incidentesReport', Object.fromEntries(myMap));


				} else {
					$('div#loading_block').remove();
					// ...
					Swal.fire({
						title: _title,
						html: _text,
						icon: _icon,
						allowOutsideClick: false
					}).then((result) => {
						if (result.isConfirmed) {
							location.reload();
						}
					})
				}
            },
            error: function(xhr, status, error) {
                $('div#loading_block').remove();
                // ...
                
                console.log('xhr in trace: ' + xhr.trace);
                console.log('xhr:' + xhr.responseText);
                console.log('status: ' + xhr.status);
                console.log(status);
                console.log(error);
                
                
                //Swal.fire('Not saved!', '', 'info')
                Swal.fire({
                    title: status.message,
                    text: "No se pudo guardar.",
                    icon: 'info',
                    allowOutsideClick: false
                }).then((result) => {
                    if (result.isConfirmed) {
                        location.reload();
                    }
                })
            }
		});
	}));
	 
});
