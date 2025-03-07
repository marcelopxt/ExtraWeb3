<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Aluno;
use App\Http\Resources\AlunoResource;
use App\Http\Requests\StoreAlunoRequest;

class AlunoController extends Controller
{
    public function index(){
        return AlunoResource::collection(Aluno::all());
    }
    public function store(StoreAlunoRequest $request){
        $aluno = Aluno::create($request->validated());
        return AlunoResource::make($aluno);
    }
    public function new(){
        return view('alunos.new');
    }
    public function edit($id){
        $aluno = $this->show($id);
        return view('alunos.edit', compact('aluno'));
    }
    public function update(StoreAlunoRequest $request, $id){
        $aluno = Aluno::find($id);
        if($aluno){
            $aluno->update($request->validated());
            return AlunoResource::make($aluno);
        }
        return response()->json(['message'=>'Aluno nao encontrado'], 404);
    }
    public function destroy($id){
        $aluno = Aluno::find($id);
        if($aluno){
            $nome = $aluno->nome;
            $aluno->delete();
            return response()->json(['message'=>'aluno: ' . $nome . ' , foi excluido'], 200);
        }
        return response()->json(null, 204);
    }
    public function show($id){
        $aluno = Aluno::find($id);
        if($aluno)
            return AlunoResource::make($aluno);
        else
            return response()->json(null, 404);
    }
}
