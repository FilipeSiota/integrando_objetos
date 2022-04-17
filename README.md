- **Título do Projeto:** Sistema Acadêmico SIA

- **Versão:** 1.0

- **Autor:** Filipe Mallmann Siota

- **Descrição:**

Evoluindo o super sistema acadêmico SIA (não a cantora)

Agora é necessário controlarmos os cursos e as turmas e os professores. Cabe a você determinar quais dados serão necessários para cada uma das classe que você definir.

Pense com calma, não existe apenas uma solução mas é importante ver quem deve ter as responsabilidades e quem conhece quem. Explore os objetos, atribua valores. Não será necessário ter leitura de dados nesse sistema, apenas a listagem de listas que deverá imprimir na tela.

> Curso

	Atributos:
	- Nome
	- Coordenador
	- Professores
	- Disciplinas
	- Egressos
	- Alunos

	Funções:
	- Listar alunos (matriculados, egressos e cancelados)
	- Listar turmas
	- Listar professores
	- Matricular aluno
	- Mover aluno para egresso (concluir o curso do aluno)
	- Excluir aluno (transferência ou cancelamento)

> Turmas (para simplificar pense em um curso superior - cada turma é para uma disciplina)

	Atributos:
	- Alunos
	- Professor
	- Disciplina
	
	Funções:
	- Matricular
	- Mostrar alunos e notas.

> Aluno

	Atributos:
	- Nome
	- Data de nascimento (dia - mês, ano - O Java tem uma classe para manipulação de datas mas nesse exercício não utilize, crie a sua)
	- Notas
	
	Funções:
	- Calcular média (aritmética)
	- Calcular idade