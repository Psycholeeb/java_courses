<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
<p>FORM</p>
<input id="name"/>
<p/>
<input id="bSeats"/>
<p/>
<input id="eSeats"/>
<p/>
<button id="save">SAVE</button>
<script type="text/javascript">
  $("#save").click(function(){
    var nameValue = $("#name").val();
    var bSeatsValue = $("#bSeats").val();
    var eSeatsValue = $("#eSeats").val();

    var map = {
        "name": nameValue,
        "businessSeats": bSeatsValue,
        "economSeats": eSeatsValue
        };
    console.log(map);
    var json = JSON.stringify(map);
    console.log(json);

    $.ajax({
        type: "POST",
        headers: {
        'Content-Type':'application/json'
        },
        url: "http://localhost:8080/finalProject/planes",
        data: json,
        success: function(data) {
          console.log("URRRA!");
          console.log(data);
        },
        dataType: "json"
        });
  });

</script>
</body>
</html>