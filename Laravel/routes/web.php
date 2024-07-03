<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\StudentController;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/studentsRecord', [StudentController::class, 'index']);
Route::get('/view-courses/{student_id}', [StudentController::class, 'viewCourses'])->name('view.courses');