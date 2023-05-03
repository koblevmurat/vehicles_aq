function confirmClicked(e){

    var allGood = false;

    if (e.disabled){
        return;
    }

    if (!confirm('Действие необратимое. Уверены, что подтвержаете выезд ТС и смену статуса?')) {
        console.log('Status changed was canceled');
        return;
    } else {
        var $row = $(e).closest("tr");
        var docUID=$row.find("td:eq(7)").text();
        var currStat=$row.find("td:eq(9)").text();
        var nextStat = 'missed';
        if (currStat == "expectation") {
            nextStat = 'missed';
        } else if (currStat == "missed") {
            nextStat = 'left';
        }

        // var docStatus = col8.find("select").val();

        let xhr = new XMLHttpRequest();
        let url = "submit";
        xhr.open("POST", url, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        var data = JSON.stringify({ "docUID": docUID, "docStatus": nextStat });
        xhr.send(data);
        $("body").css("cursor", "progress");
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4 && xhr.status == 200){
                $("body").css("cursor", "default");
                window.location.reload();
                // if (nextStat == 'missed' ) {
                //     e.value = 'Выезд';
                //     $row.css( "background-color", "Yellow" );
                //     $row.addClass( "missed" );
                // } else if (nextStat == 'left') {
                //     e.disabled = true;
                //     e.value = 'Уехал';
                //     $row.css( "background-color", "LightGreen" );
                //     $row.addClass( "left" );
                // }
            }

        };

    }
}