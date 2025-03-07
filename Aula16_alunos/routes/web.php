<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\AlunoController;

Route::get('/', function () {
    return view('alunos.index');
});

Route::get('/alunos', [AlunoController::class, 'index']);
Route::get('/alunos/new', [AlunoController::class, 'new']);
Route::get('/alunos/edit/{id}', [AlunoController::class, 'edit']);
Route::post('/alunos/store', [AlunoController::class, 'store']);
Route::put('/alunos/{id}', [AlunoController::class, 'update']);
Route::delete('/alunos/{id}', [AlunoController::class, 'destroy']);
