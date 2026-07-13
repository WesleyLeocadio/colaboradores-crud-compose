package br.com.wesleyleocadio.treinamento.controleinadimplentes.model

object AlunoRepository {

    val alunos = mutableListOf(
        Aluno(
            id = 1,
            nome = "João Silva",
            telefone = "(11) 99999-9999",
            valorDevido = 120.0,
            diasAtraso = 10,
            inadimplente = true
        ),
        Aluno(
            id = 2,
            nome = "Maria Souza",
            telefone = "(11) 98888-8888",
            valorDevido = 150.0,
            diasAtraso = 15,
            inadimplente = true
        ),
        Aluno(
            id = 3,
            nome = "Carlos Lima",
            telefone = "(11) 97777-7777",
            valorDevido = 0.0,
            diasAtraso = 0,
            inadimplente = false
        ),
        Aluno(
            id = 4,
            nome = "Pedro Santos",
            telefone = "(11) 96666-6666",
            valorDevido = 200.0,
            diasAtraso = 20,
            inadimplente = true
        )
    )

    fun buscarPorId(id: Int): Aluno? {
        return alunos.find { it.id == id }
    }

    fun listarInadimplentes(): List<Aluno> {
        return alunos.filter { it.inadimplente }
    }

    fun totalAlunos(): Int {
        return alunos.size
    }

    fun totalInadimplentes(): Int {
        return alunos.count { it.inadimplente }
    }

    fun valorTotalEmAberto(): Double {
        return alunos
            .filter { it.inadimplente }
            .sumOf { it.valorDevido }
    }
}
