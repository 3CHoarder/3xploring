var cols= ["Type of Event", "Event Time"];

function buildTableHeader(table) {
    var row = table.insertRow(-1);
    for (var i = 0; i < cols.length; i++)  {
      var headerCell = document.createElement("TH");
      headerCell.innerHTML = cols[i];
      row.appendChild(headerCell);
    }
}

// Builds the HTML Table out of web service return.
function buildHtmlTable(login, table) {
	$.ajax ({
		url :'http://localhost:8080/ghevents',
		data: {  user : login.value },
		type:'GET',
		datatype: 'json',
		success:function(data) {
		   $('table tr').remove();
		   buildTableHeader(table);
		   for (var i=0;i < data.length;i++) {
		   tr = $('<tr />');
		   tr.append("<td>" + data[i].type +"</td>");
		   tr.append("<td>" + data[i].created_at + "</td>");
		   $("table").append(tr);
	   }
	}});
}

var cols= ["Type of Event", "Event Time"];
function doFunction () {
    var user = document.getElementById("user");
    document.getElementById("show_user").innerHTML = user.value + " Events";
    var table = document.getElementById('excelDataTable') ;
    buildHtmlTable(user, table);
}


/*
$(document).ready(function() {
    $.ajax({
        url: "http://rest-service.guides.spring.io/greeting"
    }).then(function(data) {
       $('.greeting-id').append(data.id);
       $('.greeting-content').append(data.content);
    });
});

$.ajax ({
    url :'www.google.com',
    type:'GET',
    datatype: 'json',
    success:function(data) {
       var tr
       for (var i=0;i < data.length;i++) {
       tr = $('<tr />')
       tr.append("<td>" + data.name +"</td>");
       tr.append("<td>" + data.phone + "</td>");
       $("table").append(tr);
   }
})

$.getJSON method is smaller and use can parse the data using `$.each`

$.getJSON(url,function(json){
   $.each(json, function(item){
   $("td").append(item);
   });
});


$.ajax({
    url: "http://localhost:8088/api/DuplicateCleaner/things",
    data: {
        'things': "table"
    },
    dataType: "jsonp"
});


<script type="text/javascript">  
$(document).ready(function() {  
    $.ajax({  
        type: "POST",  
        url: "WebService1.asmx/HelloWorld",  
        data: "{'myUserName':'MyUserNameIsRaj'}",  
        contentType: "application/json",  
        datatype: "json",  
        success: function(responseFromServer) {  
            alert(responseFromServer.d)  
        }  
    });  
});  
</script>
*/
