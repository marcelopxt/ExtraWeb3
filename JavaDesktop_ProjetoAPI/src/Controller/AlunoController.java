package Controller;
import Model.Aluno;
import Service.API;
import java.util.ArrayList;

public class AlunoController {
    public API api = new API();

    public ArrayList<Aluno> index() {
        try {
            return api.index();
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public boolean store(Aluno aluno) {
        try {
            Aluno alunoCriado = api.store(aluno);
            return alunoCriado != null;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    public boolean update(Aluno aluno) {
        try {
            Aluno alunoEditado = api.update(aluno);
            return alunoEditado != null;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    public boolean destroy(int id) {
        try {
            return api.destroy(id);
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
}
