<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Information</title>
    <style>
        body {
            background-image: url('/images/haha.jpg'); /* Correct syntax */
            background-size: cover; /* This makes the image cover the whole page */
            background-repeat: no-repeat; /* This prevents the image from repeating */
            background-position: center center;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            justify-content: center; /* Center horizontally */
            align-items: center; /* Center vertically */
            height: 100vh; 
         
            
        }

        h1 {
            text-align: center;
            margin-top: 20px;
            font-size: 2.5em;
            color: #333;
            background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent white background */
            padding: 10px 20px; /* Add padding around the text */
            border-radius: 10px; /* Rounded corners */
            
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: 40px auto;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px 15px;
            text-align: left;
            font-size: 1em;
        }

        th {
            background-color: pink;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #e9f4f5;
        }

        a {
            text-decoration: none;
            color: #007bff;
            border: 2px solid transparent;
            padding: 6px 12px;
            background-color: #fff;
            transition: all 0.3s ease;
        }

        a:hover {
            border-color: #007bff;
            background-color: #e9f4f5;
        }
    </style>
</head>
<body>
    <h1>Student Information</h1>
    <table>
        <tr>
            <th>Student ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Address</th>
            <th>Contact Number</th>
            <th>Action</th>
        </tr>
        @foreach($students as $student)
        <tr>
            <td>{{ $student->student_id }}</td>
            <td>{{ $student->name }}</td>
            <td>{{ $student->age }}</td>
            <td>{{ $student->address }}</td>
            <td>{{ $student->contact_number }}</td>
            <td><a href="/view-courses/{{$student->student_id}}">Enrolled Courses</a></td>
        </tr>
        @endforeach
    </table>
</body>
</html>
