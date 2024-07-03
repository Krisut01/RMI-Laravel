<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Student extends Model
{
    use HasFactory;

    protected $fillable = ['student_id', 'name', 'age', 'address', 'contact_number'];

    public function courses()
    {
        return $this->hasMany(Course::class, 'student_id', 'student_id');
    }
}