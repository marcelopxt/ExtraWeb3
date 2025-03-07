@extends('layout.base')
@section('title', 'Cadastrar Alunos')
@section('content')
    <div class=" p-4 card col-sm-8 mx-auto" data-bs-theme="dark">
        <div data-bs-theme="dark"> 

            <form action='/alunos/store' method="post" data-bs-theme='dark'>
                @csrf
                <div class="mb-3">
                    <label for="nome" class="col-4 col-form-label ">Nome</label>
                        <input type="text" class="form-control" name="nome" id="nome" placeholder="Nome" />
                </div>

                <div class="mb-3">
                    <label for="email" class="col-4 col-form-label ">Email</label>
                        <input type="text" class="form-control" name="email" id="email" placeholder="email" />
                </div>

                <div class="mb-3">
                    <label for="matricula" class="col-4 col-form-label ">Matricula</label>
                        <input type="number" class="form-control" name="matricula" id="matricula"/>
                </div>
                <div class="mb-3 row">
                    <div class="offset-sm-4 col-sm-8">
                        <button type="submit" class="btn btn-primary">
                            Cadastrar Aluno
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
@endsection
