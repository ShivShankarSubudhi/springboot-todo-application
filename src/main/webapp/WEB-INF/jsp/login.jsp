<html>
<head>

<title>Login Page | Todo Application</title>
<style>
.text-bold{font-weight:bold;}
.pad10{padding:10px;}
.text-red{color:red;}
</style>
</head>
<body>
<h1>Login Page</h1>
<form method="POST">

    <div class="text-red">${errorMessage}</div>

    <div class="pad10">
       <div class="text-bold">Username</div>
     <input type="text" name="username" placeholder="Enter your username"></input>
    </div>
     <div class="pad10">
      <div  class="text-bold">Password</div>
         <input type="password" name="password" placeholder="Enter your password"></input>
    </div>
     <div class="pad10">
      <button  type="submit">Login</button>
    </div>
</form>


</body>


</html>