function getContentPlantilla() {
    $('#replace-div').empty()
    $('#replace-div').load('/plantilla');

}

function getContent() {
    $('#replace-div').empty()
    $('#replace-div').load('/uploadJSON');
    loading({})
}
function getIncidentesReport(data) {
    $('#replace-div').empty()
    $('#replace-div').load('/incidentesReport', data);
    loading({})
}
function loading (opts) {
    const defaults = {
        imgPath: '/static/img/load.gif',
      
        text: 'Cargando ...',
        style: {
            position: 'fixed',
            width: '100%',
            height: '100%',
            textAlign: 'center', 
            background: 'rgba(0, 0, 0, 0)',           
            left: 0,
            top: 0,
            zIndex: 10000
        }


    };
    $.extend(defaults, opts);

   const img = $('<div style=" width:19%;"></div><div><img style=" width:120px; height:120px;" src="' + defaults.imgPath + '"><div>' + defaults.text + '</div></div>');
   const block = $('<div style=" width: 100%; display: flex;  justify-content: center; align-items: center;"  id="loading_block"></div>');

    block.css(defaults.style).appendTo('body');
    img.css(defaults).appendTo(block);
}

     function getContent() {
        $('#replace-div').empty()
        $('#replace-div').load('indexusuarios');
        loading({})
    }
