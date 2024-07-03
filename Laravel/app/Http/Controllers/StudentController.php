<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Student;
use App\Models\Course;

class StudentController extends Controller
{
    public function index()
    {
        $students = Student::all();
        $courses = Course::all();
        return view('client.index', compact('students', 'courses'));
    }

    public function viewCourses($student_id) {
        $student = Student::where('student_id', $student_id)->firstOrFail(); // Find the student by student_id
    $courses = Course::where('student_id', $student_id)->get();
        
        return view('client.view', compact('student', 'courses'));
    }
}

