<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6">
            <h2>Code Save</h2>
            <form action="/codeSave" method="post">
                <div class="mb-3">
                    <input name="plainText" placeholder="Plain Text" class="form-control" />
                </div>
                <div class="mb-3">
                    <input name="useKey" placeholder="Key" class="form-control" />
                </div>
                <button class="btn btn-success">Save</button>
            </form>
        </div>
        <div class="col-sm-6">
            <h2>Code List</h2>
        </div>
    </div>
</div>
</body>
</html>