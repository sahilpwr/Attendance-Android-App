<!DOCTYPE html>
<html>
<body>


<?php

$j='1111111111111111111111111111111';
$w='2';
for ($x = 3400; $x <= 3472; $x++)
{
    $array[$x] = $j;
}

for ($x = 3400; $x <= 3472; $x++)
{
    echo $array[$x].$w;
    echo "<br/>";
}




$con = mysql_connect("localhost","attend_mysql","mysql");
if (!$con)
  {
  die('Could not connect: ' . mysql_error());
  }
 
mysql_select_db("attend_rec", $con);
 
$sql="INSERT INTO trial
VALUES
('$j')";
 //the message name in the post and in $_POST in insert query should be same
if (!mysql_query($sql,$con))
  {
  die('Error: ' . mysql_error());
  }
echo "1 record added to the database of sahilpwr_msql";
 



?>

</body>
</html>