function confirmClicked(e){

  var $row = $(e).closest("tr");
  var docUID=$row.find("td:eq(7)").text();
  var col8=$row.find("td:eq(8)");
  var docStatus = col8.find("select").val();
 
  let xhr = new XMLHttpRequest();
  let url = "submit";
  xhr.open("POST", url, true);
  xhr.setRequestHeader("Content-Type", "application/json");
  var data = JSON.stringify({ "docUID": docUID, "docStatus": docStatus });
//  console.log(data);
  xhr.send(data);
   if (docStatus == 'missed' ) {
        $row.css( "background-color", "red" );
        $row.addClass( "warning" );
    } else {
        $row.css( "background-color", "white" );
        $row.addClass( "ok" );
    }
}