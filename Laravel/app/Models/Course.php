<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Course extends Model
{
    use HasFactory;

    protected $table = 'courses';

    protected $fillable = ['course_id', 'student_id', 'course_title', 'course_description'];

    public function student()
    {
        return $this->belongsTo(Student::class, 'student_id', 'student_id');
    }
}

