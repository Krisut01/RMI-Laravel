<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Courses Enrolled</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-image: url('/images/haha.jpg'); /* Correct syntax */
            background-size: cover; /* This makes the image cover the whole page */
            background-repeat: no-repeat; /* This prevents the image from repeating */
            background-position: center center; /* This centers the image */
            display: flex; /* Use flexbox for centering */
            justify-content: center; /* Center horizontally */
            align-items: center; /* Center vertically */
            height: 100vh; /* Full viewport height */
        }
        .container {
            width: 800px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: rgba(255, 255, 255, 0.8); /* Adding a background color with opacity for better readability */
            border-radius: 10px;
            text-align: center; /* Center text inside the container */
        }
        h1 {
            color: #333;
            background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent white background */
            padding: 10px 20px; /* Add padding around the text */
            border-radius: 10px; /* Rounded corners */
            display: inline-block; /* Ensure the background color only covers the text */
        }
        ul {
            list-style-type: none;
            padding: 0; /* Remove padding from the list */
        }
        li {
            margin-bottom: 10px;
            font-size: 30px;
        }
        .back-button {
            display: inline-block;
            padding: 10px 20px;
            background-color: green;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
            width: 200px;
            text-align: center;
        }
        .back-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>The Courses Enrolled by <br> {{ $student->name }}</h1>
        <ul>
            @foreach($courses as $course)
                <li>{{ $course->course_title }} - {{ $course->course_description }}</li>
            @endforeach
        </ul>
        <a href="/studentsRecord" class="back-button">Back</a>
    </div>
</body>
</html>
