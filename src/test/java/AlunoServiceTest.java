import org.example.Aluno;
import org.example.AlunoDAO;
import org.example.AlunoExistenteException;
import org.example.AlunoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {

    @InjectMocks
    private AlunoService alunoService;
    @Mock
    private AlunoDAO alunoDAO;

    @Test
    public void naoDeveriaInserirAlunoJaExistente(){
        Aluno aluno = new Aluno(1, "Pedro", 22, "20192370019", "57598408009");
        Mockito.doReturn(true).when(alunoDAO).existeMatriculaAtiva("20192370019");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno));
    }

    @Test
    public void naoDeveriaInserirAlunoComCPFJaExistente(){
        Aluno aluno = new Aluno(1, "Pedro", 22, "20192370019", "57598408009");
        Mockito.doReturn(true).when(alunoDAO).existeAlunoComCPF("57598408009");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno));

    }

    @Test
    void naoDeveriaInserirAlunoMenorDeIdade(){
        Aluno aluno = new Aluno(1, "Pedro", 14, "20192370019", "57598408009");
        Mockito.doReturn(true).when(alunoDAO).alunoMenorDeIdade(14);
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno));

    }
}
