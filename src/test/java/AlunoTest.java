import org.example.Aluno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AlunoTest {
    private Aluno aluno;


    @Test
    public void deveriaCriarMatriculaComApenasOnzeDigitos(){
        aluno = new Aluno(1, "Pedro", 22, "20192370019", "57598408009");

        Assertions.assertThrows(RuntimeException.class, () -> aluno.setMatricula("20192370019"));

    }

    @Test
    public void naoPermitirAlteracaoContendoCaractereEspecial(){
        aluno = new Aluno(1, "Pedro", 22, "20192370019", "57598408009");
        Assertions.assertThrows(RuntimeException.class, () -> aluno.setMatricula("2019237@@19"));

    }

}
